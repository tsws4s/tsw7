package wsdm.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import wsdm.dao.CustomerDAO;
import wsdm.dao.EventDAO;
import wsdm.dao.GameDAO;
import wsdm.dao.ParticipantDAO;
import wsdm.dao.PriceDAO;
import wsdm.dao.ProgramDAO;
import wsdm.dao.ProgramresourceDAO;
import wsdm.dao.ResourceDAO;
import wsdm.dao.SportDAO;
import wsdm.dao.TeamDAO;
import wsdm.dao.TeamplayersDAO;
import wsdm.dao.TswacctDAO;

import wsdm.domain.Customer;
import wsdm.domain.Event;
import wsdm.domain.Game;
import wsdm.domain.Participant;
import wsdm.domain.Price;
import wsdm.domain.Program;
import wsdm.domain.Programresource;
import wsdm.domain.Resource;
import wsdm.domain.Sport;
import wsdm.domain.Team;
import wsdm.domain.Teamplayers;
import wsdm.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Program entities
 * 
 */

@Service("ProgramService")
@Transactional
public class ProgramServiceImpl implements ProgramService {

	/**
	 * DAO injected by Spring that manages Customer entities
	 * 
	 */
	@Autowired
	private CustomerDAO customerDAO;

	/**
	 * DAO injected by Spring that manages Event entities
	 * 
	 */
	@Autowired
	private EventDAO eventDAO;

	/**
	 * DAO injected by Spring that manages Game entities
	 * 
	 */
	@Autowired
	private GameDAO gameDAO;

	/**
	 * DAO injected by Spring that manages Participant entities
	 * 
	 */
	@Autowired
	private ParticipantDAO participantDAO;

	/**
	 * DAO injected by Spring that manages Price entities
	 * 
	 */
	@Autowired
	private PriceDAO priceDAO;

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

	/**
	 * DAO injected by Spring that manages Programresource entities
	 * 
	 */
	@Autowired
	private ProgramresourceDAO programresourceDAO;

	/**
	 * DAO injected by Spring that manages Resource entities
	 * 
	 */
	@Autowired
	private ResourceDAO resourceDAO;

	/**
	 * DAO injected by Spring that manages Sport entities
	 * 
	 */
	@Autowired
	private SportDAO sportDAO;

	/**
	 * DAO injected by Spring that manages Team entities
	 * 
	 */
	@Autowired
	private TeamDAO teamDAO;

	/**
	 * DAO injected by Spring that manages Teamplayers entities
	 * 
	 */
	@Autowired
	private TeamplayersDAO teamplayersDAO;

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;

	/**
	 * Instantiates a new ProgramServiceImpl.
	 *
	 */
	public ProgramServiceImpl() {
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public void saveProgram(Program program) {
		Program existingProgram = programDAO.findProgramByPrimaryKey(program.getProgramId());

		if (existingProgram != null) {
			if (existingProgram != program) {
				existingProgram.setProgramId(program.getProgramId());
				existingProgram.setProgramName(program.getProgramName());
				existingProgram.setStartDate(program.getStartDate());
				existingProgram.setEndDate(program.getEndDate());
				existingProgram.setLevelFk(program.getLevelFk());
				existingProgram.setActiveYn(program.getActiveYn());
				existingProgram.setPublishYn(program.getPublishYn());
				existingProgram.setTotalPaid(program.getTotalPaid());
				existingProgram.setTotalParticipants(program.getTotalParticipants());
				existingProgram.setGamesPerTeam(program.getGamesPerTeam());
				existingProgram.setLeagueYn(program.getLeagueYn());
			}
			program = programDAO.store(existingProgram);
		} else {
			program = programDAO.store(program);
		}
		programDAO.flush();
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Program saveProgramCustomer(Integer programId, Customer related_customer) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
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
			existingcustomer.setAddrSameAsFamily(related_customer.getAddrSameAsFamily());
			existingcustomer.setActiveYn(related_customer.getActiveYn());
			existingcustomer.setPassword(related_customer.getPassword());
			existingcustomer.setSelectTheme(related_customer.getSelectTheme());
			existingcustomer.setAdminYn(related_customer.getAdminYn());
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
	 * Save an existing Event entity
	 * 
	 */
	@Transactional
	public Program saveProgramEvents(Integer programId, Event related_events) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Event existingevents = eventDAO.findEventByPrimaryKey(related_events.getEventId());

		// copy into the existing record to preserve existing relationships
		if (existingevents != null) {
			existingevents.setEventId(related_events.getEventId());
			existingevents.setStartTime(related_events.getStartTime());
			existingevents.setEndTime(related_events.getEndTime());
			existingevents.setEventName(related_events.getEventName());
			existingevents.setDescription(related_events.getDescription());
			existingevents.setEventType(related_events.getEventType());
			existingevents.setEventUrl(related_events.getEventUrl());
			existingevents.setEventColor(related_events.getEventColor());
			existingevents.setAllDay(related_events.getAllDay());
			related_events = existingevents;
		} else {
			related_events = eventDAO.store(related_events);
			eventDAO.flush();
		}

		related_events.setProgram(program);
		program.getEvents().add(related_events);
		related_events = eventDAO.store(related_events);
		eventDAO.flush();

		program = programDAO.store(program);
		programDAO.flush();

		return program;
	}

	/**
	 * Save an existing Price entity
	 * 
	 */
	@Transactional
	public Program saveProgramPrice(Integer programId, Price related_price) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Price existingprice = priceDAO.findPriceByPrimaryKey(related_price.getPriceId());

		// copy into the existing record to preserve existing relationships
		if (existingprice != null) {
			existingprice.setPriceId(related_price.getPriceId());
			existingprice.setPriceField(related_price.getPriceField());
			existingprice.setPriceCategory(related_price.getPriceCategory());
			existingprice.setDescription(related_price.getDescription());
			existingprice.setPriceColor(related_price.getPriceColor());
			related_price = existingprice;
		} else {
			related_price = priceDAO.store(related_price);
			priceDAO.flush();
		}

		program.setPrice(related_price);
		related_price.getPrograms().add(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_price = priceDAO.store(related_price);
		priceDAO.flush();

		return program;
	}

	/**
	 * Save an existing Resource entity
	 * 
	 */
	@Transactional
	public Program saveProgramResource(Integer programId, Resource related_resource) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Resource existingresource = resourceDAO.findResourceByPrimaryKey(related_resource.getResourceId());

		// copy into the existing record to preserve existing relationships
		if (existingresource != null) {
			existingresource.setResourceId(related_resource.getResourceId());
			existingresource.setResourceName(related_resource.getResourceName());
			existingresource.setActiveYn(related_resource.getActiveYn());
			existingresource.setNotes(related_resource.getNotes());
			existingresource.setResourceType(related_resource.getResourceType());
			existingresource.setEmail(related_resource.getEmail());
			existingresource.setPhone(related_resource.getPhone());
			existingresource.setAddress(related_resource.getAddress());
			existingresource.setCity(related_resource.getCity());
			existingresource.setState(related_resource.getState());
			existingresource.setZipcode(related_resource.getZipcode());
			related_resource = existingresource;
		} else {
			related_resource = resourceDAO.store(related_resource);
			resourceDAO.flush();
		}

		program.setResource(related_resource);
		related_resource.getPrograms().add(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_resource = resourceDAO.store(related_resource);
		resourceDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Program deleteProgramGames(Integer program_programId, Integer related_games_gameId) {
		Game related_games = gameDAO.findGameByPrimaryKey(related_games_gameId, -1, -1);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);

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
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
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
	 * Return a count of all Program entity
	 * 
	 */
	@Transactional
	public Integer countPrograms() {
		return ((Long) programDAO.createQuerySingleResult("select count(o) from Program o").getSingleResult()).intValue();
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
	 * Save an existing Participant entity
	 * 
	 */
	@Transactional
	public Program saveProgramParticipants(Integer programId, Participant related_participants) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Participant existingparticipants = participantDAO.findParticipantByPrimaryKey(related_participants.getParticipantId());

		// copy into the existing record to preserve existing relationships
		if (existingparticipants != null) {
			existingparticipants.setParticipantId(related_participants.getParticipantId());
			existingparticipants.setAmtPaid(related_participants.getAmtPaid());
			existingparticipants.setNotes(related_participants.getNotes());
			existingparticipants.setGroup1(related_participants.getGroup1());
			existingparticipants.setSignedWaiverYn(related_participants.getSignedWaiverYn());
			existingparticipants.setActiveYn(related_participants.getActiveYn());
			related_participants = existingparticipants;
		} else {
			related_participants = participantDAO.store(related_participants);
			participantDAO.flush();
		}

		related_participants.setProgram(program);
		program.getParticipants().add(related_participants);
		related_participants = participantDAO.store(related_participants);
		participantDAO.flush();

		program = programDAO.store(program);
		programDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Resource entity
	 * 
	 */
	@Transactional
	public Program deleteProgramResource(Integer program_programId, Integer related_resource_resourceId) {
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);
		Resource related_resource = resourceDAO.findResourceByPrimaryKey(related_resource_resourceId, -1, -1);

		program.setResource(null);
		related_resource.getPrograms().remove(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_resource = resourceDAO.store(related_resource);
		resourceDAO.flush();

		resourceDAO.remove(related_resource);
		resourceDAO.flush();

		return program;
	}

	/**
	 * Load an existing Program entity
	 * 
	 */
	@Transactional
	public Set<Program> loadPrograms() {
		return programDAO.findAllPrograms();
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
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Program saveProgramGames(Integer programId, Game related_games) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Game existinggames = gameDAO.findGameByPrimaryKey(related_games.getGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggames != null) {
			existinggames.setGameId(related_games.getGameId());
			existinggames.setGameDate(related_games.getGameDate());
			existinggames.setHomeScore(related_games.getHomeScore());
			existinggames.setVisitorScore(related_games.getVisitorScore());
			existinggames.setRefereeFk(related_games.getRefereeFk());
			existinggames.setActiveYn(related_games.getActiveYn());
			related_games = existinggames;
		} else {
			related_games = gameDAO.store(related_games);
			gameDAO.flush();
		}

		related_games.setProgram(program);
		program.getGames().add(related_games);
		related_games = gameDAO.store(related_games);
		gameDAO.flush();

		program = programDAO.store(program);
		programDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Program deleteProgramTswacct(Integer program_programId, Integer related_tswacct_tswAcctId) {
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, -1);

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
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Program saveProgramTeams(Integer programId, Team related_teams) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
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
			related_teams = existingteams;
		}

		related_teams.setProgram(program);
		program.getTeams().add(related_teams);
		related_teams = teamDAO.store(related_teams);
		teamDAO.flush();

		program = programDAO.store(program);
		programDAO.flush();

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
	 * Delete an existing Participant entity
	 * 
	 */
	@Transactional
	public Program deleteProgramParticipants(Integer program_programId, Integer related_participants_participantId) {
		Participant related_participants = participantDAO.findParticipantByPrimaryKey(related_participants_participantId, -1, -1);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);

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
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, -1);

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
	 */
	@Transactional
	public Program findProgramByPrimaryKey(Integer programId) {
		return programDAO.findProgramByPrimaryKey(programId);
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Program saveProgramTeamplayerses(Integer programId, Teamplayers related_teamplayerses) {
		Program program = programDAO.findProgramByPrimaryKey(programId, -1, -1);
		Teamplayers existingteamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses.getTeamPlayersId());

		// copy into the existing record to preserve existing relationships
		if (existingteamplayerses != null) {
			existingteamplayerses.setTeamPlayersId(related_teamplayerses.getTeamPlayersId());
			existingteamplayerses.setAmtPaid(related_teamplayerses.getAmtPaid());
			existingteamplayerses.setNotes(related_teamplayerses.getNotes());
			existingteamplayerses.setGroup2(related_teamplayerses.getGroup2());
			existingteamplayerses.setSignedWaiverYn(related_teamplayerses.getSignedWaiverYn());
			existingteamplayerses.setActiveYn(related_teamplayerses.getActiveYn());
			existingteamplayerses.setCaptain(related_teamplayerses.getCaptain());
			existingteamplayerses.setSportPositionFk(related_teamplayerses.getSportPositionFk());
			existingteamplayerses.setOtherAmtPaid(related_teamplayerses.getOtherAmtPaid());
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
	 * Delete an existing Event entity
	 * 
	 */
	@Transactional
	public Program deleteProgramEvents(Integer program_programId, Integer related_events_eventId) {
		Event related_events = eventDAO.findEventByPrimaryKey(related_events_eventId, -1, -1);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);

		related_events.setProgram(null);
		program.getEvents().remove(related_events);

		eventDAO.remove(related_events);
		eventDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Program deleteProgramTeamplayerses(Integer program_programId, Integer related_teamplayerses_teamPlayersId) {
		Teamplayers related_teamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId, -1, -1);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);

		related_teamplayerses.setProgram(null);
		program.getTeamplayerses().remove(related_teamplayerses);

		teamplayersDAO.remove(related_teamplayerses);
		teamplayersDAO.flush();

		return program;
	}

	/**
	 * Return all Program entity
	 * 
	 */
	@Transactional
	public List<Program> findAllPrograms(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Program>(programDAO.findAllPrograms(startResult, maxRows));
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
			existingprogramresources.setResourceFk(related_programresources.getResourceFk());
			existingprogramresources.setResourcePriceFk(related_programresources.getResourcePriceFk());
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
	 * Delete an existing Price entity
	 * 
	 */
	@Transactional
	public Program deleteProgramPrice(Integer program_programId, Integer related_price_priceId) {
		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);
		Price related_price = priceDAO.findPriceByPrimaryKey(related_price_priceId, -1, -1);

		program.setPrice(null);
		related_price.getPrograms().remove(program);
		program = programDAO.store(program);
		programDAO.flush();

		related_price = priceDAO.store(related_price);
		priceDAO.flush();

		priceDAO.remove(related_price);
		priceDAO.flush();

		return program;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Program deleteProgramTeams(Integer program_programId, Integer related_teams_teamId) {
		Team related_teams = teamDAO.findTeamByPrimaryKey(related_teams_teamId, -1, -1);

		Program program = programDAO.findProgramByPrimaryKey(program_programId, -1, -1);

		related_teams.setProgram(null);
		program.getTeams().remove(related_teams);

		teamDAO.remove(related_teams);
		teamDAO.flush();

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
}
