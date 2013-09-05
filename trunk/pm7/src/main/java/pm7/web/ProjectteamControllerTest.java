package pm7.web;

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
 * Unit test for the <code>ProjectteamController</code> controller.
 *
 * @see pm7.web.ProjectteamController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class ProjectteamControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editProjectteamPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectteamPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectteamPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectteamPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectteamPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectteamPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectteamPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectteamPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectteamPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectteamPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectteamPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectteamPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectteamPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectteamPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectteamPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectteamPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectteamPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectteamPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectteamPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectteamPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectteamPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectteamAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectteamAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectteamAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectteamAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectteamAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectteamAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectteamAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectteamAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectteamAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectteamAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectteamAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectteamAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectteamAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectteamAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectteamAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectteamAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectteamAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectteamAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectteamAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectteamAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectteamAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectteamProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectteamProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectteamProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectteamProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectteamProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectteamProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectteamProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectteamProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectteamProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectteamProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectteamProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectteamProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectteamProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectteamProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectteamProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectteamProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectteamProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectteamProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectteamProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectteamProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectteamProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexProjectteam()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexProjectteam() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexProjectteam");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectteam()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectteam() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectteam");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectteam()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectteam() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectteam");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectteam()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectteam() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectteam");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectteam()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectteam() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectteam");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectteam()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectteam() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectteam");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectteam()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectteam() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectteam");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>projectteamControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetprojectteamControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/projectteamController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectteamController controller = (ProjectteamController) context.getBean("ProjectteamController");

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