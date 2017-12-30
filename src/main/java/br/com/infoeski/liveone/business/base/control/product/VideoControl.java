/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.base.control.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.infoeski.liveone.business.base.control.CrudControl;
import br.com.infoeski.liveone.business.base.repository.product.TypeVideoRepository;
import br.com.infoeski.liveone.business.base.repository.product.VideoRepository;
import br.com.infoeski.liveone.business.model.products.TypeVideo;
import br.com.infoeski.liveone.business.model.products.Video;

/**
 * @author orlei, Orlei Bicheski
 */
@Repository("videoControl")
public class VideoControl extends CrudControl<Video, VideoRepository> {

	@Autowired
	private VideoRepository repository;

	@Autowired
	private TypeVideoRepository repositoryType;

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#getRepository()
	 */
	@Override
	protected VideoRepository getRepository() {
		return repository;
	}

	/**
	 * @see br.com.infoeski.liveone.business.base.control.CrudControl#loadReferences(br.com.infoeski.liveone.integration.spring.entity.Entity)
	 */
	@Override
	protected void loadReferences(Video entity) {
		if (entity.getType() != null) {
			TypeVideo typeVideo = entity.getType();
			entity.setType(repositoryType.findOne(typeVideo.getId()));
		}
	}
}
