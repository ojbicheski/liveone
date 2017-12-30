/**
 * Copyright (c) 2003-2013 Infoeski Consultoria e Informatica Ltda.
 * Todos os direitos reservados.
 */
package br.com.infoeski.liveone.integration.spring.mongodb;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

/**
 * Class that keeps the MongoDB configuration.
 * 
 * @author orlei, Orlei Bicheski
 */
@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

	protected static final Logger log = Logger
			.getLogger(SpringMongoConfig.class);

	/**
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#getDatabaseName()
	 */
	@Override
	protected String getDatabaseName() {
		log.info("Returned database name.");
		return "liveone";
	}

	/**
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#mongo()
	 */
	@Override
	@Bean
	public Mongo mongo() throws Exception {
		log.info("Connected Mongo Client.");
		return new MongoClient("127.0.0.1");
	}

	/**
	 * @see org.springframework.data.mongodb.config.AbstractMongoConfiguration#getUserCredentials()
	 */
	@Override
	protected UserCredentials getUserCredentials() {
		log.info("Returned user credentials.");
		return null;
	}
}
