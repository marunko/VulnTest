package com.example.daos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.Customer;

@Repository
public class CustomerJDBCDao {

	@Autowired
	private JdbcTemplate template;
	
	@Transactional
	public List<Customer> getAll(){
		 
		return template.query("Select * from customer", new RowMapper<Customer>() {
			@Override
			public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setName(rs.getString("name"));
				customer.setAge(rs.getString("age"));
				return customer;
			}
			
		});
	}
	@Transactional
	@SuppressWarnings({ "deprecation", "unchecked" })
	public Customer getByName(String name) {
		Customer customer = (Customer) template.queryForObject("select * from customer as c where c.name = ?", 
		 new Object[] {name}, 
		 new BeanPropertyRowMapper(Customer.class));
		return customer;
	}
	
	 
	 
	
}
