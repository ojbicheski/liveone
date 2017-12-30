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
 * Class that support informations of the Member's Phone.
 * 
 * @author orlei, Orlei Bicheski
 *
 */
@SuppressWarnings("serial")
@Document(collection = "phones")
@XmlRootElement
public class Phone extends Entity {

	/**
	 * Field that receive phone number of the member.
	 */
	@Field
	private String number;
	
	/**
	 * Field that receive the phone's Type.
	 */
	@Field
	private TypePhone type;

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}

	/**
	 * @return the type
	 */
	public TypePhone getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypePhone type) {
		this.type = type;
	}

	/**
	 * Generated ID for Phone.
	 */
	public void generatedId() {
		if (getNumber() != null && !getNumber().isEmpty()) {
			StringBuffer asc = new StringBuffer();
			char[] chars = getNumber().toCharArray();
			for (char c : chars) {
				asc.append((int) c); 
			}
			setId(asc.toString());
		}
	}
}
