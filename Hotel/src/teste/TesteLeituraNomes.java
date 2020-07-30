package teste;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class TesteLeituraNomes {

	public static void main(String[] args) throws IOException {
		// Fluxo de entrada com arquivo
		FileInputStream fis = new FileInputStream("nomes.txt");
		InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
		BufferedReader br = new BufferedReader(isr);

		String linha = br.readLine();

		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}

		br.close();
	}

}
