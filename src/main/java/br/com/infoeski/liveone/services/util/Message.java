/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.util;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@SuppressWarnings("serial")
@XmlRootElement
public class Message implements Serializable {

	/**
	 * Message code.<br>
	 * <b>Code list</b>:<br>
	 * Errors:<br>
	 * <ul>
	 * <li>
	 * Code: ERR-0001<br>
	 * Message: Object not found</li>
	 * <li>
	 * Code: ERR-0002<br>
	 * Message: No object found for the criteria entered</li>
	 * </ul>
	 * Warn:<br>
	 * <ul>
	 * <li>WRN-0000</li>
	 * </ul>
	 * Success:<br>
	 * <ul>
	 * <li>
	 * Code: SCS-0000<br>
	 * Message: Operation performed successfully</li>
	 * </ul>
	 */
	private String code;

	/**
	 * Message text.
	 */
	private String message;

	/**
	 * Object used in case of return.
	 */
	private Serializable result;

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public Message code(String code) {
		this.code = code;
		return this;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public Message message(String message) {
		this.message = message;
		return this;
	}

	/**
	 * @return the result
	 */
	public Object getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	public Message result(Object result) {
		this.result = (Serializable) result;
		return this;
	}

}
