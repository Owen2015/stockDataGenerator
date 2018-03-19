package com.owen.stockDataGenerator.biz.market;

import java.util.Queue;
import java.util.Random;

import com.owen.stockDataGenerator.model.market.Order;

public class OrderGenerator implements Runnable{

	private Queue<Order> orders;
	private Integer type;

	public OrderGenerator(Queue<Order> orders,Integer type) {
		this.orders=orders;
		this.type=type;
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Random r1=new Random();
		Random r2=new Random();
		Random investor=new Random();
		while(true) {
			try {
			Double price=b2p(r2.nextBoolean())*20*r1.nextDouble()+200D;
			Order o1=new Order();
			o1.setInvestorId((long) investor.nextInt(5));
			o1.setStockId(0L);
			o1.setShare(100L);
			o1.setPrice(price);
			o1.setType(type);
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
