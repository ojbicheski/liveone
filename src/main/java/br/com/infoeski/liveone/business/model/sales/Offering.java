/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.sales;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.business.model.EntityLiveOne;
import br.com.infoeski.liveone.business.model.products.Product;

/**
 * @author orlei, Orlei Bicheski
 */
@SuppressWarnings("serial")
@Document(collection = "offerings")
@XmlRootElement
public class Offering extends EntityLiveOne {

	/**
	 * Identify that Offering is enabled.
	 */
	@Field
	private boolean enabled;
	
	/**
	 * Price of Product.
	 */
	@Field
	private float price;
	
	/**
	 * Date of the created. 
	 */
	@Field
	private boolean create;
	
	/**
	 * Identifier of Product.
	 */
	@Field
	private String productId;
	
	/**
	 * Transient reference of Product.
	 */
	private Product product;

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * @return the create
	 */
	public boolean isCreate() {
		return create;
	}

	/**
	 * @param create the create to set
	 */
	public void setCreate(boolean create) {
		this.create = create;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}
}
