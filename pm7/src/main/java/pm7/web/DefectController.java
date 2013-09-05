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
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;

import pm7.service.DefectService;

/**
 * Spring MVC controller that handles CRUD requests for Defect entities
 * 
 */

@Controller("DefectController")
public class DefectController {

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
	 * Service injected by Spring that provides CRUD operations for Defect entities
	 * 
	 */
	@Autowired
	private DefectService defectService;

	/**
	 * Create a new Testcase entity
	 * 
	 */
	@RequestMapping("/newDefectTestcase")
	public ModelAndView newDefectTestcase(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("testcase", new Testcase());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/testcase/editTestcase.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveDefect")
	public String saveDefect(@ModelAttribute Defect defect) {
		defectService.saveDefect(defect);
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/
		return "forward:/indexDefect";
	}

	/**
	 * Show all Project entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectProject")
	public ModelAndView listDefectProject(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/project/listProject.jsp");

		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveDefectStatusupdates")
	public ModelAndView saveDefectStatusupdates(@RequestParam Integer defect_defectId, @ModelAttribute Statusupdate statusupdates) {
		Defect parent_defect = defectService.saveDefectStatusupdates(defect_defectId, statusupdates);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/editDefect.jsp");
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Create a new Releaseplan entity
	 * 
	 */
	@RequestMapping("/newDefectReleaseplan")
	public ModelAndView newDefectReleaseplan(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("releaseplan", new Releaseplan());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectDefectProject")
	public ModelAndView selectDefectProject(@RequestParam Integer defect_defectId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("project", project);
		mav.setViewName("defect/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectStatusupdates")
	public ModelAndView confirmDeleteDefectStatusupdates(@RequestParam Integer defect_defectId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/statusupdates/deleteStatusupdates.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectProject")
	public ModelAndView confirmDeleteDefectProject(@RequestParam Integer defect_defectId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newDefectRequirement")
	public ModelAndView newDefectRequirement(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/requirement/editRequirement.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Show all Account entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectAccount")
	public ModelAndView listDefectAccount(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editDefectAccount")
	public ModelAndView editDefectAccount(@RequestParam Integer defect_defectId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("account", account);
		mav.setViewName("defect/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteDefectStatusupdates")
	public ModelAndView deleteDefectStatusupdates(@RequestParam Integer defect_defectId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectStatusupdates(defect_defectId, related_statusupdates_statusId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/editDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Show all Changerequest entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectChangerequest")
	public ModelAndView listDefectChangerequest(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/changerequest/listChangerequest.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteDefectChangerequest")
	public ModelAndView deleteDefectChangerequest(@RequestParam Integer defect_defectId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectChangerequest(defect_defectId, related_changerequest_changeId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Show all Releaseplan entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectReleaseplan")
	public ModelAndView listDefectReleaseplan(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/releaseplan/listReleaseplan.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectAccount")
	public ModelAndView confirmDeleteDefectAccount(@RequestParam Integer defect_defectId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteDefectProject")
	public ModelAndView deleteDefectProject(@RequestParam Integer defect_defectId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectProject(defect_defectId, related_project_projectId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/viewDefect.jsp");

		return mav;
	}

	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editDefect")
	public ModelAndView editDefect(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/editDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Select the child Releaseplan entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectReleaseplan")
	public ModelAndView confirmDeleteDefectReleaseplan(@RequestParam Integer defect_defectId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/releaseplan/deleteReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Requirement entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectRequirement")
	public ModelAndView listDefectRequirement(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/requirement/listRequirement.jsp");

		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newDefectChangerequest")
	public ModelAndView newDefectChangerequest(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/changerequest/editChangerequest.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newDefectAccount")
	public ModelAndView newDefectAccount(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editDefectStatusupdates")
	public ModelAndView editDefectStatusupdates(@RequestParam Integer defect_defectId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("defect/statusupdates/editStatusupdates.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Entry point to show all Defect entities
	 * 
	 */
	public String indexDefect() {
		return "redirect:/indexDefect";
	}

	/**
	 * Show all Statusupdate entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectStatusupdates")
	public ModelAndView listDefectStatusupdates(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/statusupdates/listStatusupdates.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteDefectAccount")
	public ModelAndView deleteDefectAccount(@RequestParam Integer defect_defectId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectAccount(defect_defectId, related_account_accountId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/editDefect.jsp");

		return mav;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@RequestMapping("/saveDefectTestcase")
	public ModelAndView saveDefectTestcase(@RequestParam Integer defect_defectId, @ModelAttribute Testcase testcase) {
		Defect parent_defect = defectService.saveDefectTestcase(defect_defectId, testcase);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectChangerequest")
	public ModelAndView confirmDeleteDefectChangerequest(@RequestParam Integer defect_defectId, @RequestParam Integer related_changerequest_changeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/changerequest/deleteChangerequest.jsp");

		return mav;
	}

	/**
	 * Edit an existing Testcase entity
	 * 
	 */
	@RequestMapping("/editDefectTestcase")
	public ModelAndView editDefectTestcase(@RequestParam Integer defect_defectId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("testcase", testcase);
		mav.setViewName("defect/testcase/editTestcase.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editDefectProject")
	public ModelAndView editDefectProject(@RequestParam Integer defect_defectId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("project", project);
		mav.setViewName("defect/project/editProject.jsp");

		return mav;
	}

	/**
	 * View an existing Testcase entity
	 * 
	 */
	@RequestMapping("/selectDefectTestcase")
	public ModelAndView selectDefectTestcase(@RequestParam Integer defect_defectId, @RequestParam Integer testcase_testId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("testcase", testcase);
		mav.setViewName("defect/testcase/viewTestcase.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveDefectRequirement")
	public ModelAndView saveDefectRequirement(@RequestParam Integer defect_defectId, @ModelAttribute Requirement requirement) {
		Defect parent_defect = defectService.saveDefectRequirement(defect_defectId, requirement);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectDefectAccount")
	public ModelAndView selectDefectAccount(@RequestParam Integer defect_defectId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("account", account);
		mav.setViewName("defect/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveDefectChangerequest")
	public ModelAndView saveDefectChangerequest(@RequestParam Integer defect_defectId, @ModelAttribute Changerequest changerequest) {
		Defect parent_defect = defectService.saveDefectChangerequest(defect_defectId, changerequest);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Show all Attachment entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectAttachments")
	public ModelAndView listDefectAttachments(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/attachments/listAttachments.jsp");

		return mav;
	}

	/**
	 * Select the Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefect")
	public ModelAndView confirmDeleteDefect(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/deleteDefect.jsp");

		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newDefectStatusupdates")
	public ModelAndView newDefectStatusupdates(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/statusupdates/editStatusupdates.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteDefect")
	public String deleteDefect(@RequestParam Integer defectIdKey) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectIdKey);
		defectService.deleteDefect(defect);
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/
		return "forward:/indexDefect";
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@RequestMapping("/deleteDefectTasks")
	public ModelAndView deleteDefectTasks(@RequestParam Integer defect_defectId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectTasks(defect_defectId, related_tasks_taskId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newDefectProject")
	public ModelAndView newDefectProject(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/project/editProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Attachment entity
	 * 
	 */
	@RequestMapping("/editDefectAttachments")
	public ModelAndView editDefectAttachments(@RequestParam Integer defect_defectId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("attachment", attachment);
		mav.setViewName("defect/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * View an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/selectDefectChangerequest")
	public ModelAndView selectDefectChangerequest(@RequestParam Integer defect_defectId, @RequestParam Integer changerequest_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("defect/changerequest/viewChangerequest.jsp");

		return mav;
	}

	/**
	 * Show all Defect entities
	 * 
	 */
	@RequestMapping("/indexDefect")
	public ModelAndView listDefects() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defects", defectService.loadDefects());

		mav.setViewName("defect/listDefects.jsp");

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
	 * Select the child Attachment entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectAttachments")
	public ModelAndView confirmDeleteDefectAttachments(@RequestParam Integer defect_defectId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("attachment", attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/attachments/deleteAttachments.jsp");

		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newDefect")
	public ModelAndView newDefect() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/editDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Edit an existing Task entity
	 * 
	 */
	@RequestMapping("/editDefectTasks")
	public ModelAndView editDefectTasks(@RequestParam Integer defect_defectId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("task", task);
		mav.setViewName("defect/tasks/editTasks.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * View an existing Attachment entity
	 * 
	 */
	@RequestMapping("/selectDefectAttachments")
	public ModelAndView selectDefectAttachments(@RequestParam Integer defect_defectId, @RequestParam Integer attachments_attachId) {
		Attachment attachment = attachmentDAO.findAttachmentByPrimaryKey(attachments_attachId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("attachment", attachment);
		mav.setViewName("defect/attachments/viewAttachments.jsp");

		return mav;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@RequestMapping("/saveDefectTasks")
	public ModelAndView saveDefectTasks(@RequestParam Integer defect_defectId, @ModelAttribute Task tasks) {
		Defect parent_defect = defectService.saveDefectTasks(defect_defectId, tasks);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editDefectRequirement")
	public ModelAndView editDefectRequirement(@RequestParam Integer defect_defectId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("requirement", requirement);
		mav.setViewName("defect/requirement/editRequirement.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@RequestMapping("/deleteDefectTestcase")
	public ModelAndView deleteDefectTestcase(@RequestParam Integer defect_defectId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectTestcase(defect_defectId, related_testcase_testId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveDefectAccount")
	public ModelAndView saveDefectAccount(@RequestParam Integer defect_defectId, @ModelAttribute Account account) {
		Defect parent_defect = defectService.saveDefectAccount(defect_defectId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/viewDefect.jsp");

		return mav;
	}

	/**
	 * Select an existing Defect entity
	 * 
	 */
	@RequestMapping("/selectDefect")
	public ModelAndView selectDefect(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/viewDefect.jsp");

		return mav;
	}

	/**
	 * View an existing Task entity
	 * 
	 */
	@RequestMapping("/selectDefectTasks")
	public ModelAndView selectDefectTasks(@RequestParam Integer defect_defectId, @RequestParam Integer tasks_taskId) {
		Task task = taskDAO.findTaskByPrimaryKey(tasks_taskId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("task", task);
		mav.setViewName("defect/tasks/viewTasks.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteDefectRequirement")
	public ModelAndView deleteDefectRequirement(@RequestParam Integer defect_defectId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectRequirement(defect_defectId, related_requirement_reqmtId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/viewDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@RequestMapping("/saveDefectAttachments")
	public ModelAndView saveDefectAttachments(@RequestParam Integer defect_defectId, @ModelAttribute Attachment attachments) {
		Defect parent_defect = defectService.saveDefectAttachments(defect_defectId, attachments);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/editDefect.jsp");
		/**
	public String saveProgram(HttpServletRequest request, @ModelAttribute Program program, @RequestParam Integer selected_id1, @RequestParam Integer selected_id4, @RequestParam Integer selected_id8, @RequestParam Integer selected_id11, @RequestParam Integer selected_sport_id1) {
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/deleteDefectReleaseplan")
	public ModelAndView deleteDefectReleaseplan(@RequestParam Integer defect_defectId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectReleaseplan(defect_defectId, related_releaseplan_releaseId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/viewDefect.jsp");

		return mav;
	}

	/**
	 * Create a new Task entity
	 * 
	 */
	@RequestMapping("/newDefectTasks")
	public ModelAndView newDefectTasks(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("task", new Task());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/tasks/editTasks.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Select the child Testcase entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectTestcase")
	public ModelAndView confirmDeleteDefectTestcase(@RequestParam Integer defect_defectId, @RequestParam Integer related_testcase_testId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("testcase", testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/testcase/deleteTestcase.jsp");

		return mav;
	}

	/**
	 * View an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/selectDefectStatusupdates")
	public ModelAndView selectDefectStatusupdates(@RequestParam Integer defect_defectId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("defect/statusupdates/viewStatusupdates.jsp");

		return mav;
	}

	/**
	 * Edit an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/editDefectReleaseplan")
	public ModelAndView editDefectReleaseplan(@RequestParam Integer defect_defectId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("defect/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Task entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectTasks")
	public ModelAndView listDefectTasks(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/tasks/listTasks.jsp");

		return mav;
	}

	/**
	 * View an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectDefectRequirement")
	public ModelAndView selectDefectRequirement(@RequestParam Integer defect_defectId, @RequestParam Integer requirement_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("requirement", requirement);
		mav.setViewName("defect/requirement/viewRequirement.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/defectController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * View an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/selectDefectReleaseplan")
	public ModelAndView selectDefectReleaseplan(@RequestParam Integer defect_defectId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("defect/releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editDefectChangerequest")
	public ModelAndView editDefectChangerequest(@RequestParam Integer defect_defectId, @RequestParam Integer changerequest_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("defect/changerequest/editChangerequest.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Select the child Task entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectTasks")
	public ModelAndView confirmDeleteDefectTasks(@RequestParam Integer defect_defectId, @RequestParam Integer related_tasks_taskId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("task", taskDAO.findTaskByPrimaryKey(related_tasks_taskId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/tasks/deleteTasks.jsp");

		return mav;
	}

	/**
	 * Create a new Attachment entity
	 * 
	 */
	@RequestMapping("/newDefectAttachments")
	public ModelAndView newDefectAttachments(@RequestParam Integer defect_defectId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("attachment", new Attachment());
		mav.addObject("newFlag", true);
		mav.setViewName("defect/attachments/editAttachments.jsp");

		return mav;
	}

	/**
	 * Show all Testcase entities by Defect
	 * 
	 */
	@RequestMapping("/listDefectTestcase")
	public ModelAndView listDefectTestcase(@RequestParam Integer defectIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(defectIdKey));
		mav.setViewName("defect/testcase/listTestcase.jsp");

		return mav;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@RequestMapping("/deleteDefectAttachments")
	public ModelAndView deleteDefectAttachments(@RequestParam Integer defect_defectId, @RequestParam Integer related_attachments_attachId) {
		ModelAndView mav = new ModelAndView();

		Defect defect = defectService.deleteDefectAttachments(defect_defectId, related_attachments_attachId);

		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", defect);
		mav.setViewName("defect/editDefect.jsp");
		/**
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("levels", levelService.findAllLevels4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("resources", resourceService.findAllResources4tsw(tswacct, startResult , defaultMaxRows));
		mav.addObject("user",sessionCache.getUser4Session(request));	
		**/

		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteDefectRequirement")
	public ModelAndView confirmDeleteDefectRequirement(@RequestParam Integer defect_defectId, @RequestParam Integer related_requirement_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId));
		mav.addObject("defect_defectId", defect_defectId);
		mav.setViewName("defect/requirement/deleteRequirement.jsp");

		return mav;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/saveDefectReleaseplan")
	public ModelAndView saveDefectReleaseplan(@RequestParam Integer defect_defectId, @ModelAttribute Releaseplan releaseplan) {
		Defect parent_defect = defectService.saveDefectReleaseplan(defect_defectId, releaseplan);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/viewDefect.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveDefectProject")
	public ModelAndView saveDefectProject(@RequestParam Integer defect_defectId, @ModelAttribute Project project) {
		Defect parent_defect = defectService.saveDefectProject(defect_defectId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("defect_defectId", defect_defectId);
		mav.addObject("defect", parent_defect);
		mav.setViewName("defect/viewDefect.jsp");

		return mav;
	}
}