package tsw.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tsw.domain.Game;
import tsw.domain.Participant;
import tsw.domain.ProgGenGames;
import tsw.domain.Program;
import tsw.domain.Team;
import tsw.domain.Tswacct;
import tsw.service.EventService;
import tsw.service.GameService;
import tsw.service.LevelService;
import tsw.service.ParticipantService;
import tsw.service.PriceService;
import tsw.service.ProgramService;
import tsw.service.ResourceService;
import tsw.service.SportService;
import tsw.service.TeamService;

/**
 * Spring MVC controller that handles CRUD requests for Program entities
 * 
 */

@Controller("ProgramController")
public class ProgramController {

	static int defaultMaxRows = 10;
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();
	
	/**
	 * Service injected by Spring that provides CRUD operations for Program entities
	 * 
	 */
	@Autowired
	private ProgramService programService;

	@Autowired
	private GameService gameService;

	@Autowired
	private TeamService teamService;
	
	@Autowired
	private EventService eventService;
	@Autowired
	private LevelService levelService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private PriceService priceService;
	@Autowired
	private ParticipantService participantService;
	@Autowired
	SportService sportService;
	
	// Init
	/**  ***************************************  Init  *******************************************************
	 * 	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}
	
	/**
	 */
	@RequestMapping("/programController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}	

	// List Search
	/**  *************************************  List Search  *************************************************
	 * Entry point to show all Program entities
	 * 
	 */
	public String indexProgram(HttpServletRequest request) {
		return "redirect:/indexProgram";
	}
	
	/**
	 * Show all Program entities
	 * 
	 */
	@RequestMapping("/indexProgram")
	public ModelAndView listPrograms(HttpServletRequest request) {
		ModelAndView mav = listProgramsFrom(request, 0);
		mav.addObject("leagueFlag", false);
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexProgramFrom")
	public ModelAndView listProgramsFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("programs", programService.loadPrograms4tsw(sessionCache.getTswacct(request),indexFrom));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("program/listPrograms.jsp");
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
		@RequestMapping("/searchProgramsFrom")
		public ModelAndView searchProgramsFrom(HttpServletRequest request, @RequestParam int indexFrom) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("programs", programService.loadPrograms4tsw(sessionCache.getTswacct(request)));
			mav.addObject("leagueFlag", false);
			mav.addObject("searchFlag", true);
			mav.addObject("user",sessionCache.getUser4Session(request));
			mav.setViewName("program/searchPrograms.jsp");
			return mav;
		}	

	@RequestMapping("/searchPrograms")
	public ModelAndView searchPrograms(HttpServletRequest request) {
		return searchProgramsFrom(request, 0);
	}	
	/**
	 * Show all League entities
	 * 
	 */
	@RequestMapping("/indexLeague")
	public ModelAndView listLeagues(HttpServletRequest request) {
		ModelAndView mav = listLeaguesFrom(request, 0);
		mav.addObject("leagueFlag", true);
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexLeaguesFrom")
	public ModelAndView listLeaguesFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("programs", programService.loadLeagues4tsw(sessionCache.getTswacct(request),indexFrom));
		mav.addObject("leagueFlag", true);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("program/listPrograms.jsp");
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchLeaguesFrom")
	public ModelAndView searchLeaguesFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("programs", programService.loadLeagues4tsw(sessionCache.getTswacct(request),indexFrom));
		mav.addObject("leagueFlag", true);
		mav.addObject("searchFlag", true);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("program/searchPrograms.jsp");
		return mav;
	}	
	@RequestMapping("/searchLeagues")
	public ModelAndView searchLeagues(HttpServletRequest request) {
		return searchLeaguesFrom(request, 0);
	}	

	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * 	 * Create a new Program entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newProgram")
	public ModelAndView newProgram(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Program pgm = new Program();
		pgm.setActiveYn(new Integer(1)); 
		pgm.setLeagueYn(new Integer(0));
		pgm.setTswacct(sessionCache.getTswacct(request));
		mav.addObject("program", pgm);
		mav.addObject("newFlag", true);
		mav.addObject("leagueFlag", false);	
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("program/editProgram.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Create a new League entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newLeague")
	public ModelAndView newLeague(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Program league = new Program();
		league.setActiveYn(new Integer(1)); 
		league.setLeagueYn(new Integer(1));
		league.setTswacct(sessionCache.getTswacct(request));
		mav.addObject("program", league);
		mav.addObject("newFlag", true);
		mav.addObject("leagueFlag", true);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("program/editProgram.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Program entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editProgram")
	public ModelAndView editProgram(HttpServletRequest request, @RequestParam Integer programIdKey, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Program pgm = programService.findProgramByPrimaryKey(programIdKey);
		if(pgm.getLeagueYn().intValue()==1){
				mav.addObject("leagueFlag", true);
		} else {
				mav.addObject("leagueFlag", false);
		}
		mav.addObject("program", pgm);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("program/editProgram.jsp");
		return mav;
	}	

	/**
	 * Select the Program entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteProgram")
	public ModelAndView confirmDeleteProgram(HttpServletRequest request, @RequestParam Integer programIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("program", programService.findProgramByPrimaryKey(programIdKey));
		mav.setViewName("program/deleteProgram.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Delete an existing Program entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteProgram")
	public String deleteProgram(HttpServletRequest request, @RequestParam Integer programIdKey) {
		Program program = programService.findProgramByPrimaryKey(programIdKey);
		String fwd = "forward:/indexLeague";
		if(program.getLeagueYn()<1){
			fwd = "forward:/indexProgram";
		}
		programService.deleteProgram(program);
		return fwd;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteLeague")
	public String deleteLeague(HttpServletRequest request, @RequestParam Integer programIdKey) {
		Program program = programService.findProgramByPrimaryKey(programIdKey);
		programService.deleteProgram(program);
		return "forward:/indexLeague";
	}
	
	/**
	 * Save an existing Program entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveProgram")
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		String fwd = new String("forward:/indexProgram");
		if(program.getLeagueYn()!=null && program.getLeagueYn().intValue()==1){
		 fwd = new String("forward:/indexLeague");
		}
		programService.saveProgram(sessionCache.getUser4Session(request), program, selected_id1, selected_id4, selected_id8, selected_id11, selected_sport_id1);
		return fwd;
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveLeagueQuickStart")
	public String saveLeagueQuickStart(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11) {
		String fwd = new String("forward:/indexLeague");
		// TODO: [assignedTo] (Program-Med) Implement the "Program & League Quick Entry" wizard "SAVE" capability 
		//programService.saveProgram(sessionCache.getUser4Session(request), program, selected_id1, selected_id4, selected_id8, selected_id11);
		return fwd;
	}
	
		
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * 	 * Create a new Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newProgramGames")
	public ModelAndView newProgramGames(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam String program_programName) {
		ModelAndView mav = new ModelAndView();
		Program pgm = programService.findProgramByPrimaryKey(program_programId);
		mav.addObject("program_programId", program_programId);
		mav.addObject("program_programName", program_programName);
		Game gm = new Game();
		gm.setTswacct(pgm.getTswacct());
		gm.setProgram(pgm);
		gm.setActiveYn(new Integer(1));
		mav.addObject("game", gm);
		mav.addObject("newFlag", true);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("program/games/editGames.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Show all Game entities by Program
	 * 
	 **/
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/listProgramGames")
	public ModelAndView listProgramGames(HttpServletRequest request, @RequestParam Integer programIdKey) {
		ModelAndView mav = new ModelAndView();
		Set<Program> pgmLeagues = programService.loadLeagues4tsw(sessionCache.getTswacct(request));
		mav.addObject("leagues", pgmLeagues);		
		Program pgm = programService.findProgramByPrimaryKey(programIdKey);
		mav.addObject("program", pgm);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.addObject("numTeams", pgm.getTeams().size());
		mav.setViewName("program/games/listGames.jsp");
		return mav;
	}

	// Generated Games Save
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/generateGames")
	public ModelAndView generateGames(HttpServletRequest request, @RequestParam Integer programIdKey) {
		ModelAndView mav = new ModelAndView();
		Program pgm = programService.findProgramByPrimaryKey(programIdKey);
		mav.addObject("program", pgm);
		mav.addObject("teams", pgm.getTeams());
		mav.addObject("numTeams", pgm.getTeams().size());
		ProgGenGames pgg = pgm.generateGames();
		pgg.setGengames(new HashSet<tsw.domain.GenGame>(pgg.getGengamesList()));
		request.getSession(false).setAttribute("generatedGames", pgg);
		mav.addObject("generatedGames", pgg);
		mav.setViewName("program/games/generateGames.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveGeneratedGames")
	public ModelAndView saveGeneratedGames(HttpServletRequest request) {
		ProgGenGames generatedGames  = (ProgGenGames) request.getSession(false).getAttribute("generatedGames");
		if(generatedGames==null || generatedGames.getGengamesList()==null){
			// Problem... there is no generatedGames in sessionCache to load/save.
		 	// POST collection of Generated Games?
			return listLeagues(request);
		}
		gameService.saveGeneratedGames(request, generatedGames);
		return listProgramGames(request, generatedGames.getProgramId());
	}

	/**
	 * Edit an existing Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editProgramGames")
	public ModelAndView editProgramGames(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer games_gameId) {
		Game game = gameService.findGameByPrimaryKey(games_gameId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("program_programId", program_programId);
		mav.addObject("game", game);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("program/games/editGames.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Select the child Game entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteProgramGames")
	public ModelAndView confirmDeleteProgramGames(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer related_games_gameId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("game", gameService.findGameByPrimaryKey(related_games_gameId));
		mav.addObject("program_programId", program_programId);
		mav.setViewName("program/games/deleteGames.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteProgramGames")
	public ModelAndView deleteProgramGames(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer related_games_gameId) {
		Program program = programService.deleteProgramGames(program_programId, related_games_gameId);
		return listProgramGames(request, program.getProgramId());
	}	

	/**
	 * Save an existing Game entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveProgramGames")
	public ModelAndView saveProgramGames(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer selected_id2, @RequestParam Integer selected_id3, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @ModelAttribute Game games) {
		Game theGame = programService.saveProgramGames(sessionCache.getTswacct(request), program_programId, selected_id2, selected_id3, selected_id4, selected_id8, games);
		
		eventService.saveEventForGame(theGame, program_programId, selected_id8);
		
		Team homeTeam = programService.updateTeamStandings(theGame.getTeamByHomeTeamFk());
		programService.saveProgramTeams(sessionCache.getTswacct(request), program_programId, null, null, null, homeTeam);
		Team visitorTeam = programService.updateTeamStandings(theGame.getTeamByVisitorTeamFk());
		programService.saveProgramTeams(sessionCache.getTswacct(request), program_programId, null, null, null, visitorTeam);
		return listProgramGames(request, theGame.getProgram().getProgramId());
	}


	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Participant entity
	 * 
	 */

	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })	
	@RequestMapping("/newProgramParticipants")
	public ModelAndView newProgramParticipants(HttpServletRequest request, @RequestParam Integer program_programId) {
		ModelAndView mav = new ModelAndView();
		Program pgm = programService.findProgramByPrimaryKey(program_programId);
		mav.addObject("program_programId", program_programId);
		mav.addObject("program", pgm);
		Participant part = new Participant();
		part.setTswacct(pgm.getTswacct());
		part.setActiveYn(new Integer(1));
		part.setProgram(pgm);
		mav.addObject("participant", part);
		mav.addObject("newFlag", true);
		mav.setViewName("program/participants/editParticipants.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Show all Participant entities by Program
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/listProgramParticipants")
	public ModelAndView listProgramParticipants(HttpServletRequest request, @RequestParam Integer programIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("program", programService.findProgramByPrimaryKey(programIdKey));
		mav.setViewName("program/participants/listParticipants.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Participant entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editProgramParticipants")
	public ModelAndView editProgramParticipants(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer participants_participantId) {
		Participant participant = participantService.findParticipantByPrimaryKey(participants_participantId);
		ModelAndView mav = new ModelAndView();
		mav.addObject("program_programId", program_programId);
		mav.addObject("participant", participant);
		mav.setViewName("program/participants/editParticipants.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Select the child Participant entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteProgramParticipants")
	public ModelAndView confirmDeleteProgramParticipants(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer related_participants_participantId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("participant", participantService.findParticipantByPrimaryKey(related_participants_participantId));
		mav.addObject("program_programId", program_programId);
		mav.setViewName("program/participants/deleteParticipants.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Delete an existing Participant entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteProgramParticipants")
	public ModelAndView deleteProgramParticipants(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer related_participants_participantId) {
		Program program = programService.deleteProgramParticipants(program_programId, related_participants_participantId);
		program = programService.updateParticipantCounts(program);
		programService.saveProgram(sessionCache.getUser4Session(request), program, null, null, null, null, null);
		return editProgram(request, program.getProgramId(),0);
	}
	
	/**
	 * Save an existing Participant entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveProgramParticipants")
	public ModelAndView saveProgramParticipants(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer selected_id4, @ModelAttribute Participant participants) {
		Program parent_program = programService.saveProgramParticipants(sessionCache.getTswacct(request), program_programId, selected_id4, participants);
		parent_program = programService.updateParticipantCounts(parent_program);
		programService.saveProgram(sessionCache.getUser4Session(request), parent_program, null, null, null, null, null);
		return editProgram(request, parent_program.getProgramId(), 0);
	}

	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * 	 * Create a new Team entity
	 * 
	 */

	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newProgramTeams")
	public ModelAndView newProgramTeams(HttpServletRequest request, @RequestParam Integer program_programId) {
		ModelAndView mav = new ModelAndView();
		Program pgm = programService.findProgramByPrimaryKey(program_programId);
		mav.addObject("program_programId", program_programId);
		mav.addObject("program", pgm);
		Team tm = new Team();
		tm.setLevel(pgm.getLevel());
		tm.setTswacct(pgm.getTswacct());
		tm.setActiveYn(new Integer(1));
		tm.setProgram(pgm);
		mav.addObject("team", tm);
		mav.addObject("newFlag", true);
		Integer startResult = -1;
		mav.addObject("levels", levelService.findAllLevels4tsw(sessionCache.getTswacct(request), startResult , defaultMaxRows));
		mav.setViewName("program/teams/editTeams.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Show all Team entities by Program
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/listProgramTeams")
	public ModelAndView listProgramTeams(HttpServletRequest request, @RequestParam Integer programIdKey) {
		ModelAndView mav = new ModelAndView();
		Set<Program> pgmLeagues = programService.loadLeagues4tsw(sessionCache.getTswacct(request));
		mav.addObject("leagues", pgmLeagues);
		Program pgm = programService.findProgramByPrimaryKey(programIdKey);
		mav.addObject("program", pgm);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("program/teams/listTeams.jsp");
		return mav;
	}

	/**
	 * Edit an existing Team entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editProgramTeams")
	public ModelAndView editProgramTeams(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam String program_programName, @RequestParam Integer teams_teamId) {
		Team team = teamService.findTeamByPrimaryKey(teams_teamId);

		ModelAndView mav = new ModelAndView();
		mav.addObject("program_programId", program_programId);
		mav.addObject("program_programName", program_programName);
		mav.addObject("team", team);
		mav.addObject("user",sessionCache.getUser4Session(request));
		Integer startResult = -1;
		mav.addObject("levels", levelService.findAllLevels4tsw(sessionCache.getTswacct(request), startResult , defaultMaxRows));
		mav.setViewName("program/teams/editTeams.jsp");
		return mav;
	}
	
	/**
	 * Select the child Team entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteProgramTeams")
	public ModelAndView confirmDeleteProgramTeams(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam String program_programName, @RequestParam Integer related_teams_teamId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("team", teamService.findTeamByPrimaryKey(related_teams_teamId));
		mav.addObject("program_programId", program_programId);
		mav.addObject("program_programName", program_programName);
		mav.setViewName("program/teams/deleteTeams.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteProgramTeams")
	public ModelAndView deleteProgramTeams(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer related_teams_teamId) {
		Program program = programService.deleteProgramTeams(program_programId, related_teams_teamId);
		program = programService.updateTeamCounts(program);
		programService.saveProgram(sessionCache.getUser4Session(request), program, null, null, null, null, null);
		ModelAndView mav = editProgram(request, program.getProgramId(), 0);
		return mav;
	}

	/**
	 * Save an existing Team entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveProgramTeams")
	public ModelAndView saveProgramTeams(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id5, @ModelAttribute Team teams) {
		Program parent_program = programService.saveProgramTeams(sessionCache.getTswacct(request), program_programId, selected_id1, selected_id4, selected_id5, teams);
		parent_program = programService.updateTeamCounts(parent_program);
		programService.saveProgram(sessionCache.getUser4Session(request), parent_program, null, null, null, null, null);
		return editProgram(request, parent_program.getProgramId(), 0);
	}
		
}