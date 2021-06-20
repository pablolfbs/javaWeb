package br.com.alura.java.io.test2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class TesteEscritaLeitura {
	
	public static void main(String[] args) throws IOException {
		
		InputStream fis = new FileInputStream("arquivo.txt");
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		PrintWriter pw = new PrintWriter(new File("arquivo.txt"));
		
		pw.println("teste");
		pw.println();
		pw.println("teste2");
		
		String linha = br.readLine();
		
		while (linha != null && !linha.isEmpty()) {
			pw.write(linha);
		}
		
		br.close();
		pw.close();
		
	}

}
