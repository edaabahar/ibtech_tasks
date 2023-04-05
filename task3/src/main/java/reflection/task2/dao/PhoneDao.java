package reflection.task2.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.controller.BaseController;
import reflection.task2.model.Account;
import reflection.task2.model.Phone;

public class PhoneDao {

	public BaseController b = new BaseController(new Phone().getClass());

	//save object
	public void savePhone(Phone phone) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(phone);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updatePhone(Phone phone) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(phone);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deletePhone(int id) {
		
		Phone phone = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			phone = session.get(Phone.class, id);
			session.delete(phone);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Object getPhoneById(int id) {
		
		Phone phone = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			phone = session.get(Phone.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return phone;
		
	}
	
}
