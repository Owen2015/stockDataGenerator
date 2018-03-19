package com.owen.stockDataGenerator.model.market;

public class TradeBoardElement {

	private Long stockId;
	private String stockName;
	private Double stockPrice;
	private Long exchangeVolume;
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public Double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(Double stockPrice) {
		this.stockPrice = stockPrice;
	}
	public Long getExchangeVolume() {
		return exchangeVolume;
	}
	public void setExchangeVolume(Long exchangeVolume) {
		this.exchangeVolume = exchangeVolume;
	}
	
	
}
