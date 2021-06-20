package com.pablo.teste;

public class Main4 {

	public static void main(String[] args) {

		Main4 obj = new Main4();
		obj.start();
		
	}

	private void start() {
		long[] p = {3, 4, 5};
		long[] q = method(p);
		System.out.print(p[0] + p[1] + p[2] + " : ");
		System.out.print(q[0] + q[1] + q[2]);
	}

	private long[] method(long[] r) {
		r[1] = 7;
		return r;
	}

}
