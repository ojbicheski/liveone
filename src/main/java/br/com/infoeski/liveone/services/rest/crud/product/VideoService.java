/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.product;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.product.VideoControl;
import br.com.infoeski.liveone.business.model.products.Video;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/product/video")
public class VideoService extends ProductService<VideoControl, Video> {

	@Resource(name = "videoControl")
	private VideoControl control;

	/**
	 * @see br.com.infoeski.liveone.services.rest.BaseService#getControl()
	 */
	@Override
	protected VideoControl getControl() {
		return control;
	}
}
