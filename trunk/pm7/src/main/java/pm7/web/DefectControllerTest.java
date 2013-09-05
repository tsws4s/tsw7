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
 * Unit test for the <code>DefectController</code> controller.
 *
 * @see pm7.web.DefectController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class DefectControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editDefectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectTestcase()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectTestcase() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectTestcase");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listDefectTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistDefectTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listDefectTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteDefect()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteDefect() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteDefect");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>defectControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdefectControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/defectController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		DefectController controller = (DefectController) context.getBean("DefectController");

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