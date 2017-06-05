package com.gerry.hanjra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GenericsByMethods {
	
	public static void main(String[] args) {
		Person p1 = new Person();
		Person p2 = new Person();
		Person p3 = new Person();
		p1.setName("name1");
		p2.setName("name2");
		p3.setName("name3");
		p1.setAge(21);
		p2.setAge(22);
		p3.setAge(23);
		
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		List<Integer> intList = new ArrayList();
		intList.add(1);
		intList.add(2);
		intList.add(3);
		
		Person minPerson = min(list,new PersonComparator());
		
		System.out.println(minPerson.age + "     " + minPerson.name);
		
		Integer minInteger = min(intList,new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				// TODO Auto-generated method stub
				return 0;
			}
		});
	
		System.out.println(minInteger);
	}
	
	public static <T> T min(List<T> list,Comparator comparator){
		T lowest = list.get(0);
		for(T temp:list){
			if(comparator.compare(temp, lowest) < 0){
				lowest = temp;
			}
		}
		return lowest;
	}
}

//class Minimizer<T>{
//	public static Object min(List<Object> list){
//		if()
//		return null;
//		
//		
//	}
//}
