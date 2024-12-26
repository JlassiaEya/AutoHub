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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private userDAO userDAO;

    public Login() {
        super();
        userDAO = new userDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        if (isValidCredentials(email, password)) {
        	 int userId = getUserIdFromDatabase(email);
             
        	 HttpSession session = request.getSession();
             session.setAttribute("userId", userId);
             response.sendRedirect(request.getContextPath() + "/Home");
        } else {
            response.sendRedirect("Login.jsp?error=invalid_credentials");
        }
       
    }

    private int getUserIdFromDatabase(String email) {
        User user = userDAO.getUserByemail(email);
        if (user != null) {
            return user.getId_user();
        } else {
            return -1; 
        }
    }

	private boolean isValidCredentials(String email, String password) {
        User user = userDAO.getUserByemail(email);
        if (user != null) {
            return user.getMdp().equals(password);
        }
        return false;
    }
}
