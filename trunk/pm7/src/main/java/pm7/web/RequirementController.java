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
import pm7.dao.StatusupdateDAO;
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
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;

import pm7.service.RequirementService;

/**
 * Spring MVC controller that handles CRUD requests for Requirement entities
 * 
 */

@Controller("RequirementController")
public class RequirementController {

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
	 * DAO injected by Spring that manages Statusupdate entities
	 * 
	 */
	@Autowired
	private StatusupdateDAO statusupdateDAO;

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
	 * Service injected by Spring that provides CRUD operations for Requirement entities
	 * 
	 */
	@Autowired
	private RequirementService requirementService;

	/**
	 * View an existing Feature entity
	 * 
	 */
	@RequestMapping("/selectRequirementFeature")
	public ModelAndView selectRequirementFeature(@RequestParam Integer requirement_reqmtId, @RequestParam Integer feature_featureId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("feature", feature);
		mav.setViewName("requirement/feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newRequirementProject")
	public ModelAndView newRequirementProject(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/project/editProject.jsp");

		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newRequirement")
	public ModelAndView newRequirement() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * Select the child Releaseplan entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementReleaseplan")
	public ModelAndView confirmDeleteRequirementReleaseplan(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/releaseplan/deleteReleaseplan.jsp");

		return mav;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteRequirementTasks")
	public ModelAndView deleteRequirementTasks(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementTasks(requirement_reqmtId, related_tasks_taskId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

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
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteRequirementDefects")
	public ModelAndView deleteRequirementDefects(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementDefects(requirement_reqmtId, related_defects_defectId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Show all Feature entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementFeature")
	public ModelAndView listRequirementFeature(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/feature/listFeature.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteRequirementChangerequests")
	public ModelAndView deleteRequirementChangerequests(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementChangerequests(requirement_reqmtId, related_changerequests_changeId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveRequirementTasks")
	public ModelAndView saveRequirementTasks(@RequestParam Integer requirement_reqmtId, @ModelAttribute Task tasks) {
		Requirement parent_requirement = requirementService.saveRequirementTasks(requirement_reqmtId, tasks);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementStatusupdates")
	public ModelAndView confirmDeleteRequirementStatusupdates(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/statusupdates/deleteStatusupdates.jsp");

		return mav;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@RequestMapping("/deleteRequirementFeature")
	public ModelAndView deleteRequirementFeature(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_feature_featureId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementFeature(requirement_reqmtId, related_feature_featureId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveRequirementTestcases")
	public ModelAndView saveRequirementTestcases(@RequestParam Integer requirement_reqmtId, @ModelAttribute Testcase testcases) {
		Requirement parent_requirement = requirementService.saveRequirementTestcases(requirement_reqmtId, testcases);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * View an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/selectRequirementStatusupdates")
	public ModelAndView selectRequirementStatusupdates(@RequestParam Integer requirement_reqmtId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("requirement/statusupdates/viewStatusupdates.jsp");

		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newRequirementDefects")
	public ModelAndView newRequirementDefects(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/defects/editDefects.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementAccount")
	public ModelAndView listRequirementAccount(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteRequirementAccount")
	public ModelAndView deleteRequirementAccount(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementAccount(requirement_reqmtId, related_account_accountId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Show all Statusupdate entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementStatusupdates")
	public ModelAndView listRequirementStatusupdates(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/statusupdates/listStatusupdates.jsp");

		return mav;
	}

	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editRequirementDefects")
	public ModelAndView editRequirementDefects(@RequestParam Integer requirement_reqmtId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("defect", defect);
		mav.setViewName("requirement/defects/editDefects.jsp");

		return mav;
	}

	/**
	 * Select the child Feature entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementFeature")
	public ModelAndView confirmDeleteRequirementFeature(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_feature_featureId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(related_feature_featureId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/feature/deleteFeature.jsp");

		return mav;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/deleteRequirementReleaseplan")
	public ModelAndView deleteRequirementReleaseplan(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementReleaseplan(requirement_reqmtId, related_releaseplan_releaseId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * View an existing Attachment entity
	 * 
	 */
	@RequestMapping("/selectRequirementAttachments")
	public ModelAndView selectRequirementAttachments(@RequestParam Integer requirement_reqmtId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("attachment", attachment);
		mav.setViewName("requirement/attachments/viewAttachments.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newRequirementAccount")
	public ModelAndView newRequirementAccount(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/account/editAccount.jsp");

		return mav;
	}

	/**
	 * View an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/selectRequirementReleaseplan")
	public ModelAndView selectRequirementReleaseplan(@RequestParam Integer requirement_reqmtId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("requirement/releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Select the child Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementAttachments")
	public ModelAndView confirmDeleteRequirementAttachments(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/attachments/deleteAttachments.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveRequirement")
	public String saveRequirement(@ModelAttribute Requirement requirement) {
		requirementService.saveRequirement(requirement);
		return "forward:/indexRequirement";
	}

	/**
	 * Create a new Releaseplan entity
	 * 
	 */
	@RequestMapping("/newRequirementReleaseplan")
	public ModelAndView newRequirementReleaseplan(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("releaseplan", new Releaseplan());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Testcase entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementTestcases")
	public ModelAndView listRequirementTestcases(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/testcases/listTestcases.jsp");

		return mav;
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newRequirementTasks")
	public ModelAndView newRequirementTasks(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/tasks/editTasks.jsp");

		return mav;
	}

	/**
	 * Show all Defect entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementDefects")
	public ModelAndView listRequirementDefects(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/defects/listDefects.jsp");

		return mav;
	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editRequirementTasks")
	public ModelAndView editRequirementTasks(@RequestParam Integer requirement_reqmtId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("task", task);
		mav.setViewName("requirement/tasks/editTasks.jsp");

		return mav;
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementChangerequests")
	public ModelAndView confirmDeleteRequirementChangerequests(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/changerequests/deleteChangerequests.jsp");

		return mav;
	}

	/**
	 * View an existing Task entity
	 * 
	 */
	@RequestMapping("/selectRequirementTasks")
	public ModelAndView selectRequirementTasks(@RequestParam Integer requirement_reqmtId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("task", task);
		mav.setViewName("requirement/tasks/viewTasks.jsp");

		return mav;
	}

	/**
	 * Show all Requirement entities
	 * 
	 */
	@RequestMapping("/indexRequirement")
	public ModelAndView listRequirements() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirements", requirementService.loadRequirements());

		mav.setViewName("requirement/listRequirements.jsp");

		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newRequirementChangerequests")
	public ModelAndView newRequirementChangerequests(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/changerequests/editChangerequests.jsp");

		return mav;
	}

	/**
	 * Edit an existing Feature entity
	 * 
	 */
	@RequestMapping("/editRequirementFeature")
	public ModelAndView editRequirementFeature(@RequestParam Integer requirement_reqmtId, @RequestParam Integer feature_featureId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("feature", feature);
		mav.setViewName("requirement/feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newRequirementStatusupdates")
	public ModelAndView newRequirementStatusupdates(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/statusupdates/editStatusupdates.jsp");

		return mav;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/saveRequirementReleaseplan")
	public ModelAndView saveRequirementReleaseplan(@RequestParam Integer requirement_reqmtId, @ModelAttribute Releaseplan releaseplan) {
		Requirement parent_requirement = requirementService.saveRequirementReleaseplan(requirement_reqmtId, releaseplan);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Create a new Feature entity
	 * 
	 */
	@RequestMapping("/newRequirementFeature")
	public ModelAndView newRequirementFeature(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("feature", new Feature());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveRequirementDefects")
	public ModelAndView saveRequirementDefects(@RequestParam Integer requirement_reqmtId, @ModelAttribute Defect defects) {
		Requirement parent_requirement = requirementService.saveRequirementDefects(requirement_reqmtId, defects);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementAccount")
	public ModelAndView confirmDeleteRequirementAccount(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteRequirementStatusupdates")
	public ModelAndView deleteRequirementStatusupdates(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementStatusupdates(requirement_reqmtId, related_statusupdates_statusId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementTestcases")
	public ModelAndView confirmDeleteRequirementTestcases(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_testcases_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcases_testId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/testcases/deleteTestcases.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectRequirementAccount")
	public ModelAndView selectRequirementAccount(@RequestParam Integer requirement_reqmtId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("account", account);
		mav.setViewName("requirement/account/viewAccount.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/requirementController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Entry point to show all Requirement entities
	 * 
	 */
	public String indexRequirement() {
		return "redirect:/indexRequirement";
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editRequirementAttachments")
	public ModelAndView editRequirementAttachments(@RequestParam Integer requirement_reqmtId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("attachment", attachment);
		mav.setViewName("requirement/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveRequirementStatusupdates")
	public ModelAndView saveRequirementStatusupdates(@RequestParam Integer requirement_reqmtId, @ModelAttribute Statusupdate statusupdates) {
		Requirement parent_requirement = requirementService.saveRequirementStatusupdates(requirement_reqmtId, statusupdates);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editRequirement")
	public ModelAndView editRequirement(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * Select an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectRequirement")
	public ModelAndView selectRequirement(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteRequirement")
	public String deleteRequirement(@RequestParam Integer reqmtIdKey) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtIdKey);
		requirementService.deleteRequirement(requirement);
		return "forward:/indexRequirement";
	}

	/**
	 * Show all Project entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementProject")
	public ModelAndView listRequirementProject(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/project/listProject.jsp");

		return mav;
	}

	/**
	 * Show all Attachment entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementAttachments")
	public ModelAndView listRequirementAttachments(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/attachments/listAttachments.jsp");

		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveRequirementChangerequests")
	public ModelAndView saveRequirementChangerequests(@RequestParam Integer requirement_reqmtId, @ModelAttribute Changerequest changerequests) {
		Requirement parent_requirement = requirementService.saveRequirementChangerequests(requirement_reqmtId, changerequests);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteRequirementProject")
	public ModelAndView deleteRequirementProject(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementProject(requirement_reqmtId, related_project_projectId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editRequirementStatusupdates")
	public ModelAndView editRequirementStatusupdates(@RequestParam Integer requirement_reqmtId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("requirement/statusupdates/editStatusupdates.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectRequirementProject")
	public ModelAndView selectRequirementProject(@RequestParam Integer requirement_reqmtId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("project", project);
		mav.setViewName("requirement/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Show all Releaseplan entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementReleaseplan")
	public ModelAndView listRequirementReleaseplan(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/releaseplan/listReleaseplan.jsp");

		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newRequirementAttachments")
	public ModelAndView newRequirementAttachments(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editRequirementTestcases")
	public ModelAndView editRequirementTestcases(@RequestParam Integer requirement_reqmtId, @RequestParam Integer testcases_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcases_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("testcase", testcase);
		mav.setViewName("requirement/testcases/editTestcases.jsp");

		return mav;
	}

	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementTasks")
	public ModelAndView confirmDeleteRequirementTasks(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_tasks_taskId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/tasks/deleteTasks.jsp");

		return mav;
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementDefects")
	public ModelAndView confirmDeleteRequirementDefects(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defects_defectId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/defects/deleteDefects.jsp");

		return mav;
	}

	/**
	 * View an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/selectRequirementChangerequests")
	public ModelAndView selectRequirementChangerequests(@RequestParam Integer requirement_reqmtId, @RequestParam Integer changerequests_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequests_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("requirement/changerequests/viewChangerequests.jsp");

		return mav;
	}

	/**
	 * Edit an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/editRequirementReleaseplan")
	public ModelAndView editRequirementReleaseplan(@RequestParam Integer requirement_reqmtId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("requirement/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Defect entity
	 * 
	 */
	@RequestMapping("/selectRequirementDefects")
	public ModelAndView selectRequirementDefects(@RequestParam Integer requirement_reqmtId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("defect", defect);
		mav.setViewName("requirement/defects/viewDefects.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveRequirementProject")
	public ModelAndView saveRequirementProject(@RequestParam Integer requirement_reqmtId, @ModelAttribute Project project) {
		Requirement parent_requirement = requirementService.saveRequirementProject(requirement_reqmtId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newRequirementTestcases")
	public ModelAndView newRequirementTestcases(@RequestParam Integer requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("requirement/testcases/editTestcases.jsp");

		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteRequirementTestcases")
	public ModelAndView deleteRequirementTestcases(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_testcases_testId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementTestcases(requirement_reqmtId, related_testcases_testId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/saveRequirementAttachments")
	public ModelAndView saveRequirementAttachments(@RequestParam Integer requirement_reqmtId, @ModelAttribute Attachment attachments) {
		Requirement parent_requirement = requirementService.saveRequirementAttachments(requirement_reqmtId, attachments);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deleteRequirementAttachments")
	public ModelAndView deleteRequirementAttachments(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		Requirement requirement = requirementService.deleteRequirementAttachments(requirement_reqmtId, related_attachments_attachId);

		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editRequirementAccount")
	public ModelAndView editRequirementAccount(@RequestParam Integer requirement_reqmtId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("account", account);
		mav.setViewName("requirement/account/editAccount.jsp");

		return mav;
	}

	/**
	 * View an existing Testcase entity
	 * 
	 */
	@RequestMapping("/selectRequirementTestcases")
	public ModelAndView selectRequirementTestcases(@RequestParam Integer requirement_reqmtId, @RequestParam Integer testcases_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcases_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("testcase", testcase);
		mav.setViewName("requirement/testcases/viewTestcases.jsp");

		return mav;
	}

	/**
	 * Show all Task entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementTasks")
	public ModelAndView listRequirementTasks(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/tasks/listTasks.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editRequirementProject")
	public ModelAndView editRequirementProject(@RequestParam Integer requirement_reqmtId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("project", project);
		mav.setViewName("requirement/project/editProject.jsp");

		return mav;
	}

	/**
	 * Select the Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirement")
	public ModelAndView confirmDeleteRequirement(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/deleteRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@RequestMapping("/saveRequirementFeature")
	public ModelAndView saveRequirementFeature(@RequestParam Integer requirement_reqmtId, @ModelAttribute Feature feature) {
		Requirement parent_requirement = requirementService.saveRequirementFeature(requirement_reqmtId, feature);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveRequirementAccount")
	public ModelAndView saveRequirementAccount(@RequestParam Integer requirement_reqmtId, @ModelAttribute Account account) {
		Requirement parent_requirement = requirementService.saveRequirementAccount(requirement_reqmtId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("requirement", parent_requirement);
		mav.setViewName("requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteRequirementProject")
	public ModelAndView confirmDeleteRequirementProject(@RequestParam Integer requirement_reqmtId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.setViewName("requirement/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Show all Changerequest entities by Requirement
	 * 
	 */
	@RequestMapping("/listRequirementChangerequests")
	public ModelAndView listRequirementChangerequests(@RequestParam Integer reqmtIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(reqmtIdKey));
		mav.setViewName("requirement/changerequests/listChangerequests.jsp");

		return mav;
	}

	/**
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editRequirementChangerequests")
	public ModelAndView editRequirementChangerequests(@RequestParam Integer requirement_reqmtId, @RequestParam Integer changerequests_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequests_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement_reqmtId", requirement_reqmtId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("requirement/changerequests/editChangerequests.jsp");

		return mav;
	}
}