package com.pablo.util;

public class Utils {

    private Utils() {
        throw new IllegalStateException("Utility class");
    }

    public static Double stringToDouble(String valor) {
		return Double.parseDouble(valor);
    }
    
    public static Double toMetters(Double valor) {
        return valor / 100;
    }
    
}
