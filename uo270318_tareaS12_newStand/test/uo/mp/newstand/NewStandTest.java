package uo.mp.newstand;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import uo.mp.exceptions.ApplicationException;
import uo.mp.newstand.publication.Magazine;
import uo.mp.newstand.publication.Newspaper;
import uo.mp.newstand.publication.Publication;

public class NewStandTest {

    NewStand n;
    List<Publication> list;

    @Before
    public void setUp() throws Exception {
	n = new NewStand();
	list = new LinkedList<Publication>();
    }

    @Test
    public void testCreateOrders() throws ApplicationException {
	list.add(new Newspaper("Nueva España", 6, 30));
	list.add(new Newspaper("El Mundo", 37, 10));
	list.add(new Magazine("Cosmopolitan", 4, 30, 7));
	list.add(new Magazine("Rolling Stone", 7, 30, 7));

	n.add(list);

	n.createOrders();
	// pedidos con stock por debajo de 10: se pide nuevo stock
	System.out.println(n.getOrders());
	// revistas:Si el stock es menor que 5 se piden 20 ejemplares. Si es
	// mayor o igual que 5, dependerá de la periodicidad. Si es semanal, se
	// piden tantos ejemplares como los vendidos y en otro caso, se piden
	// tantos como los vendidos más los ejemplares en stock

	assertEquals(20, n.getOrders().get(1).getItems());
	assertEquals(30, n.getOrders().get(2).getItems());
	// periodico: Se piden tantos ejemplares como los vendidos más el doble
	// de los ejemplares en stock.
	assertEquals(42, n.getOrders().get(0).getItems());
	// pedidos con stock mayor de 10: no se pide nuevo stock
	assertFalse(n.getOrders().size() == 4);
    }

    @Test
    public void testLoadFile()
	    throws FileNotFoundException, ApplicationException {
	// caso valido: todos los elementos son correctos
	n.loadFile("publicaciones.txt");
	assertEquals(8, n.getPublications().size());
    }

    @Test
    public void testLoadBlankLineFile()
	    throws FileNotFoundException, ApplicationException {
	// caso invalido: publicaciones con linea en blanco
	n.loadFile("publicacionesConLineaBlanco.txt");
	assertEquals(8, n.getPublications().size());
    }

    @Test
    public void testLoadWrongNumberFormatFile()
	    throws FileNotFoundException, ApplicationException {
	// caso invalido: publicaciones con un formato de numeros erroneo
	n.loadFile("publicacionesConNumeroErroneo.txt");
	assertEquals(6, n.getPublications().size());
    }

    @Test
    public void testLoadInvalidTypeFile() throws FileNotFoundException, ApplicationException {
	 // caso invalido: publicaciones con un tipo desconocido
	n.loadFile("publicacionesConTipoDesconocido.txt");
	assertEquals(6, n.getPublications().size());
    }

    @Test
    public void testLoadInvalidDataFieldsFile() throws FileNotFoundException, ApplicationException {
	// caso invalido: publicaciones con un nuero erroneo de datos
	n.loadFile("publicacionesNumeroErroneoDatos.txt");
	assertEquals(6, n.getPublications().size());
    }

    @Test
    public void loadZipFile()
	    throws FileNotFoundException, ApplicationException, IOException {
	//carga datos desde un fichero comprimido
	n.loadZipFile("publicaciones.gz");
	assertEquals(8, n.getPublications().size());
    }
    
    
    @Test
    public void loadUnexistingZipFile(){
	//carga datos desde un fichero comprimido que no existe
	try {
	    n.loadZipFile("publications.gz");
	    fail("Deberia fallar");
	} catch (FileNotFoundException e) {
	   
	    e.printStackTrace();
	} catch (ApplicationException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	assertEquals(0, n.getPublications().size());
    }
}
