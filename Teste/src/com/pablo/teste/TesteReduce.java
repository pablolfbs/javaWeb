package com.pablo.teste;

import java.util.Arrays;

public class TesteReduce {
	
	public static void main(String[] args) {
		
		int[] nums = {8, 5, 30, 55};
		
		int reduce = Arrays.stream(nums).reduce(0, (a, b) -> a + 1);
		System.out.println(reduce);
		
	}
	
}
