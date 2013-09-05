package pm7.util;

import java.util.Timer;

import pm7.service.AccountService;


public class TaskScheduling {

private static boolean isRunning = false;
private static Task runTask = null;
private static Timer timer =  null;
	   
	   public static String getStatus(){
		   if(runTask==null){
			   return "Is Running: "+isRunning+" - runTask = null";
		   }
		   return "Is Running: "+isRunning+" - "+runTask.getStatus();
	   }

		public static void start(AccountService acctService) {
		   if(!isRunning){
				timer = new Timer();
			    // Schedule to run after every 15 mins - 900000
				runTask = new Task(acctService);
			    timer.schedule(runTask, 15000, 600000);  
			    isRunning = true;
		   }
	   }  
	   
	   public static void stop() {
		   if(isRunning){
			   runTask.cancel();
			   timer.cancel();  
			    isRunning = false;
		   }
	   }
  
}
