package com.pablo.controlador;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

public class Controller {

	public void calculaIMC() {
		try {
			var strPeso = "";
			var strAltura = "";

			strPeso = formParam("seu peso");
			var peso = Float.parseFloat(strPeso);

			strAltura = formParam("sua altura");
			var altura = Float.parseFloat(strAltura);

			if (altura > 2)
				altura = altura / 100;

			var imc = (float) (peso / Math.pow(altura, 2));

			var msg = msgIMC(imc);

			resultado(imc, msg);
			msgFinal();

		} catch (NullPointerException e) {
			msgFinal();
		}
	}

	private static String formParam(String param) {
		var count = 0;
		String valor = null;
		do {
			if (count == 0)
				valor = JOptionPane.showInputDialog(null, "Digite " + param + ": ", "IMC", JOptionPane.QUESTION_MESSAGE)
						.replace(",", ".");
			else
				valor = JOptionPane.showInputDialog(null,
						"Vamos tentar novamente." + System.lineSeparator() + "Digite " + param + ": ", "IMC",
						JOptionPane.QUESTION_MESSAGE).replace(",", ".");

			if (valor == null)
				throw new NullPointerException();

			verificaNulo(valor);

			validaValor(valor);

			count++;
		} while (!valor.matches("^-?(?:\\d+|\\d{1,3}(?:,\\d{3})+)(?:(\\.|,)\\d+)?$"));

		return valor;
	}

	private static void resultado(float imc, String msg) {
		JOptionPane.showMessageDialog(null, "Seu IMC é " + new DecimalFormat("#.00").format(imc) + ". " + msg + ".");
	}

	private static void msgFinal() {
		Object[] options = { "Yes, please", "No, thanks", "No eggs, no ham!" };
		int n = JOptionPane.showOptionDialog(frame, "Deseja consultar outro IMC? ",
				null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
				options[2]);
		JOptionPane.showMessageDialog(null, "Volte Sempre :)", "OBRIGADO", JOptionPane.PLAIN_MESSAGE);
	}

	private static String msgIMC(float imc) {
		var msg = "";
		if (imc < 16)
			msg = "Baixo peso muito grave";
		else if (imc < 17)
			msg = "Baixo peso grave";
		else if (imc < 18.5)
			msg = "Baixo peso";
		else if (imc < 25)
			msg = "Peso normal";
		else if (imc < 30)
			msg = "Sobrepeso";
		else if (imc < 35)
			msg = "Obesidade grau I";
		else if (imc < 40)
			msg = "Obesidade grau II";
		else
			msg = "Obesidade grau III (obesidade m�rbida)";

		return msg;
	}

	private static void verificaNulo(String valor) {
		if (valor.equals(""))
			JOptionPane.showMessageDialog(null, "N�o pode estar vazio.", "ERRO", JOptionPane.ERROR_MESSAGE);
	}

	private static void validaValor(String valor) {
		if (!valor.matches("^-?(?:\\d+|\\d{1,3}(?:,\\d{3})+)(?:(\\.|,)\\d+)?$") && !valor.equals(""))
			JOptionPane.showMessageDialog(null, "N�o corresponde a um n�mero v�lido.", "ERRO",
					JOptionPane.ERROR_MESSAGE);
	}

}
