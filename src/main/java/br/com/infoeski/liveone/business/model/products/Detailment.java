/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.products;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.services.component.DateToJsonSerializer;
import br.com.infoeski.liveone.services.component.JsonToDateDeserializer;

/**
 * @author orlei, Orlei Bicheski
 *
 */
@Document(collection = "detailments")
@XmlRootElement
public class Detailment {

	/**
	 * Field that receive Detailment's description.
	 */
	@Field
	private String description;

	/**
	 * Field that receive Detailment's author.
	 */
	@Field
	private String author;

	/**
	 * Field that receive the publish date of the product.
	 */
	@Field
	@JsonSerialize(using = DateToJsonSerializer.class)
	@JsonDeserialize(using = JsonToDateDeserializer.class)
	private Date publish;

	/**
	 * Field that receive the unpublish date of the product.
	 */
	@Field
	@JsonSerialize(using = DateToJsonSerializer.class)
	@JsonDeserialize(using = JsonToDateDeserializer.class)
	private Date unpublish;

	/**
	 * Field that receive collection detailment's image gallery.
	 */
	private List<Image> gallery;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @return the publish
	 */
	public Date getPublish() {
		return publish;
	}

	/**
	 * @param publish the publish to set
	 */
	public void setPublish(Date publish) {
		this.publish = publish;
	}

	/**
	 * @return the unpublish
	 */
	public Date getUnpublish() {
		return unpublish;
	}

	/**
	 * @param unpublish the unpublish to set
	 */
	public void setUnpublish(Date unpublish) {
		this.unpublish = unpublish;
	}

	/**
	 * @return the gallery
	 */
	public List<Image> getGallery() {
		return gallery;
	}

	/**
	 * @param gallery the gallery to set
	 */
	public void setGallery(List<Image> gallery) {
		this.gallery = gallery;
	}
}
