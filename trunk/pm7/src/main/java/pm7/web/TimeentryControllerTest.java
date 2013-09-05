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
 * Unit test for the <code>TimeentryController</code> controller.
 *
 * @see pm7.web.TimeentryController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class TimeentryControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTimeentryTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTimeentryTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTimeentryTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTimeentryTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTimeentryTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTimeentryTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTimeentryTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTimeentryTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTimeentryTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTimeentryTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTimeentryTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTimeentryTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTimeentryTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTimeentryTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTimeentryTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTimeentryTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTimeentryTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTimeentryTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTimeentryTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTimeentryTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTimeentryTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTimeentryPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTimeentryPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTimeentryPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTimeentryPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTimeentryPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTimeentryPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTimeentryPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTimeentryPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTimeentryPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTimeentryPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTimeentryPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTimeentryPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTimeentryPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTimeentryPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTimeentryPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTimeentryPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTimeentryPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTimeentryPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTimeentryPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTimeentryPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTimeentryPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTimeentryAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTimeentryAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTimeentryAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTimeentryAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTimeentryAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTimeentryAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTimeentryAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTimeentryAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTimeentryAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTimeentryAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTimeentryAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTimeentryAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTimeentryAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTimeentryAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTimeentryAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTimeentryAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTimeentryAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTimeentryAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTimeentryAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTimeentryAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTimeentryAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTimeentryProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTimeentryProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTimeentryProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTimeentryProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTimeentryProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTimeentryProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTimeentryProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTimeentryProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTimeentryProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTimeentryProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTimeentryProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTimeentryProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTimeentryProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTimeentryProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTimeentryProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTimeentryProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTimeentryProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTimeentryProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTimeentryProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTimeentryProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTimeentryProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTimeentry()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTimeentry() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTimeentry");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTimeentry()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTimeentry() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTimeentry");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTimeentry()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTimeentry() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTimeentry");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTimeentry()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTimeentry() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTimeentry");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTimeentry()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTimeentry() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTimeentry");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTimeentry()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTimeentry() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTimeentry");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTimeentry()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTimeentry() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTimeentry");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>timeentryControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettimeentryControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/timeentryController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TimeentryController controller = (TimeentryController) context.getBean("TimeentryController");

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