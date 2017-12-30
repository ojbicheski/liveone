/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.download;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;

import br.com.infoeski.liveone.business.exception.DataException;
import br.com.infoeski.liveone.business.model.util.File;
import br.com.infoeski.liveone.services.rest.BaseService;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public abstract class FileDownload<F extends File> extends BaseService {

	/**
	 * Load File.
	 * 
	 * @param id
	 *            Object identify
	 * @return F Fife reference
	 * @exception DataException
	 */
	protected abstract F loadFile(String id) throws DataException;

	/**
	 * Logger reference.
	 */
	protected static final Logger log = Logger.getLogger(FileDownload.class);

	/**
	 * Recebe a referência do formulário enviado com o arquivo a ser recebido na
	 * criação de um novo Documento.
	 * 
	 * @param reference
	 *            Reference object
	 * @param parts
	 *            {@link List<FormDataBodyPart>}
	 * @return Response
	 */
	@GET
	@Path("/download/{id}")
	@Produces({ MediaType.APPLICATION_OCTET_STREAM })
	public byte[] download(@PathParam("id") String id) {
		try {
			F file = loadFile(id);
			if (file != null) {
				return file.getContent();
			}
		} catch (DataException e) {
			log.error(ERROR_Add_Failure, e);
		}
		return new byte[]{};
	}
}