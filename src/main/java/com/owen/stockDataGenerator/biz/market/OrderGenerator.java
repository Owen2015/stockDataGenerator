package com.owen.stockDataGenerator.biz.market;

import java.util.Queue;
import java.util.Random;

import com.owen.stockDataGenerator.model.market.Order;
import com.owen.stockDataGenerator.model.market.Stock;

public class OrderGenerator implements Runnable{

	private Queue<Order> orders;
	private Integer type;
	private Stock stock;

	public OrderGenerator(Queue<Order> orders,Integer type,Stock stock) {
		this.orders=orders;
		this.type=type;
		this.stock=stock;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r1=new Random();
		Random r2=new Random();
		Random investor=new Random();
		Random volume=new Random();
		while(true) {
			try {
			Double price=b2p(r2.nextBoolean())*stock.getPrice()*0.1*r1.nextDouble()+stock.getPrice();
			Order o1=new Order();
			o1.setInvestorId((long) investor.nextInt(5));
			o1.setStockId(stock.getId());
			o1.setShare((long) volume.nextInt( 200));
			o1.setPrice(price);
			o1.setType(type);
			o1.setStockName(stock.getName());
			orders.add(o1);
			Thread.sleep(1000L);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	// change from boolean to 1,-1
	private int b2p(boolean flag) {
		if(flag==true) return 1;
		else return -1;
	}
	
}
