package com.pablo.test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

import com.pablo.model.Pessoa;

public class TesteLambda {

	public static void main(String[] args) {

		Function<Integer, Integer> function = (x) -> x + x;
		Integer res = function.apply(3);
		System.out.println(res);

		List<Integer> lista = Arrays.asList(1, 3, 8, 165, 555);
		lista.forEach(l -> System.out.println(l));

		List<Pessoa> listaPessoas = Arrays.asList(new Pessoa("Joao", 32), new Pessoa("Antonio", 20),
				new Pessoa("Maria", 18), new Pessoa("Angela", 30));

		Stream<Pessoa> streamPessoas = listaPessoas.stream();

		IntSummaryStatistics intSummStat = streamPessoas.filter(p -> p.getNome().startsWith("A"))
				.mapToInt(p -> p.getIdade()).summaryStatistics();
		System.out.println(intSummStat.getSum());
		System.out.println(intSummStat.getMin());
		System.out.println(intSummStat.getMax());

	}

}
