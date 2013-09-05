package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.MyCategory;

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
public class MyCategoryServiceTest {

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
	protected MyCategoryService service;

	/**
	 * Instantiates a new MyCategoryServiceTest.
	 *
	 */
	public MyCategoryServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Return all MyCategory entity
	 * 
	 */
	@Test
	public void findAllMyCategorys() {
		// TODO: JUnit - Populate test inputs for operation: findAllMyCategorys 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<MyCategory> response = null;
		response = service.findAllMyCategorys(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllMyCategorys
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findMyCategoryByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findMyCategoryByPrimaryKey 
		Integer categoryId = 0;
		MyCategory response = null;
		response = service.findMyCategoryByPrimaryKey(categoryId);
		// TODO: JUnit - Add assertions to test outputs of operation: findMyCategoryByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return a count of all MyCategory entity
	 * 
	 */
	@Test
	public void countMyCategorys() {
		Integer response = null;
		response = service.countMyCategorys();
		// TODO: JUnit - Add assertions to test outputs of operation: countMyCategorys
	}

	/**
	 * Operation Unit Test
	 * Delete an existing MyCategory entity
	 * 
	 */
	@Test
	public void deleteMyCategory() {
		// TODO: JUnit - Populate test inputs for operation: deleteMyCategory 
		MyCategory mycategory = new myinfo.domain.MyCategory();
		service.deleteMyCategory(mycategory);
	}

	/**
	 * Operation Unit Test
	 * Load an existing MyCategory entity
	 * 
	 */
	@Test
	public void loadMyCategorys() {
		Set<MyCategory> response = null;
		response = service.loadMyCategorys();
		// TODO: JUnit - Add assertions to test outputs of operation: loadMyCategorys
	}

	/**
	 * Operation Unit Test
	 * Save an existing MyCategory entity
	 * 
	 */
	@Test
	public void saveMyCategory() {
		// TODO: JUnit - Populate test inputs for operation: saveMyCategory 
		MyCategory mycategory_1 = new myinfo.domain.MyCategory();
		service.saveMyCategory(mycategory_1);
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
