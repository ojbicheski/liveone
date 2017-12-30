/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.control.CrudControl;
import br.com.infoeski.liveone.business.base.repository.product.TypeVideoRepository;
import br.com.infoeski.liveone.business.model.products.TypeVideo;

/**
 * @author orlei, Orlei Bicheski
 */
@Repository("typeVideoControl")
public class TypeVideoControl extends CrudControl<TypeVideo, TypeVideoRepository> {

	@Autowired
	private TypeVideoRepository repository;

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#getRepository()
	 */
	@Override
	protected TypeVideoRepository getRepository() {
		return repository;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#loadReferences(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	protected void loadReferences(TypeVideo entity) {
	}
}
