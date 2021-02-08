package uo.mp.person;

public class Person  implements Comparable<Object>{
	private String name;
	private int age;

	public Person(String name, int age){
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Object p2) {
		return this.getName().compareTo(((Person) p2).getName());
	}
	
}