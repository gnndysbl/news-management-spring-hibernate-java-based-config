package by.study.news.service;

import java.util.List;
import by.study.news.entity.Article;
import by.study.news.service.exception.ServiceException;

public interface NewsService {

	public List<Article> getActive();

	public void save(Article article);

	public Article get(int id) throws ServiceException;

	public void block(int id);
	
}
