/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control;

import java.util.List;

import br.com.infoeski.liveone.business.exception.DataException;

/**
 * BaseControl interface support the sign of basic operations.
 * 
 * @author orlei, Orlei Bicheski
 */
public interface BaseControl<E> {

	/**
	 * Retrieves a single member.
	 */
	E get(String id);

	/**
	 * Adds a new member.
	 */
	E add(E entity) throws DataException;

	/**
	 * Edits an existing member.
	 */
	void edit(E entity) throws DataException;

	/**
	 * Deletes an existing member.
	 */
	void delete(String id) throws DataException;

	/**
	 * Retrieves all members.
	 */
	List<E> getAll();
}
