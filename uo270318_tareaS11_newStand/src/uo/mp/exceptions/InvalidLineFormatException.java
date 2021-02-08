package uo.mp.exceptions;

@SuppressWarnings("serial")
public class InvalidLineFormatException extends Exception {
    
    //ERRORES DE CARGA DEL FICHERO
   

    private int lineNumber;
    private String line;

    public InvalidLineFormatException(String msg, int lineNumber, String line) {
	super(msg);
	this.lineNumber = lineNumber;
	this.line = line;
    }

    @Override
    public String getMessage() {
	return super.getMessage() + " en linea " + lineNumber
		+ " con contenido " + line;

    }
    // En el caso de los objetos error el toString llama a getMessage()

   
    public InvalidLineFormatException(String arg0, Throwable arg1, boolean arg2,
	    boolean arg3) {
	super(arg0, arg1, arg2, arg3);
	// TODO Auto-generated constructor stub
    }

    public InvalidLineFormatException(String arg0, Throwable arg1) {
	super(arg0, arg1);
	// TODO Auto-generated constructor stub
    }

    public InvalidLineFormatException(String arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

    public InvalidLineFormatException(Throwable arg0) {
	super(arg0);
	// TODO Auto-generated constructor stub
    }

}

