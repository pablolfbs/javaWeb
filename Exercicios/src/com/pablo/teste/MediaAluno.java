package com.pablo.teste;

import java.text.DecimalFormat;
import java.util.Scanner;

import org.apache.log4j.Logger;

public class MediaAluno {

	int[] notas = new int[3];
	
	private static Logger logger = Logger.getLogger(MediaAluno.class);
	
	private static final String NOTA_INVALIDA = "Nota inválida! Tente novamente!";

	private static int[] adicionaNota() {

		Scanner in = new Scanner(System.in);

		int n1 = -1;
		int n2 = -1;
		int n3 = -1;

		logger.info("Adicione as 3 notas do aluno. ");
		while (n1 < 0 || n1 > 100) {
			logger.info("Digite a primeira nota: ");
			n1 = in.nextInt();
			if (n1 < 0 || n1 > 100) {
				logger.error(NOTA_INVALIDA);
			}

		}

		while (n2 < 0 || n2 > 100) {
			logger.info("Digite a segunda nota: ");
			n2 = in.nextInt();
			if (n2 < 0 || n2 > 100) {
				logger.error(NOTA_INVALIDA);
			}

		}

		while (n3 < 0 || n3 > 100) {
			logger.info("Digite a terceira nota: ");
			n3 = in.nextInt();
			if (n3 < 0 || n3 > 100) {
				logger.error(NOTA_INVALIDA);
			}

		}

		in.close();

		return new int[] { n1, n2, n3 };

	}

	private static void media(int[] array) {
		DecimalFormat df = new DecimalFormat("0.00");

		logger.info(df.format((array[0] + array[1] + array[2]) / (double) 3).replace(",", "."));

	}

	public static void main(String[] args) {
		org.apache.log4j.BasicConfigurator.configure();
		
		media(adicionaNota());
	}

}
