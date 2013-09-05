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
 * Unit test for the <code>GameController</code> controller.
 *
 * @see tsw.web.GameController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class GameControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editGameProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGameProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGameProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGameProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGameProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGameProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGameProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGameProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGameProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGameProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGameProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGameProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGameProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGameProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGameProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGameProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGameProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGameProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listGameProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistGameProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listGameProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editGameTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGameTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGameTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGameTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGameTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGameTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGameTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGameTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGameTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGameTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGameTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGameTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGameTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGameTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGameTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGameTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGameTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGameTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listGameTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistGameTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listGameTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editGameGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGameGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGameGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGameGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGameGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGameGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGameGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGameGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGameGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGameGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGameGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGameGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGameGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGameGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGameGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGameGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGameGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGameGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listGameGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistGameGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listGameGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteGame()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteGame() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteGame");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>gameControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetgameControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/gameController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		GameController controller = (GameController) context.getBean("GameController");

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