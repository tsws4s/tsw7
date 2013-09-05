package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Attachment;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Feature;
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;
import pm7.domain.Task;
import pm7.domain.Testcase;

/**
 * Spring service that handles CRUD requests for Requirement entities
 * 
 */
public interface RequirementService {

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Requirement saveRequirementTasks(Integer reqmtId, Task related_tasks);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Requirement saveRequirementProject(Integer reqmtId_1, Project related_project);

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Requirement deleteRequirementChangerequests(Integer requirement_reqmtId, Integer related_changerequests_changeId);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Requirement deleteRequirementTestcases(Integer requirement_reqmtId_1, Integer related_testcases_testId);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Requirement saveRequirementChangerequests(Integer reqmtId_2, Changerequest related_changerequests);

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Requirement deleteRequirementDefects(Integer requirement_reqmtId_2, Integer related_defects_defectId);

	/**
	 * Return a count of all Requirement entity
	 * 
	 */
	public Integer countRequirements();

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Requirement saveRequirementDefects(Integer reqmtId_3, Defect related_defects);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Requirement saveRequirementTestcases(Integer reqmtId_4, Testcase related_testcases);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Requirement deleteRequirementProject(Integer requirement_reqmtId_3, Integer related_project_projectId);

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Requirement deleteRequirementStatusupdates(Integer requirement_reqmtId_4, Integer related_statusupdates_statusId);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public Requirement deleteRequirementAttachments(Integer requirement_reqmtId_5, Integer related_attachments_attachId);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Requirement saveRequirementStatusupdates(Integer reqmtId_5, Statusupdate related_statusupdates);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Requirement deleteRequirementTasks(Integer requirement_reqmtId_6, Integer related_tasks_taskId);

	/**
	 * Load an existing Requirement entity
	 * 
	 */
	public Set<Requirement> loadRequirements();

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	public Requirement deleteRequirementFeature(Integer requirement_reqmtId_7, Integer related_feature_featureId);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Requirement deleteRequirementAccount(Integer requirement_reqmtId_8, Integer related_account_accountId);

	/**
	 * Save an existing Feature entity
	 * 
	 */
	public Requirement saveRequirementFeature(Integer reqmtId_6, Feature related_feature);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Requirement saveRequirement(Requirement requirement);

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	public Requirement deleteRequirementReleaseplan(Integer requirement_reqmtId_9, Integer related_releaseplan_releaseId);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Requirement saveRequirementAccount(Integer reqmtId_7, Account related_account);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public void deleteRequirement(Requirement requirement_1);

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Requirement saveRequirementAttachments(Integer reqmtId_8, Attachment related_attachments);

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	public Requirement saveRequirementReleaseplan(Integer reqmtId_9, Releaseplan related_releaseplan);

	/**
	 * Return all Requirement entity
	 * 
	 */
	public List<Requirement> findAllRequirements(Integer startResult, Integer maxRows);

	/**
	 */
	public Requirement findRequirementByPrimaryKey(Integer reqmtId_10);
}