package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.Budget;

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
public class BudgetServiceTest {

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
	protected BudgetService service;

	/**
	 * Instantiates a new BudgetServiceTest.
	 *
	 */
	public BudgetServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return all Budget entity
	 * 
	 */
	@Test
	public void findAllBudgets() {
		// TODO: JUnit - Populate test inputs for operation: findAllBudgets 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Budget> response = null;
		response = service.findAllBudgets(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllBudgets
	}

	/**
	 * Operation Unit Test
	 * Save an existing Budget entity
	 * 
	 */
	@Test
	public void saveBudget() {
		// TODO: JUnit - Populate test inputs for operation: saveBudget 
		Budget budget = new myinfo.domain.Budget();
		service.saveBudget(budget);
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Budget entity
	 * 
	 */
	@Test
	public void countBudgets() {
		Integer response = null;
		response = service.countBudgets();
		// TODO: JUnit - Add assertions to test outputs of operation: countBudgets
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Budget entity
	 * 
	 */
	@Test
	public void deleteBudget() {
		// TODO: JUnit - Populate test inputs for operation: deleteBudget 
		Budget budget_1 = new myinfo.domain.Budget();
		service.deleteBudget(budget_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findBudgetByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findBudgetByPrimaryKey 
		Integer budgetId = 0;
		Budget response = null;
		response = service.findBudgetByPrimaryKey(budgetId);
		// TODO: JUnit - Add assertions to test outputs of operation: findBudgetByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Load an existing Budget entity
	 * 
	 */
	@Test
	public void loadBudgets() {
		Set<Budget> response = null;
		response = service.loadBudgets();
		// TODO: JUnit - Add assertions to test outputs of operation: loadBudgets
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
