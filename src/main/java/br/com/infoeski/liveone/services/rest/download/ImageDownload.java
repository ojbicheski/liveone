/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.download;

import javax.annotation.Resource;
import javax.ws.rs.Path;

import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.product.ImageControl;
import br.com.infoeski.liveone.business.exception.DataException;
import br.com.infoeski.liveone.business.model.products.Image;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/image/source")
public class ImageDownload extends FileDownload<Image> {

	@Resource(name = "imageControl")
	private ImageControl control;
	
	/**
	 * @see br.com.infoeski.liveone.services.rest.upload.FileUpload#loadFile(java.util.Map)
	 */
	@Override
	protected Image loadFile(String id) throws DataException {
		return control.get(id);
	}
}
