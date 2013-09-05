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

import tsw.domain.Gamestats;
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
public class TeamplayersServiceTest {

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
	protected TeamplayersService service;

	/**
	 * Instantiates a new TeamplayersServiceTest.
	 *
	 */
	public TeamplayersServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Test
	public void deleteTeamplayers() {
		// DO: JUnit - Populate test inputs for operation: deleteTeamplayers 
		Teamplayers teamplayers = new tsw.domain.Teamplayers();
		service.deleteTeamplayers(teamplayers);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Gamestats entity
	 * 
	 */
	@Test
	public void saveTeamplayersGamestatses() {
		// DO: JUnit - Populate test inputs for operation: saveTeamplayersGamestatses 
		Integer teamPlayersId = 0;
		Gamestats related_gamestatses = new tsw.domain.Gamestats();
		@SuppressWarnings("unused")
		Teamplayers response = null;
		response = service.saveTeamplayersGamestatses(teamPlayersId, related_gamestatses);
		// DO: JUnit - Add assertions to test outputs of operation: saveTeamplayersGamestatses
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveTeamplayersProgram() {
		// DO: JUnit - Populate test inputs for operation: saveTeamplayersProgram 
		Integer teamPlayersId_1 = 0;
		Program related_program = new tsw.domain.Program();
		@SuppressWarnings("unused")
		Teamplayers response = null;
		response = service.saveTeamplayersProgram(teamPlayersId_1, related_program);
		// DO: JUnit - Add assertions to test outputs of operation: saveTeamplayersProgram
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Teamplayers entity
	 * 
	 */
	@Test
	public void countTeamplayerss() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countTeamplayerss();
		// DO: JUnit - Add assertions to test outputs of operation: countTeamplayerss
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveTeamplayersTswacct() {
		// DO: JUnit - Populate test inputs for operation: saveTeamplayersTswacct 
		Integer teamPlayersId_2 = 0;
		Tswacct related_tswacct = new tsw.domain.Tswacct();
		@SuppressWarnings("unused")
		Teamplayers response = null;
		response = service.saveTeamplayersTswacct(teamPlayersId_2, related_tswacct);
		// DO: JUnit - Add assertions to test outputs of operation: saveTeamplayersTswacct
	}

	/**
	 * Operation Unit Test
	 * Return all Teamplayers entity
	 * 
	 */
	@Test
	public void findAllTeamplayerss() {
		// DO: JUnit - Populate test inputs for operation: findAllTeamplayerss 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Teamplayers> response = null;
		Tswacct tswacct = null;
		response = service.findAllTeamplayerss4tsw(tswacct, startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllTeamplayerss
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteTeamplayersTswacct() {
		// DO: JUnit - Populate test inputs for operation: deleteTeamplayersTswacct 
		Integer teamplayers_teamPlayersId = 0;
		Integer related_tswacct_tswAcctId = 0;
		@SuppressWarnings("unused")
		Teamplayers response = null;
		response = service.deleteTeamplayersTswacct(teamplayers_teamPlayersId, related_tswacct_tswAcctId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteTeamplayersTswacct
	}

	/**
	 * Operation Unit Test
	 * Load an existing Teamplayers entity
	 * 
	 */
	@Test
	public void loadTeamplayerss() {
		@SuppressWarnings("unused")
		Set<Teamplayers> response = null;
		Tswacct tswacct = null;
		response = service.loadTeamplayerss4tsw(tswacct);
		// DO: JUnit - Add assertions to test outputs of operation: loadTeamplayerss
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Gamestats entity
	 * 
	 */
	@Test
	public void deleteTeamplayersGamestatses() {
		// DO: JUnit - Populate test inputs for operation: deleteTeamplayersGamestatses 
		Integer teamplayers_teamPlayersId_1 = 0;
		Integer related_gamestatses_gameStatsId = 0;
		@SuppressWarnings("unused")
		Teamplayers response = null;
		response = service.deleteTeamplayersGamestatses(teamplayers_teamPlayersId_1, related_gamestatses_gameStatsId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteTeamplayersGamestatses
	}

	/**
	 * Operation Unit Test
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Test
	public void saveTeamplayers() {
		// DO: JUnit - Populate test inputs for operation: saveTeamplayers 
		Teamplayers teamplayers_1 = new tsw.domain.Teamplayers();
		Tswacct tswAcct = null;
		service.saveTeamplayers(tswAcct, teamplayers_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteTeamplayersProgram() {
		// DO: JUnit - Populate test inputs for operation: deleteTeamplayersProgram 
		Integer teamplayers_teamPlayersId_2 = 0;
		Integer related_program_programId = 0;
		@SuppressWarnings("unused")
		Teamplayers response = null;
		response = service.deleteTeamplayersProgram(teamplayers_teamPlayersId_2, related_program_programId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteTeamplayersProgram
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findTeamplayersByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findTeamplayersByPrimaryKey 
		Integer teamPlayersId_3 = 0;
		@SuppressWarnings("unused")
		Teamplayers response = null;
		response = service.findTeamplayersByPrimaryKey(teamPlayersId_3);
		// DO: JUnit - Add assertions to test outputs of operation: findTeamplayersByPrimaryKey
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
