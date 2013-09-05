//**********************************************************
// TaskServiceImpl
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
import pm7.dao.ChangerequestDAO;
import pm7.dao.DefectDAO;
import pm7.dao.PersonDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;
import pm7.dao.TaskDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TimeentryDAO;

import pm7.domain.Account;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;
import pm7.domain.Timeentry;

/**
 * Spring service that handles CRUD requests for Task entities
 * 
 */

@Service("TaskService")
@Transactional
public class TaskServiceImpl implements TaskService {

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
	 * DAO injected by Spring that manages Timeentry entities
	 * 
	 */
	@Autowired
	private TimeentryDAO timeentryDAO;

	/**
	 * Instantiates a new TaskServiceImpl.
	 *
	 */
	public TaskServiceImpl() {
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Task deleteTaskChangerequest(Integer task_taskId, Integer related_changerequest_changeId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		Changerequest related_changerequest = changerequestDAO.findChangerequestByPrimaryKey(related_changerequest_changeId, -1, -1);

		task.setChangerequest(null);
		related_changerequest.getTasks().remove(task);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		changerequestDAO.remove(related_changerequest);
		changerequestDAO.flush();

		return task;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Task saveTaskTestcase(Integer taskId, Testcase related_testcase) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		task.setTestcase(related_testcase);
		related_testcase.getTasks().add(task);
		task = taskDAO.store(task);
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

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		return task;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Task deleteTaskAccount(Integer task_taskId, Integer related_account_accountId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		task.setAccount(null);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return task;
	}

	/**
	 * Delete an existing Task entity
	 * 
	 */
	@Transactional
	public void deleteTask(Task task) {
		taskDAO.remove(task);
		taskDAO.flush();
	}

	/**
	 * Return all Task entity
	 * 
	 */
	@Transactional
	public List<Task> findAllTasks(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Task>(taskDAO.findAllTasks(startResult, maxRows));
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Task deleteTaskDefect(Integer task_taskId, Integer related_defect_defectId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		Defect related_defect = defectDAO.findDefectByPrimaryKey(related_defect_defectId, -1, -1);

		task.setDefect(null);
		related_defect.getTasks().remove(task);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_defect = defectDAO.store(related_defect);
		defectDAO.flush();

		defectDAO.remove(related_defect);
		defectDAO.flush();

		return task;
	}

	/**
	 * Save an existing Task entity
	 * 
	 */
	@Transactional
	public Task saveTask(Task task) {
		Task existingTask = taskDAO.findTaskByPrimaryKey(task.getTaskId());

		if (existingTask != null) {
			if (existingTask != task) {
				existingTask.setTaskId(task.getTaskId());
				existingTask.setStatus(task.getStatus());
				existingTask.setTaskName(task.getTaskName());
				existingTask.setTaskDescription(task.getTaskDescription());
				existingTask.setStartDate(task.getStartDate());
				existingTask.setTargetDate(task.getTargetDate());
				existingTask.setCompleteDate(task.getCompleteDate());
				existingTask.setPercentComplete(task.getPercentComplete());
				existingTask.setEstimateHrs(task.getEstimateHrs());
				existingTask.setActualHrs(task.getActualHrs());
				existingTask.setTaskType(task.getTaskType());
			}
			task = taskDAO.store(existingTask);
		} else {
			int taskId = taskDAO.getMaxTaskId();
			task.setTaskId(taskId+1);
//			person.setAccount(acct);
			task = taskDAO.store(task);
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
		taskDAO.flush();
		return task;
		}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Task saveTaskAccount(Integer taskId, Account related_account) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		task.setAccount(related_account);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return task;
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Task saveTaskDefect(Integer taskId, Defect related_defect) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		task.setDefect(related_defect);
		related_defect.getTasks().add(task);
		task = taskDAO.store(task);
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

		related_defect = defectDAO.store(related_defect);
		defectDAO.flush();

		return task;
	}

	/**
	 * Delete an existing Person entity
	 * 
	 */
	@Transactional
	public Task deleteTaskPerson(Integer task_taskId, Integer related_person_personId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		Person related_person = personDAO.findPersonByPrimaryKey(related_person_personId, -1, -1);

		task.setPerson(null);
		related_person.getTasks().remove(task);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		personDAO.remove(related_person);
		personDAO.flush();

		return task;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Task deleteTaskTestcase(Integer task_taskId, Integer related_testcase_testId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		Testcase related_testcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId, -1, -1);

		task.setTestcase(null);
		related_testcase.getTasks().remove(task);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		testcaseDAO.remove(related_testcase);
		testcaseDAO.flush();

		return task;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Task deleteTaskProject(Integer task_taskId, Integer related_project_projectId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		task.setProject(null);
		related_project.getTasks().remove(task);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return task;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Task saveTaskRequirement(Integer taskId, Requirement related_requirement) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		task.setRequirement(related_requirement);
		related_requirement.getTasks().add(task);
		task = taskDAO.store(task);
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

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		return task;
	}

	/**
	 * Load an existing Task entity
	 * 
	 */
	@Transactional
	public Set<Task> loadTasks() {
		return taskDAO.findAllTasks();
	}

	/**
	 * Return a count of all Task entity
	 * 
	 */
	@Transactional
	public Integer countTasks() {
		return ((Long) taskDAO.createQuerySingleResult("select count(o) from Task o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Task deleteTaskStatusupdates(Integer task_taskId, Integer related_statusupdates_statusId) {
		Statusupdate related_statusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId, -1, -1);

		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);

		related_statusupdates.setTask(null);
		task.getStatusupdates().remove(related_statusupdates);

		statusupdateDAO.remove(related_statusupdates);
		statusupdateDAO.flush();

		return task;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Task deleteTaskRequirement(Integer task_taskId, Integer related_requirement_reqmtId) {
		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);
		Requirement related_requirement = requirementDAO.findRequirementByPrimaryKey(related_requirement_reqmtId, -1, -1);

		task.setRequirement(null);
		related_requirement.getTasks().remove(task);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_requirement = requirementDAO.store(related_requirement);
		requirementDAO.flush();

		requirementDAO.remove(related_requirement);
		requirementDAO.flush();

		return task;
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Task saveTaskStatusupdates(Integer taskId, Statusupdate related_statusupdates) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		related_statusupdates.setTask(task);
		task.getStatusupdates().add(related_statusupdates);
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

		task = taskDAO.store(task);
		taskDAO.flush();

		return task;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Task saveTaskProject(Integer taskId, Project related_project) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		task.setProject(related_project);
		related_project.getTasks().add(task);
		task = taskDAO.store(task);
		taskDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return task;
	}

	/**
	 */
	@Transactional
	public Task findTaskByPrimaryKey(Integer taskId) {
		return taskDAO.findTaskByPrimaryKey(taskId);
	}

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Task deleteTaskTimeentries(Integer task_taskId, Integer related_timeentries_timeEntryId) {
		Timeentry related_timeentries = timeentryDAO.findTimeentryByPrimaryKey(related_timeentries_timeEntryId, -1, -1);

		Task task = taskDAO.findTaskByPrimaryKey(task_taskId, -1, -1);

		related_timeentries.setTask(null);
		task.getTimeentries().remove(related_timeentries);

		timeentryDAO.remove(related_timeentries);
		timeentryDAO.flush();

		return task;
	}

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	@Transactional
	public Task saveTaskTimeentries(Integer taskId, Timeentry related_timeentries) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
		Timeentry existingtimeentries = timeentryDAO.findTimeentryByPrimaryKey(related_timeentries.getTimeEntryId());

		// copy into the existing record to preserve existing relationships
		if (existingtimeentries != null) {
			existingtimeentries.setTimeEntryId(related_timeentries.getTimeEntryId());
			existingtimeentries.setTimeHrs(related_timeentries.getTimeHrs());
			existingtimeentries.setRateAmt(related_timeentries.getRateAmt());
			existingtimeentries.setDate(related_timeentries.getDate());
			existingtimeentries.setDescription(related_timeentries.getDescription());
			related_timeentries = existingtimeentries;
		} else {
			related_timeentries = timeentryDAO.store(related_timeentries);
			timeentryDAO.flush();
		}

		related_timeentries.setTask(task);
		task.getTimeentries().add(related_timeentries);
		related_timeentries = timeentryDAO.store(related_timeentries);
		timeentryDAO.flush();
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

		task = taskDAO.store(task);
		taskDAO.flush();

		return task;
	}

	/**
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Task saveTaskPerson(Integer taskId, Person related_person) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		task.setPerson(related_person);
		related_person.getTasks().add(task);
		task = taskDAO.store(task);
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

		related_person = personDAO.store(related_person);
		personDAO.flush();

		return task;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Task saveTaskChangerequest(Integer taskId, Changerequest related_changerequest) {
		Task task = taskDAO.findTaskByPrimaryKey(taskId, -1, -1);
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

		task.setChangerequest(related_changerequest);
		related_changerequest.getTasks().add(task);
		task = taskDAO.store(task);
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

		related_changerequest = changerequestDAO.store(related_changerequest);
		changerequestDAO.flush();

		return task;
	}
}
