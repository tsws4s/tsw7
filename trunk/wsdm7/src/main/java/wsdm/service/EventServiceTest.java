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
import wsdm.domain.Game;
import wsdm.domain.Price;
import wsdm.domain.Program;
import wsdm.domain.Resource;
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
public class EventServiceTest {

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
	protected EventService service;

	/**
	 * Instantiates a new EventServiceTest.
	 *
	 */
	public EventServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Customer entity
	 * 
	 */
	@Test
	public void saveEventCustomer() {
		// TODO: JUnit - Populate test inputs for operation: saveEventCustomer 
		Integer eventId = 0;
		Customer related_customer = new wsdm.domain.Customer();
		Event response = null;
		response = service.saveEventCustomer(eventId, related_customer);
		// TODO: JUnit - Add assertions to test outputs of operation: saveEventCustomer
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteEventProgram() {
		// TODO: JUnit - Populate test inputs for operation: deleteEventProgram 
		Integer event_eventId = 0;
		Integer related_program_programId = 0;
		Event response = null;
		response = service.deleteEventProgram(event_eventId, related_program_programId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteEventProgram
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Event entity
	 * 
	 */
	@Test
	public void deleteEvent() {
		// TODO: JUnit - Populate test inputs for operation: deleteEvent 
		Event event = new wsdm.domain.Event();
		service.deleteEvent(event);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteEventGame() {
		// TODO: JUnit - Populate test inputs for operation: deleteEventGame 
		Integer event_eventId_1 = 0;
		Integer related_game_gameId = 0;
		Event response = null;
		response = service.deleteEventGame(event_eventId_1, related_game_gameId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteEventGame
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteEventTswacct() {
		// TODO: JUnit - Populate test inputs for operation: deleteEventTswacct 
		Integer event_eventId_2 = 0;
		Integer related_tswacct_tswAcctId = 0;
		Event response = null;
		response = service.deleteEventTswacct(event_eventId_2, related_tswacct_tswAcctId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteEventTswacct
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findEventByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findEventByPrimaryKey 
		Integer eventId_1 = 0;
		Event response = null;
		response = service.findEventByPrimaryKey(eventId_1);
		// TODO: JUnit - Add assertions to test outputs of operation: findEventByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Price entity
	 * 
	 */
	@Test
	public void saveEventPrice() {
		// TODO: JUnit - Populate test inputs for operation: saveEventPrice 
		Integer eventId_2 = 0;
		Price related_price = new wsdm.domain.Price();
		Event response = null;
		response = service.saveEventPrice(eventId_2, related_price);
		// TODO: JUnit - Add assertions to test outputs of operation: saveEventPrice
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveEventTswacct() {
		// TODO: JUnit - Populate test inputs for operation: saveEventTswacct 
		Integer eventId_3 = 0;
		Tswacct related_tswacct = new wsdm.domain.Tswacct();
		Event response = null;
		response = service.saveEventTswacct(eventId_3, related_tswacct);
		// TODO: JUnit - Add assertions to test outputs of operation: saveEventTswacct
	}

	/**
	 * Operation Unit Test
	 * Save an existing Resource entity
	 * 
	 */
	@Test
	public void saveEventResource() {
		// TODO: JUnit - Populate test inputs for operation: saveEventResource 
		Integer eventId_4 = 0;
		Resource related_resource = new wsdm.domain.Resource();
		Event response = null;
		response = service.saveEventResource(eventId_4, related_resource);
		// TODO: JUnit - Add assertions to test outputs of operation: saveEventResource
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Customer entity
	 * 
	 */
	@Test
	public void deleteEventCustomer() {
		// TODO: JUnit - Populate test inputs for operation: deleteEventCustomer 
		Integer event_eventId_3 = 0;
		Integer related_customer_customerId = 0;
		Event response = null;
		response = service.deleteEventCustomer(event_eventId_3, related_customer_customerId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteEventCustomer
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Event entity
	 * 
	 */
	@Test
	public void countEvents() {
		Integer response = null;
		response = service.countEvents();
		// TODO: JUnit - Add assertions to test outputs of operation: countEvents
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Resource entity
	 * 
	 */
	@Test
	public void deleteEventResource() {
		// TODO: JUnit - Populate test inputs for operation: deleteEventResource 
		Integer event_eventId_4 = 0;
		Integer related_resource_resourceId = 0;
		Event response = null;
		response = service.deleteEventResource(event_eventId_4, related_resource_resourceId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteEventResource
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveEventProgram() {
		// TODO: JUnit - Populate test inputs for operation: saveEventProgram 
		Integer eventId_5 = 0;
		Program related_program = new wsdm.domain.Program();
		Event response = null;
		response = service.saveEventProgram(eventId_5, related_program);
		// TODO: JUnit - Add assertions to test outputs of operation: saveEventProgram
	}

	/**
	 * Operation Unit Test
	 * Load an existing Event entity
	 * 
	 */
	@Test
	public void loadEvents() {
		Set<Event> response = null;
		response = service.loadEvents();
		// TODO: JUnit - Add assertions to test outputs of operation: loadEvents
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Price entity
	 * 
	 */
	@Test
	public void deleteEventPrice() {
		// TODO: JUnit - Populate test inputs for operation: deleteEventPrice 
		Integer event_eventId_5 = 0;
		Integer related_price_priceId = 0;
		Event response = null;
		response = service.deleteEventPrice(event_eventId_5, related_price_priceId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteEventPrice
	}

	/**
	 * Operation Unit Test
	 * Save an existing Event entity
	 * 
	 */
	@Test
	public void saveEvent() {
		// TODO: JUnit - Populate test inputs for operation: saveEvent 
		Event event_1 = new wsdm.domain.Event();
		service.saveEvent(event_1);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveEventGame() {
		// TODO: JUnit - Populate test inputs for operation: saveEventGame 
		Integer eventId_6 = 0;
		Game related_game = new wsdm.domain.Game();
		Event response = null;
		response = service.saveEventGame(eventId_6, related_game);
		// TODO: JUnit - Add assertions to test outputs of operation: saveEventGame
	}

	/**
	 * Operation Unit Test
	 * Return all Event entity
	 * 
	 */
	@Test
	public void findAllEvents() {
		// TODO: JUnit - Populate test inputs for operation: findAllEvents 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Event> response = null;
		response = service.findAllEvents(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllEvents
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
