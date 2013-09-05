package timeslot.service;

import java.util.ArrayList;

import org.joda.time.DateTime;

import timeslot.domain.DButils;
import timeslot.domain.DateUtil;
import timeslot.domain.ScheduleDateTST;
import timeslot.domain.Timeslotstst;

public class TimeslotTest {

	/**
	 * @param args
	 */
public static void main(String[] args) {

		DateTime forDate = DateUtil.parseDateString("2015-01-25");
	for(int wks=0;wks<65;wks++){
		ArrayList<ScheduleDateTST> sdWk = SchedulePatterns.createScheduleDateWeek(forDate.plusWeeks(wks));
		DButils db = new DButils();
		String sql = null;	
		int nextId = db.getNextId()+1;

		for(int i=0;i<7;i++){
			ScheduleDateTST sdTST = sdWk.get(i);
			System.out.print(DateUtil.formatDate(sdTST.getSlotDate(), DateUtil.FORMAT_YYYY_MM_DD));
			for(int j=1;j<18;j++){
				Timeslotstst timeslotstst = sdTST.getTimeSlot(j);
				sql = timeslotstst.getSQLinsertStmt(db, nextId++);
				System.out.print("."+nextId);
				try {
					db.getStatement().execute(sql);
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}
			System.out.println("*");
		}
	}
}

}
