package reflection.task2.controller;

import java.util.List;

import java.io.File;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import reflection.task2.model.*;

public class BaseController<T> {
	
	private Class<T> type;
	public BaseController(Class<T> type) {
        this.type = type;
   }
	public SessionFactory getConnection () throws HibernateException{
			File f = new File("hibernate.cfg.xml");
			
			SessionFactory factory=new Configuration().configure(f)
										    		    .addAnnotatedClass(Customer.class)
										    		    .addAnnotatedClass(Address.class)
										    		    .addAnnotatedClass(Account.class)
										    		    .addAnnotatedClass(Commands.class)
										    		    .addAnnotatedClass(Phone.class)
														.buildSessionFactory();
		    return factory;
		}
		
		public void add(T entity) {
			SessionFactory factory=getConnection();
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				session.save(entity);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
		}
		
		public T get(long id) {
			SessionFactory factory=getConnection();
			T c;
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				c=session.get(type,id);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
			return c;
		}
		
		public List<T> getAll() {
			SessionFactory factory=getConnection();
			List<T> data;
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				CriteriaBuilder cb = session.getCriteriaBuilder();
			    CriteriaQuery<T> cq = cb.createQuery(type);
			    Root<T> rootEntry = cq.from(type);
			    CriteriaQuery<T> all = cq.select(rootEntry);
			    TypedQuery<T> allQuery = session.createQuery(all);
			    data=allQuery.getResultList();
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
			return data;
			
		}
		
		public void update(T entity) {
			SessionFactory factory=getConnection();
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				session.saveOrUpdate(entity);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
		}
		
		public void delete(long id) {
			SessionFactory factory=getConnection();
			try (Session session=factory.getCurrentSession()) {
				session.beginTransaction();
				T c=session.get(type,id);
				session.remove(c);
				session.getTransaction().commit();
			}finally {
				factory.close();
			}
		}
}
