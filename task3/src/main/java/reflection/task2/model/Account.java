package reflection.task2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name="Account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="Customer")
	private Customer customer;
	
	@Column(name="CreatedAt")
	private LocalDateTime CreatedAt;
	
	@Column(name="LastUpdatedAt")
	private LocalDateTime LastUpdatedAt;
	
	@Column(name="Balance")
	private double Balance;
	
	public Account() {}
	
	public Account(Customer customer, LocalDateTime localDateTime, LocalDateTime localDateTime2, double balance) {
		this.customer = customer;
		if (this.CreatedAt == null) {
			this.CreatedAt = localDateTime;
			this.LastUpdatedAt = localDateTime;
		}else {
			this.LastUpdatedAt = localDateTime2;
		}
		this.Balance = balance;
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		this.Id = id;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getCreatedAt() {
		return CreatedAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.CreatedAt = createdAt;
	}
	public LocalDateTime getLastUpdatedAt() {
		return LastUpdatedAt;
	}
	public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
		this.LastUpdatedAt = lastUpdatedAt;
	}
	public double getBalance() {
		return Balance;
	}
	public void setBalance(double balance) {
		this.Balance = balance;
	}
	
	
}
