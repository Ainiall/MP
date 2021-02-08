package uo.mp.sort;

import java.util.Comparator;

import uo.mp.person.Person;

public class ByAgeComparator implements Comparator<Person>{


	@Override
	public int compare(Person p1, Person p2) {
		return (p1.getAge()-p2.getAge());
	}

}
