/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.member;

import org.codehaus.jackson.annotate.JsonCreator;

/**
 * @author orlei, Orlei Bicheski
 */
public enum TypePhone {
	
	CELLPHONE, RESIDENTIALPHONE, COMMERCIALPHONE;

	@Override
	public String toString() {
		return name();
	}

	@JsonCreator
	public static TypePhone create(String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		for (TypePhone v : values()) {
			if (value.equals(v.name())) {
				return v;
			}
		}
		throw new IllegalArgumentException();
	}

}
