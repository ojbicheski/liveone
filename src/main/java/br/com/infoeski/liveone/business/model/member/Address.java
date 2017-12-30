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
 * Class that support informations of the Member's Address.
 * 
 * @author orlei, Orlei Bicheski
 * 
 */
@SuppressWarnings("serial")
@Document(collection = "addresses")
@XmlRootElement
public class Address extends Entity {

	/**
	 * Field that receive the street name.
	 */
	@Field
	private String street;

	/**
	 * Field that receive the street's number.
	 */
	@Field
	private int number;

	/**
	 * Field that receive the neighborhood name.
	 */
	@Field
	private String neighborhood;

	/**
	 * Field that receive the address's complement.
	 */
	@Field
	private String complement;

	/**
	 * Field that receive the address's post code.
	 */
	@Field
	private String postcode;

	/**
	 * Field that receive the address's city name.
	 */
	@Field
	private String city;

	/**
	 * Field that receive the address's state name.
	 */
	@Field
	private String state;

	/**
	 * Field that receive the address's country name.
	 */
	@Field
	private String country;

	/**
	 * Field that receive the address's country name.
	 */
	@Field
	private TypeAddress type;

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 *            the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * @return the neighborhood
	 */
	public String getNeighborhood() {
		return neighborhood;
	}

	/**
	 * @param neighborhood
	 *            the neighborhood to set
	 */
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}

	/**
	 * @return the complement
	 */
	public String getComplement() {
		return complement;
	}

	/**
	 * @param complement
	 *            the complement to set
	 */
	public void setComplement(String complement) {
		this.complement = complement;
	}

	/**
	 * @return the postcode
	 */
	public String getPostcode() {
		return postcode;
	}

	/**
	 * @param postcode
	 *            the postcode to set
	 */
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the type
	 */
	public TypeAddress getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(TypeAddress type) {
		this.type = type;
	}

	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!getClass().equals(obj.getClass())) {
			return false;
		}

		Address other = (Address) obj;

		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city)) {
			return false;
		}

		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country)) {
			return false;
		}

		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode)) {
			return false;
		}

		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state)) {
			return false;
		}

		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street)) {
			return false;
		}

		return true;
	}
	
	/**
	 * Generated ID for Address.
	 */
	public void generatedId() {
		StringBuffer buffer = new StringBuffer();
		if (getStreet() != null && !getStreet().isEmpty()) {
			buffer.append(getStreet());
		}
		if (getPostcode() != null && !getPostcode().isEmpty()) {
			buffer.append(getPostcode());
		}
		if (getCity() != null && !getCity().isEmpty()) {
			buffer.append(getCity());
		}
		if (getCountry() != null && !getCountry().isEmpty()) {
			buffer.append(getCountry());
		}
		
		if (!buffer.toString().isEmpty()) {
			StringBuffer asc = new StringBuffer();
			char[] chars = buffer.toString().toCharArray();
			for (char c : chars) {
				asc.append((int) c); 
			}
			setId(asc.toString());
		}
	}
}