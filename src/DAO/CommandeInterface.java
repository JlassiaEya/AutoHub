package DAO;

import java.util.List;
import com.test.Beans.Commande;

public interface CommandeInterface {
	public List<Commande> getAll();
	public void addCommande(Commande c);
	public Commande findArticle(int id);
	public boolean deleteArticle(int id);
}
