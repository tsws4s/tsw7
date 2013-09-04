package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.GameDAO;
import tsw.dao.LevelDAO;
import tsw.dao.ParticipantDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.ResourceDAO;
import tsw.dao.TeamDAO;
import tsw.dao.TeamplayersDAO;
import tsw.dao.TswacctDAO;
import tsw.dao.UsersDAO;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Level;
import tsw.domain.Participant;
import tsw.domain.Program;
import tsw.domain.Resource;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.domain.Users;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Tswacct entities
 * 
 */

@Service("TswacctService")
@Transactional
public class TswacctServiceImpl implements TswacctService {
	
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
	 * DAO injected by Spring that manages Resource entities
	 * 
	 */
	@Autowired
	private ResourceDAO resourceDAO;

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
	 * DAO injected by Spring that manages Users entities
	 * 
	 */
	@Autowired
	private UsersDAO usersDAO;

	/**
	 * Instantiates a new TswacctServiceImpl.
	 *
	 */
	public TswacctServiceImpl() {
	}

	/**
	 */
	@Transactional
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId) {
		return tswacctDAO.findTswacctByPrimaryKey(tswAcctId);
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctCustomers(Integer tswacct_tswAcctId, Integer related_customers_customerId) {
		Customer related_customers = customerDAO.findCustomerByPrimaryKey(related_customers_customerId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_customers.setTswacct(null);
		tswacct.getCustomers().remove(related_customers);

		customerDAO.remove(related_customers);
		customerDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctGames(Integer tswacct_tswAcctId, Integer related_games_gameId) {
		Game related_games = gameDAO.findGameByPrimaryKey(related_games_gameId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_games.setTswacct(null);
		tswacct.getGames().remove(related_games);

		gameDAO.remove(related_games);
		gameDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Participant entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctParticipants(Integer tswAcctId, Participant related_participants) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
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

		related_participants.setTswacct(tswacct);
		tswacct.getParticipants().add(related_participants);
		related_participants = participantDAO.store(related_participants);
		participantDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctTeamplayerses(Integer tswacct_tswAcctId, Integer related_teamplayerses_teamPlayersId) {
		Teamplayers related_teamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_teamplayerses.setTswacct(null);
		tswacct.getTeamplayerses().remove(related_teamplayerses);

		teamplayersDAO.remove(related_teamplayerses);
		teamplayersDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctCustomer(Integer tswAcctId, Customer related_customer) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
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

		tswacct.setCustomer(related_customer);
		related_customer.getTswaccts().add(tswacct);
		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Resource entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctResources(Integer tswAcctId, Resource related_resources) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
		Resource existingresources = resourceDAO.findResourceByPrimaryKey(related_resources.getResourceId());

		// copy into the existing record to preserve existing relationships
		if (existingresources != null) {
			existingresources.setResourceId(related_resources.getResourceId());
			existingresources.setResourceName(related_resources.getResourceName());
			existingresources.setActiveYn(related_resources.getActiveYn());
			existingresources.setNotes(related_resources.getNotes());
			existingresources.setResourceType(related_resources.getResourceType());
			related_resources = existingresources;
		} else {
			related_resources = resourceDAO.store(related_resources);
			resourceDAO.flush();
		}

		related_resources.setTswacct(tswacct);
		tswacct.getResources().add(related_resources);
		related_resources = resourceDAO.store(related_resources);
		resourceDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Level entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctLevels(Integer tswacct_tswAcctId, Integer related_levels_levelId) {
		Level related_levels = levelDAO.findLevelByPrimaryKey(related_levels_levelId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_levels.setTswacct(null);
		tswacct.getLevels().remove(related_levels);

		levelDAO.remove(related_levels);
		levelDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctPrograms(Integer tswacct_tswAcctId, Integer related_programs_programId) {
		Program related_programs = programDAO.findProgramByPrimaryKey(related_programs_programId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_programs.setTswacct(null);
		tswacct.getPrograms().remove(related_programs);

		programDAO.remove(related_programs);
		programDAO.flush();

		return tswacct;
	}

	/**
	 * Return a count of all Tswacct entity
	 * 
	 */
	@Transactional
	public Integer countTswaccts() {
		return ((Long) tswacctDAO.createQuerySingleResult("select count(o) from Tswacct o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public void saveTswacct(Tswacct tswacct, Integer custId) {
		Tswacct existingTswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct.getTswAcctId());

		if (existingTswacct != null) {
			if (existingTswacct != tswacct) {
				existingTswacct.setTswAcctId(tswacct.getTswAcctId());
				existingTswacct.setAcctName(tswacct.getAcctName());
				existingTswacct.setSubscrType(tswacct.getSubscrType());
				existingTswacct.setAmtPaid(tswacct.getAmtPaid());
				existingTswacct.setEstablishDate(tswacct.getEstablishDate());
				existingTswacct.setExpireDate(tswacct.getExpireDate());
				existingTswacct.setActiveYn(tswacct.getActiveYn());
			}
			tswacct = existingTswacct;
		} else {
			int tswacctId = tswacctDAO.getMaxTswacctID();
			tswacct.setTswAcctId(tswacctId+1);
			tswacct.setActiveYn(new Integer(1));
		}
		if(custId!=null && custId>0){
			tswacct.setCustomer(customerDAO.findCustomerByPrimaryKey(custId));
		}
		tswacctDAO.store(tswacct);
		tswacctDAO.flush();
	}

	/**
	 * Load an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Set<Tswacct> loadTswaccts() {
		return tswacctDAO.findAllTswaccts();
	}
	@Transactional
	public Set<Tswacct> loadTswaccts(int from) {
		return tswacctDAO.findAllTswaccts(from,defaultMaxRows);
	}
	/**
	 * Delete an existing Resource entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctResources(Integer tswacct_tswAcctId, Integer related_resources_resourceId) {
		Resource related_resources = resourceDAO.findResourceByPrimaryKey(related_resources_resourceId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_resources.setTswacct(null);
		tswacct.getResources().remove(related_resources);

		resourceDAO.remove(related_resources);
		resourceDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctCustomers(Integer tswAcctId, Customer related_customers) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
		Customer existingcustomers = customerDAO.findCustomerByPrimaryKey(related_customers.getCustomerId());

		// copy into the existing record to preserve existing relationships
		if (existingcustomers != null) {
			existingcustomers.setCustomerId(related_customers.getCustomerId());
			existingcustomers.setEmail(related_customers.getEmail());
			existingcustomers.setFirstname(related_customers.getFirstname());
			existingcustomers.setLastname(related_customers.getLastname());
			existingcustomers.setPhone(related_customers.getPhone());
			existingcustomers.setYearBorn(related_customers.getYearBorn());
			existingcustomers.setAddress(related_customers.getAddress());
			existingcustomers.setCity(related_customers.getCity());
			existingcustomers.setState(related_customers.getState());
			existingcustomers.setZipcode(related_customers.getZipcode());
			related_customers = existingcustomers;
		} else {
			related_customers = customerDAO.store(related_customers);
			customerDAO.flush();
		}

		related_customers.setTswacct(tswacct);
		tswacct.getCustomers().add(related_customers);
		related_customers = customerDAO.store(related_customers);
		customerDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Users entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctUserses(Integer tswacct_tswAcctId, Integer related_userses_userId) {
		Users related_userses = usersDAO.findUsersByPrimaryKey(related_userses_userId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_userses.setTswacct(null);
		tswacct.getUserses().remove(related_userses);

		usersDAO.remove(related_userses);
		usersDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctUserses(Integer tswAcctId, Users related_userses) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
		Users existinguserses = usersDAO.findUsersByPrimaryKey(related_userses.getUserId());

		// copy into the existing record to preserve existing relationships
		if (existinguserses != null) {
			existinguserses.setUserId(related_userses.getUserId());
			existinguserses.setUsername(related_userses.getUsername());
			existinguserses.setPassword(related_userses.getPassword());
			existinguserses.setActiveYn(related_userses.getActiveYn());
			related_userses = existinguserses;
		} else {
			related_userses = usersDAO.store(related_userses);
			usersDAO.flush();
		}

		related_userses.setTswacct(tswacct);
		tswacct.getUserses().add(related_userses);
		related_userses = usersDAO.store(related_userses);
		usersDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctTeamplayerses(Integer tswAcctId, Teamplayers related_teamplayerses) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
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

		related_teamplayerses.setTswacct(tswacct);
		tswacct.getTeamplayerses().add(related_teamplayerses);
		related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
		teamplayersDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctCustomer(Integer tswacct_tswAcctId, Integer related_customer_customerId) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, defaultMaxRows);

		tswacct.setCustomer(null);
		related_customer.getTswaccts().remove(tswacct);
		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		customerDAO.remove(related_customer);
		customerDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public void deleteTswacct(Tswacct tswacct) {
		tswacctDAO.remove(tswacct);
		tswacctDAO.flush();
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctTeams(Integer tswacct_tswAcctId, Integer related_teams_teamId) {
		Team related_teams = teamDAO.findTeamByPrimaryKey(related_teams_teamId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_teams.setTswacct(null);
		tswacct.getTeams().remove(related_teams);

		teamDAO.remove(related_teams);
		teamDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Level entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctLevels(Integer tswAcctId, Level related_levels) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
		Level existinglevels = levelDAO.findLevelByPrimaryKey(related_levels.getLevelId());

		// copy into the existing record to preserve existing relationships
		if (existinglevels != null) {
			existinglevels.setLevelId(related_levels.getLevelId());
			existinglevels.setLevelName(related_levels.getLevelName());
			existinglevels.setLevelCode(related_levels.getLevelCode());
			existinglevels.setAgeLow(related_levels.getAgeLow());
			existinglevels.setAgeHigh(related_levels.getAgeHigh());
			existinglevels.setActiveYn(related_levels.getActiveYn());
			related_levels = existinglevels;
		} else {
			related_levels = levelDAO.store(related_levels);
			levelDAO.flush();
		}

		related_levels.setTswacct(tswacct);
		tswacct.getLevels().add(related_levels);
		related_levels = levelDAO.store(related_levels);
		levelDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	@Transactional
	public Tswacct deleteTswacctParticipants(Integer tswacct_tswAcctId, Integer related_participants_participantId) {
		Participant related_participants = participantDAO.findParticipantByPrimaryKey(related_participants_participantId, -1, defaultMaxRows);

		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswacct_tswAcctId, -1, defaultMaxRows);

		related_participants.setTswacct(null);
		tswacct.getParticipants().remove(related_participants);

		participantDAO.remove(related_participants);
		participantDAO.flush();

		return tswacct;
	}

	/**
	 * Return all Tswacct entity
	 * 
	 */
	@Transactional
	public List<Tswacct> findAllTswaccts(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Tswacct>(tswacctDAO.findAllTswaccts(startResult, maxRows));
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctTeams(Integer tswAcctId, Team related_teams) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
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
		} else {
			related_teams = teamDAO.store(related_teams);
			teamDAO.flush();
		}

		related_teams.setTswacct(tswacct);
		tswacct.getTeams().add(related_teams);
		related_teams = teamDAO.store(related_teams);
		teamDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctGames(Integer tswAcctId, Game related_games) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
		Game existinggames = gameDAO.findGameByPrimaryKey(related_games.getGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggames != null) {
			existinggames.setGameId(related_games.getGameId());
			existinggames.setGameDate(related_games.getGameDate());
			existinggames.setHomeScore(related_games.getHomeScore());
			existinggames.setVisitorScore(related_games.getVisitorScore());
			existinggames.setActiveYn(related_games.getActiveYn());
			related_games = existinggames;
		} else {
			related_games = gameDAO.store(related_games);
			gameDAO.flush();
		}

		related_games.setTswacct(tswacct);
		tswacct.getGames().add(related_games);
		related_games = gameDAO.store(related_games);
		gameDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Tswacct saveTswacctPrograms(Integer tswAcctId, Program related_programs) {
		Tswacct tswacct = tswacctDAO.findTswacctByPrimaryKey(tswAcctId, -1, defaultMaxRows);
		Program existingprograms = programDAO.findProgramByPrimaryKey(related_programs.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprograms != null) {
			existingprograms.setProgramId(related_programs.getProgramId());
			existingprograms.setProgramName(related_programs.getProgramName());
			existingprograms.setPrice(related_programs.getPrice());
			existingprograms.setStartDate(related_programs.getStartDate());
			existingprograms.setEndDate(related_programs.getEndDate());
			existingprograms.setActiveYn(related_programs.getActiveYn());
			existingprograms.setPublishYn(related_programs.getPublishYn());
			existingprograms.setTotalPaid(related_programs.getTotalPaid());
			existingprograms.setTotalParticipants(related_programs.getTotalParticipants());
			existingprograms.setGamesPerTeam(related_programs.getGamesPerTeam());
			existingprograms.setLeagueYn(related_programs.getLeagueYn());
			related_programs = existingprograms;
		} else {
			related_programs = programDAO.store(related_programs);
			programDAO.flush();
		}

		related_programs.setTswacct(tswacct);
		tswacct.getPrograms().add(related_programs);
		related_programs = programDAO.store(related_programs);
		programDAO.flush();

		tswacct = tswacctDAO.store(tswacct);
		tswacctDAO.flush();

		return tswacct;
	}

	@Override
	public Integer getTswacctCount() {
		return ((Long) tswacctDAO.createQuerySingleResult("select count(tswacctId) from Tswacct o").getSingleResult()).intValue();
	}

}
