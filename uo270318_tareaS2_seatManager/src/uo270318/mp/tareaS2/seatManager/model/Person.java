package uo270318.mp.tareaS2.seatManager.model;

public class Person {
    public final static int MIN_EDAD = 0;
    public final static int MAX_EDAD = 110;
    public final static int EDAD_JUBILACION = 65;
    public final static int EDAD_ADULTA = 18;

    private String nombre;
    private int edad;

    /**
     * Constructor sin parámetros donde se inicializa a unos valores por
     * defecto.
     */
    public Person() {
	nombre = "Pepe";
	edad = 41;
    }

    /**
     * Constructor que inicializa el objeto persona con unos atributos que se le
     * pasan como parámetros (el nombre y la edad).
     * 
     * @param nombre Nombre de la persona
     * @param edad   Edad de la persona
     */
    public Person(String nombre, int edad)
	    throws IllegalArgumentException, IndexOutOfBoundsException {
	if (nombre.matches("^[ A-Za-z]+"))
	    this.nombre = nombre;
	else
	    throw new IllegalArgumentException(
		    "El nombre debe contener caracteres a-z");
	if (isEdadEntre(MIN_EDAD, MAX_EDAD, edad))
	    this.edad = edad;
	else
	    throw new IndexOutOfBoundsException(
		    "La edad debe ser válida (0-110)");
    }

    /**
     * Metodo que modifica el nombre de la persona.
     * 
     * @param nombre Nuevo nombre para la persona.
     */
    @SuppressWarnings("unused")
    private void setNombre(String nombre) {
	this.nombre = nombre;
    }

    /**
     * Metodo que devuelve el valor del atributo nombre.
     * 
     * @return nombre Nombre de la persona.
     */
    public String getNombre() {
	return nombre;
    }

    /**
     * Metodo que modifica la edad de la persona.
     * 
     * @param edad Nueva edad de la persona. Esta debe estar comprendida en un
     *             rango fijado por las constantes MIN_EDAD y MAX_EDAD.
     */
    @SuppressWarnings("unused")
    private void setEdad(int edad) {
	if (isEdadEntre(MIN_EDAD, MAX_EDAD, edad)) {
	    this.edad = edad;
	}
    }

    /**
     * Metodo que devuelve el valor del atributo edad.
     * 
     * @return edad Edad de la persona.
     */
    public int getEdad() {
	return edad;
    }

    public boolean isAdultoNoJubilado() {
	if (isEdadEntre(EDAD_ADULTA, EDAD_JUBILACION, getEdad())) {
	    return true;
	}
	return false;
    }

    public static boolean isEdadEntre(int valor1, int valor2, int edad) {
	return (valor2 > valor1) ? (edad >= valor1 && edad <= valor2)
		: (edad >= valor2 && edad <= valor1);
    }
}
