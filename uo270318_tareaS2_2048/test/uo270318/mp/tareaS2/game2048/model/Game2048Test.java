package uo270318.mp.tareaS2.game2048.model;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Game2048Test {

    private Game2048 board, game;
    private static int[][] SEMIFULL11 = { { 0, 2, 0 }, { 0, 4, 0 },
	    { 0, 8, 0 } };
    private static int[][] SEMIFULL12 = { { 2, 0, 0 }, { 4, 0, 0 },
	    { 8, 0, 0 } };
    private static int[][] SEMIFULL13 = { { 0, 0, 2 }, { 0, 0, 4 },
	    { 0, 0, 8 } };
    private static int[][] SEMIFULL21 = { { 0, 2, 4 }, { 0, 4, 8 },
	    { 0, 8, 16 } };
    private static int[][] SEMIFULL22 = { { 2, 4, 0 }, { 4, 8, 0 },
	    { 8, 16, 0 } };
    private static int[][] SEMIFULL23 = { { 2, 0, 4 }, { 4, 0, 8 },
	    { 8, 0, 16 } };
    private static int[][] SEMIFULL31 = { { 0, 0, 0 }, { 0, 0, 0 },
	    { 2, 4, 8 } };
    private static int[][] SEMIFULL32 = { { 0, 0, 0 }, { 2, 4, 8 },
	    { 0, 0, 0 } };
    private static int[][] SEMIFULL33 = { { 2, 4, 8 }, { 0, 0, 0 },
	    { 0, 0, 0 } };
    private static int[][] SEMIFULL41 = { { 0, 0, 0 }, { 2, 4, 8 },
	    { 4, 8, 16 }, };
    private static int[][] SEMIFULL42 = { { 2, 4, 8 }, { 0, 0, 0 },
	    { 4, 8, 16 } };
    private static int[][] SEMIFULL43 = { { 2, 4, 8 }, { 4, 8, 16 },
	    { 0, 0, 0 } };
    private static int[][] FULL = { { 2, 4, 8 }, { 4, 8, 16 }, { 8, 4, 16 } };

   
    private static int[][] SEMIFULL5 = { { 2, 2, 0, 2, 2 }, { 2, 2, 0, 2, 2 },
	    { 0, 0, 0, 0, 0 }, { 2, 2, 0, 2, 2 }, { 2, 2, 0, 2, 2 } };
   
    private static int[][] PRUEBA = { { 2, 0, 0 }, { 4, 0, 8 }, { 2, 2, 2 } };
    
    private static int[][] PRUEBA_ROTACION = { {1,2,3,4,5},
	    {6,7,8,9,10}, {11,12,13,14,15},{16,17,18,19,20},
	    {21,22,23,24,25}};
    
    
    /**
     * Método que se ejecuta antes que las llamadas a los test, lo que permite
     * inicializar los objetos susceptibles a estudio una sola vez.
     */
    @Before
    public void setUp(){
	board = new Game2048();
	game = new Game2048();
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#Game2048()}.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testGame2048() {
	// Comprobamos si inicializa el tablero con un 2 en una posicion
	// aleatoria.
	assertEquals(1, board.containsTwo());
	assertThat(board, is(not(game)));
	assertEquals(1, game.containsTwo());
    }

    private static int[][] LOW_DIMENSION = { { 10, 2 }, { 5, 9 } };
    private static int[][] HIGH_DIMENSION = {
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
	    { 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3 } };
    private static int[][] DEFAULT_DIMENSION = { { 0, 0, 0 }, { 0, 0, 0 },
	    { 0, 0, 0 } };

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#Game2048(int dimension)}.
     */
    @SuppressWarnings("deprecation")
    @Test
    public void testGame2048Int() {
	// Comprobamos si cambia un tablero mas pequeño de lo permitido
	board.setBoard(LOW_DIMENSION);
	assertThat(LOW_DIMENSION, is(not(board.getBoard())));
	assertFalse(LOW_DIMENSION.equals(board.getBoard()));

	// Comprobamos si cambia un tablero mas grande de lo permitido
	board.setBoard(HIGH_DIMENSION);
	assertThat(HIGH_DIMENSION, is(not(board.getBoard())));
	assertEquals(DEFAULT_DIMENSION.length, board.getBoard().length);

    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#getBoard()}.
     */
    @Test
    public void testGetBoard() {
	// Comprobamos que devuelve la misma matriz que le asignamos
	board.setBoard(SEMIFULL11);
	assertArrayEquals(SEMIFULL11, board.getBoard());
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#restart()}.
     */
    @Test
    public void testRestart() {
	// Comprobamos que reinicia un tablero lleno a uno vacio excepto
	// por una posición rellenada aleatorialemente.
	board.setBoard(FULL);
	assertTrue(board.isBoardFull());
	board.restart();
	assertFalse(board.isBoardFull());

    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#next()}.
     */
    @Test
    public void testNext() {
	// Comprobamos que añade un 2 al tablero al invocar al método next();
	game.setBoard(SEMIFULL11);
	game.next();
	assertEquals(2, game.containsTwo());
	// Comprobamos que no añada nada si el tablero está lleno
	board.setBoard(FULL);
	board.next();
	assertEquals(1, board.containsTwo());
    }

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#isBoardFull()}.
     */
    @Test
    public void testIsBoardFull() {
	board.setBoard(FULL);
	assertTrue(board.isBoardFull());
	game.setBoard(SEMIFULL21);
	assertFalse(game.isBoardFull());
    }

    private static int[][] SEMIFULL1_RIGHTCOMPACTED = { { 0, 0, 2 },
	    { 0, 0, 4 }, { 0, 0, 8 } };
    private static int[][] SEMIFULL2_RIGHTCOMPACTED = { { 0, 2, 4 },
	    { 0, 4, 8 }, { 0, 8, 16 } };

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#compactRight()}.
     */
    @Test
    public void testCompactRight() {
	// Compactar a la derecha: números en columna central
	 game.setBoard(SEMIFULL11);
	 game.compactRight();
	 assertArrayEquals(SEMIFULL1_RIGHTCOMPACTED,game.getBoard());

	// Compactar a la derecha: números en columna izquierda
	game.setBoard(SEMIFULL12);
	game.compactRight();
	assertArrayEquals(SEMIFULL1_RIGHTCOMPACTED, game.getBoard());
	// Compactar a la derecha: números en columna derecha
	game.setBoard(SEMIFULL13);
	game.compactRight();
	assertArrayEquals(SEMIFULL1_RIGHTCOMPACTED, game.getBoard());
	// Compactar a la derecha: números en columna central y derecha
	game.setBoard(SEMIFULL21);
	game.compactRight();
	assertArrayEquals(SEMIFULL2_RIGHTCOMPACTED, game.getBoard());
	// Compactar a la derecha: números en columna central e izquierda
	game.setBoard(SEMIFULL22);
	game.compactRight();
	assertArrayEquals(SEMIFULL2_RIGHTCOMPACTED, game.getBoard());
	// Compactar a la derecha: números en columna izquierda y derecha
	game.setBoard(SEMIFULL23);
	game.compactRight();
	assertArrayEquals(SEMIFULL2_RIGHTCOMPACTED, game.getBoard());
    }

    private static int[][] SEMIFULL1_LEFTCOMPACTED = { { 2, 0, 0 }, { 4, 0, 0 },
	    { 8, 0, 0 } };
    private static int[][] SEMIFULL2_LEFTCOMPACTED = { { 2, 4, 0 }, { 4, 8, 0 },
	    { 8, 16, 0 } };

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#compactLeft()}.
     */
    @Test
    public void testCompactLeft() {
	// Compactar a la izquierda: números en columna central
	game.setBoard(SEMIFULL11);
	game.compactLeft();
	assertArrayEquals(SEMIFULL1_LEFTCOMPACTED, game.getBoard());
	// Compactar a la izquierda: números en columna izquierda
	game.setBoard(SEMIFULL12);
	game.compactLeft();
	assertArrayEquals(SEMIFULL1_LEFTCOMPACTED, game.getBoard());
	// Compactar a la izquierda: números en columna izquierda
	game.setBoard(SEMIFULL13);
	game.compactLeft();
	assertArrayEquals(SEMIFULL1_LEFTCOMPACTED, game.getBoard());
	// Compactar a la derecha: números en columna central y derecha
	game.setBoard(SEMIFULL21);
	game.compactLeft();
	assertArrayEquals(SEMIFULL2_LEFTCOMPACTED, game.getBoard());
	// Compactar a la derecha: números en columna central e izquierda
	game.setBoard(SEMIFULL22);
	game.compactLeft();
	assertArrayEquals(SEMIFULL2_LEFTCOMPACTED, game.getBoard());
	// Compactar a la derecha: números en columna izquierda y derecha
	game.setBoard(SEMIFULL23);
	game.compactLeft();
	assertArrayEquals(SEMIFULL2_LEFTCOMPACTED, game.getBoard());

    }

    private static int[][] SEMIFULL3_UPCOMPACTED = { { 2, 4, 8 }, { 0, 0, 0 },
	    { 0, 0, 0 } };
    private static int[][] SEMIFULL4_UPCOMPACTED = { { 2, 4, 8 }, { 4, 8, 16 },
	    { 0, 0, 0 } };

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#compactUp()}.
     */
    @Test
    public void testCompactUp() {
	// Compactar arriba: números en última fila
	board.setBoard(SEMIFULL31);
	board.compactUp();
	assertArrayEquals(SEMIFULL3_UPCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila central
	board.setBoard(SEMIFULL32);
	board.compactUp();
	assertArrayEquals(SEMIFULL3_UPCOMPACTED, board.getBoard());
	// Compactar arriba: números en primera fila
	board.setBoard(SEMIFULL33);
	board.compactUp();
	assertArrayEquals(SEMIFULL3_UPCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila central y última
	board.setBoard(SEMIFULL41);
	board.compactUp();
	assertArrayEquals(SEMIFULL4_UPCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila primera y última
	board.setBoard(SEMIFULL42);
	board.compactUp();
	assertArrayEquals(SEMIFULL4_UPCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila central y primera
	board.setBoard(SEMIFULL43);
	board.compactUp();
	assertArrayEquals(SEMIFULL4_UPCOMPACTED, board.getBoard());
    }

    private static int[][] SEMIFULL3_DOWNCOMPACTED = { { 0, 0, 0 }, { 0, 0, 0 },
	    { 2, 4, 8 } };
    private static int[][] SEMIFULL4_DOWNCOMPACTED = { { 0, 0, 0 }, { 2, 4, 8 },
	    { 4, 8, 16 } };

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#compactDown()}.
     */
    @Test
    public void testCompactDown() {
	// Compactar arriba: números en última fila
	board.setBoard(SEMIFULL31);
	board.compactDown();
	assertArrayEquals(SEMIFULL3_DOWNCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila central
	board.setBoard(SEMIFULL32);
	board.compactDown();
	assertArrayEquals(SEMIFULL3_DOWNCOMPACTED, board.getBoard());
	// Compactar arriba: números en primera fila
	board.setBoard(SEMIFULL33);
	board.compactDown();
	assertArrayEquals(SEMIFULL3_DOWNCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila central y última
	board.setBoard(SEMIFULL41);
	board.compactDown();
	assertArrayEquals(SEMIFULL4_DOWNCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila primera y última
	board.setBoard(SEMIFULL42);
	board.compactDown();
	assertArrayEquals(SEMIFULL4_DOWNCOMPACTED, board.getBoard());
	// Compactar arriba: números en fila central y primera
	board.setBoard(SEMIFULL43);
	board.compactDown();
	assertArrayEquals(SEMIFULL4_DOWNCOMPACTED, board.getBoard());
    }

    private static int[][] SEMIFULL5_MOVEDRIGHT = { { 0, 0, 0, 0, 8 },
	    { 0, 0, 0, 0, 8 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 8 },
	    { 0, 0, 0, 0, 8 } };

    private static int[][] PRUEBA_MOVEDRIGHT = { { 0, 0, 2 }, { 0, 4, 8 },
	    { 0, 2, 4 } };
   

    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#moveRight()}.
     */
    @Test
    public void testMoveRight() {
	//Varias sumas
	board.setBoard(SEMIFULL5);
	board.moveRight();
	assertArrayEquals(SEMIFULL5_MOVEDRIGHT, board.getBoard());
	// Mover un tablero lleno
	board.setBoard(FULL);
	board.moveRight();
	assertArrayEquals(FULL, board.getBoard());
	//Solo se llega a ejecutar 1 suma
	board.setBoard(PRUEBA);
	board.moveRight();
	assertArrayEquals(PRUEBA_MOVEDRIGHT, board.getBoard());
	//Sin sumas ->igual que compactar
	board.setBoard(SEMIFULL12);
	board.moveRight();
	assertArrayEquals(SEMIFULL1_RIGHTCOMPACTED, board.getBoard());
    }

    private static int[][] SEMIFULL5_MOVEDLEFT = { { 8, 0, 0, 0, 0 },
	    { 8, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 8, 0, 0, 0, 0 },
	    { 8, 0, 0, 0, 0 } };
    
    private static int[][] PRUEBA_MOVEDLEFT = { { 2, 0, 0 }, { 4, 8, 0 },
	    { 4, 2, 0 } };
    
    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#moveLeft()}.
     */
    @Test
    public void testMoveLeft() {
	//Varias sumas
	board.setBoard(SEMIFULL5);
	board.moveLeft();
	assertArrayEquals(SEMIFULL5_MOVEDLEFT, board.getBoard());
	//Solo se llega a ejecutar 1 suma
	board.setBoard(PRUEBA);
	board.moveLeft();
	assertArrayEquals(PRUEBA_MOVEDLEFT, board.getBoard());
	//Sin sumas ->igual que compactar
	board.setBoard(SEMIFULL21);
	board.moveLeft();
	assertArrayEquals(SEMIFULL2_LEFTCOMPACTED, board.getBoard());
    }
    
    private static int[][] SEMIFULL5_MOVEDUP = { { 8, 8, 0, 8, 8 },
	    { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0 } };
    
    private static int[][] PRUEBA_MOVEDUP = { { 2, 2, 8 }, { 4, 0, 2 },
	    { 2, 0, 0 } };
    
    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#moveUp()}.
     */
    @Test
    public void testMoveUp() {
	//Tablero lleno
	game.setBoard(PRUEBA_ROTACION);
	game.moveUp();
	assertArrayEquals(PRUEBA_ROTACION, game.getBoard());
	//Varias sumas
	game.setBoard(SEMIFULL5);
	game.moveUp();
	assertArrayEquals(SEMIFULL5_MOVEDUP, game.getBoard());
	//Solo se llega a ejecutar 1 suma
	game.setBoard(PRUEBA);
	game.moveUp();
	assertArrayEquals(PRUEBA_MOVEDUP, game.getBoard());
	//Sin sumas ->igual que compactar
	game.setBoard(SEMIFULL31);
	game.moveUp();
	assertArrayEquals(SEMIFULL3_UPCOMPACTED, game.getBoard());
    }
    
    private static int[][] SEMIFULL5_MOVEDOWN = { { 0, 0, 0, 0, 0 },
	    { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0 },
	    { 8, 8, 0, 8, 8 } };
    
    private static int[][] PRUEBA_MOVEDOWN = { { 2, 0, 0 }, { 4, 0, 8 },
	    { 2, 2, 2 } };
    
    /**
     * Metodo Test que hace referencia a
     * {@link uo270318.mp.tareaS2.game2048.model.Game2048#moveDown()}.
     */
    @Test
    public void testMoveDown() {
	//Varias sumas
	game.setBoard(SEMIFULL5);
	game.moveDown();
	assertArrayEquals(SEMIFULL5_MOVEDOWN, game.getBoard());
	//Solo se llega a ejecutar 1 suma
	game.setBoard(PRUEBA);
	game.moveDown();
	assertArrayEquals(PRUEBA_MOVEDOWN, game.getBoard());
	//Sin sumas ->igual que compactar
	game.setBoard(SEMIFULL41);
	game.moveDown();
	assertArrayEquals(SEMIFULL4_DOWNCOMPACTED, game.getBoard());
    }
    
}
