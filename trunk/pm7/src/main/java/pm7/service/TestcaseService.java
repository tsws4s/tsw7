package pm7.service;

import java.util.List;
import java.util.Set;

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
public interface TestcaseService {

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Testcase saveTestcaseRequirement(Integer testId, Requirement related_requirement);

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Testcase deleteTestcaseStatusupdates(Integer testcase_testId, Integer related_statusupdates_statusId);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Testcase saveTestcaseChangerequest(Integer testId_1, Changerequest related_changerequest);

	/**
	 * Return all Testcase entity
	 * 
	 */
	public List<Testcase> findAllTestcases(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Testcase deleteTestcaseProject(Integer testcase_testId_1, Integer related_project_projectId);

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Testcase saveTestcaseAttachments(Integer testId_2, Attachment related_attachments);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Testcase saveTestcase(Testcase testcase);

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	public Testcase deleteTestcaseTestcasesteps(Integer testcase_testId_2, Integer related_testcasesteps_testStepId);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Testcase saveTestcaseStatusupdates(Integer testId_3, Statusupdate related_statusupdates);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Testcase deleteTestcaseAccount(Integer testcase_testId_3, Integer related_account_accountId);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public Testcase deleteTestcaseAttachments(Integer testcase_testId_4, Integer related_attachments_attachId);

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Testcase deleteTestcaseChangerequest(Integer testcase_testId_5, Integer related_changerequest_changeId);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Testcase saveTestcaseProject(Integer testId_4, Project related_project);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Testcase deleteTestcaseRequirement(Integer testcase_testId_6, Integer related_requirement_reqmtId);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public void deleteTestcase(Testcase testcase_1);

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Testcase saveTestcaseDefects(Integer testId_5, Defect related_defects);

	/**
	 */
	public Testcase findTestcaseByPrimaryKey(Integer testId_6);

	/**
	 * Load an existing Testcase entity
	 * 
	 */
	public Set<Testcase> loadTestcases();

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Testcase deleteTestcaseTasks(Integer testcase_testId_7, Integer related_tasks_taskId);

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Testcase deleteTestcaseDefects(Integer testcase_testId_8, Integer related_defects_defectId);

	/**
	 * Save an existing Testcasestep entity
	 * 
	 */
	public Testcase saveTestcaseTestcasesteps(Integer testId_7, Testcasestep related_testcasesteps);

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Testcase saveTestcaseTasks(Integer testId_8, Task related_tasks);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Testcase saveTestcaseAccount(Integer testId_9, Account related_account);

	/**
	 * Return a count of all Testcase entity
	 * 
	 */
	public Integer countTestcases();
}