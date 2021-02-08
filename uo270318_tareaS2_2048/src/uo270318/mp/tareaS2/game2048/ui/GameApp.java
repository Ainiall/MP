package uo270318.mp.tareaS2.game2048.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo270318.mp.tareaS2.game2048.model.Game2048;

/**
 * <p>
 * Título: Clase principal
 * </p>
 * <p>
 * Descripción: 2048 es un juego en línea creado por Gabriele Cirulli. El
 * objetivo del juego es combinar números juntos (potencias de 2) con el fin de
 * alcanzar el máximo número 2048 y ganar el juego. Para mover los números en el
 * tablero, se debe elegir una dirección (arriba, derecha, abajo o izquierda).
 * Todos los números se mueven en la dirección elegida y pueden ocurrir dos
 * cosas: los números se juntan en una celda que tiene el mismo número o son
 * bloqueados si una celda contiene un número diferente.
 * 
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * <p>
 * Empresa: Escuela de Ingeniería Informática - Universidad de Oviedo
 * </p>
 * 
 * @author Ángela López UO270318
 * @version pre-alpha
 */

public class GameApp {
	private Game2048 game;

	public static void main(String[] args) {
		new GameApp().run();
	}

	public void run() {

		game = new Game2048();		
		do {
			System.out.print("JUEGO 2048\n");
			System.out.println(game.toString()); //imprime por consola
			game.restart();
			do {
				System.out.print("Mueve los números en una dirección [r R]/[l L]/[u U]/[d D]: ");
				switch (readCharacter()) {
				case 'r':	
				case 'R':
					//game.compactRight();
					game.moveRight();
					game.next();
					break;
				case 'l':
				case 'L':
					//game.compactLeft();
					game.moveLeft();
					game.next();
					break;
				case 'u':
				case 'U':
					//game.compactUp();
					game.moveUp();
					game.next();
					break;
				case 'd':
				case 'D':
					//game.compactDown();
					game.moveDown();;
					game.next();
					break;
				}
			System.out.println(game.toString()); //imprime por consola

			} while (!game.isBoardFull());
			
			System.out.println("GAME OVER");
			System.out.print("¿Quieres continuar? s/n: ");
		} while (readCharacter() == 's');
	}

	/**
	 * Lee un caracter de la entrada estandar (normalmente el teclado)
	 * 
	 * @return El caracter (en formato numérico) tecleado por el usuario.
	 */
	private int readCharacter() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int character = 0;
		try {
			character = br.read();
		} catch (IOException e) {
			System.out.println("¡Error de lectura en la entrada de datos!");
			System.exit(0);
		}
		return character;
	}
	
}
