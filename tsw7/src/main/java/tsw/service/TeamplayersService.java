package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Customer;
import tsw.domain.Gamestats;
import tsw.domain.Level;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Teamplayers entities
 * 
 */
public interface TeamplayersService {

	/**
	 * Return all Teamplayers entity
	 * 
	 */
	public List<Teamplayers> findAllTeamplayerss4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 */
	public Teamplayers findTeamplayersByPrimaryKey(Integer teamPlayersId);

	/**
	 * Return a count of all Teamplayers entity
	 * 
	 */
	public Integer countTeamplayerss();

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Teamplayers saveTeamplayersCustomer(Integer teamPlayersId_1, Customer related_customer);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Teamplayers deleteTeamplayersTeam(Integer teamplayers_teamPlayersId, Integer related_team_teamId);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public void saveTeamplayers(Tswacct tswacct, Teamplayers teamplayers);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Teamplayers saveTeamplayersTeam(Integer teamPlayersId_2, Team related_team);

	/**
	 * Load an existing Teamplayers entity
	 * 
	 */
	public Set<Teamplayers> loadTeamplayerss4tsw(Tswacct tswacct);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Teamplayers saveTeamplayersProgram(Integer teamPlayersId_3, Program related_program);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Teamplayers deleteTeamplayersCustomer(Integer teamplayers_teamPlayersId_1, Integer related_customer_customerId);

	/**
	 * Save an existing Level entity
	 * 
	 */
	public Teamplayers saveTeamplayersLevel(Integer teamPlayersId_4, Level related_level);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Teamplayers deleteTeamplayersTswacct(Integer teamplayers_teamPlayersId_2, Integer related_tswacct_tswAcctId);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Teamplayers deleteTeamplayersProgram(Integer teamplayers_teamPlayersId_3, Integer related_program_programId);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public void deleteTeamplayers(Teamplayers teamplayers_1);

	/**
	 * Delete an existing Level entity
	 * 
	 */
	public Teamplayers deleteTeamplayersLevel(Integer teamplayers_teamPlayersId_4, Integer related_level_levelId);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Teamplayers saveTeamplayersTswacct(Integer teamPlayersId_5, Tswacct related_tswacct);

	public Teamplayers saveTeamplayersGamestatses(Integer teamPlayersId, Gamestats related_gamestatses);

	public Teamplayers deleteTeamplayersGamestatses(Integer teamplayers_teamPlayersId_1, Integer related_gamestatses_gameStatsId);
}