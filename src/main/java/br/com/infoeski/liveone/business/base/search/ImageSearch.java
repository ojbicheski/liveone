/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.repository.product.ImageRepository;
import br.com.infoeski.liveone.business.model.products.Image;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Repository("imageSearch")
public class ImageSearch extends Search<Image> {

	@Autowired
	private ImageRepository repository;

	/**
	 * Load Images have relationship with Product.
	 * 
	 * @param id
	 *            Identifier of the Product
	 */
	public void loadImagesByProductId(String id) {
		add(repository.findByProductId(id));
	}

}
