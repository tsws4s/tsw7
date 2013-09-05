package pm7.service;

import java.util.List;
import java.util.Set;

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
public interface TaskService {

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Task deleteTaskChangerequest(Integer task_taskId, Integer related_changerequest_changeId);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Task saveTaskTestcase(Integer taskId, Testcase related_testcase);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Task deleteTaskAccount(Integer task_taskId_1, Integer related_account_accountId);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public void deleteTask(Task task);

	/**
	 * Return all Task entity
	 * 
	 */
	public List<Task> findAllTasks(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Task deleteTaskDefect(Integer task_taskId_2, Integer related_defect_defectId);

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Task saveTask(Task task_1);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Task saveTaskAccount(Integer taskId_1, Account related_account);

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Task saveTaskDefect(Integer taskId_2, Defect related_defect);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Task deleteTaskPerson(Integer task_taskId_3, Integer related_person_personId);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Task deleteTaskTestcase(Integer task_taskId_4, Integer related_testcase_testId);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Task deleteTaskProject(Integer task_taskId_5, Integer related_project_projectId);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Task saveTaskRequirement(Integer taskId_3, Requirement related_requirement);

	/**
	 * Load an existing Task entity
	 * 
	 */
	public Set<Task> loadTasks();

	/**
	 * Return a count of all Task entity
	 * 
	 */
	public Integer countTasks();

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Task deleteTaskStatusupdates(Integer task_taskId_6, Integer related_statusupdates_statusId);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Task deleteTaskRequirement(Integer task_taskId_7, Integer related_requirement_reqmtId);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Task saveTaskStatusupdates(Integer taskId_4, Statusupdate related_statusupdates);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Task saveTaskProject(Integer taskId_5, Project related_project);

	/**
	 */
	public Task findTaskByPrimaryKey(Integer taskId_6);

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	public Task deleteTaskTimeentries(Integer task_taskId_8, Integer related_timeentries_timeEntryId);

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	public Task saveTaskTimeentries(Integer taskId_7, Timeentry related_timeentries);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Task saveTaskPerson(Integer taskId_8, Person related_person);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Task saveTaskChangerequest(Integer taskId_9, Changerequest related_changerequest);
}