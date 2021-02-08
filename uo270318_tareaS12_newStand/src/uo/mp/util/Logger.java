package uo.mp.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Una implementaci�n b�sica de Logger que simplemente env�a los mensajes de
 * error a la salida est�ndar de errores
 */
public class Logger {

    private static final String LOG_FILE = "lab11.log";
    private static final Boolean APPEND= true;
    
    private static PrintStream out;

    public static void log(String msg) {
	try {
	    out= new PrintStream(new FileOutputStream(LOG_FILE, APPEND));
	} catch (FileNotFoundException e) {
	  out= System.err;
	  log("El fichero no existe");
	}
	out.println(msg);
    }
    
    public static void close() {
	if(out!=System.err) {
	    out.close();
	}
    }
}
