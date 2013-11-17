package wsdm.service;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

import wsdm.domain.Customer;
import wsdm.domain.Event;
import wsdm.domain.Participant;
import wsdm.domain.Program;
import wsdm.domain.Team;
import wsdm.domain.Teamplayers;
import wsdm.domain.Tswacct;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/main/resources/wsdm7-security-context.xml",
		"file:./src/main/resources/wsdm7-service-context.xml",
		"file:./src/main/resources/wsdm7-dao-context.xml",
		"file:./src/main/resources/wsdm7-web-context.xml" })
@Transactional
public class CustomerServiceTest {

	/**
	 * The Spring application context.
	 *
	 */
	@SuppressWarnings("unused")
	private ApplicationContext context;

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected CustomerService service;

	/**
	 * Instantiates a new CustomerServiceTest.
	 *
	 */
	public CustomerServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Participant entity
	 * 
	 */
	@Test
	public void saveCustomerParticipants() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerParticipants 
		Integer customerId = 0;
		Participant related_participants = new wsdm.domain.Participant();
		Customer response = null;
		response = service.saveCustomerParticipants(customerId, related_participants);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerParticipants
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteCustomerTswacct() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerTswacct 
		Integer customer_customerId = 0;
		Integer related_tswacct_tswAcctId = 0;
		Customer response = null;
		response = service.deleteCustomerTswacct(customer_customerId, related_tswacct_tswAcctId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerTswacct
	}

	/**
	 * Operation Unit Test
	 * Save an existing Customer entity
	 * 
	 */
	@Test
	public void saveCustomerCustomers() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerCustomers 
		Integer customerId_1 = 0;
		Customer related_customers = new wsdm.domain.Customer();
		Customer response = null;
		response = service.saveCustomerCustomers(customerId_1, related_customers);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerCustomers
	}

	/**
	 * Operation Unit Test
	 * Save an existing Team entity
	 * 
	 */
	@Test
	public void saveCustomerTeamsForCoachCustFk() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerTeamsForCoachCustFk 
		Integer customerId_2 = 0;
		Team related_teamsforcoachcustfk = new wsdm.domain.Team();
		Customer response = null;
		response = service.saveCustomerTeamsForCoachCustFk(customerId_2, related_teamsforcoachcustfk);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerTeamsForCoachCustFk
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Customer entity
	 * 
	 */
	@Test
	public void deleteCustomerCustomers() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerCustomers 
		Integer customer_customerId_1 = 0;
		Integer related_customers_customerId = 0;
		Customer response = null;
		response = service.deleteCustomerCustomers(customer_customerId_1, related_customers_customerId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerCustomers
	}

	/**
	 * Operation Unit Test
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Test
	public void saveCustomerTeamplayerses() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerTeamplayerses 
		Integer customerId_3 = 0;
		Teamplayers related_teamplayerses = new wsdm.domain.Teamplayers();
		Customer response = null;
		response = service.saveCustomerTeamplayerses(customerId_3, related_teamplayerses);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Test
	public void deleteCustomerTeamplayerses() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerTeamplayerses 
		Integer customer_customerId_2 = 0;
		Integer related_teamplayerses_teamPlayersId = 0;
		Customer response = null;
		response = service.deleteCustomerTeamplayerses(customer_customerId_2, related_teamplayerses_teamPlayersId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteCustomerTswaccts() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerTswaccts 
		Integer customer_customerId_3 = 0;
		Integer related_tswaccts_tswAcctId = 0;
		Customer response = null;
		response = service.deleteCustomerTswaccts(customer_customerId_3, related_tswaccts_tswAcctId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerTswaccts
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Team entity
	 * 
	 */
	@Test
	public void deleteCustomerTeamsForCoachCustFk() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerTeamsForCoachCustFk 
		Integer customer_customerId_4 = 0;
		Integer related_teamsforcoachcustfk_teamId = 0;
		Customer response = null;
		response = service.deleteCustomerTeamsForCoachCustFk(customer_customerId_4, related_teamsforcoachcustfk_teamId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerTeamsForCoachCustFk
	}

	/**
	 * Operation Unit Test
	 * Load an existing Customer entity
	 * 
	 */
	@Test
	public void loadCustomers() {
		Set<Customer> response = null;
		response = service.loadCustomers();
		// TODO: JUnit - Add assertions to test outputs of operation: loadCustomers
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Event entity
	 * 
	 */
	@Test
	public void deleteCustomerEvents() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerEvents 
		Integer customer_customerId_5 = 0;
		Integer related_events_eventId = 0;
		Customer response = null;
		response = service.deleteCustomerEvents(customer_customerId_5, related_events_eventId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerEvents
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Customer entity
	 * 
	 */
	@Test
	public void deleteCustomer() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomer 
		Customer customer = new wsdm.domain.Customer();
		service.deleteCustomer(customer);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findCustomerByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findCustomerByPrimaryKey 
		Integer customerId_4 = 0;
		Customer response = null;
		response = service.findCustomerByPrimaryKey(customerId_4);
		// TODO: JUnit - Add assertions to test outputs of operation: findCustomerByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Team entity
	 * 
	 */
	@Test
	public void deleteCustomerTeamsForManagerCustFk() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerTeamsForManagerCustFk 
		Integer customer_customerId_6 = 0;
		Integer related_teamsformanagercustfk_teamId = 0;
		Customer response = null;
		response = service.deleteCustomerTeamsForManagerCustFk(customer_customerId_6, related_teamsformanagercustfk_teamId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerTeamsForManagerCustFk
	}

	/**
	 * Operation Unit Test
	 * Save an existing Customer entity
	 * 
	 */
	@Test
	public void saveCustomer() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomer 
		Customer customer_1 = new wsdm.domain.Customer();
		service.saveCustomer(customer_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Team entity
	 * 
	 */
	@Test
	public void saveCustomerTeamsForManagerCustFk() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerTeamsForManagerCustFk 
		Integer customerId_5 = 0;
		Team related_teamsformanagercustfk = new wsdm.domain.Team();
		Customer response = null;
		response = service.saveCustomerTeamsForManagerCustFk(customerId_5, related_teamsformanagercustfk);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerTeamsForManagerCustFk
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Participant entity
	 * 
	 */
	@Test
	public void deleteCustomerParticipants() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerParticipants 
		Integer customer_customerId_7 = 0;
		Integer related_participants_participantId = 0;
		Customer response = null;
		response = service.deleteCustomerParticipants(customer_customerId_7, related_participants_participantId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerParticipants
	}

	/**
	 * Operation Unit Test
	 * Save an existing Customer entity
	 * 
	 */
	@Test
	public void saveCustomerCustomer() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerCustomer 
		Integer customerId_6 = 0;
		Customer related_customer = new wsdm.domain.Customer();
		Customer response = null;
		response = service.saveCustomerCustomer(customerId_6, related_customer);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerCustomer
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Customer entity
	 * 
	 */
	@Test
	public void countCustomers() {
		Integer response = null;
		response = service.countCustomers();
		// TODO: JUnit - Add assertions to test outputs of operation: countCustomers
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveCustomerPrograms() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerPrograms 
		Integer customerId_7 = 0;
		Program related_programs = new wsdm.domain.Program();
		Customer response = null;
		response = service.saveCustomerPrograms(customerId_7, related_programs);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerPrograms
	}

	/**
	 * Operation Unit Test
	 * Save an existing Event entity
	 * 
	 */
	@Test
	public void saveCustomerEvents() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerEvents 
		Integer customerId_8 = 0;
		Event related_events = new wsdm.domain.Event();
		Customer response = null;
		response = service.saveCustomerEvents(customerId_8, related_events);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerEvents
	}

	/**
	 * Operation Unit Test
	 * Return all Customer entity
	 * 
	 */
	@Test
	public void findAllCustomers() {
		// TODO: JUnit - Populate test inputs for operation: findAllCustomers 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Customer> response = null;
		response = service.findAllCustomers(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllCustomers
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveCustomerTswaccts() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerTswaccts 
		Integer customerId_9 = 0;
		Tswacct related_tswaccts = new wsdm.domain.Tswacct();
		Customer response = null;
		response = service.saveCustomerTswaccts(customerId_9, related_tswaccts);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerTswaccts
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Customer entity
	 * 
	 */
	@Test
	public void deleteCustomerCustomer() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerCustomer 
		Integer customer_customerId_8 = 0;
		Integer related_customer_customerId = 0;
		Customer response = null;
		response = service.deleteCustomerCustomer(customer_customerId_8, related_customer_customerId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerCustomer
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveCustomerTswacct() {
		// TODO: JUnit - Populate test inputs for operation: saveCustomerTswacct 
		Integer customerId_10 = 0;
		Tswacct related_tswacct = new wsdm.domain.Tswacct();
		Customer response = null;
		response = service.saveCustomerTswacct(customerId_10, related_tswacct);
		// TODO: JUnit - Add assertions to test outputs of operation: saveCustomerTswacct
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteCustomerPrograms() {
		// TODO: JUnit - Populate test inputs for operation: deleteCustomerPrograms 
		Integer customer_customerId_9 = 0;
		Integer related_programs_programId = 0;
		Customer response = null;
		response = service.deleteCustomerPrograms(customer_customerId_9, related_programs_programId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteCustomerPrograms
	}

	/**
	 * Autowired to set the Spring application context.
	 *
	 */
	@Autowired
	public void setContext(ApplicationContext context) {
		this.context = context;
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("session", new SessionScope());
		((DefaultListableBeanFactory) context.getAutowireCapableBeanFactory()).registerScope("request", new RequestScope());
	}

	/**
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
