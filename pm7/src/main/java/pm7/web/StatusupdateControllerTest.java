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
 * Unit test for the <code>StatusupdateController</code> controller.
 *
 * @see pm7.web.StatusupdateController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class StatusupdateControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editStatusupdateTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdateReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdateTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdatePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdatePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdatePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdatePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdatePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdatePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdatePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdatePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdatePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdatePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdatePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdatePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdatePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdatePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdatePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdatePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdatePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdatePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdatePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdatePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdatePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdateDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdateRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdateAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdateAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdateAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdateAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdateAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdateAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdateAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdateAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdateAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdateAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdateAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdateAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdateAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdateAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdateAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdateAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdateAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdateAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listStatusupdateAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistStatusupdateAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listStatusupdateAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>statusupdateControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetstatusupdateControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/statusupdateController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		StatusupdateController controller = (StatusupdateController) context.getBean("StatusupdateController");

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