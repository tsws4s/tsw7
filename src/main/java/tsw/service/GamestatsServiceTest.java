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
import tsw.domain.Teamplayers;

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
public class GamestatsServiceTest {

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
	protected GamestatsService service;

	/**
	 * Instantiates a new GamestatsServiceTest.
	 *
	 */
	public GamestatsServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Test
	public void deleteGamestatsTeamplayers() {
		// DO: JUnit - Populate test inputs for operation: deleteGamestatsTeamplayers 
		Integer gamestats_gameStatsId = 0;
		Integer related_teamplayers_teamPlayersId = 0;
		@SuppressWarnings("unused")
		Gamestats response = null;
		response = service.deleteGamestatsTeamplayers(gamestats_gameStatsId, related_teamplayers_teamPlayersId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteGamestatsTeamplayers
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Gamestats entity
	 * 
	 */
	@Test
	public void countGamestatss() {
		@SuppressWarnings("unused")
		Integer response = null;
		response = service.countGamestatss();
		// DO: JUnit - Add assertions to test outputs of operation: countGamestatss
	}

	/**
	 * Operation Unit Test
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Test
	public void saveGamestatsTeamplayers() {
		// DO: JUnit - Populate test inputs for operation: saveGamestatsTeamplayers 
		Integer gameStatsId = 0;
		Teamplayers related_teamplayers = new tsw.domain.Teamplayers();
		@SuppressWarnings("unused")
		Gamestats response = null;
		response = service.saveGamestatsTeamplayers(gameStatsId, related_teamplayers);
		// DO: JUnit - Add assertions to test outputs of operation: saveGamestatsTeamplayers
	}

	/**
	 * Operation Unit Test
	 * Return all Gamestats entity
	 * 
	 */
	@Test
	public void findAllGamestatss() {
		// DO: JUnit - Populate test inputs for operation: findAllGamestatss 
		Integer startResult = 0;
		Integer maxRows = 0;
		@SuppressWarnings("unused")
		List<Gamestats> response = null;
		response = service.findAllGamestatss(startResult, maxRows);
		// DO: JUnit - Add assertions to test outputs of operation: findAllGamestatss
	}

	/**
	 * Operation Unit Test
	 * Load an existing Gamestats entity
	 * 
	 */
	@Test
	public void loadGamestatss() {
		@SuppressWarnings("unused")
		Set<Gamestats> response = null;
		response = service.loadGamestatss();
		// DO: JUnit - Add assertions to test outputs of operation: loadGamestatss
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteGamestatsGame() {
		// DO: JUnit - Populate test inputs for operation: deleteGamestatsGame 
		Integer gamestats_gameStatsId_1 = 0;
		Integer related_game_gameId = 0;
		@SuppressWarnings("unused")
		Gamestats response = null;
		response = service.deleteGamestatsGame(gamestats_gameStatsId_1, related_game_gameId);
		// DO: JUnit - Add assertions to test outputs of operation: deleteGamestatsGame
	}

	/**
	 * Operation Unit Test
	 * Save an existing Gamestats entity
	 * 
	 */
	@Test
	public void saveGamestats() {
		// DO: JUnit - Populate test inputs for operation: saveGamestats 
		Gamestats gamestats = new tsw.domain.Gamestats();
		service.saveGamestats(gamestats);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Gamestats entity
	 * 
	 */
	@Test
	public void deleteGamestats() {
		// DO: JUnit - Populate test inputs for operation: deleteGamestats 
		Gamestats gamestats_1 = new tsw.domain.Gamestats();
		service.deleteGamestats(gamestats_1);
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findGamestatsByPrimaryKey() {
		// DO: JUnit - Populate test inputs for operation: findGamestatsByPrimaryKey 
		Integer gameStatsId_1 = 0;
		@SuppressWarnings("unused")
		Gamestats response = null;
		response = service.findGamestatsByPrimaryKey(gameStatsId_1);
		// DO: JUnit - Add assertions to test outputs of operation: findGamestatsByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveGamestatsGame() {
		// DO: JUnit - Populate test inputs for operation: saveGamestatsGame 
		Integer gameStatsId_2 = 0;
		Game related_game = new tsw.domain.Game();
		@SuppressWarnings("unused")
		Gamestats response = null;
		response = service.saveGamestatsGame(gameStatsId_2, related_game);
		// DO: JUnit - Add assertions to test outputs of operation: saveGamestatsGame
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
