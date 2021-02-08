package uo.mp.ui;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import uo.mp.exceptions.ApplicationException;
import uo.mp.newstand.NewStand;
import uo.mp.newstand.publication.Publication;
import uo.mp.util.Console;

/**
 * Resuelve la interacción de el usuario con el programa - Muestra el menú -
 * Procesa la operación elegida por el usuario - pide al usuario la información
 * necesaria para completar la opción
 * 
 * - muestra el resultado de la ejecución de la operación, o un mensaje de error
 * si no se pudo realizar
 */
public class UserInterface {
    private static final int EXIT = 0;

    private Menu menu = new Menu();
    private NewStand newStand = new NewStand();

    public void show() {
	int option = EXIT;
	do {
	    menu.show();
	    option = menu.readOption();
	    try {
		processOption(option);
	    } catch (ApplicationException ae) {
		handler(ae);
	    } catch (FileNotFoundException fnfe) {
		handler(fnfe);
	    }catch(IOException ioe) {
		handler(ioe);
	    }

	} while (option != EXIT);
    }

    private void processOption(int option)
	    throws ApplicationException, IOException {
	switch (option) {
	case EXIT:
	    return;
	case 1:
	    loadFile();
	    break;
	case 2:
	    showPublications();
	    break;
	case 3:
	    addPublication();
	    break;
	case 4:
	    removePublication();
	    break;
	case 5:
	    createOrders();
	    break;
	case 6:
	    saveToFile();
	    break;
	case 7:
	    importFromZip();
	    break;
	case 8:
	    exportToZip();
	    break;
	}
    }

    private void loadFile() throws ApplicationException, FileNotFoundException {
	String fileName = Console.readString("Nombre del fichero?");
	newStand.loadFile(fileName);
    }

    private void addPublication() throws ApplicationException {
	Publication p = new PublicForm().askForPublication();
	newStand.add(p);
    }

    private void removePublication() throws ApplicationException {
	String name = Console.readString("¿Nombre del producto?");
	newStand.remove(name);
    }

    private void showPublications() {
	List<Publication> publications = (List<Publication>) newStand
		.getPublications();
	listPublication(publications);
    }

    private void createOrders() {
	newStand.createOrders();
    }

    private void listPublication(List<Publication> publications) {
	Console.println("\nLista de productos");
	Console.println("------------------");
	for (Publication p : publications) {
	    System.out.println(p);
	}
	Console.println("------------------");
    }

    private void saveToFile() {
	String fileName = Console.readString("¿Nombre del fichero de salida?");
	newStand.saveToFile(fileName);
    }

    private void importFromZip()
	    throws FileNotFoundException, ApplicationException, IOException {
	String fileName = Console
		.readString("¿Nombre del fichero zip de entrada?");
	newStand.loadZipFile(fileName);
    }

    private void exportToZip() {
	String fileName = Console
		.readString("¿Nombre del fichero zip de salida?");
	newStand.saveToZipFile(fileName);

    }

    /**
     * Manejador por defecto que informa al usuario sobre el error ocurrido
     * 
     * @param e Excepcion
     */
    private void handler(Exception e) {
	Console.println("Se ha producido el siguiente error");
	Console.println(e.getMessage());
	Console.println("Por favor elija otra vez: ");
    }
}
