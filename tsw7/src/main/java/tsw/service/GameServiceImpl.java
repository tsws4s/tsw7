package tsw.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tsw.dao.CustomerDAO;
import tsw.dao.GameDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.ResourceDAO;
import tsw.dao.SportstattypeDAO;
import tsw.dao.TeamDAO;
import tsw.dao.TeamplayersDAO;
import tsw.dao.TswacctDAO;
import tsw.dao.GamestatsDAO;

import tsw.domain.Customer;
import tsw.domain.Game;
import tsw.domain.Gamestats;
import tsw.domain.GenGame;
import tsw.domain.ProgGenGames;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Tswacct;
import tsw.web.SessionConfigCache;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Game entities
 * 
 */

@Service("GameService")
@Transactional
public class GameServiceImpl implements GameService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages Customer entities
	 * 
	 */
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private SportstattypeDAO sportstattypeDAO;
	
	@Autowired
	private ResourceDAO resourceDAO;
	
	@Autowired
	private TeamplayersDAO teamplayersDAO;
	
	/**
	 * DAO injected by Spring that manages Game entities
	 * 
	 */
	@Autowired
	private GameDAO gameDAO;

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;

	/**
	 * DAO injected by Spring that manages Team entities
	 * 
	 */
	@Autowired
	private TeamDAO teamDAO;
	/**
	 * DAO injected by Spring that manages Gamestats entities
	 * 
	 */
	@Autowired
	private GamestatsDAO gamestatsDAO;
	
	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private ProgramService programService;
	SessionConfigCache sessionCache = UsersController.getSessionCache();
	
	/**
	 * Instantiates a new GameServiceImpl.
	 *
	 */
	public GameServiceImpl() {
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Game deleteGameTeamByVisitorTeamFk(Integer game_gameId, Integer related_teambyvisitorteamfk_teamId) {
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, defaultMaxRows);
		Team related_teambyvisitorteamfk = teamDAO.findTeamByPrimaryKey(related_teambyvisitorteamfk_teamId, -1, defaultMaxRows);

		game.setTeamByVisitorTeamFk(null);
		related_teambyvisitorteamfk.getGamesForVisitorTeamFk().remove(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_teambyvisitorteamfk = teamDAO.store(related_teambyvisitorteamfk);
		teamDAO.flush();

		teamDAO.remove(related_teambyvisitorteamfk);
		teamDAO.flush();

		return game;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Transactional
	public Game deleteGameTeamByHomeTeamFk(Integer game_gameId, Integer related_teambyhometeamfk_teamId) {
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, defaultMaxRows);
		Team related_teambyhometeamfk = teamDAO.findTeamByPrimaryKey(related_teambyhometeamfk_teamId, -1, defaultMaxRows);

		game.setTeamByHomeTeamFk(null);
		related_teambyhometeamfk.getGamesForHomeTeamFk().remove(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_teambyhometeamfk = teamDAO.store(related_teambyhometeamfk);
		teamDAO.flush();

		teamDAO.remove(related_teambyhometeamfk);
		teamDAO.flush();

		return game;
	}

	/**
	 * Save an existing Program entity
	 * 
	 */
	@Transactional
	public Game saveGameProgram(Integer gameId, Program related_program) {
		Game game = gameDAO.findGameByPrimaryKey(gameId, -1, defaultMaxRows);
		Program existingprogram = programDAO.findProgramByPrimaryKey(related_program.getProgramId());

		// copy into the existing record to preserve existing relationships
		if (existingprogram != null) {
			existingprogram.setProgramId(related_program.getProgramId());
			existingprogram.setProgramName(related_program.getProgramName());
			existingprogram.setPrice(related_program.getPrice());
			existingprogram.setStartDate(related_program.getStartDate());
			existingprogram.setEndDate(related_program.getEndDate());
			existingprogram.setActiveYn(related_program.getActiveYn());
			existingprogram.setPublishYn(related_program.getPublishYn());
			existingprogram.setTotalPaid(related_program.getTotalPaid());
			existingprogram.setTotalParticipants(related_program.getTotalParticipants());
			existingprogram.setGamesPerTeam(related_program.getGamesPerTeam());
			existingprogram.setLeagueYn(related_program.getLeagueYn());
			related_program = existingprogram;
		} else {
			related_program = programDAO.store(related_program);
			programDAO.flush();
		}

		game.setProgram(related_program);
		related_program.getGames().add(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		return game;
	}
	
	
	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Game saveGameTeamByHomeTeamFk(Integer gameId, Team related_teambyhometeamfk) {
		Game game = gameDAO.findGameByPrimaryKey(gameId, -1, defaultMaxRows);
		Team existingteamByHomeTeamFk = teamDAO.findTeamByPrimaryKey(related_teambyhometeamfk.getTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingteamByHomeTeamFk != null) {
			existingteamByHomeTeamFk.setTeamId(related_teambyhometeamfk.getTeamId());
			existingteamByHomeTeamFk.setTeamName(related_teambyhometeamfk.getTeamName());
			existingteamByHomeTeamFk.setAmtPaid(related_teambyhometeamfk.getAmtPaid());
			existingteamByHomeTeamFk.setWins(related_teambyhometeamfk.getWins());
			existingteamByHomeTeamFk.setLosses(related_teambyhometeamfk.getLosses());
			existingteamByHomeTeamFk.setTies(related_teambyhometeamfk.getTies());
			existingteamByHomeTeamFk.setGroup3(related_teambyhometeamfk.getGroup3());
			existingteamByHomeTeamFk.setColor(related_teambyhometeamfk.getColor());
			existingteamByHomeTeamFk.setPublishYn(related_teambyhometeamfk.getPublishYn());
			existingteamByHomeTeamFk.setActiveYn(related_teambyhometeamfk.getActiveYn());
			existingteamByHomeTeamFk.setNotes(related_teambyhometeamfk.getNotes());
			related_teambyhometeamfk = existingteamByHomeTeamFk;
		} else {
			related_teambyhometeamfk = teamDAO.store(related_teambyhometeamfk);
			teamDAO.flush();
		}

		game.setTeamByHomeTeamFk(related_teambyhometeamfk);
		related_teambyhometeamfk.getGamesForHomeTeamFk().add(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_teambyhometeamfk = teamDAO.store(related_teambyhometeamfk);
		teamDAO.flush();

		return game;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Transactional
	public Game deleteGameCustomer(Integer game_gameId, Integer related_customer_customerId) {
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, defaultMaxRows);
		Customer related_customer = customerDAO.findCustomerByPrimaryKey(related_customer_customerId, -1, defaultMaxRows);

		game.setCustomer(null);
		related_customer.getGames().remove(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		customerDAO.remove(related_customer);
		customerDAO.flush();

		return game;
	}

	/**
	 * Load an existing Game entity
	 * 
	 */
	@Transactional
	public Set<Game> loadGames4tsw(Tswacct tswacct) {
		return gameDAO.findAllGames4tsw(tswacct.getTswAcctId());
	}

	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Transactional
	public void deleteGame(Game game) {
		gameDAO.remove(game);
		gameDAO.flush();
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Transactional
	public Game saveGameTeamByVisitorTeamFk(Integer gameId, Team related_teambyvisitorteamfk) {
		Game game = gameDAO.findGameByPrimaryKey(gameId, -1, defaultMaxRows);
		Team existingteamByVisitorTeamFk = teamDAO.findTeamByPrimaryKey(related_teambyvisitorteamfk.getTeamId());

		// copy into the existing record to preserve existing relationships
		if (existingteamByVisitorTeamFk != null) {
			existingteamByVisitorTeamFk.setTeamId(related_teambyvisitorteamfk.getTeamId());
			existingteamByVisitorTeamFk.setTeamName(related_teambyvisitorteamfk.getTeamName());
			existingteamByVisitorTeamFk.setAmtPaid(related_teambyvisitorteamfk.getAmtPaid());
			existingteamByVisitorTeamFk.setWins(related_teambyvisitorteamfk.getWins());
			existingteamByVisitorTeamFk.setLosses(related_teambyvisitorteamfk.getLosses());
			existingteamByVisitorTeamFk.setTies(related_teambyvisitorteamfk.getTies());
			existingteamByVisitorTeamFk.setGroup3(related_teambyvisitorteamfk.getGroup3());
			existingteamByVisitorTeamFk.setColor(related_teambyvisitorteamfk.getColor());
			existingteamByVisitorTeamFk.setPublishYn(related_teambyvisitorteamfk.getPublishYn());
			existingteamByVisitorTeamFk.setActiveYn(related_teambyvisitorteamfk.getActiveYn());
			existingteamByVisitorTeamFk.setNotes(related_teambyvisitorteamfk.getNotes());
			related_teambyvisitorteamfk = existingteamByVisitorTeamFk;
		} else {
			related_teambyvisitorteamfk = teamDAO.store(related_teambyvisitorteamfk);
			teamDAO.flush();
		}

		game.setTeamByVisitorTeamFk(related_teambyvisitorteamfk);
		related_teambyvisitorteamfk.getGamesForVisitorTeamFk().add(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_teambyvisitorteamfk = teamDAO.store(related_teambyvisitorteamfk);
		teamDAO.flush();

		return game;
	}

	/**
	 * Return all Game entity
	 * 
	 */
	@Transactional
	public List<Game> findAllGames4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Game>(gameDAO.findAllGames4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Transactional
	public void saveGame(Tswacct tswacct, Game game, Integer resIdKey) {
		Game existingGame = gameDAO.findGameByPrimaryKey(game.getGameId());

		if (existingGame != null) {
			if (existingGame != game) {
				existingGame.setGameId(game.getGameId());
				existingGame.setGameDate(game.getGameDate());
				existingGame.setStartTime(game.getStartTime());
				existingGame.setEndTime(game.getEndTime());	
				existingGame.setHomeScore(game.getHomeScore());
				existingGame.setVisitorScore(game.getVisitorScore());
				existingGame.setActiveYn(game.getActiveYn());
			}
			game = existingGame;
		} else {
			int gameId = gameDAO.getMaxGameID();
			game.setGameId(gameId+1);
			game.setTswacct(tswacct);
		}
		if(resIdKey!=null && resIdKey>0){
			game.setResource(resourceDAO.findResourceByPrimaryKey(resIdKey));
		}				
		game = gameDAO.store(game);		
		gameDAO.flush();
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Game deleteGameTswacct(Integer game_gameId, Integer related_tswacct_tswAcctId) {
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		game.setTswacct(null);
		related_tswacct.getGames().remove(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return game;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Transactional
	public Game saveGameCustomer(Integer gameId, Customer related_customer) {
		Game game = gameDAO.findGameByPrimaryKey(gameId, -1, defaultMaxRows);
		Customer existingcustomer = customerDAO.findCustomerByPrimaryKey(related_customer.getCustomerId());

		// copy into the existing record to preserve existing relationships
		if (existingcustomer != null) {
			existingcustomer.setCustomerId(related_customer.getCustomerId());
			existingcustomer.setEmail(related_customer.getEmail());
			existingcustomer.setFirstname(related_customer.getFirstname());
			existingcustomer.setLastname(related_customer.getLastname());
			existingcustomer.setPhone(related_customer.getPhone());
			existingcustomer.setYearBorn(related_customer.getYearBorn());
			existingcustomer.setAddress(related_customer.getAddress());
			existingcustomer.setCity(related_customer.getCity());
			existingcustomer.setState(related_customer.getState());
			existingcustomer.setZipcode(related_customer.getZipcode());
			related_customer = existingcustomer;
		} else {
			related_customer = customerDAO.store(related_customer);
			customerDAO.flush();
		}

		game.setCustomer(related_customer);
		related_customer.getGames().add(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_customer = customerDAO.store(related_customer);
		customerDAO.flush();

		return game;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Game saveGameTswacct(Integer gameId, Tswacct related_tswacct) {
		Game game = gameDAO.findGameByPrimaryKey(gameId, -1, defaultMaxRows);
		Tswacct existingtswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswacct != null) {
			existingtswacct.setTswAcctId(related_tswacct.getTswAcctId());
			existingtswacct.setAcctName(related_tswacct.getAcctName());
			existingtswacct.setSubscrType(related_tswacct.getSubscrType());
			existingtswacct.setAmtPaid(related_tswacct.getAmtPaid());
			existingtswacct.setEstablishDate(related_tswacct.getEstablishDate());
			existingtswacct.setExpireDate(related_tswacct.getExpireDate());
			existingtswacct.setActiveYn(related_tswacct.getActiveYn());
			related_tswacct = existingtswacct;
		} else {
			related_tswacct = tswacctDAO.store(related_tswacct);
			tswacctDAO.flush();
		}

		game.setTswacct(related_tswacct);
		related_tswacct.getGames().add(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return game;
	}
	/**
	 * Save an existing Gamestats entity
	 * 
	 */
	@Transactional
	public Game saveGameGamestatses(Integer gameId, Gamestats related_gamestatses, Integer sportStatTypeId, Integer teamplayerId) {
		Game game = gameDAO.findGameByPrimaryKey(gameId, -1, -1);
		Gamestats existinggamestatses = gamestatsDAO.findGamestatsByPrimaryKey(related_gamestatses.getGameStatsId());
		if (existinggamestatses != null) {
			if (existinggamestatses != related_gamestatses) {
			// copy into the existing record to preserve existing relationships
				existinggamestatses.setGameStatsId(related_gamestatses.getGameStatsId());
				existinggamestatses.setGameStatValue(related_gamestatses.getGameStatValue());
				existinggamestatses.setGameStatTime(related_gamestatses.getGameStatTime());
			} 
			related_gamestatses = existinggamestatses; 
		} else {
			int GameStatsId = gamestatsDAO.getGamestatsMaxId();
			related_gamestatses.setGameStatsId(GameStatsId+1);
		}
		if(sportStatTypeId!=null && sportStatTypeId>0){
			related_gamestatses.setSportStatType(sportstattypeDAO.findSportstattypeByPrimaryKey(sportStatTypeId));
		}
		if(teamplayerId!=null && teamplayerId>0){
			related_gamestatses.setTeamplayers(teamplayersDAO.findTeamplayersByPrimaryKey(teamplayerId));
		}
		related_gamestatses.setGame(game);
		related_gamestatses = gamestatsDAO.store(related_gamestatses);
		gamestatsDAO.flush();

		// ?? is this needed?
		game.getGamestatses().add(related_gamestatses);
		game = gameDAO.store(game);
		gameDAO.flush();

		return game;
	}
	
	/**
	 * Delete an existing Gamestats entity
	 * 
	 */
	@Transactional
	public Game deleteGameGamestatses(Integer game_gameId, Integer related_gamestatses_gameStatsId) {
		Gamestats related_gamestatses = gamestatsDAO.findGamestatsByPrimaryKey(related_gamestatses_gameStatsId, -1, -1);
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, -1);

		// ?? is this needed?
		game.getGamestatses().remove(related_gamestatses);

		gamestatsDAO.remove(related_gamestatses);
		gamestatsDAO.flush();

		return game;
	}


	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Transactional
	public Game deleteGameProgram(Integer game_gameId, Integer related_program_programId) {
		Game game = gameDAO.findGameByPrimaryKey(game_gameId, -1, defaultMaxRows);
		Program related_program = programDAO.findProgramByPrimaryKey(related_program_programId, -1, defaultMaxRows);

		game.setProgram(null);
		related_program.getGames().remove(game);
		game = gameDAO.store(game);
		gameDAO.flush();

		related_program = programDAO.store(related_program);
		programDAO.flush();

		programDAO.remove(related_program);
		programDAO.flush();

		return game;
	}

	/**
	 */
	@Transactional
	public Game findGameByPrimaryKey(Integer gameId) {
		return gameDAO.findGameByPrimaryKey(gameId);
	}

	/**
	 * Return a count of all Game entity
	 * 
	 */
	@Transactional
	public Integer countGames() {
		return ((Long) gameDAO.createQuerySingleResult("select count(o) from Game o").getSingleResult()).intValue();
	}

	public void saveGeneratedGames(HttpServletRequest request, ProgGenGames generatedGames){
		Program pgm = programDAO.findProgramByPrimaryKey(generatedGames.getProgramId());
		java.util.Iterator<GenGame> gamIter = generatedGames.getGengamesList().iterator();
		while(gamIter.hasNext()){
			GenGame genGame = gamIter.next();
			Game newGame = new Game();
			newGame.setProgram(pgm);
			newGame.setTswacct(pgm.getTswacct());
			newGame.setGameDate(genGame.getGameDateTime());

			DateTime startTime = new DateTime(genGame.getStartTime().getTime());			
			newGame.setStartTime(startTime.toGregorianCalendar());
			DateTime endTime = new DateTime(startTime);
			endTime.plusMinutes(pgm.getGameMins());
			newGame.setEndTime(endTime.toGregorianCalendar());
			
			Integer selected_id2 = genGame.getHomeTeamId();
			Integer selected_id3 = genGame.getVisitorTeamId();
			Game savedGame = programService.saveProgramGames(sessionCache.getTswacct(request), generatedGames.getProgramId(), selected_id2, selected_id3, null, pgm.getResource().getResourceId(), newGame);
			eventService.saveEventForGame(savedGame, generatedGames.getProgramId(), pgm.getResource().getResourceId());
			
		}
	}
}
