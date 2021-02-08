package uo270318.mp.tareaS12.collections_iterators.generics.model;


public class LinkedListTest extends ListTest {

    @SuppressWarnings("rawtypes")
    @Override
    protected List createList() {
	return new LinkedList();
    }
}
