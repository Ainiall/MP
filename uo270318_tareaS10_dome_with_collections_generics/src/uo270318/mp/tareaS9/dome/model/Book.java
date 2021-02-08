package uo270318.mp.tareaS9.dome.model;

import java.io.PrintStream;

/**
 * <p>
 * Titulo: Clase Book
 * </p>
 * <p>
 * Descripcion: Clase que contiene la informacion sobre los item Book.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class Book extends Item implements Borrowable {
    private String author;
    private String ISBN;
    private String editorial;
    private boolean available;

    /**
     * Constructor con parametros.
     * 
     * @param title     Titulo
     * @param author    Autor
     * @param ISBN      Codigo ISBN
     * @param editorial Editorial
     * @param available Disponible para ser prestado
     */
    public Book(String title, String author, String ISBN, String editorial,
	    boolean available) {
	super(title, false, "", 0.0);
	setAuthor(author);
	setISBN(ISBN);
	setEditorial(editorial);
	setAvailable(available);
    }

    /**
     * Metodo que asigna el autor a un libro.
     * 
     * @param author Autor del libro.
     */
    protected void setAuthor(String author) {
	super.assertParamString(author);
	this.author = author;
    }

    /**
     * Metodo que devuelve el autor del libro.
     * 
     * @return author Autor del libro.
     */
    protected String getAuthor() {
	return author;
    }

    /**
     * Metodo que asigna el ISBN del libro.
     * 
     * @param ISBN Codigo ISBN del libro.
     */
    protected void setISBN(String ISBN) {
	checkISBN(ISBN);
    }

    /**
     * Metodo que devuelve el ISBN del libro.
     * 
     * @return ISBN Codigo ISBN del libro.
     */
    protected String getISBN() {
	return ISBN;
    }

    /**
     * Metodo que asigna la editorial al libro.
     * 
     * @param editorial Editorial del libro.
     */
    protected void setEditorial(String editorial) {
	super.assertParamString(editorial);
	this.editorial = editorial;
    }

    /**
     * Metofo que devuelve la editorial del libro.
     * 
     * @return editorial Editorial del libro.
     */
    protected String getEditorial() {
	return editorial;
    }

    /**
     * Metodo que asigna si un libro esta disponible para ser prestado.
     * 
     * @param available True para identificar que esta disponible para ser
     *                  prestado, false en caso contrario.
     */
    protected void setAvailable(boolean available) {
	this.available = available;
    }

    /**
     * Metodo que devuelve si un libro esta disponible para ser prestado.
     * 
     * @return available True si el libro esta disponible para ser prestado,
     *         false en caso contrario.
     */
    protected boolean getAvailable() {
	return available;
    }

    /**
     * Metodo que imprime el responsable del libro.
     */
    @Override
    public void printResponsables(PrintStream out) {
	out.println("El responsable del libro " + this.getTitle() + " es: "
		+ this.getAuthor());
    }

    /**
     * Metodo que devuelve el precio base del libro.
     */
    @Override
    protected double itemValue() {
	return this.getBasePrice();
    }

    /**
     * Metodo que imprime toda la informacion del libro.
     */
    @Override
    public String toString() {
	StringBuilder str = new StringBuilder();
	str.append("BOOK: ");
	str.append(super.toString());
	str.append("\nAuthor: ").append(getAuthor());
	str.append("\nISBN: ").append(getISBN());
	str.append("\nEditorial: ").append(getEditorial());
	return str.toString();
    }

    /**
     * Metodo que compara si dos libros son iguales por titulo y artista
     */
    @Override
    public boolean equals(Object theItem) {
	if (!(theItem instanceof Book)) {
	    return false;
	}
	if (this == theItem) {
	    return true;
	}
	Book book = (Book) theItem;
	return (this.getTitle().equals(book.getTitle())
		&& this.getISBN().equals(book.getISBN()));
    }

    /**
     * Metodo que comprueba si un libro puede ser prestado.
     * 
     */
    @Override
    public boolean isAvailableItem() {
	if (getOwn() && getAvailable()) {
	    return true;
	}
	return false;
    }

    /**
     * Metodo que presta un libro.
     */
    @Override
    public boolean borrowed() {
	setAvailable(false);
	return true;
    }

    /**
     * Metodo que devuelve un libro
     */
    @Override
    public boolean returned() {
	setAvailable(true);
	return true;
    }

    /**
     * Metodo auxiliar que comprueba si el ISBN introducido es correcto.
     * 
     * @param isbn ISBN a validar.
     * @throws IllegalArgumentException si el parametro introducido no es
     *                                  valido.
     */
    private void checkISBN(String isbn) {
	super.assertParamString(isbn);
	if (isbn.length() == 14) {
	    if (isbn.substring(3, 4).equals("-")) {
		if (isbn.substring(0, 2).matches("[0-9]*")
			&& isbn.substring(4, 14).matches("[0-9]*")) {
		    this.ISBN = isbn;
		}
	    }
	} else {
	    throw new IllegalArgumentException("ISBN invalido");
	}
    }

}
