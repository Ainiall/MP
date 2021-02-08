package uo.mp.newstand.publication;

import uo.mp.newstand.order.Order;

public class Newspaper extends Publication {

    public Newspaper(String name, int stock, int sales) {
	super(name, stock, sales);
    }

    @Override
    public Order getOrder() {
	return new Order(getName(), getSales() + (getStock() * 2));
    }
}
