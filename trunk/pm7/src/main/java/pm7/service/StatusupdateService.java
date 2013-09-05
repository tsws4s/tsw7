package pm7.service;

import java.util.List;
import java.util.Set;

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
public interface StatusupdateService {

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Statusupdate saveStatusupdateTask(Integer statusId, Task related_task);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Statusupdate deleteStatusupdateTask(Integer statusupdate_statusId, Integer related_task_taskId);

	/**
	 * Return a count of all Statusupdate entity
	 * 
	 */
	public Integer countStatusupdates();

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Statusupdate saveStatusupdateProject(Integer statusId_1, Project related_project);

	/**
	 * Delete an existing Person entity
	 * 
	 */
	public Statusupdate deleteStatusupdatePerson(Integer statusupdate_statusId_1, Integer related_person_personId);

	/**
	 */
	public Statusupdate findStatusupdateByPrimaryKey(Integer statusId_2);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Statusupdate deleteStatusupdateProject(Integer statusupdate_statusId_2, Integer related_project_projectId);

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	public Statusupdate saveStatusupdateReleaseplan(Integer statusId_3, Releaseplan related_releaseplan);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Statusupdate saveStatusupdateRequirement(Integer statusId_4, Requirement related_requirement);

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Statusupdate saveStatusupdateAttachments(Integer statusId_5, Attachment related_attachments);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Statusupdate saveStatusupdateAccount(Integer statusId_6, Account related_account);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Statusupdate deleteStatusupdateTestcase(Integer statusupdate_statusId_3, Integer related_testcase_testId);

	/**
	 * Return all Statusupdate entity
	 * 
	 */
	public List<Statusupdate> findAllStatusupdates(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Statusupdate saveStatusupdatePerson(Integer statusId_7, Person related_person);

	/**
	 * Load an existing Statusupdate entity
	 * 
	 */
	public Set<Statusupdate> loadStatusupdates();

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Statusupdate deleteStatusupdateDefect(Integer statusupdate_statusId_4, Integer related_defect_defectId);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Statusupdate saveStatusupdateTestcase(Integer statusId_8, Testcase related_testcase);

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public void deleteStatusupdate(Statusupdate statusupdate);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public Statusupdate deleteStatusupdateAttachments(Integer statusupdate_statusId_5, Integer related_attachments_attachId);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Statusupdate deleteStatusupdateRequirement(Integer statusupdate_statusId_6, Integer related_requirement_reqmtId);

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Statusupdate saveStatusupdateDefect(Integer statusId_9, Defect related_defect);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Statusupdate saveStatusupdate(Statusupdate statusupdate_1);

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	public Statusupdate deleteStatusupdateReleaseplan(Integer statusupdate_statusId_7, Integer related_releaseplan_releaseId);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Statusupdate deleteStatusupdateAccount(Integer statusupdate_statusId_8, Integer related_account_accountId);
}