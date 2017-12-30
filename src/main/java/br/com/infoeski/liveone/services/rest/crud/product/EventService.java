/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.product;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.product.EventControl;
import br.com.infoeski.liveone.business.model.products.Event;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/product/event")
public class EventService extends ProductService<EventControl, Event> {

	@Resource(name = "eventControl")
	private EventControl control;

	/**
	 * @see br.com.infoeski.liveone.services.rest.BaseService#getControl()
	 */
	@Override
	protected EventControl getControl() {
		return control;
	}
}
