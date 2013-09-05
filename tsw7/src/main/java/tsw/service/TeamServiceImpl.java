package tsw.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.GameDAO;
import tsw.dao.LevelDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.SportpositionDAO;
import tsw.dao.TeamDAO;
import tsw.dao.TeamplayersDAO;
import tsw.dao.TswacctDAO;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Level;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Team entities
 * 
 */

@Service("TeamService")
@Transactional
public class TeamServiceImpl implements TeamService {
	
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
	@Autowired
	private SportpositionDAO sportPositionDAO;

	/**
	 * Instantiates a new TeamServiceImpl.
	 *
	 */
	public TeamServiceImpl() {
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Team saveTeamTswacct(Integer teamId, Tswacct related_tswacct) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
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

		team.setTswacct(related_tswacct);
		related_tswacct.getTeams().add(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return team;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Team saveTeamCustomerByCoachCustFk(Integer teamId, Customer related_customerbycoachcustfk) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
		Customer existingcustomerByCoachCustFk = customerDAO.findCustomerByPrimaryKey(related_customerbycoachcustfk.getCustomerId());

		// copy into the existing record to preserve existing relationships
		if (existingcustomerByCoachCustFk != null) {
			existingcustomerByCoachCustFk.setCustomerId(related_customerbycoachcustfk.getCustomerId());
			existingcustomerByCoachCustFk.setEmail(related_customerbycoachcustfk.getEmail());
			existingcustomerByCoachCustFk.setFirstname(related_customerbycoachcustfk.getFirstname());
			existingcustomerByCoachCustFk.setLastname(related_customerbycoachcustfk.getLastname());
			existingcustomerByCoachCustFk.setPhone(related_customerbycoachcustfk.getPhone());
			existingcustomerByCoachCustFk.setYearBorn(related_customerbycoachcustfk.getYearBorn());
			existingcustomerByCoachCustFk.setAddress(related_customerbycoachcustfk.getAddress());
			existingcustomerByCoachCustFk.setCity(related_customerbycoachcustfk.getCity());
			existingcustomerByCoachCustFk.setState(related_customerbycoachcustfk.getState());
			existingcustomerByCoachCustFk.setZipcode(related_customerbycoachcustfk.getZipcode());
			related_customerbycoachcustfk = existingcustomerByCoachCustFk;
		} else {
			related_customerbycoachcustfk = customerDAO.store(related_customerbycoachcustfk);
			customerDAO.flush();
		}

		team.setCustomerByCoachCustFk(related_customerbycoachcustfk);
		related_customerbycoachcustfk.getTeamsForCoachCustFk().add(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_customerbycoachcustfk = customerDAO.store(related_customerbycoachcustfk);
		customerDAO.flush();

		return team;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Team deleteTeamTeamplayerses(Integer team_teamId, Integer related_teamplayerses_teamPlayersId) {
		Teamplayers related_teamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId, -1, defaultMaxRows);

		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);

		related_teamplayerses.setTeam(null);
		team.getTeamplayerses().remove(related_teamplayerses);

		teamplayersDAO.remove(related_teamplayerses);
		teamplayersDAO.flush();

		return team;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Team saveTeamTeamplayerses(Tswacct tswacct, Integer teamId, Integer custId, Integer selected_sportPosition_id1, Teamplayers related_teamplayerses) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
		Teamplayers existingteamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses.getTeamPlayersId());

		// copy into the existing record to preserve existing relationships
		if (existingteamplayerses != null) {
			existingteamplayerses.setTeamPlayersId(related_teamplayerses.getTeamPlayersId());
			existingteamplayerses.setAmtPaid(related_teamplayerses.getAmtPaid());
			existingteamplayerses.setNotes(related_teamplayerses.getNotes());
			existingteamplayerses.setGroup2(related_teamplayerses.getGroup2());
			existingteamplayerses.setSignedWaiverYn(related_teamplayerses.getSignedWaiverYn());
			existingteamplayerses.setActiveYn(related_teamplayerses.getActiveYn());
			existingteamplayerses.setCustomer(related_teamplayerses.getCustomer());
			related_teamplayerses = existingteamplayerses;
		} else {
			int tmplyrId = teamplayersDAO.getMaxTeamplayersID();
			related_teamplayerses.setTeamPlayersId(tmplyrId+1);
			related_teamplayerses.setTswacct(tswacct);
			related_teamplayerses.setTeam(team);
			related_teamplayerses.setProgram(team.getProgram());
			related_teamplayerses.setLevel(team.getProgram().getLevel());
			related_teamplayerses.setActiveYn(new Integer(1));
			team.getTeamplayerses().add(related_teamplayerses);
		}
		if(custId!=null && custId>0){
			related_teamplayerses.setCustomer(customerDAO.findCustomerByPrimaryKey(custId));
		}
		if(selected_sportPosition_id1!=null && selected_sportPosition_id1>0){
			related_teamplayerses.setSportPosition(sportPositionDAO.findSportpositionByPrimaryKey(selected_sportPosition_id1));
		}

		related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
		teamplayersDAO.flush();
		team = teamDAO.store(team);
		teamDAO.flush();
		return team;
	}	
	
	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Team deleteTeamGamesForHomeTeamFk(Integer team_teamId, Integer related_gamesforhometeamfk_gameId) {
		Game related_gamesforhometeamfk = gameDAO.findGameByPrimaryKey(related_gamesforhometeamfk_gameId, -1, defaultMaxRows);

		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);

		related_gamesforhometeamfk.setTeamByVisitorTeamFk(null);
		team.getGamesForVisitorTeamFk().remove(related_gamesforhometeamfk);

		gameDAO.remove(related_gamesforhometeamfk);
		gameDAO.flush();

		return team;
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public void saveTeam(Team team) {
		Team existingTeam = teamDAO.findTeamByPrimaryKey(team.getTeamId());

		if (existingTeam != null) {
			if (existingTeam != team) {
				existingTeam.setTeamId(team.getTeamId());
				existingTeam.setTeamName(team.getTeamName());
				existingTeam.setAmtPaid(team.getAmtPaid());
				existingTeam.setWins(team.getWins());
				existingTeam.setLosses(team.getLosses());
				existingTeam.setTies(team.getTies());
				existingTeam.setGroup3(team.getGroup3());
				existingTeam.setColor(team.getColor());
				existingTeam.setPublishYn(team.getPublishYn());
				existingTeam.setActiveYn(team.getActiveYn());
				existingTeam.setNotes(team.getNotes());
			}
			team = teamDAO.store(existingTeam);
		} else {
			team = teamDAO.store(team);
		}
		teamDAO.flush();
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Team deleteTeamCustomerByManagerCustFk(Integer team_teamId, Integer related_customerbymanagercustfk_customerId) {
		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);
		Customer related_customerbymanagercustfk = customerDAO.findCustomerByPrimaryKey(related_customerbymanagercustfk_customerId, -1, defaultMaxRows);

		team.setCustomerByManagerCustFk(null);
		related_customerbymanagercustfk.getTeamsForManagerCustFk().remove(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_customerbymanagercustfk = customerDAO.store(related_customerbymanagercustfk);
		customerDAO.flush();

		customerDAO.remove(related_customerbymanagercustfk);
		customerDAO.flush();

		return team;
	}

	/**
	 */
	@Transactional
	public Team findTeamByPrimaryKey(Integer teamId) {
		return teamDAO.findTeamByPrimaryKey(teamId);
	}

	@Transactional
	public Team findTeamByTeamName(Tswacct tswacct, Program pgm, String teamName) {
		return teamDAO.findTeamByTeamName(tswacct, pgm, teamName);
	}
	/**
	 * Delete an existing Level entity
	 * 
	 */
	@Transactional
	public Team deleteTeamLevel(Integer team_teamId, Integer related_level_levelId) {
		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);
		Level related_level = levelDAO.findLevelByPrimaryKey(related_level_levelId, -1, defaultMaxRows);

		team.setLevel(null);
		related_level.getTeams().remove(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_level = levelDAO.store(related_level);
		levelDAO.flush();

		levelDAO.remove(related_level);
		levelDAO.flush();

		return team;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Team deleteTeamTswacct(Integer team_teamId, Integer related_tswacct_tswAcctId) {
		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		team.setTswacct(null);
		related_tswacct.getTeams().remove(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return team;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Team saveTeamCustomerByManagerCustFk(Integer teamId, Customer related_customerbymanagercustfk) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
		Customer existingcustomerByManagerCustFk = customerDAO.findCustomerByPrimaryKey(related_customerbymanagercustfk.getCustomerId());

		// copy into the existing record to preserve existing relationships
		if (existingcustomerByManagerCustFk != null) {
			existingcustomerByManagerCustFk.setCustomerId(related_customerbymanagercustfk.getCustomerId());
			existingcustomerByManagerCustFk.setEmail(related_customerbymanagercustfk.getEmail());
			existingcustomerByManagerCustFk.setFirstname(related_customerbymanagercustfk.getFirstname());
			existingcustomerByManagerCustFk.setLastname(related_customerbymanagercustfk.getLastname());
			existingcustomerByManagerCustFk.setPhone(related_customerbymanagercustfk.getPhone());
			existingcustomerByManagerCustFk.setYearBorn(related_customerbymanagercustfk.getYearBorn());
			existingcustomerByManagerCustFk.setAddress(related_customerbymanagercustfk.getAddress());
			existingcustomerByManagerCustFk.setCity(related_customerbymanagercustfk.getCity());
			existingcustomerByManagerCustFk.setState(related_customerbymanagercustfk.getState());
			existingcustomerByManagerCustFk.setZipcode(related_customerbymanagercustfk.getZipcode());
			related_customerbymanagercustfk = existingcustomerByManagerCustFk;
		} else {
			related_customerbymanagercustfk = customerDAO.store(related_customerbymanagercustfk);
			customerDAO.flush();
		}

		team.setCustomerByManagerCustFk(related_customerbymanagercustfk);
		related_customerbymanagercustfk.getTeamsForManagerCustFk().add(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_customerbymanagercustfk = customerDAO.store(related_customerbymanagercustfk);
		customerDAO.flush();

		return team;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Team deleteTeamCustomerByCoachCustFk(Integer team_teamId, Integer related_customerbycoachcustfk_customerId) {
		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);
		Customer related_customerbycoachcustfk = customerDAO.findCustomerByPrimaryKey(related_customerbycoachcustfk_customerId, -1, defaultMaxRows);

		team.setCustomerByCoachCustFk(null);
		related_customerbycoachcustfk.getTeamsForCoachCustFk().remove(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_customerbycoachcustfk = customerDAO.store(related_customerbycoachcustfk);
		customerDAO.flush();

		customerDAO.remove(related_customerbycoachcustfk);
		customerDAO.flush();

		return team;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public void deleteTeam(Team team) {
		teamDAO.remove(team);
		teamDAO.flush();
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Team deleteTeamProgram(Integer team_teamId, Integer related_program_programId) {
		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);
		Program related_program = programDAO.findProgramByPrimaryKey(related_program_programId, -1, defaultMaxRows);

		team.setProgram(null);
		related_program.getTeams().remove(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		programDAO.remove(related_program);
		programDAO.flush();

		return team;
	}

	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Team deleteTeamGamesForVisitorTeamFk(Integer team_teamId, Integer related_gamesforvisitorteamfk_gameId) {
		Game related_gamesforvisitorteamfk = gameDAO.findGameByPrimaryKey(related_gamesforvisitorteamfk_gameId, -1, defaultMaxRows);

		Team team = teamDAO.findTeamByPrimaryKey(team_teamId, -1, defaultMaxRows);

		related_gamesforvisitorteamfk.setTeamByVisitorTeamFk(null);
		team.getGamesForVisitorTeamFk().remove(related_gamesforvisitorteamfk);

		gameDAO.remove(related_gamesforvisitorteamfk);
		gameDAO.flush();

		return team;
	}

	/**
	 * Load an existing Team entity
	 * 
	 */
	@Transactional
	public Set<Team> loadTeams4tsw(Tswacct tswacct) {
		return teamDAO.findAllTeams4tsw(tswacct.getTswAcctId());
	}

	/**
	 * Return all Team entity
	 * 
	 */
	@Transactional
	public List<Team> findAllTeams4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Team>(teamDAO.findAllTeams4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Team saveTeamGamesForHomeTeamFk(Integer teamId, Game related_gamesforhometeamfk) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
		Game existinggamesForHomeTeamFk = gameDAO.findGameByPrimaryKey(related_gamesforhometeamfk.getGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggamesForHomeTeamFk != null) {
			existinggamesForHomeTeamFk.setGameId(related_gamesforhometeamfk.getGameId());
			existinggamesForHomeTeamFk.setGameDate(related_gamesforhometeamfk.getGameDate());
			existinggamesForHomeTeamFk.setHomeScore(related_gamesforhometeamfk.getHomeScore());
			existinggamesForHomeTeamFk.setVisitorScore(related_gamesforhometeamfk.getVisitorScore());
			existinggamesForHomeTeamFk.setActiveYn(related_gamesforhometeamfk.getActiveYn());
			related_gamesforhometeamfk = existinggamesForHomeTeamFk;
		} else {
			related_gamesforhometeamfk = gameDAO.store(related_gamesforhometeamfk);
			gameDAO.flush();
		}

		related_gamesforhometeamfk.setTeamByVisitorTeamFk(team);
		team.getGamesForVisitorTeamFk().add(related_gamesforhometeamfk);
		related_gamesforhometeamfk = gameDAO.store(related_gamesforhometeamfk);
		gameDAO.flush();

		team = teamDAO.store(team);
		teamDAO.flush();

		return team;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Team saveTeamProgram(Integer teamId, Program related_program) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
		Program existingprogram = programDAO.findProgramByPrimaryKey(related_program.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprogram != null) {
			existingprogram.setProgramId(related_program.getProgramId());
			existingprogram.setProgramName(related_program.getProgramName());
			existingprogram.setPrice(related_program.getPrice());
			existingprogram.setStartDate(related_program.getStartDate());
			existingprogram.setEndDate(related_program.getEndDate());
			existingprogram.setActiveYn(related_program.getActiveYn());
			existingprogram.setPublishYn(related_program.getPublishYn());
			existingprogram.setTotalPaid(related_program.getTotalPaid());
			existingprogram.setTotalParticipants(related_program.getTotalParticipants());
			existingprogram.setGamesPerTeam(related_program.getGamesPerTeam());
			existingprogram.setLeagueYn(related_program.getLeagueYn());
			related_program = existingprogram;
		}

		team.setProgram(related_program);
		related_program.getTeams().add(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		return team;
	}

	/**
	 * Return a count of all Team entity
	 * 
	 */
	@Transactional
	public Integer countTeams() {
		return ((Long) teamDAO.createQuerySingleResult("select count(o) from Team o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Team saveTeamGamesForVisitorTeamFk(Integer teamId, Game related_gamesforvisitorteamfk) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
		Game existinggamesForVisitorTeamFk = gameDAO.findGameByPrimaryKey(related_gamesforvisitorteamfk.getGameId());

		// copy into the existing record to preserve existing relationships
		if (existinggamesForVisitorTeamFk != null) {
			existinggamesForVisitorTeamFk.setGameId(related_gamesforvisitorteamfk.getGameId());
			existinggamesForVisitorTeamFk.setGameDate(related_gamesforvisitorteamfk.getGameDate());
			existinggamesForVisitorTeamFk.setHomeScore(related_gamesforvisitorteamfk.getHomeScore());
			existinggamesForVisitorTeamFk.setVisitorScore(related_gamesforvisitorteamfk.getVisitorScore());
			existinggamesForVisitorTeamFk.setActiveYn(related_gamesforvisitorteamfk.getActiveYn());
			related_gamesforvisitorteamfk = existinggamesForVisitorTeamFk;
		} else {
			related_gamesforvisitorteamfk = gameDAO.store(related_gamesforvisitorteamfk);
			gameDAO.flush();
		}

		related_gamesforvisitorteamfk.setTeamByVisitorTeamFk(team);
		team.getGamesForVisitorTeamFk().add(related_gamesforvisitorteamfk);
		related_gamesforvisitorteamfk = gameDAO.store(related_gamesforvisitorteamfk);
		gameDAO.flush();

		team = teamDAO.store(team);
		teamDAO.flush();

		return team;
	}

	/**
	 * Save an existing Level entity
	 * 
	 */
	@Transactional
	public Team saveTeamLevel(Integer teamId, Level related_level) {
		Team team = teamDAO.findTeamByPrimaryKey(teamId, -1, defaultMaxRows);
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

		team.setLevel(related_level);
		related_level.getTeams().add(team);
		team = teamDAO.store(team);
		teamDAO.flush();

		related_level = levelDAO.store(related_level);
		levelDAO.flush();

		return team;
	}

	@Override
	public Team updateTeamplayerCounts(Team team) {
		Set<Teamplayers> tmplyrs  = team.getTeamplayerses();
		if(tmplyrs.size()>0){
			MathContext mc = new MathContext(8);
			BigDecimal amtPaid = new BigDecimal("0.00",mc);
			Iterator<Teamplayers> tmplyrIter = tmplyrs.iterator();
			while(tmplyrIter.hasNext()){
				Teamplayers tmplyr = tmplyrIter.next();
				amtPaid = amtPaid.add(tmplyr.getAmtPaid(),mc);
			}
			team.setAmtPaid(amtPaid);
		}
		return team;
	}
}
