/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.products;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.business.model.util.File;
import br.com.infoeski.liveone.integration.spring.entity.Entity;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
@SuppressWarnings("serial")
@Document(collection = "images")
@XmlRootElement
public class Image extends Entity implements File {

	/**
	 * Field that check the Image as icon.
	 */
	@Field
	private boolean icon;

	/**
	 * Field that receive Image's name.
	 */
	@Field
	private String name;

	/**
	 * Field that receive Image's MimeType.
	 */
	@Field
	private String mimeType;

	/**
	 * Field that receive Image's content.
	 */
	@Field
	private byte[] content;

	/**
	 * Field that receive Image's Product ID.
	 */
	@Field
	private String product;

	/**
	 * @return the icon
	 */
	public boolean isIcon() {
		return icon;
	}

	/**
	 * @param icon
	 *            the icon to set
	 */
	public void setIcon(boolean icon) {
		this.icon = icon;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the mimeType
	 */
	public String getMimeType() {
		return mimeType;
	}

	/**
	 * @see br.com.infoeski.liveone.business.model.util.File#setFileName(java.lang.String)
	 * 
	 * @param mimeType
	 *            the mimeType to set
	 */
	@Override
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	/**
	 * @see br.com.infoeski.liveone.business.model.util.File#getContent()
	 * 
	 * @return the content
	 */
	@Override
	public byte[] getContent() {
		return content;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(byte[] content) {
		this.content = content;
	}

	/**
	 * @return the product
	 */
	public String getProduct() {
		return product;
	}

	/**
	 * @param product
	 *            the product to set
	 */
	public void setProduct(String product) {
		this.product = product;
	}

	/**
	 * @see br.com.infoeski.liveone.business.model.util.File#setRefernce(java.lang.String)
	 */
	@Override
	public void setRefernce(String refernce) {
		setProduct(refernce);
	}

	/**
	 * @see br.com.infoeski.liveone.business.model.util.File#setFileName(java.lang.String)
	 */
	@Override
	public void setFileName(String fileName) {
		setName(fileName);
	}

	/**
	 * @see br.com.infoeski.liveone.business.model.util.File#setSize(long)
	 */
	@Override
	public void setSize(long size) {
	}

	/**
	 * @see br.com.infoeski.liveone.business.model.util.File#setFile(byte[])
	 */
	@Override
	public void setFile(byte[] file) {
		setContent(file);
	}

}
