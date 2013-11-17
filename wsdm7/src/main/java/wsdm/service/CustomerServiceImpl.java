package wsdm.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import wsdm.dao.CustomerDAO;
import wsdm.dao.EventDAO;
import wsdm.dao.ParticipantDAO;
import wsdm.dao.ProgramDAO;
import wsdm.dao.TeamDAO;
import wsdm.dao.TeamplayersDAO;
import wsdm.dao.TswacctDAO;

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

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {

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
	 * Instantiates a new CustomerServiceImpl.
	 *
	 */
	public CustomerServiceImpl() {
	}

	/**
	 * Save an existing Participant entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerParticipants(Integer customerId, Participant related_participants) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
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

		related_participants.setCustomer(customer);
		customer.getParticipants().add(related_participants);
		related_participants = participantDAO.store(related_participants);
		participantDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTswacct(Integer customer_customerId, Integer related_tswacct_tswAcctId) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, -1);

		customer.setTswacct(null);
		related_tswacct.getCustomers().remove(customer);
		customer = customerDAO.store(customer);
		customerDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerCustomers(Integer customerId, Customer related_customers) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
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
			existingcustomers.setAddrSameAsFamily(related_customers.getAddrSameAsFamily());
			existingcustomers.setActiveYn(related_customers.getActiveYn());
			existingcustomers.setPassword(related_customers.getPassword());
			existingcustomers.setSelectTheme(related_customers.getSelectTheme());
			existingcustomers.setAdminYn(related_customers.getAdminYn());
			related_customers = existingcustomers;
		} else {
			related_customers = customerDAO.store(related_customers);
			customerDAO.flush();
		}

		customer.setCustomer(related_customers);
		related_customers.getCustomers().add(customer);
		customer = customerDAO.store(customer);
		customerDAO.flush();

		related_customers = customerDAO.store(related_customers);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTeamsForCoachCustFk(Integer customerId, Team related_teamsforcoachcustfk) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
		Team existingteamsForCoachCustFk = teamDAO.findTeamByPrimaryKey(related_teamsforcoachcustfk.getTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingteamsForCoachCustFk != null) {
			existingteamsForCoachCustFk.setTeamId(related_teamsforcoachcustfk.getTeamId());
			existingteamsForCoachCustFk.setTeamName(related_teamsforcoachcustfk.getTeamName());
			existingteamsForCoachCustFk.setAmtPaid(related_teamsforcoachcustfk.getAmtPaid());
			existingteamsForCoachCustFk.setWins(related_teamsforcoachcustfk.getWins());
			existingteamsForCoachCustFk.setLosses(related_teamsforcoachcustfk.getLosses());
			existingteamsForCoachCustFk.setTies(related_teamsforcoachcustfk.getTies());
			existingteamsForCoachCustFk.setGroup3(related_teamsforcoachcustfk.getGroup3());
			existingteamsForCoachCustFk.setColor(related_teamsforcoachcustfk.getColor());
			existingteamsForCoachCustFk.setPublishYn(related_teamsforcoachcustfk.getPublishYn());
			existingteamsForCoachCustFk.setActiveYn(related_teamsforcoachcustfk.getActiveYn());
			existingteamsForCoachCustFk.setNotes(related_teamsforcoachcustfk.getNotes());
			related_teamsforcoachcustfk = existingteamsForCoachCustFk;
		} else {
			related_teamsforcoachcustfk = teamDAO.store(related_teamsforcoachcustfk);
			teamDAO.flush();
		}

		related_teamsforcoachcustfk.setCustomerByManagerCustFk(customer);
		customer.getTeamsForManagerCustFk().add(related_teamsforcoachcustfk);
		related_teamsforcoachcustfk = teamDAO.store(related_teamsforcoachcustfk);
		teamDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerCustomers(Integer customer_customerId, Integer related_customers_customerId) {
		Customer related_customers = customerDAO.findCustomerByPrimaryKey(related_customers_customerId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		customer.setCustomer(null);
		related_customers.getCustomers().remove(customer);

		customerDAO.remove(related_customers);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTeamplayerses(Integer customerId, Teamplayers related_teamplayerses) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
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

		related_teamplayerses.setCustomer(customer);
		customer.getTeamplayerses().add(related_teamplayerses);
		related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
		teamplayersDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTeamplayerses(Integer customer_customerId, Integer related_teamplayerses_teamPlayersId) {
		Teamplayers related_teamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		related_teamplayerses.setCustomer(null);
		customer.getTeamplayerses().remove(related_teamplayerses);

		teamplayersDAO.remove(related_teamplayerses);
		teamplayersDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTswaccts(Integer customer_customerId, Integer related_tswaccts_tswAcctId) {
		Tswacct related_tswaccts = tswacctDAO.findTswacctByPrimaryKey(related_tswaccts_tswAcctId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		related_tswaccts.setCustomer(null);
		customer.getTswaccts().remove(related_tswaccts);

		tswacctDAO.remove(related_tswaccts);
		tswacctDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTeamsForCoachCustFk(Integer customer_customerId, Integer related_teamsforcoachcustfk_teamId) {
		Team related_teamsforcoachcustfk = teamDAO.findTeamByPrimaryKey(related_teamsforcoachcustfk_teamId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		related_teamsforcoachcustfk.setCustomerByManagerCustFk(null);
		customer.getTeamsForManagerCustFk().remove(related_teamsforcoachcustfk);

		teamDAO.remove(related_teamsforcoachcustfk);
		teamDAO.flush();

		return customer;
	}

	/**
	 * Load an existing Customer entity
	 * 
	 */
	@Transactional
	public Set<Customer> loadCustomers() {
		return customerDAO.findAllCustomers();
	}

	/**
	 * Delete an existing Event entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerEvents(Integer customer_customerId, Integer related_events_eventId) {
		Event related_events = eventDAO.findEventByPrimaryKey(related_events_eventId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		related_events.setCustomer(null);
		customer.getEvents().remove(related_events);

		eventDAO.remove(related_events);
		eventDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDAO.remove(customer);
		customerDAO.flush();
	}

	/**
	 */
	@Transactional
	public Customer findCustomerByPrimaryKey(Integer customerId) {
		return customerDAO.findCustomerByPrimaryKey(customerId);
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTeamsForManagerCustFk(Integer customer_customerId, Integer related_teamsformanagercustfk_teamId) {
		Team related_teamsformanagercustfk = teamDAO.findTeamByPrimaryKey(related_teamsformanagercustfk_teamId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		related_teamsformanagercustfk.setCustomerByManagerCustFk(null);
		customer.getTeamsForManagerCustFk().remove(related_teamsformanagercustfk);

		teamDAO.remove(related_teamsformanagercustfk);
		teamDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public void saveCustomer(Customer customer) {
		Customer existingCustomer = customerDAO.findCustomerByPrimaryKey(customer.getCustomerId());

		if (existingCustomer != null) {
			if (existingCustomer != customer) {
				existingCustomer.setCustomerId(customer.getCustomerId());
				existingCustomer.setEmail(customer.getEmail());
				existingCustomer.setFirstname(customer.getFirstname());
				existingCustomer.setLastname(customer.getLastname());
				existingCustomer.setPhone(customer.getPhone());
				existingCustomer.setYearBorn(customer.getYearBorn());
				existingCustomer.setAddress(customer.getAddress());
				existingCustomer.setCity(customer.getCity());
				existingCustomer.setState(customer.getState());
				existingCustomer.setZipcode(customer.getZipcode());
				existingCustomer.setAddrSameAsFamily(customer.getAddrSameAsFamily());
				existingCustomer.setActiveYn(customer.getActiveYn());
				existingCustomer.setPassword(customer.getPassword());
				existingCustomer.setSelectTheme(customer.getSelectTheme());
				existingCustomer.setAdminYn(customer.getAdminYn());
			}
			customer = customerDAO.store(existingCustomer);
		} else {
			customer = customerDAO.store(customer);
		}
		customerDAO.flush();
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTeamsForManagerCustFk(Integer customerId, Team related_teamsformanagercustfk) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
		Team existingteamsForManagerCustFk = teamDAO.findTeamByPrimaryKey(related_teamsformanagercustfk.getTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingteamsForManagerCustFk != null) {
			existingteamsForManagerCustFk.setTeamId(related_teamsformanagercustfk.getTeamId());
			existingteamsForManagerCustFk.setTeamName(related_teamsformanagercustfk.getTeamName());
			existingteamsForManagerCustFk.setAmtPaid(related_teamsformanagercustfk.getAmtPaid());
			existingteamsForManagerCustFk.setWins(related_teamsformanagercustfk.getWins());
			existingteamsForManagerCustFk.setLosses(related_teamsformanagercustfk.getLosses());
			existingteamsForManagerCustFk.setTies(related_teamsformanagercustfk.getTies());
			existingteamsForManagerCustFk.setGroup3(related_teamsformanagercustfk.getGroup3());
			existingteamsForManagerCustFk.setColor(related_teamsformanagercustfk.getColor());
			existingteamsForManagerCustFk.setPublishYn(related_teamsformanagercustfk.getPublishYn());
			existingteamsForManagerCustFk.setActiveYn(related_teamsformanagercustfk.getActiveYn());
			existingteamsForManagerCustFk.setNotes(related_teamsformanagercustfk.getNotes());
			related_teamsformanagercustfk = existingteamsForManagerCustFk;
		} else {
			related_teamsformanagercustfk = teamDAO.store(related_teamsformanagercustfk);
			teamDAO.flush();
		}

		related_teamsformanagercustfk.setCustomerByManagerCustFk(customer);
		customer.getTeamsForManagerCustFk().add(related_teamsformanagercustfk);
		related_teamsformanagercustfk = teamDAO.store(related_teamsformanagercustfk);
		teamDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerParticipants(Integer customer_customerId, Integer related_participants_participantId) {
		Participant related_participants = participantDAO.findParticipantByPrimaryKey(related_participants_participantId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		related_participants.setCustomer(null);
		customer.getParticipants().remove(related_participants);

		participantDAO.remove(related_participants);
		participantDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerCustomer(Integer customerId, Customer related_customer) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
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

		customer.setCustomer(related_customer);
		related_customer.getCustomers().add(customer);
		customer = customerDAO.store(customer);
		customerDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Return a count of all Customer entity
	 * 
	 */
	@Transactional
	public Integer countCustomers() {
		return ((Long) customerDAO.createQuerySingleResult("select count(o) from Customer o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerPrograms(Integer customerId, Program related_programs) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
		Program existingprograms = programDAO.findProgramByPrimaryKey(related_programs.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprograms != null) {
			existingprograms.setProgramId(related_programs.getProgramId());
			existingprograms.setProgramName(related_programs.getProgramName());
			existingprograms.setStartDate(related_programs.getStartDate());
			existingprograms.setEndDate(related_programs.getEndDate());
			existingprograms.setLevelFk(related_programs.getLevelFk());
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

		related_programs.setCustomer(customer);
		customer.getPrograms().add(related_programs);
		related_programs = programDAO.store(related_programs);
		programDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Event entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerEvents(Integer customerId, Event related_events) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
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

		related_events.setCustomer(customer);
		customer.getEvents().add(related_events);
		related_events = eventDAO.store(related_events);
		eventDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Return all Customer entity
	 * 
	 */
	@Transactional
	public List<Customer> findAllCustomers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Customer>(customerDAO.findAllCustomers(startResult, maxRows));
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTswaccts(Integer customerId, Tswacct related_tswaccts) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
		Tswacct existingtswaccts = tswacctDAO.findTswacctByPrimaryKey(related_tswaccts.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswaccts != null) {
			existingtswaccts.setTswAcctId(related_tswaccts.getTswAcctId());
			existingtswaccts.setAcctName(related_tswaccts.getAcctName());
			existingtswaccts.setSubscrType(related_tswaccts.getSubscrType());
			existingtswaccts.setAmtPaid(related_tswaccts.getAmtPaid());
			existingtswaccts.setEstablishDate(related_tswaccts.getEstablishDate());
			existingtswaccts.setExpireDate(related_tswaccts.getExpireDate());
			existingtswaccts.setActiveYn(related_tswaccts.getActiveYn());
			related_tswaccts = existingtswaccts;
		} else {
			related_tswaccts = tswacctDAO.store(related_tswaccts);
			tswacctDAO.flush();
		}

		related_tswaccts.setCustomer(customer);
		customer.getTswaccts().add(related_tswaccts);
		related_tswaccts = tswacctDAO.store(related_tswaccts);
		tswacctDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerCustomer(Integer customer_customerId, Integer related_customer_customerId) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, -1);

		customer.setCustomer(null);
		related_customer.getCustomers().remove(customer);
		customer = customerDAO.store(customer);
		customerDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		customerDAO.remove(related_customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTswacct(Integer customerId, Tswacct related_tswacct) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, -1);
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

		customer.setTswacct(related_tswacct);
		related_tswacct.getCustomers().add(customer);
		customer = customerDAO.store(customer);
		customerDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerPrograms(Integer customer_customerId, Integer related_programs_programId) {
		Program related_programs = programDAO.findProgramByPrimaryKey(related_programs_programId, -1, -1);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, -1);

		related_programs.setCustomer(null);
		customer.getPrograms().remove(related_programs);

		programDAO.remove(related_programs);
		programDAO.flush();

		return customer;
	}
}
