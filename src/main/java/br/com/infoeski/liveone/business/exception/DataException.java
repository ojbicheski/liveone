/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.exception;

/**
 * @author orlei, Orlei Bicheski
 *
 */
@SuppressWarnings("serial")
public class DataException extends Exception {

	/**
	 * @see java.lang.Exception#Exception()
	 */
	public DataException() {
	}

	/**
	 * @see java.lang.Exception#Exception(String)
	 */
	public DataException(String message) {
		super(message);
	}

	/**
	 * @see java.lang.Exception#Exception(Throwable)
	 */
	public DataException(Throwable cause) {
		super(cause);
	}

	/**
	 * @see java.lang.Exception#Exception(String, Throwable)
	 */
	public DataException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @see java.lang.Exception#Exception(String, Throwable, boolean, boolean)
	 */
	public DataException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
