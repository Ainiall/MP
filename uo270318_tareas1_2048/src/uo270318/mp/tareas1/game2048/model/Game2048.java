package uo270318.mp.tareas1.game2048.model;

import java.util.Random;

/**
 * <p>
 * Título: Clase Game2048
 * </p>
 * <p>
 * Descripción: A partir de un array bidimensional de números y a través de
 * diferentes operaciones se simula un juego llamado "2048".
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * <p>
 * Empresa: Escuela de Ingeniería Informática - Uiversidad de Oviedo
 * </p>
 * 
 * @author Ángela López UO270318
 * @version pre-alpha
 */
public class Game2048 {
	public static final int MIN_DIMENSION = 3;
	public static final int MAX_DIMENSION = 10;
	public static final int EMPTY = 0;

	private int[][] board;

	/**
	 * Constructor sin parámetros con tablero por defecto de 3*3. Inicialmente todas
	 * las posiciones con valor 0.
	 */
	public Game2048() {
		// Inicializamos el tablero con una dimensión 3x3 por defecto
		board = new int[MIN_DIMENSION][MIN_DIMENSION];
		// Los array de enteros se inicializan a 0 por defecto.
		restart();
	}

	/**
	 * Constructor que inicializa el tablero con una dimension determinada que se le
	 * pasa como parámetro de tipo entero.
	 * 
	 * @param dimension número de filas y de columnas (matriz cuadrada) entre minimo y máximo
	 */

	public Game2048(int dimension) {
		// Inicialización del tablero con dimension columnas y fila, mientras
		// el parametro dimension se encuentre dentro del rango permitido
		// tendrá el valor dimension, si se excede se inicializa por defecto
		// a 3x3.
		if (dimension < MIN_DIMENSION || dimension > MAX_DIMENSION)
			new Game2048();
		else {
			board = new int[dimension][dimension];
			restart();
		}

	}

	/**
	 * Devuelve una copia de la matriz para poder usarla en las pruebas
	 * 
	 * @return board.clone() Copia del tablero
	 */
	protected int[][] getBoard() {
		// Copiamos el tablero usando el metodo existente clone();
		return board.clone();
	}

	/**
	 * Reinicia todas las posiciones a 0 y llama a next para que incluya un 2 en una
	 * posición aleatoria.
	 * @see uo270318.mp.tareas1.game2048.model.Game2018#next()
	 */
	public void restart() {
		// Recorremos el array y le asignamos el valor 0 a cada posición
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				board[i][j] = EMPTY;
			}
		}
		// Llamamos al método next() que se encarga de rellenar una
		// posición aleatoria con el valor 2.
		next();
	}

	/**
	 * Añade un nuevo número 2 en posición aleatoria y pinta el tablero.
	 * @see uo270318.mp.tareas1.game2048.model.Game2018#paint()
	 */
	public void next() {
		// Rellenamos una posición aleatoria con el valor 2 necesario para
		// comenzar el juego utilizando la clase interna Random.
		Random random = new Random();
		int fila = random.nextInt(board.length);
		int columna = random.nextInt(board.length);
		if(board[fila][columna]==0) {
			board[fila][columna] = 2;
		}else {
			next();
		}
		
		paint();
	}
	/**
	 * Imprime por pantalla el tablero
	 */
	public void paint() {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(j==board.length-1) 
					System.out.println(board[i][j]);
				else
				System.out.print(board[i][j]+" ");	
			}
		}
	}
	
	/**
	 * Comprueba si el tablero está lleno. Esto ocurre cuando todas las celdas o
	 * posiciones del tablero tienen un número distinto de cero.
	 * 
	 * @return true Si el tablero está lleno false Si el tablero no está lleno.
	 */
	public boolean isBoardFull() {
		// Recorremos el tablero y comprobamos el valor de cada posición.
		// Si el valor el distinto de 0 devuelve true, si es 0 devuelve false.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == EMPTY) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Compacta el tablero a la derecha compactando todas las filas.
	 */
	public void compactRight() {
		// Iteramos a través del tablero partiendo de la primera fila
		// y última columna. Si esta contiene un 0 y la columna anterior
		// de la misma fila es distinta de 0, el valor se intercambia.
		// El proceso se repite hasta que todas las posiciones susceptibles
		// al cambio se hayan comprobado.

		for (int i = 0; i < board.length; i++) {
			for (int j = board.length - 1; j > 0; j--) {
				if (board[i][j] == EMPTY && board[i][j - 1] != EMPTY) {
					board[i][j] = board[i][j - 1];
					board[i][j - 1] = EMPTY;
					compactRight();
				}
			}
		}
	}

	/**
	 * Compacta el tablero a la derecha compactando todas las filas.
	 */
	public void compactLeft() {
		// Iteramos a través del tablero partiendo de la primera fila
		// y primera columna. Si esta contiene un 0 y la columna posterior
		// de la misma fila es distinta de 0, el valor se intercambia.
		// El proceso se repite hasta que todas las posiciones susceptibles
		// al cambio se hayan comprobado.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length - 1; j++) {
				if (board[i][j] == EMPTY && board[i][j + 1] != EMPTY) {
					board[i][j] = board[i][j + 1];
					board[i][j + 1] = EMPTY;
					compactLeft();
				}
			}
		}
	}

	/**
	 * Compacta toda la matriz hacia arriba.
	 */
	public void compactUp() {
		// Iteramos a través del tablero partiendo de la primera fila
		// y primera columna. Si esta contiene un 0 y la fila posterior
		// de la misma columna es distinta de 0, el valor se intercambia.
		// El proceso se repite hasta que todas las posiciones susceptibles
		// al cambio se hayan comprobado.
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length - 1; j++) {
				if (board[j][i] == EMPTY && board[j + 1][i] != EMPTY) {
					board[j][i] = board[j + 1][i];
					board[j + 1][i] = EMPTY;
					compactUp();
				}
			}
		}
	}

	/**
	 * Compacta toda la matriz hacia abajo.
	 */
	public void compactDown() {
		// Iteramos a través del tablero partiendo de la primera fila
		// y última columna. Si esta contiene un 0 y la fila anterior
		// de la misma columna es distinta de 0, el valor se intercambia.
		// El proceso se repite hasta que todas las posiciones susceptibles
		// al cambio se hayan comprobado.
		for (int i = 0; i < board.length; i++) {
			for (int j = board.length - 1; j > 0; j--) {
				if (board[j][i] == EMPTY && board[j - 1][i] != EMPTY) {
					board[j][i] = board[j - 1][i];
					board[j - 1][i] = EMPTY;
					compactDown();
				}
			}
		}
	}

	/**
	 * Inicializa el teclado con la matriz pasada como parámetro
	 */
	protected void setBoard(int[][] matrix) {
		//Comprobamos si el tablero pasado como parametro tiene una dimensión
		//adecuada. De ser así, asignamos los valores a nuestro tablero. En caso
		//contrario creamos un nuevo tablero con la dimensión por defecto.
		if (matrix.length < MIN_DIMENSION || matrix.length > MAX_DIMENSION) {
			new Game2048();
		} else {
			board = matrix;
		}
	}

}
