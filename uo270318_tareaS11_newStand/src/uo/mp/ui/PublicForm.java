package uo.mp.ui;

import uo.mp.exceptions.ApplicationException;
import uo.mp.newstand.publication.Magazine;
import uo.mp.newstand.publication.Newspaper;
import uo.mp.newstand.publication.Publication;
import uo.mp.util.Console;

/**
 * Pide al usuario todos los datos para crear un objeto Publication
 */
public class PublicForm {

    /**
     * @return El objeto publicación creado a partir de los datos proporcionados
     * por el usuario
     * @throws ApplicationException Si hay errores logicos
     */
    public Publication askForPublication() throws ApplicationException {
	String type = Console
		.readString("¿Tipo de publicación? (periodico | revista)");
	switch (type) {
	case "periodico":
	    return askForNewspaper();
	case "revista":
	    return askForMagazine();
	default:
	    throw new ApplicationException(
		    "Tipo de publicacion invaildo. Pruebe otra vez");
	}

    }

    private Publication askForMagazine() {

	String name = Console.readString("¿Nombre?");
	int stock = Console.readInteger("¿Stock?");
	int sales = Console.readInteger("¿Vendidos?");
	int regularity = Console.readInteger("¿Regularidad?");

	return new Magazine(name, stock, sales, regularity);
    }

    private Publication askForNewspaper() {
	String name = Console.readString("¿Nombre?");
	int stock = Console.readInteger("¿Stock?");
	int sales = Console.readInteger("¿Vendidos?");

	return new Newspaper(name, stock, sales);
    }

}
