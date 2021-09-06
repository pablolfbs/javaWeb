package com.pablo.teste;

import org.apache.commons.lang3.ArrayUtils;

public class TestePost4 {

	public static void main(String[] args) {
		post4(new int[] {4, 4, 3});

	}

	public static int[] post4(int[] nums) {
		ArrayUtils.reverse(nums);
		
		return nums;
	}

}
