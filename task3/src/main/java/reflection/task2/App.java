package reflection.task2;

import reflection.task2.model.*;
import reflection.task2.bag.*;
import reflection.task2.controller.*;
import reflection.task2.dao.*;
import reflection.task2.executer.CommandExecuter;

import org.apache.log4j.BasicConfigurator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

public class App 
{
    public static void main( String[] args )
    {    	
    	BasicConfigurator.configure();
    	
//    	List<Customer> customerList = new ArrayList<Customer>();
//        // create new customer object and save it to db with reflection
//        Object cus = new Customer("test", "test", "test@isim.com");
//        
//
//    	BaseController b = new BaseController(new Customer().getClass());
//        
//        CustomerController cc = new CustomerController(b.getConnection().getCurrentSession());
        
        try {
        	Bag customerBag = new Bag();
        	customerBag.putValue(BagKey.NAME, "bag test");
        	customerBag.putValue(BagKey.SURNAME, "surname");
        	customerBag.putValue(BagKey.EMAIL, "bag@test.com2");
        	
        	CommandExecuter.execute("UpdateCustomer", customerBag);
        }catch(Exception e) {
        	e.printStackTrace();
        }
        
    }

}
