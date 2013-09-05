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
 * Unit test for the <code>FeatureController</code> controller.
 *
 * @see pm7.web.FeatureController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class FeatureControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editFeatureReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditFeatureReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editFeatureReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newFeatureReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewFeatureReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newFeatureReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveFeatureReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveFeatureReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveFeatureReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteFeatureReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteFeatureReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteFeatureReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteFeatureReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteFeatureReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteFeatureReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectFeatureReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectFeatureReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectFeatureReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listFeatureReleaseplan()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistFeatureReleaseplan() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listFeatureReleaseplan");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editFeatureAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditFeatureAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editFeatureAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newFeatureAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewFeatureAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newFeatureAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveFeatureAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveFeatureAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveFeatureAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteFeatureAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteFeatureAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteFeatureAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteFeatureAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteFeatureAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteFeatureAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectFeatureAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectFeatureAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectFeatureAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listFeatureAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistFeatureAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listFeatureAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editFeatureProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditFeatureProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editFeatureProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newFeatureProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewFeatureProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newFeatureProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveFeatureProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveFeatureProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveFeatureProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteFeatureProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteFeatureProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteFeatureProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteFeatureProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteFeatureProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteFeatureProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectFeatureProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectFeatureProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectFeatureProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listFeatureProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistFeatureProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listFeatureProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editFeatureChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditFeatureChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editFeatureChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newFeatureChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewFeatureChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newFeatureChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveFeatureChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveFeatureChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveFeatureChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteFeatureChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteFeatureChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteFeatureChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteFeatureChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteFeatureChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteFeatureChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectFeatureChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectFeatureChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectFeatureChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listFeatureChangerequests()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistFeatureChangerequests() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listFeatureChangerequests");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editFeatureRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditFeatureRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editFeatureRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newFeatureRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewFeatureRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newFeatureRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveFeatureRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveFeatureRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveFeatureRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteFeatureRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteFeatureRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteFeatureRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteFeatureRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteFeatureRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteFeatureRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectFeatureRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectFeatureRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectFeatureRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listFeatureRequirements()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistFeatureRequirements() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listFeatureRequirements");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteFeature()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteFeature() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteFeature");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>featureControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetfeatureControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/featureController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		FeatureController controller = (FeatureController) context.getBean("FeatureController");

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