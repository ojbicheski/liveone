/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.control.CrudControl;
import br.com.infoeski.liveone.business.base.repository.member.TypePreferenceRepository;
import br.com.infoeski.liveone.business.model.member.TypePreference;

/**
 * @author orlei, Orlei Bicheski
 */
@Repository("typePreferenceControl")
public class TypePreferenceControl extends CrudControl<TypePreference, TypePreferenceRepository> {

	@Autowired
	private TypePreferenceRepository repository;

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#getRepository()
	 */
	@Override
	protected TypePreferenceRepository getRepository() {
		return repository;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#loadReferences(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	protected void loadReferences(TypePreference entity) {
	}
}
