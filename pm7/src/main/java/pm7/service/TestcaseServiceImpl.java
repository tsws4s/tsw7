//**********************************************************
// TestcaseServiceImpl
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
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TestcasestepDAO;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Project;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;
import pm7.domain.Testcasestep;

/**
 * Spring service that handles CRUD requests for Testcase entities
 * 
 */

@Service("TestcaseService")
@Transactional
public class TestcaseServiceImpl implements TestcaseService {

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
	 * DAO injected by Spring that manages Testcasestep entities
	 * 
	 */
	@Autowired
	private TestcasestepDAO testcasestepDAO;

	/**
	 * Instantiates a new TestcaseServiceImpl.
	 *
	 */
	public TestcaseServiceImpl() {
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseRequirement(Integer testId, Requirement related_requirement) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		testcase.setRequirement(related_requirement);
		related_requirement.getTestcases().add(testcase);
		testcase = testcaseDAO.store(testcase);
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

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		return testcase;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseStatusupdates(Integer testcase_testId, Integer related_statusupdates_statusId) {
		Statusupdate related_statusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId, -1, -1);

		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		related_statusupdates.setTestcase(null);
		testcase.getStatusupdates().remove(related_statusupdates);

		statusupdateDAO.remove(related_statusupdates);
		statusupdateDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseChangerequest(Integer testId, Changerequest related_changerequest) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		testcase.setChangerequest(related_changerequest);
		related_changerequest.getTestcases().add(testcase);
		testcase = testcaseDAO.store(testcase);
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

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		return testcase;
	}

	/**
	 * Return all Testcase entity
	 * 
	 */
	@Transactional
	public List<Testcase> findAllTestcases(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Testcase>(testcaseDAO.findAllTestcases(startResult, maxRows));
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseProject(Integer testcase_testId, Integer related_project_projectId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		testcase.setProject(null);
		related_project.getTestcases().remove(testcase);
		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseAttachments(Integer testId, Attachment related_attachments) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		related_attachments.setTestcase(testcase);
		testcase.getAttachments().add(related_attachments);
		related_attachments = attachmentDAO.store(related_attachments);
		attachmentDAO.flush();

		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcase(Testcase testcase) {
		Testcase existingTestcase = testcaseDAO.findTestcaseByPrimaryKey(testcase.getTestId());

		if (existingTestcase != null) {
			if (existingTestcase != testcase) {
				existingTestcase.setTestId(testcase.getTestId());
				existingTestcase.setPassFail(testcase.getPassFail());
				existingTestcase.setTestCaseCode(testcase.getTestCaseCode());
				existingTestcase.setTestName(testcase.getTestName());
				existingTestcase.setTestDescription(testcase.getTestDescription());
				existingTestcase.setTestSetup(testcase.getTestSetup());
			}
			testcase = testcaseDAO.store(existingTestcase);
		} else {
			int testcaseId = testcaseDAO.getMaxTestcaseId();
			testcase.setTestId(testcaseId+1);
			testcase.setTestCaseCode("Test-"+(testcaseId+1));
//			person.setAccount(acct);
			testcase = testcaseDAO.store(testcase);
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
		testcaseDAO.flush();
		return testcase;
		}

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseTestcasesteps(Integer testcase_testId, Integer related_testcasesteps_testStepId) {
		Testcasestep related_testcasesteps = testcasestepDAO.findTestcasestepByPrimaryKey(related_testcasesteps_testStepId, -1, -1);

		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		related_testcasesteps.setTestcase(null);
		testcase.getTestcasesteps().remove(related_testcasesteps);

		testcasestepDAO.remove(related_testcasesteps);
		testcasestepDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseStatusupdates(Integer testId, Statusupdate related_statusupdates) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		related_statusupdates.setTestcase(testcase);
		testcase.getStatusupdates().add(related_statusupdates);
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

		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		return testcase;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseAccount(Integer testcase_testId, Integer related_account_accountId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		testcase.setAccount(null);
		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return testcase;
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseAttachments(Integer testcase_testId, Integer related_attachments_attachId) {
		Attachment related_attachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId, -1, -1);

		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		related_attachments.setTestcase(null);
		testcase.getAttachments().remove(related_attachments);

		attachmentDAO.remove(related_attachments);
		attachmentDAO.flush();

		return testcase;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseChangerequest(Integer testcase_testId, Integer related_changerequest_changeId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);
		Changerequest related_changerequest = changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId, -1, -1);

		testcase.setChangerequest(null);
		related_changerequest.getTestcases().remove(testcase);
		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		changerequestDAO.remove(related_changerequest);
		changerequestDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseProject(Integer testId, Project related_project) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		testcase.setProject(related_project);
		related_project.getTestcases().add(testcase);
		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return testcase;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseRequirement(Integer testcase_testId, Integer related_requirement_reqmtId) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);
		Requirement related_requirement = requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId, -1, -1);

		testcase.setRequirement(null);
		related_requirement.getTestcases().remove(testcase);
		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		requirementDAO.remove(related_requirement);
		requirementDAO.flush();

		return testcase;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public void deleteTestcase(Testcase testcase) {
		testcaseDAO.remove(testcase);
		testcaseDAO.flush();
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseDefects(Integer testId, Defect related_defects) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		related_defects.setTestcase(testcase);
		testcase.getDefects().add(related_defects);
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

		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		return testcase;
	}

	/**
	 */
	@Transactional
	public Testcase findTestcaseByPrimaryKey(Integer testId) {
		return testcaseDAO.findTestcaseByPrimaryKey(testId);
	}

	/**
	 * Load an existing Testcase entity
	 * 
	 */
	@Transactional
	public Set<Testcase> loadTestcases() {
		return testcaseDAO.findAllTestcases();
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseTasks(Integer testcase_testId, Integer related_tasks_taskId) {
		Task related_tasks = taskDAO.findTaskByPrimaryKey(related_tasks_taskId, -1, -1);

		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		related_tasks.setTestcase(null);
		testcase.getTasks().remove(related_tasks);

		taskDAO.remove(related_tasks);
		taskDAO.flush();

		return testcase;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Testcase deleteTestcaseDefects(Integer testcase_testId, Integer related_defects_defectId) {
		Defect related_defects = defectDAO.findDefectByPrimaryKey(related_defects_defectId, -1, -1);

		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testcase_testId, -1, -1);

		related_defects.setTestcase(null);
		testcase.getDefects().remove(related_defects);

		defectDAO.remove(related_defects);
		defectDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Testcasestep entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseTestcasesteps(Integer testId, Testcasestep related_testcasesteps) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
		Testcasestep existingtestcasesteps = testcasestepDAO.findTestcasestepByPrimaryKey(related_testcasesteps.getTestStepId());

		// copy into the existing record to preserve existing relationships
		if (existingtestcasesteps != null) {
			existingtestcasesteps.setTestStepId(related_testcasesteps.getTestStepId());
			existingtestcasesteps.setPassFail(related_testcasesteps.getPassFail());
			existingtestcasesteps.setTestCaseStepField(related_testcasesteps.getTestCaseStepField());
			existingtestcasesteps.setStepDescription(related_testcasesteps.getStepDescription());
			existingtestcasesteps.setExpectedResult(related_testcasesteps.getExpectedResult());
			existingtestcasesteps.setActualResult(related_testcasesteps.getActualResult());
			related_testcasesteps = existingtestcasesteps;
		} else {
			int testcasestepId = testcasestepDAO.getMaxTestcasestepId();
			related_testcasesteps.setTestStepId(testcasestepId+1);
			related_testcasesteps = testcasestepDAO.store(related_testcasesteps);
			testcasestepDAO.flush();
		}

		related_testcasesteps.setTestcase(testcase);
		testcase.getTestcasesteps().add(related_testcasesteps);
		related_testcasesteps = testcasestepDAO.store(related_testcasesteps);
		testcasestepDAO.flush();
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

		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseTasks(Integer testId, Task related_tasks) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		related_tasks.setTestcase(testcase);
		testcase.getTasks().add(related_tasks);
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

		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		return testcase;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Testcase saveTestcaseAccount(Integer testId, Account related_account) {
		Testcase testcase = testcaseDAO.findTestcaseByPrimaryKey(testId, -1, -1);
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

		testcase.setAccount(related_account);
		testcase = testcaseDAO.store(testcase);
		testcaseDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return testcase;
	}

	/**
	 * Return a count of all Testcase entity
	 * 
	 */
	@Transactional
	public Integer countTestcases() {
		return ((Long) testcaseDAO.createQuerySingleResult("select count(o) from Testcase o").getSingleResult()).intValue();
	}
}
