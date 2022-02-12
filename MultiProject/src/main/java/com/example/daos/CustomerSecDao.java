package com.example.daos;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.Customer;

@Repository
public class CustomerSecDao {

	// Here use criteria builders 
	
	@Autowired
	private SessionFactory sf;
	
	public Customer getOne(String name) {
		Session session = sf.openSession();
	      Transaction tx = null;
	      Optional<Customer> customer= null;
	      try {
	         tx = session.beginTransaction();
	         
	         @SuppressWarnings("deprecation")
			Criteria cr = session.createCriteria(Customer.class);
	         // Add restriction.
	         cr.add(Restrictions.eq("name", name));
	         customer = cr.list().stream().findAny();
	       
	          
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
		return customer.orElseThrow();
	}
}
