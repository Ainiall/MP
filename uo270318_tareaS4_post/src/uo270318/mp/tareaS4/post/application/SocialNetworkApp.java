package uo270318.mp.tareaS4.post.application;

import uo270318.mp.tareaS4.post.model.Message;
import uo270318.mp.tareaS4.post.model.Photo;
import uo270318.mp.tareaS4.post.model.Post;
import uo270318.mp.tareaS4.post.model.SocialNetwork;

/**
 * <p>
 * Titulo: Clase SocialNetworkApp
 * </p>
 * <p>
 * Descripcion: Clase application que contiene el metodo main.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * 
 * @author Angela Lopez UO270318
 * @version 1.0
 */
public class SocialNetworkApp {
    public static void main(String[] args) {
	new SocialNetworkApp().run();
    }

    public void run() {
	SocialNetwork sn = new SocialNetwork();

	// insertar post de cada tipo en 2 usuarios diferentes
	Post msg1 = new Message("Pepe", "Estoy practicando herencia");
	Post msg2 = new Message("Ana", "Hoy toca tarde de Netflix!");

	Post photo1 = new Photo("Pepe", "apuntes", "Herencia");
	Post photo2 = new Photo("Ana", "postureo", "Netflix");

	sn.add(msg1);
	sn.add(msg2);
	sn.add(photo1);
	sn.add(photo2);
	// busca e imprime los post de un usuario
	System.out.println("\nPOST DE PEPE:\n----------");
	for (Post post : sn.userPosts("Pepe")) {
	    System.out.println(post.toString());
	}
	System.out.println("\nPOST DE ANA:\n----------");
	for (Post post : sn.userPosts("Ana")) {
	    System.out.println(post.toString());
	}
	// imprimir todos los post
	System.out.println("\nTODOS LOS POST:\n----------");
	sn.printPost(System.out);
	//imrpime los post formateados a HTML siguiendo el patron indicado
	System.out.println("\nHTML:\n----------");
	String s = sn.htmlFormat().toString().replace(",", "\n");
	//espacio al principio para igualar el ident al output, meramente estetico
	s =" "+s.substring(1, s.length()-1);
	System.out.println(s);
    }
}
