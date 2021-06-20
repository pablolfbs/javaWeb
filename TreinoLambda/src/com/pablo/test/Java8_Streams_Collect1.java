package com.pablo.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Java8_Streams_Collect1 {
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
		
		ArrayList<Object> collect = list.stream()
			.collect(() -> new ArrayList<>(), (l, e) -> l.add(e), (l1, l2) -> l1.add(l2));
		
		System.out.println(collect);
		
	}

}
