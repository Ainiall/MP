package uo270318.mp.tareaS10.dome.exceptions;

import uo270318.mp.tareaS9.dome.model.Database;

public class RepeatedElementException extends Exception {
    private static final long serialVersionUID = 1L;

    public RepeatedElementException(String string) {
	super(string);
    }

}
