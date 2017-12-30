/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.products;

import org.codehaus.jackson.annotate.JsonCreator;

/**
 * @author orlei, Orlei Bicheski
 *
 */
public enum Show {
	LIVE, ONDEMAND;
	
	@Override
	public String toString() {
		return name();
	}

	@JsonCreator
	public static Show create(String value) {
		if (value == null) {
			throw new IllegalArgumentException();
		}
		for (Show v : values()) {
			if (value.equals(v.name())) {
				return v;
			}
		}
		throw new IllegalArgumentException();
	}
}
