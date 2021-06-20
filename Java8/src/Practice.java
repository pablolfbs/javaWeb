import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice {
	
	public static void main(String[] args) {
		
		List<String> palavras = new ArrayList<String>();
		palavras = Arrays.asList("Ingrid", "Pablo", "Alice");
		System.out.println(palavras);
		
		palavras.sort((s1, s2) -> Integer.compare(s1.length(), s2.length()));
		System.out.println(palavras);
		
	}
}

