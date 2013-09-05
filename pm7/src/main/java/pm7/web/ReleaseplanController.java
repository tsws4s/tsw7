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
import pm7.dao.ChangerequestDAO;
import pm7.dao.DefectDAO;
import pm7.dao.FeatureDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;

import pm7.domain.Account;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Feature;
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;

import pm7.service.ReleaseplanService;

/**
 * Spring MVC controller that handles CRUD requests for Releaseplan entities
 * 
 */

@Controller("ReleaseplanController")
public class ReleaseplanController {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

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
	 * Service injected by Spring that provides CRUD operations for Releaseplan entities
	 * 
	 */
	@Autowired
	private ReleaseplanService releaseplanService;

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editReleaseplanProject")
	public ModelAndView editReleaseplanProject(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("project", project);
		mav.setViewName("releaseplan/project/editProject.jsp");

		return mav;
	}

	/**
	 * Show all Defect entities by Releaseplan
	 * 
	 */
	@RequestMapping("/listReleaseplanDefects")
	public ModelAndView listReleaseplanDefects(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/defects/listDefects.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectReleaseplanAccount")
	public ModelAndView selectReleaseplanAccount(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("account", account);
		mav.setViewName("releaseplan/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Releaseplan
	 * 
	 */
	@RequestMapping("/listReleaseplanAccount")
	public ModelAndView listReleaseplanAccount(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/account/listAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveReleaseplanProject")
	public ModelAndView saveReleaseplanProject(@RequestParam Integer releaseplan_releaseId, @ModelAttribute Project project) {
		Releaseplan parent_releaseplan = releaseplanService.saveReleaseplanProject(releaseplan_releaseId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", parent_releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectReleaseplanRequirements")
	public ModelAndView selectReleaseplanRequirements(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer requirements_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirements_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("requirement", requirement);
		mav.setViewName("releaseplan/requirements/viewRequirements.jsp");

		return mav;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplanProject")
	public ModelAndView deleteReleaseplanProject(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Releaseplan releaseplan = releaseplanService.deleteReleaseplanProject(releaseplan_releaseId, related_project_projectId);

		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplanRequirements")
	public ModelAndView confirmDeleteReleaseplanRequirements(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_requirements_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirements_reqmtId));
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.setViewName("releaseplan/requirements/deleteRequirements.jsp");

		return mav;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplanStatusupdates")
	public ModelAndView deleteReleaseplanStatusupdates(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		Releaseplan releaseplan = releaseplanService.deleteReleaseplanStatusupdates(releaseplan_releaseId, related_statusupdates_statusId);

		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Releaseplan entities
	 * 
	 */
	@RequestMapping("/indexReleaseplan")
	public ModelAndView listReleaseplans() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplans", releaseplanService.loadReleaseplans());

		mav.setViewName("releaseplan/listReleaseplans.jsp");

		return mav;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplanFeatures")
	public ModelAndView deleteReleaseplanFeatures(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_features_featureId) {
		ModelAndView mav = new ModelAndView();

		Releaseplan releaseplan = releaseplanService.deleteReleaseplanFeatures(releaseplan_releaseId, related_features_featureId);

		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Create a new Feature entity
	 * 
	 */
	@RequestMapping("/newReleaseplanFeatures")
	public ModelAndView newReleaseplanFeatures(@RequestParam Integer releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("feature", new Feature());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/features/editFeatures.jsp");

		return mav;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@RequestMapping("/saveReleaseplanDefects")
	public ModelAndView saveReleaseplanDefects(@RequestParam Integer releaseplan_releaseId, @ModelAttribute Defect defects) {
		Releaseplan parent_releaseplan = releaseplanService.saveReleaseplanDefects(releaseplan_releaseId, defects);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", parent_releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newReleaseplanRequirements")
	public ModelAndView newReleaseplanRequirements(@RequestParam Integer releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/requirements/editRequirements.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/releaseplanController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplanDefects")
	public ModelAndView deleteReleaseplanDefects(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		Releaseplan releaseplan = releaseplanService.deleteReleaseplanDefects(releaseplan_releaseId, related_defects_defectId);

		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Select the child Statusupdate entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplanStatusupdates")
	public ModelAndView confirmDeleteReleaseplanStatusupdates(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_statusupdates_statusId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("statusupdate", statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId));
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.setViewName("releaseplan/statusupdates/deleteStatusupdates.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplanRequirements")
	public ModelAndView deleteReleaseplanRequirements(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_requirements_reqmtId) {
		ModelAndView mav = new ModelAndView();

		Releaseplan releaseplan = releaseplanService.deleteReleaseplanRequirements(releaseplan_releaseId, related_requirements_reqmtId);

		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Statusupdate entities by Releaseplan
	 * 
	 */
	@RequestMapping("/listReleaseplanStatusupdates")
	public ModelAndView listReleaseplanStatusupdates(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/statusupdates/listStatusupdates.jsp");

		return mav;
	}

	/**
	 * Edit an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/editReleaseplan")
	public ModelAndView editReleaseplan(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editReleaseplanAccount")
	public ModelAndView editReleaseplanAccount(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("account", account);
		mav.setViewName("releaseplan/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveReleaseplanRequirements")
	public ModelAndView saveReleaseplanRequirements(@RequestParam Integer releaseplan_releaseId, @ModelAttribute Requirement requirements) {
		Releaseplan parent_releaseplan = releaseplanService.saveReleaseplanRequirements(releaseplan_releaseId, requirements);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", parent_releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newReleaseplanChangerequests")
	public ModelAndView newReleaseplanChangerequests(@RequestParam Integer releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/changerequests/editChangerequests.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newReleaseplanProject")
	public ModelAndView newReleaseplanProject(@RequestParam Integer releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/project/editProject.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectReleaseplanProject")
	public ModelAndView selectReleaseplanProject(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("project", project);
		mav.setViewName("releaseplan/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveReleaseplanAccount")
	public ModelAndView saveReleaseplanAccount(@RequestParam Integer releaseplan_releaseId, @ModelAttribute Account account) {
		Releaseplan parent_releaseplan = releaseplanService.saveReleaseplanAccount(releaseplan_releaseId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", parent_releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Changerequest entities by Releaseplan
	 * 
	 */
	@RequestMapping("/listReleaseplanChangerequests")
	public ModelAndView listReleaseplanChangerequests(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/changerequests/listChangerequests.jsp");

		return mav;
	}

	/**
	 * View an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/selectReleaseplanStatusupdates")
	public ModelAndView selectReleaseplanStatusupdates(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("releaseplan/statusupdates/viewStatusupdates.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newReleaseplanAccount")
	public ModelAndView newReleaseplanAccount(@RequestParam Integer releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Create a new Statusupdate entity
	 * 
	 */
	@RequestMapping("/newReleaseplanStatusupdates")
	public ModelAndView newReleaseplanStatusupdates(@RequestParam Integer releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("statusupdate", new Statusupdate());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/statusupdates/editStatusupdates.jsp");

		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editReleaseplanRequirements")
	public ModelAndView editReleaseplanRequirements(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer requirements_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirements_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("requirement", requirement);
		mav.setViewName("releaseplan/requirements/editRequirements.jsp");

		return mav;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/saveReleaseplan")
	public String saveReleaseplan(@ModelAttribute Releaseplan releaseplan) {
		releaseplanService.saveReleaseplan(releaseplan);
		return "forward:/indexReleaseplan";
	}

	/**
	 * Select the child Defect entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplanDefects")
	public ModelAndView confirmDeleteReleaseplanDefects(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_defects_defectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("defect", defectDAO.findDefectByPrimaryKey(related_defects_defectId));
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.setViewName("releaseplan/defects/deleteDefects.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplanAccount")
	public ModelAndView confirmDeleteReleaseplanAccount(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.setViewName("releaseplan/account/deleteAccount.jsp");

		return mav;
	}

	/**
	 * View an existing Defect entity
	 * 
	 */
	@RequestMapping("/selectReleaseplanDefects")
	public ModelAndView selectReleaseplanDefects(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("defect", defect);
		mav.setViewName("releaseplan/defects/viewDefects.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplanChangerequests")
	public ModelAndView deleteReleaseplanChangerequests(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		Releaseplan releaseplan = releaseplanService.deleteReleaseplanChangerequests(releaseplan_releaseId, related_changerequests_changeId);

		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Releaseplan
	 * 
	 */
	@RequestMapping("/listReleaseplanProject")
	public ModelAndView listReleaseplanProject(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/project/listProject.jsp");

		return mav;
	}

	/**
	 * Select an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/selectReleaseplan")
	public ModelAndView selectReleaseplan(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplan")
	public String deleteReleaseplan(@RequestParam Integer releaseIdKey) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey);
		releaseplanService.deleteReleaseplan(releaseplan);
		return "forward:/indexReleaseplan";
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplanChangerequests")
	public ModelAndView confirmDeleteReleaseplanChangerequests(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId));
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.setViewName("releaseplan/changerequests/deleteChangerequests.jsp");

		return mav;
	}

	/**
	 * Select the Releaseplan entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplan")
	public ModelAndView confirmDeleteReleaseplan(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/deleteReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/selectReleaseplanChangerequests")
	public ModelAndView selectReleaseplanChangerequests(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer changerequests_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequests_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("releaseplan/changerequests/viewChangerequests.jsp");

		return mav;
	}

	/**
	 * Create a new Defect entity
	 * 
	 */
	@RequestMapping("/newReleaseplanDefects")
	public ModelAndView newReleaseplanDefects(@RequestParam Integer releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("defect", new Defect());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/defects/editDefects.jsp");

		return mav;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/saveReleaseplanStatusupdates")
	public ModelAndView saveReleaseplanStatusupdates(@RequestParam Integer releaseplan_releaseId, @ModelAttribute Statusupdate statusupdates) {
		Releaseplan parent_releaseplan = releaseplanService.saveReleaseplanStatusupdates(releaseplan_releaseId, statusupdates);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", parent_releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Feature entities by Releaseplan
	 * 
	 */
	@RequestMapping("/listReleaseplanFeatures")
	public ModelAndView listReleaseplanFeatures(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/features/listFeatures.jsp");

		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveReleaseplanChangerequests")
	public ModelAndView saveReleaseplanChangerequests(@RequestParam Integer releaseplan_releaseId, @ModelAttribute Changerequest changerequests) {
		Releaseplan parent_releaseplan = releaseplanService.saveReleaseplanChangerequests(releaseplan_releaseId, changerequests);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", parent_releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Edit an existing Feature entity
	 * 
	 */
	@RequestMapping("/editReleaseplanFeatures")
	public ModelAndView editReleaseplanFeatures(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer features_featureId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(features_featureId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("feature", feature);
		mav.setViewName("releaseplan/features/editFeatures.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplanProject")
	public ModelAndView confirmDeleteReleaseplanProject(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.setViewName("releaseplan/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteReleaseplanAccount")
	public ModelAndView deleteReleaseplanAccount(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Releaseplan releaseplan = releaseplanService.deleteReleaseplanAccount(releaseplan_releaseId, related_account_accountId);

		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

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
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editReleaseplanChangerequests")
	public ModelAndView editReleaseplanChangerequests(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer changerequests_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequests_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("releaseplan/changerequests/editChangerequests.jsp");

		return mav;
	}

	/**
	 * Edit an existing Statusupdate entity
	 * 
	 */
	@RequestMapping("/editReleaseplanStatusupdates")
	public ModelAndView editReleaseplanStatusupdates(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer statusupdates_statusId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdates_statusId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("statusupdate", statusupdate);
		mav.setViewName("releaseplan/statusupdates/editStatusupdates.jsp");

		return mav;
	}

	/**
	 * Select the child Feature entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteReleaseplanFeatures")
	public ModelAndView confirmDeleteReleaseplanFeatures(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer related_features_featureId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(related_features_featureId));
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.setViewName("releaseplan/features/deleteFeatures.jsp");

		return mav;
	}

	/**
	 * Show all Requirement entities by Releaseplan
	 * 
	 */
	@RequestMapping("/listReleaseplanRequirements")
	public ModelAndView listReleaseplanRequirements(@RequestParam Integer releaseIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(releaseIdKey));
		mav.setViewName("releaseplan/requirements/listRequirements.jsp");

		return mav;
	}

	/**
	 * Create a new Releaseplan entity
	 * 
	 */
	@RequestMapping("/newReleaseplan")
	public ModelAndView newReleaseplan() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", new Releaseplan());
		mav.addObject("newFlag", true);
		mav.setViewName("releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * View an existing Feature entity
	 * 
	 */
	@RequestMapping("/selectReleaseplanFeatures")
	public ModelAndView selectReleaseplanFeatures(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer features_featureId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(features_featureId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("feature", feature);
		mav.setViewName("releaseplan/features/viewFeatures.jsp");

		return mav;
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@RequestMapping("/saveReleaseplanFeatures")
	public ModelAndView saveReleaseplanFeatures(@RequestParam Integer releaseplan_releaseId, @ModelAttribute Feature features) {
		Releaseplan parent_releaseplan = releaseplanService.saveReleaseplanFeatures(releaseplan_releaseId, features);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("releaseplan", parent_releaseplan);
		mav.setViewName("releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Edit an existing Defect entity
	 * 
	 */
	@RequestMapping("/editReleaseplanDefects")
	public ModelAndView editReleaseplanDefects(@RequestParam Integer releaseplan_releaseId, @RequestParam Integer defects_defectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defects_defectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("releaseplan_releaseId", releaseplan_releaseId);
		mav.addObject("defect", defect);
		mav.setViewName("releaseplan/defects/editDefects.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Releaseplan entities
	 * 
	 */
	public String indexReleaseplan() {
		return "redirect:/indexReleaseplan";
	}
}