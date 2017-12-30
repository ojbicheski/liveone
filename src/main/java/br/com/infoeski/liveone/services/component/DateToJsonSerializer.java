/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.services.component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

/**
 * @author orlei, Orlei Bicheski
 * 
 */
public class DateToJsonSerializer extends JsonSerializer<Date> {

	/**
	 * @see org.codehaus.jackson.map.JsonSerializer#serialize(java.lang.Object,
	 *      org.codehaus.jackson.JsonGenerator,
	 *      org.codehaus.jackson.map.SerializerProvider)
	 */
	@Override
	public void serialize(Date value, JsonGenerator gen, SerializerProvider provider) throws IOException,
			JsonProcessingException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		formatter.setTimeZone(TimeZone.getTimeZone("GMT"));

		gen.writeString(formatter.format(value));
	}
}
