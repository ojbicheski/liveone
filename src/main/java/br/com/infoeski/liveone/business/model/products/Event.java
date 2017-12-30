/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.products;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.map.annotate.JsonDeserialize;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import br.com.infoeski.liveone.services.component.DateToJsonSerializer;
import br.com.infoeski.liveone.services.component.HourToJsonSerializer;
import br.com.infoeski.liveone.services.component.JsonToDateDeserializer;
import br.com.infoeski.liveone.services.component.JsonToHourDeserializer;

/**
 * @author orlei, Orlei Bicheski
 *
 */
@SuppressWarnings("serial")
@Document(collection = "events")
@XmlRootElement
public class Event extends Product {

	/**
	 * Field that receive the date of the Event.
	 */
	@Field
	@JsonSerialize(using = DateToJsonSerializer.class)
	@JsonDeserialize(using = JsonToDateDeserializer.class)
	private Date date;

	/**
	 * Field that receive the date of the Event.
	 */
	@Field
	@JsonSerialize(using = HourToJsonSerializer.class)
	@JsonDeserialize(using = JsonToHourDeserializer.class)
	private Date hour;

	/**
	 * Field that receive calling of the event.
	 */
	@Field
	private String calling;

	/**
	 * Field that receive Place Name of the event.
	 */
	@Field
	private String placeName;

	/**
	 * @return the calling
	 */
	public String getCalling() {
		return calling;
	}

	/**
	 * @param calling the calling to set
	 */
	public void setCalling(String calling) {
		this.calling = calling;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the hour
	 */
	public Date getHour() {
		return hour;
	}

	/**
	 * @param hour the hour to set
	 */
	public void setHour(Date hour) {
		this.hour = hour;
	}

	/**
	 * @return the placeName
	 */
	public String getPlaceName() {
		return placeName;
	}

	/**
	 * @param placeName the placeName to set
	 */
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
}
