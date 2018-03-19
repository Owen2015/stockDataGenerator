package com.owen.stockDataGenerator.model.market;

import java.util.List;
import java.util.Queue;

public class Market {

	private List<Stock> stocks;
	private List<Investor> investors;
	//private List<Order>buyOrder;
	//private List<Order>sellOrder;
	private Queue<Order> buyOrders;
	private Queue<Order> sellOrders;
	public List<Stock> getStocks() {
		return stocks;
	}
	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}
	public List<Investor> getInvestors() {
		return investors;
	}
	public void setInvestors(List<Investor> investors) {
		this.investors = investors;
	}
	public Queue<Order> getBuyOrders() {
		return buyOrders;
	}
	public void setBuyOrders(Queue<Order> buyOrders) {
		this.buyOrders = buyOrders;
	}
	public Queue<Order> getSellOrders() {
		return sellOrders;
	}
	public void setSellOrders(Queue<Order> sellOrders) {
		this.sellOrders = sellOrders;
	}
	
	
}
