package reflection.task2.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.model.*;

public class PhoneController {
	private Session session;
	
	public PhoneController(Session session) {
		this.session = session;
	}
	
	public void add(Phone phone) {
		Transaction transaction = session.beginTransaction();
		session.save(phone);
		transaction.commit();
	}
	
	public void update(Phone phone) {
		Transaction transaction = session.beginTransaction();
		session.update(phone);
		transaction.commit();
	}
	
	public void delete(Phone phone) {
		Transaction transaction = session.beginTransaction();
		session.delete(phone);
		transaction.commit();
	}
}
