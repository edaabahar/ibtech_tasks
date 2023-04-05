package reflection.task2.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.bag.Bag;
import reflection.task2.bag.BagKey;
import reflection.task2.dao.AddressDao;
import reflection.task2.model.*;

public class AddressController {

	AddressDao cd = new AddressDao();
	
	public AddressController() {};
	
	public AddressController(AddressDao cd) {
		this.cd = cd;
	}
	
	public void add(Bag bag) {
		Address address = new Address();
		address.setAddressInfo(bag.getValue(BagKey.ADDRESSINFO).toString());
		
		cd.saveAddress(address);
	}
	
	public void update(Bag bag) {
		Address address = new Address();
		address.setAddressInfo(bag.getValue(BagKey.ADDRESSINFO).toString());
		
		cd.updateAddress(address);
	}
	
	public void delete(Bag bag) {
		int id = (int) bag.getValue(BagKey.ADDRESSID);
		cd.deleteAddress(id);
	}
}
