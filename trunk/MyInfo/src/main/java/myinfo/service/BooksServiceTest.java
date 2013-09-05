package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.Books;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;

import org.springframework.context.ApplicationContext;

import org.springframework.mock.web.MockHttpServletRequest;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.RequestScope;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.SessionScope;

/**
 * Class to run the service as a JUnit test. Each operation in the service is a separate test.
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@ContextConfiguration(locations = {
		"file:./src/main/resources/MyInfo-security-context.xml",
		"file:./src/main/resources/MyInfo-service-context.xml",
		"file:./src/main/resources/MyInfo-dao-context.xml",
		"file:./src/main/resources/MyInfo-web-context.xml" })
@Transactional
public class BooksServiceTest {

	/**
	 * The Spring application context.
	 *
	 */
	@SuppressWarnings("unused")
	private ApplicationContext context;

	/**
	 * The service being tested, injected by Spring.
	 *
	 */
	@Autowired
	protected BooksService service;

	/**
	 * Instantiates a new BooksServiceTest.
	 *
	 */
	public BooksServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Books entity
	 * 
	 */
	@Test
	public void deleteBooks() {
		// TODO: JUnit - Populate test inputs for operation: deleteBooks 
		Books books = new myinfo.domain.Books();
		service.deleteBooks(books);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Books entity
	 * 
	 */
	@Test
	public void saveBooks() {
		// TODO: JUnit - Populate test inputs for operation: saveBooks 
		Books books_1 = new myinfo.domain.Books();
		service.saveBooks(books_1);
	}

	/**
	 * Operation Unit Test
	 * Return all Books entity
	 * 
	 */
	@Test
	public void findAllBookss() {
		// TODO: JUnit - Populate test inputs for operation: findAllBookss 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Books> response = null;
		response = service.findAllBookss(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllBookss
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findBooksByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findBooksByPrimaryKey 
		Integer bookId = 0;
		Books response = null;
		response = service.findBooksByPrimaryKey(bookId);
		// TODO: JUnit - Add assertions to test outputs of operation: findBooksByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Books entity
	 * 
	 */
	@Test
	public void countBookss() {
		Integer response = null;
		response = service.countBookss();
		// TODO: JUnit - Add assertions to test outputs of operation: countBookss
	}

	/**
	 * Operation Unit Test
	 * Load an existing Books entity
	 * 
	 */
	@Test
	public void loadBookss() {
		Set<Books> response = null;
		response = service.loadBookss();
		// TODO: JUnit - Add assertions to test outputs of operation: loadBookss
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
	 * Sets Up the Request context
	 *
	 */
	private void setupRequestContext() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		ServletRequestAttributes attributes = new ServletRequestAttributes(request);
		RequestContextHolder.setRequestAttributes(attributes);
	}
}
