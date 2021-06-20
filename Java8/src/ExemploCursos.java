import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Curso {

	private String nome;
	private int alunos;

	public Curso(String nome, int alunos) {
		this.nome = nome;
		this.alunos = alunos;
	}

	public String getNome() {
		return nome;
	}

	public int getAlunos() {
		return alunos;
	}
}

public class ExemploCursos {

	public static void main(String[] args) {

		List<Curso> cursos = new ArrayList<Curso>();
		cursos = Arrays.asList(new Curso("Python", 45), new Curso("JavaScript", 150), new Curso("Java 8", 113), new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		int sum = cursos.stream().filter(c -> c.getAlunos() > 100).mapToInt(Curso::getAlunos).sum();
		System.out.println(sum);
		
		cursos.stream().mapToDouble(c -> c.getAlunos()).average().ifPresent(c -> System.out.println(c));
		
		cursos.stream().filter(c -> c.getAlunos() > 50).collect(Collectors.toList()).forEach(c -> System.out.println(c.getNome()));
		
		String data = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		System.out.println(data);
		
		LocalDate ld = LocalDate.of(2099, Month.JANUARY, 25);
		System.out.println(ld.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
	}

}
