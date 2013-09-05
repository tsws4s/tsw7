package pm7.service;

import java.util.List;
import java.util.Set;

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
public interface DefectService {

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public void deleteDefect(Defect defect);

	/**
	 * Load an existing Defect entity
	 * 
	 */
	public Set<Defect> loadDefects();

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Defect deleteDefectStatusupdates(Integer defect_defectId, Integer related_statusupdates_statusId);

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	public Defect deleteDefectReleaseplan(Integer defect_defectId_1, Integer related_releaseplan_releaseId);

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Defect saveDefect(Defect defect_1);

	/**
	 * Return a count of all Defect entity
	 * 
	 */
	public Integer countDefects();

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	public Defect saveDefectReleaseplan(Integer defectId, Releaseplan related_releaseplan);

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Defect saveDefectAttachments(Integer defectId_1, Attachment related_attachments);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Defect saveDefectChangerequest(Integer defectId_2, Changerequest related_changerequest);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Defect deleteDefectTasks(Integer defect_defectId_2, Integer related_tasks_taskId);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Defect saveDefectAccount(Integer defectId_3, Account related_account);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Defect deleteDefectTestcase(Integer defect_defectId_3, Integer related_testcase_testId);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Defect saveDefectStatusupdates(Integer defectId_4, Statusupdate related_statusupdates);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Defect saveDefectRequirement(Integer defectId_5, Requirement related_requirement);

	/**
	 * Return all Defect entity
	 * 
	 */
	public List<Defect> findAllDefects(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Defect deleteDefectAccount(Integer defect_defectId_4, Integer related_account_accountId);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Defect deleteDefectRequirement(Integer defect_defectId_5, Integer related_requirement_reqmtId);

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Defect deleteDefectChangerequest(Integer defect_defectId_6, Integer related_changerequest_changeId);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Defect saveDefectProject(Integer defectId_6, Project related_project);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public Defect deleteDefectAttachments(Integer defect_defectId_7, Integer related_attachments_attachId);

	/**
	 */
	public Defect findDefectByPrimaryKey(Integer defectId_7);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Defect deleteDefectProject(Integer defect_defectId_8, Integer related_project_projectId);

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Defect saveDefectTasks(Integer defectId_8, Task related_tasks);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Defect saveDefectTestcase(Integer defectId_9, Testcase related_testcase);
}