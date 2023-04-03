package reflection.task2.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.model.*;

public class CustomerController {
	private Session session;
	
	public CustomerController() {};
	
	public CustomerController(Session session) {
		this.session = session;
	}
	
	public void add(List<?> list, Customer customer) {
		System.out.println("test");
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
	}
	
	public void UpdateCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.update(customer);
		transaction.commit();
	}
	
	public void DeleteCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.delete(customer);
		transaction.commit();
	}
}
