package com.janousek.publictransport.serverapp.config;

import com.janousek.publictransport.serverapp.repository.CustomerRepository;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackageClasses = CustomerRepository.class)
public class MongoDatabaseConfig extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		return "publictransport";
	}

	@Bean
	@Override
	public MongoClient mongoClient() {
		MongoClient client = new MongoClient("localhost");
		return client;
	}

	@Bean
	public MongoTemplate mongoTemplate() throws Exception {
		return new MongoTemplate(mongoClient(), getDatabaseName());
	}
}
