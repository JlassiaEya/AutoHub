package Controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.userDAO; // Import de la classe UserDAO
import com.test.Beans.User; // Import de la classe User

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import java.io.IOException;

@WebServlet("/Profile")
public class ProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId != null) {
            userDAO userDAO = new userDAO();
            User user = userDAO.getUserById(userId);

            request.setAttribute("user", user); 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Profile.jsp");
            dispatcher.forward(request, response);
        }else {
            // Redirection vers la page de connexion avec un message d'erreur
            response.sendRedirect("Login.jsp?error=invalid_credentials");
        }

    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        doGet(request, response);
    }
}
