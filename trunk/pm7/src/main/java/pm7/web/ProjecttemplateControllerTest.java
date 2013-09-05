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
 * Unit test for the <code>ProjecttemplateController</code> controller.
 *
 * @see pm7.web.ProjecttemplateController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class ProjecttemplateControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editProjecttemplateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjecttemplateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjecttemplateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjecttemplateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjecttemplateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjecttemplateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjecttemplateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjecttemplateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjecttemplateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjecttemplateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjecttemplateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjecttemplateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjecttemplateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjecttemplateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjecttemplateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjecttemplateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjecttemplateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjecttemplateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjecttemplateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjecttemplateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjecttemplateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjecttemplateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjecttemplateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjecttemplateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjecttemplateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjecttemplateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjecttemplateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjecttemplateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjecttemplateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjecttemplateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjecttemplateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjecttemplateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjecttemplateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjecttemplateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjecttemplateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjecttemplateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjecttemplateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjecttemplateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjecttemplateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjecttemplateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjecttemplateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjecttemplateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexProjecttemplate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexProjecttemplate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexProjecttemplate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjecttemplate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjecttemplate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjecttemplate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjecttemplate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjecttemplate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjecttemplate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjecttemplate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjecttemplate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjecttemplate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjecttemplate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjecttemplate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjecttemplate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjecttemplate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjecttemplate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjecttemplate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjecttemplate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjecttemplate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjecttemplate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>projecttemplateControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetprojecttemplateControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/projecttemplateController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjecttemplateController controller = (ProjecttemplateController) context.getBean("ProjecttemplateController");

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