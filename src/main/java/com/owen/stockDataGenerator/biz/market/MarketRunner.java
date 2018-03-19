package com.owen.stockDataGenerator.biz.market;


import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import com.owen.stockDataGenerator.model.market.Market;
import com.owen.stockDataGenerator.model.market.Order;
import com.owen.stockDataGenerator.model.market.TradeBoardElement;

public class MarketRunner implements Runnable {

	private List<TradeBoardElement> tradeBoard;
	
	public MarketRunner(List<TradeBoardElement> tradeBoard) {
		this.tradeBoard=tradeBoard;
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		Market market=new Market();
		market=MarketInitializer.init(market);
		
		Queue<Order> buyOrders= createPriorityBlockQueue(1,-1);
		Queue<Order> sellOrders= createPriorityBlockQueue(-1,1);
		generateOrder(buyOrders,sellOrders);
		
		Order buyOrder;
		Order sellOrder;
		
		TradeBoardElement tb=new TradeBoardElement();
		tradeBoard.add(tb);
		while(true) {

			buyOrder=buyOrders.peek();
			sellOrder=sellOrders.peek();
			if(sellOrder.getPrice()<=buyOrder.getPrice()) {
				
				tb.setStockId(buyOrder.getStockId());
				tb.setStockPrice((buyOrder.getPrice()+sellOrder.getPrice())/2);
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
	
   /** create PriorityBloking queue, parameter i, j use to control the sorting order of the queue. 
	   (-1,1) means ascendant order, use for sell order
	   (1,-1) means descendant order, use for buy order
	 */
	
	private Queue<Order> createPriorityBlockQueue(int i,int j) {
		return new PriorityBlockingQueue<Order>(1000,new Comparator<Order>() {

			@Override
			public int compare(Order arg0, Order arg1) {
				// TODO Auto-generated method stub
				if(arg0.getPrice()<arg1.getPrice()) return i;
				else if(arg0.getPrice()>arg1.getPrice()) return j;
				else return 0;
			}});

	}
	
	private void generateOrder(Queue<Order> buyOrders,Queue<Order> sellOrders) {
		
		Thread buyOrderGenerator=new Thread(new OrderGenerator(buyOrders,0));
		Thread sellOrderGenerator=new Thread(new OrderGenerator(sellOrders,1));
		
		buyOrderGenerator.start();
		sellOrderGenerator.start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
