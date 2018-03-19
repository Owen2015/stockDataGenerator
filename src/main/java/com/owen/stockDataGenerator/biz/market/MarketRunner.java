package com.owen.stockDataGenerator.biz.market;


import java.util.Comparator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

import com.owen.stockDataGenerator.model.market.Market;
import com.owen.stockDataGenerator.model.market.Order;
import com.owen.stockDataGenerator.model.market.Stock;
import com.owen.stockDataGenerator.model.market.TradeBoardElement;

public class MarketRunner implements Runnable {

	private List<TradeBoardElement> tradeBoard;
	
	public MarketRunner(List<TradeBoardElement> tradeBoard) {
		this.tradeBoard=tradeBoard;
	}

	@Override
	public void run() {
		Market market=new Market();
		market=MarketInitializer.init(market);
		List<Stock> stocks=market.getStocks();
		
		Stock stock;
		Queue<Order> buyOrders;
		Queue<Order> sellOrders;
		TradeBoardElement tradeBoardElement;
		for(int i=0;i<stocks.size();i++) {
			stock=stocks.get(i);
			buyOrders=createPriorityBlockQueue(1,-1);
			sellOrders=createPriorityBlockQueue(-1,1);
			generateOrder(buyOrders,Order.BUY,stock);
			generateOrder(sellOrders,Order.SELL,stock);
			
			tradeBoardElement=new TradeBoardElement();
			tradeBoard.add(tradeBoardElement);
			handleOrder(buyOrders,sellOrders,tradeBoardElement);
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
	
	private void generateOrder(Queue<Order> orders,int orderType,Stock stock) {
		Thread runOrder=new Thread(new OrderGenerator(orders,orderType,stock));
		runOrder.start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void handleOrder(Queue<Order> buyOrders,Queue<Order> sellOrders,TradeBoardElement tradeBoardElement) {
		Thread orderHandler=new Thread(new OrderHandler(buyOrders,sellOrders,tradeBoardElement));
		orderHandler.start();
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
