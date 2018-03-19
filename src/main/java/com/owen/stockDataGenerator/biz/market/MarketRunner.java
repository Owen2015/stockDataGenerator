package com.owen.stockDataGenerator.biz.market;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.PriorityBlockingQueue;

import com.owen.stockDataGenerator.model.market.Investor;
import com.owen.stockDataGenerator.model.market.Market;
import com.owen.stockDataGenerator.model.market.Order;
import com.owen.stockDataGenerator.model.market.TradeBoardElement;

public class MarketRunner implements Runnable {

	private List<TradeBoardElement> tradeBoard;
	private Market market;
	
	public MarketRunner(List<TradeBoardElement> tradeBoard) {
		this.tradeBoard=tradeBoard;
	}

	public static void main(String[] args ) {
		
		Queue<Order> buyOrders= new PriorityBlockingQueue<Order>(1000,new Comparator<Order>() {

			@Override
			public int compare(Order arg0, Order arg1) {
				// TODO Auto-generated method stub
				if(arg0.getPrice()<arg1.getPrice()) return 1;
				else if(arg0.getPrice()>arg1.getPrice()) return -1;
				else return 0;
			}});
		Order o1=new Order();
		o1.setPrice(100D);
		Order o2=new Order();
		o2.setPrice(200D);
		Order o3=new Order();
		o3.setPrice(300D);
		buyOrders.add(o2);
		buyOrders.add(o1);
		buyOrders.add(o3);
		Order o4=buyOrders.peek();
		System.out.println(o4.getPrice());
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Market market=new Market();
		market=MarketInitializer.init(market);
		
		Queue<Order> buyOrders= new PriorityBlockingQueue<Order>(1000,new Comparator<Order>() {

			@Override
			public int compare(Order arg0, Order arg1) {
				// TODO Auto-generated method stub
				if(arg0.getPrice()<arg1.getPrice()) return 1;
				else if(arg0.getPrice()>arg1.getPrice()) return -1;
				else return 0;
			}});
		
		//Queue<Order> synSellOrders=new PriorityBlockingQueue<Order>(Collections.reverseOrder());
		
		Queue<Order> sellOrders= new PriorityBlockingQueue<Order>(1000,new Comparator<Order>() {

			@Override
			public int compare(Order arg0, Order arg1) {
				// TODO Auto-generated method stub
				if(arg0.getPrice()<arg1.getPrice()) return -1;
				else if(arg0.getPrice()>arg1.getPrice()) return 1;
				else return 0;
			}});
		

		Thread buyOrderGenerator=new Thread(new OrderGenerator(buyOrders,0));
		Thread sellOrderGenerator=new Thread(new OrderGenerator(sellOrders,1));
		
		buyOrderGenerator.start();
		sellOrderGenerator.start();
		
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		
		Order buyOrder;
		Order sellOrder;
		while(true) {

			buyOrder=buyOrders.peek();
			sellOrder=sellOrders.peek();
			if(sellOrder.getPrice()<=buyOrder.getPrice()) {
				
				TradeBoardElement tb=new TradeBoardElement();
				tb.setStockId(buyOrder.getStockId());
				tb.setStockPrice((buyOrder.getPrice()+sellOrder.getPrice())/2);
				tradeBoard.add(tb);
				buyOrders.poll();
				sellOrders.poll();
				
			}
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}

}
