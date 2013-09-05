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
 * Unit test for the <code>ChangerequestController</code> controller.
 *
 * @see pm7.web.ChangerequestController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class ChangerequestControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editChangerequestReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestRequirement()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestRequirement() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestRequirement");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestTestcases()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestTestcases() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestTestcases");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestTasks()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestTasks() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestTasks");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequestAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequestAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequestAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequestAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequestAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequestAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequestAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequestAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequestAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequestAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequestAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequestAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequestAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequestAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequestAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequestAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequestAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequestAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listChangerequestAttachments()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistChangerequestAttachments() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listChangerequestAttachments");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteChangerequest()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteChangerequest() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteChangerequest");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>changerequestControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetchangerequestControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/changerequestController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ChangerequestController controller = (ChangerequestController) context.getBean("ChangerequestController");

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