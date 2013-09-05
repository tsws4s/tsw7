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
 * Unit test for the <code>TestcaseController</code> controller.
 *
 * @see pm7.web.TestcaseController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class TestcaseControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTestcaseAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcaseAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcaseAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcaseAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcaseAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcaseAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcaseAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcaseAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcaseAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcaseAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcaseAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcaseAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcaseAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcaseAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcaseAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcaseAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcaseAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcaseAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcaseAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTestcaseAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTestcaseAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTestcaseAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>testcaseControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettestcaseControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/testcaseController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TestcaseController controller = (TestcaseController) context.getBean("TestcaseController");

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