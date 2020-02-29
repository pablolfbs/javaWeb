package example.ejb;

import javax.ejb.Stateless;

@Stateless
public class CalculadoraBean implements Calculadora {

	@Override
	public double soma(double a, double b) {
		return a + b;
	}

	@Override
	public double subtracao(double a, double b) {
		return a - b;
	}

	@Override
	public double multiplicacao(double a, double b) {
		return a * b;
	}

	@Override
	public double divisao(double a, double b) {
		return a / b;
	}

}
