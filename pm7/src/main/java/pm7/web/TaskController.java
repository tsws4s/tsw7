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

import pm7.dao.ChangerequestDAO;
import pm7.dao.DefectDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TimeentryDAO;

import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Project;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;
import pm7.domain.Timeentry;

import pm7.service.ChangerequestService;
import pm7.service.DefectService;
import pm7.service.PersonService;
import pm7.service.ProjectService;
import pm7.service.RequirementService;
import pm7.service.TaskService;
import pm7.service.TestcaseService;

/**
 * Spring MVC controller that handles CRUD requests for Task entities
 * 
 */

@Controller("TaskController")
public class TaskController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */

	@Autowired
	private ChangerequestDAO changerequestDAO;

	@Autowired
	private DefectDAO defectDAO;

	@Autowired
	private RequirementDAO requirementDAO;

	@Autowired
	private StatusupdateDAO statusupdateDAO;

	@Autowired
	private TaskDAO taskDAO;

	@Autowired
	private TestcaseDAO testcaseDAO;

	@Autowired
	private TimeentryDAO timeentryDAO;
	
	/**
	 * Service injected by Spring that provides CRUD operations for Task entities
	 * 
	 */
	@Autowired
	private TaskService taskService;
	@Autowired
	private ProjectService projectService;
	@Autowired
	private PersonService personService;
	@Autowired
	private RequirementService requirementService;
	@Autowired
	private DefectService defectService;
	@Autowired
	private ChangerequestService changerequestService;
	@Autowired
	private TestcaseService testService;


	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteTaskStatusupdates")
	public ModelAndView deleteTaskStatusupdates(@RequestParam Integer task_taskId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();
		Task task = taskService.deleteTaskStatusupdates(task_taskId, related_statusupdates_statusId);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", task);
		Integer projectId = null;
		if(task.getProject()!=null){
			projectId=task.getProject().getProjectId();
		}
		mav.addObject("project_projectId", projectId);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.setViewName("project/tasks/editTasks.jsp");
		return mav;
	}

	/**
	 * Select the Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTask")
	public ModelAndView confirmDeleteTask(@RequestParam Integer taskIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(taskIdKey));
		mav.setViewName("task/deleteTask.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteTaskRequirement")
	public ModelAndView deleteTaskRequirement(@RequestParam Integer task_taskId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		Task task = taskService.deleteTaskRequirement(task_taskId, related_requirement_reqmtId);
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", task);
		mav.setViewName("task/editTask.jsp");
		return mav;
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newTask")
	public ModelAndView newTask() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("task/editTask.jsp");
		mav.addObject("task", new Task());
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("projects", projectService.loadProjects());		
		mav.addObject("tests", testService.loadTestcases());
		return mav;
	}


	/**
	 * Create a new Timeentry entity
	 * 
	 */
	@RequestMapping("/newTaskTimeentries")
	public ModelAndView newTaskTimeentries(@RequestParam Integer task_taskId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("timeentry", new Timeentry());
		mav.addObject("newFlag", true);
		mav.setViewName("task/timeentries/editTimeentries.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/taskController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTaskRequirement")
	public ModelAndView confirmDeleteTaskRequirement(@RequestParam Integer task_taskId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId));
		mav.addObject("task_taskId", task_taskId);
		mav.setViewName("task/requirement/deleteRequirement.jsp");

		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editTaskStatusupdates")
	public ModelAndView editTaskStatusupdates(@RequestParam Integer task_taskId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		Integer projectId = null;
		if(task.getProject()!=null){
			projectId=task.getProject().getProjectId();
		}
		mav.addObject("project_projectId", projectId);
		mav.addObject("statusupdate", statusupdate);
		mav.addObject("persons", personService.loadPersons());		
		mav.setViewName("task/statusupdates/editStatusupdates.jsp");
		return mav;
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTaskTestcase")
	public ModelAndView confirmDeleteTaskTestcase(@RequestParam Integer task_taskId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId));
		mav.addObject("task_taskId", task_taskId);
		mav.setViewName("task/testcase/deleteTestcase.jsp");

		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveTask")
	public String saveTask(@ModelAttribute Task task) {
		taskService.saveTask(task);
		/*
			public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) { 
		 */
		return "forward:/indexTask";
	}

	/**
	 * Select the child Timeentry entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTaskTimeentries")
	public ModelAndView confirmDeleteTaskTimeentries(@RequestParam Integer task_taskId, @RequestParam Integer related_timeentries_timeEntryId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(related_timeentries_timeEntryId));
		mav.addObject("task_taskId", task_taskId);
		mav.setViewName("task/timeentries/deleteTimeentries.jsp");

		return mav;
	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/saveTaskTimeentries")
	public ModelAndView saveTaskTimeentries(@RequestParam Integer task_taskId, @ModelAttribute Timeentry timeentries) {
		Task parent_task = taskService.saveTaskTimeentries(task_taskId, timeentries);

		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", parent_task);
		mav.setViewName("task/viewTask.jsp");
		mav.addObject("persons", personService.loadPersons());	
		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editTaskRequirement")
	public ModelAndView editTaskRequirement(@RequestParam Integer task_taskId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("requirement", requirement);
		mav.setViewName("task/requirement/editRequirement.jsp");
		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteTaskTestcase")
	public ModelAndView deleteTaskTestcase(@RequestParam Integer task_taskId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();
		Task task = taskService.deleteTaskTestcase(task_taskId, related_testcase_testId);
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", task);
		mav.setViewName("task/editTask.jsp");
		return mav;
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTaskChangerequest")
	public ModelAndView confirmDeleteTaskChangerequest(@RequestParam Integer task_taskId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId));
		mav.addObject("task_taskId", task_taskId);
		mav.setViewName("task/changerequest/deleteChangerequest.jsp");
		return mav;
	}
	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveTaskChangerequest")
	public ModelAndView saveTaskChangerequest(@RequestParam Integer task_taskId, @ModelAttribute Changerequest changerequest) {
		Task parent_task = taskService.saveTaskChangerequest(task_taskId, changerequest);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", parent_task);
		mav.setViewName("task/viewTask.jsp");
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
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveTaskRequirement")
	public ModelAndView saveTaskRequirement(@RequestParam Integer task_taskId, @ModelAttribute Requirement requirement) {
		Task parent_task = taskService.saveTaskRequirement(task_taskId, requirement);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", parent_task);
		mav.setViewName("task/viewTask.jsp");
		return mav;
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTaskStatusupdates")
	public ModelAndView confirmDeleteTaskStatusupdates(@RequestParam Integer task_taskId, @RequestParam Integer related_statusupdates_statusId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		ModelAndView mav = new ModelAndView();
		Integer projectId = null;
		if(task.getProject()!=null){
			projectId=task.getProject().getProjectId();
		}
		mav.addObject("project_projectId", projectId);	
		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId));
		mav.addObject("task_taskId", task_taskId);
		mav.setViewName("task/statusupdates/deleteStatusupdates.jsp");

		return mav;
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTaskDefect")
	public ModelAndView confirmDeleteTaskDefect(@RequestParam Integer task_taskId, @RequestParam Integer related_defect_defectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defect_defectId));
		mav.addObject("task_taskId", task_taskId);
		mav.setViewName("task/defect/deleteDefect.jsp");

		return mav;
	}

	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editTaskDefect")
	public ModelAndView editTaskDefect(@RequestParam Integer task_taskId, @RequestParam Integer defect_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("defect", defect);
		mav.setViewName("task/defect/editDefect.jsp");
		return mav;
	}

	/**
	 * Edit an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/editTaskTimeentries")
	public ModelAndView editTaskTimeentries(@RequestParam Integer task_taskId, @RequestParam Integer timeentries_timeEntryId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentries_timeEntryId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("timeentry", timeentry);
		mav.setViewName("task/timeentries/editTimeentries.jsp");
		mav.addObject("persons", personService.loadPersons());	
		return mav;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteTaskDefect")
	public ModelAndView deleteTaskDefect(@RequestParam Integer task_taskId, @RequestParam Integer related_defect_defectId) {
		ModelAndView mav = new ModelAndView();
		Task task = taskService.deleteTaskDefect(task_taskId, related_defect_defectId);
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", task);
		mav.setViewName("task/editTask.jsp");
		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newTaskDefect")
	public ModelAndView newTaskDefect(@RequestParam Integer task_taskId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("task/defect/editDefect.jsp");
		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newTaskProject")
	public ModelAndView newTaskProject(@RequestParam Integer task_taskId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("task/project/editProject.jsp");

		return mav;
	}

	/**
	 * View an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/selectTaskStatusupdates")
	public ModelAndView selectTaskStatusupdates(@RequestParam Integer task_taskId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("task/statusupdates/viewStatusupdates.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveTaskTestcase")
	public ModelAndView saveTaskTestcase(@RequestParam Integer task_taskId, @ModelAttribute Testcase testcase) {
		Task parent_task = taskService.saveTaskTestcase(task_taskId, testcase);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", parent_task);
		mav.setViewName("task/viewTask.jsp");
		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveTaskDefect")
	public ModelAndView saveTaskDefect(@RequestParam Integer task_taskId, @ModelAttribute Defect defect) {
		Task parent_task = taskService.saveTaskDefect(task_taskId, defect);

		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", parent_task);
		mav.setViewName("task/viewTask.jsp");
		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveTaskStatusupdates")
	public ModelAndView saveTaskStatusupdates(@RequestParam Integer task_taskId, @ModelAttribute Statusupdate statusupdates) {
		Task parent_task = taskService.saveTaskStatusupdates(task_taskId, statusupdates);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", parent_task);
		Integer projectId = null;
		if(parent_task.getProject()!=null){
			projectId=parent_task.getProject().getProjectId();
		}
		mav.addObject("project_projectId", projectId);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.setViewName("project/tasks/editTasks.jsp");
		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newTaskChangerequest")
	public ModelAndView newTaskChangerequest(@RequestParam Integer task_taskId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("task/changerequest/editChangerequest.jsp");
		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newTaskRequirement")
	public ModelAndView newTaskRequirement(@RequestParam Integer task_taskId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("task/requirement/editRequirement.jsp");
		return mav;
	}

	/**
	 * Show all Task entities
	 * 
	 */
	@RequestMapping("/indexTask")
	public ModelAndView listTasks() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("tasks", taskService.loadTasks());
		mav.setViewName("task/listTasks.jsp");
		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editTaskTestcase")
	public ModelAndView editTaskTestcase(@RequestParam Integer task_taskId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("testcase", testcase);
		mav.setViewName("task/testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editTaskChangerequest")
	public ModelAndView editTaskChangerequest(@RequestParam Integer task_taskId, @RequestParam Integer changerequest_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("task/changerequest/editChangerequest.jsp");
		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newTaskStatusupdates")
	public ModelAndView newTaskStatusupdates(@RequestParam Integer task_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		Integer projectId = null;
		if(task.getProject()!=null){
			projectId=task.getProject().getProjectId();
		}
		mav.addObject("project_projectId", projectId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("task/statusupdates/editStatusupdates.jsp");
		mav.addObject("persons", personService.loadPersons());		
		return mav;
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/deleteTaskTimeentries")
	public ModelAndView deleteTaskTimeentries(@RequestParam Integer task_taskId, @RequestParam Integer related_timeentries_timeEntryId) {
		ModelAndView mav = new ModelAndView();
		Task task = taskService.deleteTaskTimeentries(task_taskId, related_timeentries_timeEntryId);
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", task);
		mav.setViewName("task/editTask.jsp");
		return mav;
	}

	/**
	 * Entry point to show all Task entities
	 * 
	 */
	public String indexTask() {
		return "redirect:/indexTask";
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteTask")
	public String deleteTask(@RequestParam Integer taskIdKey) {
		Task task = taskDAO.findTaskByPrimaryKey(taskIdKey);
		taskService.deleteTask(task);
		return "forward:/indexTask";
	}

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newTaskTestcase")
	public ModelAndView newTaskTestcase(@RequestParam Integer task_taskId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("task/testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteTaskChangerequest")
	public ModelAndView deleteTaskChangerequest(@RequestParam Integer task_taskId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		Task task = taskService.deleteTaskChangerequest(task_taskId, related_changerequest_changeId);
		mav.addObject("task_taskId", task_taskId);
		mav.addObject("task", task);
		mav.setViewName("task/editTask.jsp");
		return mav;
	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editTask")
	public ModelAndView editTask(@RequestParam Integer taskIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("task", taskDAO.findTaskByPrimaryKey(taskIdKey));
		mav.setViewName("task/editTask.jsp");
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("projects", projectService.loadProjects());		
		return mav;
	}
}