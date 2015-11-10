package edu.mum.cs.cs544.examples.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.mum.cs.cs544.examples.dao.CustomerDAO;
import edu.mum.cs.cs544.examples.entity.Country;
import edu.mum.cs.cs544.examples.entity.Customer;

@Component
public class CustomerServiceImpl implements CustomerService {

    SessionFactory sessionFactory;
    
	@Autowired
	CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    
	public List<Customer> getAllCustomers() {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		// Get a list of all customers
		List<Customer> customers    = customerDAO.findAll();
		tx.commit();
		
		return customers;
	}

	public List<Customer> getCustomerList(Country country) {
		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		// Get a list of all customers for a particular country
		List<Customer> customers   = customerDAO.findAll();
		tx.commit();
		
		return customers;
	}
	
	
}
