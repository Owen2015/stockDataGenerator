package com.owen.stockDataGenerator.model.market;

import java.util.Map;

public class Investor {

	private Long id;
	private String name;
	private Map<Long,Long> stocks;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<Long, Long> getStocks() {
		return stocks;
	}
	public void setStocks(Map<Long, Long> stocks) {
		this.stocks = stocks;
	}
	
}
