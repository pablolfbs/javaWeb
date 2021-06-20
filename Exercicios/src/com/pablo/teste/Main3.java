package com.pablo.teste;

public class Main3 {

	public static void main(String[] args) {

		long ini = System.currentTimeMillis();

		String s = "pablo luiz faria britto de souza";

		System.out.print(String.valueOf(s.charAt(0)).toUpperCase());
		for (int i = 1; i < s.length(); i++) {
			if (String.valueOf(s.charAt(i)).equals(" ")) {
				System.out.print(" " + String.valueOf(s.charAt(i + 1)).toUpperCase());
			} else {
				if (!String.valueOf(s.charAt(i - 1)).equals(" ")) {
					System.out.print(String.valueOf(s.charAt(i)));
				}
			}
		}
		System.out.println();
		long fim = System.currentTimeMillis();
		System.out.println(fim - ini);
	}
}
