/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.repository.member;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.infoeski.liveone.business.model.member.Preference;

/**
 * Repository that support the operations of Preference entity.
 * 
 * @author orlei, Orlei Bicheski
 */
public interface PreferenceRepository extends MongoRepository<Preference, String> {

	/**
	 * Search all preferences that have specific TypePreference.
	 * 
	 * @param id
	 *            Identifier of TypePreference.
	 * @return List<Preference>
	 */
	@Query("{ f_entity_type: { _id: '?0' } }")
	List<Preference> findByThePreferencesTypePreference(String id);
}
