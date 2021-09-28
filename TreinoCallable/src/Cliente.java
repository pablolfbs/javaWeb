import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Cliente {

	public static void main(String[] args) {
		String serverName = "localhost";
		int port = 8000;
		try {
			System.out.println("Iniciando a conex�o!");
			// faz a conex�o
			Socket client = new Socket(serverName, port);
			System.out.println("Conectado a: " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();

			// envia a mensagem para o servidor
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Ol� Servidor! " + client.getLocalSocketAddress());

			// recebe a resposta do servidor
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);

			// imprime a resposta
			System.out.println("Resposta: " + in.readUTF());
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}