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
 * Unit test for the <code>BooksController</code> controller.
 *
 * @see myinfo.web.BooksController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
public class BooksControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexBooks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexBooks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexBooks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectBooks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectBooks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectBooks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editBooks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditBooks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editBooks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveBooks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveBooks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveBooks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newBooks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewBooks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newBooks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteBooks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteBooks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteBooks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteBooks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteBooks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteBooks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>booksControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetbooksControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/booksController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		BooksController controller = (BooksController) context.getBean("BooksController");

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