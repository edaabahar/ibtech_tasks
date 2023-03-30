package crud.Task1.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Customer")
	private Customer customer;
	
	@Column(name="AddressInfo")
	private String AddressInfo;
	
	public Address() {}
	
	public Address(Customer customer, String addressInfo) {
		this.AddressInfo = addressInfo;
		this.customer = customer;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getAddressInfo() {
		return AddressInfo;
	}
	public void setAddressInfo(String address) {
		this.AddressInfo = address;
	}
	
}
