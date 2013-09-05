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
 * Unit test for the <code>PersonController</code> controller.
 *
 * @see pm7.web.PersonController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class PersonControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editPersonAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonAccounts()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonAccounts() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonAccounts");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonAccounts()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonAccounts() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonAccounts");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonAccounts()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonAccounts() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonAccounts");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonAccounts()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonAccounts() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonAccounts");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonAccounts()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonAccounts() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonAccounts");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonAccounts()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonAccounts() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonAccounts");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonAccounts()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonAccounts() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonAccounts");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonProjectsForFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonProjectsForFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonProjectsForFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonProjectsForFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonProjectsForFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonProjectsForFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonProjectsForFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonProjectsForFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonProjectsForFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonProjectsForFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonProjectsForFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonProjectsForFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonProjectsForFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonProjectsForFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonProjectsForFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonProjectsForFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonProjectsForFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonProjectsForFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonProjectsForFkContactPersonId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonProjectsForFkContactPersonId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonProjectsForFkContactPersonId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPersonProjectsForFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPersonProjectsForFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPersonProjectsForFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPersonProjectsForFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPersonProjectsForFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPersonProjectsForFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePersonProjectsForFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePersonProjectsForFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePersonProjectsForFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePersonProjectsForFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePersonProjectsForFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePersonProjectsForFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePersonProjectsForFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePersonProjectsForFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePersonProjectsForFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPersonProjectsForFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPersonProjectsForFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPersonProjectsForFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listPersonProjectsForFkProjMgrId()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistPersonProjectsForFkProjMgrId() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listPersonProjectsForFkProjMgrId");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>savePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsavePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/savePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeletePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeletePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeletePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deletePerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeletePerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deletePerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>personControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetpersonControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/personController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		PersonController controller = (PersonController) context.getBean("PersonController");

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