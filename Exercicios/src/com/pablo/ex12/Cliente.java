package com.pablo.ex12;

public class Cliente {

	public static void main(String[] args) {

		try {

			throw new RuntimeException();
		} catch (RuntimeException e) {
			System.out.println(1);
		} catch (Exception e) {
			System.out.println(2);
		} finally {
			System.out.println(3);
		}

	}

}
