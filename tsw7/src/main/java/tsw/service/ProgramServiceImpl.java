package tsw.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.GameDAO;
import tsw.dao.LevelDAO;
import tsw.dao.ParticipantDAO;
import tsw.dao.PriceDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.ProgramresourceDAO;
import tsw.dao.ResourceDAO;
import tsw.dao.SportDAO;
import tsw.dao.TeamDAO;
import tsw.dao.TeamplayersDAO;
import tsw.dao.TswacctDAO;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Level;
import tsw.domain.Participant;
import tsw.domain.Program;
import tsw.domain.Programresource;
import tsw.domain.Sport;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.domain.Users;
import tsw.web.SessionConfigCache;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Program entities
 * 
 */

@Service("ProgramService")
@Transactional
public class ProgramServiceImpl implements ProgramService {
	
	SessionConfigCache sessionCache = UsersController.getSessionCache();	
	int defaultMaxRows = UsersController.getDefaultMaxRows();
	
	/**
	 * DAO injected by Spring that manages Customer entities
	 * 
	 */
	@Autowired
	private CustomerDAO customerDAO;

	/**
	 * DAO injected by Spring that manages Game entities
	 * 
	 */
	@Autowired
	private GameDAO gameDAO;

	/**
	 * DAO injected by Spring that manages Level entities
	 * 
	 */
	@Autowired
	private LevelDAO levelDAO;

	/**
	 * DAO injected by Spring that manages Participant entities
	 * 
	 */
	@Autowired
	private ParticipantDAO participantDAO;

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

	/**
	 * DAO injected by Spring that manages Team entities
	 * 
	 */
	@Autowired
	private TeamDAO teamDAO;

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;
		
	@Autowired
	private ResourceDAO resourceDAO;
	
	@Autowired
	private PriceDAO priceDAO;
	
	/**
	 * DAO injected by Spring that manages Users entities
	 * 
	 */
	/**
	 * DAO injected by Spring that manages Programresource entities
	 * 
	 */
	@Autowired
	private ProgramresourceDAO programresourceDAO;

	/**
	 * DAO injected by Spring that manages Sport entities
	 * 
	 */
	@Autowired
	private SportDAO sportDAO;
	
	@Autowired
	private TeamplayersDAO teamplayersDAO;
	
	/**
	 * Instantiates a new ProgramServiceImpl.
	 *
	 */
	public ProgramServiceImpl() {
	}

	/**
	 * Load an existing Program entity
	 * 
	 */
	@Transactional
	public Set<Program> loadPrograms4tsw(Tswacct tswacct) {
		return programDAO.findAllPrograms4tsw(tswacct.getTswAcctId());
	}
	public Set<Program> loadPrograms4tsw(Tswacct tswacct, int from) {
		return programDAO.findAllPrograms4tsw(tswacct.getTswAcctId(), from, defaultMaxRows);
	}
	public Set<Program> loadAnyPrograms4tsw(Tswacct tswacct, int from) {
		return programDAO.findAnyPrograms4tsw(tswacct.getTswAcctId(), from, defaultMaxRows);
	}
	/**
	 * Load an existing League entity
	 * 
	 */
	@Transactional
	public Set<Program> loadLeagues4tsw(Tswacct tswacct) {
		return programDAO.findAllLeagues4tsw(tswacct.getTswAcctId());
	}
	public Set<Program> loadLeagues4tsw(Tswacct tswacct, int from) {
		return programDAO.findAllLeagues4tsw(tswacct.getTswAcctId(), from, defaultMaxRows);
	}
	/**
	 * Save an existing Participant entity
	 * 
	 */
	@Transactional
	public Program saveProgramParticipants(Tswacct tswacct, Integer programId,  Integer custId, Participant related_participants) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, defaultMaxRows);
		Participant existingparticipants = participantDAO.findParticipantByPrimaryKey(related_participants.getParticipantId());

		// copy into the existing record to preserve existing relationships
		if (existingparticipants != null) {
			existingparticipants.setParticipantId(related_participants.getParticipantId());
			existingparticipants.setAmtPaid(related_participants.getAmtPaid());
			existingparticipants.setNotes(related_participants.getNotes());
			existingparticipants.setGroup1(related_participants.getGroup1());
			existingparticipants.setSignedWaiverYn(related_participants.getSignedWaiverYn());
			existingparticipants.setActiveYn(related_participants.getActiveYn());
			existingparticipants.setCustomer(related_participants.getCustomer());
			related_participants = existingparticipants;
		} else {
			int partId = participantDAO.getMaxParticipantID();
			related_participants.setParticipantId(partId+1);
			related_participants.setTswacct(tswacct);			
			related_participants.setProgram(program);
			program.getParticipants().add(related_participants);
		}
		if(custId!=null && custId>0){
			related_participants.setCustomer(customerDAO.findCustomerByPrimaryKey(custId));
		}

		related_participants = participantDAO.store(related_participants);
		participantDAO.flush();
		program = programDAO.store(program);
		programDAO.flush();
		return program;
	}
	/**
	 * Save an existing Sport entity
	 * 
	 */
	@Transactional
	public Program saveProgramSport(Integer programId, Sport related_sport) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Sport existingsport = sportDAO.findSportByPrimaryKey(related_sport.getSportId());

		// copy into the existing record to preserve existing relationships
		if (existingsport != null) {
			existingsport.setSportId(related_sport.getSportId());
			existingsport.setSportName(related_sport.getSportName());
			existingsport.setWikiUrl(related_sport.getWikiUrl());
			existingsport.setActiveYn(related_sport.getActiveYn());
			existingsport.setNumGamePlayers(related_sport.getNumGamePlayers());
			existingsport.setNumTeamRoster(related_sport.getNumTeamRoster());
			existingsport.setNormalSeason(related_sport.getNormalSeason());
			related_sport = existingsport;
		} else {
			related_sport = sportDAO.store(related_sport);
			sportDAO.flush();
		}

		program.setSport(related_sport);
		related_sport.getPrograms().add(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_sport = sportDAO.store(related_sport);
		sportDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Programresource entity
	 * 
	 */
	@Transactional
	public Program deleteProgramProgramresources(Integer program_programId, Integer related_programresources_programResourceId) {
		Programresource related_programresources = programresourceDAO.findProgramresourceByPrimaryKey(related_programresources_programResourceId, -1, -1);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);

		related_programresources.setProgram(null);
		program.getProgramresources().remove(related_programresources);

		programresourceDAO.remove(related_programresources);
		programresourceDAO.flush();

		return program;
	}
	
	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Program deleteProgramGames(Integer program_programId, Integer related_games_gameId) {
		Game related_games = gameDAO.findGameByPrimaryKey(related_games_gameId, -1, defaultMaxRows);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, defaultMaxRows);

		related_games.setProgram(null);
		program.getGames().remove(related_games);

		gameDAO.remove(related_games);
		gameDAO.flush();

		return program;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Program saveProgramTswacct(Integer programId, Tswacct related_tswacct) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, defaultMaxRows);
		Tswacct existingtswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswacct != null) {
			existingtswacct.setTswAcctId(related_tswacct.getTswAcctId());
			existingtswacct.setAcctName(related_tswacct.getAcctName());
			existingtswacct.setSubscrType(related_tswacct.getSubscrType());
			existingtswacct.setAmtPaid(related_tswacct.getAmtPaid());
			existingtswacct.setEstablishDate(related_tswacct.getEstablishDate());
			existingtswacct.setExpireDate(related_tswacct.getExpireDate());
			existingtswacct.setActiveYn(related_tswacct.getActiveYn());
			related_tswacct = existingtswacct;
		} else {
			related_tswacct = tswacctDAO.store(related_tswacct);
			tswacctDAO.flush();
		}

		program.setTswacct(related_tswacct);
		related_tswacct.getPrograms().add(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Level entity
	 * 
	 */
	@Transactional
	public Program deleteProgramLevel(Integer program_programId, Integer related_level_levelId) {
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, defaultMaxRows);
		Level related_level = levelDAO.findLevelByPrimaryKey(related_level_levelId, -1, defaultMaxRows);

		program.setLevel(null);
		related_level.getPrograms().remove(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_level = levelDAO.store(related_level);
		levelDAO.flush();

		levelDAO.remove(related_level);
		levelDAO.flush();

		return program;
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Game saveProgramGames(Tswacct tswacct, Integer programId, Integer homeTeamId, Integer visitorTeamId, Integer refId, Integer resIdKey, Game related_games) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, defaultMaxRows);
		Game existinggames = gameDAO.findGameByPrimaryKey(related_games.getGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggames != null) {
			existinggames.setGameId(related_games.getGameId());
			existinggames.setGameDate(related_games.getGameDate());
			existinggames.setStartTime(related_games.getStartTime());
			existinggames.setEndTime(related_games.getEndTime());
			existinggames.setHomeScore(related_games.getHomeScore());
			existinggames.setVisitorScore(related_games.getVisitorScore());
			existinggames.setActiveYn(related_games.getActiveYn());
			existinggames.setTeamByHomeTeamFk(related_games.getTeamByHomeTeamFk());
			existinggames.setTeamByVisitorTeamFk(related_games.getTeamByVisitorTeamFk());
			related_games = existinggames;
		} else {
			int gameId = gameDAO.getMaxGameID();
			related_games.setGameId(gameId+1);
			related_games.setTswacct(tswacct);
			related_games.setProgram(program);
			related_games.setActiveYn(new Integer(1));
			DateTime startTime = new DateTime(related_games.getStartTime().getTime());
			int mins = 60;
			if(program.getGameMins()!=null){
				mins = program.getGameMins();
			}
			startTime = startTime.plusMinutes(mins);
			related_games.setEndTime(startTime.toGregorianCalendar());
			
			program.getGames().add(related_games);

		}
		if(homeTeamId!=null && homeTeamId>0){
			related_games.setTeamByHomeTeamFk(teamDAO.findTeamByPrimaryKey(homeTeamId));
		}
		if(visitorTeamId!=null && visitorTeamId>0){
			related_games.setTeamByVisitorTeamFk(teamDAO.findTeamByPrimaryKey(visitorTeamId));
		}
		if(refId!=null && refId>0){
			related_games.setCustomer(customerDAO.findCustomerByPrimaryKey(refId));
		}
		if(resIdKey!=null && resIdKey>0){
			related_games.setResource(resourceDAO.findResourceByPrimaryKey(resIdKey));
		}
		Game returnGame = related_games;
		related_games = gameDAO.store(related_games);
		gameDAO.flush();

		program = programDAO.store(program);
		programDAO.flush();

		return returnGame;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Program saveProgramTeamplayerses(Integer programId, Teamplayers related_teamplayerses) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, defaultMaxRows);
		Teamplayers existingteamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses.getTeamPlayersId());

		// copy into the existing record to preserve existing relationships
		if (existingteamplayerses != null) {
			existingteamplayerses.setTeamPlayersId(related_teamplayerses.getTeamPlayersId());
			existingteamplayerses.setAmtPaid(related_teamplayerses.getAmtPaid());
			existingteamplayerses.setNotes(related_teamplayerses.getNotes());
			existingteamplayerses.setGroup2(related_teamplayerses.getGroup2());
			existingteamplayerses.setSignedWaiverYn(related_teamplayerses.getSignedWaiverYn());
			existingteamplayerses.setActiveYn(related_teamplayerses.getActiveYn());
			related_teamplayerses = existingteamplayerses;
		} else {
			related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
			teamplayersDAO.flush();
		}

		related_teamplayerses.setProgram(program);
		program.getTeamplayerses().add(related_teamplayerses);
		related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
		teamplayersDAO.flush();

		program = programDAO.store(program);
		programDAO.flush();

		return program;
	}

	/**
	 * Save an existing Programresource entity
	 * 
	 */
	@Transactional
	public Program saveProgramProgramresources(Integer programId, Programresource related_programresources) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Programresource existingprogramresources = programresourceDAO.findProgramresourceByPrimaryKey(related_programresources.getProgramResourceId());

		// copy into the existing record to preserve existing relationships
		if (existingprogramresources != null) {
			existingprogramresources.setProgramResourceId(related_programresources.getProgramResourceId());
			existingprogramresources.setResource(related_programresources.getResource());
			existingprogramresources.setResourcePrice(related_programresources.getResourcePrice());
			related_programresources = existingprogramresources;
		} else {
			related_programresources = programresourceDAO.store(related_programresources);
			programresourceDAO.flush();
		}

		related_programresources.setProgram(program);
		program.getProgramresources().add(related_programresources);
		related_programresources = programresourceDAO.store(related_programresources);
		programresourceDAO.flush();

		program = programDAO.store(program);
		programDAO.flush();

		return program;
	}


	/**
	 * Return a count of all Program entity
	 * 
	 */
	@Transactional
	public Integer countPrograms() {
		return ((Long) programDAO.createQuerySingleResult("select count(o) from Program o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Level entity
	 * 
	 */
	@Transactional
	public Program saveProgramLevel(Integer programId, Level related_level) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, defaultMaxRows);
		Level existinglevel = levelDAO.findLevelByPrimaryKey(related_level.getLevelId());

		// copy into the existing record to preserve existing relationships
		if (existinglevel != null) {
			existinglevel.setLevelId(related_level.getLevelId());
			existinglevel.setLevelName(related_level.getLevelName());
			existinglevel.setLevelCode(related_level.getLevelCode());
			existinglevel.setAgeLow(related_level.getAgeLow());
			existinglevel.setAgeHigh(related_level.getAgeHigh());
			existinglevel.setActiveYn(related_level.getActiveYn());
			related_level = existinglevel;
		} else {
			related_level = levelDAO.store(related_level);
			levelDAO.flush();
		}

		program.setLevel(related_level);
		related_level.getPrograms().add(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_level = levelDAO.store(related_level);
		levelDAO.flush();

		return program;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Program saveProgramCustomer(Integer programId, Customer related_customer) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, defaultMaxRows);
		Customer existingcustomer = customerDAO.findCustomerByPrimaryKey(related_customer.getCustomerId());

		// copy into the existing record to preserve existing relationships
		if (existingcustomer != null) {
			existingcustomer.setCustomerId(related_customer.getCustomerId());
			existingcustomer.setEmail(related_customer.getEmail());
			existingcustomer.setFirstname(related_customer.getFirstname());
			existingcustomer.setLastname(related_customer.getLastname());
			existingcustomer.setPhone(related_customer.getPhone());
			existingcustomer.setYearBorn(related_customer.getYearBorn());
			existingcustomer.setAddress(related_customer.getAddress());
			existingcustomer.setCity(related_customer.getCity());
			existingcustomer.setState(related_customer.getState());
			existingcustomer.setZipcode(related_customer.getZipcode());
			related_customer = existingcustomer;
		} else {
			related_customer = customerDAO.store(related_customer);
			customerDAO.flush();
		}

		program.setCustomer(related_customer);
		related_customer.getPrograms().add(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	@Transactional
	public Program deleteProgramParticipants(Integer program_programId, Integer related_participants_participantId) {
		Participant related_participants = participantDAO.findParticipantByPrimaryKey(related_participants_participantId, -1, defaultMaxRows);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, defaultMaxRows);

		related_participants.setProgram(null);
		program.getParticipants().remove(related_participants);

		participantDAO.remove(related_participants);
		participantDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Program deleteProgramCustomer(Integer program_programId, Integer related_customer_customerId) {
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, defaultMaxRows);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, defaultMaxRows);

		program.setCustomer(null);
		related_customer.getPrograms().remove(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		customerDAO.remove(related_customer);
		customerDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Program deleteProgramTeamplayerses(Integer program_programId, Integer related_teamplayerses_teamPlayersId) {
		Teamplayers related_teamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId, -1, defaultMaxRows);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, defaultMaxRows);

		related_teamplayerses.setProgram(null);
		program.getTeamplayerses().remove(related_teamplayerses);

		teamplayersDAO.remove(related_teamplayerses);
		teamplayersDAO.flush();

		return program;
	}

	/**
	 */
	@Transactional
	public Program findProgramByPrimaryKey(Integer programId) {
		return programDAO.findProgramByPrimaryKey(programId);
	}
	
	@Transactional
	public Program findProgramByProgramName(Tswacct tswacct, String programName) {
		return programDAO.findProgramByProgramName(tswacct, programName);
	}
	
	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Program deleteProgramTswacct(Integer program_programId, Integer related_tswacct_tswAcctId) {
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		program.setTswacct(null);
		related_tswacct.getPrograms().remove(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Program deleteProgramTeams(Integer program_programId, Integer related_teams_teamId) {
		Team related_teams = teamDAO.findTeamByPrimaryKey(related_teams_teamId, -1, defaultMaxRows);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, defaultMaxRows);
		if(related_teams!=null && program!=null){
			related_teams.setProgram(null);
			program.getTeams().remove(related_teams);
	
			teamDAO.remove(related_teams);
			teamDAO.flush();
		}
		return program;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public void deleteProgram(Program program) {
		programDAO.remove(program);
		programDAO.flush();
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Program saveProgramTeams(Tswacct tswacct, Integer programId, Integer levelId, Integer coachId, Integer managerId, Team related_teams) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, defaultMaxRows);
		if(related_teams!=null){
		Team existingteams = teamDAO.findTeamByPrimaryKey(related_teams.getTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingteams != null) {
			existingteams.setTeamId(related_teams.getTeamId());
			existingteams.setTeamName(related_teams.getTeamName());
			existingteams.setAmtPaid(related_teams.getAmtPaid());
			existingteams.setWins(related_teams.getWins());
			existingteams.setLosses(related_teams.getLosses());
			existingteams.setTies(related_teams.getTies());
			existingteams.setGroup3(related_teams.getGroup3());
			existingteams.setColor(related_teams.getColor());
			existingteams.setPublishYn(related_teams.getPublishYn());
			existingteams.setActiveYn(related_teams.getActiveYn());
			existingteams.setNotes(related_teams.getNotes());
			existingteams.setLevel(related_teams.getLevel());
			existingteams.setCustomerByCoachCustFk(related_teams.getCustomerByCoachCustFk());
			existingteams.setCustomerByManagerCustFk(related_teams.getCustomerByManagerCustFk());
			related_teams = existingteams;
		} else {
			int teamId = teamDAO.getMaxTeamID();
			related_teams.setTeamId(teamId+1);
			related_teams.setTswacct(tswacct);
			related_teams.setProgram(program);
			related_teams.setActiveYn(new Integer(1));
			program.getTeams().add(related_teams);
		}
		if(levelId!=null && levelId>0){
			related_teams.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coachId!=null && coachId>0){
			related_teams.setCustomerByCoachCustFk(customerDAO.findCustomerByPrimaryKey(coachId));
		}
		if(managerId!=null && managerId>0){
			related_teams.setCustomerByManagerCustFk(customerDAO.findCustomerByPrimaryKey(managerId));
		}
		related_teams = teamDAO.store(related_teams);
		teamDAO.flush();	
		program = programDAO.store(program);
		programDAO.flush();
		}
		return program;
	}

	/**
	 * Delete an existing Sport entity
	 * 
	 */
	@Transactional
	public Program deleteProgramSport(Integer program_programId, Integer related_sport_sportId) {
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);
		Sport related_sport = sportDAO.findSportByPrimaryKey(related_sport_sportId, -1, -1);

		program.setSport(null);
		related_sport.getPrograms().remove(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_sport = sportDAO.store(related_sport);
		sportDAO.flush();

		sportDAO.remove(related_sport);
		sportDAO.flush();

		return program;
	}
	
	/**
	 * Return all Program entity
	 * 
	 */
	@Transactional
	public List<Program> findAllPrograms4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Program>(programDAO.findAllPrograms4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}
	/**
	 * Return all League entity
	 * 
	 */
	@Transactional
	public List<Program> findAllLeagues4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Program>(programDAO.findAllLeagues4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public void saveProgram(Users user4session, Program program, Integer levelId, Integer coordId, Integer resourceId, Integer priceId, Integer sportId) {
		Program existingProgram = programDAO.findProgramByPrimaryKey(program.getProgramId());
		if (existingProgram != null) {
			if (existingProgram != program) {
				existingProgram.setProgramId(program.getProgramId());
				existingProgram.setProgramName(program.getProgramName());
				existingProgram.setStartDate(program.getStartDate());
				existingProgram.setEndDate(program.getEndDate());
				existingProgram.setActiveYn(program.getActiveYn());
				existingProgram.setTswacct(user4session.getTswacct());
				existingProgram.setPublishYn(program.getPublishYn());
				existingProgram.setTotalPaid(program.getTotalPaid());
				existingProgram.setTotalParticipants(program.getTotalParticipants());
				existingProgram.setGamesPerTeam(program.getGamesPerTeam());
				existingProgram.setGameMins(program.getGameMins());
				existingProgram.setLeagueYn(program.getLeagueYn());
				existingProgram.setLevel(program.getLevel());
			}
			program = existingProgram;
		} else {
			int progId = programDAO.getMaxProgramID();
			program.setProgramId(progId+1);			
			program.setTswacct(user4session.getTswacct());
			if(program.getLeagueYn()==null){
				program.setLeagueYn(0);
			}
			program.setActiveYn(new Integer(1));
		}
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		
		program = programDAO.store(program);		
		programDAO.flush();
	}

	@Override
	public Integer getProgramsCount4tsw(Tswacct tswacct) {
		int tswId = tswacct.getTswAcctId();
		return ((Long) programDAO.createQuerySingleResult("select count(programId) from Program o where (leagueYn<>'1') and (tswAcctFk='"+tswId+"')").getSingleResult()).intValue();
	}

	@Override
	public Integer getLeaguesCount4tsw(Tswacct tswacct) {
		int tswId = tswacct.getTswAcctId();
		return ((Long) programDAO.createQuerySingleResult("select count(programId) from Program o where (leagueYn='1') and (tswAcctFk='"+tswId+"')").getSingleResult()).intValue();
	}

	@Override
	public Integer getProgramTeamsCount(Integer programId) {
		return ((Long) programDAO.createQuerySingleResult("select count(teamId) from Team o where programFk='"+programId+"'").getSingleResult()).intValue();
	}

	@Override
	public Program updateTeamCounts(Program program) {
		Set<Team> tms  = program.getTeams();
		if(tms.size()>0){
			MathContext mc = new MathContext(8);
			BigDecimal amtPaid = new BigDecimal("0.00",mc);
			Iterator<Team> tmsIter = tms.iterator();
			while(tmsIter.hasNext()){
				Team tm = tmsIter.next();
				if(tm.getAmtPaid()!=null){
					amtPaid = amtPaid.add(tm.getAmtPaid());
				}
			}
			program.setTotalPaid(amtPaid);
			program.setTotalParticipants(tms.size());
		}
		return program;
	}

	@Override
	public Program updateParticipantCounts(Program program) {
		Set<Participant> parts  = program.getParticipants();
		if(parts.size()>0){
			MathContext mc = new MathContext(8);
			BigDecimal amtPaid = new BigDecimal("0.00",mc);
			Iterator<Participant> partsIter = parts.iterator();
			while(partsIter.hasNext()){
				Participant part = partsIter.next();
				amtPaid = amtPaid.add(part.getAmtPaid(),mc);
			}
			program.setTotalPaid(amtPaid);
			program.setTotalParticipants(parts.size());
		}
		return program;
	}
	
	@Override
	public Team updateTeamStandings(Team team) {
		if(team!=null){
		Set<Game> homeGames = team.getGamesForHomeTeamFk();
		int wins = 0;
		int losses = 0;
		int ties = 0;
		if(homeGames.size()>0){
			Iterator<Game> gameIter = homeGames.iterator();
			while(gameIter.hasNext()){
				Game theGame = gameIter.next();
				if(theGame.getHomeScore()!=null && theGame.getVisitorScore()!=null){
					if(theGame.getHomeScore()>theGame.getVisitorScore()){
						wins++;
					}
					if(theGame.getHomeScore().equals(theGame.getVisitorScore())){
						ties++;
					}
					if(theGame.getHomeScore()<theGame.getVisitorScore()){
						losses++;
					}					
				}
			}
		}
		Set<Game> visitorGames = team.getGamesForVisitorTeamFk();
		if(visitorGames.size()>0){
			Iterator<Game> gameIter = visitorGames.iterator();
			while(gameIter.hasNext()){
				Game theGame = gameIter.next();
				if(theGame.getHomeScore()!=null && theGame.getVisitorScore()!=null){
					if(theGame.getVisitorScore()>theGame.getHomeScore()){
						wins++;
					}
					if(theGame.getVisitorScore().equals(theGame.getHomeScore())){
						ties++;
					}
					if(theGame.getVisitorScore()<theGame.getHomeScore()){
						losses++;
					}					
				}
			}
		}		
		if(wins==0){
			team.setWins(null);
		} else {
			team.setWins(wins);
		}
		if(losses==0){
			team.setLosses(null);
		} else {
			team.setLosses(losses);
		}
		if(ties==0){
			team.setTies(null);
		} else {
			team.setTies(ties);
		}
		}
		return team;
	}
	
}
