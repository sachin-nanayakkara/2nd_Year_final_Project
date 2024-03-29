package com.jwt.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



import com.jwt.model.Stock;

@Repository
public class StockDAOImpl implements StockDAO {

	@Autowired
	private SessionFactory sessionFactory1;    
	
	@Override
	public void addStock(Stock stock) {
		sessionFactory1.getCurrentSession().saveOrUpdate(stock);
		
	}

	@SuppressWarnings("unchecked")
	public List<Stock> getAllStocks() {
		return sessionFactory1.getCurrentSession().createQuery("from Stock")
				.list();
	}

	@Override
	public void deleteStock(Integer stockId) {
		Stock stock  = (Stock) sessionFactory1.getCurrentSession().load(
				Stock.class, stockId);
		if (null != stock) {
			this.sessionFactory1.getCurrentSession().delete(stock);
		}
		
	}

	@Override
	public Stock getStock(int stockid) {
		return (Stock) sessionFactory1.getCurrentSession().get(
				Stock.class, stockid);
	}

	@Override
	public Stock updateStock(Stock stock) {
		sessionFactory1.getCurrentSession().update(stock);
		return stock;
	}

	
	public Stock updateName(Stock stock) {
		sessionFactory1.getCurrentSession().update(stock);
		return stock;
	}

	public Stock getName(String stockid) {
		return (Stock) sessionFactory1.getCurrentSession().get(
				Stock.class, stockid);
	}

	
	
}
