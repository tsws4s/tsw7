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

import pm7.dao.AttachmentDAO;
import pm7.dao.ChangerequestDAO;
import pm7.dao.ClientDAO;
import pm7.dao.DefectDAO;
import pm7.dao.FeatureDAO;
import pm7.dao.InvoiceDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ProjectteamDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TimeentryDAO;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Client;
import pm7.domain.Defect;
import pm7.domain.Feature;
import pm7.domain.Invoice;
import pm7.domain.Project;
import pm7.domain.Projectteam;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;
import pm7.domain.Timeentry;

import pm7.service.AccountService;
import pm7.service.ChangerequestService;
import pm7.service.ClientService;
import pm7.service.DefectService;
import pm7.service.FeatureService;
import pm7.service.PersonService;
import pm7.service.ProjectService;
import pm7.service.RequirementService;
import pm7.service.TaskService;
import pm7.service.TestcaseService;
import pm7.util.TaskScheduling;

/**
 * Spring MVC controller that handles CRUD requests for Project entities
 * 
 */

@Controller("ProjectController")
public class ProjectController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */

	@Autowired
	private AttachmentDAO attachmentDAO;

	@Autowired
	private ChangerequestDAO changerequestDAO;

	@Autowired
	private ClientDAO clientDAO;

	@Autowired
	private DefectDAO defectDAO;

	@Autowired
	private FeatureDAO featureDAO;

	@Autowired
	private InvoiceDAO invoiceDAO;

	@Autowired
	private ProjectDAO projectDAO;

	@Autowired
	private ProjectteamDAO projectteamDAO;

	@Autowired
	private ReleaseplanDAO releaseplanDAO;

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
	 * Service injected by Spring that provides CRUD operations for Project entities
	 * 
	 */
	@Autowired
	private ProjectService projectService;
	@Autowired
	private AccountService acctService;
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
	@Autowired
	private ClientService clientService;
	@Autowired
	private FeatureService featureService;
	@Autowired
	private TaskService taskService;

	/**
	 */
	@RequestMapping("/projectController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/saveProjectTimeentries")
	public ModelAndView saveProjectTimeentries(@RequestParam Integer project_projectId, @ModelAttribute Timeentry timeentries) {
		Project parent_project = projectService.saveProjectTimeentries(project_projectId, timeentries);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("project", parent_project);
		mav.setViewName("project/viewProject.jsp");

		return mav;
	}


	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editProject")
	public ModelAndView editProject(@RequestParam Integer projectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(projectIdKey));
		mav.addObject("persons", personService.loadPersons());	
		mav.addObject("clients", clientService.loadClients());		
		mav.setViewName("project/editProject.jsp");

		return mav;
	}


	/**
	 * Save an existing Feature entity
	 * 
	 */
	@RequestMapping("/saveProjectFeatures")
	public ModelAndView saveProjectFeatures(@RequestParam Integer project_projectId, @ModelAttribute Feature features) {
		projectService.saveProjectFeatures(project_projectId, features);
		return editProject(project_projectId);

	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@RequestMapping("/deleteProjectFeatures")
	public ModelAndView deleteProjectFeatures(@RequestParam Integer project_projectId, @RequestParam Integer related_features_featureId) {
		projectService.deleteProjectFeatures(project_projectId, related_features_featureId);
		return editProject(project_projectId);
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteProject")
	public String deleteProject(@RequestParam Integer projectIdKey) {
		Project project = projectDAO.findProjectByPrimaryKey(projectIdKey);
		projectService.deleteProject(project);
		return "forward:/indexProject";
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectStatusupdates")
	public ModelAndView confirmDeleteProjectStatusupdates(@RequestParam Integer project_projectId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/statusupdates/deleteStatusupdates.jsp");

		return mav;
	}

	/**
	 * Select the child Invoice entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectInvoices")
	public ModelAndView confirmDeleteProjectInvoices(@RequestParam Integer project_projectId, @RequestParam Integer related_invoices_invoiceId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("invoice", invoiceDAO.findInvoiceByPrimaryKey(related_invoices_invoiceId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/invoices/deleteInvoices.jsp");

		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/saveProjectAttachments")
	public ModelAndView saveProjectAttachments(@RequestParam Integer project_projectId, @ModelAttribute Attachment attachments) {
		projectService.saveProjectAttachments(project_projectId, attachments);
		return editProject(project_projectId);
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveProjectStatusupdates")
	public ModelAndView saveProjectStatusupdates(@RequestParam Integer project_projectId, @ModelAttribute Statusupdate statusupdates) {
		projectService.saveProjectStatusupdates(project_projectId, statusupdates);
		return editProject(project_projectId);
	}

	/**
	 * Save an existing Invoice entity
	 * 
	 */
	@RequestMapping("/saveProjectInvoices")
	public ModelAndView saveProjectInvoices(@RequestParam Integer project_projectId, @ModelAttribute Invoice invoices) {
		projectService.saveProjectInvoices(project_projectId, invoices);
		return editProject(project_projectId);
	}

	/**
	 * Select the child Releaseplan entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectReleaseplans")
	public ModelAndView confirmDeleteProjectReleaseplans(@RequestParam Integer project_projectId, @RequestParam Integer related_releaseplans_releaseId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplans_releaseId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/releaseplans/deleteReleaseplans.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteProjectChangerequests")
	public ModelAndView deleteProjectChangerequests(@RequestParam Integer project_projectId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		Project project = projectService.deleteProjectChangerequests(project_projectId, related_changerequests_changeId);

		mav.addObject("project_projectId", project_projectId);
		mav.addObject("project", project);
		mav.setViewName("project/viewProject.jsp");

		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveProjectDefects")
	public ModelAndView saveProjectDefects(@RequestParam Integer project_projectId, @ModelAttribute Defect defects) {
		projectService.saveProjectDefects(project_projectId, defects);
		return editProject(project_projectId);
	}

	/**
	 * Create a new Timeentry entity
	 * 
	 */
	@RequestMapping("/newProjectTimeentries")
	public ModelAndView newProjectTimeentries(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("timeentry", new Timeentry());
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("newFlag", true);
		mav.setViewName("project/timeentries/editTimeentries.jsp");

		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newProjectAttachments")
	public ModelAndView newProjectAttachments(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("project/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Edit an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/editProjectReleaseplans")
	public ModelAndView editProjectReleaseplans(@RequestParam Integer project_projectId, @RequestParam Integer releaseplans_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplans_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("releaseplan", releaseplan);
		mav.addObject("persons", personService.loadPersons());		
		mav.setViewName("project/releaseplans/editReleaseplans.jsp");

		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newProjectStatusupdates")
	public ModelAndView newProjectStatusupdates(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("newFlag", true);
		mav.setViewName("project/statusupdates/editStatusupdates.jsp");

		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveProjectChangerequests")
	public ModelAndView saveProjectChangerequests(@RequestParam Integer project_projectId, @ModelAttribute Changerequest changerequests) {
		projectService.saveProjectChangerequests(project_projectId, changerequests);
		return editProject(project_projectId);
	}

	/**
	 * Select the child Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectAttachments")
	public ModelAndView confirmDeleteProjectAttachments(@RequestParam Integer project_projectId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/attachments/deleteAttachments.jsp");

		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectRequirements")
	public ModelAndView confirmDeleteProjectRequirements(@RequestParam Integer project_projectId, @RequestParam Integer related_requirements_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirements_reqmtId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/requirements/deleteRequirements.jsp");

		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newProjectRequirements")
	public ModelAndView newProjectRequirements(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("features", featureService.loadFeatures());		
		mav.addObject("newFlag", true);
		mav.setViewName("project/requirements/editRequirements.jsp");

		return mav;
	}

	/**
	 * Delete an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/deleteProjectProjectteams")
	public ModelAndView deleteProjectProjectteams(@RequestParam Integer project_projectId, @RequestParam Integer related_projectteams_projectTeamId) {
		projectService.deleteProjectProjectteams(project_projectId, related_projectteams_projectTeamId);
		return editProject(project_projectId);
	}


	/**
	 * Entry point to show all Project entities
	 * 
	 */
	public String indexProject() {
		return "redirect:/indexProject";
	}

	/**
	 * Show all Project entities
	 * 
	 */
	@RequestMapping("/indexProject")
	public ModelAndView listProjects() {
		ModelAndView mav = new ModelAndView();
		TaskScheduling.start(acctService);
		mav.addObject("projects", projectService.loadProjects());
		mav.setViewName("project/listProjects.jsp");

		return mav;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/deleteProjectReleaseplans")
	public ModelAndView deleteProjectReleaseplans(@RequestParam Integer project_projectId, @RequestParam Integer related_releaseplans_releaseId) {
		projectService.deleteProjectReleaseplans(project_projectId, related_releaseplans_releaseId);
		return editProject(project_projectId);
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newProjectTasks")
	public ModelAndView newProjectTasks(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("task", new Task());
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.addObject("newFlag", true);
		mav.setViewName("project/tasks/editTasks.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editProjectTestcases")
	public ModelAndView editProjectTestcases(@RequestParam Integer project_projectId, @RequestParam Integer testcases_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcases_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("testcase", testcase);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.setViewName("project/testcases/editTestcases.jsp");
		return mav;
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/deleteProjectTimeentries")
	public ModelAndView deleteProjectTimeentries(@RequestParam Integer project_projectId, @RequestParam Integer related_timeentries_timeEntryId) {
		projectService.deleteProjectTimeentries(project_projectId, related_timeentries_timeEntryId);
		return editProject(project_projectId);
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveProjectTasks")
	public ModelAndView saveProjectTasks(@RequestParam Integer project_projectId, @ModelAttribute Task tasks) {
		projectService.saveProjectTasks(project_projectId, tasks);
		return editProject(project_projectId);
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editProjectAttachments")
	public ModelAndView editProjectAttachments(@RequestParam Integer project_projectId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("attachment", attachment);
		mav.setViewName("project/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Select the child Projectteam entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectProjectteams")
	public ModelAndView confirmDeleteProjectProjectteams(@RequestParam Integer project_projectId, @RequestParam Integer related_projectteams_projectTeamId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("projectteam", projectteamDAO.findProjectteamByPrimaryKey(related_projectteams_projectTeamId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/projectteams/deleteProjectteams.jsp");

		return mav;
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectDefects")
	public ModelAndView confirmDeleteProjectDefects(@RequestParam Integer project_projectId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defects_defectId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/defects/deleteDefects.jsp");

		return mav;
	}

	/**
	 * Select the child Timeentry entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectTimeentries")
	public ModelAndView confirmDeleteProjectTimeentries(@RequestParam Integer project_projectId, @RequestParam Integer related_timeentries_timeEntryId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("timeentry", timeentryDAO.findTimeentryByPrimaryKey(related_timeentries_timeEntryId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/timeentries/deleteTimeentries.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteProjectRequirements")
	public ModelAndView deleteProjectRequirements(@RequestParam Integer project_projectId, @RequestParam Integer related_requirements_reqmtId) {
		projectService.deleteProjectRequirements(project_projectId, related_requirements_reqmtId);
		return editProject(project_projectId);

	}


	/**
	 * Select the Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProject")
	public ModelAndView confirmDeleteProject(@RequestParam Integer projectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(projectIdKey));
		mav.setViewName("project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveProject")
	public String saveProject(@ModelAttribute Project project, @RequestParam Integer selected_id1, @RequestParam Integer selected_id2) {
		projectService.saveProject(project, selected_id1, selected_id2);
		return "forward:/indexProject";
	}


	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteProjectTestcases")
	public ModelAndView deleteProjectTestcases(@RequestParam Integer project_projectId, @RequestParam Integer related_testcases_testId) {
		projectService.deleteProjectTestcases(project_projectId, related_testcases_testId);
		return editProject(project_projectId);

	}

	/**
	 * Save an existing Client entity
	 * 
	 */
	@RequestMapping("/saveProjectClient")
	public ModelAndView saveProjectClient(@RequestParam Integer project_projectId, @ModelAttribute Client client) {
		projectService.saveProjectClient(project_projectId, client);
		return editProject(project_projectId);
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteProjectStatusupdates")
	public ModelAndView deleteProjectStatusupdates(@RequestParam Integer project_projectId, @RequestParam Integer related_statusupdates_statusId) {
		projectService.deleteProjectStatusupdates(project_projectId, related_statusupdates_statusId);
		return editProject(project_projectId);
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editProjectRequirements")
	public ModelAndView editProjectRequirements(@RequestParam Integer project_projectId, @RequestParam Integer requirements_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirements_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("requirement", requirement);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.setViewName("project/requirements/editRequirements.jsp");

		return mav;
	}

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newProjectTestcases")
	public ModelAndView newProjectTestcases(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());				
		mav.setViewName("project/testcases/editTestcases.jsp");

		return mav;
	}


	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectTasks")
	public ModelAndView confirmDeleteProjectTasks(@RequestParam Integer project_projectId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_tasks_taskId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/tasks/deleteTasks.jsp");

		return mav;
	}

	/**
	 * Select the child Feature entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectFeatures")
	public ModelAndView confirmDeleteProjectFeatures(@RequestParam Integer project_projectId, @RequestParam Integer related_features_featureId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(related_features_featureId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/features/deleteFeatures.jsp");

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
	 * Create a new Releaseplan entity
	 * 
	 */
	@RequestMapping("/newProjectReleaseplans")
	public ModelAndView newProjectReleaseplans(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("releaseplan", new Releaseplan());
		mav.addObject("newFlag", true);
		mav.setViewName("project/releaseplans/editReleaseplans.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newProject")
	public ModelAndView newProject() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.addObject("persons", personService.loadPersons());		
		mav.setViewName("project/editProject.jsp");
		return mav;
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectChangerequests")
	public ModelAndView confirmDeleteProjectChangerequests(@RequestParam Integer project_projectId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/changerequests/deleteChangerequests.jsp");

		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newProjectChangerequests")
	public ModelAndView newProjectChangerequests(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.setViewName("project/changerequests/editChangerequests.jsp");

		return mav;
	}

	/**
	 * Create a new Feature entity
	 * 
	 */
	@RequestMapping("/newProjectFeatures")
	public ModelAndView newProjectFeatures(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("feature", new Feature());
		mav.addObject("newFlag", true);
		mav.setViewName("project/features/editFeatures.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveProjectRequirements")
	public ModelAndView saveProjectRequirements(@RequestParam Integer project_projectId, @ModelAttribute Requirement requirements) {
		projectService.saveProjectRequirements(project_projectId, requirements);
		return editProject(project_projectId);
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveProjectTestcases")
	public ModelAndView saveProjectTestcases(@RequestParam Integer project_projectId, @ModelAttribute Testcase testcases) {
		projectService.saveProjectTestcases(project_projectId, testcases);
		return editProject(project_projectId);
	}


	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteProjectDefects")
	public ModelAndView deleteProjectDefects(@RequestParam Integer project_projectId, @RequestParam Integer related_defects_defectId) {
		projectService.deleteProjectDefects(project_projectId, related_defects_defectId);
		return editProject(project_projectId);
	}

	/**
	 * Save an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/saveProjectProjectteams")
	public ModelAndView saveProjectProjectteams(@RequestParam Integer project_projectId, @RequestParam Integer selected_id1, @ModelAttribute Projectteam projectteams) {
		// Integer selected_id1=null;
		projectService.saveProjectProjectteams(project_projectId, selected_id1, projectteams);
		return editProject(project_projectId);
	}

	/**
	 * Edit an existing Feature entity
	 * 
	 */
	@RequestMapping("/editProjectFeatures")
	public ModelAndView editProjectFeatures(@RequestParam Integer project_projectId, @RequestParam Integer features_featureId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(features_featureId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("feature", feature);
		mav.setViewName("project/features/editFeatures.jsp");

		return mav;
	}
	
	/**
	 * Create a new Projectteam entity
	 * 
	 */
	@RequestMapping("/newProjectProjectteams")
	public ModelAndView newProjectProjectteams(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("projectteams", new Projectteam());
		mav.addObject("persons", personService.loadPersons());				
		mav.addObject("newFlag", true);
		mav.setViewName("project/projectteams/editProjectteams.jsp");

		return mav;
	}
	
	/**
	 * Edit an existing Projectteam entity
	 * 
	 */
	@RequestMapping("/editProjectProjectteams")
	public ModelAndView editProjectProjectteams(@RequestParam Integer project_projectId, @RequestParam Integer projectteams_projectTeamId) {
		Projectteam projectteam = projectteamDAO.findProjectteamByPrimaryKey(projectteams_projectTeamId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("projectteams", projectteam);
		mav.addObject("persons", personService.loadPersons());				
		mav.setViewName("project/projectteams/editProjectteams.jsp");

		return mav;
	}


	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editProjectDefects")
	public ModelAndView editProjectDefects(@RequestParam Integer project_projectId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("defect", defect);
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.setViewName("project/defects/editDefects.jsp");
		return mav;
	}


	/**
	 * Edit an existing Client entity
	 * 
	 */
	@RequestMapping("/editProjectClient")
	public ModelAndView editProjectClient(@RequestParam Integer project_projectId, @RequestParam Integer client_clientId) {
		Client client = clientDAO.findClientByPrimaryKey(client_clientId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("client", client);
		mav.addObject("persons", personService.loadPersons());		
		mav.setViewName("project/client/editClient.jsp");

		return mav;
	}

	/**
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editProjectChangerequests")
	public ModelAndView editProjectChangerequests(@RequestParam Integer project_projectId, @RequestParam Integer changerequests_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequests_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("changerequest", changerequest);
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.setViewName("project/changerequests/editChangerequests.jsp");
		return mav;
	}


	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveProjectAccount")
	public ModelAndView saveProjectAccount(@RequestParam Integer project_projectId, @ModelAttribute Account account) {
		projectService.saveProjectAccount(project_projectId, account);
		return editProject(project_projectId);
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteProjectTestcases")
	public ModelAndView confirmDeleteProjectTestcases(@RequestParam Integer project_projectId, @RequestParam Integer related_testcases_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcases_testId));
		mav.addObject("project_projectId", project_projectId);
		mav.setViewName("project/testcases/deleteTestcases.jsp");

		return mav;
	}


	/**
	 * Edit an existing Timeentry entity
	 * 
	 */
	@RequestMapping("/editProjectTimeentries")
	public ModelAndView editProjectTimeentries(@RequestParam Integer project_projectId, @RequestParam Integer timeentries_timeEntryId) {
		Timeentry timeentry = timeentryDAO.findTimeentryByPrimaryKey(timeentries_timeEntryId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("timeentry", timeentry);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());
		mav.addObject("tasks", taskService.loadTasks());		
		mav.setViewName("project/timeentries/editTimeentries.jsp");

		return mav;
	}


	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editProjectStatusupdates")
	public ModelAndView editProjectStatusupdates(@RequestParam Integer project_projectId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("statusupdate", statusupdate);
		mav.addObject("persons", personService.loadPersons());		
		mav.setViewName("project/statusupdates/editStatusupdates.jsp");
		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newProjectDefects")
	public ModelAndView newProjectDefects(@RequestParam Integer project_projectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.setViewName("project/defects/editDefects.jsp");

		return mav;
	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editProjectTasks")
	public ModelAndView editProjectTasks(@RequestParam Integer project_projectId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("project_projectId", project_projectId);
		mav.addObject("task", task);
		mav.addObject("persons", personService.loadPersons());		
		mav.addObject("reqmts", requirementService.loadRequirements());		
		mav.addObject("defects", defectService.loadDefects());		
		mav.addObject("changereqs", changerequestService.loadChangerequests());		
		mav.addObject("tests", testService.loadTestcases());		
		mav.setViewName("project/tasks/editTasks.jsp");
		return mav;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteProjectTasks")
	public ModelAndView deleteProjectTasks(@RequestParam Integer project_projectId, @RequestParam Integer related_tasks_taskId) {
		projectService.deleteProjectTasks(project_projectId, related_tasks_taskId);
		return editProject(project_projectId);
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/saveProjectReleaseplans")
	public ModelAndView saveProjectReleaseplans(@RequestParam Integer project_projectId, @ModelAttribute Releaseplan releaseplans) {
		projectService.saveProjectReleaseplans(project_projectId, releaseplans);
		return editProject(project_projectId);
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deleteProjectAttachments")
	public ModelAndView deleteProjectAttachments(@RequestParam Integer project_projectId, @RequestParam Integer related_attachments_attachId) {
		projectService.deleteProjectAttachments(project_projectId, related_attachments_attachId);
		return editProject(project_projectId);
	}
	
	
	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView mav = new ModelAndView();
//		mav.addObject("testcasestep", testcasestep);
		mav.setViewName("../sitemesh-common/dashboard.jsp");

		return mav;
	}
}