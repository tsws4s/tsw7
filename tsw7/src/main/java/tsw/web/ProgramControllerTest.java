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
 * Unit test for the <code>ProgramController</code> controller.
 *
 * @see tsw.web.ProgramController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class ProgramControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editProgramSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgramSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgramSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgramSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgramSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgramSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgramSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgramSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgramSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgramSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgramSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgramSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgramSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgramSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgramSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgramSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgramSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgramSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProgramSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProgramSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProgramSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProgramTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgramTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgramTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgramTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgramTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgramTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgramTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgramTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgramTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgramTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgramTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgramTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgramTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgramTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgramTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgramTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgramTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgramTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProgramTswacct()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProgramTswacct() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProgramTswacct");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProgramProgramresources()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgramProgramresources() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgramProgramresources");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgramProgramresources()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgramProgramresources() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgramProgramresources");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgramProgramresources()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgramProgramresources() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgramProgramresources");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgramProgramresources()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgramProgramresources() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgramProgramresources");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgramProgramresources()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgramProgramresources() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgramProgramresources");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgramProgramresources()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgramProgramresources() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgramProgramresources");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProgramProgramresources()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProgramProgramresources() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProgramProgramresources");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProgramTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgramTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgramTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgramTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgramTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgramTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgramTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgramTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgramTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgramTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgramTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgramTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgramTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgramTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgramTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgramTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgramTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgramTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProgramTeamplayerses()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProgramTeamplayerses() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProgramTeamplayerses");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProgramGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgramGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgramGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgramGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgramGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgramGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgramGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgramGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgramGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgramGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgramGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgramGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgramGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgramGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgramGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgramGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgramGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgramGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProgramGames()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProgramGames() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProgramGames");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>programControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetprogramControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/programController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramController controller = (ProgramController) context.getBean("ProgramController");

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