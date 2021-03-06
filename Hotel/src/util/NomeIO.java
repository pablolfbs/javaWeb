package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

public class NomeIO {
	
	private NomeIO() {
		throw new IllegalStateException("Utility class");
	}
	
	public static Collection<String> lerArquivo() {
		
//		InputStream input = getClass().getResourceAsStream("file.properties");
//		try {
//			properties.load(input);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return properties;
		
		// Fluxo de entrada com arquivo
		InputStream fis;
		InputStreamReader isr;
		BufferedReader br;
		Collection<String> lista = new ArrayList<>();
		try {
			// C�digo alterado para transformar o m�todo em est�tico.
			// fis = getClass().getResourceAsStream("nomes.txt");
			fis = NomeIO.class.getResourceAsStream("nomes.txt");
			isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
			br = new BufferedReader(isr);
			String linha = br.readLine();

			while (linha != null) {
				lista.add(linha.trim());
				linha = br.readLine();
			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
}
