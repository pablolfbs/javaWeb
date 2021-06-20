package com.pablo.test;

import java.util.Arrays;
import java.util.List;

public class Java8_Stream_Reduce {

	public static void main(String[] args) {

		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		Integer num = list.stream().reduce(1, (n1, n2) -> n1 * n2);
		
		System.out.println(num);

	}

}
