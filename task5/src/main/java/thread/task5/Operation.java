package thread.task5;

import java.util.List;

import thread.task5.model.Account2;
import thread.task5.model.BatchData;
import thread.task5.dao.*;

public class Operation implements Runnable {
	
	private int startNumber;
	private int endNumber;
	private List<BatchData> batchData;
	
	public Operation(int startNumber, int endNumber, List<BatchData> batchData) {
		this.startNumber = startNumber;
		this.endNumber = endNumber;
		this.batchData = batchData;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		BatchDataDao batchDataDao = new BatchDataDao();
		AccountDao accountDao = new AccountDao();
		
		for (int i = startNumber; i < endNumber; i++) {
			BatchData bd = batchData.get(i);
			Account2 account = (Account2) accountDao.getAccountById(bd.getACCOUNTNO());
			
			if (bd.getTRANSACTIONTYPE() == 'A') {
				account.setBalance(account.getBalance() + bd.getAMOUNT());
				accountDao.updateAccount(account);
			}else if (bd.getTRANSACTIONTYPE() == 'B') {
				account.setBalance(account.getBalance() - bd.getAMOUNT());
				accountDao.updateAccount(account);
			}else System.out.println("Unknown transaction type");
			
			bd.setSTATUS(1);
			batchDataDao.updateBatchData(bd);
			
			System.out.println(i + ". batch data processed by " + Thread.currentThread().getName());
		}
	}

}
