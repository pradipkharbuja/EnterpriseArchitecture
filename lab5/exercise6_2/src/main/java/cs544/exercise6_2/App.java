package cs544.exercise6_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("springconfig.xml");

		IBookService bookService = context.getBean("bookService", IBookService.class);

		Book book1 = context.getBean("book1", Book.class);
		Book book2 = context.getBean("book2", Book.class);
		Book book3 = context.getBean("book3", Book.class);
		
		bookService.buy(book1);
		bookService.buy(book2);
		bookService.buy(book3);
	}
}
