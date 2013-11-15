package tsw.service;


import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;


import javax.servlet.http.HttpServletRequest;
import tsw.domain.ImportFile;


/*
import java.util.ArrayList;
import java.util.List;
import tsw.utils.ImportFileToBean;
import org.springframework.beans.factory.annotation.Autowired;
import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Program;
import tsw.domain.Resource;
import tsw.domain.Team;*/

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;

@Service("CSVFileService")
public class CSVFileService {
    
	
/*	private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";
	private static final String VALUES_REGEX = "\\$\\{values\\}";


	//  Import, Tables: Customer, Team, Game, Event, Teamplayer, Participant
	public static String FILE_DATA_TYPE_CUSTOMER 	= "Customer";
	public static String FILE_DATA_TYPE_PROGRAM		= "Program";
	public static String FILE_DATA_TYPE_PARTICIPANT = "Participant";
	public static String FILE_DATA_TYPE_LEAGUE		= "Program";
	public static String FILE_DATA_TYPE_TEAMS 		= "Team";
	public static String FILE_DATA_TYPE_TEAMPLAYER 	= "Teamplayer";
	public static String FILE_DATA_TYPE_GAME 		= "Game";
	public static String FILE_DATA_TYPE_GAMESCORE 	= "Game";
	public static String FILE_DATA_TYPE_GAMESTATS 	= "Gamestats";
	public static String FILE_DATA_TYPE_EVENT 		= "Event";
 
	/***
	 * 1. CUSTOMER, custFname, custLname, yearBorn, email, phone, address, city, state, zipcode
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
	
	//  Import:  Customers, Teams & Players, Participants, Events & Games	
	
	public static ImportFile loadRecords(HttpServletRequest request, ImportFile importFile) throws IOException {
		CSVReader csvReader = null;
		try {		
			csvReader = new CSVReader(new FileReader(importFile.getUploadPath()+File.separator+importFile.getFileName()), importFile.getSeparator());
		} catch (Exception e) {
			e.printStackTrace();
			throw new IOException("Error occured while executing file. " + e.getMessage());
		}
		importFile.setHeaderRow(csvReader.readNext()) ;
		if (null == importFile.getHeaderRow()) {
			throw new FileNotFoundException("No columns defined in given CSV file, check file format.");
		}
		importFile.setImportRecords(csvReader.readAll());
		return importFile;
	}
	
	/**
	 *  eg.  csvFile = "C:\\4devPC\\cutomer.csv";  sqlTable = "select * from Customer;";
	 */		
	public void sqlTableToCSV(HttpServletRequest request, Connection connection, String sqlTable, String csvFile) throws Exception{
		boolean includeHeaders = true;
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(csvFile));
			ResultSet myResultSet = connection.createStatement().executeQuery(sqlTable);
			writer.writeAll(myResultSet, includeHeaders);
			writer.close();
		} catch (Exception e) {
			throw new Exception("Error occured while loading data from file to database." + e.getMessage());
		}
	}

	public ImportFile createAndSaveObjects(HttpServletRequest request, ImportFile importFile) throws Exception {
		
/*		ImportFileToBean<Object> csvImport2Bean = new ImportFileToBean<Object>();
		List<Object> list = csvImport2Bean.parse(importFile);
		List<Boolean> recordLoaded = new ArrayList<Boolean>();
		for (Object object : list) {			
			Boolean loaded = new Boolean(false);
			try {
				
				if(importFile.getFileDataType().equalsIgnoreCase(FILE_DATA_TYPE_CUSTOMER)){
					Customer customer = (Customer) object;
					Customer existingCustomer = customerService.findCustomerByName(sessionCache.getTswacct(request), customer.getFirstname(), customer.getLastname());
					if(existingCustomer!=null){
						customer.setCustomerId(existingCustomer.getCustomerId());
					}
					customerService.saveCustomer(customer, null, sessionCache.getTswacct(request));
				}
				
				if(importFile.getFileDataType().equalsIgnoreCase(FILE_DATA_TYPE_TEAMS)){
					Team team = (Team) object;
					Program tmPgm = team.getProgram();
					Program pgm = programService.findProgramByProgramName(sessionCache.getTswacct(request), tmPgm.getProgramName());
					if(pgm==null){
						throw new Exception("Cannot find Program for name: "+tmPgm.getProgramName());
					}
					team.setProgram(pgm);
					Team hmTeam =teamService.findTeamByTeamName(sessionCache.getTswacct(request), pgm, team.getTeamName());
					if(hmTeam!=null){
						throw new Exception("Team already exists!");
					}
					Customer tmCoach = team.getCustomerByCoachCustFk();
					Customer coach = customerService.findCustomerByName(sessionCache.getTswacct(request), tmCoach.getFirstname(), tmCoach.getLastname());
					team.setCustomerByCoachCustFk(coach);
					team.setLevel(pgm.getLevel());					
					programService.saveProgramTeams(sessionCache.getTswacct(request), pgm.getProgramId(), pgm.getLevel().getLevelId(), coach.getCustomerId(), null, team);
				}
				
				if(importFile.getFileDataType().equalsIgnoreCase(FILE_DATA_TYPE_GAME)){
					Game game = (Game) object;
					// 2DO: check if Game exists (find by gameDate, homeTeam, visitorTeam)
					Program gmPgm = game.getProgram();
					Program pgm = programService.findProgramByProgramName(sessionCache.getTswacct(request), gmPgm.getProgramName());
					if(pgm==null){
						throw new Exception("Cannot find Program for name: "+gmPgm.getProgramName());
					}
					game.setProgram(pgm);					
					Team gmHmTeam = game.getTeamByHomeTeamFk();
					Team hmTeam = teamService.findTeamByTeamName(sessionCache.getTswacct(request), pgm, gmHmTeam.getTeamName());
					if(hmTeam==null){
						throw new Exception("Cannot find Home Team for name: "+gmHmTeam.getTeamName());						
					}
					game.setTeamByHomeTeamFk(hmTeam);
					Team gmVisTeam = game.getTeamByVisitorTeamFk();
					Team visTeam = teamService.findTeamByTeamName(sessionCache.getTswacct(request), pgm, gmVisTeam.getTeamName());
					if(visTeam==null){
						throw new Exception("Cannot find Visitor Team for name: "+gmVisTeam.getTeamName());						
					}
					game.setTeamByVisitorTeamFk(visTeam);
					Resource res = game.getResource();
					res = resourceService.findResourceByResourceName(sessionCache.getTswacct(request), res.getResourceName());
					game.setResource(res);
					Integer resId = null;
					if(res!=null){
						resId = res.getResourceId();
					}					
					Customer ref = game.getCustomer();
					ref = customerService.findCustomerByName(sessionCache.getTswacct(request), ref.getFirstname(), ref.getLastname());
					game.setCustomer(ref);			
					Integer refCustId = null;
					if(ref!=null){
						refCustId = ref.getCustomerId();
					}
					programService.saveProgramGames(sessionCache.getTswacct(request), pgm.getProgramId(), hmTeam.getTeamId(), visTeam.getTeamId(), refCustId, resId, game);
					eventService.saveEventForGame(game, pgm.getProgramId(), resId);

				}
				
				loaded = new Boolean(true);
			} catch (Exception e) {
				loaded = new Boolean(false);
				e.printStackTrace();
			}
			recordLoaded.add(loaded);
		} 
		importFile.setRecordLoaded(recordLoaded); */
		return importFile;
	}

}