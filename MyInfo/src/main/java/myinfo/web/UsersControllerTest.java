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
 * Unit test for the <code>UsersController</code> controller.
 *
 * @see myinfo.web.UsersController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
public class UsersControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>usersControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetusersControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/usersController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UsersController controller = (UsersController) context.getBean("UsersController");

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