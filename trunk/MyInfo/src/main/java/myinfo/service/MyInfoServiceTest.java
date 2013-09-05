package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.MyInfo;

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
public class MyInfoServiceTest {

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
	protected MyInfoService service;

	/**
	 * Instantiates a new MyInfoServiceTest.
	 *
	 */
	public MyInfoServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing MyInfo entity
	 * 
	 */
	@Test
	public void saveMyInfo() {
		// TODO: JUnit - Populate test inputs for operation: saveMyInfo 
		MyInfo myinfo = new myinfo.domain.MyInfo();
		service.saveMyInfo(myinfo);
	}

	/**
	 * Operation Unit Test
	 * Load an existing MyInfo entity
	 * 
	 */
	@Test
	public void loadMyInfos() {
		Set<MyInfo> response = null;
		response = service.loadMyInfos();
		// TODO: JUnit - Add assertions to test outputs of operation: loadMyInfos
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findMyInfoByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findMyInfoByPrimaryKey 
		Integer myInfoId = 0;
		MyInfo response = null;
		response = service.findMyInfoByPrimaryKey(myInfoId);
		// TODO: JUnit - Add assertions to test outputs of operation: findMyInfoByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return all MyInfo entity
	 * 
	 */
	@Test
	public void findAllMyInfos() {
		// TODO: JUnit - Populate test inputs for operation: findAllMyInfos 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<MyInfo> response = null;
		response = service.findAllMyInfos(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllMyInfos
	}

	/**
	 * Operation Unit Test
	 * Return a count of all MyInfo entity
	 * 
	 */
	@Test
	public void countMyInfos() {
		Integer response = null;
		response = service.countMyInfos();
		// TODO: JUnit - Add assertions to test outputs of operation: countMyInfos
	}

	/**
	 * Operation Unit Test
	 * Delete an existing MyInfo entity
	 * 
	 */
	@Test
	public void deleteMyInfo() {
		// TODO: JUnit - Populate test inputs for operation: deleteMyInfo 
		MyInfo myinfo_1 = new myinfo.domain.MyInfo();
		service.deleteMyInfo(myinfo_1);
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
