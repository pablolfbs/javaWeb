package com.pablo.ex4;

public class Teste {
	
	Teste() {
		System.out.println(salary);
	}
	
	void updateSalary() {
		salary = 25000;
		System.out.println(salary);
	}
	
	int salary = 10000;

	public static void main(String[] args) {
		
		new Teste();

//		Scanner in = new Scanner(System.in);
//		String login = null;
//		String senha = null;
//
//		do {
//
//			System.out.println("Digite o login: ");
//			login = in.nextLine();
//
//			System.out.println("Digite a senha: ");
//			senha = in.nextLine();
//
//			if (login.equals("pablolfbs") && senha.equals("1234")) {
//				System.out.println("Login efetuado com sucesso!");
//			} else {
//				System.out.println("Login e/ou senha inválido(s)");
//			}
//
//		} while (!(login.equals("pablolfbs") && senha.equals("1234")));

	}

}
