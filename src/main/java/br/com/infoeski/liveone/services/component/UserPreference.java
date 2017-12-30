/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.component;

import java.io.Serializable;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@SuppressWarnings("serial")
@Component("preference")
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserPreference implements Serializable {

	/**
	 * User Locale.
	 */
	private Locale language;
	
	/**
	 * Spring Application Context.
	 */
	private ApplicationContext context;

	/**
	 * Constructor.
	 */
	public UserPreference() {
		populate();
	}

	/**
	 * Populate with default Locale in case of parameter language be NULL.
	 */
	public void populate() {
		if (language == null) {
			language = Locale.US;
		}
	}

	/**
	 * @return the language
	 */
	public Locale getLanguage() {
		return language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(String language) {
		if ("en_US".equals(language)) {
			this.language = Locale.US;
		} else if ("en_UK".equals(language)) {
			this.language = Locale.UK;
		}
	}

	/**
	 * Return message 
	 * @param key 
	 * @return String Message
	 */
	public String getMessage(String key) {
		if (context == null) {
			context = new ClassPathXmlApplicationContext("messageContext.xml");
		}
		return context.getMessage(key, null, getLanguage());
	}

}
