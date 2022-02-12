package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.example.Customer;
import com.example.DatabaseDao;

@Controller
public class FormController {

	@Autowired
	private DatabaseDao db;
	
	
	@GetMapping("/form")
	public String getForm(Model model) {
		 model.addAttribute("customer", new Customer());
		return "form";
	}
	
	@PostMapping("/submit")//use Requestparams()
	public RedirectView  postForm(@ModelAttribute Customer c, Model model) {
		// action 
		model.addAttribute("customer", c);
		System.out.println(c.toString());
		if(db.createUser(c))
			return new RedirectView("success");
		else return new RedirectView("failure");
	}
	
	@ResponseBody
	@GetMapping("/success")
	public String getSucc() {
		return "Success";
		
	}
	@ResponseBody
	@GetMapping("/failure")
	public String getFailure() {
		return "Fail";
		
	}
}
