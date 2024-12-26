package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.Beans.Commande;

import DAO.ComandeDAO;

@WebServlet("/ListeCServlets")
public class ListeCServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ListeCServlets() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Appeler la méthode getAll() de ComandeDAO pour récupérer toutes les commandes
        ComandeDAO commandeDAO = new ComandeDAO();
        List<Commande> commandes = commandeDAO.getAll();

        // Définir les commandes comme attribut de requête pour les transmettre à la JSP
        request.setAttribute("commandes", commandes);

        // Rediriger vers la page ListeCommande.jsp pour affichage
        request.getRequestDispatcher("/WEB-INF/ListeCommande.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Récupérer les données du formulaire s'il y en a
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");
        String adresse = request.getParameter("adresse");

        // Créer une nouvelle commande avec les données du formulaire
        Commande commande = new Commande();
        commande.setNom(nom);
        commande.setPrenom(prenom);
        commande.setAdresse(adresse);

        // Ajouter la nouvelle commande à la base de données
        ComandeDAO commandeDAO = new ComandeDAO();
        commandeDAO.addCommande(commande);

        // Rediriger vers la page ListeCommande.jsp pour affichage de toutes les commandes
        response.sendRedirect(request.getContextPath() + "/ListeCServlets");
    }
}
