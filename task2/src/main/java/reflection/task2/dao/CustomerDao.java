package reflection.task2.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.controller.BaseController;
import reflection.task2.model.Account;
import reflection.task2.model.Customer;

public class CustomerDao {

	public BaseController b = new BaseController(new Customer().getClass());
	
	//save object
	public void saveCustomer(Customer customer) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateCustomer(Customer customer) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteCustomer(int id) {
		
		Customer customer = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			customer = session.get(Customer.class, id);
			session.delete(customer);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Customer getCustomerById(int id) {
		
		Customer customer = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			customer = session.get(Customer.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return customer;
		
	}
	
}

