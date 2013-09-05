//**********************************************************
// RequirementServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 06/22/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package pm7.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

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

/**
 * Spring service that handles CRUD requests for Requirement entities
 * 
 */

@Service("RequirementService")
@Transactional
public class RequirementServiceImpl implements RequirementService {

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
	 * Instantiates a new RequirementServiceImpl.
	 *
	 */
	public RequirementServiceImpl() {
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementTasks(Integer reqmtId, Task related_tasks) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Task existingtasks = taskDAO.findTaskByPrimaryKey(related_tasks.getTaskId());

		// copy into the existing record to preserve existing relationships
		if (existingtasks != null) {
			existingtasks.setTaskId(related_tasks.getTaskId());
			existingtasks.setStatus(related_tasks.getStatus());
			existingtasks.setTaskName(related_tasks.getTaskName());
			existingtasks.setTaskDescription(related_tasks.getTaskDescription());
			existingtasks.setStartDate(related_tasks.getStartDate());
			existingtasks.setTargetDate(related_tasks.getTargetDate());
			existingtasks.setCompleteDate(related_tasks.getCompleteDate());
			existingtasks.setPercentComplete(related_tasks.getPercentComplete());
			existingtasks.setEstimateHrs(related_tasks.getEstimateHrs());
			existingtasks.setActualHrs(related_tasks.getActualHrs());
			existingtasks.setTaskType(related_tasks.getTaskType());
			related_tasks = existingtasks;
		} else {
			related_tasks = taskDAO.store(related_tasks);
			taskDAO.flush();
		}

		related_tasks.setRequirement(requirement);
		requirement.getTasks().add(related_tasks);
		related_tasks = taskDAO.store(related_tasks);
		taskDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementProject(Integer reqmtId, Project related_project) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Project existingproject = projectDAO.findProjectByPrimaryKey(related_project.getProjectId());

		// copy into the existing record to preserve existing relationships
		if (existingproject != null) {
			existingproject.setProjectId(related_project.getProjectId());
			existingproject.setProjectName(related_project.getProjectName());
			existingproject.setProjectDesc(related_project.getProjectDesc());
			existingproject.setProjectType(related_project.getProjectType());
			existingproject.setStartDate(related_project.getStartDate());
			existingproject.setDueDate(related_project.getDueDate());
			existingproject.setCompleteDate(related_project.getCompleteDate());
			existingproject.setEstimateHrs(related_project.getEstimateHrs());
			existingproject.setActualHrs(related_project.getActualHrs());
			existingproject.setHrRate(related_project.getHrRate());
			existingproject.setActiveYn(related_project.getActiveYn());
			related_project = existingproject;
		} else {
			related_project = projectDAO.store(related_project);
			projectDAO.flush();
		}

		requirement.setProject(related_project);
		related_project.getRequirements().add(requirement);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementChangerequests(Integer requirement_reqmtId, Integer related_changerequests_changeId) {
		Changerequest related_changerequests = changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId, -1, -1);

		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		related_changerequests.setRequirement(null);
		requirement.getChangerequests().remove(related_changerequests);

		changerequestDAO.remove(related_changerequests);
		changerequestDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementTestcases(Integer requirement_reqmtId, Integer related_testcases_testId) {
		Testcase related_testcases = testcaseDAO.findTestcaseByPrimaryKey(related_testcases_testId, -1, -1);

		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		related_testcases.setRequirement(null);
		requirement.getTestcases().remove(related_testcases);

		testcaseDAO.remove(related_testcases);
		testcaseDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementChangerequests(Integer reqmtId, Changerequest related_changerequests) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Changerequest existingchangerequests = changerequestDAO.findChangerequestByPrimaryKey(related_changerequests.getChangeId());

		// copy into the existing record to preserve existing relationships
		if (existingchangerequests != null) {
			existingchangerequests.setChangeId(related_changerequests.getChangeId());
			existingchangerequests.setStatus(related_changerequests.getStatus());
			existingchangerequests.setChangePriority(related_changerequests.getChangePriority());
			existingchangerequests.setChangeCode(related_changerequests.getChangeCode());
			existingchangerequests.setChangeName(related_changerequests.getChangeName());
			existingchangerequests.setChangeDescription(related_changerequests.getChangeDescription());
			related_changerequests = existingchangerequests;
		} else {
			related_changerequests = changerequestDAO.store(related_changerequests);
			changerequestDAO.flush();
		}

		related_changerequests.setRequirement(requirement);
		requirement.getChangerequests().add(related_changerequests);
		related_changerequests = changerequestDAO.store(related_changerequests);
		changerequestDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementDefects(Integer requirement_reqmtId, Integer related_defects_defectId) {
		Defect related_defects = defectDAO.findDefectByPrimaryKey(related_defects_defectId, -1, -1);

		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		related_defects.setRequirement(null);
		requirement.getDefects().remove(related_defects);

		defectDAO.remove(related_defects);
		defectDAO.flush();

		return requirement;
	}

	/**
	 * Return a count of all Requirement entity
	 * 
	 */
	@Transactional
	public Integer countRequirements() {
		return ((Long) requirementDAO.createQuerySingleResult("select count(o) from Requirement o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementDefects(Integer reqmtId, Defect related_defects) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Defect existingdefects = defectDAO.findDefectByPrimaryKey(related_defects.getDefectId());

		// copy into the existing record to preserve existing relationships
		if (existingdefects != null) {
			existingdefects.setDefectId(related_defects.getDefectId());
			existingdefects.setStatus(related_defects.getStatus());
			existingdefects.setDefectPriority(related_defects.getDefectPriority());
			existingdefects.setDefectName(related_defects.getDefectName());
			existingdefects.setDefectDescriptin(related_defects.getDefectDescriptin());
			related_defects = existingdefects;
		} else {
			related_defects = defectDAO.store(related_defects);
			defectDAO.flush();
		}

		related_defects.setRequirement(requirement);
		requirement.getDefects().add(related_defects);
		related_defects = defectDAO.store(related_defects);
		defectDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementTestcases(Integer reqmtId, Testcase related_testcases) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Testcase existingtestcases = testcaseDAO.findTestcaseByPrimaryKey(related_testcases.getTestId());

		// copy into the existing record to preserve existing relationships
		if (existingtestcases != null) {
			existingtestcases.setTestId(related_testcases.getTestId());
			existingtestcases.setPassFail(related_testcases.getPassFail());
			existingtestcases.setTestCaseCode(related_testcases.getTestCaseCode());
			existingtestcases.setTestName(related_testcases.getTestName());
			existingtestcases.setTestDescription(related_testcases.getTestDescription());
			existingtestcases.setTestSetup(related_testcases.getTestSetup());
			related_testcases = existingtestcases;
		} else {
			related_testcases = testcaseDAO.store(related_testcases);
			testcaseDAO.flush();
		}

		related_testcases.setRequirement(requirement);
		requirement.getTestcases().add(related_testcases);
		related_testcases = testcaseDAO.store(related_testcases);
		testcaseDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementProject(Integer requirement_reqmtId, Integer related_project_projectId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		requirement.setProject(null);
		related_project.getRequirements().remove(requirement);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementStatusupdates(Integer requirement_reqmtId, Integer related_statusupdates_statusId) {
		Statusupdate related_statusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId, -1, -1);

		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		related_statusupdates.setRequirement(null);
		requirement.getStatusupdates().remove(related_statusupdates);

		statusupdateDAO.remove(related_statusupdates);
		statusupdateDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementAttachments(Integer requirement_reqmtId, Integer related_attachments_attachId) {
		Attachment related_attachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId, -1, -1);

		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		related_attachments.setRequirement(null);
		requirement.getAttachments().remove(related_attachments);

		attachmentDAO.remove(related_attachments);
		attachmentDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementStatusupdates(Integer reqmtId, Statusupdate related_statusupdates) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Statusupdate existingstatusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates.getStatusId());

		// copy into the existing record to preserve existing relationships
		if (existingstatusupdates != null) {
			existingstatusupdates.setStatusId(related_statusupdates.getStatusId());
			existingstatusupdates.setStatusDate(related_statusupdates.getStatusDate());
			existingstatusupdates.setStatusUpdateDesc(related_statusupdates.getStatusUpdateDesc());
			existingstatusupdates.setEstHrsLeft(related_statusupdates.getEstHrsLeft());
			existingstatusupdates.setRiskGyr(related_statusupdates.getRiskGyr());
			related_statusupdates = existingstatusupdates;
		} else {
			int statusupdateId = statusupdateDAO.getMaxStatusupdateId();
			related_statusupdates.setStatusId(statusupdateId+1);
			related_statusupdates = statusupdateDAO.store(related_statusupdates);
			statusupdateDAO.flush();
		}

		related_statusupdates.setRequirement(requirement);
		requirement.getStatusupdates().add(related_statusupdates);
		related_statusupdates = statusupdateDAO.store(related_statusupdates);
		statusupdateDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementTasks(Integer requirement_reqmtId, Integer related_tasks_taskId) {
		Task related_tasks = taskDAO.findTaskByPrimaryKey(related_tasks_taskId, -1, -1);

		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);

		related_tasks.setRequirement(null);
		requirement.getTasks().remove(related_tasks);

		taskDAO.remove(related_tasks);
		taskDAO.flush();

		return requirement;
	}

	/**
	 * Load an existing Requirement entity
	 * 
	 */
	@Transactional
	public Set<Requirement> loadRequirements() {
		return requirementDAO.findAllRequirements();
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementFeature(Integer requirement_reqmtId, Integer related_feature_featureId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);
		Feature related_feature = featureDAO.findFeatureByPrimaryKey(related_feature_featureId, -1, -1);

		requirement.setFeature(null);
		related_feature.getRequirements().remove(requirement);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		related_feature = featureDAO.store(related_feature);
		featureDAO.flush();

		featureDAO.remove(related_feature);
		featureDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementAccount(Integer requirement_reqmtId, Integer related_account_accountId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		requirement.setAccount(null);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementFeature(Integer reqmtId, Feature related_feature) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Feature existingfeature = featureDAO.findFeatureByPrimaryKey(related_feature.getFeatureId());

		// copy into the existing record to preserve existing relationships
		if (existingfeature != null) {
			existingfeature.setFeatureId(related_feature.getFeatureId());
			existingfeature.setFeatureCode(related_feature.getFeatureCode());
			existingfeature.setFeatureName(related_feature.getFeatureName());
			existingfeature.setFeaturePriority(related_feature.getFeaturePriority());
			related_feature = existingfeature;
		} else {
			related_feature = featureDAO.store(related_feature);
			featureDAO.flush();
		}

		requirement.setFeature(related_feature);
		related_feature.getRequirements().add(requirement);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		related_feature = featureDAO.store(related_feature);
		featureDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirement(Requirement requirement) {
		Requirement existingRequirement = requirementDAO.findRequirementByPrimaryKey(requirement.getReqmtId());

		if (existingRequirement != null) {
			if (existingRequirement != requirement) {
				existingRequirement.setReqmtId(requirement.getReqmtId());
				existingRequirement.setStatus(requirement.getStatus());
				existingRequirement.setReqmtPriority(requirement.getReqmtPriority());
				existingRequirement.setReqmtCode(requirement.getReqmtCode());
				existingRequirement.setReqmtName(requirement.getReqmtName());
				existingRequirement.setReqmtStoryDescription(requirement.getReqmtStoryDescription());
			}
			requirement = requirementDAO.store(existingRequirement);
		} else {
			int requirementId = requirementDAO.getMaxRequirementId();
			requirement.setReqmtId(requirementId+1);
			requirement.setReqmtCode("Reqmt-"+(requirementId+1));
//			person.setAccount(acct);
			requirement = requirementDAO.store(requirement);
		}
//		if(attachmentId!=null && attachmentId>0){
//			attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//		}		
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/
		requirementDAO.flush();
		return requirement;
		}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Requirement deleteRequirementReleaseplan(Integer requirement_reqmtId, Integer related_releaseplan_releaseId) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(requirement_reqmtId, -1, -1);
		Releaseplan related_releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId, -1, -1);

		requirement.setReleaseplan(null);
		related_releaseplan.getRequirements().remove(requirement);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		releaseplanDAO.remove(related_releaseplan);
		releaseplanDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementAccount(Integer reqmtId, Account related_account) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Account existingaccount = accountDAO.findAccountByPrimaryKey(related_account.getAccountId());

		// copy into the existing record to preserve existing relationships
		if (existingaccount != null) {
			existingaccount.setAccountId(related_account.getAccountId());
			existingaccount.setAccountName(related_account.getAccountName());
			existingaccount.setExpireDate(related_account.getExpireDate());
			related_account = existingaccount;
		} else {
			related_account = accountDAO.store(related_account);
			accountDAO.flush();
		}

		requirement.setAccount(related_account);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return requirement;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public void deleteRequirement(Requirement requirement) {
		requirementDAO.remove(requirement);
		requirementDAO.flush();
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementAttachments(Integer reqmtId, Attachment related_attachments) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Attachment existingattachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments.getAttachId());

		// copy into the existing record to preserve existing relationships
		if (existingattachments != null) {
			existingattachments.setAttachId(related_attachments.getAttachId());
			existingattachments.setAttachmentType(related_attachments.getAttachmentType());
			existingattachments.setAttachmentUrl(related_attachments.getAttachmentUrl());
			related_attachments = existingattachments;
		} else {
			int attachmentId = attachmentDAO.getMaxAttachmentId();
			related_attachments.setAttachId(attachmentId+1);
			related_attachments = attachmentDAO.store(related_attachments);
			attachmentDAO.flush();
		}

		related_attachments.setRequirement(requirement);
		requirement.getAttachments().add(related_attachments);
		related_attachments = attachmentDAO.store(related_attachments);
		attachmentDAO.flush();

		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		return requirement;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Requirement saveRequirementReleaseplan(Integer reqmtId, Releaseplan related_releaseplan) {
		Requirement requirement = requirementDAO.findRequirementByPrimaryKey(reqmtId, -1, -1);
		Releaseplan existingreleaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan.getReleaseId());

		// copy into the existing record to preserve existing relationships
		if (existingreleaseplan != null) {
			existingreleaseplan.setReleaseId(related_releaseplan.getReleaseId());
			existingreleaseplan.setReleaseCode(related_releaseplan.getReleaseCode());
			existingreleaseplan.setReleaseName(related_releaseplan.getReleaseName());
			existingreleaseplan.setReleaseDescription(related_releaseplan.getReleaseDescription());
			existingreleaseplan.setReleaseDate(related_releaseplan.getReleaseDate());
			related_releaseplan = existingreleaseplan;
		} else {
			related_releaseplan = releaseplanDAO.store(related_releaseplan);
			releaseplanDAO.flush();
		}

		requirement.setReleaseplan(related_releaseplan);
		related_releaseplan.getRequirements().add(requirement);
		requirement = requirementDAO.store(requirement);
		requirementDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		return requirement;
	}

	/**
	 * Return all Requirement entity
	 * 
	 */
	@Transactional
	public List<Requirement> findAllRequirements(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Requirement>(requirementDAO.findAllRequirements(startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public Requirement findRequirementByPrimaryKey(Integer reqmtId) {
		return requirementDAO.findRequirementByPrimaryKey(reqmtId);
	}
}
