package com.pablo.teste;

public class Main {

	public static void main(String[] args) {

//		Integer num = 597;
//		
//		if (Arrays.asList(226, 597).contains(num)) {
//			System.out.println("tem");
//		} else {
//			System.out.println("não tem");
//		}
//		
//		System.out.println(num);

//		Date data = new Date();
//		
//		System.out.println(data);
//		
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
//		
//		String s = sdf.format(data);
//		
//		try {
//			Date data1 = sdf.parse(s);
//			System.out.println(data1);
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(s);

//		List<Integer> lista = new ArrayList<Integer>();
//		lista.add(1);
//		lista.add(2);
//		lista.remove(0);
//		System.out.println(lista);
//		
//		String s = "Pablo";
//		StringBuilder sb = new StringBuilder();
//		for (int i = s.length() - 1; i >= 0; i--) {
//			sb.append(s.charAt(i));
//		}
//		System.out.println(sb);

//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		String sData = "2020-01-14";
//		try {
//			Date data1 = sdf.parse(sData);
//			Date data2 = new Date();
//			
//			System.out.println(data1.compareTo(data2));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}

//		String s = "Teste palavra invertida";
//		
//		StringBuilder sb = new StringBuilder();
//		
//		for (int i = s.length() - 1; i >= 0; i--) {
//			sb.append(s.charAt(i));
//		}
//		System.out.println(sb);
//		
//		String a = "teste";
//		String sql = " SELECT * FROM hospede WHERE nome LIKE %% ";
//		String novoSql = sql.replace("%%", "%"+ a + "%");
//		System.out.println(novoSql);

//		List<Integer> lista = new ArrayList<Integer>();
//		for (int i = 1; i <= 10; i++) {
//			lista.add(i);
//		}
//		
//		int[] array = {1, 2, 7};
//		for (int i = 0; i < array.length; i++) {
//			if (lista.contains(array[i])) {
//				System.out.println(array[i]);
//			}
//		}
//		
//		List<Integer> listaInseridos = new ArrayList<Integer>();
//		listaInseridos.add(1);
//		listaInseridos.add(2);
//		listaInseridos.add(7);
//		for (int i = 0; i < listaInseridos.size(); i++) {
//			if (lista.contains(listaInseridos.get(i))) {
//				System.out.println(listaInseridos.get(i));
//			}
//		}

//		String opcao = "ordenarPorNome";
//		int a = opcao.indexOf("Por");
//		System.out.println(opcao.substring(a + 3, a + 4).toLowerCase() + opcao.substring(a + 4));
//		
//		String s1="this is index of example";  
//		//passing substring  
//		int index1=s1.indexOf("is");//returns the index of is substring  
//		int index2=s1.indexOf("index");//returns the index of index substring  
//		System.out.println(index1+"  "+index2);//2 8  
//		  
//		//passing substring with from index  
//		int index3=s1.indexOf("is",4);//returns the index of is substring after 4th index  
//		System.out.println(index3);//5 i.e. the index of another is  
//		  
//		//passing char value  
//		int index4=s1.indexOf('s');//returns the index of s char value  
//		System.out.println(index4);//

//		List<Integer> lista = new ArrayList<Integer>();
//		for (int i = 1; i <= 10; i+=3) {
//			lista.add(i);
//		}
//		System.out.println(lista);
//		
//		List<Integer> listaTrocada = new ArrayList<Integer>();
//		for (int i = 1; i <= 10; i++) {
//			if (!lista.contains(i)) {
//				listaTrocada.add(i);
//			}
//		}
//		System.out.println(listaTrocada);

//		String s = "palavra invertida";
//		
//		for (int i = s.length() - 1; i >= 0; i--) {
//			System.out.print(s.charAt(i));
//		}

//		int[][] array = {{0, 1, 2}, {46, 3}, {5, 10, 158}};
//		for (int i = 0; i < array.length; i++) {
//			for (int j = 0; j < array[i].length; j++) {
//				System.out.println(array[i][j]);
//			}
//		}

//		Scanner in = new Scanner(System.in);
//		
//		System.out.println("Quantos anos tem a pessoa?");
//		int ano = in.nextInt();
//		System.out.println("Quantos meses?");
//		int meses = in.nextInt();
//		System.out.println("Quantos dias?");
//		int dias = in.nextInt();
//		
//		System.out.println("Essa pessoa tem " + ano + " anos, " + meses + " meses e " + dias + " dias.");
//		
//		ano *= 365;
//		meses *= 30;
//		int idade = ano + meses + dias;
//		
//		System.out.println("A idade da pessoa em dias é de aproximadamente " + idade + " dias.");
//		
//		in.close();

//		Fazer um programa que imprima a média aritmética dos números 8,9 e 7. A média dos números 4, 5 e 6. A soma das duas médias. A média das médias
//		int media1 = (8 + 9 + 7) / 3;
//		int media2 = (4 + 5 + 6) / 3;
//		System.out.println(media1);
//		System.out.println(media2);
//		
//		int somaDasMedias = media1 + media2;
//		float mediaDasMedias = (float) somaDasMedias / 2;
//		System.out.println(somaDasMedias);
//		System.out.println(mediaDasMedias);

//		String s = "arara";
//		int count = 0;
//		System.out.println(s.length());
//		System.out.println(s.toUpperCase());
//		
//		for (int i = 0; i < s.length(); i++) {
//			if (Arrays.asList("a", "e", "i", "o", "u").contains(String.valueOf(s.charAt(i)).toLowerCase())) {
//				count++;
//			}
//		}
//		System.out.println(count);
//		
//		if (s.substring(0, 3).toLowerCase().equals("RIO".toLowerCase())) {
//			System.out.println("Sim, inicia com RIO");
//		} else {
//			System.out.println("Não, não inicia com RIO");
//		}
//		
//		count = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (String.valueOf(s.charAt(i)).matches("[0-9]*")) {
//				count++;
//			}
//		}
//		System.out.println(count);
//		
//		String sb = new StringBuffer(s).reverse().toString();
//		if (s.equals(sb)) {
//			System.out.println("É um palíndromo");
//		} else {
//			System.out.println("Não é um palíndromo");
//		}

//		String nome = "pablo luiz faria britto de souza";
//		capitalize(nome);

//		int index = word.indexOf(guess);
//		while (index >= 0) {
//		    System.out.println(index);
//		    index = word.indexOf(guess, index + 1);

//		String texto = "PABLO  LUIZ       FARIA BRITTO    DE   SOUZA";
//		int index = 0;
//		int indexAnterior = 0;
//		int count = 0;
//		System.out.println("O texto tem " + texto.length() + " caracteres.");
//		while (index >= 0) {
//			if (index > 0) {
//				System.out.println(texto.substring(indexAnterior, index));
//				indexAnterior = index + 1;
//			}
//			index = texto.indexOf(" ", index + 1);
//			if (index == -1) {
//				System.out.println(texto.substring(indexAnterior));
//			}
//			count++;
//		}
//		System.out.println("O texto tem " + count + " palavras.");

//		System.out.println(texto.replaceAll("\\s+", " "));

//		String s = "Ifmg";
//		for (int i = 1; i <= s.length(); i++) {
//			System.out.println(s.substring(0, i));
//		}
//		for (int i = s.length() - 1; i > 0; i--) {
//			System.out.println(s.substring(0, i));
//		}

//		String anterior = "";
//		for (int i = 0; i < s.length(); i++) {
//			anterior += String.valueOf(s.charAt(i));
//			System.out.println(anterior);
//		}
//		for (int i = s.length() - 1; i > 0; i--) {
//			anterior = anterior.replace(String.valueOf(s.charAt(i)), "");
//			System.out.println(anterior);
//		}

//		String str = "Pablo Luiz Faria Britto de Souza";
//		System.out.println(str.replace("de", "of"));
//		System.out.println(str.indexOf("Faria"));
//		System.out.println(str.length());
//		System.out.println(str.toUpperCase());

//		String descricao = Turno.NOITE.getDescricao();
//		System.out.println(descricao);

//		List<Integer> lista = new ArrayList<Integer>();
//		for (int i = 0; i < 10; i++) {
//			lista.add(i);
//		}
//		System.out.println(lista);
//		
//		lista.forEach(l -> System.out.println(l));

//		List<Integer> lista = Arrays.asList(1, 3, 6, 7);

//		for (int i = 0; i < 10; i++) {
//			if (!lista.contains(i)) {
//				System.out.println(i);
//			}
//		}
//		System.out.println(lista);

//		System.out.println(new SimpleDateFormat("dd-MM-yyyy").format(System.currentTimeMillis()));
//		System.out.println(Calendar.getInstance());
//		System.out.println(Calendar.getInstance().getTime());

//		Calendar cal = Calendar.getInstance();
//        int mouthStart = cal.get(Calendar.MONTH);
//
//        Calendar calendar = Calendar.getInstance();
//        calendar.clear();
//        System.out.println(calendar.getTime());
//        calendar.set(Calendar.DAY_OF_MONTH, 1);
//        calendar.set(Calendar.MONTH,  mouthStart - 1);
//        calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));
//
//        Date tempDateStart = calendar.getTime();
//        System.out.println(tempDateStart);
//
//        calendar.add(Calendar.MONTH, 1);
//        calendar.add(Calendar.MILLISECOND, -1);
//
//        Date tempDateEnd = calendar.getTime();
//        System.out.println(tempDateEnd);

	}

//	private static void capitalize(String valor) {
//		int index = valor.indexOf(" ");
//		System.out.print(valor.substring(0, 1).toUpperCase());
//		while (index >= 0) {
//			System.out.print(
//							!Arrays.asList("e").contains(valor.substring(index+1, index+2)) && 
//							!Arrays.asList("do", "da", "de", "di", "du").contains(valor.substring(index+1, index+3)) && 
//							!Arrays.asList("dos", "das").contains(valor.substring(index+1, index+4)) 
//								? valor.substring(index+1, index+2).toUpperCase() : ""
//							);
//			index = valor.indexOf(" ", index + 1);
//		}
//	}

}
