package wsdm.util;

import java.util.*;

import wsdm.domain.Sport;
import wsdm.rest.SportRest;

class Task extends TimerTask {
	
	private SportRest sportRest;
	
	int size = 0;
	int count = 0;
	int exceptions = 0;
	
	public Task(SportRest sportRest) {
		this.sportRest = sportRest;
	}

	// run is a abstract method that defines task performed at scheduled time.
	@SuppressWarnings("unchecked")
	@Override
	public void run() {


		try {
			Set<Sport> sports = (Set<Sport>) sportRest.listSports();
			size=sports.size();
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
