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
import tsw.domain.Programresource;
import tsw.domain.Sport;
import tsw.domain.Teamplayers;
import tsw.domain.Tswacct;
import tsw.domain.Users;

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
public class ProgramServiceTest {

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
	protected ProgramService service;

	/**
	 * Instantiates a new ProgramServiceTest.
	 *
	 */
	public ProgramServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteProgram() {
		// DO: JUnit - Populate test inputs for operation: deleteProgram 
		Program program = new tsw.domain.Program();
		service.deleteProgram(program);
	}

	/**
	 * Operation Unit Test
	 * Return all Program entity
	 * 
	 */
	@Test
	public void findAllPrograms() {
		// DO: JUnit - Populate test inputs for operation: findAllPrograms 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Program> response = null;
		Tswacct tswacct = null;
		response = service.findAllPrograms4tsw(tswacct, startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllPrograms
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findProgramByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findProgramByPrimaryKey 
		Integer programId = 0;
		@SuppressWarnings("unused")
		Program response = null;
		response = service.findProgramByPrimaryKey(programId);
		// DO: JUnit - Add assertions to test outputs of operation: findProgramByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Load an existing Program entity
	 * 
	 */
	@Test
	public void loadPrograms() {
		@SuppressWarnings("unused")
		Set<Program> response = null;
		Tswacct tswacct = null;
		response = service.loadPrograms4tsw(tswacct);
		// DO: JUnit - Add assertions to test outputs of operation: loadPrograms
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveProgramTswacct() {
		// DO: JUnit - Populate test inputs for operation: saveProgramTswacct 
		Integer programId_1 = 0;
		Tswacct related_tswacct = new tsw.domain.Tswacct();
		@SuppressWarnings("unused")
		Program response = null;
		response = service.saveProgramTswacct(programId_1, related_tswacct);
		// DO: JUnit - Add assertions to test outputs of operation: saveProgramTswacct
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteProgramTswacct() {
		// DO: JUnit - Populate test inputs for operation: deleteProgramTswacct 
		Integer program_programId = 0;
		Integer related_tswacct_tswAcctId = 0;
		@SuppressWarnings("unused")
		Program response = null;
		response = service.deleteProgramTswacct(program_programId, related_tswacct_tswAcctId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteProgramTswacct
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sport entity
	 * 
	 */
	@Test
	public void saveProgramSport() {
		// DO: JUnit - Populate test inputs for operation: saveProgramSport 
		Integer programId_2 = 0;
		Sport related_sport = new tsw.domain.Sport();
		@SuppressWarnings("unused")
		Program response = null;
		response = service.saveProgramSport(programId_2, related_sport);
		// DO: JUnit - Add assertions to test outputs of operation: saveProgramSport
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteProgramGames() {
		// DO: JUnit - Populate test inputs for operation: deleteProgramGames 
		Integer program_programId_1 = 0;
		Integer related_games_gameId = 0;
		@SuppressWarnings("unused")
		Program response = null;
		response = service.deleteProgramGames(program_programId_1, related_games_gameId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteProgramGames
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Programresource entity
	 * 
	 */
	@Test
	public void deleteProgramProgramresources() {
		// DO: JUnit - Populate test inputs for operation: deleteProgramProgramresources 
		Integer program_programId_2 = 0;
		Integer related_programresources_programResourceId = 0;
		@SuppressWarnings("unused")
		Program response = null;
		response = service.deleteProgramProgramresources(program_programId_2, related_programresources_programResourceId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteProgramProgramresources
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveProgramGames() {
		// DO: JUnit - Populate test inputs for operation: saveProgramGames 
		Integer programId_3 = 0;
		Game related_games = new tsw.domain.Game();
		@SuppressWarnings("unused")
		Game response = null;
		Integer refId = null;
		Tswacct tswacct = null;
		Integer homeTeamId = null;
		Integer visitorTeamId = null;
		Integer resIdKey = null;
		response = service.saveProgramGames(tswacct, programId_3, homeTeamId, visitorTeamId, refId, resIdKey, related_games);
		// DO: JUnit - Add assertions to test outputs of operation: saveProgramGames
	}

	/**
	 * Operation Unit Test
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Test
	public void saveProgramTeamplayerses() {
		// DO: JUnit - Populate test inputs for operation: saveProgramTeamplayerses 
		Integer programId_4 = 0;
		Teamplayers related_teamplayerses = new tsw.domain.Teamplayers();
		@SuppressWarnings("unused")
		Program response = null;
		response = service.saveProgramTeamplayerses(programId_4, related_teamplayerses);
		// DO: JUnit - Add assertions to test outputs of operation: saveProgramTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Save an existing Programresource entity
	 * 
	 */
	@Test
	public void saveProgramProgramresources() {
		// DO: JUnit - Populate test inputs for operation: saveProgramProgramresources 
		Integer programId_5 = 0;
		Programresource related_programresources = new tsw.domain.Programresource();
		@SuppressWarnings("unused")
		Program response = null;
		response = service.saveProgramProgramresources(programId_5, related_programresources);
		// DO: JUnit - Add assertions to test outputs of operation: saveProgramProgramresources
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveProgram() {
		// DO: JUnit - Populate test inputs for operation: saveProgram 
		Program program_1 = new tsw.domain.Program();
		Integer selected_id8 = null;
		Integer selected_id1 = null;
		Users user4session = null;
		Integer selected_id11 = null;
		Integer selected_id4 = null;
		Integer selected_sport_id1 = null;
		service.saveProgram(user4session, program_1, selected_id1, selected_id4, selected_id8, selected_id11, selected_sport_id1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Test
	public void deleteProgramTeamplayerses() {
		// DO: JUnit - Populate test inputs for operation: deleteProgramTeamplayerses 
		Integer program_programId_3 = 0;
		Integer related_teamplayerses_teamPlayersId = 0;
		@SuppressWarnings("unused")
		Program response = null;
		response = service.deleteProgramTeamplayerses(program_programId_3, related_teamplayerses_teamPlayersId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteProgramTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Program entity
	 * 
	 */
	@Test
	public void countPrograms() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countPrograms();
		// DO: JUnit - Add assertions to test outputs of operation: countPrograms
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sport entity
	 * 
	 */
	@Test
	public void deleteProgramSport() {
		// DO: JUnit - Populate test inputs for operation: deleteProgramSport 
		Integer program_programId_4 = 0;
		Integer related_sport_sportId = 0;
		@SuppressWarnings("unused")
		Program response = null;
		response = service.deleteProgramSport(program_programId_4, related_sport_sportId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteProgramSport
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
