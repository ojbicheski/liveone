/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.util;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public interface File {

	/**
	 * Return Object Identify.
	 * 
	 * @return Identify
	 */
	String getId();

	/**
	 * Return content File.
	 * 
	 * @return byte[]
	 */
	byte[] getContent();

	/**
	 * Set Reference Object.
	 * 
	 * @param refernce
	 */
	void setRefernce(String refernce);

	/**
	 * Set File Name.
	 * 
	 * @param fileName
	 */
	void setFileName(String fileName);

	/**
	 * Set MimeType.
	 * 
	 * @param mimeType
	 */
	void setMimeType(String mimeType);

	/**
	 * Set Size.
	 * 
	 * @param size
	 */
	void setSize(long size);

	/**
	 * Set File.
	 * 
	 * @param file
	 */
	void setFile(byte[] file);
}
