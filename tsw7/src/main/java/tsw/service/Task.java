package tsw.service;

import java.util.*;

import tsw.domain.Tswacct;

class Task extends TimerTask {
	
	private TswacctService tswacctService;
	
	int size = 0;
	int count = 0;
	int exceptions = 0;
	
	public Task(TswacctService tswacctService) {
		this.tswacctService = tswacctService;
	}

	// run is a abstract method that defines task performed at scheduled time.
	@Override
	public void run() {


		try {
			Set<Tswacct> tswaccts = tswacctService.loadTswaccts();
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
