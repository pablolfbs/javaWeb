
public class TesteConexao {

	public static void main(String[] args) {
		
		try(Conexao con = new Conexao()) {
			con.leDados();
		} catch (IllegalStateException e) {
			System.err.println("Erro na conex�o!");
		}

//		Conexao con = null;
//		try {
//			con = new Conexao();
//			con.leDados();
//		} catch (IllegalStateException e) {
//			System.err.println("Erro na conex�o!");
//		} finally {
//			con.close();
//		}

	}

}
