package com.owen.stockDataGenerator.biz.market;

import java.util.Queue;

import com.owen.stockDataGenerator.model.market.Order;
import com.owen.stockDataGenerator.model.market.TradeBoardElement;

public class OrderHandler implements Runnable{

	private Queue<Order> buyOrders;
	private Queue<Order> sellOrders;
	private TradeBoardElement tradeBoardElement;
	public OrderHandler(Queue<Order> buyOrders,Queue<Order> sellOrders,TradeBoardElement tradeBoardElement) {
		this.buyOrders=buyOrders;
		this.sellOrders=sellOrders;
		this.tradeBoardElement=tradeBoardElement;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Order buyOrder;
		Order sellOrder;
		while(true) {
			if(!buyOrders.isEmpty()&&!sellOrders.isEmpty()) {
				
				buyOrder=buyOrders.peek();
				sellOrder=sellOrders.peek();
				if(sellOrder.getPrice()<=buyOrder.getPrice()) {
					
					tradeBoardElement.setStockId(buyOrder.getStockId());
					tradeBoardElement.setStockPrice((buyOrder.getPrice()+sellOrder.getPrice())/2);
					tradeBoardElement.setVolume(buyOrder.getShare());
					tradeBoardElement.setStockName(buyOrder.getStockName());
					buyOrders.poll();
					sellOrders.poll();
					
				}
			}
			

		}
	}

}
