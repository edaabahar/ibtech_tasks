package thread.task5.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import thread.task5.model.*;


public class BatchDataDao {

	public BaseDao b = new BaseDao(new BatchData().getClass());
	//save object
	public void saveBatchData(BatchData bd) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.save(bd);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}
	//update object
	public void updateBatchData(BatchData bd) {
		
		Transaction transaction = null;
		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			session.saveOrUpdate(bd);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	
	//delete object
	public void deleteBatchData(int id) {
		
		BatchData bd = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//delete object
			bd = session.get(BatchData.class, id);
			session.delete(bd);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
	}	

	//read object
	public Object getBatchDataById(int id) {
		
		BatchData bd = null;
		
		Transaction transaction = null;

		try(Session session = b.getConnection().openSession()){
			//start transaction
			transaction = session.beginTransaction();
			
			//save object
			bd = session.get(BatchData.class, id);
			
			//commit the transaction
			transaction.commit();
		}catch(Exception e){
			if(transaction != null) {
				transaction.rollback();
			}
		}
		
		return bd;
		
	}
	
	public List<BatchData> getAllData(){
		try {
			Session session = b.getConnection().openSession();
			return session.createQuery("from BatchData").list();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}





