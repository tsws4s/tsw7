package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.Users;

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
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
@Transactional
public class UsersServiceTest {

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
	protected UsersService service;

	/**
	 * Instantiates a new UsersServiceTest.
	 *
	 */
	public UsersServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Load an existing Users entity
	 * 
	 */
	@Test
	public void loadUserss() {
		Set<Users> response = null;
		response = service.loadUserss();
		// TODO: JUnit - Add assertions to test outputs of operation: loadUserss
	}

	/**
	 * Operation Unit Test
	 * Save an existing Users entity
	 * 
	 */
	@Test
	public void saveUsers() {
		// TODO: JUnit - Populate test inputs for operation: saveUsers 
		Users users = new myinfo.domain.Users();
		service.saveUsers(users);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Users entity
	 * 
	 */
	@Test
	public void countUserss() {
		Integer response = null;
		response = service.countUserss();
		// TODO: JUnit - Add assertions to test outputs of operation: countUserss
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Users entity
	 * 
	 */
	@Test
	public void deleteUsers() {
		// TODO: JUnit - Populate test inputs for operation: deleteUsers 
		Users users_1 = new myinfo.domain.Users();
		service.deleteUsers(users_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findUsersByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findUsersByPrimaryKey 
		Integer id = 0;
		Users response = null;
		response = service.findUsersByPrimaryKey(id);
		// TODO: JUnit - Add assertions to test outputs of operation: findUsersByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return all Users entity
	 * 
	 */
	@Test
	public void findAllUserss() {
		// TODO: JUnit - Populate test inputs for operation: findAllUserss 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Users> response = null;
		response = service.findAllUserss(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllUserss
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
