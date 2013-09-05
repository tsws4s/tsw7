package pm7.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import pm7.dao.AccountDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ProjectteamDAO;

import pm7.domain.Account;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Projectteam;

import pm7.service.ProjectteamService;

/**
 * Spring MVC controller that handles CRUD requests for Projectteam entities
 * 
 */

@Controller("ProjectteamController")
public class ProjectteamController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Person entities
	 * 
	 */
	@Autowired
	private PersonDAO personDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Projectteam entities
	 * 
	 */
	@Autowired
	private ProjectteamDAO projectteamDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Projectteam entities
	 * 
	 */
	@Autowired
	private ProjectteamService projectteamService;

	/**
	 * Select the child Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectteamPerson")
	public ModelAndView confirmDeleteProjectteamPerson(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(related_person_personId));
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.setViewName("projectteam/person/deletePerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteProjectteamAccount")
	public ModelAndView deleteProjectteamAccount(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Projectteam projectteam = projectteamService.deleteProjectteamAccount(projectteam_projectTeamId, related_account_accountId);

		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("projectteam", projectteam);
		mav.setViewName("projectteam/viewProjectteam.jsp");

		return mav;
	}

	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editProjectteamPerson")
	public ModelAndView editProjectteamPerson(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("person", person);
		mav.setViewName("projectteam/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveProjectteamPerson")
	public ModelAndView saveProjectteamPerson(@RequestParam Integer projectteam_projectTeamId, @ModelAttribute Person person) {
		Projectteam parent_projectteam = projectteamService.saveProjectteamPerson(projectteam_projectTeamId, person);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("projectteam", parent_projectteam);
		mav.setViewName("projectteam/viewProjectteam.jsp");

		return mav;
	}

	/**
	 * Select an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/selectProjectteam")
	public ModelAndView selectProjectteam(@RequestParam Integer projectTeamIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(projectTeamIdKey));
		mav.setViewName("projectteam/viewProjectteam.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectProjectteamAccount")
	public ModelAndView selectProjectteamAccount(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("account", account);
		mav.setViewName("projectteam/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Select the Projectteam entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectteam")
	public ModelAndView confirmDeleteProjectteam(@RequestParam Integer projectTeamIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(projectTeamIdKey));
		mav.setViewName("projectteam/deleteProjectteam.jsp");

		return mav;
	}

	/**
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
	 * Create a new Projectteam entity
	 * 
	 */
	@RequestMapping("/newProjectteam")
	public ModelAndView newProjectteam() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", new Projectteam());
		mav.addObject("newFlag", true);
		mav.setViewName("projectteam/editProjectteam.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveProjectteamProject")
	public ModelAndView saveProjectteamProject(@RequestParam Integer projectteam_projectTeamId, @ModelAttribute Project project) {
		Projectteam parent_projectteam = projectteamService.saveProjectteamProject(projectteam_projectTeamId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("projectteam", parent_projectteam);
		mav.setViewName("projectteam/viewProjectteam.jsp");

		return mav;
	}

	/**
	 * Show all Person entities by Projectteam
	 * 
	 */
	@RequestMapping("/listProjectteamPerson")
	public ModelAndView listProjectteamPerson(@RequestParam Integer projectTeamIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(projectTeamIdKey));
		mav.setViewName("projectteam/person/listPerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/deleteProjectteam")
	public String deleteProjectteam(@RequestParam Integer projectTeamIdKey) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectTeamIdKey);
		projectteamService.deleteProjectteam(projectteam);
		return "forward:/indexProjectteam";
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteProjectteamProject")
	public ModelAndView deleteProjectteamProject(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Projectteam projectteam = projectteamService.deleteProjectteamProject(projectteam_projectTeamId, related_project_projectId);

		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("projectteam", projectteam);
		mav.setViewName("projectteam/viewProjectteam.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveProjectteamAccount")
	public ModelAndView saveProjectteamAccount(@RequestParam Integer projectteam_projectTeamId, @ModelAttribute Account account) {
		Projectteam parent_projectteam = projectteamService.saveProjectteamAccount(projectteam_projectTeamId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("projectteam", parent_projectteam);
		mav.setViewName("projectteam/viewProjectteam.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectProjectteamProject")
	public ModelAndView selectProjectteamProject(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("project", project);
		mav.setViewName("projectteam/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/editProjectteam")
	public ModelAndView editProjectteam(@RequestParam Integer projectTeamIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(projectTeamIdKey));
		mav.setViewName("projectteam/editProjectteam.jsp");

		return mav;
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newProjectteamPerson")
	public ModelAndView newProjectteamPerson(@RequestParam Integer projectteam_projectTeamId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("projectteam/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newProjectteamAccount")
	public ModelAndView newProjectteamAccount(@RequestParam Integer projectteam_projectTeamId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("projectteam/account/editAccount.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/projectteamController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all Account entities by Projectteam
	 * 
	 */
	@RequestMapping("/listProjectteamAccount")
	public ModelAndView listProjectteamAccount(@RequestParam Integer projectTeamIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(projectTeamIdKey));
		mav.setViewName("projectteam/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editProjectteamAccount")
	public ModelAndView editProjectteamAccount(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("account", account);
		mav.setViewName("projectteam/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editProjectteamProject")
	public ModelAndView editProjectteamProject(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("project", project);
		mav.setViewName("projectteam/project/editProject.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Projectteam
	 * 
	 */
	@RequestMapping("/listProjectteamProject")
	public ModelAndView listProjectteamProject(@RequestParam Integer projectTeamIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(projectTeamIdKey));
		mav.setViewName("projectteam/project/listProject.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectteamAccount")
	public ModelAndView confirmDeleteProjectteamAccount(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.setViewName("projectteam/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * View an existing Person entity
	 * 
	 */
	@RequestMapping("/selectProjectteamPerson")
	public ModelAndView selectProjectteamPerson(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("person", person);
		mav.setViewName("projectteam/person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deleteProjectteamPerson")
	public ModelAndView deleteProjectteamPerson(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		Projectteam projectteam = projectteamService.deleteProjectteamPerson(projectteam_projectTeamId, related_person_personId);

		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("projectteam", projectteam);
		mav.setViewName("projectteam/viewProjectteam.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newProjectteamProject")
	public ModelAndView newProjectteamProject(@RequestParam Integer projectteam_projectTeamId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("projectteam/project/editProject.jsp");

		return mav;
	}

	/**
	 * Show all Projectteam entities
	 * 
	 */
	@RequestMapping("/indexProjectteam")
	public ModelAndView listProjectteams() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteams", projectteamService.loadProjectteams());

		mav.setViewName("projectteam/listProjectteams.jsp");

		return mav;
	}

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/saveProjectteam")
	public String saveProjectteam(@ModelAttribute Projectteam projectteam) {
		projectteamService.saveProjectteam(projectteam);
		return "forward:/indexProjectteam";
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectteamProject")
	public ModelAndView confirmDeleteProjectteamProject(@RequestParam Integer projectteam_projectTeamId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("projectteam_projectTeamId", projectteam_projectTeamId);
		mav.setViewName("projectteam/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Projectteam entities
	 * 
	 */
	public String indexProjectteam() {
		return "redirect:/indexProjectteam";
	}
}