/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.search;

import java.util.ArrayList;
import java.util.List;

import br.com.infoeski.liveone.business.base.repository.BaseSearch;
import br.com.infoeski.liveone.integration.spring.entity.Entity;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public class Search<E extends Entity> implements BaseSearch<E> {

	/**
	 * Result of Search.
	 */
	private List<E> result = new ArrayList<E>();

	/**
	 * @see br.com.infoeski.liveone.business.base.repository.BaseSearch#getResult()
	 */
	@Override
	public List<E> getResult() {
		return result;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.repository.BaseSearch#isEmpty()
	 */
	@Override
	public boolean isEmpty() {
		return result.isEmpty();
	}

	/**
	 * Add result of Search.
	 * 
	 * @param values
	 *            List values
	 */
	protected void add(List<E> values) {
		result.clear();
		if (values != null && !values.isEmpty()) {
			result.addAll(values);
		}
	}
}
