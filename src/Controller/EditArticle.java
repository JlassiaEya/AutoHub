package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ArticleDAO;
import com.test.Beans.Article;

@WebServlet("/EditArticle")
public class EditArticle extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private ArticleDAO articleDAO;

    public EditArticle() {
        super();
        articleDAO = new ArticleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        Article article =  articleDAO.getId(articleId);
        
        request.setAttribute("article", article);
        request.getRequestDispatcher("/WEB-INF/EditArticle.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int articleId = Integer.parseInt(request.getParameter("articleId"));
        String nomArticle = request.getParameter("nomArticle");
        String description = request.getParameter("description");
        double prix = Double.parseDouble(request.getParameter("prix"));
        String etat = request.getParameter("etat");
        String categorie = request.getParameter("categorie");
        int qteStock = Integer.parseInt(request.getParameter("qteStock"));

        // Get the existing photo value from the database
        Article existingArticle = articleDAO.findArticle(articleId);
        String existingPhoto = existingArticle.getPhoto();

        // Get the new photo value, if provided
        String newPhoto = request.getParameter("photo");

        // If no new photo is provided, keep the existing photo
        if (newPhoto == null || newPhoto.trim().isEmpty()) {
            newPhoto = existingPhoto;
        }

        Article article = new Article();
        article.setIdArticle(articleId);
        article.setNomArticle(nomArticle);
        article.setDescription(description);
        article.setPrix(prix);
        article.setEtat(etat);
        article.setCategorie(categorie);
        article.setQteStock(qteStock);
        article.setPhoto(newPhoto);

        articleDAO.update(article);
        response.sendRedirect(request.getContextPath() + "/UserArticle");
    }
}