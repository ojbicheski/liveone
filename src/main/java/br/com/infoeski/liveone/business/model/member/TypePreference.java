/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.member;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.integration.spring.entity.Entity;

/**
 * Class that support basic informations of the TypePreference.
 * 
 * @author orlei, Orlei Bicheski
 *
 */
@SuppressWarnings("serial")
@Document(collection = "typesPreference")
@XmlRootElement
public class TypePreference extends Entity {
	
	/**
	 * Field that receive description of the TypePreference.
	 */
	@Field
	private String description;
	
	/**
	 * Transient preferences list.
	 */
	private List<Preference> preferences;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the preferences
	 */
	public List<Preference> getPreferences() {
		if (preferences == null) {
			preferences = new ArrayList<Preference>();
		}
		return preferences;
	}

}
