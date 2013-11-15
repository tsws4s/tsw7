package tsw.utils;

import java.util.ArrayList;
import java.util.Set;
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

import tsw.dao.ProgramDAO;
import tsw.dao.ProgramDAOImpl;
import tsw.domain.GenGame;
import tsw.domain.Program;
import tsw.domain.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({
		DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class,
		TransactionalTestExecutionListener.class })
@Transactional
@ContextConfiguration(locations = {
		"file:./src/main/resources/tsw7-security-context.xml",
		"file:./src/main/resources/tsw7-service-context.xml",
		"file:./src/main/resources/tsw7-dao-context.xml",
		"file:./src/main/resources/tsw7-web-context.xml" })

public class GameGeneratorTest {

	ProgramDAO dataStore;
	

	public static void main(String[] args) {
		
		GameGeneratorTest test = new GameGeneratorTest();
		test.runTest();
		
	}
	
	@Rollback(false)
	@Test
	public void runTest(){

		int gamesPerTeam = 5;
		int programId = 3;
//		int gamesPerTeam = pgm.getGamesPerTeam();
//		int numGamesPerDt = 1;		
		ProgramDAOImpl programDao = new ProgramDAOImpl();
	
		Program pgm = programDao.findProgramByProgramId(programId, -1, -1);
		Set<Team> tms = pgm.getTeams();

		ArrayList<GenGame> games = GameGenerator.generateGamePairings(1, tms, gamesPerTeam);

		System.out.println("Total Games: "+games.size());
		System.out.println(games.toString());
	}
	
	@Autowired
	public void setDataStore(ProgramDAO dataStore) {
		this.dataStore = dataStore;
	}
}
