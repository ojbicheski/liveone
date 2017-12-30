/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.repository.product;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.infoeski.liveone.business.model.products.Event;

/**
 * Repository that support the operations of Event entity.
 * 
 * @author orlei, Orlei Bicheski
 */
public interface EventRepository extends MongoRepository<Event, String> {

}
