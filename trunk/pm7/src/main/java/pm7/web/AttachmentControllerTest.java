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
 * Unit test for the <code>AttachmentController</code> controller.
 *
 * @see pm7.web.AttachmentController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class AttachmentControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editAttachmentTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachmentPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentPerson()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentPerson() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentPerson");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachmentAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachmentChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachmentDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachmentRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachmentStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentStatusupdate()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentStatusupdate() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentStatusupdate");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachmentProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachmentProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachmentProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachmentProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachmentProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachmentProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachmentProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachmentProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachmentProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachmentProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachmentProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachmentProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachmentProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachmentProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachmentProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachmentProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachmentProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachmentProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listAttachmentProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistAttachmentProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listAttachmentProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexAttachment()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexAttachment() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexAttachment");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectAttachment()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectAttachment() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectAttachment");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editAttachment()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditAttachment() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editAttachment");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveAttachment()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveAttachment() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveAttachment");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newAttachment()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewAttachment() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newAttachment");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteAttachment()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteAttachment() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteAttachment");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteAttachment()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteAttachment() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteAttachment");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>attachmentControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetattachmentControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/attachmentController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		AttachmentController controller = (AttachmentController) context.getBean("AttachmentController");

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