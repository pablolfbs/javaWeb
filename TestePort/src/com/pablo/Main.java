package com.pablo;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		
//		System.out.println(computesClosestToZero(arr));
		System.out.println(exists(new int[] {1, 5, 3, 8, 6}, 2));
		
	}
	
	
	

	private static int computesClosestToZero(int[] arr) {
		int closestIndex = 0;
		int diff = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; ++i) {
		    int abs = Math.abs(arr[i]);
		    if (abs < diff) {
		        closestIndex = i;
		        diff = abs;
		    } else if (abs == diff && arr[i] > 0 && arr[closestIndex] < 0) {
		        //same distance to zero but positive 
		        closestIndex = i;
		    }
		}   
		return arr[closestIndex];
	}
	
	private static boolean exists(int[] ints, int k) {
		Arrays.sort(ints);
		return Arrays.binarySearch(ints, 0, ints.length, k) >= 0 ? true : false;
	}

}
