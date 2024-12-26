package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.Beans.Article;
import com.test.Beans.Cart;

public class CartDAO implements InterfaceCart {

	public void saveCart(Cart cart) {
	    if (cart == null || cart.getItems() == null || cart.getItems().isEmpty()) {
	        return;
	    }

	    String sql = "INSERT INTO cart (idUser, idArticle, quantity) VALUES (?, ?, ?)";
	    try (Connection connection = dbc.CreateConnexion()) {
	        for (Article item : cart.getItems()) {
	            try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	                int userId = cart.getUserId();
	                int articleId = item.getIdArticle();
	                int quantity = item.getQteStock();
	                stmt.setInt(1, userId);
	                stmt.setInt(2, articleId);
	                stmt.setInt(3, quantity);
	                stmt.executeUpdate();
	            } catch (SQLException e) {
	                // Gérer les erreurs spécifiques à cette requête
	                e.printStackTrace();
	            }
	        }
	    } catch (SQLException e) {
	        // Gérer les erreurs de connexion
	        e.printStackTrace();
	    }
	}

	@Override
	public void updateCart(Cart cart) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cart getCart(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCart(int userId) {
		// TODO Auto-generated method stub
		
	}
	
	}