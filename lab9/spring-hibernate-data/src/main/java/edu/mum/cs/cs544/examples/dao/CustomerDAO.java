package edu.mum.cs.cs544.examples.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.cs544.examples.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Integer> {
	public List<Customer> findByAddressCityCountry();
}
