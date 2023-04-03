package reflection.task2.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.model.*;

public class AccountController {
	private Session session;
	
	public AccountController(Session session) {
		this.session = session;
	}
	
	public void add(Account account) {
		Transaction transaction = session.beginTransaction();
		session.save(account);
		transaction.commit();
	}
	
	public void update(Account account) {
		Transaction transaction = session.beginTransaction();
		session.update(account);
		transaction.commit();
	}
	
	public void delete(Account account) {
		Transaction transaction = session.beginTransaction();
		session.delete(account);
		transaction.commit();
	}
}
