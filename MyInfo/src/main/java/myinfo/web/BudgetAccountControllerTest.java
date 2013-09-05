package myinfo.web;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import org.springframework.test.context.ContextConfiguration;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Unit test for the <code>BudgetAccountController</code> controller.
 *
 * @see myinfo.web.BudgetAccountController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
public class BudgetAccountControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexBudgetAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexBudgetAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexBudgetAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectBudgetAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectBudgetAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectBudgetAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editBudgetAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditBudgetAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editBudgetAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveBudgetAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveBudgetAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveBudgetAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newBudgetAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewBudgetAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newBudgetAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteBudgetAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteBudgetAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteBudgetAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteBudgetAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteBudgetAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteBudgetAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>budgetaccountControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetbudgetaccountControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/budgetaccountController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetAccountController controller = (BudgetAccountController) context.getBean("BudgetAccountController");

		// TODO Invoke method and Assert return values

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
	 * Returns a mock HttpServletRequest object.
	 *
	 */
	private MockHttpServletRequest getMockHttpServletRequest() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
		return request;
	}

	/**
	 * Returns a mock HttpServletResponse object.
	 *
	 */
	private MockHttpServletResponse getMockHttpServletResponse() {
		return new MockHttpServletResponse();
	}
}