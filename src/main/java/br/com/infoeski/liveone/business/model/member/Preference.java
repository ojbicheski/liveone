/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.member;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.integration.spring.entity.Entity;

/**
 * Class that support basic informations of the Preference.
 * 
 * @author orlei, Orlei Bicheski
 *
 */
@SuppressWarnings("serial")
@Document(collection = "preferences")
@XmlRootElement
public class Preference extends Entity {

	/**
	 * Field that receive description of the Preference.
	 */
	@Field
	private String description;
	
	/**
	 * Field with the reference of the Type.
	 */
	@Field
	private TypePreference type;

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
	 * @return the type
	 */
	public TypePreference getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypePreference type) {
		this.type = type;
	}
}
