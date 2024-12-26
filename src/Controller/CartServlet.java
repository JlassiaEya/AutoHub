package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.Beans.Cart;
import DAO.CartDAO;

@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartDAO cartDAO;

    public CartServlet() {
        super();
        cartDAO = new CartDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        String action = request.getParameter("action");

        if (action != null && action.equals("delete")) {
            int articleId = Integer.parseInt(request.getParameter("articleId"));
            cart.removeItem(articleId);
            session.setAttribute("cart", cart); // Update the session cart
            response.sendRedirect("CartServlet");
            return;
        }

        double totalCart = cart.getTotal();
        request.setAttribute("totalCart", totalCart);

        request.setAttribute("cart", cart);
        request.getRequestDispatcher("/WEB-INF/Cart.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        double totalCart = cart.getTotal();
        request.setAttribute("totalCart", totalCart);
        request.getRequestDispatcher("/WEB-INF/Commande.jsp").forward(request, response);
    }
}
