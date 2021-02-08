package uo270318.mp.tareaS9.collections_iterators.generics.model;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public abstract class ListTest {

    @SuppressWarnings("rawtypes")
    private List list;

    public ListTest() {
	super();
    }

    @Before
    public void setUp() {
	list = createList();
    }

    @SuppressWarnings("rawtypes")
    protected abstract List createList();

    @SuppressWarnings("unchecked")
    @Test
    public void testSize() {
	// caso 1 lista vacia
	assertEquals(0, list.size());
	// caso 2 lista no vacia
	list.add(1);
	list.add("hola");
	assertNotEquals(0, list.size());
	assertEquals(2, list.size());
	// caso 3 lista con un elemento (se borra 1)
	list.remove(0);
	assertEquals(1, list.size());
	// caso 4 lista con 0 elementos
	list.remove(0);
	assertEquals(0, list.size());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testIsEmpty() {
	// lista vacia
	assertTrue(list.isEmpty());
	// lista no vacia, devuelve falso
	list.add("hola");
	assertFalse(list.isEmpty());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testContains() {
	// lista vacia
	assertFalse(list.contains(null));
	// lista no vacia que no contiene el elemento
	list.add(1);
	list.add(2);
	assertFalse(list.contains(5));
	// lista no vacia que contiene el elemento
	assertTrue(list.contains(2));
	list.add(null);
	list.add(7);
	assertEquals(4, list.size());
	// lista con elemento repetido
	list.add(7);
	assertTrue(list.contains(7));

    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddObject() {
	// caso 1 insertar en coleccion vacia
	list.add("hi");
	assertEquals("hi", list.get(0));
	assertEquals(1, list.size());
	assertEquals("[hi]", list.toString());
	// caso 2 insertar al principio
	list.add(0, "say");
	assertEquals("say", list.get(0));
	assertEquals(2, list.size());
	assertEquals("[say, hi]", list.toString());
	// caso 3 insertar al final
	list.add("world");
	assertEquals("world", list.get(2));
	assertEquals(3, list.size());
	assertEquals("[say, hi, world]", list.toString());
	// caso 4 insertar en el medio
	list.add(2, "hello");
	assertEquals("hello", list.get(2));
	assertEquals(4, list.size());
	assertEquals("[say, hi, hello, world]", list.toString());
	// caso 5 insertar null
	list.add(0, null);
	assertEquals(null, list.get(0));
	assertEquals(5, list.size());
	assertEquals("[null, say, hi, hello, world]", list.toString());
	// caso 6 insertar elemento repetido
	list.add(null);
	assertEquals(null, list.get(5));
	assertEquals(6, list.size());
	assertEquals("[null, say, hi, hello, world, null]", list.toString());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testRemoveObject() {
	// caso 1 borrar en coleccion vacia
	list.remove("hi");
	assertEquals(0, list.size());
	assertFalse(list.remove("hi"));

	list.add("1");
	list.add("2");
	list.add("3");
	list.add("4");
	// caso 2 borrar al principio
	list.remove("1");
	assertEquals("2", list.get(0));
	assertEquals(3, list.size());
	assertEquals("[2, 3, 4]", list.toString());
	// caso 3 borrar al final
	list.remove("4");
	assertEquals("3", list.get(list.size() - 1));
	assertEquals(2, list.size());
	assertEquals("[2, 3]", list.toString());
	// caso 4 borrar en el medio
	list.add("5");
	list.remove("3");
	assertEquals("[2, 5]", list.toString());
	// caso 5 borrar null
	list.add(0, null);
	list.remove(null);
	assertEquals("2", list.get(0));
	assertEquals(2, list.size());
	assertEquals("[2, 5]", list.toString());
	// caso 6 borrar elemento repetido
	list.add("6");
	list.add("5");
	list.remove("5");
	assertEquals("6", list.get(1));
	assertEquals(3, list.size());
	assertEquals("[2, 6, 5]", list.toString());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testAddIntObject() {
	//por posicion
	list.add(0, 1);
	list.add(1, 2);
	list.add(1, 3);
	list.add(3, 4);
	list.add(2, 5);
	assertEquals(5, list.size());
	assertEquals("[1, 3, 5, 2, 4]", list.toString());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testRemoveInt() {
	//por posicion
	list.add(0, 1);
	list.add(1, 2);
	list.add(1, 3);
	list.add(3, 4);
	list.add(2, 5);
	assertEquals(5, list.size());
	assertEquals("[1, 3, 5, 2, 4]", list.toString());
	assertEquals(3, list.remove(1));
	assertEquals(2, list.remove(2));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testClear() {
	//lista vacia
	list.clear();
	assertEquals(0, list.size());
	assertTrue(list.isEmpty());
	//lista no vacia
	list.add(1);
	list.add(2);
	list.add(3);
	list.clear();
	assertEquals(0, list.size());
	assertTrue(list.isEmpty());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testIndexOf() {
	// lista vacia
	assertEquals(-1, list.indexOf(null));
	// lista no vacia que no contiene el elemento
	list.add(1);
	assertEquals(-1, list.indexOf(null));
	// lista no vacia que contiene el elemento
	list.add(2);
	list.add(3);
	assertEquals(2, list.indexOf(3));
	// lista no vacia con null
	list.add(null);
	assertEquals(3, list.indexOf(null));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testGet() {
	//lista no vacia
	list.add("hola");
	assertEquals("hola",list.get(0));
	//lista no vacia con mas de un objeto
	list.add("mundo");
	assertEquals("mundo",list.get(1));
	//lista no vacia con null
	list.add(null);
	assertEquals(null,list.get(2));
	}

    @SuppressWarnings("unchecked")
    @Test
    public void testSet() {
	//lista no vacia
	list.add("hola");
	assertEquals("hola",list.get(0));
	list.add("mundo");
	assertEquals("mundo",list.get(1));
	list.add(null);
	assertEquals(null,list.get(2));
	list.set(0, "hi");
	assertEquals("hi",list.get(0));
	}
    
    @Test
    public void testListIsEmptyWhenCreated() {
	assertEquals(0, list.size());
	assertTrue(list.isEmpty());
    }

    @Test
    public void testToStringEmpty() {
	assertEquals("[]", list.toString());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testToStringInteger() {
	list.add(1);
	list.add(2);
	list.add(3);
	list.add(4);
	assertEquals("[1, 2, 3, 4]", list.toString());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testToStringString() {
	list.add("testing");
	list.add("with");
	list.add("the");
	list.add("JUnit");
	list.add("framework");
	assertEquals("[testing, with, the, JUnit, framework]", list.toString());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testEquals() {
	// vacias iguales
	@SuppressWarnings("rawtypes")
	List list2 = new LinkedList();
	assertTrue(list.equals(list2));
	// con elementos distintos
	list.add("primero");
	assertFalse(list.equals(list2));
	// con elementos iguales
	list2.add("primero");
	assertTrue(list.equals(list2));
	// comprarar objetos de distinto tipo
	assertFalse(list.equals(3));
	//listas con elementos iguales en distinto orden
	list2.add("segundo");
	list2.add("tercero");
	list.add("tercero");
	list.add("segundo");
	assertFalse(list.equals(list2));
	//lista con elementos distintos
	list.add("jeje");
	list2.add("jaja");
	assertFalse(list.equals(list2));
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testIterator() {
	list.add("1");
	list.add("2");
	list.add("3");
	@SuppressWarnings("rawtypes")
	Iterator i = list.iterator();
	while(i.hasNext()) {
	    if(i.next().equals("1")) {
		i.remove();
		assertEquals("2",list.get(0));
	    }
	    if(i.next().equals("2")) {
		assertEquals("3",i.next());	
	    }
	}
	
    }
    @SuppressWarnings("unchecked")
    @Test
    public void testAddOutOfBounds() {
	try {
	    list.remove(-10);
	    fail("Se esperaba un IndexOutOfBoundsException");
	} catch (IndexOutOfBoundsException iobe) {
	    assertEquals("Invalid index", iobe.getMessage());
	}
	try {
	    list.set(-3, 7);
	    fail("Se esperaba un IndexOutOfBoundsException");
	} catch (IndexOutOfBoundsException iobe) {
	    assertEquals("Invalid index", iobe.getMessage());
	}
	try {
	    list.get(-1);
	    fail("Se esperaba un IndexOutOfBoundsException");
	} catch (IndexOutOfBoundsException iobe) {
	    assertEquals("Invalid index", iobe.getMessage());
	}

	try {
	    list.add(-1, "a");
	    fail("Se esperaba un IndexOutOfBoundsException");
	} catch (IndexOutOfBoundsException iobe) {
	    assertEquals("Invalid index", iobe.getMessage());
	}

	try {
	    list.add(list.size() + 1, "a");
	    fail("Se esperaba un IndexOutOfBoundsException");
	} catch (IndexOutOfBoundsException iobe) {
	    assertEquals("Invalid index", iobe.getMessage());
	}
    }

    @SuppressWarnings("unchecked")
    @Test(expected = IndexOutOfBoundsException.class)
    public void testAddOutOfBounds2() {
	list.add(-1, "a");
    }

}