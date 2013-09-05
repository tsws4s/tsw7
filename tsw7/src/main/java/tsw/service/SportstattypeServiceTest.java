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
public class SportstattypeServiceTest {

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
	protected SportstattypeService service;

	/**
	 * Instantiates a new SportstattypeServiceTest.
	 *
	 */
	public SportstattypeServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing Sportstattype entity
	 * 
	 */
	@Test
	public void loadSportstattypes() {
		@SuppressWarnings("unused")
		Set<Sportstattype> response = null;
		response = service.loadSportstattypes();
		// DO: JUnit - Add assertions to test outputs of operation: loadSportstattypes
	}

	/**
	 * Operation Unit Test
	 * Return all Sportstattype entity
	 * 
	 */
	@Test
	public void findAllSportstattypes() {
		// DO: JUnit - Populate test inputs for operation: findAllSportstattypes 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Sportstattype> response = null;
		response = service.findAllSportstattypes(startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllSportstattypes
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Sportstattype entity
	 * 
	 */
	@Test
	public void countSportstattypes() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countSportstattypes();
		// DO: JUnit - Add assertions to test outputs of operation: countSportstattypes
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sportstattype entity
	 * 
	 */
	@Test
	public void saveSportstattype() {
		// DO: JUnit - Populate test inputs for operation: saveSportstattype 
		Sportstattype sportstattype = new tsw.domain.Sportstattype();
		service.saveSportstattype(sportstattype);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sport entity
	 * 
	 */
	@Test
	public void saveSportstattypeSport() {
		// DO: JUnit - Populate test inputs for operation: saveSportstattypeSport 
		Integer sportStatTypeId = 0;
		Sport related_sport = new tsw.domain.Sport();
		@SuppressWarnings("unused")
		Sportstattype response = null;
		response = service.saveSportstattypeSport(sportStatTypeId, related_sport);
		// DO: JUnit - Add assertions to test outputs of operation: saveSportstattypeSport
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sport entity
	 * 
	 */
	@Test
	public void deleteSportstattypeSport() {
		// DO: JUnit - Populate test inputs for operation: deleteSportstattypeSport 
		Integer sportstattype_sportStatTypeId = 0;
		Integer related_sport_sportId = 0;
		@SuppressWarnings("unused")
		Sportstattype response = null;
		response = service.deleteSportstattypeSport(sportstattype_sportStatTypeId, related_sport_sportId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteSportstattypeSport
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sportstattype entity
	 * 
	 */
	@Test
	public void deleteSportstattype() {
		// DO: JUnit - Populate test inputs for operation: deleteSportstattype 
		Sportstattype sportstattype_1 = new tsw.domain.Sportstattype();
		service.deleteSportstattype(sportstattype_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findSportstattypeByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findSportstattypeByPrimaryKey 
		Integer sportStatTypeId_1 = 0;
		@SuppressWarnings("unused")
		Sportstattype response = null;
		response = service.findSportstattypeByPrimaryKey(sportStatTypeId_1);
		// DO: JUnit - Add assertions to test outputs of operation: findSportstattypeByPrimaryKey
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
