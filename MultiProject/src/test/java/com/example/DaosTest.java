package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.daos.CustomerJDBCDao;
import com.example.daos.CustomerSecDao;

@SpringBootTest
public class DaosTest {

	@Autowired 
	private CustomerSecDao csd;
	@Autowired 
	private CustomerJDBCDao jdbcdao;
	@Test
	public void getOne() {
		Customer customer = csd.getOne("Bob");
		System.out.println(customer.toString());
		Assertions.assertNotEquals(null, customer);
		
	}
	@Test
	public void getTwo() {
		jdbcdao.getAll().stream().forEach(System.out::println);
		
	}
	@Test
	public void getThree() {
		 
		System.out.println(jdbcdao.getByName("Mob"));
		
	}
	
}
