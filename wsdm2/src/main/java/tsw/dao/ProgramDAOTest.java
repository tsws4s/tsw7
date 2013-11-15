package tsw.dao;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.annotation.Rollback;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import org.springframework.transaction.annotation.Transactional;

import tsw.domain.Program;

/**
 * Class used to test the basic Data Store Functionality
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = {
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
public class ProgramDAOTest {
	/**
	 * The DAO being tested, injected by Spring
	 *
	 */
	private ProgramDAO dataStore;

	/**
	 * Instantiates a new ProgramDAOTest.
	 *
	 */
	public ProgramDAOTest() {
	}

	/**
	 * Method to test Program domain object.
	 *
	 */
	@Rollback(false)
	@Test
	public void Program() {
		Program instance = new Program();

		// Test create				
		// DO: Populate instance for create.  The store will fail if the primary key fields are blank.				

		// store the object
		dataStore.store(instance);

		// Test update
		// DO: Modify non-key domain object values for update

		// update the object
		dataStore.store(instance);

		// Test delete
		dataStore.remove(instance);

	}

	/**
	 * Method to allow Spring to inject the DAO that will be tested
	 *
	 */
	@Autowired
	public void setDataStore(ProgramDAO dataStore) {
		this.dataStore = dataStore;
	}
}
