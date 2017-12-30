/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.member;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.member.TypePreferenceControl;
import br.com.infoeski.liveone.business.model.member.TypePreference;
import br.com.infoeski.liveone.services.rest.crud.CrudService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/typePreference")
public class TypePreferenceService extends CrudService<TypePreferenceControl, TypePreference> {

	@Resource(name = "typePreferenceControl")
	private TypePreferenceControl control;

	/**
	 * @see br.com.infoeski.liveone.services.rest.BaseService#getControl()
	 */
	@Override
	protected TypePreferenceControl getControl() {
		return control;
	}
}
