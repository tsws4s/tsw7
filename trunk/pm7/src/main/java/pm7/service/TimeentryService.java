package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Person;
import pm7.domain.Project;
import pm7.domain.Task;
import pm7.domain.Timeentry;

/**
 * Spring service that handles CRUD requests for Timeentry entities
 * 
 */
public interface TimeentryService {

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Timeentry deleteTimeentryPerson(Integer timeentry_timeEntryId, Integer related_person_personId);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Timeentry saveTimeentryProject(Integer timeEntryId, Project related_project);

	/**
	 * Return a count of all Timeentry entity
	 * 
	 */
	public Integer countTimeentrys();

	/**
	 * Save an existing Timeentry entity
	 * 
	 */
	public Timeentry saveTimeentry(Timeentry timeentry);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Timeentry saveTimeentryAccount(Integer timeEntryId_1, Account related_account);

	/**
	 * Load an existing Timeentry entity
	 * 
	 */
	public Set<Timeentry> loadTimeentrys();

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Timeentry saveTimeentryPerson(Integer timeEntryId_2, Person related_person);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Timeentry deleteTimeentryProject(Integer timeentry_timeEntryId_1, Integer related_project_projectId);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Timeentry deleteTimeentryTask(Integer timeentry_timeEntryId_2, Integer related_task_taskId);

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Timeentry saveTimeentryTask(Integer timeEntryId_3, Task related_task);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Timeentry deleteTimeentryAccount(Integer timeentry_timeEntryId_3, Integer related_account_accountId);

	/**
	 * Return all Timeentry entity
	 * 
	 */
	public List<Timeentry> findAllTimeentrys(Integer startResult, Integer maxRows);

	/**
	 */
	public Timeentry findTimeentryByPrimaryKey(Integer timeEntryId_4);

	/**
	 * Delete an existing Timeentry entity
	 * 
	 */
	public void deleteTimeentry(Timeentry timeentry_1);
}