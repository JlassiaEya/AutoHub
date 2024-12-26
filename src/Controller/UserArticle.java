package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import DAO.ArticleDAO;
import com.test.Beans.Article;

@WebServlet("/UserArticle")
public class UserArticle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ArticleDAO articleDAO;

    public UserArticle() {
        super();
        articleDAO = new ArticleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null || userId == -1) {
            response.sendRedirect("Login.jsp");
            return;
        }

        List<Article> articles = articleDAO.getByUserId(userId);
        request.setAttribute("articles", articles);
        request.getRequestDispatcher("/WEB-INF/UserArticles.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    String action = request.getParameter("action");
    String articleIdStr = request.getParameter("articleId");

    if (articleIdStr == null || articleIdStr.isEmpty()) {
        response.sendRedirect("UserArticle");
        return;
    }

    int articleId;
    try {
        articleId = Integer.parseInt(articleIdStr);
    } catch (NumberFormatException e) {
        // Handle the case where articleIdStr cannot be parsed to an integer
        e.printStackTrace();
        response.sendRedirect("UserArticle");
        return;
    }

    if ("delete".equals(action)) {
        articleDAO.deleteArticle(articleId);
    } else {
        String nomArticle = request.getParameter("nomArticle");
        String description = request.getParameter("description");
        double prix;
        try {
            prix = Double.parseDouble(request.getParameter("prix"));
        } catch (NumberFormatException e) {
            // Handle the case where prix cannot be parsed to a double
            e.printStackTrace();
            response.sendRedirect("UserArticle");
            return;
        }
        String etat = request.getParameter("etat");
        String categorie = request.getParameter("categorie");
        int qteStock;
        try {
            qteStock = Integer.parseInt(request.getParameter("qteStock"));
        } catch (NumberFormatException e) {
            // Handle the case where qteStock cannot be parsed to an integer
            e.printStackTrace();
            response.sendRedirect("UserArticle");
            return;
        }

        Article article = new Article();
        article.setIdArticle(articleId);
        article.setNomArticle(nomArticle);
        article.setDescription(description);
        article.setPrix(prix);
        article.setEtat(etat);
        article.setCategorie(categorie);
        article.setQteStock(qteStock);

        articleDAO.update(article);
    }
    response.sendRedirect("UserArticle");
}
}