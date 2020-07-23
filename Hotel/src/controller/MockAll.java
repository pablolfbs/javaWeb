package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

public class MockAll implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String json = new Gson().toJson(Ctrl.mockAll());
		
		response.setContentType("application/json");
		response.getOutputStream().write(json.getBytes());
		response.flushBuffer();
		return json;
	}

}
