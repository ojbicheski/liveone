/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.repository.product;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import br.com.infoeski.liveone.business.model.products.Image;

/**
 * Repository that support the operations of Image entity.
 * 
 * @author orlei, Orlei Bicheski
 */
public interface ImageRepository extends MongoRepository<Image, String> {

	/**
	 * Search Images that have specific Product ID.
	 * 
	 * @param id
	 *            Identifier of Product.
	 * @return List<Image>
	 */
	@Query(value = "{ 'product' : ?0 }", fields = "{ 'id' : 1, 'name' : 1, 'icon' : 1, 'product' : 1 }")
	List<Image> findByProductId(String id);


	/**
	 * Search Images that have specific Product ID.
	 * 
	 * @param id
	 *            Identifier of Product.
	 * @return List<Image>
	 */
	@Query(value = "{ 'icon' : true, 'product' : ?0 }")
	List<Image> findIconByProductId(String id);
}
