/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.presentation.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.infoeski.liveone.presentation.component.js.JS;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@SuppressWarnings("serial")
public class JSServlet extends HttpServlet {
	
	private static Map<String, JS> files = new HashMap<String, JS>();
	
	/**
	 * @see javax.servlet.http.HttpServlet#service(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {
		PrintWriter writer = response.getWriter();
		
		response.addHeader("mime/type", "application/javascript");
		
		String[] split = request.getRequestURL().toString().split("/js/");
		if (split != null && split.length == 2) {
			JS script = null;
			if(files.containsKey(split[1])) {
				script = files.get(split[1]);
			} else {
				script = new JS(split[1], split[0]);
				files.put(split[1], script);
			}
			if (script != null) {
				writer.print(script.toString());
			}
		} else {
			for (String key : files.keySet()) {
				writer.print(key);
				writer.print("\n");
			}
		}

		writer.flush();
		writer.close();
	}
}
