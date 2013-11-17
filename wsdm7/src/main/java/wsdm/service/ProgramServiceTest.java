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
import wsdm.domain.Event;
import wsdm.domain.Game;
import wsdm.domain.Participant;
import wsdm.domain.Price;
import wsdm.domain.Program;
import wsdm.domain.Programresource;
import wsdm.domain.Resource;
import wsdm.domain.Sport;
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
	 * Save an existing Program entity
	 * 
	 */
	@Test
	public void saveProgram() {
		// TODO: JUnit - Populate test inputs for operation: saveProgram 
		Program program = new wsdm.domain.Program();
		service.saveProgram(program);
	}

	/**
	 * Operation Unit Test
	 * Save an existing Customer entity
	 * 
	 */
	@Test
	public void saveProgramCustomer() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramCustomer 
		Integer programId = 0;
		Customer related_customer = new wsdm.domain.Customer();
		Program response = null;
		response = service.saveProgramCustomer(programId, related_customer);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramCustomer
	}

	/**
	 * Operation Unit Test
	 * Save an existing Event entity
	 * 
	 */
	@Test
	public void saveProgramEvents() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramEvents 
		Integer programId_1 = 0;
		Event related_events = new wsdm.domain.Event();
		Program response = null;
		response = service.saveProgramEvents(programId_1, related_events);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramEvents
	}

	/**
	 * Operation Unit Test
	 * Save an existing Price entity
	 * 
	 */
	@Test
	public void saveProgramPrice() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramPrice 
		Integer programId_2 = 0;
		Price related_price = new wsdm.domain.Price();
		Program response = null;
		response = service.saveProgramPrice(programId_2, related_price);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramPrice
	}

	/**
	 * Operation Unit Test
	 * Save an existing Resource entity
	 * 
	 */
	@Test
	public void saveProgramResource() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramResource 
		Integer programId_3 = 0;
		Resource related_resource = new wsdm.domain.Resource();
		Program response = null;
		response = service.saveProgramResource(programId_3, related_resource);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramResource
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Game entity
	 * 
	 */
	@Test
	public void deleteProgramGames() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramGames 
		Integer program_programId = 0;
		Integer related_games_gameId = 0;
		Program response = null;
		response = service.deleteProgramGames(program_programId, related_games_gameId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramGames
	}

	/**
	 * Operation Unit Test
	 * Save an existing Tswacct entity
	 * 
	 */
	@Test
	public void saveProgramTswacct() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramTswacct 
		Integer programId_4 = 0;
		Tswacct related_tswacct = new wsdm.domain.Tswacct();
		Program response = null;
		response = service.saveProgramTswacct(programId_4, related_tswacct);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramTswacct
	}

	/**
	 * Operation Unit Test
	 * Return a count of all Program entity
	 * 
	 */
	@Test
	public void countPrograms() {
		Integer response = null;
		response = service.countPrograms();
		// TODO: JUnit - Add assertions to test outputs of operation: countPrograms
	}

	/**
	 * Operation Unit Test
	 * Save an existing Sport entity
	 * 
	 */
	@Test
	public void saveProgramSport() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramSport 
		Integer programId_5 = 0;
		Sport related_sport = new wsdm.domain.Sport();
		Program response = null;
		response = service.saveProgramSport(programId_5, related_sport);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramSport
	}

	/**
	 * Operation Unit Test
	 * Save an existing Participant entity
	 * 
	 */
	@Test
	public void saveProgramParticipants() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramParticipants 
		Integer programId_6 = 0;
		Participant related_participants = new wsdm.domain.Participant();
		Program response = null;
		response = service.saveProgramParticipants(programId_6, related_participants);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramParticipants
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Resource entity
	 * 
	 */
	@Test
	public void deleteProgramResource() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramResource 
		Integer program_programId_1 = 0;
		Integer related_resource_resourceId = 0;
		Program response = null;
		response = service.deleteProgramResource(program_programId_1, related_resource_resourceId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramResource
	}

	/**
	 * Operation Unit Test
	 * Load an existing Program entity
	 * 
	 */
	@Test
	public void loadPrograms() {
		Set<Program> response = null;
		response = service.loadPrograms();
		// TODO: JUnit - Add assertions to test outputs of operation: loadPrograms
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Programresource entity
	 * 
	 */
	@Test
	public void deleteProgramProgramresources() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramProgramresources 
		Integer program_programId_2 = 0;
		Integer related_programresources_programResourceId = 0;
		Program response = null;
		response = service.deleteProgramProgramresources(program_programId_2, related_programresources_programResourceId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramProgramresources
	}

	/**
	 * Operation Unit Test
	 * Save an existing Game entity
	 * 
	 */
	@Test
	public void saveProgramGames() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramGames 
		Integer programId_7 = 0;
		Game related_games = new wsdm.domain.Game();
		Program response = null;
		response = service.saveProgramGames(programId_7, related_games);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramGames
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Test
	public void deleteProgramTswacct() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramTswacct 
		Integer program_programId_3 = 0;
		Integer related_tswacct_tswAcctId = 0;
		Program response = null;
		response = service.deleteProgramTswacct(program_programId_3, related_tswacct_tswAcctId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramTswacct
	}

	/**
	 * Operation Unit Test
	 * Save an existing Team entity
	 * 
	 */
	@Test
	public void saveProgramTeams() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramTeams 
		Integer programId_8 = 0;
		Team related_teams = new wsdm.domain.Team();
		Program response = null;
		response = service.saveProgramTeams(programId_8, related_teams);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramTeams
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Program entity
	 * 
	 */
	@Test
	public void deleteProgram() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgram 
		Program program_1 = new wsdm.domain.Program();
		service.deleteProgram(program_1);
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Participant entity
	 * 
	 */
	@Test
	public void deleteProgramParticipants() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramParticipants 
		Integer program_programId_4 = 0;
		Integer related_participants_participantId = 0;
		Program response = null;
		response = service.deleteProgramParticipants(program_programId_4, related_participants_participantId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramParticipants
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Customer entity
	 * 
	 */
	@Test
	public void deleteProgramCustomer() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramCustomer 
		Integer program_programId_5 = 0;
		Integer related_customer_customerId = 0;
		Program response = null;
		response = service.deleteProgramCustomer(program_programId_5, related_customer_customerId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramCustomer
	}

	/**
	 * Operation Unit Test
	 */
	@Test
	public void findProgramByPrimaryKey() {
		// TODO: JUnit - Populate test inputs for operation: findProgramByPrimaryKey 
		Integer programId_9 = 0;
		Program response = null;
		response = service.findProgramByPrimaryKey(programId_9);
		// TODO: JUnit - Add assertions to test outputs of operation: findProgramByPrimaryKey
	}

	/**
	 * Operation Unit Test
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Test
	public void saveProgramTeamplayerses() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramTeamplayerses 
		Integer programId_10 = 0;
		Teamplayers related_teamplayerses = new wsdm.domain.Teamplayers();
		Program response = null;
		response = service.saveProgramTeamplayerses(programId_10, related_teamplayerses);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Event entity
	 * 
	 */
	@Test
	public void deleteProgramEvents() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramEvents 
		Integer program_programId_6 = 0;
		Integer related_events_eventId = 0;
		Program response = null;
		response = service.deleteProgramEvents(program_programId_6, related_events_eventId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramEvents
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Test
	public void deleteProgramTeamplayerses() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramTeamplayerses 
		Integer program_programId_7 = 0;
		Integer related_teamplayerses_teamPlayersId = 0;
		Program response = null;
		response = service.deleteProgramTeamplayerses(program_programId_7, related_teamplayerses_teamPlayersId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramTeamplayerses
	}

	/**
	 * Operation Unit Test
	 * Return all Program entity
	 * 
	 */
	@Test
	public void findAllPrograms() {
		// TODO: JUnit - Populate test inputs for operation: findAllPrograms 
		Integer startResult = 0;
		Integer maxRows = 0;
		List<Program> response = null;
		response = service.findAllPrograms(startResult, maxRows);
		// TODO: JUnit - Add assertions to test outputs of operation: findAllPrograms
	}

	/**
	 * Operation Unit Test
	 * Save an existing Programresource entity
	 * 
	 */
	@Test
	public void saveProgramProgramresources() {
		// TODO: JUnit - Populate test inputs for operation: saveProgramProgramresources 
		Integer programId_11 = 0;
		Programresource related_programresources = new wsdm.domain.Programresource();
		Program response = null;
		response = service.saveProgramProgramresources(programId_11, related_programresources);
		// TODO: JUnit - Add assertions to test outputs of operation: saveProgramProgramresources
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Price entity
	 * 
	 */
	@Test
	public void deleteProgramPrice() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramPrice 
		Integer program_programId_8 = 0;
		Integer related_price_priceId = 0;
		Program response = null;
		response = service.deleteProgramPrice(program_programId_8, related_price_priceId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramPrice
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Team entity
	 * 
	 */
	@Test
	public void deleteProgramTeams() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramTeams 
		Integer program_programId_9 = 0;
		Integer related_teams_teamId = 0;
		Program response = null;
		response = service.deleteProgramTeams(program_programId_9, related_teams_teamId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramTeams
	}

	/**
	 * Operation Unit Test
	 * Delete an existing Sport entity
	 * 
	 */
	@Test
	public void deleteProgramSport() {
		// TODO: JUnit - Populate test inputs for operation: deleteProgramSport 
		Integer program_programId_10 = 0;
		Integer related_sport_sportId = 0;
		Program response = null;
		response = service.deleteProgramSport(program_programId_10, related_sport_sportId);
		// TODO: JUnit - Add assertions to test outputs of operation: deleteProgramSport
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
