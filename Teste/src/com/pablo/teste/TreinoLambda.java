package com.pablo.teste;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TreinoLambda {

	public static void main(String[] args) {
		
//		new Thread(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Olá Mundo!");
//			}
//		}).run();
//		
//		new Thread(() -> System.out.println("Olá Mundo!")).run();

//		JButton jButton = new JButton();
//		jButton.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("Olá Mundo!");
//			}
//		});
//		
//		JButton jButton2 = new JButton();
//		jButton2.addActionListener(e -> System.out.println("Olá Mundo!"));

		List<Integer> list = Arrays.asList(1, 5, 8, 9, 1, 4, 7, 6, 6, 9, 9);
		
//		Stream<Integer> map = list.stream().filter(e -> e % 2 == 0);
//		map.forEach(l -> System.out.println(l));
		
//		Map<Integer, List<Integer>> collect = list.stream()
//				.collect(Collectors.groupingBy(e -> e * 5));
//		System.out.println(collect.get(20));
		
		String collect = list.stream()
				.map(e -> String.valueOf(e))
				.collect(Collectors.joining(" - "));
		System.out.println(collect);
		
	}

}
