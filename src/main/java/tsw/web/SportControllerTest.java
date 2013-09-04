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
 * Unit test for the <code>SportController</code> controller.
 *
 * @see tsw.web.SportController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class SportControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editSportSportstattypes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSportSportstattypes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSportSportstattypes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSportSportstattypes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSportSportstattypes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSportSportstattypes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSportSportstattypes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSportSportstattypes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSportSportstattypes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSportSportstattypes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSportSportstattypes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSportSportstattypes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSportSportstattypes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSportSportstattypes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSportSportstattypes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSportSportstattypes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSportSportstattypes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSportSportstattypes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSportSportstattypes()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSportSportstattypes() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSportSportstattypes");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSportSportpositions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSportSportpositions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSportSportpositions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSportSportpositions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSportSportpositions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSportSportpositions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSportSportpositions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSportSportpositions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSportSportpositions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSportSportpositions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSportSportpositions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSportSportpositions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSportSportpositions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSportSportpositions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSportSportpositions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSportSportpositions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSportSportpositions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSportSportpositions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSportSportpositions()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSportSportpositions() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSportSportpositions");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSportPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSportPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSportPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSportPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSportPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSportPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSportPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSportPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSportPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSportPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSportPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSportPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSportPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSportPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSportPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSportPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSportPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSportPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSportPrograms()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSportPrograms() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSportPrograms");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>sportControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsportControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/sportController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportController controller = (SportController) context.getBean("SportController");

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