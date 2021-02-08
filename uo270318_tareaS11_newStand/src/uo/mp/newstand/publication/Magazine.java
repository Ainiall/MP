package uo.mp.newstand.publication;

import uo.mp.newstand.order.Order;

public class Magazine extends Publication {
		
	public static int WEEK = 7;
	public static int MIN_STOCK = 5;
	public static int MIN_ORDER = 20;
	private int regularity;
	
	public Magazine(String name, int stock, int sales, int regularity){
		super (name, stock, sales);
		checkPositive(regularity);
		setRegularity(regularity);
	}

	private void setRegularity(int regularity) {
		this.regularity = regularity;
		
	}

	public int getRegularity() {
		return regularity;
	}	

	@Override
	public Order getOrder() {

		if (getStock() < MIN_STOCK)
			return new Order(this.getName(), MIN_ORDER);
		else {
			if (getRegularity() == WEEK)
				return new Order(this.getName(), getSales());
			else
				return new Order(this.getName(), getSales() + getStock());
		}
	}
	
	public String toString() {
		return super.toString() + "\t" + getRegularity();
	}
	
	
	

}
