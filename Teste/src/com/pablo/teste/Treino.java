package com.pablo.teste;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class Treino {

	public static void main(String[] args) throws IOException {
		
		PrintWriter pw = new PrintWriter(new File("arquivo.txt"));
		pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod");
		pw.println("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, ");
		
		pw.close();
		
		InputStream fis = new FileInputStream("arquivo.txt");
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while (linha != null && !linha.isEmpty()) {
			System.out.println(linha);
			linha = br.readLine();
		}
		br.close();
		
	}

}
