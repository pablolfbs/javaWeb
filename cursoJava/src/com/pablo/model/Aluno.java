package com.pablo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

	private String nome;
	private double[] nota;

	public void calculaNotaFinal(double[] notas) {
		double notaFinal = notas[0] + notas[1] + notas[2];
		System.out.println("FINAL GRADE = " + notaFinal);
		if (notaFinal >= 60) {
			System.out.println("PASS");
		} else {
			System.out.println("FAILED");
			System.out.println("MISSING " + (60 - notaFinal) + " POINTS");
		}

	}

}
