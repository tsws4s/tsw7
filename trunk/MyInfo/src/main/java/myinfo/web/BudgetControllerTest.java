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
 * Unit test for the <code>BudgetController</code> controller.
 *
 * @see myinfo.web.BudgetController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
public class BudgetControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexBudget()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexBudget() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexBudget");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectBudget()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectBudget() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectBudget");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editBudget()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditBudget() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editBudget");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveBudget()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveBudget() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveBudget");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newBudget()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewBudget() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newBudget");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteBudget()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteBudget() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteBudget");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteBudget()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteBudget() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteBudget");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>budgetControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetbudgetControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/budgetController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BudgetController controller = (BudgetController) context.getBean("BudgetController");

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