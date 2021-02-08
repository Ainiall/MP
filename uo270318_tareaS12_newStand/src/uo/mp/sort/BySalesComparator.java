package uo.mp.sort;

import java.util.Comparator;

import uo.mp.newstand.publication.Publication;

public class BySalesComparator implements Comparator<Publication> {

    @Override
    public int compare(Publication p1, Publication p2) {
	if(p1.getSales()==p2.getSales()) {
	    return p1.getStock()-p2.getStock();
	}else {
	    return p1.getSales()-p2.getSales();
	}
    }

}
