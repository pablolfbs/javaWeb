import java.util.Map;

public class ClasseTeste {

	public static void main(String[] args) {
		
		Produto p = new Produto("Design Patterns", "LIVRO", 59.90, "Publicado pela Casa do Código");
		
		Map<String, Object> props = GeradorMapa.gerarMapa(p);
		
		for (String prop : props.keySet()) {
			System.out.println(prop + " = " + props.get(prop));
		}
		
	}

	public void metodoVazio() {
		
	}

}
