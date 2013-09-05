package tsw.service;

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

import tsw.domain.Sport;
import tsw.domain.Sportposition;

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
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
@Transactional
public class SportpositionServiceTest {

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
	protected SportpositionService service;

	/**
	 * Instantiates a new SportpositionServiceTest.
	 *
	 */
	public SportpositionServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sport entity
	 * 
	 */
	@Test
	public void saveSportpositionSport() {
		// DO: JUnit - Populate test inputs for operation: saveSportpositionSport 
		Integer sportPositionId = 0;
		Sport related_sport = new tsw.domain.Sport();
		@SuppressWarnings("unused")
		Sportposition response = null;
		response = service.saveSportpositionSport(sportPositionId, related_sport);
		// DO: JUnit - Add assertions to test outputs of operation: saveSportpositionSport
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sport entity
	 * 
	 */
	@Test
	public void deleteSportpositionSport() {
		// DO: JUnit - Populate test inputs for operation: deleteSportpositionSport 
		Integer sportposition_sportPositionId = 0;
		Integer related_sport_sportId = 0;
		@SuppressWarnings("unused")
		Sportposition response = null;
		response = service.deleteSportpositionSport(sportposition_sportPositionId, related_sport_sportId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteSportpositionSport
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sportposition entity
	 * 
	 */
	@Test
	public void saveSportposition() {
		// DO: JUnit - Populate test inputs for operation: saveSportposition 
		Sportposition sportposition = new tsw.domain.Sportposition();
		service.saveSportposition(sportposition);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSportpositionByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findSportpositionByPrimaryKey 
		Integer sportPositionId_1 = 0;
		@SuppressWarnings("unused")
		Sportposition response = null;
		response = service.findSportpositionByPrimaryKey(sportPositionId_1);
		// DO: JUnit - Add assertions to test outputs of operation: findSportpositionByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Sportposition entity
	 * 
	 */
	@Test
	public void countSportpositions() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countSportpositions();
		// DO: JUnit - Add assertions to test outputs of operation: countSportpositions
	}

	/**
	 * Operation Unit Test
	 * Return all Sportposition entity
	 * 
	 */
	@Test
	public void findAllSportpositions() {
		// DO: JUnit - Populate test inputs for operation: findAllSportpositions 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Sportposition> response = null;
		response = service.findAllSportpositions(startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllSportpositions
	}

	/**
	 * Operation Unit Test
	 * Load an existing Sportposition entity
	 * 
	 */
	@Test
	public void loadSportpositions() {
		@SuppressWarnings("unused")
		Set<Sportposition> response = null;
		response = service.loadSportpositions();
		// DO: JUnit - Add assertions to test outputs of operation: loadSportpositions
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sportposition entity
	 * 
	 */
	@Test
	public void deleteSportposition() {
		// DO: JUnit - Populate test inputs for operation: deleteSportposition 
		Sportposition sportposition_1 = new tsw.domain.Sportposition();
		service.deleteSportposition(sportposition_1);
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
