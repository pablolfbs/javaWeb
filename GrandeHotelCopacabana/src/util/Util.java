package util;

public class Util {

	public static String formataCpf(String cpf) {
		try {
			if (cpf.length() == 11)
				return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
						+ cpf.substring(9, 11));

		} catch (Exception e) {
			e.printStackTrace();
		}
		return cpf;
	}
}
