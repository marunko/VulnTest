package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Customer;
import com.example.DatabaseDao;
import com.example.daos.CustomerSecDao;

@Controller
public class SearchController {

	// Checking equals in Hibernate and MySql 
	// Clauses 
	// OR 1=1, Union table Select
	
	@Autowired
	private DatabaseDao db;
	@Autowired 
	private CustomerSecDao csd;
	
	@GetMapping("/search")
	public String getSearch() {
		return "search";
	}
	
	
	@ResponseBody
	@PostMapping("/findbyname")
	public ResponseEntity<Customer> getResult(@RequestParam("value") String value){
		Customer customer = db.getCustByName(value);
		return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@ResponseBody
	@PostMapping("/findbycriterianame")
	public ResponseEntity<Customer> getResultCriteria(@RequestParam("value") String value){
		Customer customer = csd.getOne(value);
		return customer != null ? new ResponseEntity<>(customer, HttpStatus.OK) 
				: new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
