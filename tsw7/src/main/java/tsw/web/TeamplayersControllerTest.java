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
 * Unit test for the <code>TeamplayersController</code> controller.
 *
 * @see tsw.web.TeamplayersController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class TeamplayersControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTeamplayersProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTeamplayersProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTeamplayersProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTeamplayersProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTeamplayersProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTeamplayersProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTeamplayersProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTeamplayersProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTeamplayersProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTeamplayersProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTeamplayersProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTeamplayersProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTeamplayersProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTeamplayersProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTeamplayersProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTeamplayersProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTeamplayersProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTeamplayersProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTeamplayersProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTeamplayersProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTeamplayersProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTeamplayersTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTeamplayersTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTeamplayersTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTeamplayersTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTeamplayersTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTeamplayersTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTeamplayersTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTeamplayersTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTeamplayersTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTeamplayersTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTeamplayersTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTeamplayersTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTeamplayersTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTeamplayersTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTeamplayersTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTeamplayersTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTeamplayersTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTeamplayersTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTeamplayersTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTeamplayersTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTeamplayersTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTeamplayersGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTeamplayersGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTeamplayersGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTeamplayersGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTeamplayersGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTeamplayersGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTeamplayersGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTeamplayersGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTeamplayersGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTeamplayersGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTeamplayersGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTeamplayersGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTeamplayersGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTeamplayersGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTeamplayersGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTeamplayersGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTeamplayersGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTeamplayersGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTeamplayersGamestatses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTeamplayersGamestatses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTeamplayersGamestatses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTeamplayers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTeamplayers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTeamplayers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>teamplayersControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetteamplayersControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/teamplayersController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TeamplayersController controller = (TeamplayersController) context.getBean("TeamplayersController");

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