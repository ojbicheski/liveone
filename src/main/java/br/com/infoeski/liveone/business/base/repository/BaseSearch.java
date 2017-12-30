/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.repository;

import java.util.List;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public interface BaseSearch<E> {

	/**
	 * Return result by Search.
	 * 
	 * @return List<E>
	 */
	List<E> getResult();

	/**
	 * Verify if the result is Empty.
	 * 
	 * @return boolean
	 */
	boolean isEmpty();
}
