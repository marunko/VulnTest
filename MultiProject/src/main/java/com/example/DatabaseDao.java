package com.example;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DatabaseDao {

	@Autowired 
	private SessionFactory sessionfactory;
	
	 
	public Customer getCustomer(int id) {
		Query<Customer> query = null;
		Customer customer = null;
		 
		try {
			Session session = sessionfactory.openSession();
			query = session.<Customer>createQuery("FROM Customer C WHERE C.id ="+id);
			customer = query.getSingleResult();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
		
	}
	
	
	public Customer getCustByName(String name) {
		Query<Customer> query = null;
		Customer customer = null;
		 
		try {
			Session session = sessionfactory.openSession();
			query = session.<Customer>createQuery("FROM Customer C WHERE C.name = '"+name+"'");
			customer = query.getSingleResult();
			session.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return customer;
	}
	
	public boolean createUser(Customer c) {
		Session session = sessionfactory.openSession();
		
		Transaction trans = session.beginTransaction();
		try {
			session.save(c);
			trans.commit();
		}
		catch(Exception e) {
			trans.rollback();
			e.printStackTrace();
			return false;
		}
		finally {
			session.close();
		}
		return true;
	}
	 
}
 