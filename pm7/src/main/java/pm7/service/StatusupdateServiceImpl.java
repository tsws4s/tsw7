//**********************************************************
// StatusupdateServiceImpl
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

/**
 * Spring service that handles CRUD requests for Statusupdate entities
 * 
 */

@Service("StatusupdateService")
@Transactional
public class StatusupdateServiceImpl implements StatusupdateService {

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
	 * Instantiates a new StatusupdateServiceImpl.
	 *
	 */
	public StatusupdateServiceImpl() {
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateTask(Integer statusId, Task related_task) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
		Task existingtask = taskDAO.findTaskByPrimaryKey(related_task.getTaskId());

		// copy into the existing record to preserve existing relationships
		if (existingtask != null) {
			existingtask.setTaskId(related_task.getTaskId());
			existingtask.setStatus(related_task.getStatus());
			existingtask.setTaskName(related_task.getTaskName());
			existingtask.setTaskDescription(related_task.getTaskDescription());
			existingtask.setStartDate(related_task.getStartDate());
			existingtask.setTargetDate(related_task.getTargetDate());
			existingtask.setCompleteDate(related_task.getCompleteDate());
			existingtask.setPercentComplete(related_task.getPercentComplete());
			existingtask.setEstimateHrs(related_task.getEstimateHrs());
			existingtask.setActualHrs(related_task.getActualHrs());
			existingtask.setTaskType(related_task.getTaskType());
			related_task = existingtask;
		} else {
			related_task = taskDAO.store(related_task);
			taskDAO.flush();
		}

		statusupdate.setTask(related_task);
		related_task.getStatusupdates().add(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_task = taskDAO.store(related_task);
		taskDAO.flush();

		return statusupdate;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateTask(Integer statusupdate_statusId, Integer related_task_taskId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Task related_task = taskDAO.findTaskByPrimaryKey(related_task_taskId, -1, -1);

		statusupdate.setTask(null);
		related_task.getStatusupdates().remove(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_task = taskDAO.store(related_task);
		taskDAO.flush();

		taskDAO.remove(related_task);
		taskDAO.flush();

		return statusupdate;
	}

	/**
	 * Return a count of all Statusupdate entity
	 * 
	 */
	@Transactional
	public Integer countStatusupdates() {
		return ((Long) statusupdateDAO.createQuerySingleResult("select count(o) from Statusupdate o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateProject(Integer statusId, Project related_project) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
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

		statusupdate.setProject(related_project);
		related_project.getStatusupdates().add(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return statusupdate;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdatePerson(Integer statusupdate_statusId, Integer related_person_personId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Person related_person = personDAO.findPersonByPrimaryKey(related_person_personId, -1, -1);

		statusupdate.setPerson(null);
		related_person.getStatusupdates().remove(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		personDAO.remove(related_person);
		personDAO.flush();

		return statusupdate;
	}

	/**
	 */
	@Transactional
	public Statusupdate findStatusupdateByPrimaryKey(Integer statusId) {
		return statusupdateDAO.findStatusupdateByPrimaryKey(statusId);
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateProject(Integer statusupdate_statusId, Integer related_project_projectId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		statusupdate.setProject(null);
		related_project.getStatusupdates().remove(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return statusupdate;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateReleaseplan(Integer statusId, Releaseplan related_releaseplan) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
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

		statusupdate.setReleaseplan(related_releaseplan);
		related_releaseplan.getStatusupdates().add(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		return statusupdate;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateRequirement(Integer statusId, Requirement related_requirement) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
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

		statusupdate.setRequirement(related_requirement);
		related_requirement.getStatusupdates().add(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		return statusupdate;
	}

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateAttachments(Integer statusId, Attachment related_attachments) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
		Attachment existingattachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments.getAttachId());

		// copy into the existing record to preserve existing relationships
		if (existingattachments != null) {
			existingattachments.setAttachId(related_attachments.getAttachId());
			existingattachments.setAttachmentType(related_attachments.getAttachmentType());
			existingattachments.setAttachmentUrl(related_attachments.getAttachmentUrl());
			related_attachments = existingattachments;
		} else {
			related_attachments = attachmentDAO.store(related_attachments);
			attachmentDAO.flush();
		}

		related_attachments.setStatusupdate(statusupdate);
		statusupdate.getAttachments().add(related_attachments);
		related_attachments = attachmentDAO.store(related_attachments);
		attachmentDAO.flush();

		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		return statusupdate;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateAccount(Integer statusId, Account related_account) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
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

		statusupdate.setAccount(related_account);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return statusupdate;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateTestcase(Integer statusupdate_statusId, Integer related_testcase_testId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Testcase related_testcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId, -1, -1);

		statusupdate.setTestcase(null);
		related_testcase.getStatusupdates().remove(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		testcaseDAO.remove(related_testcase);
		testcaseDAO.flush();

		return statusupdate;
	}

	/**
	 * Return all Statusupdate entity
	 * 
	 */
	@Transactional
	public List<Statusupdate> findAllStatusupdates(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Statusupdate>(statusupdateDAO.findAllStatusupdates(startResult, maxRows));
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdatePerson(Integer statusId, Person related_person) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
		Person existingperson = personDAO.findPersonByPrimaryKey(related_person.getPersonId());

		// copy into the existing record to preserve existing relationships
		if (existingperson != null) {
			existingperson.setPersonId(related_person.getPersonId());
			existingperson.setFirstname(related_person.getFirstname());
			existingperson.setLastname(related_person.getLastname());
			existingperson.setPhone(related_person.getPhone());
			existingperson.setEmail(related_person.getEmail());
			existingperson.setDefaultProjectRole(related_person.getDefaultProjectRole());
			existingperson.setAddress(related_person.getAddress());
			existingperson.setCity(related_person.getCity());
			existingperson.setState(related_person.getState());
			existingperson.setZip(related_person.getZip());
			existingperson.setActiveYn(related_person.getActiveYn());
			related_person = existingperson;
		} else {
			related_person = personDAO.store(related_person);
			personDAO.flush();
		}

		statusupdate.setPerson(related_person);
		related_person.getStatusupdates().add(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		return statusupdate;
	}

	/**
	 * Load an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Set<Statusupdate> loadStatusupdates() {
		return statusupdateDAO.findAllStatusupdates();
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateDefect(Integer statusupdate_statusId, Integer related_defect_defectId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Defect related_defect = defectDAO.findDefectByPrimaryKey(related_defect_defectId, -1, -1);

		statusupdate.setDefect(null);
		related_defect.getStatusupdates().remove(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_defect = defectDAO.store(related_defect);
		defectDAO.flush();

		defectDAO.remove(related_defect);
		defectDAO.flush();

		return statusupdate;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateTestcase(Integer statusId, Testcase related_testcase) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
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

		statusupdate.setTestcase(related_testcase);
		related_testcase.getStatusupdates().add(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		return statusupdate;
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public void deleteStatusupdate(Statusupdate statusupdate) {
		statusupdateDAO.remove(statusupdate);
		statusupdateDAO.flush();
	}

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateAttachments(Integer statusupdate_statusId, Integer related_attachments_attachId) {
		Attachment related_attachments = attachmentDAO.findAttachmentByPrimaryKey(related_attachments_attachId, -1, -1);

		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);

		related_attachments.setStatusupdate(null);
		statusupdate.getAttachments().remove(related_attachments);

		attachmentDAO.remove(related_attachments);
		attachmentDAO.flush();

		return statusupdate;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateRequirement(Integer statusupdate_statusId, Integer related_requirement_reqmtId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Requirement related_requirement = requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId, -1, -1);

		statusupdate.setRequirement(null);
		related_requirement.getStatusupdates().remove(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		requirementDAO.remove(related_requirement);
		requirementDAO.flush();

		return statusupdate;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdateDefect(Integer statusId, Defect related_defect) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusId, -1, -1);
		Defect existingdefect = defectDAO.findDefectByPrimaryKey(related_defect.getDefectId());

		// copy into the existing record to preserve existing relationships
		if (existingdefect != null) {
			existingdefect.setDefectId(related_defect.getDefectId());
			existingdefect.setStatus(related_defect.getStatus());
			existingdefect.setDefectPriority(related_defect.getDefectPriority());
			existingdefect.setDefectName(related_defect.getDefectName());
			existingdefect.setDefectDescriptin(related_defect.getDefectDescriptin());
			related_defect = existingdefect;
		} else {
			related_defect = defectDAO.store(related_defect);
			defectDAO.flush();
		}

		statusupdate.setDefect(related_defect);
		related_defect.getStatusupdates().add(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_defect = defectDAO.store(related_defect);
		defectDAO.flush();

		return statusupdate;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Statusupdate saveStatusupdate(Statusupdate statusupdate) {
		Statusupdate existingStatusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate.getStatusId());

		if (existingStatusupdate != null) {
			if (existingStatusupdate != statusupdate) {
				existingStatusupdate.setStatusId(statusupdate.getStatusId());
				existingStatusupdate.setStatusDate(statusupdate.getStatusDate());
				existingStatusupdate.setStatusUpdateDesc(statusupdate.getStatusUpdateDesc());
				existingStatusupdate.setEstHrsLeft(statusupdate.getEstHrsLeft());
				existingStatusupdate.setRiskGyr(statusupdate.getRiskGyr());
			}
			statusupdate = statusupdateDAO.store(existingStatusupdate);
		} else {
			int statusupdateId = statusupdateDAO.getMaxStatusupdateId();
			statusupdate.setStatusId(statusupdateId+1);
//			person.setAccount(acct);
			statusupdate = statusupdateDAO.store(statusupdate);
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
		statusupdateDAO.flush();
		return statusupdate;
		}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateReleaseplan(Integer statusupdate_statusId, Integer related_releaseplan_releaseId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Releaseplan related_releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId, -1, -1);

		statusupdate.setReleaseplan(null);
		related_releaseplan.getStatusupdates().remove(statusupdate);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		releaseplanDAO.remove(related_releaseplan);
		releaseplanDAO.flush();

		return statusupdate;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Statusupdate deleteStatusupdateAccount(Integer statusupdate_statusId, Integer related_account_accountId) {
		Statusupdate statusupdate = statusupdateDAO.findStatusupdateByPrimaryKey(statusupdate_statusId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		statusupdate.setAccount(null);
		statusupdate = statusupdateDAO.store(statusupdate);
		statusupdateDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return statusupdate;
	}
}
