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
 * Unit test for the <code>GamestatsController</code> controller.
 *
 * @see tsw.web.GamestatsController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class GamestatsControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editGamestatsGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGamestatsGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGamestatsGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGamestatsGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGamestatsGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGamestatsGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGamestatsGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGamestatsGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGamestatsGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGamestatsGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGamestatsGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGamestatsGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGamestatsGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGamestatsGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGamestatsGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGamestatsGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGamestatsGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGamestatsGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listGamestatsGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistGamestatsGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listGamestatsGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editGamestatsTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGamestatsTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGamestatsTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGamestatsTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGamestatsTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGamestatsTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGamestatsTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGamestatsTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGamestatsTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGamestatsTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGamestatsTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGamestatsTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGamestatsTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGamestatsTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGamestatsTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGamestatsTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGamestatsTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGamestatsTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listGamestatsTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistGamestatsTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listGamestatsTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexGamestats()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexGamestats() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexGamestats");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGamestats()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGamestats() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGamestats");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editGamestats()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGamestats() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGamestats");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGamestats()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGamestats() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGamestats");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGamestats()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGamestats() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGamestats");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGamestats()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGamestats() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGamestats");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGamestats()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGamestats() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGamestats");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>gamestatsControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetgamestatsControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/gamestatsController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GamestatsController controller = (GamestatsController) context.getBean("GamestatsController");

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