package com.pablo.teste;

import java.util.Arrays;
import java.util.List;

public class Teste10 {
	
	public static void main(String[] args) {
		
		List<String> asList = Arrays.asList("Pablo", "Ingrid", "Alice");
		System.out.println(asList.toString().substring(1, asList.toString().length() - 1));
		
		String data = "202104";
		System.out.println(data.substring(4));
	}

}
