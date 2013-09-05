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
 * Unit test for the <code>ProjectController</code> controller.
 *
 * @see pm7.web.ProjectController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class ProjectControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editProjectPersonByFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectPersonByFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectPersonByFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectPersonByFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectPersonByFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectPersonByFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectPersonByFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectPersonByFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectPersonByFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectPersonByFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectPersonByFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectPersonByFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectPersonByFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectPersonByFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectPersonByFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectPersonByFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectPersonByFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectPersonByFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectPersonByFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectPersonByFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectPersonByFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectPersonByFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectPersonByFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectPersonByFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectPersonByFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectPersonByFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectPersonByFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectPersonByFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectPersonByFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectPersonByFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectPersonByFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectPersonByFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectPersonByFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectPersonByFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectPersonByFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectPersonByFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectPersonByFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectPersonByFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectPersonByFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectPersonByFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectPersonByFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectPersonByFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProjectChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProjectChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProjectChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProjectChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProjectChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProjectChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProjectChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProjectChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProjectChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProjectChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProjectChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProjectChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProjectChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProjectChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProjectChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProjectChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProjectChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProjectChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listProjectChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistProjectChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listProjectChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>projectControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetprojectControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/projectController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ProjectController controller = (ProjectController) context.getBean("ProjectController");

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