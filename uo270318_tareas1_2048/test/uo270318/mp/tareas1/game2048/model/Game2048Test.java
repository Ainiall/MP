package uo270318.mp.tareas1.game2048.model;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;


public class Game2048Test {
	private static int[][] SEMIFULL11 = {{0,2,0},{0,4,0},{0,8,0}};
	private static int[][] SEMIFULL12 = {{2,0,0},{4,0,0},{8,0,0}};
	private static int[][] SEMIFULL13 = {{0,0,2},{0,0,4},{0,0,8}};
	private static int[][] SEMIFULL1_RIGHTCOMPACTED = {{0,0,2},{0,0,4},{0,0,8}};
	private static int[][] SEMIFULL1_LEFTCOMPACTED = {{2,0,0},{4,0,0},{8,0,0}};
	
	@Test
	public void test() {
	Game2048 G = new Game2048();
	//Compactar a la derecha -> caso simple
		G.setBoard(SEMIFULL11);
		G.paint();
		G.compactRight();
		assertArrayEquals(SEMIFULL1_RIGHTCOMPACTED,G.getBoard());
	//Compactar a la izquierda ->caso simple
		G.compactLeft();
		assertArrayEquals(SEMIFULL1_LEFTCOMPACTED,G.getBoard());
	//Compactar a la derecha ->caso 2 movimientos
		G.setBoard(SEMIFULL12);
		G.compactRight();
		assertArrayEquals(SEMIFULL1_RIGHTCOMPACTED,G.getBoard());
	//Compactar a la izquierda ->caso 2 movimientos
		G.setBoard(SEMIFULL13);
		G.compactLeft();
		assertArrayEquals(SEMIFULL1_LEFTCOMPACTED,G.getBoard());
	}
	
	private static int[][] SEMIFULL21 = {{0,2,4},{0,4,8},{0,8,16}};
	private static int[][] SEMIFULL23 = {{2,0,4},{4,0,8},{8,0,16}};
	private static int[][] SEMIFULL2_RIGHTCOMPACTED = {{0,2,4},{0,4,8},{0,8,16}};
	private static int[][] SEMIFULL2_LEFTCOMPACTED = {{2,4,0},{4,8,0},{8,16,0}};
	
	@Test
	public void test2() {
	Game2048 G = new Game2048();
	//Compactar a la derecha
		G.setBoard(SEMIFULL21);
		G.compactRight();
		assertArrayEquals(SEMIFULL2_RIGHTCOMPACTED,G.getBoard());
	//Compactar a la izquierda
		G.compactLeft();
		assertArrayEquals(SEMIFULL2_LEFTCOMPACTED,G.getBoard());
	//Compactar a la derecha
		G.setBoard(SEMIFULL23);
		G.compactRight();
		assertArrayEquals(SEMIFULL2_RIGHTCOMPACTED,G.getBoard());
	//Compactar a la izquierda
		G.compactLeft();
		assertArrayEquals(SEMIFULL2_LEFTCOMPACTED,G.getBoard());
	//Comprobar si el tablero esta lleno
		assertFalse(G.isBoardFull());
	}
		
	private static int[][] SEMIFULL32 = {{0,0,0},{2,4,8},{0,0,0}};
	private static int[][] SEMIFULL33 = {{2,4,8},{0,0,0},{0,0,0}};
	private static int[][] SEMIFULL3_UPCOMPACTED = {{2,4,8},{0,0,0},{0,0,0}};
	private static int[][] SEMIFULL3_DOWNCOMPACTED = {{0,0,0},{0,0,0},{2,4,8}};
	
	@Test
	public void test3() {
	Game2048 G = new Game2048();
	//Compactar arriba
		G.setBoard(SEMIFULL32);
		G.compactUp();
		assertArrayEquals(SEMIFULL3_UPCOMPACTED,G.getBoard());
	//Compactar abajo
		G.compactDown();
		assertArrayEquals(SEMIFULL3_DOWNCOMPACTED,G.getBoard());
	//Compactar arriba
		G.compactUp();
		assertArrayEquals(SEMIFULL33,G.getBoard());

	}
	
	private static int[][] SEMIFULL41 = {{0,0,0},{2,4,8},{4,8,16},};
	private static int[][] SEMIFULL4_UPCOMPACTED = {{2,4,8},{4,8,16},{0,0,0}};
	private static int[][] SEMIFULL4_DOWNCOMPACTED = {{0,0,0},{2,4,8},{4,8,16}};

	@Test
	public void test4() {
	Game2048 G = new Game2048();
	//Compactar arriba
		G.setBoard(SEMIFULL41);
		G.compactUp();
		assertArrayEquals(SEMIFULL4_UPCOMPACTED,G.getBoard());
	//Compactar abajo
		G.compactDown();
		assertArrayEquals(SEMIFULL4_DOWNCOMPACTED,G.getBoard());
	//Compactar abajo
		G.compactDown();
		assertArrayEquals(SEMIFULL4_DOWNCOMPACTED,G.getBoard());
		
	}
	
	private static int[][] FULL = {{2,4,8},{4,8,16},{8,16,32}};
	
	@Test
	public void test5() {
	Game2048 G = new Game2048();
	//Compactar a la derecha
		G.setBoard(FULL);
		G.compactRight();
		assertArrayEquals(FULL,G.getBoard());
	//Compactar a la izquierda
		G.compactLeft();
		assertArrayEquals(FULL,G.getBoard());
	//Comprobar si el tablero esta lleno
		assertTrue(G.isBoardFull());
	}
	
	private static int[][] LOW_DIMENSION = {{10,2},{5,9}};
	private static int[][] HIGH_DIMENSION = {{3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3},
			{3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3},
			{3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3},
			{3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3},{3,3,3,3,3,3,3,3,3,3,3}};
	
	private static int[][] DEFAULT_DIMENSION = {{0,0,0},{0,0,0},{0,0,0}};
	
	@SuppressWarnings("deprecation")
	@Test
	public void test6() {
	Game2048 G = new Game2048();
	//Comprobamos si cambia un tablero de tamaño incorrecto
		G.setBoard(LOW_DIMENSION);
		assertThat(LOW_DIMENSION, is(not(G.getBoard())));
		assertFalse(LOW_DIMENSION.equals(G.getBoard()));
		assertFalse(G.isBoardFull());

		G.setBoard(HIGH_DIMENSION);
		assertThat(HIGH_DIMENSION, is(not(G.getBoard())));
		assertEquals(DEFAULT_DIMENSION.length, G.getBoard().length);

	}
}
