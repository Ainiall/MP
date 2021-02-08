package uo270318.mp.tareaS5.dome.model;

public interface Borrowable {
    boolean isAvailableItem(); //disponible para ser prestado
    
    boolean borrowed();
    boolean returned();
    
}
