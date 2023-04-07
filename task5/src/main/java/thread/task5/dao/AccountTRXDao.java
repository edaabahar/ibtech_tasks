package thread.task5.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import thread.task5.model.*;


public class AccountTRXDao {

	public BaseDao b = new BaseDao(new AccountTRX().getClass());
	//save object
	public void saveAccountTRX(AccountTRX accounttrx) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(accounttrx);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateAccountTRX(AccountTRX accounttrx) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(accounttrx);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteAccountTRX(int id) {
		
		AccountTRX accounttrx = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			accounttrx = session.get(AccountTRX.class, id);
			session.delete(accounttrx);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Object getAccountTRXById(int id) {
		
		AccountTRX accounttrx = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			accounttrx = session.get(AccountTRX.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return accounttrx;
		
	}
	
}


