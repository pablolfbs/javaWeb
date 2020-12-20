package com.pablo.util;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    private static Double stringToDouble(String valor) {
		return Double.parseDouble(valor);
	}
    
}
