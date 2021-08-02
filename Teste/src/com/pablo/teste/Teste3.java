package com.pablo.teste;

import java.math.BigDecimal;

public class Teste3 {
	
	public static void main(String[] args) {
		
		String s = "Pablo123Teste4343";
		
		System.out.println(s.replaceAll("\\D+", ""));
		
		StringBuilder sb = new StringBuilder(s);
		System.out.println(sb.reverse());
		
		BigDecimal bd = new BigDecimal(10);
		System.out.println(bd.add(new BigDecimal(5)));
		
	}

}
