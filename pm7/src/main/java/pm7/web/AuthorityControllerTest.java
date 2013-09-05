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
 * Unit test for the <code>AuthorityController</code> controller.
 *
 * @see pm7.web.AuthorityController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class AuthorityControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexAuthority()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexAuthority() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexAuthority");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAuthority()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAuthority() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAuthority");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAuthority()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAuthority() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAuthority");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAuthority()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAuthority() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAuthority");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAuthority()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAuthority() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAuthority");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAuthority()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAuthority() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAuthority");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAuthority()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAuthority() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAuthority");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>authorityControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetauthorityControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/authorityController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AuthorityController controller = (AuthorityController) context.getBean("AuthorityController");

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