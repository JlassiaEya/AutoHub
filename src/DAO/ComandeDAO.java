package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.test.Beans.Commande;

public class ComandeDAO implements CommandeInterface {

    @Override
    public List<Commande> getAll() {
        String sql = "SELECT * FROM commande";
        try (Connection connection = dbc.CreateConnexion();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();

            ArrayList<Commande> commandes = new ArrayList<>();
            while (rs.next()) {
                Commande commande = new Commande();
                commande.setIdCommande(rs.getInt("id"));
                commande.setNom(rs.getString("nom"));
                commande.setPrenom(rs.getString("prenom"));
                commande.setAdresse(rs.getString("adresse"));
                commande.setDateCommande(rs.getDate("date_commande").toLocalDate()); 
                commandes.add(commande);
                System.out.println("Commande récupérée : " + commande);
            }
            return commandes;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addCommande(Commande c) {
    	String sql = "INSERT INTO commande (nom, prenom, adresse, total, date_commande) VALUES (?, ?, ?, ?, ?)";
        try (Connection maconnexion = dbc.CreateConnexion();
             PreparedStatement stmt = maconnexion.prepareStatement(sql)) {
            stmt.setString(1, c.getNom());
            stmt.setString(2, c.getPrenom());
            stmt.setString(3, c.getAdresse());
            stmt.setDouble(4, c.getTotal());
            stmt.setDate(5, java.sql.Date.valueOf(c.getDateCommande())); 
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Commande findArticle(int id) {
        return null;
    }

    @Override
    public boolean deleteArticle(int id) {
        return false;
    }
}
