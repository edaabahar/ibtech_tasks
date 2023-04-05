package reflection.task2.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.bag.Bag;
import reflection.task2.bag.BagKey;
import reflection.task2.dao.PhoneDao;
import reflection.task2.model.*;

public class PhoneController {
	PhoneDao cd = new PhoneDao();
	
	public PhoneController() {};
	
	public PhoneController(PhoneDao cd) {
		this.cd = cd;
	}
	
	public void add(Bag bag) {
		Phone phone = new Phone();
		phone.setPhoneNumber(bag.getValue(BagKey.PHONENUMBER).toString());
		
		cd.savePhone(phone);
	}
	
	public void update(Bag bag) {
		Phone phone = new Phone();
		phone.setPhoneNumber(bag.getValue(BagKey.PHONENUMBER).toString());
		
		cd.updatePhone(phone);
	}
	
	public void delete(Bag bag) {
		int id = (int) bag.getValue(BagKey.PHONEID);
		cd.deletePhone(id);
	}
}
