//**********************************************************
// DefectServiceImpl
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

/**
 * Spring service that handles CRUD requests for Defect entities
 * 
 */

@Service("DefectService")
@Transactional
public class DefectServiceImpl implements DefectService {

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
	 * Instantiates a new DefectServiceImpl.
	 *
	 */
	public DefectServiceImpl() {
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public void deleteDefect(Defect defect) {
		defectDAO.remove(defect);
		defectDAO.flush();
	}

	/**
	 * Load an existing Defect entity
	 * 
	 */
	@Transactional
	public Set<Defect> loadDefects() {
		return defectDAO.findAllDefects();
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectStatusupdates(Integer defect_defectId, Integer related_statusupdates_statusId) {
		Statusupdate related_statusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId, -1, -1);

		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);

		related_statusupdates.setDefect(null);
		defect.getStatusupdates().remove(related_statusupdates);

		statusupdateDAO.remove(related_statusupdates);
		statusupdateDAO.flush();

		return defect;
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectReleaseplan(Integer defect_defectId, Integer related_releaseplan_releaseId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);
		Releaseplan related_releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId, -1, -1);

		defect.setReleaseplan(null);
		related_releaseplan.getDefects().remove(defect);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		releaseplanDAO.remove(related_releaseplan);
		releaseplanDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Defect saveDefect(Defect defect) {
		Defect existingDefect = defectDAO.findDefectByPrimaryKey(defect.getDefectId());

		if (existingDefect != null) {
			if (existingDefect != defect) {
				existingDefect.setDefectId(defect.getDefectId());
				existingDefect.setStatus(defect.getStatus());
				existingDefect.setDefectPriority(defect.getDefectPriority());
				existingDefect.setDefectName(defect.getDefectName());
				existingDefect.setDefectDescriptin(defect.getDefectDescriptin());
			}
			defect = defectDAO.store(existingDefect);
		} else {
			int defectId = defectDAO.getMaxDefectId();
			defect.setDefectId(defectId+1);
//			defect.setAccount(acct);
			defect = defectDAO.store(defect);
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
		defectDAO.flush();
		return defect;
		}

	/**
	 * Return a count of all Defect entity
	 * 
	 */
	@Transactional
	public Integer countDefects() {
		return ((Long) defectDAO.createQuerySingleResult("select count(o) from Defect o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Defect saveDefectReleaseplan(Integer defectId, Releaseplan related_releaseplan) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
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

		defect.setReleaseplan(related_releaseplan);
		related_releaseplan.getDefects().add(defect);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Defect saveDefectAttachments(Integer defectId, Attachment related_attachments) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
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

		related_attachments.setDefect(defect);
		defect.getAttachments().add(related_attachments);
		related_attachments = attachmentDAO.store(related_attachments);
		attachmentDAO.flush();

		defect = defectDAO.store(defect);
		defectDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Defect saveDefectChangerequest(Integer defectId, Changerequest related_changerequest) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
		Changerequest existingchangerequest = changerequestDAO.findChangerequestByPrimaryKey(related_changerequest.getChangeId());

		// copy into the existing record to preserve existing relationships
		if (existingchangerequest != null) {
			existingchangerequest.setChangeId(related_changerequest.getChangeId());
			existingchangerequest.setStatus(related_changerequest.getStatus());
			existingchangerequest.setChangePriority(related_changerequest.getChangePriority());
			existingchangerequest.setChangeCode(related_changerequest.getChangeCode());
			existingchangerequest.setChangeName(related_changerequest.getChangeName());
			existingchangerequest.setChangeDescription(related_changerequest.getChangeDescription());
			related_changerequest = existingchangerequest;
		} else {
			related_changerequest = changerequestDAO.store(related_changerequest);
			changerequestDAO.flush();
		}

		defect.setChangerequest(related_changerequest);
		related_changerequest.getDefects().add(defect);
		defect = defectDAO.store(defect);
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

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		return defect;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectTasks(Integer defect_defectId, Integer related_tasks_taskId) {
		Task related_tasks = taskDAO.findTaskByPrimaryKey(related_tasks_taskId, -1, -1);

		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);

		related_tasks.setDefect(null);
		defect.getTasks().remove(related_tasks);

		taskDAO.remove(related_tasks);
		taskDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Defect saveDefectAccount(Integer defectId, Account related_account) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
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

		defect.setAccount(related_account);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return defect;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectTestcase(Integer defect_defectId, Integer related_testcase_testId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);
		Testcase related_testcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId, -1, -1);

		defect.setTestcase(null);
		related_testcase.getDefects().remove(defect);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		testcaseDAO.remove(related_testcase);
		testcaseDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Defect saveDefectStatusupdates(Integer defectId, Statusupdate related_statusupdates) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
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

		related_statusupdates.setDefect(defect);
		defect.getStatusupdates().add(related_statusupdates);
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

		defect = defectDAO.store(defect);
		defectDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Defect saveDefectRequirement(Integer defectId, Requirement related_requirement) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
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

		defect.setRequirement(related_requirement);
		related_requirement.getDefects().add(defect);
		defect = defectDAO.store(defect);
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

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		return defect;
	}

	/**
	 * Return all Defect entity
	 * 
	 */
	@Transactional
	public List<Defect> findAllDefects(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Defect>(defectDAO.findAllDefects(startResult, maxRows));
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectAccount(Integer defect_defectId, Integer related_account_accountId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		defect.setAccount(null);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return defect;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectRequirement(Integer defect_defectId, Integer related_requirement_reqmtId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);
		Requirement related_requirement = requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId, -1, -1);

		defect.setRequirement(null);
		related_requirement.getDefects().remove(defect);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		requirementDAO.remove(related_requirement);
		requirementDAO.flush();

		return defect;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectChangerequest(Integer defect_defectId, Integer related_changerequest_changeId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);
		Changerequest related_changerequest = changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId, -1, -1);

		defect.setChangerequest(null);
		related_changerequest.getDefects().remove(defect);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		changerequestDAO.remove(related_changerequest);
		changerequestDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Defect saveDefectProject(Integer defectId, Project related_project) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
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

		defect.setProject(related_project);
		related_project.getDefects().add(defect);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return defect;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectAttachments(Integer defect_defectId, Integer related_attachments_attachId) {
		Attachment related_attachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId, -1, -1);

		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);

		related_attachments.setDefect(null);
		defect.getAttachments().remove(related_attachments);

		attachmentDAO.remove(related_attachments);
		attachmentDAO.flush();

		return defect;
	}

	/**
	 */
	@Transactional
	public Defect findDefectByPrimaryKey(Integer defectId) {
		return defectDAO.findDefectByPrimaryKey(defectId);
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Defect deleteDefectProject(Integer defect_defectId, Integer related_project_projectId) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defect_defectId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		defect.setProject(null);
		related_project.getDefects().remove(defect);
		defect = defectDAO.store(defect);
		defectDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Defect saveDefectTasks(Integer defectId, Task related_tasks) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
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

		related_tasks.setDefect(defect);
		defect.getTasks().add(related_tasks);
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

		defect = defectDAO.store(defect);
		defectDAO.flush();

		return defect;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Defect saveDefectTestcase(Integer defectId, Testcase related_testcase) {
		Defect defect = defectDAO.findDefectByPrimaryKey(defectId, -1, -1);
		Testcase existingtestcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase.getTestId());

		// copy into the existing record to preserve existing relationships
		if (existingtestcase != null) {
			existingtestcase.setTestId(related_testcase.getTestId());
			existingtestcase.setPassFail(related_testcase.getPassFail());
			existingtestcase.setTestCaseCode(related_testcase.getTestCaseCode());
			existingtestcase.setTestName(related_testcase.getTestName());
			existingtestcase.setTestDescription(related_testcase.getTestDescription());
			existingtestcase.setTestSetup(related_testcase.getTestSetup());
			related_testcase = existingtestcase;
		} else {
			related_testcase = testcaseDAO.store(related_testcase);
			testcaseDAO.flush();
		}

		defect.setTestcase(related_testcase);
		related_testcase.getDefects().add(defect);
		defect = defectDAO.store(defect);
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

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		return defect;
	}
}
