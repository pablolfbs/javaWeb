package com.pablo.teste;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

public class TreinoIO {

	public static void main(String[] args) throws Exception {
		
//		PrintWriter pw = new PrintWriter(new File("arquivo.txt"));
		PrintWriter pw = new PrintWriter(new File("arquivo.txt"));
		pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		pw.println("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, ");
		pw.close();
		
		Scanner sc = new Scanner(new File("arquivo.txt"));
		
		while (sc.hasNextLine()) {
			String linha = sc.nextLine();
			System.out.println(linha);
		}
	}
}
