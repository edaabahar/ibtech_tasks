package reflection.task2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Phone")
public class Phone {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;

	@ManyToOne
	@JoinColumn(name="CustomerId")
	private Customer customer;
	
	@Column(name="PhoneNumber")
	private String PhoneNumber;
	
	public Phone() {}
	
	public Phone(Customer customer, String phoneNumber) {
		this.PhoneNumber = phoneNumber;
		this.customer = customer;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
}
