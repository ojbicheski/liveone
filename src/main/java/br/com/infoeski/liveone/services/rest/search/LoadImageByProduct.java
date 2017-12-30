/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.search.ImageSearch;
import br.com.infoeski.liveone.services.rest.BaseService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@Controller
@Path("/search/image")
public class LoadImageByProduct extends BaseService {

	@Autowired
	private ImageSearch search;

	/**
	 * Load all Preference orderly by TypePreference.
	 * 
	 * @return List<Preference>
	 */
	@GET
	@Path("/product/{id}/gallery")
	@Produces(MediaType.APPLICATION_JSON)
	public Response loadImagesByProductId(@PathParam("id") String id) {
		search.loadImagesByProductId(id);

		if (search.isEmpty()) {
 			return response(ERROR_Object_Not_Found, Response.Status.OK);
		}
		return response(SUCCESS_Operation_Performed_Successfully, search.getResult(), Response.Status.OK);
	}
}
