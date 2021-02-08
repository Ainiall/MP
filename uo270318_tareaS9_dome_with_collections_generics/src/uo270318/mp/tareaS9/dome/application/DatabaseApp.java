package uo270318.mp.tareaS9.dome.application;

import uo270318.mp.tareaS10.dome.exceptions.ItemNotInCollectionException;
import uo270318.mp.tareaS10.dome.exceptions.RepeatedElementException;
import uo270318.mp.tareaS9.dome.model.Book;
import uo270318.mp.tareaS9.dome.model.Cd;
import uo270318.mp.tareaS9.dome.model.Database;
import uo270318.mp.tareaS9.dome.model.Dvd;
import uo270318.mp.tareaS9.dome.model.Item;
import uo270318.mp.tareaS9.dome.model.PlatformEnum;
import uo270318.mp.tareaS9.dome.model.VideoGame;
import utils.Logger;

/**
 * <p>
 * Titulo: Clase DatabaseApp
 * </p>
 * <p>
 * Descripcion: Clase application que contiene el metodo main.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class DatabaseApp {
    public static void main(String[] args) {
	try {
	    new DatabaseApp().run();
	} catch (RepeatedElementException e) {
	   handler(e);
	} catch(ItemNotInCollectionException ie) {
	    handler(ie);
	}
    }

    private static void handler(Exception e) {
	System.out.print(e.getMessage()
		+ " .Pruebe a introducir el dato de nuevo.");
	Logger.log(e.getMessage());
    }

    private void run() throws RepeatedElementException, ItemNotInCollectionException {
	Database ddbb = new Database();
	Item cd =new Cd("Don't Smile at Me", "Billie Eilish", 9, 29, true);
	ddbb.add(cd);
	ddbb.add(new Cd("AM", "Arctic Monkeys", 12, 41, false));
	ddbb.add(new Cd(
		"Inside In/Inside Out",
		"The Kooks", 15, 41, false));
	ddbb.add(new Dvd("El viaje de Chihiro", "‎Hayao Miyazaki", 125));
	ddbb.add(new Dvd("Captain Fantastic", "Matt Ross", 118));
	ddbb.add(new Dvd("Whiplash", "Damien Chazelle", 106));
	ddbb.add(new VideoGame("God of War",
		"Sony Computer Entertainment America", 1,
		PlatformEnum.PLAYSTATION));
	ddbb.add(new VideoGame("Quantum Break", "Microsoft Studios", 1,
		PlatformEnum.XBOX));
	ddbb.add(new VideoGame("Super Smash Bros.Ultimate", "‎Nintendo", 8,
		PlatformEnum.NINTENDO));
	Item dvd = new Book("El imperio final", "Brandom Sanderson",
		"978-8466658898", "S.A. EDICIONES B", true);
	ddbb.add(dvd);
	ddbb.add(new Book("Camino de Reyes", "Brandom Sanderson",
		"978-8466647946", "S.A. EDICIONES B", false));
	ddbb.add(new Book("Hyperion", "Dan Simmons", "978-8498723069",
		"B DE BOLSILLO ", true));
	System.out.println(
		"Num items owned: " + ddbb.numberOfItemsOwned() + "\n");
	System.out.println("Responsables: ");
	ddbb.printResponsables(System.out);
	System.out.println("\nList: \n");
	ddbb.list(System.out);
	System.out.println("Total price: " + ddbb.totalValue());
	System.out.println(ddbb.generateCode());
	System.out.println(ddbb.generateCode());
	System.out.println("\nList Borrowables: \n");
	ddbb.listBorrowableItems(System.out);
	System.out.println("\nList Available to borrow: \n");
	ddbb.listAvailableItems(System.out); 
	ddbb.remove(cd);
    }
}
