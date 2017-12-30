/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.product;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.product.TypeVideoControl;
import br.com.infoeski.liveone.business.model.products.TypeVideo;
import br.com.infoeski.liveone.services.rest.crud.CrudService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/typeVideo")
public class TypeVideoService extends CrudService<TypeVideoControl, TypeVideo> {

	@Resource(name = "typeVideoControl")
	private TypeVideoControl control;

	/**
	 * @see br.com.infoeski.liveone.services.rest.BaseService#getControl()
	 */
	@Override
	protected TypeVideoControl getControl() {
		return control;
	}
}
