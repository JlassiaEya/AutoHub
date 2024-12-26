package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.Beans.Article;

public class ArticleDAO implements ArticleInterface {

	@Override
	public List<Article> getAll() {
	    String sql = "SELECT * FROM article";
	    try (Connection connection = dbc.CreateConnexion();
	         PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();
	        
	        ArrayList<Article> articles = new ArrayList<>();
	        while (rs.next()) {
	            Article article = new Article();
	            article.setIdArticle(rs.getInt("idArticle"));
	            article.setIdUser(rs.getInt("idUser"));
	            article.setNomArticle(rs.getString("nomArticle"));
	            article.setDescription(rs.getString("description"));
	            article.setPrix(rs.getDouble("prix"));
	            article.setEtat(rs.getString("etat"));
	            article.setTelephone(rs.getString("telephone"));
	            article.setPhoto(rs.getString("photo"));
	            article.setDatePublication(rs.getDate("datePublication"));
	            article.setCategorie(rs.getString("categorie"));
	            article.setQteStock(rs.getInt("qteStock"));
	            articles.add(article);
	            System.out.println("Article retrieved: " + article);
	        }
	        return articles;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}

    @Override
    public void addArticle(Article art) {
        String sql = "INSERT INTO article (idUser, nomArticle, description, prix, etat, telephone, photo, datePublication, categorie,qteStock) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, art.getIdUser());
            stmt.setString(2, art.getNomArticle());
            stmt.setString(3, art.getDescription());
            stmt.setDouble(4, art.getPrix());
            stmt.setString(5, art.getEtat());
            stmt.setString(6, art.getTelephone());
            stmt.setString(7, art.getPhoto());
            stmt.setDate(8, new java.sql.Date(art.getDatePublication().getTime()));
            stmt.setString(9, art.getCategorie());
            stmt.setInt(10, art.getQteStock());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Article findArticle(int id) {
        String sql = "SELECT * FROM article WHERE idArticle = ?";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                Article article = new Article();
                article.setIdArticle(rs.getInt("idArticle"));
                article.setIdUser(rs.getInt("idUser"));
                article.setNomArticle(rs.getString("nomArticle"));
                article.setDescription(rs.getString("description"));
                article.setPrix(rs.getDouble("prix"));
                article.setEtat(rs.getString("etat"));
                article.setPhoto(rs.getString("photo"));
                article.setDatePublication(rs.getDate("datePublication"));
                article.setCategorie(rs.getString("categorie"));
                article.setQteStock(rs.getInt("qteStock"));
                return article;
            } else {
                // L'article n'a pas été trouvé dans la base de données
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean deleteArticle(int id) {
        String sql = "DELETE FROM article WHERE idArticle = ?";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    public List<Article> getByCategory(String category) {
        String sql = "SELECT * FROM article WHERE categorie = ?";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, category);
            ResultSet rs = stmt.executeQuery();
            
            ArrayList<Article> articles = new ArrayList<>();
            while (rs.next()) {
                Article article = new Article();
                article.setIdArticle(rs.getInt("idArticle"));
                article.setIdUser(rs.getInt("idUser"));
                article.setNomArticle(rs.getString("nomArticle"));
                article.setDescription(rs.getString("description"));
                article.setPrix(rs.getDouble("prix"));
                article.setEtat(rs.getString("etat"));
                article.setPhoto(rs.getString("photo"));
                article.setDatePublication(rs.getDate("datePublication"));
                article.setCategorie(rs.getString("categorie"));
                article.setQteStock(rs.getInt("qteStock"));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public Map<String, List<Article>> getArticlesByCategory() {
        Map<String, List<Article>> articlesByCategory = new HashMap<>();
        String sql = "SELECT * FROM article";
        
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                Article article = new Article();
                article.setIdArticle(resultSet.getInt("idArticle"));
                article.setIdUser(resultSet.getInt("idUser"));
                article.setNomArticle(resultSet.getString("nomArticle"));
                article.setDescription(resultSet.getString("description"));
                article.setPrix(resultSet.getDouble("prix"));
                article.setEtat(resultSet.getString("etat"));
                article.setPhoto(resultSet.getString("photo"));
                article.setDatePublication(resultSet.getDate("datePublication"));
                article.setCategorie(resultSet.getString("categorie"));
                article.setQteStock(resultSet.getInt("qteStock"));
                
                String category = article.getCategorie();
                List<Article> categoryArticles = articlesByCategory.getOrDefault(category, new ArrayList<>());
                categoryArticles.add(article);
                articlesByCategory.put(category, categoryArticles);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return articlesByCategory;
    }

    public List<Article> getByUserId(int id_user) {
        String sql = "SELECT * FROM article WHERE idUser = ?";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id_user);
            ResultSet rs = stmt.executeQuery();

            ArrayList<Article> articles = new ArrayList<>();
            while (rs.next()) {
                Article article = new Article();
                article.setIdArticle(rs.getInt("idArticle"));
                article.setIdUser(rs.getInt("idUser"));
                article.setNomArticle(rs.getString("nomArticle"));
                article.setDescription(rs.getString("description"));
                article.setPrix(rs.getDouble("prix"));
                article.setEtat(rs.getString("etat"));
                article.setPhoto(rs.getString("photo"));
                article.setDatePublication(rs.getDate("datePublication"));
                article.setCategorie(rs.getString("categorie"));
                article.setQteStock(rs.getInt("qteStock"));
                articles.add(article);
            }
            return articles;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public void update(Article article) {
        String sql = "UPDATE article SET nomArticle = ?, description = ?, prix = ?, etat = ?, photo = ?, datePublication = ?, categorie = ?, qteStock = ? WHERE idArticle = ?";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            // Récupérer l'article existant pour obtenir la photo existante
            Article existingArticle = findArticle(article.getIdArticle());
            String existingPhoto = existingArticle != null ? existingArticle.getPhoto() : null;

            stmt.setString(1, article.getNomArticle());
            stmt.setString(2, article.getDescription());
            stmt.setDouble(3, article.getPrix());
            stmt.setString(4, article.getEtat());

            // Utiliser la nouvelle photo si fournie, sinon utiliser l'existante
            if (article.getPhoto() != null) {
                stmt.setString(5, article.getPhoto());
            } else {
                stmt.setString(5, existingPhoto);
            }

            if (article.getDatePublication() != null) {
                stmt.setDate(6, new java.sql.Date(article.getDatePublication().getTime()));
            } else {
                // Utiliser la date actuelle si datePublication est null
                stmt.setDate(6, new java.sql.Date(System.currentTimeMillis()));
            }

            stmt.setString(7, article.getCategorie());
            stmt.setInt(8, article.getQteStock());
            stmt.setInt(9, article.getIdArticle());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


	public Article getId(int articleId) {
        String sql = "SELECT * FROM article WHERE idArticle = ?";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, articleId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Article article = new Article();
                    article.setIdArticle(rs.getInt("idArticle"));
                    article.setNomArticle(rs.getString("nomArticle"));
                    article.setDescription(rs.getString("description"));
                    article.setPrix(rs.getDouble("prix"));
                    article.setEtat(rs.getString("etat"));
                    article.setPhoto(rs.getString("photo"));
                    article.setDatePublication(rs.getDate("datePublication"));
                    article.setCategorie(rs.getString("categorie"));
                    article.setQteStock(rs.getInt("qteStock"));
                    return article;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


	

}