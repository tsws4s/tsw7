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
 * Unit test for the <code>MyInfoController</code> controller.
 *
 * @see myinfo.web.MyInfoController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
public class MyInfoControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>indexMyInfo()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexMyInfo() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexMyInfo");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectMyInfo()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectMyInfo() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectMyInfo");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editMyInfo()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditMyInfo() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editMyInfo");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveMyInfo()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveMyInfo() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveMyInfo");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newMyInfo()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewMyInfo() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newMyInfo");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteMyInfo()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteMyInfo() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteMyInfo");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteMyInfo()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteMyInfo() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteMyInfo");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>myinfoControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetmyinfoControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/myinfoController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		MyInfoController controller = (MyInfoController) context.getBean("MyInfoController");

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