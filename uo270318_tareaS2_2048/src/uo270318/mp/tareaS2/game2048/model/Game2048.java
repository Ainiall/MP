package uo270318.mp.tareaS2.game2048.model;

import java.util.Random;

/**
 * <p>
 * T�tulo: Clase Game2048
 * </p>
 * <p>
 * Descripci�n: A partir de un array bidimensional de n�meros y a trav�s de
 * diferentes operaciones se simula un juego llamado "2048".
 * </p>
 * <p>
 * Copyright: Copyright (c) 2019
 * </p>
 * <p>
 * Empresa: Escuela de Ingenier�a Inform�tica - Uiversidad de Oviedo
 * </p>
 * 
 * @author �ngela L�pez UO270318
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
     * Constructor sin par�metros con tablero por defecto de 3*3. Inicialmente
     * todas las posiciones con valor 0.
     */
    public Game2048() {
	// Inicializamos el tablero con una dimensi�n 3x3 por defecto
	board = new int[MIN_DIMENSION][MIN_DIMENSION];
	// Los array de enteros se inicializan a 0 por defecto.
	restart();
    }

    /**
     * Constructor que inicializa el tablero con una dimension determinada que
     * se le pasa como par�metro de tipo entero.
     * 
     * @param dimension n�mero de filas y de columnas (matriz cuadrada) entre
     *                  minimo y m�ximo
     */

    public Game2048(int dimension) {
	// Inicializaci�n del tablero con dimension columnas y fila, mientras
	// el parametro dimension se encuentre dentro del rango permitido
	// tendr� el valor dimension, si se excede se inicializa por defecto
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
	// reutilizar el m�todo en las rotaciones copiamos la matriz de forma
	// que no se referencien entre s�.
	return deepCopy(board);
    }

    /**
     * Reinicia todas las posiciones a 0 y llama a next para que incluya un 2 en
     * una posici�n aleatoria.
     * 
     * @see uo270318.mp.tareaS2.game2048.model.Game2048#next()
     */
    public void restart() {
	// Recorremos el array y le asignamos el valor 0 a cada posici�n
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board.length; j++) {
		board[i][j] = EMPTY;
	    }
	}
	// Llamamos al m�todo next() que se encarga de rellenar una
	// posici�n aleatoria con el valor 2.
	next();
    }

    /**
     * A�ade un nuevo n�mero 2 en posici�n aleatoria y pinta el tablero.
     * 
     */
    public void next() {
	// Rellenamos una posici�n aleatoria con el valor 2 necesario para
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
     * Comprueba si el tablero est� lleno. Esto ocurre cuando todas las celdas o
     * posiciones del tablero tienen un n�mero distinto de cero.
     * 
     * @return true Si el tablero est� lleno false Si el tablero no est� lleno.
     */
    public boolean isBoardFull() {
	// Recorremos el tablero y comprobamos el valor de cada posici�n.
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
	// Iteramos a trav�s del tablero partiendo de la primera fila
	// y �ltima columna. Si esta contiene un 0 y la columna anterior
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
	// Iteramos a trav�s del tablero partiendo de la primera fila
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
	// Iteramos a trav�s del tablero partiendo de la primera fila
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
	// Iteramos a trav�s del tablero partiendo de la primera fila
	// y �ltima columna. Si esta contiene un 0 y la fila anterior
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
     * Inicializa el teclado con la matriz pasada como par�metro
     */
    protected void setBoard(int[][] matrix) {
	// Comprobamos si el tablero pasado como parametro tiene una dimensi�n
	// adecuada. De ser as�, asignamos los valores a nuestro tablero. En
	// caso contrario creamos un nuevo tablero con la dimensi�n por defecto.
	if (matrix.length < MIN_DIMENSION || matrix.length > MAX_DIMENSION) {
	    new Game2048();
	} else {	 
	    // al asignar directamente board= matrix hacemos una copia
	    // superficial (es decir, los cambios a board afectan a matrix ya
	    // que comparten referencia).Como es un m�todo creado para su
	    // utilizaci�n en pruebas esto no es conveniente, pues tendr�amos
	    // que crear varias matrices distintas. Por ello, es mejor
	    // implementear una copia profunda.
	    board = deepCopy(matrix);
	}
    }

    /**
     * M�todo que implementa una copia profunda de la matriz que se le pasa como
     * par�metro. De esta forma apunta a nuevas direcciones de memoria, por lo
     * que es m�s lento pero permite realizar cambios sin que afecte a la matriz
     * original, permitiendo su reutilizaci�n.
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
     * M�todo que mueve los n�meros hacia la derecha.
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
     * M�todo que mueve los n�meros hacia la izquierda.
     */
    public void moveLeft() {
	rotateBoard(2);
	moveRight();
	rotateBoard(2);
    }

    /**
     * M�todo que mueve los n�meros hacia arriba.
     */
    public void moveUp() {
	rotateBoard(3);
	moveRight();
	rotateBoard(1);
    }

    /**
     * M�todo que mueve los n�meros hacia abajo.
     */
    public void moveDown() {
	rotateBoard(1);
	moveRight();
	rotateBoard(3);
    }

    /**
     * M�todo que mueve el tablero en sentido contrario a las agujas del reloj
     * una cantidad de veces indicada. Para hacer este cambio utiliza una matriz
     * auxiliar aux, de la misma dimensi�n que el tablero original.
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
     * @return cont Contador de n�mero de veces que aparece un 2 en el tablero.
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
