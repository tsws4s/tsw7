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
 * Unit test for the <code>InvoiceitemController</code> controller.
 *
 * @see pm7.web.InvoiceitemController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class InvoiceitemControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editInvoiceitemAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceitemAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceitemAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceitemAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceitemAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceitemAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceitemAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceitemAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceitemAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceitemAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceitemAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceitemAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceitemAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceitemAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceitemAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceitemAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceitemAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceitemAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInvoiceitemAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInvoiceitemAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInvoiceitemAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInvoiceitemInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceitemInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceitemInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceitemInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceitemInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceitemInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceitemInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceitemInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceitemInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceitemInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceitemInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceitemInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceitemInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceitemInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceitemInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceitemInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceitemInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceitemInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInvoiceitemInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInvoiceitemInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInvoiceitemInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInvoiceitemProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceitemProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceitemProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceitemProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceitemProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceitemProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceitemProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceitemProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceitemProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceitemProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceitemProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceitemProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceitemProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceitemProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceitemProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceitemProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceitemProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceitemProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInvoiceitemProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInvoiceitemProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInvoiceitemProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexInvoiceitem()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexInvoiceitem() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexInvoiceitem");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceitem()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceitem() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceitem");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInvoiceitem()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceitem() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceitem");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceitem()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceitem() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceitem");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceitem()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceitem() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceitem");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceitem()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceitem() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceitem");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceitem()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceitem() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceitem");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>invoiceitemControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetinvoiceitemControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/invoiceitemController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceitemController controller = (InvoiceitemController) context.getBean("InvoiceitemController");

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