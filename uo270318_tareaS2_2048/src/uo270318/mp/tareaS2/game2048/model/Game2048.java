package uo270318.mp.tareaS2.game2048.model;

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
    /**
     * Constantes
     */
    public static final int MIN_DIMENSION = 3;
    public static final int MAX_DIMENSION = 10;
    public static final int EMPTY = 0;

    private int[][] board;
    private int cont = 0;

    /**
     * Constructor sin parámetros con tablero por defecto de 3*3. Inicialmente
     * todas las posiciones con valor 0.
     */
    public Game2048() {
	// Inicializamos el tablero con una dimensión 3x3 por defecto
	board = new int[MIN_DIMENSION][MIN_DIMENSION];
	// Los array de enteros se inicializan a 0 por defecto.
	restart();
    }

    /**
     * Constructor que inicializa el tablero con una dimension determinada que
     * se le pasa como parámetro de tipo entero.
     * 
     * @param dimension número de filas y de columnas (matriz cuadrada) entre
     *                  minimo y máximo
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
	// EDIT: usar directamente .clone() referencia al mismo objeto, para
	// reutilizar el método en las rotaciones copiamos la matriz de forma
	// que no se referencien entre sí.
	return deepCopy(board);
    }

    /**
     * Reinicia todas las posiciones a 0 y llama a next para que incluya un 2 en
     * una posición aleatoria.
     * 
     * @see uo270318.mp.tareaS2.game2048.model.Game2048#next()
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
     * 
     */
    public void next() {
	// Rellenamos una posición aleatoria con el valor 2 necesario para
	// comenzar el juego utilizando la clase interna Random.
	Random random = new Random();
	int fila = random.nextInt(board.length);
	int columna = random.nextInt(board.length);
	if (!isBoardFull()) {
	    if (board[fila][columna] == 0) {
		board[fila][columna] = 2;
	    } else {
		next();
	    }
	}
    }

    /**
     * Imprime por pantalla el tablero
     */
    public String toString() {
	String str = "";
	for (int i = 0; i < board.length; i++) {
	    str = str + "\n";
	    for (int j = 0; j <= (board.length - 1); j++)
		str = " " + str + board[i][j] + " ";
	}
	return str;
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
	// Comprobamos si el tablero pasado como parametro tiene una dimensión
	// adecuada. De ser así, asignamos los valores a nuestro tablero. En
	// caso contrario creamos un nuevo tablero con la dimensión por defecto.
	if (matrix.length < MIN_DIMENSION || matrix.length > MAX_DIMENSION) {
	    new Game2048();
	} else {	 
	    // al asignar directamente board= matrix hacemos una copia
	    // superficial (es decir, los cambios a board afectan a matrix ya
	    // que comparten referencia).Como es un método creado para su
	    // utilización en pruebas esto no es conveniente, pues tendríamos
	    // que crear varias matrices distintas. Por ello, es mejor
	    // implementear una copia profunda.
	    board = deepCopy(matrix);
	}
    }

    /**
     * Método que implementa una copia profunda de la matriz que se le pasa como
     * parámetro. De esta forma apunta a nuevas direcciones de memoria, por lo
     * que es más lento pero permite realizar cambios sin que afecte a la matriz
     * original, permitiendo su reutilización.
     * 
     * @param array Array bidimensional al que se realiza la copia profunda
     * @return aux Array bidimensional resultado de la copia (sin compartir
     *         referencia)
     */
    private int[][] deepCopy(int [][] array){
	int[][] aux = new int[array.length][];
	for (int i = 0; i < array.length; i++)
	    aux[i] = array[i].clone();
	return aux;
    }
	
    /**
     * Método que mueve los números hacia la derecha.
     */
    public void moveRight() {
	// compacta -> suma -> repite hasta que no se pueda sumar mas
	compactRight();
	for (int i = 0; i < board.length; i++) {
	    for (int j = board.length - 1; j > 0; j--) {
		//sumamos si 2 numeros seguidos son iguales y distintos a 0
		if (board[i][j] != EMPTY && board[i][j] == board[i][j - 1]) {
		    board[i][j] = board[i][j - 1] * 2;
		    board[i][j - 1] = EMPTY;
		    moveRight();
		}
	    }
	}
    }

    /**
     * Método que mueve los números hacia la izquierda.
     */
    public void moveLeft() {
	rotateBoard(2);
	moveRight();
	rotateBoard(2);
    }

    /**
     * Método que mueve los números hacia arriba.
     */
    public void moveUp() {
	rotateBoard(3);
	moveRight();
	rotateBoard(1);
    }

    /**
     * Método que mueve los números hacia abajo.
     */
    public void moveDown() {
	rotateBoard(1);
	moveRight();
	rotateBoard(3);
    }

    /**
     * Método que mueve el tablero en sentido contrario a las agujas del reloj
     * una cantidad de veces indicada. Para hacer este cambio utiliza una matriz
     * auxiliar aux, de la misma dimensión que el tablero original.
     * 
     * @param veces Veces que se rota el tablero.
     */
    private void rotateBoard(int veces) {
	int[][] a = this.getBoard();
	for (int n = 0; n < veces; n++) {
	    for (int i = 0; i < board.length; i++) {
		for (int j = 0; j < board.length; j++) {
		    board[board.length - 1 - j][i] = a[i][j];
		}
	    }
	    a = this.getBoard();
	}
    }

    /**
     * Metodo auxiliar que nos permite realizar pruebas unitarias sobre el
     * tablero.
     * 
     * @return cont Contador de número de veces que aparece un 2 en el tablero.
     */
    public int containsTwo() {
	cont = 0;
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		if (board[i][j] == 2) {
		    cont++;
		}
	    }
	}
	return cont;
    }

}
