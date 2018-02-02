package searching_example;

import java.util.ArrayList;

public class TextExample {

	public static void main(String[] args) {

		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Lakrids");               // 0 
		strings.add("Vingummi");              // 1
		strings.add("Marsbar");               // 2
		strings.add("Twix");                  // 3
		strings.add("Peaunuts");              // 4
		strings.add("Chokolade");             // 5
		strings.add("Bridge blanding");       // 6
		
		int i = SearchingExample.linearSearchList(strings, "Twix");
		int j = strings.indexOf("Twix");
		System.out.println("Twix is found on index: " + i + ". indexOf is "+ j);
	
		i = SearchingExample.linearSearchList(strings, "Bounty"); // Does not exist
		j = strings.indexOf("Bounty");
		System.out.println("Bounty is found on index: " + i + ". indexOf is " + j);
		
		ArrayList<Customer> customer = new ArrayList<Customer>();
		customer.add(new Customer("Ann", 1, 1234));
		customer.add(new Customer("Bente", 2, 3333));
		customer.add(new Customer("Dann", 3, 45555));
		customer.add(new Customer("Finn", 4, 66666));
		customer.add(new Customer("Hans", 5, 77777));
		
		System.out.println("\nLooking for Customer with name Finn:");
		Customer c = SearchingExample.linearSearchCustomer(customer, "Finn"); 
		System.out.println(c);
		
		System.out.println("\nLooking for Customer with name Jane:");
		c = SearchingExample.linearSearchCustomer(customer, "Jane"); // Does not exist
		System.out.println(c);
	}

}
