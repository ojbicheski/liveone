/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.presentation.component.js;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public class JS {

	/**
	 * Logger reference.
	 */
	private static final Logger log = Logger.getLogger(JS.class);

	/**
	 * URL service RESTFul.
	 */
	private String url;

	/**
	 * File name.
	 */
	private String fileName;

	/**
	 * Buffer to JS file.
	 */
	private StringBuffer buffer = new StringBuffer();

	/**
	 * Constructor.
	 */
	public JS(String fileName, String url) {
		this.fileName = fileName;
		this.url = url;
		load();
	}

	/**
	 * Load file JS.
	 */
	private void load() {
		try {
			InputStream stream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

			String line;
			while ((line = reader.readLine()) != null) {
				buffer.append(line).append("\n");
			}
			stream.close();
		} catch (IOException e) {
			log.error("Failure load JS file ".concat(fileName).concat("."), e);
		}
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (buffer != null && !buffer.toString().isEmpty()) {
			return buffer.toString().replace("[#URL]", url);
		}
		return "";
	}

}
