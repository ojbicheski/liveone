/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.crud.member;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Controller;

import br.com.infoeski.liveone.business.base.control.member.MemberControl;
import br.com.infoeski.liveone.business.model.member.Address;
import br.com.infoeski.liveone.business.model.member.Member;
import br.com.infoeski.liveone.business.model.member.Phone;
import br.com.infoeski.liveone.services.rest.crud.CrudService;

/**
 * @author orlei, Orlei Bicheski
 */
@Controller
@Path("/member")
public class MemberService extends CrudService<MemberControl, Member> {

	@Resource(name = "memberControl")
	private MemberControl control;

	/**
	 * @see br.com.infoeski.liveone.services.rest.BaseService#getControl()
	 */
	@Override
	protected MemberControl getControl() {
		return control;
	}

	@GET
	@Path("/{id}/addresses/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddresses(@PathParam("id") String id) {
		Member entity = getControl().get(id);

		if (entity == null) {
			return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
		} else {
			return response(SUCCESS_Operation_Performed_Successfully, entity.getAddresses(), Response.Status.OK);
		}
	}

	@POST
	@Path("/{id}/address/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveAddress(@PathParam("id") String id, Address address) {
		Member entity = getControl().get(id);
		
		if (entity == null) {
			return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
		}

		entity.addAddress(address);
		
		return save(entity);
	}

	@GET
	@Path("/{id}/address/{idAddress}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAddress(@PathParam("id") String id, @PathParam("idAddress") String idAddress) {
		Member entity = getControl().get(id);

		if (entity != null) {
			Address address = entity.getAddress(idAddress);
			if (address != null) {
				return response(SUCCESS_Operation_Performed_Successfully, address, Response.Status.OK);
			}
		}
		
		return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
	}

	@DELETE
	@Path("/{id}/address/{idAddress}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteAddress(@PathParam("id") String id, @PathParam("idAddress") String idAddress) {
		Member entity = getControl().get(id);
		
		if (entity == null) {
			return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		entity.deleteAddress(idAddress);
		
		return save(entity);
	}

	@GET
	@Path("/{id}/phones/")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhones(@PathParam("id") String id) {
		Member entity = getControl().get(id);

		if (entity == null) {
			return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
		} else {
			return response(SUCCESS_Operation_Performed_Successfully, entity.getPhones(), Response.Status.OK);
		}
	}

	@POST
	@Path("/{id}/phone/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response savePhone(@PathParam("id") String id, Phone phone) {
		Member entity = getControl().get(id);
		
		if (entity == null) {
			return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
		}

		entity.addPhone(phone);
		return save(entity);
	}

	@GET
	@Path("/{id}/phone/{idPhone}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getPhone(@PathParam("id") String id, @PathParam("idPhone") String idPhone) {
		Member entity = getControl().get(id);

		if (entity != null) {
			Phone phone = entity.getPhone(idPhone);
			if (phone != null) {
				return response(SUCCESS_Operation_Performed_Successfully, phone, Response.Status.OK);
			}
		}
		
		return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
	}

	@DELETE
	@Path("/{id}/phone/{idPhone}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePhone(@PathParam("id") String id, @PathParam("idPhone") String idPhone) {
		Member entity = getControl().get(id);
		
		if (entity == null) {
			return response(ERROR_Object_Not_Found, Response.Status.INTERNAL_SERVER_ERROR);
		}
		
		entity.deletePhone(idPhone);
		return save(entity);
	}
}
