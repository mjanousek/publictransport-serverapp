package com.janousek.publictransport.serverapp.repository;

import com.janousek.publictransport.serverapp.config.MongoDatabaseConfig;
import com.janousek.publictransport.serverapp.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MongoDatabaseConfig.class)
public class CustomerRepositoryTest {

	@Autowired
	CustomerRepository repository;

	@Before
	public void clearDatabase() {
		repository.deleteAll();
	}

	@Test
	public void testSavingCustomers() {

		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		List<Customer> customers = repository.findAll();
		assertEquals(2, customers.size(), "Two customers has been fetched");
	}

}