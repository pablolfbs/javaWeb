package com.pablo.teste;

import java.util.HashMap;
import java.util.Map;

public class TesteMap {
	
	public static void main(String[] args) {
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "Pablo");
		map.put(2, "Ingrid");
		map.put(3, "Alice");
		map.put(4, "Nadja");
		map.put(5, "Antonio Luiz");
		map.put(6, "Marcello");
		
		System.out.println(map.entrySet());
		
		System.out.println(map.get(3));
		
		System.out.println(map.containsKey(5));
		
		System.out.println(map.containsValue("Pablo"));
		
		System.out.println(map.isEmpty());
		
		System.out.println(map.keySet());
		
		System.out.println(map.values());
		
		map.forEach((k, v) -> System.out.println(k + " - " + v));
		
	}

}
