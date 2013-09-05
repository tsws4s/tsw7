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
 * Unit test for the <code>TaskController</code> controller.
 *
 * @see pm7.web.TaskController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class TaskControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editTaskTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTaskStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTaskStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTaskStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTaskStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTaskStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTaskStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTaskStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTaskStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTaskStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTaskStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTaskStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTaskStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTaskStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTaskStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTaskStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTaskStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTaskStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTaskStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listTaskStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistTaskStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listTaskStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteTask()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteTask() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteTask");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>taskControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GettaskControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/taskController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		TaskController controller = (TaskController) context.getBean("TaskController");

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