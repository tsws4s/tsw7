package tsw.web;

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

import tsw.domain.Program;
import tsw.domain.Sport;
import tsw.domain.Team;
import tsw.domain.Teamplayers;

import tsw.service.ProgramService;
import tsw.service.SportpositionService;
import tsw.service.TeamService;
import tsw.service.TeamplayersService;

/**
 * Spring MVC controller that handles CRUD requests for Team entities
 * 
 */

@Controller("TeamController")
public class TeamController {

	static int defaultMaxRows = 10;
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * Service injected by Spring that provides CRUD operations for Team entities
	 * 
	 */
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private TeamplayersService teamplayersService;
	
	@Autowired
	private ProgramService programService;
	
	@Autowired
	private ProgramController pgmController;
	
	@Autowired
	private SportpositionService sportpositionService;
	
	// Init
	/**  ***************************************  Init  *******************************************************
	 * Register custom, context-specific property editors
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
	@RequestMapping("/teamController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}


	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all Team entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexTeam")
	public ModelAndView listTeams(HttpServletRequest request) {
		return listTeamsFrom(request, 0);
	}

	/**
	 * Entry point to show all Team entities
	 * 
	 */
	public String indexTeam() {
		return "redirect:/indexTeam";
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
		@RequestMapping("/indexTeamFrom")
		public ModelAndView listTeamsFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Set<Program> pgmLeagues = programService.loadLeagues4tsw(sessionCache.getTswacct(request));
		mav.addObject("leagues", pgmLeagues);
		mav.addObject("program", pgmLeagues.iterator().next());
		mav.addObject("user",sessionCache.getUser4Session(request));
	//	mav.addObject("teams", teamService.loadTeams());
		mav.setViewName("program/teams/listTeams.jsp");
		return mav;
	}
	@RequestMapping("/searchTeam")
	public ModelAndView searchTeams(HttpServletRequest request, @RequestParam Integer program_programId, @RequestParam Integer teamNum) {
		return searchTeamsFrom(request, 0, program_programId, teamNum);
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchTeamFrom")
	public ModelAndView searchTeamsFrom(HttpServletRequest request, @RequestParam int indexFrom, @RequestParam Integer program_programId, @RequestParam Integer teamNum) {
		ModelAndView mav = new ModelAndView();
		Program pgm = programService.findProgramByPrimaryKey(program_programId);
		mav.addObject("program", pgm);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("team/searchTeams.jsp");
		mav.addObject("teamNum", teamNum);
		mav.addObject("searchFlag", true);
		return mav;
	}

	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * 	 * Create a new Team entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newTeam")
	public ModelAndView newTeam(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Team tm = new Team();
		tm.setActiveYn(1);
		mav.addObject("team", tm);
		mav.addObject("newFlag", true);
		mav.setViewName("team/editTeam.jsp");

		return mav;
	}
	
	/**
	 * Edit an existing Team entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editTeam")
	public ModelAndView editTeam(HttpServletRequest request, @RequestParam Integer teamIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("team", teamService.findTeamByPrimaryKey(teamIdKey));
		mav.setViewName("team/editTeam.jsp");

		return mav;
	}

	/**
	 * Select the Team entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteTeam")
	public ModelAndView confirmDeleteTeam(HttpServletRequest request, @RequestParam Integer teamIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.addObject("team", teamService.findTeamByPrimaryKey(teamIdKey));
		mav.setViewName("team/deleteTeam.jsp");

		return mav;
	}
	
	/**
	 * Delete an existing Team entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteTeam")
	public String deleteTeam(HttpServletRequest request, @RequestParam Integer teamIdKey) {
		Team team = teamService.findTeamByPrimaryKey(teamIdKey);
		teamService.deleteTeam(team);
		return "forward:/indexTeam";
	}
	
	/**
	 * Save an existing Team entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveTeam")
	public String saveTeam(HttpServletRequest request, @ModelAttribute Team team) {
		teamService.saveTeam(team);
		return "forward:/indexTeam";
	}
	
	
	// Teamplayers
	/**  ********************  AEDS Team Teamplayers  ********************************
	 * Select the child Teamplayers entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteTeamTeamplayerses")
	public ModelAndView confirmDeleteTeamTeamplayerses(HttpServletRequest request, @RequestParam Integer team_teamId, @RequestParam Integer related_teamplayerses_teamPlayersId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.addObject("teamplayers", teamplayersService.findTeamplayersByPrimaryKey(related_teamplayerses_teamPlayersId));
		mav.addObject("team_teamId", team_teamId);
		mav.setViewName("team/teamplayerses/deleteTeamplayerses.jsp");

		return mav;
	}
	/**
	 * Delete an existing Teamplayers entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteTeamTeamplayerses")
	public ModelAndView deleteTeamTeamplayerses(HttpServletRequest request, @RequestParam Integer team_teamId, @RequestParam Integer related_teamplayerses_teamPlayersId) {
		Team team = teamService.deleteTeamTeamplayerses(team_teamId, related_teamplayerses_teamPlayersId);
		teamService.updateTeamplayerCounts(team);
		Program pgm = team.getProgram();
		programService.saveProgramTeams(sessionCache.getTswacct(request), pgm.getProgramId(), null, null, null, team);
		programService.updateTeamCounts(pgm);
		programService.saveProgram(sessionCache.getUser4Session(request), pgm, null, null, null, null, null);		
		return  pgmController.editProgramTeams(request, pgm.getProgramId(), pgm.getProgramName(),team.getTeamId());
	}

	/**
	 * Edit an existing Teamplayers entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editTeamTeamplayerses")
	public ModelAndView editTeamTeamplayerses(HttpServletRequest request, @RequestParam Integer team_teamId, @RequestParam Integer teamplayerses_teamPlayersId) {
		Teamplayers teamplayers = teamplayersService.findTeamplayersByPrimaryKey(teamplayerses_teamPlayersId);
		Team team = teamService.findTeamByPrimaryKey(team_teamId);
		Sport sport = team.getProgram().getSport();
		ModelAndView mav = new ModelAndView();
		mav.addObject("team_teamId", team_teamId);
		mav.addObject("team", team);
		mav.addObject("teamplayers", teamplayers);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.addObject("sport", sport);
		Integer startResult= -1;
		mav.addObject("positions", sportpositionService.findAllSportpositionsForSport(startResult, defaultMaxRows, sport.getSportId()));
		mav.addObject("newFlag", false);
		mav.setViewName("team/teamplayerses/editTeamplayerses.jsp");

		return mav;
	}
	
	/**
	 * Save an existing Teamplayers entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveTeamTeamplayerses")
	public ModelAndView saveTeamTeamplayerses(HttpServletRequest request, @RequestParam Integer team_teamId, @RequestParam Integer selected_id4, @RequestParam Integer selected_sportPosition_id1, @ModelAttribute Teamplayers teamplayerses) {
		Team parent_team = teamService.saveTeamTeamplayerses(sessionCache.getTswacct(request), team_teamId, selected_id4, selected_sportPosition_id1, teamplayerses);
		teamService.updateTeamplayerCounts(parent_team);
		Program pgm = parent_team.getProgram();
		programService.saveProgramTeams(sessionCache.getTswacct(request), pgm.getProgramId(), null, null, null, parent_team);
		programService.updateTeamCounts(pgm);
		programService.saveProgram(sessionCache.getUser4Session(request), pgm, null, null, null, null, null);
		return  pgmController.editProgramTeams(request, pgm.getProgramId(), pgm.getProgramName(),parent_team.getTeamId());
	}

	/**
	 * Create a new Teamplayers entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newTeamTeamplayerses")
	public ModelAndView newTeamTeamplayerses(HttpServletRequest request, @RequestParam Integer team_teamId) {
		ModelAndView mav = new ModelAndView();
		Team team = teamService.findTeamByPrimaryKey(team_teamId);
		Sport sport = team.getProgram().getSport();
		Teamplayers tmPlyr = new Teamplayers();
		tmPlyr.setProgram(team.getProgram());
		tmPlyr.setLevel(team.getLevel());
		tmPlyr.setTswacct(team.getTswacct());
		tmPlyr.setActiveYn(new Integer(1));
		tmPlyr.setTeam(team);
		mav.addObject("team_teamId", team_teamId);
		mav.addObject("team", team);
		mav.addObject("teamplayers", tmPlyr);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.addObject("sport", sport);
		Integer startResult= -1;
		mav.addObject("positions", sportpositionService.findAllSportpositionsForSport(startResult, defaultMaxRows, sport.getSportId()));
		mav.addObject("newFlag", true);
		mav.setViewName("team/teamplayerses/editTeamplayerses.jsp");

		return mav;
	}

}