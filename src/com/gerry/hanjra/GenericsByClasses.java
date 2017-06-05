package com.gerry.hanjra;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Person {

		int age;
		String name;
		
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}	
}

public class GenericsByClasses{
	public static void main(String[] args) {
		Person p1 =  new Person();
		p1.setAge(23);
		p1.setName("Donnie");
		Person p2 =  new Person();
		p2.setAge(22);
		p2.setName("Brasco");
		List<Person> map = new ArrayList<>();
		map.add(p1);
		map.add(p2);
		System.out.println(map.get(0).name + "" + map.get(1).name);
		Collections.sort(map,new PersonComparator());
		System.out.println(map.get(0).name + "" + map.get(1).name);
		Collections.sort(map,new ReverseComparator(new  PersonComparator()));
		System.out.println(map.get(0).name + "" + map.get(1).name);
	}
}

class PersonComparator implements Comparator<Person>{
	@Override
	public int compare(Person o1, Person o2) {
		return o1.age - o2.age;
	}
}

class ReverseComparator<T> implements Comparator<T>{
	
	private Comparator<T> pcompa;
	
	public ReverseComparator(final Comparator<T> comparator) {
		// TODO Auto-generated constructor stub
		this.pcompa = comparator;
	}
	@Override
	public int compare(T o1, T o2) {
		// TODO Auto-generated method stub
		return -1*pcompa.compare(o1, o2);
	}
}

