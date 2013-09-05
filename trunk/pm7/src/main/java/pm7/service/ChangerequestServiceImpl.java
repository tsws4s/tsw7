//**********************************************************
// ChangerequestServiceImpl
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

/**
 * Spring service that handles CRUD requests for Changerequest entities
 * 
 */

@Service("ChangerequestService")
@Transactional
public class ChangerequestServiceImpl implements ChangerequestService {

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
	 * Instantiates a new ChangerequestServiceImpl.
	 *
	 */
	public ChangerequestServiceImpl() {
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestAttachments(Integer changeId, Attachment related_attachments) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		related_attachments.setChangerequest(changerequest);
		changerequest.getAttachments().add(related_attachments);
		related_attachments = attachmentDAO.store(related_attachments);
		attachmentDAO.flush();

		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		return changerequest;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestProject(Integer changeId, Project related_project) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		changerequest.setProject(related_project);
		related_project.getChangerequests().add(changerequest);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestAccount(Integer changerequest_changeId, Integer related_account_accountId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		changerequest.setAccount(null);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return changerequest;
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestFeature(Integer changeId, Feature related_feature) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		changerequest.setFeature(related_feature);
		related_feature.getChangerequests().add(changerequest);
		changerequest = changerequestDAO.store(changerequest);
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

		related_feature = featureDAO.store(related_feature);
		featureDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestFeature(Integer changerequest_changeId, Integer related_feature_featureId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);
		Feature related_feature = featureDAO.findFeatureByPrimaryKey(related_feature_featureId, -1, -1);

		changerequest.setFeature(null);
		related_feature.getChangerequests().remove(changerequest);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_feature = featureDAO.store(related_feature);
		featureDAO.flush();

		featureDAO.remove(related_feature);
		featureDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestAttachments(Integer changerequest_changeId, Integer related_attachments_attachId) {
		Attachment related_attachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId, -1, -1);

		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		related_attachments.setChangerequest(null);
		changerequest.getAttachments().remove(related_attachments);

		attachmentDAO.remove(related_attachments);
		attachmentDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestProject(Integer changerequest_changeId, Integer related_project_projectId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		changerequest.setProject(null);
		related_project.getChangerequests().remove(changerequest);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return changerequest;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestReleaseplan(Integer changeId, Releaseplan related_releaseplan) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		changerequest.setReleaseplan(related_releaseplan);
		related_releaseplan.getChangerequests().add(changerequest);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestDefects(Integer changerequest_changeId, Integer related_defects_defectId) {
		Defect related_defects = defectDAO.findDefectByPrimaryKey(related_defects_defectId, -1, -1);

		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		related_defects.setChangerequest(null);
		changerequest.getDefects().remove(related_defects);

		defectDAO.remove(related_defects);
		defectDAO.flush();

		return changerequest;
	}

	/**
	 * Load an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Set<Changerequest> loadChangerequests() {
		return changerequestDAO.findAllChangerequests();
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestTasks(Integer changeId, Task related_tasks) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		related_tasks.setChangerequest(changerequest);
		changerequest.getTasks().add(related_tasks);
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

		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		return changerequest;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestAccount(Integer changeId, Account related_account) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		changerequest.setAccount(related_account);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestTasks(Integer changerequest_changeId, Integer related_tasks_taskId) {
		Task related_tasks = taskDAO.findTaskByPrimaryKey(related_tasks_taskId, -1, -1);

		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		related_tasks.setChangerequest(null);
		changerequest.getTasks().remove(related_tasks);

		taskDAO.remove(related_tasks);
		taskDAO.flush();

		return changerequest;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequest(Changerequest changerequest) {
		Changerequest existingChangerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest.getChangeId());

		if (existingChangerequest != null) {
			if (existingChangerequest != changerequest) {
				existingChangerequest.setChangeId(changerequest.getChangeId());
				existingChangerequest.setStatus(changerequest.getStatus());
				existingChangerequest.setChangePriority(changerequest.getChangePriority());
				existingChangerequest.setChangeCode(changerequest.getChangeCode());
				existingChangerequest.setChangeName(changerequest.getChangeName());
				existingChangerequest.setChangeDescription(changerequest.getChangeDescription());
			}
			changerequest = changerequestDAO.store(existingChangerequest);
		} else {
			int changeId = changerequestDAO.getMaxChangeId();
			changerequest.setChangeId(changeId+1);
			changerequest.setChangeCode("ChangeReq-"+(changeId+1));
//			changerequest.setAccount(acct);
			changerequest = changerequestDAO.store(changerequest);
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
		changerequestDAO.flush();
		return changerequest;
		}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestRequirement(Integer changeId, Requirement related_requirement) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
		Requirement existingrequirement = requirementDAO.findRequirementByPrimaryKey(related_requirement.getReqmtId());

		// copy into the existing record to preserve existing relationships
		if (existingrequirement != null) {
			existingrequirement.setReqmtId(related_requirement.getReqmtId());
			existingrequirement.setStatus(related_requirement.getStatus());
			existingrequirement.setReqmtPriority(related_requirement.getReqmtPriority());
			existingrequirement.setReqmtCode(related_requirement.getReqmtCode());
			existingrequirement.setReqmtName(related_requirement.getReqmtName());
			existingrequirement.setReqmtStoryDescription(related_requirement.getReqmtStoryDescription());
			related_requirement = existingrequirement;
		} else {
			related_requirement = requirementDAO.store(related_requirement);
			requirementDAO.flush();
		}

		changerequest.setRequirement(related_requirement);
		related_requirement.getChangerequests().add(changerequest);
		changerequest = changerequestDAO.store(changerequest);
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

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestReleaseplan(Integer changerequest_changeId, Integer related_releaseplan_releaseId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);
		Releaseplan related_releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId, -1, -1);

		changerequest.setReleaseplan(null);
		related_releaseplan.getChangerequests().remove(changerequest);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		releaseplanDAO.remove(related_releaseplan);
		releaseplanDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestRequirement(Integer changerequest_changeId, Integer related_requirement_reqmtId) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);
		Requirement related_requirement = requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId, -1, -1);

		changerequest.setRequirement(null);
		related_requirement.getChangerequests().remove(changerequest);
		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		requirementDAO.remove(related_requirement);
		requirementDAO.flush();

		return changerequest;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestDefects(Integer changeId, Defect related_defects) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		related_defects.setChangerequest(changerequest);
		changerequest.getDefects().add(related_defects);
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

		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		return changerequest;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public void deleteChangerequest(Changerequest changerequest) {
		changerequestDAO.remove(changerequest);
		changerequestDAO.flush();
	}

	/**
	 * Return all Changerequest entity
	 * 
	 */
	@Transactional
	public List<Changerequest> findAllChangerequests(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Changerequest>(changerequestDAO.findAllChangerequests(startResult, maxRows));
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Changerequest deleteChangerequestTestcases(Integer changerequest_changeId, Integer related_testcases_testId) {
		Testcase related_testcases = testcaseDAO.findTestcaseByPrimaryKey(related_testcases_testId, -1, -1);

		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changerequest_changeId, -1, -1);

		related_testcases.setChangerequest(null);
		changerequest.getTestcases().remove(related_testcases);

		testcaseDAO.remove(related_testcases);
		testcaseDAO.flush();

		return changerequest;
	}

	/**
	 * Return a count of all Changerequest entity
	 * 
	 */
	@Transactional
	public Integer countChangerequests() {
		return ((Long) changerequestDAO.createQuerySingleResult("select count(o) from Changerequest o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Changerequest saveChangerequestTestcases(Integer changeId, Testcase related_testcases) {
		Changerequest changerequest = changerequestDAO.findChangerequestByPrimaryKey(changeId, -1, -1);
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

		related_testcases.setChangerequest(changerequest);
		changerequest.getTestcases().add(related_testcases);
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

		changerequest = changerequestDAO.store(changerequest);
		changerequestDAO.flush();

		return changerequest;
	}

	/**
	 */
	@Transactional
	public Changerequest findChangerequestByPrimaryKey(Integer changeId) {
		return changerequestDAO.findChangerequestByPrimaryKey(changeId);
	}
}
