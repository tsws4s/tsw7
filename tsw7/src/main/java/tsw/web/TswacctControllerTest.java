package tsw.web;

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
 * Unit test for the <code>TswacctController</code> controller.
 *
 * @see tsw.web.TswacctController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class TswacctControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTswacctGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTswacctGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTswacctGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTswacctGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTswacctGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTswacctGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTswacctGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTswacctGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTswacctGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTswacctGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTswacctGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTswacctGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTswacctGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTswacctGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTswacctGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTswacctGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTswacctGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTswacctGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTswacctGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTswacctGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTswacctGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTswacctPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTswacctPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTswacctPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTswacctPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTswacctPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTswacctPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTswacctPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTswacctPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTswacctPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTswacctPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTswacctPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTswacctPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTswacctPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTswacctPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTswacctPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTswacctPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTswacctPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTswacctPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTswacctPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTswacctPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTswacctPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTswacctTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTswacctTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTswacctTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTswacctTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTswacctTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTswacctTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTswacctTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTswacctTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTswacctTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTswacctTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTswacctTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTswacctTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTswacctTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTswacctTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTswacctTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTswacctTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTswacctTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTswacctTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTswacctTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTswacctTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTswacctTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>tswacctControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettswacctControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/tswacctController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TswacctController controller = (TswacctController) context.getBean("TswacctController");

		// DO Invoke method and Assert return values

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