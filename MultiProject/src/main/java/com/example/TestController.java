package com.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.App; // external local custom library (added through maven install)

@Controller
public class TestController {
 
	@Autowired
	DatabaseDao db;
	
 
	@GetMapping()
	public String index() {
		return "index";
	}
	
	@ResponseBody
	@GetMapping("/db")
	public String getCity(@RequestParam("id") int id) {
		 
		return db.getCustomer(id).toString();
	}
	
	@ResponseBody
	@GetMapping("/dbs")
	public String getCityByName(@RequestParam("name") String name) {
		 
		return db.getCustByName(name).toString();
	}
	 
	@GetMapping("/second")
	public String getSecond() {
		return "second";
	}
	
	
}
