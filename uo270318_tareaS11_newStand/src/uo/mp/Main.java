package uo.mp;

import uo.mp.ui.UserInterface;
import uo.mp.util.Console;
import uo.mp.util.Logger;

public class Main {

    public static void main(String[] args) {
	new Main().run();
    }

    private void run() {
	try {
	    new UserInterface().show();
	} catch (RuntimeException e) {
	    handlerDefaultRuntimeException(e);
	} catch (Exception e) {
	    handlerDefaultException(e);
	}

    }

    
    /**
     * Metodo que maneja las excepciones en ultima instancia. 
     * @param e Excepcion
     */
    private void handlerDefaultException(Exception e) {
	Console.println(
		"Debido a algunos problemas tecnicos, el programa ha tenido errores.");
	Console.println(e.getMessage());
    }

    private void handlerDefaultRuntimeException(RuntimeException rte) {
	Console.println(
		"Debido a algunos errores del sistema, el programa no puede continuar.");
	Console.println("Por favor pongase en contacto con el personal tecnico.");
	Logger.log(rte.getMessage());
    }

}
