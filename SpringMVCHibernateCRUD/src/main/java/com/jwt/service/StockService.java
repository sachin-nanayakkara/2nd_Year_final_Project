package com.jwt.service;
import java.util.List;

import com.jwt.model.Stock;




public interface StockService {
	
	public void addStock(Stock stock);

	public List<Stock> getAllStocks();

	public void deleteStock(Integer stockId);

	public Stock getStock(int stockid);

	public Stock updateStock(Stock stock);

	public Stock getName(String stockid);
	
	public Stock updateName(Stock stock);
	
}
