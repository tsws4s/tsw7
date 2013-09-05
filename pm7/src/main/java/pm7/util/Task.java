package pm7.util;

import java.util.*;

import pm7.domain.Account;
import pm7.service.AccountService;


class Task extends TimerTask {
	
	private AccountService acctService;
	
	int size = 0;
	int count = 0;
	int exceptions = 0;
	
	public Task(AccountService acctService) {
		this.acctService = acctService;
	}

	// run is a abstract method that defines task performed at scheduled time.
	@Override
	public void run() {


		try {
			Set<Account> tswaccts = acctService.loadAccounts();
			size=tswaccts.size();
		} catch (Exception e) {
			exceptions++;
			e.printStackTrace();
		}
		count++;
		// System.out.println("Task: "+count+" - tswacct.size= "+size);
	}
	
	public String getStatus(){
		return count+" :exceptions="+exceptions+" :size="+size;
	}
}
