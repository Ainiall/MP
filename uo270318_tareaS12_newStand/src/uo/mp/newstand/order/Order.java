package uo.mp.newstand.order;

public class Order {
	private String name;
	private int items;
	
	public Order(String name, int items){
		setName(name);
		setItems(items);
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	public int getItems() {
		return items;
	}

	private void setItems(int items) {
		this.items = items;
	}
	
	public String toString(){
		return "Petición " + getName() + "\t" + getItems();
	}
	
	public String serialize(){
		return  getName() + "\t" + getItems();
	}
	

}
