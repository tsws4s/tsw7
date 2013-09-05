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
 * Unit test for the <code>ReleaseplanController</code> controller.
 *
 * @see pm7.web.ReleaseplanController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class ReleaseplanControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editReleaseplanAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplanAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplanAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplanAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplanAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplanAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplanAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplanAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplanAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplanAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplanAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplanAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplanAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplanAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplanAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplanAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplanAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplanAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReleaseplanAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReleaseplanAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReleaseplanAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReleaseplanProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplanProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplanProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplanProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplanProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplanProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplanProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplanProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplanProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplanProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplanProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplanProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplanProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplanProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplanProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplanProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplanProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplanProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReleaseplanProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReleaseplanProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReleaseplanProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReleaseplanFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplanFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplanFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplanFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplanFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplanFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplanFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplanFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplanFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplanFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplanFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplanFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplanFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplanFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplanFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplanFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplanFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplanFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReleaseplanFeatures()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReleaseplanFeatures() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReleaseplanFeatures");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReleaseplanDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplanDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplanDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplanDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplanDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplanDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplanDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplanDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplanDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplanDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplanDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplanDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplanDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplanDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplanDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplanDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplanDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplanDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReleaseplanDefects()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReleaseplanDefects() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReleaseplanDefects");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReleaseplanRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplanRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplanRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplanRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplanRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplanRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplanRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplanRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplanRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplanRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplanRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplanRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplanRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplanRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplanRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplanRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplanRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplanRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReleaseplanRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReleaseplanRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReleaseplanRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReleaseplanStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplanStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplanStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplanStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplanStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplanStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplanStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplanStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplanStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplanStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplanStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplanStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplanStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplanStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplanStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplanStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplanStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplanStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReleaseplanStatusupdates()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReleaseplanStatusupdates() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReleaseplanStatusupdates");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReleaseplanChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplanChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplanChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplanChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplanChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplanChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplanChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplanChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplanChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplanChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplanChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplanChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplanChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplanChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplanChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplanChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplanChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplanChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listReleaseplanChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistReleaseplanChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listReleaseplanChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>releaseplanControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetreleaseplanControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/releaseplanController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		ReleaseplanController controller = (ReleaseplanController) context.getBean("ReleaseplanController");

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