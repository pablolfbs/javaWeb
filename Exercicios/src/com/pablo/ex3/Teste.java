package com.pablo.ex3;

public class Teste {
	
	public static void main(String[] args) {
		
		ContaCorrente cc = new ContaCorrente(1224, 100.00f, "especial", 1000.00f);
		
		cc.consultaSaldo();
		
		cc.deposita(500f);
		
		cc.consultaSaldo();
		
		cc.realizaSaque(800f);
		
		cc.consultaSaldo();
		
		cc.realizaSaque(100f);
		
		cc.consultaSaldo();
		
	}

}
