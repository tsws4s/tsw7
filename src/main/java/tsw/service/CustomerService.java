package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Participant;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Customer entities
 * 
 */
public interface CustomerService {

	/**
	 * Delete an existing Game entity
	 * 
	 */
	public Customer deleteCustomerGames(Integer customer_customerId, Integer related_games_gameId);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Customer saveCustomerTeamplayerses(Integer customerId, Teamplayers related_teamplayerses);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Customer deleteCustomerPrograms(Integer customer_customerId_2, Integer related_programs_programId);

	/**
	 * Save an existing Game entity
	 * 
	 */
	public Customer saveCustomerGames(Integer customerId_2, Game related_games);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Customer saveCustomerTeamsForManagerCustFk(Integer customerId_3, Team related_teamsformanagercustfk);

	/**
	 */
	public Customer findCustomerByPrimaryKey(Integer customerId_4);
	public Customer findCustomerByEmailAddr(String email);
	
	public Customer findCustomerByName(Tswacct tswacct, String fname, String lname);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Customer saveCustomerTswaccts(Integer customerId_5, Tswacct related_tswaccts);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Customer deleteCustomerTeamsForCoachCustFk(Integer customer_customerId_4, Integer related_teamsforcoachcustfk_teamId);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Customer deleteCustomerTswaccts(Integer customer_customerId_5, Integer related_tswaccts_tswAcctId);

	/**
	 * Save an existing Participant entity
	 * 
	 */
	public Customer saveCustomerParticipants(Integer customerId_6, Participant related_participants);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Customer saveCustomerCustomers(Integer customerId_7, Customer related_customers);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Customer deleteCustomerTswacct(Integer customer_customerId_6, Integer related_tswacct_tswAcctId);

	/**
	 * Save an existing Customer entity
	 * @param selected_id4 
	 * 
	 */
	public Customer saveCustomer(Customer customer, Integer selected_id4, Tswacct tswacct);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Customer saveCustomerCustomer(Integer customerId_8, Customer related_customer);

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Customer saveCustomerPrograms(Integer customerId_10, Program related_programs);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public void deleteCustomer(Customer customer_1);

	/**
	 * Return all Customer entity
	 * 
	 */
	public List<Customer> findAllCustomers4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Customer saveCustomerTeamsForCoachCustFk(Integer customerId_12, Team related_teamsforcoachcustfk);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Customer deleteCustomerCustomers(Integer customer_customerId_10, Integer related_customers_customerId);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Customer deleteCustomerTeamplayerses(Integer customer_customerId_11, Integer related_teamplayerses_teamPlayersId);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Customer deleteCustomerTeamsForManagerCustFk(Integer customer_customerId_12, Integer related_teamsformanagercustfk_teamId);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Customer saveCustomerTswacct(Integer customerId_15, Tswacct related_tswacct);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Customer deleteCustomerCustomer(Integer customer_customerId_13, Integer related_customer_customerId);

	/**
	 * Return a count of all Customer entity
	 * 
	 */
	public Integer countCustomers();
	
	public Integer getCustomerCount4tsw(Tswacct tswacct);

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	public Customer deleteCustomerParticipants(Integer customer_customerId_14, Integer related_participants_participantId);

	/**
	 * Load an existing Customer entity
	 * 
	 */
	public Set<Customer> loadCustomers4tsw(Tswacct tswacct);
	public Set<Customer> loadCustomers4tsw(Tswacct tswacct, int from, int resultsPerPage);
}