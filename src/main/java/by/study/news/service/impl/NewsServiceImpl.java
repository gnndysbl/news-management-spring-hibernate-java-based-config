package by.study.news.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import by.study.news.dao.NewsDAO;
import by.study.news.dao.exception.DAOException;
import by.study.news.entity.Article;
import by.study.news.service.NewsService;
import by.study.news.service.exception.ServiceException;

@Service
public class NewsServiceImpl implements NewsService {

	private static final String ACTIVE = "ACTIVE";
	private static final String BLOCKED = "BLOCKED";

	// need to inject customer dao
	@Autowired
	private NewsDAO newsDAO;

	// @Override
	@Transactional
	public List<Article> getActive() {
		return newsDAO.getActive();
	}

	// @Override
	@Transactional
	public void save(Article article) {

		// check
		article.setDate(new Date());
		article.setStatus(ACTIVE);
		newsDAO.save(article);
	}

	// @Override
	@Transactional
	public Article get(int id) throws ServiceException {

		try {
			Article art = newsDAO.get(id);
			if (art.getStatus().equals("BLOCKED") == true) {
				throw new ServiceException("article #" + id + " is blocked");
			}
			return art;

		} catch (DAOException e) {

			throw new ServiceException("Can not find article #" + id + "; Caused by DAOException:" + e.getMessage());
		}
	}

	// @Override
	@Transactional
	public void block(int id) {

		newsDAO.block(id);
	}
}
