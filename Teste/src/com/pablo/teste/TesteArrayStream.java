package com.pablo.teste;

import java.util.Arrays;
import java.util.Collections;

public class TesteArrayStream {

	public static void main(String[] args) {
		int[] array = {0, 2, 3, 8, 1};
		int[] array1 = {0, 3, 3, 9, 8, 1};
		
//		array1 = array;
//		for (int i : array1) {
//			System.out.println(i);
//		}
		
		Collections.reverse(Arrays.asList(array));
		Arrays.stream(array).sorted().forEach(a -> System.out.println(a));
		
		System.out.println("----------");
		
		Arrays.stream(array)
					.boxed() // Converts Intstream to Stream<Integer>
					.sorted(Collections.reverseOrder())
					.forEach(a -> System.out.println(a));
		
//		Arrays.sort(array);
//		
//		for (int i : array) {
//			System.out.println(i);
//		}

	}

}
