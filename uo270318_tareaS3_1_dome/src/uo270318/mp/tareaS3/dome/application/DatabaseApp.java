package uo270318.mp.tareaS3.dome.application;

import uo270318.mp.tareaS3.dome.model.Cd;
import uo270318.mp.tareaS3.dome.model.Database;
import uo270318.mp.tareaS3.dome.model.Dvd;
import uo270318.mp.tareaS3.dome.model.PlatformEnum;
import uo270318.mp.tareaS3.dome.model.VideoGame;

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
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class DatabaseApp {
    public static void main(String[] args) {
	new DatabaseApp().run();
    }

    private void run() {
	Database ddbb = new Database();
	ddbb.add(new Cd("Don't Smile at Me", "Billie Eilish", 9, 29));
	ddbb.add(new Cd("AM", "Arctic Monkeys", 12, 41));
	ddbb.add(new Cd("Inside In/Inside Out", "The Kooks", 15, 41));
	ddbb.add(new Dvd("El viaje de Chihiro", "‎Hayao Miyazaki", 125));
	ddbb.add(new Dvd("Captain Fantastic", "Matt Ross", 118));
	ddbb.add(new Dvd("Whiplash", "Damien Chazelle", 106));
	ddbb.add(new VideoGame("God of War",
		"Sony Computer Entertainment America", 1,
		PlatformEnum.PLAYSTATION));
	ddbb.add(new VideoGame("Quantum Break", "Microsoft Studios", 1,
		PlatformEnum.XBOX));
	ddbb.add(new VideoGame("Super Smash Bros.Ultimate", "‎Nintendo",
		8, PlatformEnum.NINTENDO));

	System.out.println(
		"Num items owned: " + ddbb.numberOfItemsOwned() + "\n");
	System.out.println("Responsables: ");
	ddbb.printResponsables(System.out);
	System.out.println("\nList: \n");
	ddbb.list(System.out);
    }
}
