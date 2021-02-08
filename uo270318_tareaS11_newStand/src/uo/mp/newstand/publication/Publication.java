package uo.mp.newstand.publication;

import uo.mp.newstand.order.Order;

public abstract class Publication {
    public static int STOCK_TO_ORDER = 10;
    public static int LOWER_ZERO = 0;

    private String name;
    private int stock;
    private int sales;

    public Publication(String name, int stock, int sold) {
	setName(name);
	setStock(stock);
	setSales(sold);
    }

    private void setStock(int stock) {
	checkPositive(stock);
	this.stock = stock;
    }

    private void setName(String name) {
	checkName(name);
	this.name = name;

    }

    public void setSales(int sales) {
	checkPositive(sales);
	this.sales = sales;
    }

    public String getName() {
	return name;
    }

    public int getStock() {
	return stock;
    }

    public int getSales() {
	return sales;
    }

    public abstract Order getOrder();

    public String toString() {

	return getName() + "\t" + getStock() + "\t" + getSales();
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Publication other = (Publication) obj;
	if (name == null) {
	    if (other.name != null)
		return false;
	} else if (!name.equals(other.name))
	    return false;
	return true;
    }

    /**
     * Comprueba que la cadena exista y que no esté formada únicamente por
     * espacios en blanco
     * 
     * @param name Nombre del fichero
     */
    private void checkName(String name) {
	if (name == null)
	    throw new IllegalArgumentException("Cadena para nombre es null");
	if (name.trim().length() == 0)
	    throw new IllegalArgumentException("Cadena sin caracteres");
    }

    /**
     * Comprueba que el stock y sold no sean menor que cero
     * 
     * @param Stock
     * 
     */
    protected void checkPositive(int integer) {
	if (integer < LOWER_ZERO)
	    throw new IllegalArgumentException("No es válido el entero");
    }

}
