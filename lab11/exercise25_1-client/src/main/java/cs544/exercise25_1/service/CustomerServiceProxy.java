package cs544.exercise25_1.service;

import java.util.Collection;

import org.springframework.web.client.RestTemplate;

import cs544.exercise25_1.generated.customer.Customer;
import cs544.exercise25_1.generated.customer.Customers;

public class CustomerServiceProxy implements ICustomerService {

	private static final String customersURL = "http://localhost:8080/exercise25_1-service/rest/customers";
	private static final String customerURL = "http://localhost:8080/exercise25_1-service/rest/customer/{customerNumber}";

	private RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public void addCustomer(Customer customer) {
		restTemplate.postForLocation(customersURL, customer);
	}

	public void deleteCustomer(String customerNumber) {
		restTemplate.delete(customerURL, customerNumber);
	}

	public void updateCustomer(Customer customer) {
		restTemplate.put(customerURL, customer, customer.getCustomerNumber());
	}

	public Collection<Customer> getCustomers() {		
		Customers customers = restTemplate.getForObject(customersURL, Customers.class);
		return customers.getCustomer();
	}

	public Customer getCustomer(String customerNumber) {
		return restTemplate.getForObject(customerURL, Customer.class);
	}

}
