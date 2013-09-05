package pm7.web;

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
 * Unit test for the <code>UserController</code> controller.
 *
 * @see pm7.web.UserController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class UserControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editUserAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditUserAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editUserAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newUserAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewUserAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newUserAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveUserAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveUserAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveUserAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteUserAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteUserAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteUserAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteUserAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteUserAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteUserAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectUserAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectUserAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectUserAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listUserAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistUserAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listUserAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteUser()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteUser() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteUser");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>userControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetuserControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/userController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		UserController controller = (UserController) context.getBean("UserController");

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