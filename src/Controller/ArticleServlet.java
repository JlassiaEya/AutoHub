package Controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.Beans.Article;
import DAO.ArticleDAO;
/**
 * Servlet implementation class Article
 */
@WebServlet("/Article")
public class ArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
  		 request.getRequestDispatcher("/WEB-INF/AjoutArticle.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        HttpSession session = request.getSession();
	        int userId = (int) session.getAttribute("userId");

	        // Vérifier si l'ID de l'utilisateur est valide
	        if (userId != -1) {
	            String nomArticle = request.getParameter("nomArticle");
	            String description = request.getParameter("description");
	            double prix = Double.parseDouble(request.getParameter("prix"));
	            String etat = request.getParameter("etat");
	            String telephone = request.getParameter("telephone");
	            String photo = request.getParameter("photo");
	            String categorie = request.getParameter("categorie");
	            int qteStock = Integer.parseInt(request.getParameter("qteStock"));
	            
	            // Créer un objet Article
	            Article article = new Article();
	            article.setIdUser(userId);
	            article.setNomArticle(nomArticle);
	            article.setDescription(description);
	            article.setPrix(prix);
	            article.setEtat(etat);
	            article.setTelephone(telephone);
	            article.setPhoto(photo);
	            article.setDatePublication(new Date());
	            article.setCategorie(categorie);
	            article.setQteStock(qteStock);

	            
	            // Ajouter l'article à la base de données
	            ArticleDAO articleDAO = new ArticleDAO();
	            articleDAO.addArticle(article);
	            
	            // Redirection vers la page d'accueil après l'ajout de l'article
	             response.sendRedirect(request.getContextPath() + "/Home");
	        } else {
	            // Redirection vers une page d'erreur si l'utilisateur n'est pas connecté
	            response.sendRedirect(request.getContextPath() + "/error.jsp");
	        }
	    }
	}