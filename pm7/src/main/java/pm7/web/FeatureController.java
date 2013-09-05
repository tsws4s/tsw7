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
import pm7.dao.FeatureDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;

import pm7.domain.Account;
import pm7.domain.Changerequest;
import pm7.domain.Feature;
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;

import pm7.service.FeatureService;

/**
 * Spring MVC controller that handles CRUD requests for Feature entities
 * 
 */

@Controller("FeatureController")
public class FeatureController {

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
	 * Service injected by Spring that provides CRUD operations for Feature entities
	 * 
	 */
	@Autowired
	private FeatureService featureService;

	/**
	 * Select an existing Feature entity
	 * 
	 */
	@RequestMapping("/selectFeature")
	public ModelAndView selectFeature(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Edit an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/editFeatureReleaseplan")
	public ModelAndView editFeatureReleaseplan(@RequestParam Integer feature_featureId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("feature/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Project entities by Feature
	 * 
	 */
	@RequestMapping("/listFeatureProject")
	public ModelAndView listFeatureProject(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/project/listProject.jsp");

		return mav;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@RequestMapping("/deleteFeature")
	public String deleteFeature(@RequestParam Integer featureIdKey) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(featureIdKey);
		featureService.deleteFeature(feature);
		return "forward:/indexFeature";
	}

	/**
	 * Show all Releaseplan entities by Feature
	 * 
	 */
	@RequestMapping("/listFeatureReleaseplan")
	public ModelAndView listFeatureReleaseplan(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/releaseplan/listReleaseplan.jsp");

		return mav;
	}

	/**
	 * Show all Requirement entities by Feature
	 * 
	 */
	@RequestMapping("/listFeatureRequirements")
	public ModelAndView listFeatureRequirements(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/requirements/listRequirements.jsp");

		return mav;
	}

	/**
	 * Select the child Requirement entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteFeatureRequirements")
	public ModelAndView confirmDeleteFeatureRequirements(@RequestParam Integer feature_featureId, @RequestParam Integer related_requirements_reqmtId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("requirement", requirementDAO.findRequirementByPrimaryKey(related_requirements_reqmtId));
		mav.addObject("feature_featureId", feature_featureId);
		mav.setViewName("feature/requirements/deleteRequirements.jsp");

		return mav;
	}

	/**
	 * Create a new Account entity
	 * 
	 */
	@RequestMapping("/newFeatureAccount")
	public ModelAndView newFeatureAccount(@RequestParam Integer feature_featureId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("account", new Account());
		mav.addObject("newFlag", true);
		mav.setViewName("feature/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/deleteFeatureChangerequests")
	public ModelAndView deleteFeatureChangerequests(@RequestParam Integer feature_featureId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		Feature feature = featureService.deleteFeatureChangerequests(feature_featureId, related_changerequests_changeId);

		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * View an existing Project entity
	 * 
	 */
	@RequestMapping("/selectFeatureProject")
	public ModelAndView selectFeatureProject(@RequestParam Integer feature_featureId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("project", project);
		mav.setViewName("feature/project/viewProject.jsp");

		return mav;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@RequestMapping("/deleteFeatureAccount")
	public ModelAndView deleteFeatureAccount(@RequestParam Integer feature_featureId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		Feature feature = featureService.deleteFeatureAccount(feature_featureId, related_account_accountId);

		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@RequestMapping("/saveFeatureRequirements")
	public ModelAndView saveFeatureRequirements(@RequestParam Integer feature_featureId, @ModelAttribute Requirement requirements) {
		Feature parent_feature = featureService.saveFeatureRequirements(feature_featureId, requirements);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", parent_feature);
		mav.setViewName("feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/saveFeatureReleaseplan")
	public ModelAndView saveFeatureReleaseplan(@RequestParam Integer feature_featureId, @ModelAttribute Releaseplan releaseplan) {
		Feature parent_feature = featureService.saveFeatureReleaseplan(feature_featureId, releaseplan);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", parent_feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * View an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/selectFeatureChangerequests")
	public ModelAndView selectFeatureChangerequests(@RequestParam Integer feature_featureId, @RequestParam Integer changerequests_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequests_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("feature/changerequests/viewChangerequests.jsp");

		return mav;
	}

	/**
	 * Create a new Project entity
	 * 
	 */
	@RequestMapping("/newFeatureProject")
	public ModelAndView newFeatureProject(@RequestParam Integer feature_featureId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("project", new Project());
		mav.addObject("newFlag", true);
		mav.setViewName("feature/project/editProject.jsp");

		return mav;
	}

	/**
	 * Create a new Changerequest entity
	 * 
	 */
	@RequestMapping("/newFeatureChangerequests")
	public ModelAndView newFeatureChangerequests(@RequestParam Integer feature_featureId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("changerequest", new Changerequest());
		mav.addObject("newFlag", true);
		mav.setViewName("feature/changerequests/editChangerequests.jsp");

		return mav;
	}

	/**
	 * View an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/selectFeatureReleaseplan")
	public ModelAndView selectFeatureReleaseplan(@RequestParam Integer feature_featureId, @RequestParam Integer releaseplan_releaseId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("releaseplan", releaseplan);
		mav.setViewName("feature/releaseplan/viewReleaseplan.jsp");

		return mav;
	}

	/**
	 * Edit an existing Requirement entity
	 * 
	 */
	@RequestMapping("/editFeatureRequirements")
	public ModelAndView editFeatureRequirements(@RequestParam Integer feature_featureId, @RequestParam Integer requirements_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirements_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("requirement", requirement);
		mav.setViewName("feature/requirements/editRequirements.jsp");

		return mav;
	}

	/**
	 * Select the Feature entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteFeature")
	public ModelAndView confirmDeleteFeature(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/deleteFeature.jsp");

		return mav;
	}

	/**
	 * Entry point to show all Feature entities
	 * 
	 */
	public String indexFeature() {
		return "redirect:/indexFeature";
	}

	/**
	 * Select the child Releaseplan entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteFeatureReleaseplan")
	public ModelAndView confirmDeleteFeatureReleaseplan(@RequestParam Integer feature_featureId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("releaseplan", releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId));
		mav.addObject("feature_featureId", feature_featureId);
		mav.setViewName("feature/releaseplan/deleteReleaseplan.jsp");

		return mav;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@RequestMapping("/deleteFeatureRequirements")
	public ModelAndView deleteFeatureRequirements(@RequestParam Integer feature_featureId, @RequestParam Integer related_requirements_reqmtId) {
		ModelAndView mav = new ModelAndView();

		Feature feature = featureService.deleteFeatureRequirements(feature_featureId, related_requirements_reqmtId);

		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@RequestMapping("/saveFeatureAccount")
	public ModelAndView saveFeatureAccount(@RequestParam Integer feature_featureId, @ModelAttribute Account account) {
		Feature parent_feature = featureService.saveFeatureAccount(feature_featureId, account);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", parent_feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Show all Feature entities
	 * 
	 */
	@RequestMapping("/indexFeature")
	public ModelAndView listFeatures() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("features", featureService.loadFeatures());

		mav.setViewName("feature/listFeatures.jsp");

		return mav;
	}

	/**
	 * Edit an existing Project entity
	 * 
	 */
	@RequestMapping("/editFeatureProject")
	public ModelAndView editFeatureProject(@RequestParam Integer feature_featureId, @RequestParam Integer project_projectId) {
		Project project = projectDAO.findProjectByPrimaryKey(project_projectId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("project", project);
		mav.setViewName("feature/project/editProject.jsp");

		return mav;
	}

	/**
	 * Edit an existing Feature entity
	 * 
	 */
	@RequestMapping("/editFeature")
	public ModelAndView editFeature(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Show all Account entities by Feature
	 * 
	 */
	@RequestMapping("/listFeatureAccount")
	public ModelAndView listFeatureAccount(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/account/listAccount.jsp");

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
	@RequestMapping("/newFeatureReleaseplan")
	public ModelAndView newFeatureReleaseplan(@RequestParam Integer feature_featureId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("releaseplan", new Releaseplan());
		mav.addObject("newFlag", true);
		mav.setViewName("feature/releaseplan/editReleaseplan.jsp");

		return mav;
	}

	/**
	 * Select the child Project entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteFeatureProject")
	public ModelAndView confirmDeleteFeatureProject(@RequestParam Integer feature_featureId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("project", projectDAO.findProjectByPrimaryKey(related_project_projectId));
		mav.addObject("feature_featureId", feature_featureId);
		mav.setViewName("feature/project/deleteProject.jsp");

		return mav;
	}

	/**
	 * Create a new Feature entity
	 * 
	 */
	@RequestMapping("/newFeature")
	public ModelAndView newFeature() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", new Feature());
		mav.addObject("newFlag", true);
		mav.setViewName("feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@RequestMapping("/deleteFeatureReleaseplan")
	public ModelAndView deleteFeatureReleaseplan(@RequestParam Integer feature_featureId, @RequestParam Integer related_releaseplan_releaseId) {
		ModelAndView mav = new ModelAndView();

		Feature feature = featureService.deleteFeatureReleaseplan(feature_featureId, related_releaseplan_releaseId);

		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Select the child Changerequest entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteFeatureChangerequests")
	public ModelAndView confirmDeleteFeatureChangerequests(@RequestParam Integer feature_featureId, @RequestParam Integer related_changerequests_changeId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("changerequest", changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId));
		mav.addObject("feature_featureId", feature_featureId);
		mav.setViewName("feature/changerequests/deleteChangerequests.jsp");

		return mav;
	}

	/**
	 * Show all Changerequest entities by Feature
	 * 
	 */
	@RequestMapping("/listFeatureChangerequests")
	public ModelAndView listFeatureChangerequests(@RequestParam Integer featureIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("feature", featureDAO.findFeatureByPrimaryKey(featureIdKey));
		mav.setViewName("feature/changerequests/listChangerequests.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/featureController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@RequestMapping("/deleteFeatureProject")
	public ModelAndView deleteFeatureProject(@RequestParam Integer feature_featureId, @RequestParam Integer related_project_projectId) {
		ModelAndView mav = new ModelAndView();

		Feature feature = featureService.deleteFeatureProject(feature_featureId, related_project_projectId);

		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * View an existing Requirement entity
	 * 
	 */
	@RequestMapping("/selectFeatureRequirements")
	public ModelAndView selectFeatureRequirements(@RequestParam Integer feature_featureId, @RequestParam Integer requirements_reqmtId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirements_reqmtId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("requirement", requirement);
		mav.setViewName("feature/requirements/viewRequirements.jsp");

		return mav;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/saveFeatureChangerequests")
	public ModelAndView saveFeatureChangerequests(@RequestParam Integer feature_featureId, @ModelAttribute Changerequest changerequests) {
		Feature parent_feature = featureService.saveFeatureChangerequests(feature_featureId, changerequests);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", parent_feature);
		mav.setViewName("feature/editFeature.jsp");

		return mav;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@RequestMapping("/saveFeatureProject")
	public ModelAndView saveFeatureProject(@RequestParam Integer feature_featureId, @ModelAttribute Project project) {
		Feature parent_feature = featureService.saveFeatureProject(feature_featureId, project);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("feature", parent_feature);
		mav.setViewName("feature/viewFeature.jsp");

		return mav;
	}

	/**
	 * Create a new Requirement entity
	 * 
	 */
	@RequestMapping("/newFeatureRequirements")
	public ModelAndView newFeatureRequirements(@RequestParam Integer feature_featureId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("requirement", new Requirement());
		mav.addObject("newFlag", true);
		mav.setViewName("feature/requirements/editRequirements.jsp");

		return mav;
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@RequestMapping("/saveFeature")
	public String saveFeature(@ModelAttribute Feature feature) {
		featureService.saveFeature(feature);
		return "forward:/indexFeature";
	}

	/**
	 * Edit an existing Changerequest entity
	 * 
	 */
	@RequestMapping("/editFeatureChangerequests")
	public ModelAndView editFeatureChangerequests(@RequestParam Integer feature_featureId, @RequestParam Integer changerequests_changeId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequests_changeId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("changerequest", changerequest);
		mav.setViewName("feature/changerequests/editChangerequests.jsp");

		return mav;
	}

	/**
	 * View an existing Account entity
	 * 
	 */
	@RequestMapping("/selectFeatureAccount")
	public ModelAndView selectFeatureAccount(@RequestParam Integer feature_featureId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("account", account);
		mav.setViewName("feature/account/viewAccount.jsp");

		return mav;
	}

	/**
	 * Edit an existing Account entity
	 * 
	 */
	@RequestMapping("/editFeatureAccount")
	public ModelAndView editFeatureAccount(@RequestParam Integer feature_featureId, @RequestParam Integer account_accountId) {
		Account account = accountDAO.findAccountByPrimaryKey(account_accountId, -1, -1);

		ModelAndView mav = new ModelAndView();
		mav.addObject("feature_featureId", feature_featureId);
		mav.addObject("account", account);
		mav.setViewName("feature/account/editAccount.jsp");

		return mav;
	}

	/**
	 * Select the child Account entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteFeatureAccount")
	public ModelAndView confirmDeleteFeatureAccount(@RequestParam Integer feature_featureId, @RequestParam Integer related_account_accountId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("account", accountDAO.findAccountByPrimaryKey(related_account_accountId));
		mav.addObject("feature_featureId", feature_featureId);
		mav.setViewName("feature/account/deleteAccount.jsp");

		return mav;
	}
}