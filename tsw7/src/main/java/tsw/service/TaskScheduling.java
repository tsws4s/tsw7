package tsw.service;

import java.util.Timer;


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

		public static void start(TswacctService tswacctService) {
		   if(!isRunning){
				timer = new Timer();
			    // Schedule to run after every 15 mins - 900000
				runTask = new Task(tswacctService);
			    timer.schedule(runTask, 15000, 900000);  
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
