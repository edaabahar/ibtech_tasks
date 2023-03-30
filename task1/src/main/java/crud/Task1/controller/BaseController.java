package crud.Task1.controller;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import crud.Task1.model.*;

public class BaseController<T> {
	private Session session;
	
	public BaseController(Session session) {
		this.session = session;
	}
	
	public void createData(T model) {
		Transaction transaction = session.beginTransaction();
		session.save(model);
		transaction.commit();
	}
	
	public T getData(T cls, int id) {
		return (T) session.get(cls.getClass(), id);
	}
	
	public List<T> getAllData(Class<T> cls){
		return session.createQuery("from" + cls.getName()).list();
	}
	
	public void updateData(T cls) {
		Transaction transaction = session.beginTransaction();
		session.update(cls);
		transaction.commit();
	}
	
	public void deleteData(T cls) {
		Transaction transaction = session.beginTransaction();
		session.delete(cls);
		transaction.commit();
	}
	
}
