package uo.mp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Una clase de utilidad para read/write lineas de caracteres de/a un fichero de
 * texto
 */
public class FileUtil {

    /**
     * Metodo que carga una lista de caracteres desde un fichero
     * @param inFileName Fichero de entrada
     * @return res Lista de caracteres
     * @throws FileNotFoundException Si no encuentra el fichero
     */
    public List<String> loadFile(String inFileName)
	    throws FileNotFoundException {
	List<String> res = new LinkedList<String>();
	BufferedReader in = new BufferedReader(new FileReader(inFileName));
	// mientras haya caracteres por leer
	try {
	    try {
		while (in.ready()) {
		    res.add(in.readLine());
		}
	    } finally {
		in.close();
	    }
	} catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}
	return res;
    }

    /**
     * Metodo que guarda una lista de caracteres a un fichero
     * @param outFileName Fichero de salida
     * @param lines Lista de caracteres a insertar en el fichero
     */
    public void saveToFile(String outFileName, List<String> lines) {

	try {
	    // puede lanzar una ioexception en escritura asi que debe estar
	    // comprobado en el try
	    BufferedWriter out = new BufferedWriter(
		    new FileWriter(outFileName));
	    try {
		for (String l : lines) {
		    out.write(l);
		    out.newLine();
		}
	    } finally {
		out.close();
	    }
	} catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}
    }

}
