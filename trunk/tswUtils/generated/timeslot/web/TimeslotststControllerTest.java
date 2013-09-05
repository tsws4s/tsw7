package timeslot.web;

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
 * Unit test for the <code>TimeslotststController</code> controller.
 *
 * @see timeslot.web.TimeslotststController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tswUtils-security-context.xml",
		"file:./resources/tswUtils-service-context.xml",
		"file:./resources/tswUtils-dao-context.xml",
		"file:./resources/tswUtils-web-context.xml" })
public class TimeslotststControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexTimeslotstst()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTimeslotstst() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTimeslotstst");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTimeslotstst()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTimeslotstst() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTimeslotstst");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTimeslotstst()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTimeslotstst() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTimeslotstst");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTimeslotstst()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTimeslotstst() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTimeslotstst");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTimeslotstst()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTimeslotstst() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTimeslotstst");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTimeslotstst()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTimeslotstst() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTimeslotstst");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTimeslotstst()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTimeslotstst() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTimeslotstst");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>timeslotststControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettimeslotststControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/timeslotststController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeslotststController controller = (TimeslotststController) context.getBean("TimeslotststController");

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