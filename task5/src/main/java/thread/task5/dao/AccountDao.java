package thread.task5.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;

import thread.task5.model.Account2;


public class AccountDao {

	public BaseDao b = new BaseDao(new Account2().getClass());
	//save object
	public void saveAccount(Account2 account) {
		
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
	public void updateAccount(Account2 account) {
		
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
		
		Account2 account = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			account = session.get(Account2.class, id);
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
		
		Account2 account = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			account = session.get(Account2.class, id);
			
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


