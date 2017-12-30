/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;

import br.com.infoeski.liveone.business.base.control.BaseControl;
import br.com.infoeski.liveone.business.exception.DataException;
import br.com.infoeski.liveone.integration.spring.entity.Entity;
import br.com.infoeski.liveone.services.rest.BaseService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public abstract class CrudService<C extends BaseControl<E>, E extends Entity> extends BaseService {

	/**
	 * Logger reference.
	 */
	protected static final Logger log = Logger.getLogger(CrudService.class);

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response save(E entity) {
		String error = ERROR_Add_Failure;
		try {
			if (entity.hasId()) {
				error = ERROR_Edit_Failure;
				getControl().edit(entity);
			} else {
				getControl().add(entity);
			}

			return response(SUCCESS_Operation_Performed_Successfully, entity.getId(), Response.Status.OK);
		} catch (DataException e) {
			log.error(error, e);
			return response(error, Response.Status.NOT_ACCEPTABLE);
		}
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("id") String id) {
		E entity = getControl().get(id);

		if (entity == null) {
			return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
		} else {
			return response(SUCCESS_Operation_Performed_Successfully, entity, Response.Status.OK);
		}
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") String id) {
		try {
			getControl().delete(id);

			return response(SUCCESS_Operation_Performed_Successfully, Response.Status.OK);
		} catch (DataException e) {
			log.error(ERROR_Delete_Failure, e);
			return response(ERROR_Delete_Failure, Response.Status.INTERNAL_SERVER_ERROR);
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response all() {
		List<E> result = getControl().getAll();

		if (result != null && !result.isEmpty()) {
			return response(SUCCESS_Operation_Performed_Successfully, result, Response.Status.OK);
		} else {
			return response(ERROR_Object_Not_Found, Response.Status.NO_CONTENT);
		}
	}

	/**
	 * Reference of Control.
	 * 
	 * @return C
	 */
	protected abstract C getControl();
}