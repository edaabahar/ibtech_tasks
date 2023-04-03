package reflection.task2.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.model.Account;

import reflection.task2.controller.BaseController;

public class AccountDao {

	public BaseController b = new BaseController(new Account().getClass());
	//save object
	public void saveAccount(Account account) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(account);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateAccount(Account account) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(account);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteAccount(int id) {
		
		Account account = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			account = session.get(Account.class, id);
			session.delete(account);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Object getAccountById(int id) {
		
		Account account = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			account = session.get(Account.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return account;
		
	}
	
}

