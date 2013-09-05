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
 * Unit test for the <code>SportpositionController</code> controller.
 *
 * @see tsw.web.SportpositionController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class SportpositionControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editSportpositionSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSportpositionSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSportpositionSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSportpositionSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSportpositionSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSportpositionSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSportpositionSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSportpositionSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSportpositionSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSportpositionSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSportpositionSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSportpositionSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSportpositionSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSportpositionSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSportpositionSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSportpositionSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSportpositionSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSportpositionSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listSportpositionSport()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistSportpositionSport() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listSportpositionSport");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexSportposition()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexSportposition() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexSportposition");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectSportposition()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectSportposition() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectSportposition");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editSportposition()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditSportposition() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editSportposition");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveSportposition()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveSportposition() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveSportposition");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newSportposition()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewSportposition() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newSportposition");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteSportposition()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteSportposition() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteSportposition");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteSportposition()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteSportposition() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteSportposition");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>sportpositionControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsportpositionControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/sportpositionController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		SportpositionController controller = (SportpositionController) context.getBean("SportpositionController");

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