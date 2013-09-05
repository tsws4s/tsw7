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

import tsw.domain.Program;
import tsw.domain.Sport;
import tsw.domain.Sportposition;
import tsw.domain.Sportstattype;

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
public class SportServiceTest {

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
	protected SportService service;

	/**
	 * Instantiates a new SportServiceTest.
	 *
	 */
	public SportServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return all Sport entity
	 * 
	 */
	@Test
	public void findAllSports() {
		// DO: JUnit - Populate test inputs for operation: findAllSports 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Sport> response = null;
		response = service.findAllSports(startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllSports
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sportstattype entity
	 * 
	 */
	@Test
	public void saveSportSportstattypes() {
		// DO: JUnit - Populate test inputs for operation: saveSportSportstattypes 
		Integer sportId = 0;
		Sportstattype related_sportstattypes = new tsw.domain.Sportstattype();
		@SuppressWarnings("unused")
		Sport response = null;
		response = service.saveSportSportstattypes(sportId, related_sportstattypes);
		// DO: JUnit - Add assertions to test outputs of operation: saveSportSportstattypes
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sport entity
	 * 
	 */
	@Test
	public void deleteSport() {
		// DO: JUnit - Populate test inputs for operation: deleteSport 
		Sport sport = new tsw.domain.Sport();
		service.deleteSport(sport);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveSportPrograms() {
		// DO: JUnit - Populate test inputs for operation: saveSportPrograms 
		Integer sportId_1 = 0;
		Program related_programs = new tsw.domain.Program();
		@SuppressWarnings("unused")
		Sport response = null;
		response = service.saveSportPrograms(sportId_1, related_programs);
		// DO: JUnit - Add assertions to test outputs of operation: saveSportPrograms
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sportstattype entity
	 * 
	 */
	@Test
	public void deleteSportSportstattypes() {
		// DO: JUnit - Populate test inputs for operation: deleteSportSportstattypes 
		Integer sport_sportId = 0;
		Integer related_sportstattypes_sportStatTypeId = 0;
		@SuppressWarnings("unused")
		Sport response = null;
		response = service.deleteSportSportstattypes(sport_sportId, related_sportstattypes_sportStatTypeId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteSportSportstattypes
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteSportPrograms() {
		// DO: JUnit - Populate test inputs for operation: deleteSportPrograms 
		Integer sport_sportId_1 = 0;
		Integer related_programs_programId = 0;
		@SuppressWarnings("unused")
		Sport response = null;
		response = service.deleteSportPrograms(sport_sportId_1, related_programs_programId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteSportPrograms
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sportposition entity
	 * 
	 */
	@Test
	public void deleteSportSportpositions() {
		// DO: JUnit - Populate test inputs for operation: deleteSportSportpositions 
		Integer sport_sportId_2 = 0;
		Integer related_sportpositions_sportPositionId = 0;
		@SuppressWarnings("unused")
		Sport response = null;
		response = service.deleteSportSportpositions(sport_sportId_2, related_sportpositions_sportPositionId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteSportSportpositions
	}

	/**
	 * Operation Unit Test
	 * Load an existing Sport entity
	 * 
	 */
	@Test
	public void loadSports() {
		@SuppressWarnings("unused")
		Set<Sport> response = null;
		response = service.loadSports();
		// DO: JUnit - Add assertions to test outputs of operation: loadSports
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sportposition entity
	 * 
	 */
	@Test
	public void saveSportSportpositions() {
		// DO: JUnit - Populate test inputs for operation: saveSportSportpositions 
		Integer sportId_2 = 0;
		Sportposition related_sportpositions = new tsw.domain.Sportposition();
		@SuppressWarnings("unused")
		Sport response = null;
		response = service.saveSportSportpositions(sportId_2, related_sportpositions);
		// DO: JUnit - Add assertions to test outputs of operation: saveSportSportpositions
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Sport entity
	 * 
	 */
	@Test
	public void countSports() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countSports();
		// DO: JUnit - Add assertions to test outputs of operation: countSports
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sport entity
	 * 
	 */
	@Test
	public void saveSport() {
		// DO: JUnit - Populate test inputs for operation: saveSport 
		Sport sport_1 = new tsw.domain.Sport();
		service.saveSport(sport_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSportByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findSportByPrimaryKey 
		Integer sportId_3 = 0;
		@SuppressWarnings("unused")
		Sport response = null;
		response = service.findSportByPrimaryKey(sportId_3);
		// DO: JUnit - Add assertions to test outputs of operation: findSportByPrimaryKey
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
