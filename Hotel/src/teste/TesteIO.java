package teste;

import java.util.ArrayList;
import java.util.Collection;

import util.NomeIO;

public class TesteIO {
	
	public static void main(String[] args) {
		
		Collection<String> colecao = NomeIO.lerArquivo();
		ArrayList<String> list = new ArrayList<>(colecao);
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (list.get(i).equals(list.get(j))) {
					System.out.println(list.get(j));
				}
			}
		}
		
	}

}
