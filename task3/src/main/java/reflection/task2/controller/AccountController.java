package reflection.task2.controller;

import org.hibernate.Session;
import org.hibernate.Transaction;

import reflection.task2.bag.Bag;
import reflection.task2.bag.BagKey;
import reflection.task2.dao.AccountDao;
import reflection.task2.model.*;
import java.time.LocalDateTime;

public class AccountController {
	AccountDao cd = new AccountDao();
	
	public AccountController() {};
	
	public AccountController(AccountDao cd) {
		this.cd = cd;
	}
	
	public void add(Bag bag) {
		Account account = new Account();
		account.setBalance((double)bag.getValue(BagKey.BALANCE));
		account.setCreatedAt((LocalDateTime)bag.getValue(BagKey.CREATEDAT));
		account.setLastUpdatedAt((LocalDateTime)bag.getValue(BagKey.LASTUPDATEDAT));
		
		cd.saveAccount(account);
}
	
	public void update(Bag bag) {
		Account account = new Account();
		account.setBalance((double)bag.getValue(BagKey.BALANCE));
		account.setCreatedAt((LocalDateTime)bag.getValue(BagKey.CREATEDAT));
		account.setLastUpdatedAt((LocalDateTime)bag.getValue(BagKey.LASTUPDATEDAT));
		
		cd.updateAccount(account);
	}
	
	public void delete(Bag bag) {
		int id = (int) bag.getValue(BagKey.ACCOUNTID);
		cd.deleteAccount(id);
	}
}
