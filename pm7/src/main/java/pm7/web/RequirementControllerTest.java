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
 * Unit test for the <code>RequirementController</code> controller.
 *
 * @see pm7.web.RequirementController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class RequirementControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editRequirementReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirementStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirementStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirementStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirementStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirementStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirementStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirementStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirementStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirementStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirementStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirementStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirementStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirementStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirementStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirementStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirementStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirementStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirementStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listRequirementStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistRequirementStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listRequirementStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>requirementControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetrequirementControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/requirementController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		RequirementController controller = (RequirementController) context.getBean("RequirementController");

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