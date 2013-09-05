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
 * Unit test for the <code>AccountController</code> controller.
 *
 * @see pm7.web.AccountController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class AccountControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editAccountPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountProjectteams()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountProjectteams() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountProjectteams");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountClients()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountClients() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountClients");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountProjecttemplates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountProjecttemplates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountProjecttemplates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountTestcasesteps()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountTestcasesteps() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountTestcasesteps");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountReleaseplans()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountReleaseplans() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountReleaseplans");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountTimeentries()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountTimeentries() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountTimeentries");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountUsers()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountUsers() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountUsers");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountProjects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountProjects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountProjects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountPersons()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountPersons() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountPersons");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountInvoices()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountInvoices() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountInvoices");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccountDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccountDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccountDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccountDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccountDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccountDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccountDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccountDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccountDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccountDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccountDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccountDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccountDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccountDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccountDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccountDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccountDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccountDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAccountDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAccountDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAccountDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>accountControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetaccountControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/accountController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AccountController controller = (AccountController) context.getBean("AccountController");

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