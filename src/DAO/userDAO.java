package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.test.Beans.User;

public class userDAO implements UserInterface {

	@Override
	public List<User> getAll() {
	    String sql = "SELECT * FROM user"; 
	    try (Connection connection = dbc.CreateConnexion();
	         PreparedStatement stmt = connection.prepareStatement(sql)) {
	        ResultSet rs = stmt.executeQuery();
	        
	        ArrayList<User> users = new ArrayList<>();
	        while (rs.next()) {
	            User user = new User(rs.getInt("id_user"), rs.getString("nom"), rs.getString("email"), rs.getString("mdp"));
	            users.add(user);
	            System.out.println("User retrieved: " + user);
	        }
	        return users;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return null;
	    }
	}
    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO user (nom, email, mdp) VALUES(?,?,?)";
        try {
            Connection maconnexion = dbc.CreateConnexion();
            PreparedStatement stmt = maconnexion.prepareStatement(sql);
            stmt.setString(1, user.getNom());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getMdp());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }       
    }
    

    @Override
    public User findUser(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        // TODO Auto-generated method stub
        return false;
    }

	@Override
	public boolean added(User user) {
		    String sql = "INSERT INTO user (nom, email, mdp) VALUES(?,?,?)";
		    try {
		        Connection maconnexion = dbc.CreateConnexion();
		        PreparedStatement stmt = maconnexion.prepareStatement(sql);
		        stmt.setString(1, user.getNom());
		        stmt.setString(2, user.getEmail());
		        stmt.setString(3, user.getMdp());
		        int rowsAffected = stmt.executeUpdate();
		        return rowsAffected > 0; 
		    } catch (SQLException e) {
		        e.printStackTrace();
		        return false; 
		    }       

	}
	public User getUserByemail(String email) {
	    try {
	        Connection connection = dbc.CreateConnexion();
	        PreparedStatement statement = connection.prepareStatement("SELECT * FROM user WHERE email = ?");
	        statement.setString(1, email); 
	        ResultSet resultSet = statement.executeQuery();

	        if (resultSet.next()) {
	            int id = resultSet.getInt("id_user");
	            String username = resultSet.getString("nom");
	            String password = resultSet.getString("mdp");
	            return new User(id, username, email, password);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	 public User getUserById(int userId) {
	        User user = null;
	        
	        String sql = "SELECT * FROM user WHERE id_user = ?";
	        
	        try (
	            Connection connection = dbc.CreateConnexion();
	            PreparedStatement statement = connection.prepareStatement(sql)
	        ) {
	            statement.setInt(1, userId);
	            
	            ResultSet resultSet = statement.executeQuery();
	            
	            if (resultSet.next()) {
	                user = new User(
	                    resultSet.getInt("id_user"),
	                    resultSet.getString("nom"),
	                    resultSet.getString("email"),
	                    resultSet.getString("mdp")
	                );
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        
	        return user;
	    }
	}






