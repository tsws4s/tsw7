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
import pm7.dao.AttachmentDAO;
import pm7.dao.ChangerequestDAO;
import pm7.dao.DefectDAO;
import pm7.dao.FeatureDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Feature;
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Task;
import pm7.domain.Testcase;

import pm7.service.ChangerequestService;

/**
 * Spring MVC controller that handles CRUD requests for Changerequest entities
 * 
 */

@Controller("ChangerequestController")
public class ChangerequestController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Attachment entities
	 * 
	 */
	@Autowired
	private AttachmentDAO attachmentDAO;

	/**
	 * DAO injected by Spring that manages Changerequest entities
	 * 
	 */
	@Autowired
	private ChangerequestDAO changerequestDAO;

	/**
	 * DAO injected by Spring that manages Defect entities
	 * 
	 */
	@Autowired
	private DefectDAO defectDAO;

	/**
	 * DAO injected by Spring that manages Feature entities
	 * 
	 */
	@Autowired
	private FeatureDAO featureDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Releaseplan entities
	 * 
	 */
	@Autowired
	private ReleaseplanDAO releaseplanDAO;

	/**
	 * DAO injected by Spring that manages Requirement entities
	 * 
	 */
	@Autowired
	private RequirementDAO requirementDAO;

	/**
	 * DAO injected by Spring that manages Task entities
	 * 
	 */
	@Autowired
	private TaskDAO taskDAO;

	/**
	 * DAO injected by Spring that manages Testcase entities
	 * 
	 */
	@Autowired
	private TestcaseDAO testcaseDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Changerequest entities
	 * 
	 */
	@Autowired
	private ChangerequestService changerequestService;

	/**
	 * View an existing Feature entity
	 * 
	 */
	@RequestMapping("/selectChangerequestFeature")
	public ModelAndView selectChangerequestFeature(@RequestParam Integer changerequest_changeId, @RequestParam Integer feature_featureId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("feature", feature);
		mav.setViewName("changerequest/feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Select an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/selectChangerequest")
	public ModelAndView selectChangerequest(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newChangerequestTestcases")
	public ModelAndView newChangerequestTestcases(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/testcases/editTestcases.jsp");

		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/saveChangerequestAttachments")
	public ModelAndView saveChangerequestAttachments(@RequestParam Integer changerequest_changeId, @ModelAttribute Attachment attachments) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestAttachments(changerequest_changeId, attachments);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/editChangerequest.jsp");

		return mav;
	}

	/**
	 * View an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectChangerequestRequirement")
	public ModelAndView selectChangerequestRequirement(@RequestParam Integer changerequest_changeId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("requirement", requirement);
		mav.setViewName("changerequest/requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveChangerequestTasks")
	public ModelAndView saveChangerequestTasks(@RequestParam Integer changerequest_changeId, @ModelAttribute Task tasks) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestTasks(changerequest_changeId, tasks);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Select the child Feature entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestFeature")
	public ModelAndView confirmDeleteChangerequestFeature(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_feature_featureId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(related_feature_featureId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/feature/deleteFeature.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveChangerequestTestcases")
	public ModelAndView saveChangerequestTestcases(@RequestParam Integer changerequest_changeId, @ModelAttribute Testcase testcases) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestTestcases(changerequest_changeId, testcases);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestProject")
	public ModelAndView listChangerequestProject(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/project/listProject.jsp");

		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveChangerequest")
	public String saveChangerequest(@ModelAttribute Changerequest changerequest) {
		changerequestService.saveChangerequest(changerequest);
		return "forward:/indexChangerequest";
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
	 * Show all Releaseplan entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestReleaseplan")
	public ModelAndView listChangerequestReleaseplan(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/releaseplan/listReleaseplan.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newChangerequestAccount")
	public ModelAndView newChangerequestAccount(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteChangerequest")
	public String deleteChangerequest(@RequestParam Integer changeIdKey) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeIdKey);
		changerequestService.deleteChangerequest(changerequest);
		return "forward:/indexChangerequest";
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editChangerequestAccount")
	public ModelAndView editChangerequestAccount(@RequestParam Integer changerequest_changeId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("account", account);
		mav.setViewName("changerequest/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestDefects")
	public ModelAndView deleteChangerequestDefects(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestDefects(changerequest_changeId, related_defects_defectId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveChangerequestAccount")
	public ModelAndView saveChangerequestAccount(@RequestParam Integer changerequest_changeId, @ModelAttribute Account account) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestAccount(changerequest_changeId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectChangerequestProject")
	public ModelAndView selectChangerequestProject(@RequestParam Integer changerequest_changeId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("project", project);
		mav.setViewName("changerequest/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestProject")
	public ModelAndView confirmDeleteChangerequestProject(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newChangerequest")
	public ModelAndView newChangerequest() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/editChangerequest.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editChangerequestProject")
	public ModelAndView editChangerequestProject(@RequestParam Integer changerequest_changeId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("project", project);
		mav.setViewName("changerequest/project/editProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/editChangerequestReleaseplan")
	public ModelAndView editChangerequestReleaseplan(@RequestParam Integer changerequest_changeId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("changerequest/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Defect entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestDefects")
	public ModelAndView listChangerequestDefects(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/defects/listDefects.jsp");

		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestTestcases")
	public ModelAndView deleteChangerequestTestcases(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_testcases_testId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestTestcases(changerequest_changeId, related_testcases_testId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editChangerequestDefects")
	public ModelAndView editChangerequestDefects(@RequestParam Integer changerequest_changeId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("defect", defect);
		mav.setViewName("changerequest/defects/editDefects.jsp");

		return mav;
	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editChangerequestTasks")
	public ModelAndView editChangerequestTasks(@RequestParam Integer changerequest_changeId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("task", task);
		mav.setViewName("changerequest/tasks/editTasks.jsp");

		return mav;
	}

	/**
	 * Show all Testcase entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestTestcases")
	public ModelAndView listChangerequestTestcases(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/testcases/listTestcases.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newChangerequestProject")
	public ModelAndView newChangerequestProject(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/project/editProject.jsp");

		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newChangerequestRequirement")
	public ModelAndView newChangerequestRequirement(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editChangerequestTestcases")
	public ModelAndView editChangerequestTestcases(@RequestParam Integer changerequest_changeId, @RequestParam Integer testcases_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcases_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("testcase", testcase);
		mav.setViewName("changerequest/testcases/editTestcases.jsp");

		return mav;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestReleaseplan")
	public ModelAndView deleteChangerequestReleaseplan(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestReleaseplan(changerequest_changeId, related_releaseplan_releaseId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Select the Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequest")
	public ModelAndView confirmDeleteChangerequest(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/deleteChangerequest.jsp");

		return mav;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestTasks")
	public ModelAndView deleteChangerequestTasks(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestTasks(changerequest_changeId, related_tasks_taskId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestFeature")
	public ModelAndView deleteChangerequestFeature(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_feature_featureId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestFeature(changerequest_changeId, related_feature_featureId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * View an existing Task entity
	 * 
	 */
	@RequestMapping("/selectChangerequestTasks")
	public ModelAndView selectChangerequestTasks(@RequestParam Integer changerequest_changeId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("task", task);
		mav.setViewName("changerequest/tasks/viewTasks.jsp");

		return mav;
	}

	/**
	 * Show all Task entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestTasks")
	public ModelAndView listChangerequestTasks(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/tasks/listTasks.jsp");

		return mav;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestAttachments")
	public ModelAndView deleteChangerequestAttachments(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestAttachments(changerequest_changeId, related_attachments_attachId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/editChangerequest.jsp");

		return mav;
	}

	/**
	 * View an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/selectChangerequestReleaseplan")
	public ModelAndView selectChangerequestReleaseplan(@RequestParam Integer changerequest_changeId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("changerequest/releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Attachment entity
	 * 
	 */
	@RequestMapping("/selectChangerequestAttachments")
	public ModelAndView selectChangerequestAttachments(@RequestParam Integer changerequest_changeId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("attachment", attachment);
		mav.setViewName("changerequest/attachments/viewAttachments.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/changerequestController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@RequestMapping("/saveChangerequestFeature")
	public ModelAndView saveChangerequestFeature(@RequestParam Integer changerequest_changeId, @ModelAttribute Feature feature) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestFeature(changerequest_changeId, feature);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestTasks")
	public ModelAndView confirmDeleteChangerequestTasks(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_tasks_taskId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/tasks/deleteTasks.jsp");

		return mav;
	}

	/**
	 * Show all Attachment entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestAttachments")
	public ModelAndView listChangerequestAttachments(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/attachments/listAttachments.jsp");

		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newChangerequestDefects")
	public ModelAndView newChangerequestDefects(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/defects/editDefects.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestRequirement")
	public ModelAndView deleteChangerequestRequirement(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestRequirement(changerequest_changeId, related_requirement_reqmtId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectChangerequestAccount")
	public ModelAndView selectChangerequestAccount(@RequestParam Integer changerequest_changeId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("account", account);
		mav.setViewName("changerequest/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newChangerequestTasks")
	public ModelAndView newChangerequestTasks(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/tasks/editTasks.jsp");

		return mav;
	}

	/**
	 * Select the child Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestAttachments")
	public ModelAndView confirmDeleteChangerequestAttachments(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/attachments/deleteAttachments.jsp");

		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editChangerequestRequirement")
	public ModelAndView editChangerequestRequirement(@RequestParam Integer changerequest_changeId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("requirement", requirement);
		mav.setViewName("changerequest/requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * Create a new Feature entity
	 * 
	 */
	@RequestMapping("/newChangerequestFeature")
	public ModelAndView newChangerequestFeature(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("feature", new Feature());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestAccount")
	public ModelAndView confirmDeleteChangerequestAccount(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveChangerequestRequirement")
	public ModelAndView saveChangerequestRequirement(@RequestParam Integer changerequest_changeId, @ModelAttribute Requirement requirement) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestRequirement(changerequest_changeId, requirement);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveChangerequestProject")
	public ModelAndView saveChangerequestProject(@RequestParam Integer changerequest_changeId, @ModelAttribute Project project) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestProject(changerequest_changeId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editChangerequestAttachments")
	public ModelAndView editChangerequestAttachments(@RequestParam Integer changerequest_changeId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("attachment", attachment);
		mav.setViewName("changerequest/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Create a new Releaseplan entity
	 * 
	 */
	@RequestMapping("/newChangerequestReleaseplan")
	public ModelAndView newChangerequestReleaseplan(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("releaseplan", new Releaseplan());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Select the child Releaseplan entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestReleaseplan")
	public ModelAndView confirmDeleteChangerequestReleaseplan(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/releaseplan/deleteReleaseplan.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestAccount")
	public ModelAndView deleteChangerequestAccount(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestAccount(changerequest_changeId, related_account_accountId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/editChangerequest.jsp");

		return mav;
	}

	/**
	 * Edit an existing Feature entity
	 * 
	 */
	@RequestMapping("/editChangerequestFeature")
	public ModelAndView editChangerequestFeature(@RequestParam Integer changerequest_changeId, @RequestParam Integer feature_featureId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("feature", feature);
		mav.setViewName("changerequest/feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveChangerequestDefects")
	public ModelAndView saveChangerequestDefects(@RequestParam Integer changerequest_changeId, @ModelAttribute Defect defects) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestDefects(changerequest_changeId, defects);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Show all Changerequest entities
	 * 
	 */
	@RequestMapping("/indexChangerequest")
	public ModelAndView listChangerequests() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequests", changerequestService.loadChangerequests());

		mav.setViewName("changerequest/listChangerequests.jsp");

		return mav;
	}

	/**
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editChangerequest")
	public ModelAndView editChangerequest(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/editChangerequest.jsp");

		return mav;
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestTestcases")
	public ModelAndView confirmDeleteChangerequestTestcases(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_testcases_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcases_testId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/testcases/deleteTestcases.jsp");

		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newChangerequestAttachments")
	public ModelAndView newChangerequestAttachments(@RequestParam Integer changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("changerequest/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestRequirement")
	public ModelAndView confirmDeleteChangerequestRequirement(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/requirement/deleteRequirement.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteChangerequestProject")
	public ModelAndView deleteChangerequestProject(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Changerequest changerequest = changerequestService.deleteChangerequestProject(changerequest_changeId, related_project_projectId);

		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/saveChangerequestReleaseplan")
	public ModelAndView saveChangerequestReleaseplan(@RequestParam Integer changerequest_changeId, @ModelAttribute Releaseplan releaseplan) {
		Changerequest parent_changerequest = changerequestService.saveChangerequestReleaseplan(changerequest_changeId, releaseplan);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("changerequest", parent_changerequest);
		mav.setViewName("changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Changerequest entities
	 * 
	 */
	public String indexChangerequest() {
		return "redirect:/indexChangerequest";
	}

	/**
	 * Show all Feature entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestFeature")
	public ModelAndView listChangerequestFeature(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/feature/listFeature.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestAccount")
	public ModelAndView listChangerequestAccount(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/account/listAccount.jsp");

		return mav;
	}

	/**
	 * View an existing Defect entity
	 * 
	 */
	@RequestMapping("/selectChangerequestDefects")
	public ModelAndView selectChangerequestDefects(@RequestParam Integer changerequest_changeId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("defect", defect);
		mav.setViewName("changerequest/defects/viewDefects.jsp");

		return mav;
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteChangerequestDefects")
	public ModelAndView confirmDeleteChangerequestDefects(@RequestParam Integer changerequest_changeId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defects_defectId));
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.setViewName("changerequest/defects/deleteDefects.jsp");

		return mav;
	}

	/**
	 * View an existing Testcase entity
	 * 
	 */
	@RequestMapping("/selectChangerequestTestcases")
	public ModelAndView selectChangerequestTestcases(@RequestParam Integer changerequest_changeId, @RequestParam Integer testcases_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcases_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest_changeId", changerequest_changeId);
		mav.addObject("testcase", testcase);
		mav.setViewName("changerequest/testcases/viewTestcases.jsp");

		return mav;
	}

	/**
	 * Show all Requirement entities by Changerequest
	 * 
	 */
	@RequestMapping("/listChangerequestRequirement")
	public ModelAndView listChangerequestRequirement(@RequestParam Integer changeIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(changeIdKey));
		mav.setViewName("changerequest/requirement/listRequirement.jsp");

		return mav;
	}
}