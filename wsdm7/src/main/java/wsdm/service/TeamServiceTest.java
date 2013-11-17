package wsdm.service;

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

import wsdm.domain.Customer;
import wsdm.domain.Game;
import wsdm.domain.Level;
import wsdm.domain.Program;
import wsdm.domain.Team;
import wsdm.domain.Teamplayers;
import wsdm.domain.Tswacct;

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
		"file:./src/main/resources/wsdm7-security-context.xml",
		"file:./src/main/resources/wsdm7-service-context.xml",
		"file:./src/main/resources/wsdm7-dao-context.xml",
		"file:./src/main/resources/wsdm7-web-context.xml" })
@Transactional
public class TeamServiceTest {

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
	protected TeamService service;

	/**
	 * Instantiates a new TeamServiceTest.
	 *
	 */
	public TeamServiceTest() {
		setupRequestContext();
	}

	/**
	 * Operation Unit Test
	 * Save an existing Customer entity
	 * 
	 */
	@Test
	public void saveTeamCustomerByCoachCustFk() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamCustomerByCoachCustFk 
		Integer teamId = 0;
		Customer related_customerbycoachcustfk = new wsdm.domain.Customer();
		Team response = null;
		response = service.saveTeamCustomerByCoachCustFk(teamId, related_customerbycoachcustfk);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamCustomerByCoachCustFk
	}

	/**
	 * Operation Unit Test
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveTeamProgram() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamProgram 
		Integer teamId_1 = 0;
		Program related_program = new wsdm.domain.Program();
		Team response = null;
		response = service.saveTeamProgram(teamId_1, related_program);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamProgram
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Customer entity
	 * 
	 */
	@Test
	public void deleteTeamCustomerByCoachCustFk() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamCustomerByCoachCustFk 
		Integer team_teamId = 0;
		Integer related_customerbycoachcustfk_customerId = 0;
		Team response = null;
		response = service.deleteTeamCustomerByCoachCustFk(team_teamId, related_customerbycoachcustfk_customerId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamCustomerByCoachCustFk
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findTeamByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findTeamByPrimaryKey 
		Integer teamId_2 = 0;
		Team response = null;
		response = service.findTeamByPrimaryKey(teamId_2);
		// TODO: JUnit - Add assertions to test outputs of operation: findTeamByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveTeamTswacct() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamTswacct 
		Integer teamId_3 = 0;
		Tswacct related_tswacct = new wsdm.domain.Tswacct();
		Team response = null;
		response = service.saveTeamTswacct(teamId_3, related_tswacct);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamTswacct
	}

	/**
	 * Operation Unit Test
	 * Save an existing Team entity
	 * 
	 */
	@Test
	public void saveTeam() {
		// TODO: JUnit - Populate test inputs for operation: saveTeam 
		Team team = new wsdm.domain.Team();
		service.saveTeam(team);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveTeamGamesForVisitorTeamFk() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamGamesForVisitorTeamFk 
		Integer teamId_4 = 0;
		Game related_gamesforvisitorteamfk = new wsdm.domain.Game();
		Team response = null;
		response = service.saveTeamGamesForVisitorTeamFk(teamId_4, related_gamesforvisitorteamfk);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamGamesForVisitorTeamFk
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteTeamGamesForVisitorTeamFk() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamGamesForVisitorTeamFk 
		Integer team_teamId_1 = 0;
		Integer related_gamesforvisitorteamfk_gameId = 0;
		Team response = null;
		response = service.deleteTeamGamesForVisitorTeamFk(team_teamId_1, related_gamesforvisitorteamfk_gameId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamGamesForVisitorTeamFk
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveTeamGamesForHomeTeamFk() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamGamesForHomeTeamFk 
		Integer teamId_5 = 0;
		Game related_gamesforhometeamfk = new wsdm.domain.Game();
		Team response = null;
		response = service.saveTeamGamesForHomeTeamFk(teamId_5, related_gamesforhometeamfk);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamGamesForHomeTeamFk
	}

	/**
	 * Operation Unit Test
	 * Save an existing Customer entity
	 * 
	 */
	@Test
	public void saveTeamCustomerByManagerCustFk() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamCustomerByManagerCustFk 
		Integer teamId_6 = 0;
		Customer related_customerbymanagercustfk = new wsdm.domain.Customer();
		Team response = null;
		response = service.saveTeamCustomerByManagerCustFk(teamId_6, related_customerbymanagercustfk);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamCustomerByManagerCustFk
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Customer entity
	 * 
	 */
	@Test
	public void deleteTeamCustomerByManagerCustFk() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamCustomerByManagerCustFk 
		Integer team_teamId_2 = 0;
		Integer related_customerbymanagercustfk_customerId = 0;
		Team response = null;
		response = service.deleteTeamCustomerByManagerCustFk(team_teamId_2, related_customerbymanagercustfk_customerId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamCustomerByManagerCustFk
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteTeamProgram() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamProgram 
		Integer team_teamId_3 = 0;
		Integer related_program_programId = 0;
		Team response = null;
		response = service.deleteTeamProgram(team_teamId_3, related_program_programId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamProgram
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Team entity
	 * 
	 */
	@Test
	public void deleteTeam() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeam 
		Team team_1 = new wsdm.domain.Team();
		service.deleteTeam(team_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteTeamGamesForHomeTeamFk() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamGamesForHomeTeamFk 
		Integer team_teamId_4 = 0;
		Integer related_gamesforhometeamfk_gameId = 0;
		Team response = null;
		response = service.deleteTeamGamesForHomeTeamFk(team_teamId_4, related_gamesforhometeamfk_gameId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamGamesForHomeTeamFk
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Team entity
	 * 
	 */
	@Test
	public void countTeams() {
		Integer response = null;
		response = service.countTeams();
		// TODO: JUnit - Add assertions to test outputs of operation: countTeams
	}

	/**
	 * Operation Unit Test
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Test
	public void saveTeamTeamplayerses() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamTeamplayerses 
		Integer teamId_7 = 0;
		Teamplayers related_teamplayerses = new wsdm.domain.Teamplayers();
		Team response = null;
		response = service.saveTeamTeamplayerses(teamId_7, related_teamplayerses);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Save an existing Level entity
	 * 
	 */
	@Test
	public void saveTeamLevel() {
		// TODO: JUnit - Populate test inputs for operation: saveTeamLevel 
		Integer teamId_8 = 0;
		Level related_level = new wsdm.domain.Level();
		Team response = null;
		response = service.saveTeamLevel(teamId_8, related_level);
		// TODO: JUnit - Add assertions to test outputs of operation: saveTeamLevel
	}

	/**
	 * Operation Unit Test
	 * Return all Team entity
	 * 
	 */
	@Test
	public void findAllTeams() {
		// TODO: JUnit - Populate test inputs for operation: findAllTeams 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Team> response = null;
		response = service.findAllTeams(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllTeams
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Test
	public void deleteTeamTeamplayerses() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamTeamplayerses 
		Integer team_teamId_5 = 0;
		Integer related_teamplayerses_teamPlayersId = 0;
		Team response = null;
		response = service.deleteTeamTeamplayerses(team_teamId_5, related_teamplayerses_teamPlayersId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteTeamTswacct() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamTswacct 
		Integer team_teamId_6 = 0;
		Integer related_tswacct_tswAcctId = 0;
		Team response = null;
		response = service.deleteTeamTswacct(team_teamId_6, related_tswacct_tswAcctId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamTswacct
	}

	/**
	 * Operation Unit Test
	 * Load an existing Team entity
	 * 
	 */
	@Test
	public void loadTeams() {
		Set<Team> response = null;
		response = service.loadTeams();
		// TODO: JUnit - Add assertions to test outputs of operation: loadTeams
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Level entity
	 * 
	 */
	@Test
	public void deleteTeamLevel() {
		// TODO: JUnit - Populate test inputs for operation: deleteTeamLevel 
		Integer team_teamId_7 = 0;
		Integer related_level_levelId = 0;
		Team response = null;
		response = service.deleteTeamLevel(team_teamId_7, related_level_levelId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteTeamLevel
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
