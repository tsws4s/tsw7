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
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TestcaseDAO;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Testcase;

import pm7.service.AttachmentService;

/**
 * Spring MVC controller that handles CRUD requests for Attachment entities
 * 
 */

@Controller("AttachmentController")
public class AttachmentController {

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
	 * DAO injected by Spring that manages Testcase entities
	 * 
	 */
	@Autowired
	private TestcaseDAO testcaseDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for Attachment entities
	 * 
	 */
	@Autowired
	private AttachmentService attachmentService;

	/**
	 * Show all Account entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentAccount")
	public ModelAndView listAttachmentAccount(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newAttachmentProject")
	public ModelAndView newAttachmentProject(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/project/editProject.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newAttachmentAccount")
	public ModelAndView newAttachmentAccount(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentProject")
	public ModelAndView confirmDeleteAttachmentProject(@RequestParam Integer attachment_attachId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentTestcase")
	public ModelAndView confirmDeleteAttachmentTestcase(@RequestParam Integer attachment_attachId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/testcase/deleteTestcase.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentRequirement")
	public ModelAndView deleteAttachmentRequirement(@RequestParam Integer attachment_attachId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentRequirement(attachment_attachId, related_requirement_reqmtId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editAttachmentPerson")
	public ModelAndView editAttachmentPerson(@RequestParam Integer attachment_attachId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("person", person);
		mav.setViewName("attachment/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Attachment entities
	 * 
	 */
	public String indexAttachment() {
		return "redirect:/indexAttachment";
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editAttachmentProject")
	public ModelAndView editAttachmentProject(@RequestParam Integer attachment_attachId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("project", project);
		mav.setViewName("attachment/project/editProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editAttachmentTestcase")
	public ModelAndView editAttachmentTestcase(@RequestParam Integer attachment_attachId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("testcase", testcase);
		mav.setViewName("attachment/testcase/editTestcase.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editAttachmentAccount")
	public ModelAndView editAttachmentAccount(@RequestParam Integer attachment_attachId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("account", account);
		mav.setViewName("attachment/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveAttachmentProject")
	public ModelAndView saveAttachmentProject(@RequestParam Integer attachment_attachId, @ModelAttribute Project project) {
		Attachment parent_attachment = attachmentService.saveAttachmentProject(attachment_attachId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentChangerequest")
	public ModelAndView deleteAttachmentChangerequest(@RequestParam Integer attachment_attachId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentChangerequest(attachment_attachId, related_changerequest_changeId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Show all Statusupdate entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentStatusupdate")
	public ModelAndView listAttachmentStatusupdate(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/statusupdate/listStatusupdate.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveAttachmentRequirement")
	public ModelAndView saveAttachmentRequirement(@RequestParam Integer attachment_attachId, @ModelAttribute Requirement requirement) {
		Attachment parent_attachment = attachmentService.saveAttachmentRequirement(attachment_attachId, requirement);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentStatusupdate")
	public ModelAndView deleteAttachmentStatusupdate(@RequestParam Integer attachment_attachId, @RequestParam Integer related_statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentStatusupdate(attachment_attachId, related_statusupdate_statusId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Show all Attachment entities
	 * 
	 */
	@RequestMapping("/indexAttachment")
	public ModelAndView listAttachments() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachments", attachmentService.loadAttachments());

		mav.setViewName("attachment/listAttachments.jsp");

		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveAttachmentChangerequest")
	public ModelAndView saveAttachmentChangerequest(@RequestParam Integer attachment_attachId, @ModelAttribute Changerequest changerequest) {
		Attachment parent_attachment = attachmentService.saveAttachmentChangerequest(attachment_attachId, changerequest);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

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
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveAttachmentAccount")
	public ModelAndView saveAttachmentAccount(@RequestParam Integer attachment_attachId, @ModelAttribute Account account) {
		Attachment parent_attachment = attachmentService.saveAttachmentAccount(attachment_attachId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveAttachmentTestcase")
	public ModelAndView saveAttachmentTestcase(@RequestParam Integer attachment_attachId, @ModelAttribute Testcase testcase) {
		Attachment parent_attachment = attachmentService.saveAttachmentTestcase(attachment_attachId, testcase);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Select the child Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentPerson")
	public ModelAndView confirmDeleteAttachmentPerson(@RequestParam Integer attachment_attachId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(related_person_personId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/person/deletePerson.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveAttachmentPerson")
	public ModelAndView saveAttachmentPerson(@RequestParam Integer attachment_attachId, @ModelAttribute Person person) {
		Attachment parent_attachment = attachmentService.saveAttachmentPerson(attachment_attachId, person);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editAttachmentRequirement")
	public ModelAndView editAttachmentRequirement(@RequestParam Integer attachment_attachId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("requirement", requirement);
		mav.setViewName("attachment/requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/saveAttachment")
	public String saveAttachment(@ModelAttribute Attachment attachment) {
		attachmentService.saveAttachment(attachment);
		return "forward:/indexAttachment";
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newAttachmentRequirement")
	public ModelAndView newAttachmentRequirement(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * Select an existing Attachment entity
	 * 
	 */
	@RequestMapping("/selectAttachment")
	public ModelAndView selectAttachment(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newAttachmentPerson")
	public ModelAndView newAttachmentPerson(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveAttachmentDefect")
	public ModelAndView saveAttachmentDefect(@RequestParam Integer attachment_attachId, @ModelAttribute Defect defect) {
		Attachment parent_attachment = attachmentService.saveAttachmentDefect(attachment_attachId, defect);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Select the Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachment")
	public ModelAndView confirmDeleteAttachment(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/deleteAttachment.jsp");

		return mav;
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editAttachment")
	public ModelAndView editAttachment(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/editAttachment.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectAttachmentAccount")
	public ModelAndView selectAttachmentAccount(@RequestParam Integer attachment_attachId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("account", account);
		mav.setViewName("attachment/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentProject")
	public ModelAndView deleteAttachmentProject(@RequestParam Integer attachment_attachId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentProject(attachment_attachId, related_project_projectId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveAttachmentStatusupdate")
	public ModelAndView saveAttachmentStatusupdate(@RequestParam Integer attachment_attachId, @ModelAttribute Statusupdate statusupdate) {
		Attachment parent_attachment = attachmentService.saveAttachmentStatusupdate(attachment_attachId, statusupdate);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", parent_attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentStatusupdate")
	public ModelAndView confirmDeleteAttachmentStatusupdate(@RequestParam Integer attachment_attachId, @RequestParam Integer related_statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdate_statusId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/statusupdate/deleteStatusupdate.jsp");

		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newAttachmentDefect")
	public ModelAndView newAttachmentDefect(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/defect/editDefect.jsp");

		return mav;
	}

	/**
	 * View an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectAttachmentRequirement")
	public ModelAndView selectAttachmentRequirement(@RequestParam Integer attachment_attachId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("requirement", requirement);
		mav.setViewName("attachment/requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * View an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/selectAttachmentChangerequest")
	public ModelAndView selectAttachmentChangerequest(@RequestParam Integer attachment_attachId, @RequestParam Integer changerequest_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("attachment/changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectAttachmentProject")
	public ModelAndView selectAttachmentProject(@RequestParam Integer attachment_attachId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("project", project);
		mav.setViewName("attachment/project/viewProject.jsp");

		return mav;
	}

	/**
	 * View an existing Testcase entity
	 * 
	 */
	@RequestMapping("/selectAttachmentTestcase")
	public ModelAndView selectAttachmentTestcase(@RequestParam Integer attachment_attachId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("testcase", testcase);
		mav.setViewName("attachment/testcase/viewTestcase.jsp");

		return mav;
	}

	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editAttachmentDefect")
	public ModelAndView editAttachmentDefect(@RequestParam Integer attachment_attachId, @RequestParam Integer defect_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("defect", defect);
		mav.setViewName("attachment/defect/editDefect.jsp");

		return mav;
	}

	/**
	 * View an existing Person entity
	 * 
	 */
	@RequestMapping("/selectAttachmentPerson")
	public ModelAndView selectAttachmentPerson(@RequestParam Integer attachment_attachId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("person", person);
		mav.setViewName("attachment/person/viewPerson.jsp");

		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentRequirement")
	public ModelAndView confirmDeleteAttachmentRequirement(@RequestParam Integer attachment_attachId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/requirement/deleteRequirement.jsp");

		return mav;
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentDefect")
	public ModelAndView confirmDeleteAttachmentDefect(@RequestParam Integer attachment_attachId, @RequestParam Integer related_defect_defectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defect_defectId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/defect/deleteDefect.jsp");

		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newAttachmentStatusupdate")
	public ModelAndView newAttachmentStatusupdate(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/statusupdate/editStatusupdate.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/attachmentController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Show all Testcase entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentTestcase")
	public ModelAndView listAttachmentTestcase(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/testcase/listTestcase.jsp");

		return mav;
	}

	/**
	 * Show all Person entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentPerson")
	public ModelAndView listAttachmentPerson(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/person/listPerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editAttachmentChangerequest")
	public ModelAndView editAttachmentChangerequest(@RequestParam Integer attachment_attachId, @RequestParam Integer changerequest_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("attachment/changerequest/editChangerequest.jsp");

		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentTestcase")
	public ModelAndView deleteAttachmentTestcase(@RequestParam Integer attachment_attachId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentTestcase(attachment_attachId, related_testcase_testId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editAttachmentStatusupdate")
	public ModelAndView editAttachmentStatusupdate(@RequestParam Integer attachment_attachId, @RequestParam Integer statusupdate_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("attachment/statusupdate/editStatusupdate.jsp");

		return mav;
	}

	/**
	 * View an existing Defect entity
	 * 
	 */
	@RequestMapping("/selectAttachmentDefect")
	public ModelAndView selectAttachmentDefect(@RequestParam Integer attachment_attachId, @RequestParam Integer defect_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("defect", defect);
		mav.setViewName("attachment/defect/viewDefect.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentAccount")
	public ModelAndView deleteAttachmentAccount(@RequestParam Integer attachment_attachId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentAccount(attachment_attachId, related_account_accountId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentProject")
	public ModelAndView listAttachmentProject(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/project/listProject.jsp");

		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newAttachment")
	public ModelAndView newAttachment() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/editAttachment.jsp");

		return mav;
	}

	/**
	 * Show all Requirement entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentRequirement")
	public ModelAndView listAttachmentRequirement(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/requirement/listRequirement.jsp");

		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newAttachmentChangerequest")
	public ModelAndView newAttachmentChangerequest(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/changerequest/editChangerequest.jsp");

		return mav;
	}

	/**
	 * Show all Changerequest entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentChangerequest")
	public ModelAndView listAttachmentChangerequest(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/changerequest/listChangerequest.jsp");

		return mav;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentPerson")
	public ModelAndView deleteAttachmentPerson(@RequestParam Integer attachment_attachId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentPerson(attachment_attachId, related_person_personId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newAttachmentTestcase")
	public ModelAndView newAttachmentTestcase(@RequestParam Integer attachment_attachId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("attachment/testcase/editTestcase.jsp");

		return mav;
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentChangerequest")
	public ModelAndView confirmDeleteAttachmentChangerequest(@RequestParam Integer attachment_attachId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/changerequest/deleteChangerequest.jsp");

		return mav;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deleteAttachment")
	public String deleteAttachment(@RequestParam Integer attachIdKey) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachIdKey);
		attachmentService.deleteAttachment(attachment);
		return "forward:/indexAttachment";
	}

	/**
	 * Show all Defect entities by Attachment
	 * 
	 */
	@RequestMapping("/listAttachmentDefect")
	public ModelAndView listAttachmentDefect(@RequestParam Integer attachIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(attachIdKey));
		mav.setViewName("attachment/defect/listDefect.jsp");

		return mav;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteAttachmentDefect")
	public ModelAndView deleteAttachmentDefect(@RequestParam Integer attachment_attachId, @RequestParam Integer related_defect_defectId) {
		ModelAndView mav = new ModelAndView();

		Attachment attachment = attachmentService.deleteAttachmentDefect(attachment_attachId, related_defect_defectId);

		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("attachment", attachment);
		mav.setViewName("attachment/viewAttachment.jsp");

		return mav;
	}

	/**
	 * View an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/selectAttachmentStatusupdate")
	public ModelAndView selectAttachmentStatusupdate(@RequestParam Integer attachment_attachId, @RequestParam Integer statusupdate_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("attachment/statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteAttachmentAccount")
	public ModelAndView confirmDeleteAttachmentAccount(@RequestParam Integer attachment_attachId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("attachment_attachId", attachment_attachId);
		mav.setViewName("attachment/account/deleteAccount.jsp");

		return mav;
	}
}