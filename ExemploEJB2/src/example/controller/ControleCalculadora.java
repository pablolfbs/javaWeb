package example.controller;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import example.ejb.Calculadora;

@Named(value = "controleCalculadora")
@RequestScoped
public class ControleCalculadora {

	@EJB
	private Calculadora calculadora;

	public Calculadora getCalculadora() {
		return calculadora;
	}

	public void setCalculadora(Calculadora calculadora) {
		this.calculadora = calculadora;
	}

}
