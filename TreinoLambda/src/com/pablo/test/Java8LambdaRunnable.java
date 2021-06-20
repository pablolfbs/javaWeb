package com.pablo.test;

public class Java8LambdaRunnable {

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Olá, mundo!");
			}
		}).run();

		new Thread(() -> System.out.println("Olá, mundo!")).run();
	}

}
