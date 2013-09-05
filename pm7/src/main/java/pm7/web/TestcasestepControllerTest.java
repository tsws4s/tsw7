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
 * Unit test for the <code>TestcasestepController</code> controller.
 *
 * @see pm7.web.TestcasestepController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class TestcasestepControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTestcasestepTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcasestepTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcasestepTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcasestepTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcasestepTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcasestepTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcasestepTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcasestepTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcasestepTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcasestepTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcasestepTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcasestepTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcasestepTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcasestepTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcasestepTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcasestepTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcasestepTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcasestepTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcasestepTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcasestepTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcasestepTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcasestepAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcasestepAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcasestepAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcasestepAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcasestepAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcasestepAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcasestepAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcasestepAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcasestepAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcasestepAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcasestepAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcasestepAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcasestepAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcasestepAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcasestepAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcasestepAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcasestepAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcasestepAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcasestepAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcasestepAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcasestepAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcasestepProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcasestepProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcasestepProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcasestepProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcasestepProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcasestepProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcasestepProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcasestepProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcasestepProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcasestepProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcasestepProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcasestepProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcasestepProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcasestepProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcasestepProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcasestepProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcasestepProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcasestepProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcasestepProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcasestepProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcasestepProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTestcasestep()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTestcasestep() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTestcasestep");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcasestep()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcasestep() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcasestep");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcasestep()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcasestep() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcasestep");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcasestep()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcasestep() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcasestep");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcasestep()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcasestep() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcasestep");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcasestep()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcasestep() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcasestep");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcasestep()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcasestep() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcasestep");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>testcasestepControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettestcasestepControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/testcasestepController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcasestepController controller = (TestcasestepController) context.getBean("TestcasestepController");

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