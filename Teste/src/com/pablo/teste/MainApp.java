package com.pablo.teste;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MainApp {

	public static void main(String[] args) {
		
		int array[] = new int[10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
			
			System.out.print(i == array.length - 1 ? array[i] : array[i] + ", ");
		}
		
		System.out.println("");
		
		Set<String> lista1 = new HashSet<String>();
		lista1.add("Pablo");
		lista1.add("Ingrid");
		lista1.add("Alice");
		lista1.add("Pablo");
		
		Set<String> lista2 = new TreeSet<String>();
		lista2.add("Pablo");
		lista2.add("Ingrid");
		lista2.add("Alice");
		lista2.add("Pablo");
		
		Iterator<String> it1 = lista1.iterator();
		while (it1.hasNext()) {
			String result = it1.next();
			System.out.println(result);
		}
		
		Iterator<String> it2 = lista2.iterator();
		while (it2.hasNext()) {
			String result = it2.next();
			System.out.println(result);
		}
		
	}

}
