package com.pablo.teste;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Teste1 {

	private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);

	public static void main(String[] args) {
		
		Aleatorio a = new Aleatorio();
		Future<Integer> futureRandom = threadpool.submit(a);
		
		try {
			Integer val = futureRandom.get();
			System.out.println(val);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
		threadpool.shutdown();
	}
}

class Aleatorio implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {

		Integer num = new Random().nextInt();
		return num;
	}

}
