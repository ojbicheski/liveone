/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.upload;

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
@Path("/image")
public class ImageUpload extends FileUpload<Image> {

	@Resource(name = "imageControl")
	private ImageControl control;
	
	/**
	 * @see br.com.infoeski.liveone.services.rest.upload.FileUpload#loadFile(java.util.Map)
	 */
	@Override
	protected Image loadFile(Image file) throws DataException {
		return control.add(file);
	}
	
	/**
	 * @see br.com.infoeski.liveone.services.rest.upload.FileUpload#newFile()
	 */
	@Override
	protected Image newFile() {
		return new Image();
	}
}
