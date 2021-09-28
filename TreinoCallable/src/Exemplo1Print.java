import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Exemplo1Print {

	private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);

	public static void main(String[] args) throws InterruptedException, ExecutionException {

		GerarNumeroAleatorio task = new GerarNumeroAleatorio();
		System.out.println("Processando a tarefa ...");

		Future<Integer> future = threadpool.submit(task);
		
		while (!future.isDone()) {
			System.out.println("A tarefa ainda não foi processada!");
			Thread.sleep(10000);
		}
		System.out.println("Tarega completa!");
		
		long factorial = (long) future.get();
		System.out.println("O número gerado foi: " + factorial);
		
		threadpool.shutdown();
	}

}

class GerarNumeroAleatorio implements Callable<Integer> {

	@Override
	public Integer call() {
		Random rand = new Random();
		Integer number = rand.nextInt(100);

		return number;
	}

}
