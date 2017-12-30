/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.product;

import javax.annotation.Resource;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.product.ImageControl;
import br.com.infoeski.liveone.business.exception.DataException;
import br.com.infoeski.liveone.services.rest.BaseService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/product/image")
public class ImageService extends BaseService {

	/**
	 * Logger reference.
	 */
	protected static final Logger log = Logger.getLogger(ImageService.class);

	/**
	 * ImageControl reference.
	 */
	@Resource(name = "imageControl")
	private ImageControl control;

	/**
	 * Delete specific Image by ID.
	 * 
	 * @param id
	 *            Object identify
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {
		try {
			control.delete(id);

			return response(SUCCESS_Operation_Performed_Successfully, Response.Status.OK);
		} catch (DataException e) {
			log.error(ERROR_Delete_Failure, e);
			return response(ERROR_Delete_Failure, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	/**
	 * Delete specific Image by ID.
	 * 
	 * @param id
	 *            Object identify
	 * @return
	 */
	@GET
	@Path("/{id}/icon/activate/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response activateIcon(@PathParam("id") String id, @PathParam("productId")  String productId) {
		try {
			control.activateIcon(id, productId);

			return response(SUCCESS_Operation_Performed_Successfully, Response.Status.OK);
		} catch (DataException e) {
			log.error(ERROR_Delete_Failure, e);
			return response(ERROR_Delete_Failure, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}
}
