package wsdm.util;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import wsdm.domain.Sport;
import wsdm.rest.SportRest;

class Task extends TimerTask {
	
	private SportRest sportRest;
    private static final Logger LOGGER = 
            Logger.getLogger(Task.class.getName());
    
	int size = 0;
	int count = 0;
	int exceptions = 0;
	
	public Task(SportRest sportRest) {
		this.sportRest = sportRest;
	}

	// run is a abstract method that defines task performed at scheduled time.
	@Override
	public void run() {


		try {
			ArrayList<Sport> sports = (ArrayList<Sport>) sportRest.listSports();
			size=sports.size();
		} catch (Exception e) {
			exceptions++;
			e.printStackTrace();
		}
		count++;
		LOGGER.log(Level.INFO, "wsdm Task: "+count+" - sports.size= "+size);
	}
	
	public String getStatus(){
		return count+" :exceptions="+exceptions+" :size="+size;
	}
}
