package com.pablo.teste;

import java.util.HashMap;
import java.util.Map;

public class Main1 {
	
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<>();
		map.put("firstName", "Wolmir");
		map.put("lastName", "Garbin");
		map.put("blog", "Receitas de Código");
		map.put("url", "https://receitasdecodigo.com.br");
		
		map.forEach((k, v) -> System.out.println(String.format("key: %s | value: %s", k, v)));
		
	}
	
}
