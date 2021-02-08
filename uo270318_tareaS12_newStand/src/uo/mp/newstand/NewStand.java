package uo.mp.newstand;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import uo.mp.exceptions.ApplicationException;
import uo.mp.file.FileUtil;
import uo.mp.file.ZipFileUtil;
import uo.mp.newstand.order.Order;
import uo.mp.newstand.order.OrderSerializer;
import uo.mp.newstand.publication.Publication;
import uo.mp.newstand.publication.parser.PublicationParser;
import uo.mp.util.Logger;

public class NewStand {

    private List<Publication> publications = new LinkedList<Publication>();
    private List<Order> orders = new LinkedList<Order>();

    /**
     * Carga las publicaciones contenidas en el fichero especificado
     * 
     * @param inFileName Nombre del fichero
     * @throws ApplicationException Si se genera algun error logico
     * @throws FileNotFoundException Si no encuentra el fichero
     */
    public void loadFile(String inFileName)
	    throws ApplicationException, FileNotFoundException {
	checkFileName(inFileName);
	List<String> lines = new FileUtil().loadFile(inFileName);
	List<Publication> filePublications = new PublicationParser()
		.parse(lines);
	this.add(filePublications);

    }

    /**
     * Metodo que carga un archivo zip
     * 
     * @param inFileName Nombre del fichero
     * @throws ApplicationException Si se genera algun error logico
     * @throws IOException Si se genera algun error en el manejo del fichero comprimido
     * @throws FileNotFoundException Si no se encuentra el fichero
     */
    public void loadZipFile(String inFileName)
	    throws ApplicationException, FileNotFoundException, IOException {
	checkFileName(inFileName);
	List<String> lines = new ZipFileUtil().loadFile(inFileName);
	List<Publication> filePublications = new PublicationParser()
		.parse(lines);
	this.add(filePublications);

    }

    /**
     * Añade todas las publicaciones contenidas en la lista pasada como
     * parametro a la lista de publicaciones de NewStand. Ninguna publicaci�n
     * debe estar repetida. Si una publicacion de la lista pasada esta repetida
     * no ser� a�adida para evitar inconsistencias y se continua añadiendo las
     * siguientes.
     * 
     * @param newPublications la lista con las publicaciones obtenidas del
     * fichero
     * @throws ApplicationException Si hay erroes logicos
     */
    public void add(List<Publication> newPublications)
	    throws ApplicationException {
	for (Publication p : newPublications) {
	    this.addFromList(p);
	}
    }

    /**
     * Añade una publicacion a la lista si no esta repetida
     * 
     * @param p al publicacion a añadir
     * @throws ApplicationException Si hay errores logicos
     */
    public void add(Publication p) throws ApplicationException {
	checkRepeated(p);
	publications.add(p);
    }

    /**
     * Añade una publicacion obtenida de los datos del fichero a la lista de
     * NewStand. No puede haber publicaciones repetidas
     * 
     * @param p la publicacion a añadir
     */
    public void addFromList(Publication p) {
	// para recogerla de forma que se ignore la linea invalida y se continue
	// con la ejecucion del resto del fichero
	try {
	    checkRepeated(p);
	    publications.add(p);
	} catch (ApplicationException e) {
	    Logger.log("La publicacion " + p.getName()
		    + " esta repetida y no se inserta.");
	}

    }

    /**
     * Borra una publicacion que coincida con el nombre pasado como parametro de
     * la lista de publicaciones
     * 
     * @param name el nombre de la publicacion
     * @throws ApplicationException Si hay errores logicos
     */
    public void remove(String name) throws ApplicationException {
	int pos = searchByName(name);
	if (pos == -1) {
	    throw new ApplicationException(
		    "No se puede eliminar esa publicacion:" + name);
	}
	publications.remove(pos);
    }

    private int searchByName(String name) {
	for (int i = 0; i < publications.size(); i++) {
	    Publication p = publications.get(i);
	    if ((p.getName().equals(name)) /* compara los dos nombres */ )
		return i;
	}
	return -1;
    }

    /**
     * @return una copia de la lista privada de publicaciones
     */
    public List<Publication> getPublications() {
	// si se devuelve la lista original se obtiene la referencia y eso
	// podria ocasionar errores por modificaciones externas
	return new LinkedList<Publication>(publications);
    }

    /**
     * Genera la lista de pedidos a partir de la lista de publicaciones, los
     * pedidos se generan si el stock de la publicaciones < STOCK_TO_ORDER
     */
    public void createOrders() {
	for (Publication p : publications) {
	    if (p.getStock() < Publication.STOCK_TO_ORDER) {
		orders.add(p.getOrder());
	    }
	}
    }

    /**
     * Guarda en un fichero
     * 
     * @param outFileName Nombre del fichero
     */
    public void saveToFile(String outFileName) {
	List<String> lines = new OrderSerializer().serialize(orders);
	new FileUtil().saveToFile(outFileName, lines);
    }

    /**
     * Guarda en un zip
     * @param outFileName Fichero de salida
     */
    public void saveToZipFile(String outFileName) {
	List<String> lines = new OrderSerializer().serialize(orders);
	new ZipFileUtil().saveToFile(outFileName, lines);
    }
    
    /**
     * Metodo auxiliar que comprueba si hay alguna publicacion repetida
     * 
     * @param p Publicacion a comprobar
     * @throws ApplicationException Si la publicacion esta repetida
     */
    private void checkRepeated(Publication p) throws ApplicationException {
	if (publications.contains(p)) {
	    throw new ApplicationException("La publicacion esta repetida");
	}

    }

    /**
     * Metodo auxiliar que comprueba si el nombre tiene un tamaño valido
     * 
     * @param inFileName
     * @throws ApplicationException
     */
    private void checkFileName(String inFileName) throws ApplicationException {
	if (inFileName.length() < 5) {
	    throw new ApplicationException(
		    "El nombre del fichero es demasiado corto.");
	}
    }


    /**
     * Metodo auxiliar que devuelve la lista de pedidos
     * 
     * @return orders Lista de pedidos
     */
    public List<Order> getOrders() {
	return orders;
    }

}
