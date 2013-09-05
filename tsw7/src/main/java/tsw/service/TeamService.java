package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Level;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Team entities
 * 
 */
public interface TeamService {

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Team saveTeamTswacct(Integer teamId, Tswacct related_tswacct);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Team saveTeamCustomerByCoachCustFk(Integer teamId_1, Customer related_customerbycoachcustfk);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Team deleteTeamTeamplayerses(Integer team_teamId, Integer related_teamplayerses_teamPlayersId);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Team saveTeamTeamplayerses(Tswacct tswacct, Integer teamId_2, Integer selected_id4, Integer selected_sportPosition_id1, Teamplayers related_teamplayerses);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Team deleteTeamGamesForHomeTeamFk(Integer team_teamId_1, Integer related_gamesforhometeamfk_gameId);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public void saveTeam(Team team);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Team deleteTeamCustomerByManagerCustFk(Integer team_teamId_2, Integer related_customerbymanagercustfk_customerId);

	/**
	 */
	public Team findTeamByPrimaryKey(Integer teamId_3);
	
	public Team findTeamByTeamName(Tswacct tswacct, Program pgm, String teamName);

	/**
	 * Delete an existing Level entity
	 * 
	 */
	public Team deleteTeamLevel(Integer team_teamId_3, Integer related_level_levelId);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Team deleteTeamTswacct(Integer team_teamId_4, Integer related_tswacct_tswAcctId);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Team saveTeamCustomerByManagerCustFk(Integer teamId_4, Customer related_customerbymanagercustfk);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Team deleteTeamCustomerByCoachCustFk(Integer team_teamId_5, Integer related_customerbycoachcustfk_customerId);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public void deleteTeam(Team team_1);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Team deleteTeamProgram(Integer team_teamId_6, Integer related_program_programId);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Team deleteTeamGamesForVisitorTeamFk(Integer team_teamId_7, Integer related_gamesforvisitorteamfk_gameId);

	/**
	 * Load an existing Team entity
	 * 
	 */
	public Set<Team> loadTeams4tsw(Tswacct tswacct);

	/**
	 * Return all Team entity
	 * 
	 */
	public List<Team> findAllTeams4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Team saveTeamGamesForHomeTeamFk(Integer teamId_5, Game related_gamesforhometeamfk);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Team saveTeamProgram(Integer teamId_6, Program related_program);

	/**
	 * Return a count of all Team entity
	 * 
	 */
	public Integer countTeams();

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Team saveTeamGamesForVisitorTeamFk(Integer teamId_7, Game related_gamesforvisitorteamfk);

	/**
	 * Save an existing Level entity
	 * 
	 */
	public Team saveTeamLevel(Integer teamId_8, Level related_level);

	public Team updateTeamplayerCounts(Team parent_team);
}