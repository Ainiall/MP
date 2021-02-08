package uo.mp.ui;

import uo.mp.util.Console;

/**
 * Muestra un menu de opciones por pantalla Devuelve la opción elegida por el
 * usuario
 */
public class Menu {
    private String[] options = { "Cargar fichero", "Mostrar publicaciones",
	    "Añadir publicaión", "Eliminar publicación", "Crear peticiones",
	    "Grabar a fichero", "", "Importar de zip", "Exportar a zip",

    };

    public int readOption() {
	return Console.readInteger("Opción");
    }

    public void show() {
	int i = 1;
	for (String line : options) {
	    if ("".equals(line)) {
		Console.println("");
		continue;
	    }

	    Console.printf("\t%2d- %s\n", i++, line);
	}
	Console.printf("\n\t%2d- %s\n", 0, "Salir");
    }

}
