/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control.member;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.control.CrudControl;
import br.com.infoeski.liveone.business.base.repository.member.MemberRepository;
import br.com.infoeski.liveone.business.base.repository.member.PreferenceRepository;
import br.com.infoeski.liveone.business.model.member.Member;
import br.com.infoeski.liveone.business.model.member.Preference;

/**
 * @author orlei, Orlei Bicheski
 */
@Repository("memberControl")
public class MemberControl extends CrudControl<Member, MemberRepository> {

	@Autowired
	private MemberRepository repository;
	
	@Autowired
	private PreferenceRepository preferenceRep;

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#getRepository()
	 */
	@Override
	protected MemberRepository getRepository() {
		return repository;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#loadReferences(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	protected void loadReferences(Member entity) {
		if (entity.getPreferences() != null && !entity.getPreferences().isEmpty()) {
			// Load Preferences
			List<String> idPreferences = new ArrayList<String>();
			for (Preference preference : entity.getPreferences()) {
				idPreferences.add(preference.getId());
			}
			
			if (idPreferences.isEmpty()) {
				entity.clearPreferences();
			} else {
				List<Preference> preferences = new ArrayList<Preference>(preferenceRep.findAll());
				if (preferences != null && !preferences.isEmpty()) {
					entity.setPreferences(preferences);
				} else {
					entity.clearPreferences();
				}
			}
		}
	}
}
