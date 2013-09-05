package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.BudgetAccount;

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
public class BudgetAccountServiceTest {

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
	protected BudgetAccountService service;

	/**
	 * Instantiates a new BudgetAccountServiceTest.
	 *
	 */
	public BudgetAccountServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return all BudgetAccount entity
	 * 
	 */
	@Test
	public void findAllBudgetAccounts() {
		// TODO: JUnit - Populate test inputs for operation: findAllBudgetAccounts 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<BudgetAccount> response = null;
		response = service.findAllBudgetAccounts(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllBudgetAccounts
	}

	/**
	 * Operation Unit Test
	 * Return a count of all BudgetAccount entity
	 * 
	 */
	@Test
	public void countBudgetAccounts() {
		Integer response = null;
		response = service.countBudgetAccounts();
		// TODO: JUnit - Add assertions to test outputs of operation: countBudgetAccounts
	}

	/**
	 * Operation Unit Test
	 * Save an existing BudgetAccount entity
	 * 
	 */
	@Test
	public void saveBudgetAccount() {
		// TODO: JUnit - Populate test inputs for operation: saveBudgetAccount 
		BudgetAccount budgetaccount = new myinfo.domain.BudgetAccount();
		service.saveBudgetAccount(budgetaccount);
	}

	/**
	 * Operation Unit Test
	 * Load an existing BudgetAccount entity
	 * 
	 */
	@Test
	public void loadBudgetAccounts() {
		Set<BudgetAccount> response = null;
		response = service.loadBudgetAccounts();
		// TODO: JUnit - Add assertions to test outputs of operation: loadBudgetAccounts
	}

	/**
	 * Operation Unit Test
	 * Delete an existing BudgetAccount entity
	 * 
	 */
	@Test
	public void deleteBudgetAccount() {
		// TODO: JUnit - Populate test inputs for operation: deleteBudgetAccount 
		BudgetAccount budgetaccount_1 = new myinfo.domain.BudgetAccount();
		service.deleteBudgetAccount(budgetaccount_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findBudgetAccountByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findBudgetAccountByPrimaryKey 
		Integer budId = 0;
		BudgetAccount response = null;
		response = service.findBudgetAccountByPrimaryKey(budId);
		// TODO: JUnit - Add assertions to test outputs of operation: findBudgetAccountByPrimaryKey
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
