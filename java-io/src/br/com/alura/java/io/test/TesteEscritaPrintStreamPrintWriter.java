package br.com.alura.java.io.test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class TesteEscritaPrintStreamPrintWriter {

	public static void main(String[] args) throws IOException {

		// Fluxo de entrada com arquivo
//		FileOutputStream fos = new FileOutputStream("lorem2.txt");
//		OutputStreamWriter osw = new OutputStreamWriter(fos);
//		BufferedWriter bw = new BufferedWriter(osw);
		
//		PrintStream ps = new PrintStream(new File("lorem2.txt"));
		PrintWriter pw = new PrintWriter(new File("lorem2.txt"), "UTF-8");
		
		pw.println("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod ");
		pw.println();
		pw.println();
		pw.println("tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, ");
		
		pw.close();
	}

}
