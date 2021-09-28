import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Servidor implements Runnable {

	private final ServerSocket serverSocket;
	private final ExecutorService pool;

	List<Future<VerificaRequisicao>> requisicoes = new ArrayList<Future<VerificaRequisicao>>();

	public static void main(String args[]) throws IOException {
		// cria uma Thread nova eexcutando o servidor
		System.out.println("Servidor no ar");
		new Thread(new Servidor(8000, 3)).run();
	}

	public Servidor(int port, int poolSize) throws IOException {
		serverSocket = new ServerSocket(port);
		pool = Executors.newFixedThreadPool(poolSize);
	}

	public void run() { // run the service
		try {
			// cria uma tarefa para a verifica��o das requisi��es
			pool.execute(new VerificaRequisicao(requisicoes));
			while (true) {
				System.out.println("Nova requisi��o!");
				Future<VerificaRequisicao> req = (Future<VerificaRequisicao>) pool
						.submit(new TrataRequisicao(serverSocket.accept()));
				// armazena todas as requisi��es
				requisicoes.add(req);
			}
		} catch (IOException ex) {
			pool.shutdown();
		}
	}
}

// classe que executa de 10 em 10 segundos e verifica o status das requisi��es
class VerificaRequisicao implements Runnable {
	private final List<Future<VerificaRequisicao>> requisicoes;

	VerificaRequisicao(List<Future<VerificaRequisicao>> requisicoes) {
		this.requisicoes = requisicoes;
	}

	public void run() {
		while (true) {
			int somaTerminadas = 0;
			int somaCanceladas = 0;
			int somaEmExecucao = 0;
			try {
				Thread.sleep(10000);
				for (Future<VerificaRequisicao> f : requisicoes) {
					if (f.isDone()) {
						somaTerminadas++;
					} else if (f.isCancelled()) {
						somaCanceladas++;
					} else if (!f.isDone()) {
						somaEmExecucao++;
					}
				}
				System.out.println("Terminadas: " + somaTerminadas);
				System.out.println("Canceladas: " + somaCanceladas);
				System.out.println("Execu��o: " + somaEmExecucao);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

// classe que recebe a requisi��o do cliente e a responde
class TrataRequisicao implements Runnable {
	private final Socket server;

	TrataRequisicao(Socket server) {
		this.server = server;
	}

	public void run() {
		try {
			System.out.println("Conectado a: " + server.getRemoteSocketAddress());
			DataInputStream in = new DataInputStream(server.getInputStream());
			System.out.println(in.readUTF());
			DataOutputStream out = new DataOutputStream(server.getOutputStream());
			Thread.sleep(5000);
			out.writeUTF("Sua conex�o terminou! Tchau!");
			server.close();
		} catch (SocketTimeoutException s) {
			System.out.println("Socket timed out!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}