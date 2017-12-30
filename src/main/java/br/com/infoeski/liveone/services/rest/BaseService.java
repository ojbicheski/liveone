/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest;

import java.io.IOException;

import javax.annotation.Resource;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;

import br.com.infoeski.liveone.services.component.UserPreference;
import br.com.infoeski.liveone.services.util.Message;

/**
 * @author orlei, Orlei Bicheski
 */
public abstract class BaseService {

	/**
	 * Logger reference.
	 */
	private static final Logger log = Logger.getLogger(BaseService.class);

	protected static final String ERROR_Object_Not_Found = "ERR-0001";
	protected static final String ERROR_No_Object_Found_For_The_Criteria_Entered = "ERR-0002";
	protected static final String ERROR_Add_Failure = "ERR-0003";
	protected static final String ERROR_Edit_Failure = "ERR-0004";
	protected static final String ERROR_Delete_Failure = "ERR-0005";

	protected static final String WARN_Warn = "WRN-0001";

	protected static final String SUCCESS_Operation_Performed_Successfully = "SCS-0001";

	@Resource(name = "preference")
	private UserPreference preference;

	/**
	 * Set preference language.
	 * 
	 * @param language
	 */
	protected void setLang(String language) {
		if (language != null) {
			preference.setLanguage(language);
		}
	}

	/**
	 * Create the Response.
	 * 
	 * @param code
	 *            Code of the Message
	 * @param status
	 *            Status response
	 * @return Response
	 */
	protected Response response(String code, Status status) {
		return response(code, null, status);
	}

	/**
	 * Create the Response.
	 * 
	 * @param code
	 *            Code of the Message
	 * @param result
	 *            Result of the process
	 * @param status
	 *            Status response
	 * @return
	 */
	protected Response response(String code, Object result, Status status) {
		return Response.status(status).entity(json(message(code, result))).build();
	}

	/**
	 * Create the Message.
	 * 
	 * @param code
	 *            Code of the Message
	 * @param result
	 *            Result of the process
	 * @return Message
	 */
	private Message message(String code, Object result) {
		if (result == null) {
			return (new Message()).code(code).message(preference.getMessage(code));
		} else {
			return (new Message()).code(code).message(preference.getMessage(code)).result(result);
		}
	}

	/**
	 * 
	 * @param message Return Message
	 * @return String
	 */
	private String json(Message message) {
		try {
			return new ObjectMapper().writeValueAsString(message);
		} catch (IOException e) {
			log.warn("JSON fail.", e);
		}
		return "";
	}
}
