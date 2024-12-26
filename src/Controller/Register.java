package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO;
import com.test.Beans.User;
/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	 private userDAO userDAO; // Déclarez une variable d'instance de UserDAO

	    public Register() {
	        super();
	        userDAO = new userDAO(); // Initialisez la variable d'instance dans le constructeur
	    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String username = request.getParameter("username");
	    String email = request.getParameter("email");
	    String password = request.getParameter("password");

	    // Validation des données
	    if (username == null || email == null || password == null || username.isEmpty() || email.isEmpty() || password.isEmpty()) {
	        response.sendRedirect("Register.jsp?error=missing_fields");
	        return;
	    }

	    // Création de l'utilisateur
	    User user = new User();
	    user.setNom(username);
	    user.setEmail(email);
	    user.setMdp(password);

	    if (userDAO.added(user)) {
              int userId = getUserIdFromDatabase(email);
             
             // Création d'une session et stockage de l'ID de l'utilisateur
             HttpSession session = request.getSession();
             session.setAttribute("userId", userId);
             response.sendRedirect(request.getContextPath() + "/Home");
	    } else {
	        response.sendRedirect("Register.jsp?error=registration_failed");
	    }
	}

	private int getUserIdFromDatabase(String email) {
        // Recherche de l'utilisateur dans la base de données par son adresse e-mail
        User user = userDAO.getUserByemail(email);
        if (user != null) {
            // Si l'utilisateur est trouvé, retourner son ID
            return user.getId_user();
        } else {
            // Si l'utilisateur n'est pas trouvé, retourner une valeur par défaut ou -1
            return -1; // Vous pouvez changer cela selon votre logique de gestion des erreurs
        }
    }

}
