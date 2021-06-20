
public class TesteConexao {

	public static void main(String[] args) {
		
		try(Conexao con = new Conexao()) {
			con.leDados();
		} catch (IllegalStateException e) {
			System.err.println("Erro na conexão!");
		}

//		Conexao con = null;
//		try {
//			con = new Conexao();
//			con.leDados();
//		} catch (IllegalStateException e) {
//			System.err.println("Erro na conexão!");
//		} finally {
//			con.close();
//		}

	}

}
