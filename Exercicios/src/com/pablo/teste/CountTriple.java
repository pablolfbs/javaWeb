package com.pablo.teste;

public class CountTriple {

	public static void main(String[] args) {

		System.out.println(countTriple("abcXXXabc")); // 1
		System.out.println();
		System.out.println(countTriple("xxxabyyyycd")); // 3
		System.out.println();
		System.out.println(countTriple("a")); // 0

	}

	private static int countTriple(String string) {
		
		int count = 0;
		int match = 0;
		
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(0) == string.charAt(i)) {
				count++;
				if (count == 3) {
					match++;
				}
			}
			if (i == string.length()) {
				string.replaceAll(String.valueOf(string.charAt(0)), "");
			}
		}
		return match;
	}
}
