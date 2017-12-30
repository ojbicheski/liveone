/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.control.CrudControl;
import br.com.infoeski.liveone.business.base.repository.product.ImageRepository;
import br.com.infoeski.liveone.business.exception.DataException;
import br.com.infoeski.liveone.business.model.products.Image;

/**
 * @author orlei, Orlei Bicheski
 */
@Repository("imageControl")
public class ImageControl extends CrudControl<Image, ImageRepository> {

	@Autowired
	private ImageRepository repository;

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#getRepository()
	 */
	@Override
	protected ImageRepository getRepository() {
		return repository;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#loadReferences(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	protected void loadReferences(Image entity) {
	}

	/**
	 * Active a specific image as the new Icon of the specific Product.
	 * 
	 * @param id
	 *            Object identify of Image
	 * @param productId
	 *            Object identify of Product
	 * @throws DataException
	 */
	public void activateIcon(String id, String productId) throws DataException {
		if (logger.isDebugEnabled()) {
			logger.debug("Retrieving an existing object. Class name: ".concat(this.getClass().getName()));
		}

		// Deactivate old Icons
		List<Image> deactivates = repository.findIconByProductId(productId);
		for (Image deactivate : deactivates) {
			deactivate.setIcon(false);
			edit(deactivate);
		}

		// Active new Icon
		Image activate = repository.findOne(id);
		activate.setIcon(true);
		edit(activate);
	}
}
