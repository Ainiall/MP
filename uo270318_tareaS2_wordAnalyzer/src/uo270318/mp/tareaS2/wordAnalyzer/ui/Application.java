package uo270318.mp.tareaS2.wordAnalyzer.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import uo270318.mp.tareaS2.wordAnalyzer.model.WordAnalyzer;


/**
 * <p>
 * T�tulo: Clase Application
 * </p>
 * <p>
 * Descripci�n: Clase que muestra diferentes operaciones con cadenas de caracteres.
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * @author �ngela L�pez UO270318
 * @version 1.0
 */

public class Application {
	
	/**
	 * El m�todo main
	 * @param args No es usado
	 */
	public static void main(String[] args){
		new Application().run();
	}
	
	/**
	 * Pide una palabra al usuario y la analiza
	 */
	private void run() {
		System.out.print("Escribe una palabra: ");
		String word = readString();
		WordAnalyzer analyzer = new WordAnalyzer(word);
		System.out.println("Primer car�cter repetido: " + analyzer.firstRepeatedCharacter());
		System.out.println("Primer car�cter m�ltiple: " + analyzer.firstMultipleCharacter());
		System.out.println("Grupos de caracteres repetidos: " + analyzer.countGroupsOfRepeatedCharacters());

		System.out.println();
		System.out.println("Primer car�cter m�ltiple en \"pollo\": " +
				new WordAnalyzer("pollo").firstMultipleCharacter());
		System.out.println("Grupos de caracteres repetidos en \"aabbcdaaaabb\": " +
				new WordAnalyzer("aabbcdaaaabb").countGroupsOfRepeatedCharacters());
		System.out.print("Primer car�cter repetido en \"antes\": ");
		System.out.println(new WordAnalyzer("antes").firstRepeatedCharacter());		
	}
	
	/**
	 * Lee un string de la consola.
	 * Este codigo NO DEBE ENTERDERSE AHORA se ver� m�s adelante (tema 7).
	 * @return El string escrito por el usuario
	 */
	private String readString() {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String str = null;
		try {
			str = br.readLine();
		}catch(IOException e) {
			System.err.println("Error reading the string.");
			System.exit(1);
		}
		return str;
	}

}