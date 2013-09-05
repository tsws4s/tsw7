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
 * Unit test for the <code>ProgramresourceController</code> controller.
 *
 * @see tsw.web.ProgramresourceController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class ProgramresourceControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editProgramresourceProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgramresourceProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgramresourceProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgramresourceProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgramresourceProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgramresourceProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgramresourceProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgramresourceProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgramresourceProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgramresourceProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgramresourceProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgramresourceProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgramresourceProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgramresourceProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgramresourceProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgramresourceProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgramresourceProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgramresourceProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProgramresourceProgram()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProgramresourceProgram() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProgramresourceProgram");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexProgramresource()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexProgramresource() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexProgramresource");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProgramresource()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProgramresource() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProgramresource");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProgramresource()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProgramresource() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProgramresource");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProgramresource()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProgramresource() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProgramresource");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProgramresource()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProgramresource() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProgramresource");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProgramresource()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProgramresource() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProgramresource");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProgramresource()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProgramresource() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProgramresource");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

		// DO Invoke method and Assert return values

	}

	/**
	 * Test <code>programresourceControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetprogramresourceControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/programresourceController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProgramresourceController controller = (ProgramresourceController) context.getBean("ProgramresourceController");

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