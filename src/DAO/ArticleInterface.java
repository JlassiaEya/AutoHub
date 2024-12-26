package DAO;

import java.util.List;

import com.test.Beans.Article;


public interface ArticleInterface {
	public List<Article> getAll();
	public void addArticle(Article art);
	public Article findArticle(int id);
	public boolean deleteArticle(int id);
}
