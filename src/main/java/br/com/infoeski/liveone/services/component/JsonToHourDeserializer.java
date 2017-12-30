/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.component;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public class JsonToHourDeserializer extends JsonDeserializer<Date> {

	/**
	 * @see org.codehaus.jackson.map.JsonDeserializer#deserialize(org.codehaus.jackson.JsonParser,
	 *      org.codehaus.jackson.map.DeserializationContext)
	 */
	@Override
	public Date deserialize(JsonParser parser, DeserializationContext context) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

		try {
			return formatter.parse(parser.getText());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
