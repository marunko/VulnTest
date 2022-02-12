package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.daos.CustomerSecDao;

@SpringBootTest
public class DaosTest {

	@Autowired 
	private CustomerSecDao csd;
	
	@Test
	public void getOne() {
		Customer customer = csd.getOne("Bob");
		System.out.println(customer.toString());
		Assertions.assertNotEquals(null, customer);
		
	}
}
