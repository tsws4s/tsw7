package timeslot.service;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import org.joda.time.DateTime;

import timeslot.domain.DateUtil;
import timeslot.domain.ScheduleDateTST;
import timeslot.domain.Timeslotstst;

public class SchedulePatterns { 
	public static String PRICE_LEVEL_A="A";
	public static String PRICE_LEVEL_B="B";
	public static String PRICE_LEVEL_C="C";
	
	public static String WEEKDAY_MTWRF="MTWRF";
	public static String WEEKDAY_SS="SS";

	// set defaults
	public static int ACTIVE_YN=1;
	public static int BELONGS_TO=1;
	public static String CUST_DISPLAY="";
	public static int MODIFIED_BY=7;
	public static int T3S_FK=1;
	
	public static ArrayList<ScheduleDateTST> createScheduleDateWeek(DateTime forDate){
		
		ArrayList<ScheduleDateTST> sdWk = new ArrayList<ScheduleDateTST>();
		sdWk.add(SchedulePatterns.createScheduleDatePatternFor(forDate, SchedulePatterns.WEEKDAY_SS));
		sdWk.add(SchedulePatterns.createScheduleDatePatternFor(forDate.plusDays(1), SchedulePatterns.WEEKDAY_MTWRF));
		sdWk.add(SchedulePatterns.createScheduleDatePatternFor(forDate.plusDays(2), SchedulePatterns.WEEKDAY_MTWRF));
		sdWk.add(SchedulePatterns.createScheduleDatePatternFor(forDate.plusDays(3), SchedulePatterns.WEEKDAY_MTWRF));
		sdWk.add(SchedulePatterns.createScheduleDatePatternFor(forDate.plusDays(4), SchedulePatterns.WEEKDAY_MTWRF));
		sdWk.add(SchedulePatterns.createScheduleDatePatternFor(forDate.plusDays(5), SchedulePatterns.WEEKDAY_MTWRF));
		sdWk.add(SchedulePatterns.createScheduleDatePatternFor(forDate.plusDays(6), SchedulePatterns.WEEKDAY_SS));
				
		return sdWk;
	}
	
	public static ScheduleDateTST createScheduleDatePatternFor(DateTime forDate, String weekdayPattern){
		ScheduleDateTST sd = new ScheduleDateTST(forDate);

		DateTime startHr = DateUtil.parseDateString("2013-02-14 06:00:00");
		DateTime endHr = startHr;
		String priceLevel = PRICE_LEVEL_A;

		for(int i=1;i<18;i++){			
			priceLevel = getPriceLevel(i, weekdayPattern);
			startHr=startHr.plusHours(1);
			endHr = startHr.plusMinutes(50);
			Timeslotstst ts = new Timeslotstst();
			ts.setDate(forDate.toGregorianCalendar());
			ts.setStart(startHr.toGregorianCalendar());
			ts.setEnd(endHr.toGregorianCalendar());
			ts.setPriceLevel(priceLevel);
			
			// defaults
			ts.setActiveYn(ACTIVE_YN);
			ts.setBelongsToResId(BELONGS_TO);
			ts.setCustDisplay(CUST_DISPLAY);
			ts.setModifiedByUserFk(MODIFIED_BY);
			ts.setT3sFk(T3S_FK);
			ts.setModifiedLast(new GregorianCalendar());
			
			sd.setTimeSlot(i, ts);
		}
		return sd;
	}
	
	public static String getPriceLevel(int slotNum, String weekdayPattern){
		String priceLevel=PRICE_LEVEL_A;
		
		if(weekdayPattern.equalsIgnoreCase(WEEKDAY_MTWRF)){
			if(slotNum<11){			// TimeSlots 1-10 = PRICE_LEVEL_C
				priceLevel = PRICE_LEVEL_C;
			}					
			if(slotNum>10 && slotNum<16){	// TimeSlots 11-15 = PRICE_LEVEL_A
				priceLevel = PRICE_LEVEL_A;
			}
			if(slotNum>15){			// TimeSlots 16-17 = PRICE_LEVEL_B
				priceLevel = PRICE_LEVEL_B;
			}					
		}
		
		if(weekdayPattern.equalsIgnoreCase(WEEKDAY_SS)){
			if(slotNum<11){			// TimeSlots 1-15  = PRICE_LEVEL_A
				priceLevel = PRICE_LEVEL_A;
			}
			if(slotNum>15){			// TimeSlots 16-17 = PRICE_LEVEL_B
				priceLevel = PRICE_LEVEL_B;
			}					
		}
		return priceLevel;
	}
}
