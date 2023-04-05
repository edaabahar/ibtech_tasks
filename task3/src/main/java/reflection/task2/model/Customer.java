package reflection.task2.model;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.*;

@Entity
@Table(name = "Customer")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id",nullable=false,unique=true)
	private int Id;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Surname")
	private String Surname;
	
	@Column(name="Email")
	private String Email;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Phone> PhoneNumbers;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Address> Addresses;

	@OneToMany(fetch=FetchType.LAZY, mappedBy = "customer", cascade = CascadeType.ALL)
	private List<Account> Accounts;
	
	public Customer() {}
	
	public Customer(int id, String name, String surname, String email) {
		this.Id = id;
		this.Name = name;
		this.Surname = surname;
		this.Email = email;
	}
	
	public Customer(String name, String surname, String email) {
		this.Name = name;
		this.Surname = surname;
		this.Email = email;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getSurname() {
		return Surname;
	}
	public void setSurname(String surname) {
		Surname = surname;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public List<Phone> getPhoneNumbers() {
		return PhoneNumbers;
	}

	public void setPhoneNumbers(List<Phone> phoneNumbers) {
		PhoneNumbers = phoneNumbers;
	}

	public List<Address> getAddresses() {
		return Addresses;
	}
	public void setAddresses(List<Address> addresses) {
		this.Addresses = addresses;
	}

	public List<Account> getAccounts() {
		return Accounts;
	}

	public void setAccounts(List<Account> accounts) {
		Accounts = accounts;
	}
	
	public void addAddress(Address addressInfo) {
		if (this.Addresses == null)
			this.Addresses = new ArrayList<Address>();
		this.Addresses.add(addressInfo);
		addressInfo.setCustomer(this);
	}
	public void addPhone(Phone phoneNumber) {
		if (this.PhoneNumbers == null){
			this.PhoneNumbers = new ArrayList<Phone>();
		}
		this.PhoneNumbers.add(phoneNumber);
		phoneNumber.setCustomer(this);
	}
	public void addAccount(Account account) {
		if (this.Accounts == null){
			this.Accounts = new ArrayList<Account>();
		}
		this.Accounts.add(account);
		account.setCustomer(this);
	}
}
