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
import pm7.dao.TaskDAO;
import pm7.dao.TimeentryDAO;

import pm7.domain.Account;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Task;
import pm7.domain.Timeentry;

import pm7.service.TimeentryService;

/**
 * Spring MVC controller that handles CRUD requests for Timeentry entities
 * 
 */

@Controller("TimeentryController")
public class TimeentryController {

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
	 * DAO injected by Spring that manages Task entities
	 * 
	 */
	@Autowired
	private TaskDAO taskDAO;

	/**
	 * DAO injected by Spring that manages Timeentry entities
	 * 
	 */
	@Autowired
	private TimeentryDAO timeentryDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Timeentry entities
	 * 
	 */
	@Autowired
	private TimeentryService timeentryService;

	/**
	 * Show all Project entities by Timeentry
	 * 
	 */
	@RequestMapping("/listTimeentryProject")
	public ModelAndView listTimeentryProject(@RequestParam Integer timeEntryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey));
		mav.setViewName("timeentry/project/listProject.jsp");

		return mav;
	}

	/**
	 * Show all Person entities by Timeentry
	 * 
	 */
	@RequestMapping("/listTimeentryPerson")
	public ModelAndView listTimeentryPerson(@RequestParam Integer timeEntryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey));
		mav.setViewName("timeentry/person/listPerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editTimeentryProject")
	public ModelAndView editTimeentryProject(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("project", project);
		mav.setViewName("timeentry/project/editProject.jsp");

		return mav;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deleteTimeentryPerson")
	public ModelAndView deleteTimeentryPerson(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		Timeentry timeentry = timeentryService.deleteTimeentryPerson(timeentry_timeEntryId, related_person_personId);

		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newTimeentryAccount")
	public ModelAndView newTimeentryAccount(@RequestParam Integer timeentry_timeEntryId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("timeentry/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Select the child Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTimeentryPerson")
	public ModelAndView confirmDeleteTimeentryPerson(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(related_person_personId));
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.setViewName("timeentry/person/deletePerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteTimeentryAccount")
	public ModelAndView deleteTimeentryAccount(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Timeentry timeentry = timeentryService.deleteTimeentryAccount(timeentry_timeEntryId, related_account_accountId);

		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/saveTimeentry")
	public String saveTimeentry(@ModelAttribute Timeentry timeentry) {
		timeentryService.saveTimeentry(timeentry);
		return "forward:/indexTimeentry";
	}

	/**
	 * View an existing Task entity
	 * 
	 */
	@RequestMapping("/selectTimeentryTask")
	public ModelAndView selectTimeentryTask(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer task_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("task", task);
		mav.setViewName("timeentry/task/viewTask.jsp");

		return mav;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteTimeentryTask")
	public ModelAndView deleteTimeentryTask(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_task_taskId) {
		ModelAndView mav = new ModelAndView();

		Timeentry timeentry = timeentryService.deleteTimeentryTask(timeentry_timeEntryId, related_task_taskId);

		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Timeentry
	 * 
	 */
	@RequestMapping("/listTimeentryAccount")
	public ModelAndView listTimeentryAccount(@RequestParam Integer timeEntryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey));
		mav.setViewName("timeentry/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteTimeentryProject")
	public ModelAndView deleteTimeentryProject(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Timeentry timeentry = timeentryService.deleteTimeentryProject(timeentry_timeEntryId, related_project_projectId);

		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTimeentryTask")
	public ModelAndView confirmDeleteTimeentryTask(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_task_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_task_taskId));
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.setViewName("timeentry/task/deleteTask.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editTimeentryAccount")
	public ModelAndView editTimeentryAccount(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("account", account);
		mav.setViewName("timeentry/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveTimeentryPerson")
	public ModelAndView saveTimeentryPerson(@RequestParam Integer timeentry_timeEntryId, @ModelAttribute Person person) {
		Timeentry parent_timeentry = timeentryService.saveTimeentryPerson(timeentry_timeEntryId, person);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", parent_timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveTimeentryTask")
	public ModelAndView saveTimeentryTask(@RequestParam Integer timeentry_timeEntryId, @ModelAttribute Task task) {
		Timeentry parent_timeentry = timeentryService.saveTimeentryTask(timeentry_timeEntryId, task);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", parent_timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectTimeentryAccount")
	public ModelAndView selectTimeentryAccount(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("account", account);
		mav.setViewName("timeentry/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveTimeentryProject")
	public ModelAndView saveTimeentryProject(@RequestParam Integer timeentry_timeEntryId, @ModelAttribute Project project) {
		Timeentry parent_timeentry = timeentryService.saveTimeentryProject(timeentry_timeEntryId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", parent_timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/timeentryController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editTimeentryTask")
	public ModelAndView editTimeentryTask(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer task_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("task", task);
		mav.setViewName("timeentry/task/editTask.jsp");

		return mav;
	}

	/**
	 * Create a new Timeentry entity
	 * 
	 */
	@RequestMapping("/newTimeentry")
	public ModelAndView newTimeentry() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", new Timeentry());
		mav.addObject("newFlag", true);
		mav.setViewName("timeentry/editTimeentry.jsp");

		return mav;
	}

	/**
	 * Edit an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/editTimeentry")
	public ModelAndView editTimeentry(@RequestParam Integer timeEntryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey));
		mav.setViewName("timeentry/editTimeentry.jsp");

		return mav;
	}

	/**
	 * View an existing Person entity
	 * 
	 */
	@RequestMapping("/selectTimeentryPerson")
	public ModelAndView selectTimeentryPerson(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("person", person);
		mav.setViewName("timeentry/person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newTimeentryProject")
	public ModelAndView newTimeentryProject(@RequestParam Integer timeentry_timeEntryId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("timeentry/project/editProject.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTimeentryAccount")
	public ModelAndView confirmDeleteTimeentryAccount(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.setViewName("timeentry/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editTimeentryPerson")
	public ModelAndView editTimeentryPerson(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("person", person);
		mav.setViewName("timeentry/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/deleteTimeentry")
	public String deleteTimeentry(@RequestParam Integer timeEntryIdKey) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey);
		timeentryService.deleteTimeentry(timeentry);
		return "forward:/indexTimeentry";
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTimeentryProject")
	public ModelAndView confirmDeleteTimeentryProject(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.setViewName("timeentry/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newTimeentryTask")
	public ModelAndView newTimeentryTask(@RequestParam Integer timeentry_timeEntryId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("timeentry/task/editTask.jsp");

		return mav;
	}

	/**
	 * Show all Task entities by Timeentry
	 * 
	 */
	@RequestMapping("/listTimeentryTask")
	public ModelAndView listTimeentryTask(@RequestParam Integer timeEntryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey));
		mav.setViewName("timeentry/task/listTask.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveTimeentryAccount")
	public ModelAndView saveTimeentryAccount(@RequestParam Integer timeentry_timeEntryId, @ModelAttribute Account account) {
		Timeentry parent_timeentry = timeentryService.saveTimeentryAccount(timeentry_timeEntryId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("timeentry", parent_timeentry);
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Timeentry entities
	 * 
	 */
	public String indexTimeentry() {
		return "redirect:/indexTimeentry";
	}

	/**
	 * Select an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/selectTimeentry")
	public ModelAndView selectTimeentry(@RequestParam Integer timeEntryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey));
		mav.setViewName("timeentry/viewTimeentry.jsp");

		return mav;
	}

	/**
	 * Select the Timeentry entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTimeentry")
	public ModelAndView confirmDeleteTimeentry(@RequestParam Integer timeEntryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(timeEntryIdKey));
		mav.setViewName("timeentry/deleteTimeentry.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectTimeentryProject")
	public ModelAndView selectTimeentryProject(@RequestParam Integer timeentry_timeEntryId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("project", project);
		mav.setViewName("timeentry/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newTimeentryPerson")
	public ModelAndView newTimeentryPerson(@RequestParam Integer timeentry_timeEntryId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("timeentry_timeEntryId", timeentry_timeEntryId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("timeentry/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Show all Timeentry entities
	 * 
	 */
	@RequestMapping("/indexTimeentry")
	public ModelAndView listTimeentrys() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentrys", timeentryService.loadTimeentrys());

		mav.setViewName("timeentry/listTimeentrys.jsp");

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
}