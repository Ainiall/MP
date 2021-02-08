package uo.mp.file;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Una clase de utilizad para read/write líneas de caracteres de/a un fichero de
 * texto comprimido(.txt.gz)
 */
public class ZipFileUtil {

    /**
     * Metodo que carga una lista de caracteres desde un fichero comprimido
     * @param inFileName Nombre del fichero de entrada
     * @return res Lista de caracteres obtenidos
     * @throws FileNotFoundException Si no se encuentra el fichero
     * @throws IOException Si ocurre un error con el manejo del fichero
     */
    public List<String> loadFile(String inFileName)
	    throws FileNotFoundException {
	List<String> res = new LinkedList<String>();
	try {
	    BufferedReader in = new BufferedReader(new InputStreamReader(
		    new GZIPInputStream(new FileInputStream(inFileName))));

	    // mientras haya caracteres por leer
	    try {
		while (in.ready()) {
		    res.add(in.readLine());
		}
	    } finally {
		in.close();
	    }
	}catch (IOException ioe) {
	    throw new RuntimeException(ioe);
	}
	return res;
    }

    /**
     * Metodo que guarda una lista de caracteres a un archivo comprimido
     * @param outZippedFileName Archivo comprimido de salida
     * @param lines Lista de caracteres a insertar
     */
    public void saveToFile(String outZippedFileName, List<String> lines) {
	try {
	    // puede lanzar una ioexception en escritura asi que debe estar
	    // comprobado en el try
	    BufferedWriter out = new BufferedWriter(
		    new OutputStreamWriter(new GZIPOutputStream(
			    new FileOutputStream(outZippedFileName))));
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
