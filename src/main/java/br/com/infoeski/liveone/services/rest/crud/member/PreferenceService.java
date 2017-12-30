/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.member;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.member.PreferenceControl;
import br.com.infoeski.liveone.business.model.member.Preference;
import br.com.infoeski.liveone.services.rest.crud.CrudService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/preference")
public class PreferenceService extends CrudService<PreferenceControl, Preference> {

	@Resource(name = "preferenceControl")
	private PreferenceControl control;

	/**
	 * @see br.com.infoeski.liveone.services.rest.BaseService#getControl()
	 */
	@Override
	protected PreferenceControl getControl() {
		return control;
	}
}
