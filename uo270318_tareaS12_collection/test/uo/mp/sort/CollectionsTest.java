package uo.mp.sort;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uo.mp.person.Person;

public class CollectionsTest {

	@Test
	public void testWithIntegers() {
		List<Person> list = new ArrayList<>();
		
		list.add( new Person("Juan",18) );
		list.add( new Person("Angela",23));
		list.add( new Person("Nuria",30));
		list.add( new Person("Raul",10));
		
		Collections.sort( list );
		
		System.out.println( list );
		
		assertTrue( "[Angela, Juan, Nuria, Raul]".equals( list.toString() ) );
		
		Collections.sort( list, new ByAgeComparator() );
		
		assertTrue( "[Raul, Juan, Angela, Nuria]".equals( list.toString() ) );
	}

}
