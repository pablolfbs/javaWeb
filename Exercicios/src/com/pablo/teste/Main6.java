package com.pablo.teste;

import java.util.Scanner;

import org.apache.log4j.Logger;

public class Main6 {

	private static Logger logger = Logger.getLogger(Main6.class);
	
	public static void main(String[] args) {
		
		org.apache.log4j.BasicConfigurator.configure();
		
		try (Scanner in = new Scanner(System.in)) {
			
			String s = in.nextLine();

			logger.info(s);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
