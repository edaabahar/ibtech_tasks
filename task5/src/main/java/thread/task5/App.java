package thread.task5;

import thread.task5.model.*;
import thread.task5.dao.*;

import java.util.List;
import java.util.stream.Collectors;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



@SuppressWarnings("deprecation")
public class App 
{
    public static void main( String[] args )
    {
        addData();
    }
    
    
    public static void execute(int threadCount) {
    	BatchDataDao batchDataDao = new BatchDataDao();
		List<BatchData> batchDatas = batchDataDao.getAllData();
		
		System.out.println("-->> batchData Size: " + batchDatas.size());
		System.out.println("-->> batchData To Be Processed: " + batchDatas.stream().filter(x -> (x.getSTATUS() == 0)).collect(Collectors.toList()).size());

		int commitCount = batchDatas.size() / threadCount;
		DateFormat dateformat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z");
		ExecutorService executor = Executors.newFixedThreadPool(threadCount);
		for (int i = 0; i < threadCount; i++) {
			Runnable worker =  new Operation(i * commitCount, (i + 1) * commitCount, batchDatas);
			executor.execute(worker);
			
			System.out.println(i + " thread started. " + dateformat.format(new Date(System.currentTimeMillis())));
		}
		executor.shutdown();
		while (!executor.isTerminated()) {
		}
		System.out.println("SON");
    }
    
    public static void addData() {
		
		AccountDao accountDao = new AccountDao();
		BatchDataDao batchDataDao = new BatchDataDao();

		for (int i = 0; i < 100; i++) {
			Account2 account = new Account2("Vadesiz" + i, (Math.random()*1000)+1);
			accountDao.saveAccount(account);

			for (int j = 0; j < 8; j++) {
				
				
				if (j % 2 == 0) {
					BatchData batchData = new BatchData(i, 0, account.getId(),(Math.random()*10) + 1, 'A');
					batchDataDao.saveBatchData(batchData);
					
					
				}else {
					BatchData batchData = new BatchData(i, 0, account.getId(),(Math.random()*10) + 1, 'B');
					batchDataDao.saveBatchData(batchData);	
				}
			}
		}
	}
}
