package crud.Task1;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import crud.Task1.model.*;
import crud.Task1.controller.*;

import java.time.LocalDateTime;

public class App 
{
    public static void main( String[] args )
    {
    	BasicConfigurator.configure();
    	
        BaseController db = new BaseController(getSessionFactory().openSession());
        
        //customer
        Customer customer = new Customer("Eda", "Bahar", "edaabahar@gmail.com");
        Customer customer2 = new Customer("Eda2", "Bahar2", "eda.bahar@ibtech.com.tr");
        
        //address
        Address add1 = new Address(customer, "gebze/kocaeli");
        Address add2 = new Address(customer2, "beşiktaş/istanbul");
        
        //phone
        Phone phone1 = new Phone(customer, "532 222 22 22");
        Phone phone2 = new Phone(customer2, "5321 111 11 11");
        
        //account        
        Account acc1 = new Account(customer,LocalDateTime.now(), LocalDateTime.now(), (double)1000);
        Account acc2 = new Account(customer2,LocalDateTime.now(), LocalDateTime.now(), (double)2000);
        
        //save to db
        customer.addAccount(acc1);
        customer2.addAccount(acc2);
        customer.addPhone(phone1);
        customer2.addPhone(phone2);
        customer.addAddress(add1);;
        customer2.addAddress(add2);
        db.createData(customer);
        db.createData(customer2);
        
        //read data
        System.out.println("read customer name: " + customer.getName());
        
        //update data
        customer.setName("test");
        db.updateData(customer);
        
        acc1.setBalance((double)1500);
        db.updateData(acc1);
        
        //read customer with id
        System.out.println("read customer with its id: " + customer.getId());
        System.out.println(db.getData(customer, customer.getId()));
        
        //delete
        db.deleteData(acc2);
        
    }
    
    public static SessionFactory getSessionFactory() {
    	Configuration cfg = new Configuration()
    		    .addAnnotatedClass(Customer.class)
    		    .addAnnotatedClass(Address.class)
    		    .addAnnotatedClass(Account.class)
    		    .addAnnotatedClass(Phone.class);
    	cfg.configure("crud\\Task1\\hibernate.cfg.xml");
    	return cfg.buildSessionFactory();
    }
}
