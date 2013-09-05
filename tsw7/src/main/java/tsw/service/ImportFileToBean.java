package tsw.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;

import tsw.domain.Game;
import tsw.domain.ImportFile;
import tsw.domain.Customer;
import tsw.domain.Program;
import tsw.domain.Resource;
import tsw.domain.Team;

import java.util.GregorianCalendar;

/***
 * 1. CUSTOMER, firstname, lastname, yearBorn, email, phone, address, city, state, zipcode
 * 2. PROGRAM, programName, sportName, startDate, endDate, levelName, price, resourceName, coordFname, coordLname
 * 3. PARTICIPANT, programName, programGroup, partFname, partLname, yearBorn, group, amtPaid, signedWaiver
 * 4. LEAGUE, leagueName, sportName, startDate, endDate, levelName, price, resourceName, coordFname, coordLname
 * 5. TEAM, leagueName, teamName, CoachFname, CoachLname, teamGroup
 * 6. TEAMPLAYER, leagueName, teamName, positionName, playerFname, playerLname, yearBorn, amtPaid, signedWaiver, group
 * 7. GAME, leagueName, resourceName, gameDate, startTime, endTime, homeTeamName, visitorTeamName, refFname, refLname
 * 8. GAMESCORE, leagueName, gameDate, homeTeamName, visitorTeamName, homeScore, visitorScore
 * 9. GAMESTATS, leagueName, gameDate, homeTeamName, visitorTeamName, playerFname, playerLname, statTime, statTypeName, statValue
 *10. EVENT, resourceName, eventName, eventType, eventDesc, eventDate, startTime, endTime
 **/

public class ImportFileToBean<T> {
	
//  Import, Tables and Columns
public static String FILE_DATA_TYPE_CUSTOMER 	= "Customer";
public static String FILE_DATA_TYPE_PROGRAM		= "Program";
public static String FILE_DATA_TYPE_LEAGUE		= "Program";
public static String FILE_DATA_TYPE_PARTICIPANT = "Participant";
public static String FILE_DATA_TYPE_TEAMS 		= "Team";
public static String FILE_DATA_TYPE_TEAMPLAYER 	= "Teamplayers";
public static String FILE_DATA_TYPE_GAME 		= "Game";
public static String FILE_DATA_TYPE_GAMESCORE 	= "Game";
public static String FILE_DATA_TYPE_GAMESTATS 	= "Gamestats";
public static String FILE_DATA_TYPE_EVENT 		= "Event";

private static final String THEME_BLUE = "Blue";
private static final String DEFLT_PWD = "changeme";

 	public List<Object> parse(ImportFile importFile) {

        try {
        	String dataType = importFile.getFileDataType();
            String[] line;
            List<String[]> records = importFile.getImportRecords();
            List<Object> list = new ArrayList<Object>();
            ListIterator<String[]> iter = records.listIterator();
            while (iter!=null && iter.hasNext()){
            	line = iter.next();
        		if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_CUSTOMER)) {
        			Customer bean = processCustomerLine(line);
        			list.add(bean);
         		}
        		if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_TEAMS)) {
        			Team bean = processTeamLine(line);
        			list.add(bean);
         		}
        		if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_GAME) || dataType.equalsIgnoreCase(FILE_DATA_TYPE_GAMESCORE)) {
        			Game bean = processGameLine(line);
        			list.add(bean);
         		}
        	}
            return list;
        } catch (Exception e) {
            throw new RuntimeException("Error parsing ImportFile!", e);
        }
    }
 	
	/***
	 * 1. CUSTOMER, firstname, lastname, yearBorn, email, phone, address, city, state, zipcode
	 **/
    protected Customer processCustomerLine(String[] line) {
		Customer bean = new Customer();
		// add field validation...
		bean.setFirstname(line[0]);
		bean.setLastname(line[1]);
		if(line[2]!=null){
			bean.setYearBorn(Integer.parseInt(line[2]));
		}
		bean.setEmail(line[3]);
		bean.setPhone(line[4]);
		bean.setAddress(line[5]);
		bean.setCity(line[6]);
		bean.setState(line[7]);
		bean.setZipcode(line[8]);
		// defaults
		bean.setActiveYn(new Integer(1));
		bean.setAdminYn(new Integer(0));
		bean.setSelectTheme(THEME_BLUE);
		bean.setPassword(DEFLT_PWD);
		// add CustomerId and Tswacct when "Save" Customer
		return bean;
	}
    
	/***
	 * 5. TEAM, leagueName, teamName, CoachFname, CoachLname, teamGroup
	 **/
   protected Team processTeamLine(String[] line) {
	   	Team bean = new Team();
	   		Program pgm = new Program();
	   		pgm.setProgramName(line[0]);
	   	bean.setProgram(pgm);
	   	
	   	bean.setTeamName(line[1]);
	   	
	   		Customer coach = new Customer();
	   		coach.setFirstname(line[2]);
	   		coach.setLastname(line[3]);
	   	bean.setCustomerByCoachCustFk(coach);
	   	
	   	bean.setGroup3(line[4]);

		// defaults
		bean.setActiveYn(new Integer(1));
		bean.setPublishYn(new Integer(1));
		// add TeamId and Tswacct when "Save" Team
		return bean;
	}
   
	/***
	 * 7. GAME, leagueName, resourceName, gameDate, startTime, endTime, homeTeamName, visitorTeamName, refFname, refLname, homeScore, visitorScore
	 * 8. GAMESCORE, leagueName, gameDate, homeTeamName, visitorTeamName, homeScore, visitorScore
	 **/
   protected Game processGameLine(String[] line) {
	   	Game bean = new Game();
	   		Program pgm = new Program();
	   		pgm.setProgramName(line[0]);
	   	bean.setProgram(pgm);
	   	
	   		Resource res = new Resource();
	   		res.setResourceName(line[1]);
	   	bean.setResource(res);
	   	
	   		Date dt = DateUtil.convertToDate(line[2]);
	   		Calendar gmDt = new GregorianCalendar();
	   		gmDt.setTime(dt);
	   	bean.setGameDate(gmDt);
	   	
	   		Date dt2 = DateUtil.convertToTime(line[3]);
	   		Calendar gmDt2 = new GregorianCalendar();
	   		gmDt2.setTime(dt2);	
	   	bean.setStartTime(gmDt2);
	   	
	   		Date dt3 = DateUtil.convertToTime(line[4]);
	   		Calendar gmDt3 = new GregorianCalendar();
	   		gmDt3.setTime(dt3);	
	   	bean.setEndTime(gmDt3);
	   	
	   		Team homeTm = new Team();
	   		homeTm.setTeamName(line[5]);
	   	bean.setTeamByHomeTeamFk(homeTm);
	   	
	   		Team visTm = new Team();
	   		visTm.setTeamName(line[6]);
   		bean.setTeamByVisitorTeamFk(visTm);
   		
   		if(line.length>7){
	   		Customer ref = new Customer();
	   		ref.setFirstname(line[7]);
	   		ref.setLastname(line[8]);
	   	bean.setCustomer(ref);
   		}	   	
		if(line.length>9 && line[9]!=null){
			bean.setHomeScore(Integer.parseInt(line[9]));
		}
		if(line.length>10 && line[10]!=null){
			bean.setVisitorScore(Integer.parseInt(line[10]));
		}
	   	
		// defaults
		bean.setActiveYn(new Integer(1));
		// add GameId and Tswacct when "Save" Game
		return bean;
	}

/*******************************
 *         		
	if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_PROGRAM) || dataType.equalsIgnoreCase(FILE_DATA_TYPE_LEAGUE)) {
		Program bean = processProgramLine(hdr, line);
		list.add(bean);
	}
	if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_PARTICIPANT)) {
		Participant bean = processParticipantLine(hdr, line);
		list.add(bean);
	}
	if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_TEAMPLAYER)) {
		Teamplayers bean = processTeamplayersLine(hdr, line);
		list.add(bean);
	}

	if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_GAMESTATS)) {
		Gamestats bean = processGamestatsLine(hdr, line);
		list.add(bean);
	}
	if (dataType.equalsIgnoreCase(FILE_DATA_TYPE_EVENT)) {
		Event bean = processEventLine(hdr, line);
		list.add(bean);
	}	

	 * 2. PROGRAM, programName, sportName, startDate, endDate, levelName, price, resourceName, coordFname, coordLname
	 * 4. LEAGUE, leagueName, sportName, startDate, endDate, levelName, price, resourceName, coordFname, coordLname

    protected Program processProgramLine(String[] hdr, String[] line) {
    	Program bean2 = new Program();
		for (int col = 0; col < line.length; col++) {
			String colHdr = hdr[col];
			String colData = line[col];
			if (colHdr.equalsIgnoreCase(PGM_NAME)) { bean2.setProgramName(colData); }
			if (colHdr.equalsIgnoreCase(PGM_SPORTNAME)) { bean2.setSport(sport); }
			if (colHdr.equalsIgnoreCase(PGM_STARTDATE)) { bean2.setStartDate(new GregorianCalendar(colData)); }
			if (colHdr.equalsIgnoreCase(PGM_ENDDATE)) { bean2.setEndDate(new GregorianCalendar(colData)); }
			if (colHdr.equalsIgnoreCase(PGM_LEVELNAME)) { bean2.setLevel(colData); }
			if (colHdr.equalsIgnoreCase(PGM_PRICE)) { bean2.setPrice(colData); }
			if (colHdr.equalsIgnoreCase(PGM_RESOURCENAME)) { bean2.setResource(colData); }
			if (colHdr.equalsIgnoreCase(PGM_COORDFNAME)) { bean2.setCustomer(colData); }
			if (colHdr.equalsIgnoreCase(PGM_COORDLNAME)) { bean2.setCustomer(colData); }

		}
		if (bean2.equals(new Program())) { 
			bean2 = null;
		} else {
			// add default values
			// ....			
		}
		return bean2;
	}

	 * 3. PARTICIPANT, programName, programGroup, partFname, partLname, yearBorn, group, amtPaid, signedWaiver
   
    protected Participant processParticipantLine(String[] hdr, String[] line) {
    	Participant bean2 = new Participant();
		for (int col = 0; col < line.length; col++) {
			String colHdr = hdr[col];
			String colData = line[col];
			if (colHdr.equalsIgnoreCase(PART_PGMNAME)) { bean2.setProgram(colData); }
			if (colHdr.equalsIgnoreCase(PART_PGMGRP)) { bean2.setProgram(colData); }
			if (colHdr.equalsIgnoreCase(PART_FNAME)) { bean2.setCustomer(colData); }
			if (colHdr.equalsIgnoreCase(PART_LNAME)) { bean2.setCustomer(colData); }
			if (colHdr.equalsIgnoreCase(PART_YRBORN)) { bean2.setCustomer(colData); }
			if (colHdr.equalsIgnoreCase(PART_GROUP)) { bean2.setGroup1(colData); }
			if (colHdr.equalsIgnoreCase(PART_AMTPD)) { bean2.setAmtPaid(new BigDecimal(colData)); }
			if (colHdr.equalsIgnoreCase(PART_WAIVER)) { bean2.setSignedWaiverYn(Integer.parseInt(colData)); }


		}
		if (bean2.equals(new Participant())) { 
			bean2 = null;
		} else {
			// add default values
			// ....			
		}
		return bean2;
	}

	 * 6. TEAMPLAYER, leagueName, teamName, positionName, playerFname, playerLname, yearBorn, amtPaid, signedWaiver, group
    
    protected Teamplayers processTeamplayersLine(String[] hdr, String[] line) {
    	Teamplayers bean2 = new Teamplayers();
		for (int col = 0; col < line.length; col++) {
			String colHdr = hdr[col];
			String colData = line[col];
			if (colHdr.equalsIgnoreCase(TMPLR_LGNAME)) { bean2.setProgram(colData); }
			if (colHdr.equalsIgnoreCase(TMPLR_TMNAME)) { bean2.setTeam(colData); }
			if (colHdr.equalsIgnoreCase(TMPLR_POSNAME)) { bean2.setSportPosition(colData); }
			if (colHdr.equalsIgnoreCase(TMPLR_FNAME)) { bean2.setCustomer(colData); }
			if (colHdr.equalsIgnoreCase(TMPLR_LNAME)) { bean2.setCustomer(colData); }
			if (colHdr.equalsIgnoreCase(TMPLR_YRBORN)) { bean2.setCustomer(colData); }
			if (colHdr.equalsIgnoreCase(TMPLR_AMTPD)) { bean2.setAmtPaid(new BigDecimal(colData)); }
			if (colHdr.equalsIgnoreCase(TMPLR_WAIVER)) { bean2.setSignedWaiverYn(Integer.parseInt(colData)); }
			if (colHdr.equalsIgnoreCase(TMPLR_GROUP)) { bean2.setGroup2(colData); }
			
		}
		if (bean2.equals(new Teamplayers())) { 
			bean2 = null;
		} else {
			// add default values
			// ....			
		}
		return bean2;
	}

	 * 9. GAMESTATS, leagueName, gameDate, homeTeamName, visitorTeamName, playerFname, playerLname, statTime, statTypeName, statValue
    
    protected Gamestats processGamestatsLine(String[] hdr, String[] line) {
    	Gamestats bean2 = new Gamestats();
		for (int col = 0; col < line.length; col++) {
			String colHdr = hdr[col];
			String colData = line[col];
			if (colHdr.equalsIgnoreCase(GMSTS_LGNAME)) { bean2.setGame(colData); }
			if (colHdr.equalsIgnoreCase(GMSTS_DATE)) { bean2.setGame(new GregorianCalendar(colData)); }
			if (colHdr.equalsIgnoreCase(GMSTS_HTMNAME)) { bean2.setGame(colData); }
			if (colHdr.equalsIgnoreCase(GMSTS_VTMNAME)) { bean2.setGame(colData); }
			if (colHdr.equalsIgnoreCase(GMSTS_PLYRFNAME)) { bean2.setTeamplayers(colData); }
			if (colHdr.equalsIgnoreCase(GMSTS_PLYRLNAME)) { bean2.setTeamplayers(colData); }
			if (colHdr.equalsIgnoreCase(GMSTS_TIME)) { bean2.setGameStatTime(new GregorianCalendar(colData)); }
			if (colHdr.equalsIgnoreCase(GMSTS_TYPENAME)) { bean2.setSportStatType(colData); }
			if (colHdr.equalsIgnoreCase(GMSTS_VALUE)) { bean2.setGameStatValue(Integer.parseInt(colData)); }

		}
		if (bean2.equals(new Gamestats())) { 
			bean2 = null;
		} else {
			// add default values
			// ....			
		}
		return bean2;
	}

	 *10. EVENT, resourceName, eventName, eventType, eventDesc, eventDate, startTime, endTime
    
    protected Event processEventLine(String[] hdr, String[] line) {
    	Event bean2 = new Event();
		for (int col = 0; col < line.length; col++) {
			String colHdr = hdr[col];
			String colData = line[col];
			if (colHdr.equalsIgnoreCase(EVT_RESNAME)) { bean2.setResource(colData); }
			if (colHdr.equalsIgnoreCase(EVT_NAME)) { bean2.setEventName(colData); }
			if (colHdr.equalsIgnoreCase(EVT_TYPE)) { bean2.setEventType(colData); }
			if (colHdr.equalsIgnoreCase(EVT_DESC)) { bean2.setDescription(colData); }
			if (colHdr.equalsIgnoreCase(EVT_DATE)) { bean2.setEventDate(new GregorianCalendar(colData)); }
			if (colHdr.equalsIgnoreCase(EVT_START)) { bean2.setStartTime(new GregorianCalendar(colData)); }
			if (colHdr.equalsIgnoreCase(EVT_END)) { bean2.setEndTime(new GregorianCalendar(colData)); }


		}
		if (bean2.equals(new Event())) { 
			bean2 = null;
		} else {
			// add default values
			// ....			
		}
		return bean2;
	}
	
*************/

}
