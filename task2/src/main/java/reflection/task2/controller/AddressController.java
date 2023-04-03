package reflection.task2.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.model.*;

public class AddressController {
	private Session session;
	
	public AddressController(Session session) {
		this.session = session;
	}
	
	public void AddAddress(Address address) {
		Transaction transaction = session.beginTransaction();
		session.save(address);
		transaction.commit();
	}
	
	public void UpdateAddress(Address address) {
		Transaction transaction = session.beginTransaction();
		session.update(address);
		transaction.commit();
	}
	
	public void DeleteAddress(Address address) {
		Transaction transaction = session.beginTransaction();
		session.delete(address);
		transaction.commit();
	}
}
