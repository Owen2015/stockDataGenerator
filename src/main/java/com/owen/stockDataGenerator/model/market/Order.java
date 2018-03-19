package com.owen.stockDataGenerator.model.market;



public class Order implements Comparable<Order>{

	private Long id;
	private Long stockId;
	private Long investorId;
	private Double price;
	private Long share;
	private Integer type;
	
	public static final Integer BUY=0;
	public static final Integer SELL=1;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStockId() {
		return stockId;
	}
	public void setStockId(Long stockId) {
		this.stockId = stockId;
	}
	public Long getInvestorId() {
		return investorId;
	}
	public void setInvestorId(Long investorId) {
		this.investorId = investorId;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Long getShare() {
		return share;
	}
	public void setShare(Long share) {
		this.share = share;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == null)
			return false;
		Order other = (Order) obj;
		try{
			if (this.getId() == null) {
				if (other.getId() != null)
					return false;
			} else if (this.getId().equals(other.getId())){
				return true;				
			}
		}catch(Exception e){
			System.out.println(e);
		}
		if (getClass() != obj.getClass())
			return false;
		return false;
	}
	public static void main(String[] args) {
		System.out.println(1+2/3D);
	}


	@Override
	public int compareTo(Order order) {
		// TODO Auto-generated method stub
		try{
		if(this.getPrice()<order.getPrice()) return -1;
		else if(this.getPrice()>order.getPrice()) return 1;
		else return 0;
		} catch(Exception e){
			System.out.println(e.toString());
		return (Integer) null;	
		}
	}

	
	
}
