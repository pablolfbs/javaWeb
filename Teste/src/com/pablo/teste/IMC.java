package com.pablo.teste;

import javax.swing.JOptionPane;

public class IMC {

	public static void main(String[] args) {

		try {
			String strPeso = JOptionPane.showInputDialog(null, "Digite seu peso: ", "IMC", JOptionPane.QUESTION_MESSAGE)
					.replace(",", ".");
			float peso = Float.parseFloat(strPeso);

			String strAltura = JOptionPane
					.showInputDialog(null, "Digite sua altura: ", "IMC", JOptionPane.QUESTION_MESSAGE)
					.replace(",", ".");
			float altura = Float.parseFloat(strAltura);

			if (altura > 2)
				altura = altura / 100;

			float imc = peso / (altura * altura);
			JOptionPane.showMessageDialog(null, "Seu IMC é " + imc);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Não pode conter letras nem mais de um ponto ou vírgula.", "ERRO",
					JOptionPane.ERROR_MESSAGE);
		}

	}

}
