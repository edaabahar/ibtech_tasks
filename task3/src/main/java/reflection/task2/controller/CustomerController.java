package reflection.task2.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.model.*;
import reflection.task2.bag.*;
import reflection.task2.dao.*;


public class CustomerController {
	
	CustomerDao cd = new CustomerDao();
	
	public CustomerController() {};
	
	public CustomerController(CustomerDao cd) {
		this.cd = cd;
	}
	
	public void add(Bag bag) { // tek parametre bag olsun geleni işle
		Customer customer = new Customer();
		customer.setName(bag.getValue(BagKey.NAME).toString());
		customer.setSurname(bag.getValue(BagKey.SURNAME).toString());
		customer.setEmail(bag.getValue(BagKey.EMAIL).toString());
		
		cd.saveCustomer(customer);
	}
	
	public void update(Bag bag) {
		Customer customer = new Customer();
		customer.setName(bag.getValue(BagKey.NAME).toString());
		customer.setSurname(bag.getValue(BagKey.SURNAME).toString());
		customer.setEmail(bag.getValue(BagKey.EMAIL).toString());
		
		cd.updateCustomer(customer);
	}
	
	public void delete(Bag bag) {
		int id = (int) bag.getValue(BagKey.CUSTOMERID);
		
		cd.deleteCustomer(id);
	}
}
