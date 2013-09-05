package timeslot.domain;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class ScheduleDateTST {

	int numTimeSlots = 17;
	DateTime slotDate;
	ArrayList<Timeslotstst> timeslots = null;
	
	public ScheduleDateTST(DateTime slotDate) {
		if(slotDate==null){
			slotDate = DateUtil.parseDateString("2013-02-14");
		}
		this.slotDate = slotDate;
		timeslots = new ArrayList<Timeslotstst>();
		for(int i=0;i<18;i++){
			timeslots.add(new Timeslotstst());
		}
	}

	public int getNumTimeSlots() {
		return numTimeSlots;
	}

	public void setNumTimeSlots(int numTimeSlots) {
		this.numTimeSlots = numTimeSlots;
	}

	public DateTime getSlotDate() {
		return slotDate;
	}

	public void setSlotDate(DateTime slotDate) {
		this.slotDate = slotDate;
	}

	public void setTimeSlot(int slotNum, Timeslotstst ts){
		ts.setTimeslot(slotNum);
		if(ts.getDate()==null){
			ts.setDate(getSlotDate().toGregorianCalendar());
		}
		timeslots.set(slotNum, ts);
	}
	public Timeslotstst getTimeSlot(int slotNum){
		return timeslots.get(slotNum);
	}
	
	public String toString() {
		String sd2str = "ScheduleDate: ";
		Timeslotstst ts = null;
		sd2str+=this.slotDate+"\n";
		for(int i=1;i<18;i++){
			ts = timeslots.get(i);
			sd2str+=ts.toString()+"\n";
		}
		
		return sd2str;
	}
}
