/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.control.CrudControl;
import br.com.infoeski.liveone.business.base.repository.product.EventRepository;
import br.com.infoeski.liveone.business.model.products.Event;

/**
 * @author orlei, Orlei Bicheski
 */
@Repository("eventControl")
public class EventControl extends CrudControl<Event, EventRepository> {

	@Autowired
	private EventRepository repository;

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#getRepository()
	 */
	@Override
	protected EventRepository getRepository() {
		return repository;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#loadReferences(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	protected void loadReferences(Event entity) {
	}
}
