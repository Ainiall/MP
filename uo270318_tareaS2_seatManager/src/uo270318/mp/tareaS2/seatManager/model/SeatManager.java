package uo270318.mp.tareaS2.seatManager.model;

import java.util.ArrayList;

public class SeatManager {
    /**
     * Constantes
     */
    public final static int MAX_FILAS = 10;
    public final static int MAX_COLUMNAS = 4;
    public final static int DEFAULT = 0;
    public final static int ASIENTO = 3;

    private Person[][] asiento;

    /**
     * Constructor sin par�metros que inicializa el asiento por defecto A 3*3
     */
    public SeatManager() {
	asiento = new Person[ASIENTO][ASIENTO];
    }

    /**
     * Constructor que inicializa el asiento en una posici�n determinada por los
     * atributos que se le pasan como par�metros de tipo entero.
     * 
     * @param fila   El n�mero de fila
     * @param columna El n�mero de columna
     */
    public SeatManager(int fila, int columna){
	if (isNumEntre(DEFAULT, MAX_FILAS, fila)
		&& isNumEntre(DEFAULT, MAX_COLUMNAS, columna)) {
	    asiento = new Person[fila][columna];
	}
    }

    /**
     * M�todo que recibe como par�metro un objeto de tipo Person, un n�mero de
     * fila y un n�mero de columna y coloca al objeto Person mencionado en la
     * posici�n indicada, siempre que est� libre o si est� ocupado por un adulto
     * no jubilado.
     * 
     * @param persona Persona a colocar
     * @param fila    Fila de la matriz
     * @param columna Columna de la matriz
     * @return true Si puede colocarse a la persona false Si no puede tomar
     *         asiento
     */
    public boolean bookSeat(Person persona, int fila, int columna){
	if (persona != null && isNumEntre(DEFAULT, MAX_FILAS, fila)
		&& isNumEntre(DEFAULT, MAX_COLUMNAS, columna)) {
	    if (asiento[fila][columna] == null
		    || asiento[fila][columna].isAdultoNoJubilado()) {
		asiento[fila][columna] = persona;
		return true;
	    }
	}
	return false;
    }

    /**
     * M�todo que devuelve un ArrayList con las personas sentadas en filas pares
     * cuya edad esta comprendida entre aquellas que se pasan como par�metros.
     * 
     * @param min_edad Edad m�nima del intervalo
     * @param max_edad Edad m�xima del intervalo
     * @return personas ArrayList con las personas sentadas en filas pares y
     *         edad v�lida.
     */
    @SuppressWarnings("static-access")
    public ArrayList<Person> findPassengersByAge(int min_edad, int max_edad){
	ArrayList<Person> personas = new ArrayList<Person>();
	for (int i = 0; i < asiento.length; i++) {
	    for (int j = 0; j < asiento[0].length; j++) {
		if (i % 2 == 0 && asiento[i][j] != null) {
		    if (asiento[i][j].isEdadEntre(min_edad, max_edad,
			    asiento[i][j].getEdad())) {
			personas.add(asiento[i][j]);
		    }
		}
	    }
	}
	return personas;
    }

    /**
     * M�todo auxiliar que comprueba si un entero pasado como par�metro se
     * encuentra en el rango marcado por dos valores de entrada que se pasan
     * como parametros.
     * 
     * @param valor1 Primer valor que restringe el rango
     * @param valor2 Segundo valor que restringe el rango
     * @param num    N�mero a observar
     * @return true Si el n�mero se encuentra en el rango fijado
     * @return false Si el n�mero no se encuentra en el rango fijado
     * @throws IllegalArgumentException Cuando el par�metro introducido no es
     *                                  v�lido
     */
    private static boolean isNumEntre(int valor1, int valor2, int num) {
	if (valor2 > valor1 && num >= valor1 && num <= valor2) {
	    return true;
	} else if (valor1 > valor2 && num >= valor2 && num <= valor1) {
	    return true;
	} else
	    throw new IllegalArgumentException(
		    "El parametro introducido no es v�lido");

    }

    /**
     * M�todo auxiliar que devuelve las filas que tiene la matriz asiento.
     * 
     * @return asiento.lenght N�mero de filas
     */
    public int getFilas() {
	return asiento.length;
    }

    /**
     * M�todo auxiliar que devuelve las columnas que tiene la matriz asiento.
     * 
     * @return asiento[0].length N�mero de columnas
     */
    public int getColumnas() {
	return asiento[0].length;
    }

    /**
     * M�todo auxiliar que devuelve el objeto Persona correspondiente a una
     * posici�n concreta de la matriz asiento. Esta viene determinada por los
     * par�metros fila y columna.
     * 
     * @param fila    Fila donde se encuentra la persona
     * @param columna Columna donde se encuentra la persona
     * @return asiento[fila][columna] Persona que se encuentra en el asiento
     *         seleccionado
     */
    public Person getPersona(int fila, int columna) {
	if (isNumEntre(DEFAULT, MAX_FILAS, fila)
		&& isNumEntre(DEFAULT, MAX_COLUMNAS, columna))
	    return asiento[fila][columna];
	throw new IndexOutOfBoundsException(
		"Los parametros deben estar comprendidos entre "
			+ "unos valores v�lidos");
    }
}
