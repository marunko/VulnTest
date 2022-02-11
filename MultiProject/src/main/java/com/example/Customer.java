package com.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity 
@Table(name="customer")
@Data
public class Customer {

	@Id
	private int id;
	
	@Column(name="name")
	String name;
	
	@Column(name="age")
	String age;
	
	@Override
	public String toString() {
		return id+" " + name+" " + age;
	}
}
