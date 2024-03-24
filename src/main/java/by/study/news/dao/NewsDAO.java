package by.study.news.dao;

import java.util.List;

import by.study.news.dao.exception.DAOException;
import by.study.news.entity.Article;

public interface NewsDAO {

	public List<Article> getActive();

	public void save(Article article);

	public Article get(int id) throws DAOException;

	public void block(int id);
	
}
