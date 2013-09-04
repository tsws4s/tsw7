package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.GameDAO;
import tsw.dao.ParticipantDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.TeamDAO;
import tsw.dao.TeamplayersDAO;
import tsw.dao.TswacctDAO;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Participant;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Customer entities
 * 
 */

@Service("CustomerService")
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
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
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerGames(Integer customer_customerId, Integer related_games_gameId) {
		Game related_games = gameDAO.findGameByPrimaryKey(related_games_gameId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		related_games.setCustomer(null);
		customer.getGames().remove(related_games);

		gameDAO.remove(related_games);
		gameDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTeamplayerses(Integer customerId, Teamplayers related_teamplayerses) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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

		related_teamplayerses.setCustomer(customer);
		customer.getTeamplayerses().add(related_teamplayerses);
		related_teamplayerses = teamplayersDAO.store(related_teamplayerses);
		teamplayersDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerPrograms(Integer customer_customerId, Integer related_programs_programId) {
		Program related_programs = programDAO.findProgramByPrimaryKey(related_programs_programId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		related_programs.setCustomer(null);
		customer.getPrograms().remove(related_programs);

		programDAO.remove(related_programs);
		programDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerGames(Integer customerId, Game related_games) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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

		related_games.setCustomer(customer);
		customer.getGames().add(related_games);
		related_games = gameDAO.store(related_games);
		gameDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTeamsForManagerCustFk(Integer customerId, Team related_teamsformanagercustfk) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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
	 */
	@Transactional
	public Customer findCustomerByPrimaryKey(Integer customerId) {
		return customerDAO.findCustomerByPrimaryKey(customerId);
	}

	@Transactional
	public Customer findCustomerByEmailAddr(String email) {
		return customerDAO.findCustomerByEmailAddr(email);
	}
	@Transactional
	public Customer findCustomerByName(Tswacct tswacct, String fname, String lname) {
		return customerDAO.findCustomerByName(tswacct, fname, lname);
	}
	
	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTswaccts(Integer customerId, Tswacct related_tswaccts) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTeamsForCoachCustFk(Integer customer_customerId, Integer related_teamsforcoachcustfk_teamId) {
		Team related_teamsforcoachcustfk = teamDAO.findTeamByPrimaryKey(related_teamsforcoachcustfk_teamId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		related_teamsforcoachcustfk.setCustomerByManagerCustFk(null);
		customer.getTeamsForManagerCustFk().remove(related_teamsforcoachcustfk);

		teamDAO.remove(related_teamsforcoachcustfk);
		teamDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTswaccts(Integer customer_customerId, Integer related_tswaccts_tswAcctId) {
		Tswacct related_tswaccts = tswacctDAO.findTswacctByPrimaryKey(related_tswaccts_tswAcctId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		related_tswaccts.setCustomer(null);
		customer.getTswaccts().remove(related_tswaccts);

		tswacctDAO.remove(related_tswaccts);
		tswacctDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Participant entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerParticipants(Integer customerId, Participant related_participants) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerCustomers(Integer customerId, Customer related_customers) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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

		customer.setCustomer(related_customers);
		related_customers.getCustomers().add(customer);
		customer = customerDAO.store(customer);
		customerDAO.flush();

		related_customers = customerDAO.store(related_customers);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTswacct(Integer customer_customerId, Integer related_tswacct_tswAcctId) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

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
	public Customer saveCustomer(Customer customer, Integer custId, Tswacct tswacct) {
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
				existingCustomer.setSelectTheme(customer.getSelectTheme());
				existingCustomer.setActiveYn(customer.getActiveYn());
				existingCustomer.setPassword(customer.getPassword());
				if(custId==null && existingCustomer.getCustomer()!=null){
					existingCustomer.setCustomer(null);
				}
				if(custId!=null && custId==-1 && existingCustomer.getCustomer()!=null){
					custId = existingCustomer.getCustomer().getCustomerId();
				}
			}
			customer = customerDAO.store(existingCustomer);
		} else {
			int customerId = customerDAO.getMaxCustomerID();
			customer.setCustomerId(customerId+1);
			customer.setTswacct(tswacct);
			customer = customerDAO.store(customer);
		}
		if(custId!=null && custId>0){
			customer.setCustomer(customerDAO.findCustomerByPrimaryKey(custId));
		}
			
		customerDAO.flush();
		
		return customer;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerCustomer(Integer customerId, Customer related_customer) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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

		customer.setCustomer(related_customer);
		related_customer.getCustomers().add(customer);
		customer = customerDAO.store(customer);
		customerDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerPrograms(Integer customerId, Program related_programs) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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

		related_programs.setCustomer(customer);
		customer.getPrograms().add(related_programs);
		related_programs = programDAO.store(related_programs);
		programDAO.flush();

		customer = customerDAO.store(customer);
		customerDAO.flush();

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
	 * Return all Customer entity
	 * 
	 */
	@Transactional
	public List<Customer> findAllCustomers4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Customer>(customerDAO.findAllCustomers4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}


	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTeamsForCoachCustFk(Integer customerId, Team related_teamsforcoachcustfk) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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
		Customer related_customers = customerDAO.findCustomerByPrimaryKey(related_customers_customerId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		customer.setCustomer(null);
		related_customers.getCustomers().remove(customer);

		customerDAO.remove(related_customers);
		customerDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTeamplayerses(Integer customer_customerId, Integer related_teamplayerses_teamPlayersId) {
		Teamplayers related_teamplayerses = teamplayersDAO.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		related_teamplayerses.setCustomer(null);
		customer.getTeamplayerses().remove(related_teamplayerses);

		teamplayersDAO.remove(related_teamplayerses);
		teamplayersDAO.flush();

		return customer;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerTeamsForManagerCustFk(Integer customer_customerId, Integer related_teamsformanagercustfk_teamId) {
		Team related_teamsformanagercustfk = teamDAO.findTeamByPrimaryKey(related_teamsformanagercustfk_teamId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		related_teamsformanagercustfk.setCustomerByManagerCustFk(null);
		customer.getTeamsForManagerCustFk().remove(related_teamsformanagercustfk);

		teamDAO.remove(related_teamsformanagercustfk);
		teamDAO.flush();

		return customer;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Customer saveCustomerTswacct(Integer customerId, Tswacct related_tswacct) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customerId, -1, defaultMaxRows);
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
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerCustomer(Integer customer_customerId, Integer related_customer_customerId) {
		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, defaultMaxRows);

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
	 * Return a count of all Customer entity
	 * 
	 */
	@Transactional
	public Integer getCustomerCount4tsw(Tswacct tswacct) {
	
		int tswId = tswacct.getTswAcctId();
		return ((Long) customerDAO.createQuerySingleResult("select count(customerId) from Customer o where tswAcctFk = '"+tswId+"'").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	@Transactional
	public Customer deleteCustomerParticipants(Integer customer_customerId, Integer related_participants_participantId) {
		Participant related_participants = participantDAO.findParticipantByPrimaryKey(related_participants_participantId, -1, defaultMaxRows);

		Customer customer = customerDAO.findCustomerByPrimaryKey(customer_customerId, -1, defaultMaxRows);

		related_participants.setCustomer(null);
		customer.getParticipants().remove(related_participants);

		participantDAO.remove(related_participants);
		participantDAO.flush();

		return customer;
	}

	/**
	 * Load an existing Customer entity
	 * 
	 */
	@Transactional
	public Set<Customer> loadCustomers4tsw(Tswacct tswacct) {
		return customerDAO.findAllCustomers4tsw(tswacct.getTswAcctId());
	}
	// Pagination
	@Transactional
	public Set<Customer> loadCustomers4tsw(Tswacct tswacct, int from, int resultsPerPage) {

		return customerDAO.findAllCustomers4tsw(tswacct.getTswAcctId(), from,resultsPerPage);
	}

	@Override
	public Integer countCustomers() {
		// DO Auto-generated method stub
		return null;
	}

}
