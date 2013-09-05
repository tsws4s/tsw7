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
import pm7.dao.DefectDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Defect;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;

import pm7.service.StatusupdateService;

/**
 * Spring MVC controller that handles CRUD requests for Statusupdate entities
 * 
 */

@Controller("StatusupdateController")
public class StatusupdateController {

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
	 * Service injected by Spring that provides CRUD operations for Statusupdate entities
	 * 
	 */
	@Autowired
	private StatusupdateService statusupdateService;

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateAccount")
	public ModelAndView confirmDeleteStatusupdateAccount(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateProject")
	public ModelAndView confirmDeleteStatusupdateProject(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateDefect")
	public ModelAndView deleteStatusupdateDefect(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_defect_defectId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateDefect(statusupdate_statusId, related_defect_defectId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateRequirement")
	public ModelAndView deleteStatusupdateRequirement(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateRequirement(statusupdate_statusId, related_requirement_reqmtId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Create a new Person entity
	 * 
	 */
	@RequestMapping("/newStatusupdatePerson")
	public ModelAndView newStatusupdatePerson(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("person", new Person());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Show all Person entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdatePerson")
	public ModelAndView listStatusupdatePerson(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/person/listPerson.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateProject")
	public ModelAndView listStatusupdateProject(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/project/listProject.jsp");

		return mav;
	}

	/**
	 * Select the child Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateAttachments")
	public ModelAndView confirmDeleteStatusupdateAttachments(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/attachments/deleteAttachments.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newStatusupdateProject")
	public ModelAndView newStatusupdateProject(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/project/editProject.jsp");

		return mav;
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateDefect")
	public ModelAndView confirmDeleteStatusupdateDefect(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_defect_defectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defect_defectId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/defect/deleteDefect.jsp");

		return mav;
	}

	/**
	 * Show all Task entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateTask")
	public ModelAndView listStatusupdateTask(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/task/listTask.jsp");

		return mav;
	}

	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editStatusupdateDefect")
	public ModelAndView editStatusupdateDefect(@RequestParam Integer statusupdate_statusId, @RequestParam Integer defect_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("defect", defect);
		mav.setViewName("statusupdate/defect/editDefect.jsp");

		return mav;
	}

	/**
	 * Edit an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/editStatusupdateReleaseplan")
	public ModelAndView editStatusupdateReleaseplan(@RequestParam Integer statusupdate_statusId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("statusupdate/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newStatusupdateTestcase")
	public ModelAndView newStatusupdateTestcase(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/testcase/editTestcase.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editStatusupdateAccount")
	public ModelAndView editStatusupdateAccount(@RequestParam Integer statusupdate_statusId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("account", account);
		mav.setViewName("statusupdate/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Show all Statusupdate entities
	 * 
	 */
	@RequestMapping("/indexStatusupdate")
	public ModelAndView listStatusupdates() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdates", statusupdateService.loadStatusupdates());

		mav.setViewName("statusupdate/listStatusupdates.jsp");

		return mav;
	}

	/**
	 * Show all Releaseplan entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateReleaseplan")
	public ModelAndView listStatusupdateReleaseplan(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/releaseplan/listReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Person entity
	 * 
	 */
	@RequestMapping("/selectStatusupdatePerson")
	public ModelAndView selectStatusupdatePerson(@RequestParam Integer statusupdate_statusId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("person", person);
		mav.setViewName("statusupdate/person/viewPerson.jsp");

		return mav;
	}

	/**
	 * View an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateReleaseplan")
	public ModelAndView selectStatusupdateReleaseplan(@RequestParam Integer statusupdate_statusId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("statusupdate/releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Testcase entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateTestcase")
	public ModelAndView selectStatusupdateTestcase(@RequestParam Integer statusupdate_statusId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("testcase", testcase);
		mav.setViewName("statusupdate/testcase/viewTestcase.jsp");

		return mav;
	}

	/**
	 * Create a new Releaseplan entity
	 * 
	 */
	@RequestMapping("/newStatusupdateReleaseplan")
	public ModelAndView newStatusupdateReleaseplan(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("releaseplan", new Releaseplan());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newStatusupdateRequirement")
	public ModelAndView newStatusupdateRequirement(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * View an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateRequirement")
	public ModelAndView selectStatusupdateRequirement(@RequestParam Integer statusupdate_statusId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("requirement", requirement);
		mav.setViewName("statusupdate/requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 * View an existing Attachment entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateAttachments")
	public ModelAndView selectStatusupdateAttachments(@RequestParam Integer statusupdate_statusId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("attachment", attachment);
		mav.setViewName("statusupdate/attachments/viewAttachments.jsp");

		return mav;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateAttachments")
	public ModelAndView deleteStatusupdateAttachments(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateAttachments(statusupdate_statusId, related_attachments_attachId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateTask")
	public ModelAndView confirmDeleteStatusupdateTask(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_task_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_task_taskId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/task/deleteTask.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateRequirement")
	public ModelAndView saveStatusupdateRequirement(@RequestParam Integer statusupdate_statusId, @ModelAttribute Requirement requirement) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateRequirement(statusupdate_statusId, requirement);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@RequestMapping("/saveStatusupdatePerson")
	public ModelAndView saveStatusupdatePerson(@RequestParam Integer statusupdate_statusId, @ModelAttribute Person person) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdatePerson(statusupdate_statusId, person);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editStatusupdateTestcase")
	public ModelAndView editStatusupdateTestcase(@RequestParam Integer statusupdate_statusId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("testcase", testcase);
		mav.setViewName("statusupdate/testcase/editTestcase.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateTestcase")
	public ModelAndView saveStatusupdateTestcase(@RequestParam Integer statusupdate_statusId, @ModelAttribute Testcase testcase) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateTestcase(statusupdate_statusId, testcase);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Select the child Releaseplan entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateReleaseplan")
	public ModelAndView confirmDeleteStatusupdateReleaseplan(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/releaseplan/deleteReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Requirement entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateRequirement")
	public ModelAndView listStatusupdateRequirement(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/requirement/listRequirement.jsp");

		return mav;
	}

	/**
	 * View an existing Defect entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateDefect")
	public ModelAndView selectStatusupdateDefect(@RequestParam Integer statusupdate_statusId, @RequestParam Integer defect_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("defect", defect);
		mav.setViewName("statusupdate/defect/viewDefect.jsp");

		return mav;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateReleaseplan")
	public ModelAndView deleteStatusupdateReleaseplan(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateReleaseplan(statusupdate_statusId, related_releaseplan_releaseId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Show all Attachment entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateAttachments")
	public ModelAndView listStatusupdateAttachments(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/attachments/listAttachments.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateProject")
	public ModelAndView saveStatusupdateProject(@RequestParam Integer statusupdate_statusId, @ModelAttribute Project project) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateProject(statusupdate_statusId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/statusupdateController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * View an existing Task entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateTask")
	public ModelAndView selectStatusupdateTask(@RequestParam Integer statusupdate_statusId, @RequestParam Integer task_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("task", task);
		mav.setViewName("statusupdate/task/viewTask.jsp");

		return mav;
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editStatusupdateAttachments")
	public ModelAndView editStatusupdateAttachments(@RequestParam Integer statusupdate_statusId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("attachment", attachment);
		mav.setViewName("statusupdate/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateTestcase")
	public ModelAndView confirmDeleteStatusupdateTestcase(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/testcase/deleteTestcase.jsp");

		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateTestcase")
	public ModelAndView deleteStatusupdateTestcase(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateTestcase(statusupdate_statusId, related_testcase_testId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateAccount")
	public ModelAndView deleteStatusupdateAccount(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateAccount(statusupdate_statusId, related_account_accountId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editStatusupdateRequirement")
	public ModelAndView editStatusupdateRequirement(@RequestParam Integer statusupdate_statusId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("requirement", requirement);
		mav.setViewName("statusupdate/requirement/editRequirement.jsp");

		return mav;
	}

	/**
	 * Select the Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdate")
	public ModelAndView confirmDeleteStatusupdate(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/deleteStatusupdate.jsp");

		return mav;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateReleaseplan")
	public ModelAndView saveStatusupdateReleaseplan(@RequestParam Integer statusupdate_statusId, @ModelAttribute Releaseplan releaseplan) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateReleaseplan(statusupdate_statusId, releaseplan);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Select an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/selectStatusupdate")
	public ModelAndView selectStatusupdate(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateProject")
	public ModelAndView selectStatusupdateProject(@RequestParam Integer statusupdate_statusId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("project", project);
		mav.setViewName("statusupdate/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newStatusupdateDefect")
	public ModelAndView newStatusupdateDefect(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/defect/editDefect.jsp");

		return mav;
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newStatusupdateTask")
	public ModelAndView newStatusupdateTask(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/task/editTask.jsp");

		return mav;
	}

	/**
	 * Select the child Person entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdatePerson")
	public ModelAndView confirmDeleteStatusupdatePerson(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("person", personDAO.findPersonByPrimaryKey(related_person_personId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/person/deletePerson.jsp");

		return mav;
	}

	/**
	 * Edit an existing Person entity
	 * 
	 */
	@RequestMapping("/editStatusupdatePerson")
	public ModelAndView editStatusupdatePerson(@RequestParam Integer statusupdate_statusId, @RequestParam Integer person_personId) {
		Person person = personDAO.findPersonByPrimaryKey(person_personId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("person", person);
		mav.setViewName("statusupdate/person/editPerson.jsp");

		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateDefect")
	public ModelAndView saveStatusupdateDefect(@RequestParam Integer statusupdate_statusId, @ModelAttribute Defect defect) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateDefect(statusupdate_statusId, defect);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateAccount")
	public ModelAndView saveStatusupdateAccount(@RequestParam Integer statusupdate_statusId, @ModelAttribute Account account) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateAccount(statusupdate_statusId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editStatusupdate")
	public ModelAndView editStatusupdate(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/editStatusupdate.jsp");

		return mav;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateTask")
	public ModelAndView deleteStatusupdateTask(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_task_taskId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateTask(statusupdate_statusId, related_task_taskId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateAccount")
	public ModelAndView listStatusupdateAccount(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateTask")
	public ModelAndView saveStatusupdateTask(@RequestParam Integer statusupdate_statusId, @ModelAttribute Task task) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateTask(statusupdate_statusId, task);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newStatusupdateAccount")
	public ModelAndView newStatusupdateAccount(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/saveStatusupdateAttachments")
	public ModelAndView saveStatusupdateAttachments(@RequestParam Integer statusupdate_statusId, @ModelAttribute Attachment attachments) {
		Statusupdate parent_statusupdate = statusupdateService.saveStatusupdateAttachments(statusupdate_statusId, attachments);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", parent_statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Show all Defect entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateDefect")
	public ModelAndView listStatusupdateDefect(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/defect/listDefect.jsp");

		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newStatusupdateAttachments")
	public ModelAndView newStatusupdateAttachments(@RequestParam Integer statusupdate_statusId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdatePerson")
	public ModelAndView deleteStatusupdatePerson(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_person_personId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdatePerson(statusupdate_statusId, related_person_personId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Statusupdate entities
	 * 
	 */
	public String indexStatusupdate() {
		return "redirect:/indexStatusupdate";
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdateProject")
	public ModelAndView deleteStatusupdateProject(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Statusupdate statusupdate = statusupdateService.deleteStatusupdateProject(statusupdate_statusId, related_project_projectId);

		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("statusupdate/viewStatusupdate.jsp");

		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newStatusupdate")
	public ModelAndView newStatusupdate() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("statusupdate/editStatusupdate.jsp");

		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteStatusupdateRequirement")
	public ModelAndView confirmDeleteStatusupdateRequirement(@RequestParam Integer statusupdate_statusId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId));
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.setViewName("statusupdate/requirement/deleteRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveStatusupdate")
	public String saveStatusupdate(@ModelAttribute Statusupdate statusupdate) {
		statusupdateService.saveStatusupdate(statusupdate);
		return "forward:/indexStatusupdate";
	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editStatusupdateTask")
	public ModelAndView editStatusupdateTask(@RequestParam Integer statusupdate_statusId, @RequestParam Integer task_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("task", task);
		mav.setViewName("statusupdate/task/editTask.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectStatusupdateAccount")
	public ModelAndView selectStatusupdateAccount(@RequestParam Integer statusupdate_statusId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("account", account);
		mav.setViewName("statusupdate/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Show all Testcase entities by Statusupdate
	 * 
	 */
	@RequestMapping("/listStatusupdateTestcase")
	public ModelAndView listStatusupdateTestcase(@RequestParam Integer statusIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey));
		mav.setViewName("statusupdate/testcase/listTestcase.jsp");

		return mav;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteStatusupdate")
	public String deleteStatusupdate(@RequestParam Integer statusIdKey) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusIdKey);
		statusupdateService.deleteStatusupdate(statusupdate);
		return "forward:/indexStatusupdate";
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editStatusupdateProject")
	public ModelAndView editStatusupdateProject(@RequestParam Integer statusupdate_statusId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("statusupdate_statusId", statusupdate_statusId);
		mav.addObject("project", project);
		mav.setViewName("statusupdate/project/editProject.jsp");

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