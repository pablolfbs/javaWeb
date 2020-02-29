package teste;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import model.Quarto;

public class Teste {

	public static void main(String[] args) {

		int[] numQuarto = new int[5];
		int num;
		List<Quarto> quartos = new ArrayList<Quarto>();
		Quarto quarto = new Quarto();

		Random rand = new Random();
		
		for (int i = 0; i < 5; i++) {
			quarto = new Quarto();
			num = rand.nextInt(5);
			numQuarto[i] = num;
			quarto.setNum(num);
			quartos.add(quarto);
			if (quarto != null) {
				if (num != quartos.get(i).getNum()) {
					quarto = new Quarto();
					num = rand.nextInt(5);
					numQuarto[i] = num;
					quarto.setNum(num);
					quartos.add(quarto);
				} else {
//					continue;
				}
				
			}
//			System.out.println(quarto.getNum());
		}
		

	}

}
