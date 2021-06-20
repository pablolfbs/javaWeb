package com.pablo.ex8;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno aluno = new Aluno();
		
		try {
			aluno.setDataMat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-02-19 15:30"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		System.out.println(aluno.getDataMat());
	}

}
