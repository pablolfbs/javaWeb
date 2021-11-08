import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Level;

public class Exemplo1 {
	
	private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		int randNumber = new Random().nextInt(20) + 1;
		
		Fatorial task = new Fatorial(randNumber);
		System.out.println("Enviando a tarefa ...");
		
		Future<Long> future = threadpool.submit(task);
		System.out.println("Task is submitted");
		
		while(!future.isDone()) {
			System.out.println("Tarefa não terminada ainda ...");
			Thread.sleep(5000);
		}
		System.out.println("Tarefa finalizada!");
		long factorial = (long) future.get();
		System.out.println("Fatorial de " + randNumber + " é: " + factorial);
		
		threadpool.shutdown();
	}

}

class Fatorial implements Callable<Long> {
	private final int number;
	
	public Fatorial(int number) {
		this.number = number;
	}

	@Override
	public Long call() throws Exception {
		long output = 0;
		
		try {
			output = factorial(number);
		} catch (Exception ex) {
			java.util.logging.Logger.getLogger(Exemplo1.class.getName()).log(Level.SEVERE, null, ex);
		}
		return output;
	}
	
	private long factorial(int number) throws InterruptedException {
		if (number < 0) {
			throw new IllegalArgumentException("Number must be greater than zero");
		}
		long result = 1;
		
		while(number > 0) {
			result = result * number;
			number--;
		}
		return result;
	}
	
}
