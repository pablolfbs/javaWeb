package com.pablo.controlador;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import com.pablo.util.Utils;

public class Controller {
	
	public void calculaIMC() {
		try {
			var strPeso = "";
			var strAltura = "";

			strPeso = formParam("seu peso");
			var peso = Double.parseDouble(strPeso);

			strAltura = formParam("sua altura");
			var altura = Double.parseDouble(strAltura);
			altura = Utils.toMetters(altura);

			var imc = (Double) (peso / Math.pow(altura, 2));

			var msg = msgIMC(imc);

			msgFinal(imc, msg);
			repetirConsulta();

		} catch (NullPointerException e) {
			msgAgradecimento();
		}
	}
	
	private static String formParam(String param) {
		var count = 0;
		String valor = null;
		do {
			if (count == 0)
				valor = JOptionPane.showInputDialog(null, "Digite " + param + ": ", "IMC", JOptionPane.QUESTION_MESSAGE)
						.replace(",", "").replace(".", "");
			else
				valor = JOptionPane.showInputDialog(null,
						"Vamos tentar novamente." + System.lineSeparator() + "Digite " + param + ": ", "IMC",
						JOptionPane.QUESTION_MESSAGE).replace(",", "").replace(".", "");

			if (valor == null)
				throw new NullPointerException();

			count++;
		} while (verificaNulo(valor) || validaValor(valor) || validaPeso(param, valor) || validaAltura(param, valor));
		
		return valor;
	}
	
	private static void msgFinal(Double imc, String msg) {
		JOptionPane.showMessageDialog(null, "Seu IMC é " + new DecimalFormat("#.00").format(imc) + ". " + msg + ".");
	}
	
	private static void repetirConsulta() {
		Object[] options = { "No, thanks", "Yes, please" };
		int n = JOptionPane.showOptionDialog(null, "Deseja fazer outra consulta? ",
				null, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
		
		if (n == 1)
			new Controller().calculaIMC();
		else
			msgAgradecimento();
	}

	private static void msgAgradecimento() {
		JOptionPane.showMessageDialog(null, "Volte Sempre :)", "OBRIGADO", JOptionPane.PLAIN_MESSAGE);
	}

	private static String msgIMC(Double imc) {
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
			msg = "Obesidade grau III (obesidade mórbida)";
		
		return msg;
	}

	private static boolean verificaNulo(String valor) {
		if (valor.equals("")) {
			JOptionPane.showMessageDialog(null, "Não pode estar vazio.", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		return false;
	}

	private static boolean validaValor(String valor) {
		if (!valor.matches("^-?(?:\\d+|\\d{1,3}(?:,\\d{3})+)(?:(\\.|,)\\d+)?$") && !valor.equals("")) {
			JOptionPane.showMessageDialog(null, "Não corresponde a um número válido.", "ERRO", JOptionPane.ERROR_MESSAGE);
			
			return true;
		}
		return false;
	}
	
	private static boolean validaPeso(String param, String valor) {
		if (param.equals("seu peso") && (Utils.stringToDouble(valor) > 600 || Utils.stringToDouble(valor) < 0)) {
			JOptionPane.showMessageDialog(null, "O peso deve estar entre 0 e 600 kg.", "ERRO", JOptionPane.ERROR_MESSAGE);
			return true;				
		}
		return false;
	}
	
	private static boolean validaAltura(String param, String valor) {
		if (param.contentEquals("sua altura") && (Utils.stringToDouble(valor) > 250 || Utils.stringToDouble(valor) <= 40)) {
			JOptionPane.showMessageDialog(null, "Altura deve estar entre 0,4 e 2,5 metros.", "ERRO", JOptionPane.ERROR_MESSAGE);
			return true;				
		}
		return false;
	}

}
