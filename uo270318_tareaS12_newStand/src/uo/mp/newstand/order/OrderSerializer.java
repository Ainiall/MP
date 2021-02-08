package uo.mp.newstand.order;

import java.util.LinkedList;
import java.util.List;

public class OrderSerializer {

    /**
     * Devuelve una lista de String a partir de una lista de pedidos
     * 
     * @param orders la lista de pedidos
     * @return lines Lista de caracteres serializados
     */
    public List<String> serialize(List<Order> orders) {
	List<String> lines = new LinkedList<String>();
	for (Order o : orders) {
	    lines.add(o.serialize());
	}
	return lines;
    }

}
