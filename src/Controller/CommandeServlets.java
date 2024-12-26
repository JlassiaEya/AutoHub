package Controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.Beans.Cart;
import com.test.Beans.Commande;

import DAO.ComandeDAO;

@WebServlet("/Commande")
public class CommandeServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/Commande.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");

        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        double totalCart = 0.0;

        if (cart != null) {
            totalCart = cart.getTotal();
        }
        LocalDate dateCommande = LocalDate.now();

     Commande commande = new Commande(nom, prenom, adresse, totalCart, dateCommande);
        ComandeDAO commandeDAO = new ComandeDAO();
        try {
            commandeDAO.addCommande(commande);
            request.setAttribute("successMessage", "La commande a été ajoutée avec succès.");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("errorMessage", "Erreur lors de l'ajout de la commande. Veuillez réessayer.");
        }

        request.setAttribute("totalCart", totalCart);

        request.getRequestDispatcher("/WEB-INF/Commande.jsp").forward(request, response);
    }
}