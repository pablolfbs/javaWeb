package com.pablo.ex1;

public class MainElevador {

	public static void main(String[] args) {
		Elevador el = new Elevador();

		el.inicializa(5, 10);

		el.entra();
		el.entra();
		el.entra();
		el.entra();
		el.entra();
		el.entra();
		el.entra();

		System.out.println(el.getPessoasPresentes());

		el.sai();
		el.sai();
		el.sai();
		el.sai();
		el.sai();
		el.sai();

		System.out.println(el.getPessoasPresentes());

		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();
		el.sobe();

		System.out.println(el.getAndarAtual());
		
		el.desce();
		el.desce();
		el.desce();
		el.desce();
		el.desce();
		el.desce();
		el.desce();
		el.desce();
		el.desce();
		el.desce();
		el.desce();

		System.out.println(el.getAndarAtual());
	}
}
