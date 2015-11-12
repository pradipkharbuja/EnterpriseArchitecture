package cs544.exercise25_1.client;

import java.util.Collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cs544.exercise25_1.generated.customer.Customer;
import cs544.exercise25_1.service.ICustomerService;

public class CustomerApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");
		ICustomerService remoteService = context.getBean("customerServiceProxy", ICustomerService.class);

		// TODO add 3 customers & print customers list
		Customer customer1 = new Customer("C1", "Pradip Kharbuja");
		Customer customer2 = new Customer("C2", "Prithivi Khatri");
		Customer customer3 = new Customer("C3", "Sukrit Adhikari");

		remoteService.addCustomer(customer1);
		remoteService.addCustomer(customer2);
		remoteService.addCustomer(customer3);

		System.out.println(remoteService.getCustomers());
		// remoteService.getCustomers().forEach(System.out::println);

		// TODO update 1 customer & print customers list
		customer1.setName("Bidhut Karki");
		remoteService.updateCustomer(customer1);

		System.out.println(remoteService.getCustomers());

		// TODO delete 1 customer & print customers list
		remoteService.deleteCustomer("C2");
		System.out.println(remoteService.getCustomers());
	}

	public static void printCustomers(Collection<Customer> customers) {
		for (Customer customer : customers) {
			System.out.println(customer.getName() + " " + customer.getCustomerNumber());
		}
		System.out.println();
	}
}
