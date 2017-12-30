/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.repository.product;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.infoeski.liveone.business.model.products.TypeVideo;

/**
 * Repository that support the operations of TypeVideo entity.
 * 
 * @author orlei, Orlei Bicheski
 */
public interface TypeVideoRepository extends MongoRepository<TypeVideo, String> {

}
