/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.rest.upload;

import java.io.IOException;
import java.io.InputStream;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import br.com.infoeski.liveone.business.exception.DataException;
import br.com.infoeski.liveone.business.model.util.File;
import br.com.infoeski.liveone.services.rest.BaseService;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public abstract class FileUpload<F extends File> extends BaseService {

	/**
	 * Load in memory.
	 * 
	 * @param file
	 * @exception DataException
	 */
	protected abstract F loadFile(F file) throws DataException;

	/**
	 * Create new instance File
	 * 
	 * @return F
	 */
	protected abstract F newFile();

	/**
	 * Logger reference.
	 */
	protected static final Logger log = Logger.getLogger(FileUpload.class);

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
	@POST
	@Path("/upload")
	@Consumes({ MediaType.MULTIPART_FORM_DATA })
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response upload(@FormDataParam("file") InputStream input,
			@FormDataParam("file") FormDataContentDisposition fileInfo,
			@FormDataParam("reference") String reference) {
		try {
			F file = newFile();

			file.setRefernce(reference);
			file.setFileName(fileInfo.getFileName());
			file.setSize(fileInfo.getSize());
			//file.setMimeType(mimeType(fileInfo.getParameters()));
			file.setFile(IOUtils.toByteArray(input));

			file = loadFile(file);

			return response(SUCCESS_Operation_Performed_Successfully, file.getId(), Response.Status.OK);
		} catch (DataException | IOException e) {
			log.error(ERROR_Add_Failure, e);
			return response(ERROR_Add_Failure, Response.Status.NOT_ACCEPTABLE);
		}
	}

	/**
	 * INFO: get uploaded mime/type. header sample { Content-Type=[image/png], }
	 */
//	private String mimeType(MultivaluedMap<String, String> header) {
//		return header.getFirst("Content-Type");
//	}
}