package wsdm.service;

import java.util.List;
import java.util.Set;

import wsdm.domain.Customer;
import wsdm.domain.Event;
import wsdm.domain.Participant;
import wsdm.domain.Program;
import wsdm.domain.Team;
import wsdm.domain.Teamplayers;
import wsdm.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Customer entities
 * 
 */
public interface CustomerService {

	/**
	 * Save an existing Participant entity
	 * 
	 */
	public Customer saveCustomerParticipants(Integer customerId, Participant related_participants);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Customer deleteCustomerTswacct(Integer customer_customerId, Integer related_tswacct_tswAcctId);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Customer saveCustomerCustomers(Integer customerId_1, Customer related_customers);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Customer saveCustomerTeamsForCoachCustFk(Integer customerId_2, Team related_teamsforcoachcustfk);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Customer deleteCustomerCustomers(Integer customer_customerId_1, Integer related_customers_customerId);

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	public Customer saveCustomerTeamplayerses(Integer customerId_3, Teamplayers related_teamplayerses);

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	public Customer deleteCustomerTeamplayerses(Integer customer_customerId_2, Integer related_teamplayerses_teamPlayersId);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Customer deleteCustomerTswaccts(Integer customer_customerId_3, Integer related_tswaccts_tswAcctId);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Customer deleteCustomerTeamsForCoachCustFk(Integer customer_customerId_4, Integer related_teamsforcoachcustfk_teamId);

	/**
	 * Load an existing Customer entity
	 * 
	 */
	public Set<Customer> loadCustomers();

	/**
	 * Delete an existing Event entity
	 * 
	 */
	public Customer deleteCustomerEvents(Integer customer_customerId_5, Integer related_events_eventId);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public void deleteCustomer(Customer customer);

	/**
	 */
	public Customer findCustomerByPrimaryKey(Integer customerId_4);

	/**
	 * Delete an existing Team entity
	 * 
	 */
	public Customer deleteCustomerTeamsForManagerCustFk(Integer customer_customerId_6, Integer related_teamsformanagercustfk_teamId);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public void saveCustomer(Customer customer_1);

	/**
	 * Save an existing Team entity
	 * 
	 */
	public Customer saveCustomerTeamsForManagerCustFk(Integer customerId_5, Team related_teamsformanagercustfk);

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	public Customer deleteCustomerParticipants(Integer customer_customerId_7, Integer related_participants_participantId);

	/**
	 * Save an existing Customer entity
	 * 
	 */
	public Customer saveCustomerCustomer(Integer customerId_6, Customer related_customer);

	/**
	 * Return a count of all Customer entity
	 * 
	 */
	public Integer countCustomers();

	/**
	 * Save an existing Program entity
	 * 
	 */
	public Customer saveCustomerPrograms(Integer customerId_7, Program related_programs);

	/**
	 * Save an existing Event entity
	 * 
	 */
	public Customer saveCustomerEvents(Integer customerId_8, Event related_events);

	/**
	 * Return all Customer entity
	 * 
	 */
	public List<Customer> findAllCustomers(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Customer saveCustomerTswaccts(Integer customerId_9, Tswacct related_tswaccts);

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	public Customer deleteCustomerCustomer(Integer customer_customerId_8, Integer related_customer_customerId);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Customer saveCustomerTswacct(Integer customerId_10, Tswacct related_tswacct);

	/**
	 * Delete an existing Program entity
	 * 
	 */
	public Customer deleteCustomerPrograms(Integer customer_customerId_9, Integer related_programs_programId);
}