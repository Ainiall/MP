package uo270318.mp.tareaS3.post.model;

import static org.junit.Assert.*;

import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

/**
 * <p>
 * Titulo: Clase SocialNetworkTest
 * </p>
 * <p>
 * Descripcion: En esta clase se realizan pruebas unitarias referidas a la clase
 * SocialNetwork.java {@link uo270318.mp.tareaS3.post.model.SocialNetwork}
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */

public class SocialNetworkTest {
    private SocialNetwork sn;
    private SocialNetwork empty;
    private Post msg1;
    private Post photo1;
    private Post msg2;
    private Post photo2;
    private Post error;

    @Before
    public void setUp() {
	sn = new SocialNetwork();
	empty = new SocialNetwork();
	msg1 = new Message("user1", "msg1");
	photo1 = new Photo("user1", "path1", "title1");
	msg2 = new Message("user2", "msg2");
	photo2 = new Photo("user2", "path2", "title2");
	sn.add(msg1);
	sn.add(photo1);
	sn.add(msg2);
	sn.add(photo2);
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.SocialNetwork#add(Post post)}.
     */
    @Test
    public void testAdd() {
	// Inserto valido
	sn.add(new Photo("user3", "path3", "title3"));
	sn.add(new Message("user3", "msg3"));
	// Inserto elemento repetido
	sn.add(photo1);
	// Inserto invalido en coleccion no vacia
	try {
	    sn.add(error);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}
	// Inserto invalido en coleccion vacia
	try {
	    empty.add(error);
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("El parametro es null", iae.getMessage());
	}
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.SocialNetwork#printPost(PrintStream out)}.
     */
    @Test
    public void testPrintPost() {
	System.out.println("PRINT POSTS:\n-----------");
	sn.printPost(System.out);
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS3.post.model.SocialNetwork#userPosts(String userID)}.
     */
    @Test
    public void testUserPosts() {
	System.out.println("PRINT USER POSTS:\n-----------");
	//Usuario valido
	for (Post post : sn.userPosts("user1")) {
	    post.print(System.out);
	}
	//Usuario invalido
	try {
	    sn.userPosts("   ");
	    fail("Deberia lanzar una excepcion");
	} catch (IllegalArgumentException iae) {
	    assertEquals("La cadena es incorrecta", iae.getMessage());
	}
    }
}
