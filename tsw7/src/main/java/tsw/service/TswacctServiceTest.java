package tsw.service;

import java.util.List;
import java.util.Set;

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

import tsw.domain.Game;
import tsw.domain.Program;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;

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
		"file:./resources/tsw4-security-context.xml",
		"file:./resources/tsw4-service-context.xml",
		"file:./resources/tsw4-dao-context.xml",
		"file:./resources/tsw4-web-context.xml" })
@Transactional
public class TswacctServiceTest {

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
	protected TswacctService service;

	/**
	 * Instantiates a new TswacctServiceTest.
	 *
	 */
	public TswacctServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Test
	public void deleteTswacctTeamplayerses() {
		// DO: JUnit - Populate test inputs for operation: deleteTswacctTeamplayerses 
		Integer tswacct_tswAcctId = 0;
		Integer related_teamplayerses_teamPlayersId = 0;
		@SuppressWarnings("unused")
		Tswacct response = null;
		response = service.deleteTswacctTeamplayerses(tswacct_tswAcctId, related_teamplayerses_teamPlayersId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteTswacctTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveTswacctPrograms() {
		// DO: JUnit - Populate test inputs for operation: saveTswacctPrograms 
		Integer tswAcctId = 0;
		Program related_programs = new tsw.domain.Program();
		@SuppressWarnings("unused")
		Tswacct response = null;
		response = service.saveTswacctPrograms(tswAcctId, related_programs);
		// DO: JUnit - Add assertions to test outputs of operation: saveTswacctPrograms
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveTswacctGames() {
		// DO: JUnit - Populate test inputs for operation: saveTswacctGames 
		Integer tswAcctId_1 = 0;
		Game related_games = new tsw.domain.Game();
		@SuppressWarnings("unused")
		Tswacct response = null;
		response = service.saveTswacctGames(tswAcctId_1, related_games);
		// DO: JUnit - Add assertions to test outputs of operation: saveTswacctGames
	}

	/**
	 * Operation Unit Test
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Test
	public void saveTswacctTeamplayerses() {
		// DO: JUnit - Populate test inputs for operation: saveTswacctTeamplayerses 
		Integer tswAcctId_2 = 0;
		Teamplayers related_teamplayerses = new tsw.domain.Teamplayers();
		@SuppressWarnings("unused")
		Tswacct response = null;
		response = service.saveTswacctTeamplayerses(tswAcctId_2, related_teamplayerses);
		// DO: JUnit - Add assertions to test outputs of operation: saveTswacctTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Load an existing Tswacct entity
	 * 
	 */
	@Test
	public void loadTswaccts() {
		@SuppressWarnings("unused")
		Set<Tswacct> response = null;
		response = service.loadTswaccts();
		// DO: JUnit - Add assertions to test outputs of operation: loadTswaccts
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findTswacctByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findTswacctByPrimaryKey 
		Integer tswAcctId_3 = 0;
		@SuppressWarnings("unused")
		Tswacct response = null;
		response = service.findTswacctByPrimaryKey(tswAcctId_3);
		// DO: JUnit - Add assertions to test outputs of operation: findTswacctByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Tswacct entity
	 * 
	 */
	@Test
	public void countTswaccts() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countTswaccts();
		// DO: JUnit - Add assertions to test outputs of operation: countTswaccts
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteTswacct() {
		// DO: JUnit - Populate test inputs for operation: deleteTswacct 
		Tswacct tswacct = new tsw.domain.Tswacct();
		service.deleteTswacct(tswacct);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveTswacct() {
		// DO: JUnit - Populate test inputs for operation: saveTswacct 
		Tswacct tswacct_1 = new tsw.domain.Tswacct();
		Integer tswAcct = null;
		service.saveTswacct(tswacct_1, tswAcct);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteTswacctGames() {
		// DO: JUnit - Populate test inputs for operation: deleteTswacctGames 
		Integer tswacct_tswAcctId_1 = 0;
		Integer related_games_gameId = 0;
		@SuppressWarnings("unused")
		Tswacct response = null;
		response = service.deleteTswacctGames(tswacct_tswAcctId_1, related_games_gameId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteTswacctGames
	}

	/**
	 * Operation Unit Test
	 * Return all Tswacct entity
	 * 
	 */
	@Test
	public void findAllTswaccts() {
		// DO: JUnit - Populate test inputs for operation: findAllTswaccts 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Tswacct> response = null;
		response = service.findAllTswaccts(startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllTswaccts
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteTswacctPrograms() {
		// DO: JUnit - Populate test inputs for operation: deleteTswacctPrograms 
		Integer tswacct_tswAcctId_2 = 0;
		Integer related_programs_programId = 0;
		@SuppressWarnings("unused")
		Tswacct response = null;
		response = service.deleteTswacctPrograms(tswacct_tswAcctId_2, related_programs_programId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteTswacctPrograms
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
