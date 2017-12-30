/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.control.CrudControl;
import br.com.infoeski.liveone.business.base.repository.member.PreferenceRepository;
import br.com.infoeski.liveone.business.base.repository.member.TypePreferenceRepository;
import br.com.infoeski.liveone.business.model.member.Preference;
import br.com.infoeski.liveone.business.model.member.TypePreference;

/**
 * @author orlei, Orlei Bicheski
 */
@Repository("preferenceControl")
public class PreferenceControl extends CrudControl<Preference, PreferenceRepository> {

	@Autowired
	private PreferenceRepository repository;

	@Autowired
	private TypePreferenceRepository repositoryType;

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#getRepository()
	 */
	@Override
	protected PreferenceRepository getRepository() {
		return repository;
	}
	
	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#loadReferences(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	protected void loadReferences(Preference entity) {
		if (entity.getType() != null) {
			TypePreference typePreference = entity.getType();
			entity.setType(repositoryType.findOne(typePreference.getId()));
		}
	}
}
