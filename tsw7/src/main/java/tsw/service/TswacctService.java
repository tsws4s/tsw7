package tsw.service;

import java.util.List;
import java.util.Set;

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

/**
 * Spring service that handles CRUD requests for Tswacct entities
 * 
 */
public interface TswacctService {

	/**
	 */
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId);

	public Integer getTswacctCount();
	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Tswacct deleteTswacctCustomers(Integer tswacct_tswAcctId, Integer related_customers_customerId);

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Tswacct deleteTswacctGames(Integer tswacct_tswAcctId_1, Integer related_games_gameId);

	/**
	 * Save an existing Participant entity
	 * 
	 */
	public Tswacct saveTswacctParticipants(Integer tswAcctId_1, Participant related_participants);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Tswacct deleteTswacctTeamplayerses(Integer tswacct_tswAcctId_2, Integer related_teamplayerses_teamPlayersId);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Tswacct saveTswacctCustomer(Integer tswAcctId_3, Customer related_customer);

	/**
	 * Save an existing Resource entity
	 * 
	 */
	public Tswacct saveTswacctResources(Integer tswAcctId_4, Resource related_resources);

	/**
	 * Delete an existing Level entity
	 * 
	 */
	public Tswacct deleteTswacctLevels(Integer tswacct_tswAcctId_3, Integer related_levels_levelId);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Tswacct deleteTswacctPrograms(Integer tswacct_tswAcctId_4, Integer related_programs_programId);

	/**
	 * Return a count of all Tswacct entity
	 * 
	 */
	public Integer countTswaccts();

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public void saveTswacct(Tswacct tswacct, Integer selected_id4);

	/**
	 * Load an existing Tswacct entity
	 * 
	 */
	public Set<Tswacct> loadTswaccts();
	public Set<Tswacct> loadTswaccts(int from);

	/**
	 * Delete an existing Resource entity
	 * 
	 */
	public Tswacct deleteTswacctResources(Integer tswacct_tswAcctId_5, Integer related_resources_resourceId);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Tswacct saveTswacctCustomers(Integer tswAcctId_5, Customer related_customers);

	/**
	 * Delete an existing Users entity
	 * 
	 */
	public Tswacct deleteTswacctUserses(Integer tswacct_tswAcctId_6, Integer related_userses_userId);

	/**
	 * Save an existing Users entity
	 * 
	 */
	public Tswacct saveTswacctUserses(Integer tswAcctId_6, Users related_userses);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Tswacct saveTswacctTeamplayerses(Integer tswAcctId_8, Teamplayers related_teamplayerses);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Tswacct deleteTswacctCustomer(Integer tswacct_tswAcctId_8, Integer related_customer_customerId);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public void deleteTswacct(Tswacct tswacct_1);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Tswacct deleteTswacctTeams(Integer tswacct_tswAcctId_9, Integer related_teams_teamId);

	/**
	 * Save an existing Level entity
	 * 
	 */
	public Tswacct saveTswacctLevels(Integer tswAcctId_9, Level related_levels);

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	public Tswacct deleteTswacctParticipants(Integer tswacct_tswAcctId_10, Integer related_participants_participantId);

	/**
	 * Return all Tswacct entity
	 * 
	 */
	public List<Tswacct> findAllTswaccts(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Tswacct saveTswacctTeams(Integer tswAcctId_10, Team related_teams);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Tswacct saveTswacctGames(Integer tswAcctId_11, Game related_games);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Tswacct saveTswacctPrograms(Integer tswAcctId_12, Program related_programs);
}