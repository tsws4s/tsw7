package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.GamestatsDAO;
import tsw.dao.LevelDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.TeamDAO;
import tsw.dao.TeamplayersDAO;
import tsw.dao.TswacctDAO;

import tsw.domain.Customer;
import tsw.domain.Gamestats;
import tsw.domain.Level;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Teamplayers entities
 * 
 */

@Service("TeamplayersService")
@Transactional
public class TeamplayersServiceImpl implements TeamplayersService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages Customer entities
	 * 
	 */
	@Autowired
	private CustomerDAO customerDAO;

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
	/**
	 * DAO injected by Spring that manages Gamestats entities
	 * 
	 */
	@Autowired
	private GamestatsDAO gamestatsDAO;
	
	/**
	 * Instantiates a new TeamplayersServiceImpl.
	 *
	 */
	public TeamplayersServiceImpl() {
	}

	/**
	 * Return all Teamplayers entity
	 * 
	 */
	@Transactional
	public List<Teamplayers> findAllTeamplayerss4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Teamplayers>(teamplayersDAO.findAllTeamplayerss4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId) {
		return teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersId);
	}

	/**
	 * Return a count of all Teamplayers entity
	 * 
	 */
	@Transactional
	public Integer countTeamplayerss() {
		return ((Long) teamplayersDAO.createQuerySingleResult("select count(o) from Teamplayers o").getSingleResult()).intValue();
	}
	/**
	 * Save an existing Gamestats entity
	 * 
	 */
	@Transactional
	public Teamplayers saveTeamplayersGamestatses(Integer teamPlayersId, Gamestats related_gamestatses) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersId, -1, -1);
		Gamestats existinggamestatses = gamestatsDAO.findGamestatsByPrimaryKey(related_gamestatses.getGameStatsId());

		// copy into the existing record to preserve existing relationships
		if (existinggamestatses != null) {
			existinggamestatses.setGameStatsId(related_gamestatses.getGameStatsId());
			existinggamestatses.setGameStatValue(related_gamestatses.getGameStatValue());
			existinggamestatses.setGameStatTime(related_gamestatses.getGameStatTime());
			related_gamestatses = existinggamestatses;
		} else {
			related_gamestatses = gamestatsDAO.store(related_gamestatses);
			gamestatsDAO.flush();
		}

		related_gamestatses.setTeamplayers(teamplayers);
		teamplayers.getGamestatses().add(related_gamestatses);
		related_gamestatses = gamestatsDAO.store(related_gamestatses);
		gamestatsDAO.flush();

		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		return teamplayers;
	}


	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Teamplayers saveTeamplayersCustomer(Integer teamPlayersId, Customer related_customer) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersId, -1, defaultMaxRows);
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

		teamplayers.setCustomer(related_customer);
		related_customer.getTeamplayerses().add(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return teamplayers;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Teamplayers deleteTeamplayersTeam(Integer teamplayers_teamPlayersId, Integer related_team_teamId) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, defaultMaxRows);
		Team related_team = teamDAO.findTeamByPrimaryKey(related_team_teamId, -1, defaultMaxRows);

		teamplayers.setTeam(null);
		related_team.getTeamplayerses().remove(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_team = teamDAO.store(related_team);
		teamDAO.flush();

		teamDAO.remove(related_team);
		teamDAO.flush();

		return teamplayers;
	}
	/**
	 * Delete an existing Gamestats entity
	 * 
	 */
	@Transactional
	public Teamplayers deleteTeamplayersGamestatses(Integer teamplayers_teamPlayersId, Integer related_gamestatses_gameStatsId) {
		Gamestats related_gamestatses = gamestatsDAO.findGamestatsByPrimaryKey(related_gamestatses_gameStatsId, -1, -1);

		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, -1);

		related_gamestatses.setTeamplayers(null);
		teamplayers.getGamestatses().remove(related_gamestatses);

		gamestatsDAO.remove(related_gamestatses);
		gamestatsDAO.flush();

		return teamplayers;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public void saveTeamplayers(Tswacct tswacct, Teamplayers teamplayers) {
		Teamplayers existingTeamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers.getTeamPlayersId());

		if (existingTeamplayers != null) {
			if (existingTeamplayers != teamplayers) {
				existingTeamplayers.setTeamPlayersId(teamplayers.getTeamPlayersId());
				existingTeamplayers.setAmtPaid(teamplayers.getAmtPaid());
				existingTeamplayers.setNotes(teamplayers.getNotes());
				existingTeamplayers.setGroup2(teamplayers.getGroup2());
				existingTeamplayers.setSignedWaiverYn(teamplayers.getSignedWaiverYn());
				existingTeamplayers.setActiveYn(teamplayers.getActiveYn());
			}
			teamplayers = teamplayersDAO.store(existingTeamplayers);
		} else {
			int tmPlayerId = teamplayersDAO.getMaxTeamplayersID();
			teamplayers.setTeamPlayersId(tmPlayerId+1);
			teamplayers.setTswacct(tswacct);	
			teamplayers = teamplayersDAO.store(teamplayers);
		}
		teamplayersDAO.flush();
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Teamplayers saveTeamplayersTeam(Integer teamPlayersId, Team related_team) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersId, -1, defaultMaxRows);
		Team existingteam = teamDAO.findTeamByPrimaryKey(related_team.getTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingteam != null) {
			existingteam.setTeamId(related_team.getTeamId());
			existingteam.setTeamName(related_team.getTeamName());
			existingteam.setAmtPaid(related_team.getAmtPaid());
			existingteam.setWins(related_team.getWins());
			existingteam.setLosses(related_team.getLosses());
			existingteam.setTies(related_team.getTies());
			existingteam.setGroup3(related_team.getGroup3());
			existingteam.setColor(related_team.getColor());
			existingteam.setPublishYn(related_team.getPublishYn());
			existingteam.setActiveYn(related_team.getActiveYn());
			existingteam.setNotes(related_team.getNotes());
			related_team = existingteam;
		} else {
			related_team = teamDAO.store(related_team);
			teamDAO.flush();
		}

		teamplayers.setTeam(related_team);
		related_team.getTeamplayerses().add(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_team = teamDAO.store(related_team);
		teamDAO.flush();

		return teamplayers;
	}

	/**
	 * Load an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Set<Teamplayers> loadTeamplayerss4tsw(Tswacct tswacct) {
		return teamplayersDAO.findAllTeamplayerss4tsw(tswacct.getTswAcctId());
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Teamplayers saveTeamplayersProgram(Integer teamPlayersId, Program related_program) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersId, -1, defaultMaxRows);
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
		} else {
			related_program = programDAO.store(related_program);
			programDAO.flush();
		}

		teamplayers.setProgram(related_program);
		related_program.getTeamplayerses().add(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		return teamplayers;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Teamplayers deleteTeamplayersCustomer(Integer teamplayers_teamPlayersId, Integer related_customer_customerId) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, defaultMaxRows);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, defaultMaxRows);

		teamplayers.setCustomer(null);
		related_customer.getTeamplayerses().remove(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		customerDAO.remove(related_customer);
		customerDAO.flush();

		return teamplayers;
	}

	/**
	 * Save an existing Level entity
	 * 
	 */
	@Transactional
	public Teamplayers saveTeamplayersLevel(Integer teamPlayersId, Level related_level) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersId, -1, defaultMaxRows);
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

		teamplayers.setLevel(related_level);
		related_level.getTeamplayerses().add(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_level = levelDAO.store(related_level);
		levelDAO.flush();

		return teamplayers;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Teamplayers deleteTeamplayersTswacct(Integer teamplayers_teamPlayersId, Integer related_tswacct_tswAcctId) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		teamplayers.setTswacct(null);
		related_tswacct.getTeamplayerses().remove(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return teamplayers;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Teamplayers deleteTeamplayersProgram(Integer teamplayers_teamPlayersId, Integer related_program_programId) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, defaultMaxRows);
		Program related_program = programDAO.findProgramByPrimaryKey(related_program_programId, -1, defaultMaxRows);

		teamplayers.setProgram(null);
		related_program.getTeamplayerses().remove(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		programDAO.remove(related_program);
		programDAO.flush();

		return teamplayers;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public void deleteTeamplayers(Teamplayers teamplayers) {
		teamplayersDAO.remove(teamplayers);
		teamplayersDAO.flush();
	}

	/**
	 * Delete an existing Level entity
	 * 
	 */
	@Transactional
	public Teamplayers deleteTeamplayersLevel(Integer teamplayers_teamPlayersId, Integer related_level_levelId) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamplayers_teamPlayersId, -1, defaultMaxRows);
		Level related_level = levelDAO.findLevelByPrimaryKey(related_level_levelId, -1, defaultMaxRows);

		teamplayers.setLevel(null);
		related_level.getTeamplayerses().remove(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_level = levelDAO.store(related_level);
		levelDAO.flush();

		levelDAO.remove(related_level);
		levelDAO.flush();

		return teamplayers;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Teamplayers saveTeamplayersTswacct(Integer teamPlayersId, Tswacct related_tswacct) {
		Teamplayers teamplayers = teamplayersDAO.findTeamplayersByPrimaryKey(teamPlayersId, -1, defaultMaxRows);
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

		teamplayers.setTswacct(related_tswacct);
		related_tswacct.getTeamplayerses().add(teamplayers);
		teamplayers = teamplayersDAO.store(teamplayers);
		teamplayersDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return teamplayers;
	}
}
