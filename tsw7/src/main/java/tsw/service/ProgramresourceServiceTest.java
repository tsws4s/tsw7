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

import tsw.domain.Programresource;

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
public class ProgramresourceServiceTest {

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
	protected ProgramresourceService service;

	/**
	 * Instantiates a new ProgramresourceServiceTest.
	 *
	 */
	public ProgramresourceServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Programresource entity
	 * 
	 */
	@Test
	public void saveProgramresource() {
		// DO: JUnit - Populate test inputs for operation: saveProgramresource 
		Programresource programresource = new tsw.domain.Programresource();
		service.saveProgramresource(programresource, null, null, null);
	}


	/**
	 * Operation Unit Test
	 */
	@Test
	public void findProgramresourceByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findProgramresourceByPrimaryKey 
		Integer programResourceId = 0;
		@SuppressWarnings("unused")
		Programresource response = null;
		response = service.findProgramresourceByPrimaryKey(programResourceId);
		// DO: JUnit - Add assertions to test outputs of operation: findProgramresourceByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Load an existing Programresource entity
	 * 
	 */
	@Test
	public void loadProgramresources() {
		@SuppressWarnings("unused")
		Set<Programresource> response = null;
		response = service.loadProgramresources();
		// DO: JUnit - Add assertions to test outputs of operation: loadProgramresources
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Programresource entity
	 * 
	 */
	@Test
	public void deleteProgramresource() {
		// DO: JUnit - Populate test inputs for operation: deleteProgramresource 
		Programresource programresource_1 = new tsw.domain.Programresource();
		service.deleteProgramresource(programresource_1);
	}

	/**
	 * Operation Unit Test
	 * Return all Programresource entity
	 * 
	 */
	@Test
	public void findAllProgramresources() {
		// DO: JUnit - Populate test inputs for operation: findAllProgramresources 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Programresource> response = null;
		response = service.findAllProgramresources(startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllProgramresources
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Programresource entity
	 * 
	 */
	@Test
	public void countProgramresources() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countProgramresources();
		// DO: JUnit - Add assertions to test outputs of operation: countProgramresources
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
