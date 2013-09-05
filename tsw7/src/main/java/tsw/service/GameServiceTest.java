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
import tsw.domain.Gamestats;
import tsw.domain.Program;
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
public class GameServiceTest {

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
	protected GameService service;

	/**
	 * Instantiates a new GameServiceTest.
	 *
	 */
	public GameServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteGameProgram() {
		// DO: JUnit - Populate test inputs for operation: deleteGameProgram 
		Integer game_gameId = 0;
		Integer related_program_programId = 0;
		@SuppressWarnings("unused")
		Game response = service.deleteGameProgram(game_gameId, related_program_programId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteGameProgram
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteGameTswacct() {
		// DO: JUnit - Populate test inputs for operation: deleteGameTswacct 
		Integer game_gameId_1 = 0;
		Integer related_tswacct_tswAcctId = 0;
		@SuppressWarnings("unused")
		Game response = null;
		response = service.deleteGameTswacct(game_gameId_1, related_tswacct_tswAcctId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteGameTswacct
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveGameProgram() {
		// DO: JUnit - Populate test inputs for operation: saveGameProgram 
		Integer gameId = 0;
		Program related_program = new tsw.domain.Program();
		@SuppressWarnings("unused")
		Game response = null;
		response = service.saveGameProgram(gameId, related_program);
		// DO: JUnit - Add assertions to test outputs of operation: saveGameProgram
	}

	/**
	 * Operation Unit Test
	 * Load an existing Game entity
	 * 
	 */
	@Test
	public void loadGames() {
		@SuppressWarnings("unused")
		Set<Game> response = null;
		Tswacct tswacct = null;
		response = service.loadGames4tsw(tswacct);
		// DO: JUnit - Add assertions to test outputs of operation: loadGames
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveGameTswacct() {
		// DO: JUnit - Populate test inputs for operation: saveGameTswacct 
		Integer gameId_1 = 0;
		Tswacct related_tswacct = new tsw.domain.Tswacct();
		@SuppressWarnings("unused")
		Game response = null;
		response = service.saveGameTswacct(gameId_1, related_tswacct);
		// DO: JUnit - Add assertions to test outputs of operation: saveGameTswacct
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Gamestats entity
	 * 
	 */
	@Test
	public void deleteGameGamestatses() {
		// DO: JUnit - Populate test inputs for operation: deleteGameGamestatses 
		Integer game_gameId_2 = 0;
		Integer related_gamestatses_gameStatsId = 0;
		@SuppressWarnings("unused")
		Game response = null;
		response = service.deleteGameGamestatses(game_gameId_2, related_gamestatses_gameStatsId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteGameGamestatses
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveGame() {
		// DO: JUnit - Populate test inputs for operation: saveGame 
		Game game = new tsw.domain.Game();
		Tswacct tswAcct = null;
		service.saveGame(tswAcct, game, null);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Gamestats entity
	 * 
	 */
	@Test
	public void saveGameGamestatses() {
		// DO: JUnit - Populate test inputs for operation: saveGameGamestatses 
		Integer gameId_2 = 0;
		Gamestats related_gamestatses = new tsw.domain.Gamestats();
		@SuppressWarnings("unused")
		Game response = null;
		response = service.saveGameGamestatses(gameId_2, related_gamestatses, null, null);
		// DO: JUnit - Add assertions to test outputs of operation: saveGameGamestatses
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Game entity
	 * 
	 */
	@Test
	public void countGames() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countGames();
		// DO: JUnit - Add assertions to test outputs of operation: countGames
	}

	/**
	 * Operation Unit Test
	 * Return all Game entity
	 * 
	 */
	@Test
	public void findAllGames() {
		// DO: JUnit - Populate test inputs for operation: findAllGames 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Game> response = null;
		Tswacct tswacct = null;
		response = service.findAllGames4tsw(tswacct, startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllGames
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findGameByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findGameByPrimaryKey 
		Integer gameId_3 = 0;
		@SuppressWarnings("unused")
		Game response = null;
		response = service.findGameByPrimaryKey(gameId_3);
		// DO: JUnit - Add assertions to test outputs of operation: findGameByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteGame() {
		// DO: JUnit - Populate test inputs for operation: deleteGame 
		Game game_1 = new tsw.domain.Game();
		service.deleteGame(game_1);
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
