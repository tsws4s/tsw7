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
 * Unit test for the <code>ClientController</code> controller.
 *
 * @see pm7.web.ClientController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class ClientControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editClientPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClientAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClientInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClientProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClientPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClientPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClientPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClientPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClientPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClientPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClientPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClientPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClientPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClientPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClientPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClientPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClientPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClientPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClientPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClientPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClientPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClientPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listClientPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistClientPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listClientPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>clientControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetclientControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/clientController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ClientController controller = (ClientController) context.getBean("ClientController");

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