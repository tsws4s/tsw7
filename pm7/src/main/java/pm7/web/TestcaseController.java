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
import pm7.dao.DefectDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TestcasestepDAO;

import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;
import pm7.domain.Testcasestep;

import pm7.service.TestcaseService;

/**
 * Spring MVC controller that handles CRUD requests for Testcase entities
 * 
 */

@Controller("TestcaseController")
public class TestcaseController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */

	@Autowired
	private AttachmentDAO attachmentDAO;

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
	private TestcasestepDAO testcasestepDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Testcase entities
	 * 
	 */
	@Autowired
	private TestcaseService testcaseService;

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newTestcase")
	public ModelAndView newTestcase() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editTestcase")
	public ModelAndView editTestcase(@RequestParam Integer testIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(testIdKey));
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newTestcaseStatusupdates")
	public ModelAndView newTestcaseStatusupdates(@RequestParam Integer testcase_testId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/statusupdates/editStatusupdates.jsp");
		return mav;
	}
	/**
	 * Create a new Testcasestep entity
	 * 
	 */
	@RequestMapping("/newTestcaseTestcasesteps")
	public ModelAndView newTestcaseTestcasesteps(@RequestParam Integer testcase_testId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcasestep", new Testcasestep());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/testcasesteps/editTestcasesteps.jsp");

		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newTestcaseDefects")
	public ModelAndView newTestcaseDefects(@RequestParam Integer testcase_testId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/defects/editDefects.jsp");
		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newTestcaseAttachments")
	public ModelAndView newTestcaseAttachments(@RequestParam Integer testcase_testId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/attachments/editAttachments.jsp");
		return mav;
	}


	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editTestcaseDefects")
	public ModelAndView editTestcaseDefects(@RequestParam Integer testcase_testId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("defect", defect);
		mav.setViewName("testcase/defects/editDefects.jsp");
		return mav;
	}

	/**
	 * Save an existing Testcasestep entity
	 * 
	 */
	@RequestMapping("/saveTestcaseTestcasesteps")
	public ModelAndView saveTestcaseTestcasesteps(@RequestParam Integer testcase_testId, @ModelAttribute Testcasestep testcasesteps) {
		Testcase parent_testcase = testcaseService.saveTestcaseTestcasesteps(testcase_testId, testcasesteps);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", parent_testcase);
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteTestcaseRequirement")
	public ModelAndView deleteTestcaseRequirement(@RequestParam Integer testcase_testId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		Testcase testcase = testcaseService.deleteTestcaseRequirement(testcase_testId, related_requirement_reqmtId);
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcase/viewTestcase.jsp");
		return mav;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteTestcaseStatusupdates")
	public ModelAndView deleteTestcaseStatusupdates(@RequestParam Integer testcase_testId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();
		Testcase testcase = testcaseService.deleteTestcaseStatusupdates(testcase_testId, related_statusupdates_statusId);
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteTestcase")
	public String deleteTestcase(@RequestParam Integer testIdKey) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testIdKey);
		testcaseService.deleteTestcase(testcase);
		return "forward:/indexTestcase";
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
	 * Select the Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcase")
	public ModelAndView confirmDeleteTestcase(@RequestParam Integer testIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(testIdKey));
		mav.setViewName("testcase/deleteTestcase.jsp");

		return mav;
	}


	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveTestcaseRequirement")
	public ModelAndView saveTestcaseRequirement(@RequestParam Integer testcase_testId, @ModelAttribute Requirement requirement) {
		Testcase parent_testcase = testcaseService.saveTestcaseRequirement(testcase_testId, requirement);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", parent_testcase);
		mav.setViewName("testcase/viewTestcase.jsp");
		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/saveTestcaseAttachments")
	public ModelAndView saveTestcaseAttachments(@RequestParam Integer testcase_testId, @ModelAttribute Attachment attachments) {
		Testcase parent_testcase = testcaseService.saveTestcaseAttachments(testcase_testId, attachments);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", parent_testcase);
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 */
	@RequestMapping("/testcaseController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcaseTasks")
	public ModelAndView confirmDeleteTestcaseTasks(@RequestParam Integer testcase_testId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_tasks_taskId));
		mav.addObject("testcase_testId", testcase_testId);
		mav.setViewName("testcase/tasks/deleteTasks.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcasestep entity
	 * 
	 */
	@RequestMapping("/editTestcaseTestcasesteps")
	public ModelAndView editTestcaseTestcasesteps(@RequestParam Integer testcase_testId, @RequestParam Integer testcasesteps_testStepId) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testcasesteps_testStepId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcasestep", testcasestep);
		mav.setViewName("testcase/testcasesteps/editTestcasesteps.jsp");
		return mav;
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcaseDefects")
	public ModelAndView confirmDeleteTestcaseDefects(@RequestParam Integer testcase_testId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defects_defectId));
		mav.addObject("testcase_testId", testcase_testId);
		mav.setViewName("testcase/defects/deleteDefects.jsp");
		return mav;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteTestcaseDefects")
	public ModelAndView deleteTestcaseDefects(@RequestParam Integer testcase_testId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		Testcase testcase = testcaseService.deleteTestcaseDefects(testcase_testId, related_defects_defectId);

		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcase/viewTestcase.jsp");

		return mav;
	}

	/**
	 * Show all Testcase entities
	 * 
	 */
	@RequestMapping("/indexTestcase")
	public ModelAndView listTestcases() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcases", testcaseService.loadTestcases());
		mav.setViewName("testcase/listTestcases.jsp");
		return mav;
	}
	/**
	 * View an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectTestcaseRequirement")
	public ModelAndView selectTestcaseRequirement(@RequestParam Integer testcase_testId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("requirement", requirement);
		mav.setViewName("testcase/requirement/viewRequirement.jsp");
		return mav;
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editTestcaseAttachments")
	public ModelAndView editTestcaseAttachments(@RequestParam Integer testcase_testId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("attachment", attachment);
		mav.setViewName("testcase/attachments/editAttachments.jsp");
		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveTestcaseStatusupdates")
	public ModelAndView saveTestcaseStatusupdates(@RequestParam Integer testcase_testId, @ModelAttribute Statusupdate statusupdates) {
		Testcase parent_testcase = testcaseService.saveTestcaseStatusupdates(testcase_testId, statusupdates);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", parent_testcase);
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcaseStatusupdates")
	public ModelAndView confirmDeleteTestcaseStatusupdates(@RequestParam Integer testcase_testId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId));
		mav.addObject("testcase_testId", testcase_testId);
		mav.setViewName("testcase/statusupdates/deleteStatusupdates.jsp");
		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveTestcaseDefects")
	public ModelAndView saveTestcaseDefects(@RequestParam Integer testcase_testId, @ModelAttribute Defect defects) {
		Testcase parent_testcase = testcaseService.saveTestcaseDefects(testcase_testId, defects);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", parent_testcase);
		mav.setViewName("testcase/viewTestcase.jsp");
		return mav;
	}

	/**
	 * Entry point to show all Testcase entities
	 * 
	 */
	public String indexTestcase() {
		return "redirect:/indexTestcase";
	}

	/**
	 * Select the child Testcasestep entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcaseTestcasesteps")
	public ModelAndView confirmDeleteTestcaseTestcasesteps(@RequestParam Integer testcase_testId, @RequestParam Integer related_testcasesteps_testStepId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcasestep", testcasestepDAO.findTestcasestepByPrimaryKey(related_testcasesteps_testStepId));
		mav.addObject("testcase_testId", testcase_testId);
		mav.setViewName("testcase/testcasesteps/deleteTestcasesteps.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteTestcaseChangerequest")
	public ModelAndView deleteTestcaseChangerequest(@RequestParam Integer testcase_testId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		Testcase testcase = testcaseService.deleteTestcaseChangerequest(testcase_testId, related_changerequest_changeId);
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcase/viewTestcase.jsp");
		return mav;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteTestcaseTasks")
	public ModelAndView deleteTestcaseTasks(@RequestParam Integer testcase_testId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();
		Testcase testcase = testcaseService.deleteTestcaseTasks(testcase_testId, related_tasks_taskId);
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcase/viewTestcase.jsp");
		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editTestcaseStatusupdates")
	public ModelAndView editTestcaseStatusupdates(@RequestParam Integer testcase_testId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("testcase/statusupdates/editStatusupdates.jsp");
		return mav;
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcaseChangerequest")
	public ModelAndView confirmDeleteTestcaseChangerequest(@RequestParam Integer testcase_testId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId));
		mav.addObject("testcase_testId", testcase_testId);
		mav.setViewName("testcase/changerequest/deleteChangerequest.jsp");
		return mav;
	}

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	@RequestMapping("/deleteTestcaseTestcasesteps")
	public ModelAndView deleteTestcaseTestcasesteps(@RequestParam Integer testcase_testId, @RequestParam Integer related_testcasesteps_testStepId) {
		ModelAndView mav = new ModelAndView();
		Testcase testcase = testcaseService.deleteTestcaseTestcasesteps(testcase_testId, related_testcasesteps_testStepId);
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveTestcaseChangerequest")
	public ModelAndView saveTestcaseChangerequest(@RequestParam Integer testcase_testId, @ModelAttribute Changerequest changerequest) {
		Testcase parent_testcase = testcaseService.saveTestcaseChangerequest(testcase_testId, changerequest);
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", parent_testcase);
		mav.setViewName("testcase/viewTestcase.jsp");
		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveTestcaseTasks")
	public ModelAndView saveTestcaseTasks(@RequestParam Integer testcase_testId, @ModelAttribute Task tasks) {
		Testcase parent_testcase = testcaseService.saveTestcaseTasks(testcase_testId, tasks);

		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", parent_testcase);
		mav.setViewName("testcase/viewTestcase.jsp");
		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newTestcaseRequirement")
	public ModelAndView newTestcaseRequirement(@RequestParam Integer testcase_testId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/requirement/editRequirement.jsp");
		return mav;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deleteTestcaseAttachments")
	public ModelAndView deleteTestcaseAttachments(@RequestParam Integer testcase_testId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();
		Testcase testcase = testcaseService.deleteTestcaseAttachments(testcase_testId, related_attachments_attachId);
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("testcase", testcase);
		mav.setViewName("testcase/editTestcase.jsp");
		return mav;
	}

	/**
	 * Select the child Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcaseAttachments")
	public ModelAndView confirmDeleteTestcaseAttachments(@RequestParam Integer testcase_testId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId));
		mav.addObject("testcase_testId", testcase_testId);
		mav.setViewName("testcase/attachments/deleteAttachments.jsp");
		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveTestcase")
	public String saveTestcase(@ModelAttribute Testcase testcase) {
		testcaseService.saveTestcase(testcase);
		return "forward:/indexTestcase";
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newTestcaseTasks")
	public ModelAndView newTestcaseTasks(@RequestParam Integer testcase_testId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/tasks/editTasks.jsp");
		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newTestcaseChangerequest")
	public ModelAndView newTestcaseChangerequest(@RequestParam Integer testcase_testId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("testcase_testId", testcase_testId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("testcase/changerequest/editChangerequest.jsp");
		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteTestcaseRequirement")
	public ModelAndView confirmDeleteTestcaseRequirement(@RequestParam Integer testcase_testId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId));
		mav.addObject("testcase_testId", testcase_testId);
		mav.setViewName("testcase/requirement/deleteRequirement.jsp");
		return mav;
	}
}