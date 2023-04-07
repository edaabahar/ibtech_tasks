package thread.task5.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table()
public class BatchData {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Id;
	
	
	@Column(name="SIRANO")
	private int SIRANO;
	
	@Column(name="STATUS")
	private int STATUS;

	@Column(name="ACCOUNTNO")
	private int ACCOUNTNO;

	@Column(name="AMOUNT")
	private double AMOUNT;

	@Column(name="TRANSACTIONTYPE")
	private char TRANSACTIONTYPE;

	public BatchData() {}
		
	public BatchData(int sIRANO, int sTATUS, int aCCOUNTNO, double aMOUNT, char tRANSACTIONTYPE) {
		super();
		SIRANO = sIRANO;
		STATUS = sTATUS;
		ACCOUNTNO = aCCOUNTNO;
		AMOUNT = aMOUNT;
		TRANSACTIONTYPE = tRANSACTIONTYPE;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getSIRANO() {
		return SIRANO;
	}

	public void setSIRANO(int sIRANO) {
		SIRANO = sIRANO;
	}

	public int getSTATUS() {
		return STATUS;
	}

	public void setSTATUS(int sTATUS) {
		STATUS = sTATUS;
	}

	public int getACCOUNTNO() {
		return ACCOUNTNO;
	}

	public void setACCOUNTNO(int aCCOUNTNO) {
		ACCOUNTNO = aCCOUNTNO;
	}

	public double getAMOUNT() {
		return AMOUNT;
	}

	public void setAMOUNT(double aMOUNT) {
		AMOUNT = aMOUNT;
	}

	public char getTRANSACTIONTYPE() {
		return TRANSACTIONTYPE;
	}

	public void setTRANSACTIONTYPE(char tRANSACTIONTYPE) {
		TRANSACTIONTYPE = tRANSACTIONTYPE;
	}
	
}
