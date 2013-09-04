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
 * Unit test for the <code>SportstattypeController</code> controller.
 *
 * @see tsw.web.SportstattypeController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class SportstattypeControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editSportstattypeSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSportstattypeSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSportstattypeSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSportstattypeSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSportstattypeSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSportstattypeSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSportstattypeSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSportstattypeSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSportstattypeSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSportstattypeSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSportstattypeSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSportstattypeSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSportstattypeSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSportstattypeSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSportstattypeSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSportstattypeSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSportstattypeSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSportstattypeSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSportstattypeSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSportstattypeSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSportstattypeSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexSportstattype()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSportstattype() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSportstattype");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSportstattype()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSportstattype() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSportstattype");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSportstattype()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSportstattype() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSportstattype");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSportstattype()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSportstattype() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSportstattype");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSportstattype()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSportstattype() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSportstattype");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSportstattype()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSportstattype() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSportstattype");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSportstattype()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSportstattype() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSportstattype");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>sportstattypeControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsportstattypeControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/sportstattypeController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportstattypeController controller = (SportstattypeController) context.getBean("SportstattypeController");

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