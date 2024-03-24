package by.study.news.dao.impl;

import java.util.List;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import by.study.news.dao.NewsDAO;
import by.study.news.dao.exception.DAOException;
import by.study.news.entity.Article;

@Repository
public class NewsDAOImpl implements NewsDAO {

	private static final String GET_ACTIVE_ARTICLES_BY_DATE_DESC = "from Article where status=:status order by date DESC ";
	private static final String BLOCK_ARTICLE = "update Article set status=:status where id=:id";
	
	private static final String STATUS_PARAM = "status";
	private static final String ID_PARAM = "id";
	
	private static final String ACTIVE = "ACTIVE";
	private static final String BLOCKED = "BLOCKED";

	
	
	
	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	
	public NewsDAOImpl (SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

	//@Override
	public List<Article> getActive() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by date
		Query<Article> theQuery = 
				currentSession.createQuery(GET_ACTIVE_ARTICLES_BY_DATE_DESC,
											Article.class);
		theQuery.setParameter(STATUS_PARAM, ACTIVE);

		
		// execute query and get result list
		List<Article> news = theQuery.getResultList();
				
		// return the results		
		return news;
	}

	//@Override
	public void save(Article article) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the article ... finally LOL
		currentSession.saveOrUpdate(article);
		
	}

	//@Override
	public Article get(int id) throws DAOException {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Article article = currentSession.get(Article.class, id);
		
		if (article == null) {
			
			throw new DAOException("article #"+id+" is null");
			
		} else
			
		return article;
	}

	//@Override
	public void block(int id) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(BLOCK_ARTICLE);
		
		theQuery.setParameter(STATUS_PARAM, BLOCKED);
		theQuery.setParameter(ID_PARAM, id);
				
		theQuery.executeUpdate();		
	}

}











