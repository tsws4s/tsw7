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
 * Unit test for the <code>InvoiceController</code> controller.
 *
 * @see pm7.web.InvoiceController
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"file:./src/main/resources/pm7-security-context.xml",
		"file:./src/main/resources/pm7-service-context.xml",
		"file:./src/main/resources/pm7-dao-context.xml",
		"file:./src/main/resources/pm7-web-context.xml" })
public class InvoiceControllerTest {
	/**
	 * The Spring application context.
	 *
	 */
	private ApplicationContext context;

	/**
	 * Test <code>editInvoiceAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInvoiceAccount()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInvoiceAccount() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInvoiceAccount");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInvoiceClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInvoiceClient()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInvoiceClient() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInvoiceClient");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInvoiceProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInvoiceProject()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInvoiceProject() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInvoiceProject");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInvoiceInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoiceInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoiceInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoiceInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoiceInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoiceInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoiceInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoiceInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoiceInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoiceInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoiceInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoiceInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoiceInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoiceInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoiceInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoiceInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoiceInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoiceInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>listInvoiceInvoiceitems()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetlistInvoiceInvoiceitems() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/listInvoiceInvoiceitems");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>indexInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetindexInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/indexInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>selectInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetselectInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/selectInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>editInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GeteditInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/editInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>saveInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetsaveInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/saveInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>newInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetnewInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/newInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>confirmDeleteInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetconfirmDeleteInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/confirmDeleteInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>deleteInvoice()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetdeleteInvoice() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/deleteInvoice");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

		// TODO Invoke method and Assert return values

	}

	/**
	 * Test <code>invoiceControllerbinaryaction()</code>.
	 */
	@Test
	@SuppressWarnings("unused")
	public void GetinvoiceControllerbinaryaction() throws Exception {
		MockHttpServletRequest request = getMockHttpServletRequest();
		request.setRequestURI("/invoiceController/binary.action");
		MockHttpServletResponse response = getMockHttpServletResponse();

		// Get the singleton controller instance
		InvoiceController controller = (InvoiceController) context.getBean("InvoiceController");

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