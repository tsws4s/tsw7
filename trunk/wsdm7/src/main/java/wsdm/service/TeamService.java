package wsdm.service;

import java.util.List;
import java.util.Set;

import wsdm.domain.Customer;
import wsdm.domain.Game;
import wsdm.domain.Level;
import wsdm.domain.Program;
import wsdm.domain.Team;
import wsdm.domain.Teamplayers;
import wsdm.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Team entities
 * 
 */
public interface TeamService {

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Team saveTeamCustomerByCoachCustFk(Integer teamId, Customer related_customerbycoachcustfk);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Team saveTeamProgram(Integer teamId_1, Program related_program);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Team deleteTeamCustomerByCoachCustFk(Integer team_teamId, Integer related_customerbycoachcustfk_customerId);

	/**
	 */
	public Team findTeamByPrimaryKey(Integer teamId_2);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Team saveTeamTswacct(Integer teamId_3, Tswacct related_tswacct);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public void saveTeam(Team team);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Team saveTeamGamesForVisitorTeamFk(Integer teamId_4, Game related_gamesforvisitorteamfk);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Team deleteTeamGamesForVisitorTeamFk(Integer team_teamId_1, Integer related_gamesforvisitorteamfk_gameId);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Team saveTeamGamesForHomeTeamFk(Integer teamId_5, Game related_gamesforhometeamfk);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Team saveTeamCustomerByManagerCustFk(Integer teamId_6, Customer related_customerbymanagercustfk);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Team deleteTeamCustomerByManagerCustFk(Integer team_teamId_2, Integer related_customerbymanagercustfk_customerId);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Team deleteTeamProgram(Integer team_teamId_3, Integer related_program_programId);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public void deleteTeam(Team team_1);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Team deleteTeamGamesForHomeTeamFk(Integer team_teamId_4, Integer related_gamesforhometeamfk_gameId);

	/**
	 * Return a count of all Team entity
	 * 
	 */
	public Integer countTeams();

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Team saveTeamTeamplayerses(Integer teamId_7, Teamplayers related_teamplayerses);

	/**
	 * Save an existing Level entity
	 * 
	 */
	public Team saveTeamLevel(Integer teamId_8, Level related_level);

	/**
	 * Return all Team entity
	 * 
	 */
	public List<Team> findAllTeams(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Team deleteTeamTeamplayerses(Integer team_teamId_5, Integer related_teamplayerses_teamPlayersId);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Team deleteTeamTswacct(Integer team_teamId_6, Integer related_tswacct_tswAcctId);

	/**
	 * Load an existing Team entity
	 * 
	 */
	public Set<Team> loadTeams();

	/**
	 * Delete an existing Level entity
	 * 
	 */
	public Team deleteTeamLevel(Integer team_teamId_7, Integer related_level_levelId);
}