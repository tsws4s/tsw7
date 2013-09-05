package myinfo.web;

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
 * Unit test for the <code>MyCategoryController</code> controller.
 *
 * @see myinfo.web.MyCategoryController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
public class MyCategoryControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexMyCategory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexMyCategory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexMyCategory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectMyCategory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectMyCategory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectMyCategory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editMyCategory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditMyCategory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editMyCategory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveMyCategory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveMyCategory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveMyCategory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newMyCategory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewMyCategory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newMyCategory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteMyCategory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteMyCategory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteMyCategory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteMyCategory()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteMyCategory() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteMyCategory");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>mycategoryControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetmycategoryControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/mycategoryController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyCategoryController controller = (MyCategoryController) context.getBean("MyCategoryController");

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