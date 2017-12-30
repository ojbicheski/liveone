/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.products;

import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.integration.spring.entity.Entity;

/**
 * @author orlei, Orlei Bicheski
 */
@SuppressWarnings("serial")
public abstract class Product extends Entity {

	/**
	 * Product Name.
	 */
	@Field
	private String name;

	/**
	 * Product Summary.
	 */
	@Field
	private String summary;

	/**
	 * Field that sign the product as private. Just members that paid by Video.
	 */
	@Field
	private String deprived;
	
	/**
	 * Field with the reference of the Product's Detailment.
	 */
	@Field
	private Detailment detailment;

	/**
	 * Video URL.
	 */
	@Field
	private String url;
	
	/**
	 * Field with the reference of the Video's Type.
	 */
	@Field
	private TypeVideo type;
	
	/**
	 * Field with the reference of the Video's Show.
	 */
	@Field
	private Show show;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param summary the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

	/**
	 * @return the deprived
	 */
	public String getDeprived() {
		return deprived;
	}

	/**
	 * @param deprived the deprived to set
	 */
	public void setDeprived(String deprived) {
		this.deprived = deprived;
	}

	/**
	 * @return the detailment
	 */
	public Detailment getDetailment() {
		return detailment;
	}

	/**
	 * @param detailment the detailment to set
	 */
	public void setDetailment(Detailment detailment) {
		this.detailment = detailment;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the type
	 */
	public TypeVideo getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(TypeVideo type) {
		this.type = type;
	}

	/**
	 * @return the show
	 */
	public Show getShow() {
		return show;
	}

	/**
	 * @param show the show to set
	 */
	public void setShow(Show show) {
		this.show = show;
	}
	
}
