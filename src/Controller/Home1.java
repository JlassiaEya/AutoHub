package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.test.Beans.User;
import com.test.Beans.Article;
import com.test.Beans.Cart;


import DAO.ArticleDAO;
import DAO.CartDAO;
import DAO.userDAO;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home1")
public class Home1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    private CartDAO cartDAO;

    public Home1() {
        super();
        CartDAO cartDAO = new CartDAO();
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String categoryFilter = request.getParameter("category");
        request.setAttribute("categoryFilter", categoryFilter);

        ArticleDAO articleDAO = new ArticleDAO();
        List<Article> articles;
        
        if (categoryFilter != null && !categoryFilter.isEmpty()) {
            articles = articleDAO.getByCategory(categoryFilter);
        } else {
            articles = articleDAO.getAll();
        }

        userDAO userDAO = new userDAO();
        List<User> users = userDAO.getAll();
        List<User> usersP = new ArrayList<>();
        Set<String> uniqueCategories = new HashSet<>();
        Map<String, List<Article>> articlesByCategory = new HashMap<>();

        // Ajouter les utilisateurs correspondants à chaque article
        for (Article article : articles) {
            for (User user : users) {
                if (user.getId_user() == article.getIdUser()) {
                    usersP.add(user);
                    break;
                }
            }
            // Remplir la liste des catégories uniques et la map des articles par catégorie
            uniqueCategories.add(article.getCategorie());
            List<Article> categoryArticles = articlesByCategory.getOrDefault(article.getCategorie(), new ArrayList<>());
            categoryArticles.add(article);
            articlesByCategory.put(article.getCategorie(), categoryArticles);
        }

        request.setAttribute("uniqueCategories", uniqueCategories);
        request.setAttribute("articles", articles);
        request.setAttribute("usersP", usersP);
        request.setAttribute("articlesByCategory", articlesByCategory);
        
        request.getRequestDispatcher("/WEB-INF/Home1.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");

        if (cart == null) {
            cart = new Cart();
            session.setAttribute("cart", cart);
        }

        int articleId = Integer.parseInt(request.getParameter("articleId"));
        String name = request.getParameter("nomArticle");
        double total = Double.parseDouble(request.getParameter("prix"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        // Créer un objet Article avec les détails reçus
        Article article = new Article();
        article.setIdArticle(articleId);
        article.setNomArticle(name);
        article.setPrix(total);
        article.setQteStock(quantity);

        // Ajouter l'article au panier
        cart.addItem(article);
        double totalCart = cart.getTotal();

        // Enregistrer le panier dans la base de données
        if (cartDAO != null && totalCart > 0) {
            cartDAO.saveCart(cart);
            System.out.println("Article Enregistrer dans la base");
        } else {
            System.out.println("erreurrrrrrrrrrrrrr");

        }

        response.sendRedirect(request.getContextPath() + "/CartServlet");
    }
}