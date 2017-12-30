/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.search;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.repository.member.PreferenceRepository;
import br.com.infoeski.liveone.business.base.repository.member.TypePreferenceRepository;
import br.com.infoeski.liveone.business.model.member.Preference;
import br.com.infoeski.liveone.business.model.member.TypePreference;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Repository("typePreferenceSearch")
public class TypePreferenceSearch extends Search<TypePreference> {
	
	@Autowired
	private TypePreferenceRepository repository;

	@Autowired
	private PreferenceRepository repPreference;

	/**
	 * Load all Preferences orderly by Field Description of TypePrefence and ASC
	 * direction.
	 */
	public void loadPreferencesByTypePreference() {
		List<TypePreference> types = repository.findAll();
		List<Preference> preferences = repPreference.findAll();
		
		for (TypePreference type : types) {
			for (Preference preference : preferences) {
				if (preference.getType().equals(type)) {
					type.getPreferences().add(preference);
				}
			}
		}
		
		add(types);
	}

}
