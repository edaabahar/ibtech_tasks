package thread.task5.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.time.LocalDateTime;


@Entity
@Table(name="Account2")
public class Account2 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	

	@Column(name="AccountNo") 
	private String accountNo;
	
	@Column(name="Balance")
	private double Balance;
	
	public Account2() {}
	
	public Account2(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.Balance = balance;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getBalance() {
		return Balance;
	}

	public void setBalance(double balance) {
		Balance = balance;
	}

	
}

