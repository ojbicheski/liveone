/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.business.model.products;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author orlei, Orlei Bicheski
 *
 */
@SuppressWarnings("serial")
@Document(collection = "videos")
@XmlRootElement
public class Video extends Product {
}
