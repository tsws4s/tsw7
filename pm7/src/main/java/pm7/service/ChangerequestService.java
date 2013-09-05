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
import pm7.domain.Task;
import pm7.domain.Testcase;

/**
 * Spring service that handles CRUD requests for Changerequest entities
 * 
 */
public interface ChangerequestService {

	/**
	 * Save an existing Attachment entity
	 * 
	 */
	public Changerequest saveChangerequestAttachments(Integer changeId, Attachment related_attachments);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Changerequest saveChangerequestProject(Integer changeId_1, Project related_project);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Changerequest deleteChangerequestAccount(Integer changerequest_changeId, Integer related_account_accountId);

	/**
	 * Save an existing Feature entity
	 * 
	 */
	public Changerequest saveChangerequestFeature(Integer changeId_2, Feature related_feature);

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	public Changerequest deleteChangerequestFeature(Integer changerequest_changeId_1, Integer related_feature_featureId);

	/**
	 * Delete an existing Attachment entity
	 * 
	 */
	public Changerequest deleteChangerequestAttachments(Integer changerequest_changeId_2, Integer related_attachments_attachId);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Changerequest deleteChangerequestProject(Integer changerequest_changeId_3, Integer related_project_projectId);

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	public Changerequest saveChangerequestReleaseplan(Integer changeId_3, Releaseplan related_releaseplan);

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Changerequest deleteChangerequestDefects(Integer changerequest_changeId_4, Integer related_defects_defectId);

	/**
	 * Load an existing Changerequest entity
	 * 
	 */
	public Set<Changerequest> loadChangerequests();

	/**
	 * Save an existing Task entity
	 * 
	 */
	public Changerequest saveChangerequestTasks(Integer changeId_4, Task related_tasks);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Changerequest saveChangerequestAccount(Integer changeId_5, Account related_account);

	/**
	 * Delete an existing Task entity
	 * 
	 */
	public Changerequest deleteChangerequestTasks(Integer changerequest_changeId_5, Integer related_tasks_taskId);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Changerequest saveChangerequest(Changerequest changerequest);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Changerequest saveChangerequestRequirement(Integer changeId_6, Requirement related_requirement);

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	public Changerequest deleteChangerequestReleaseplan(Integer changerequest_changeId_6, Integer related_releaseplan_releaseId);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Changerequest deleteChangerequestRequirement(Integer changerequest_changeId_7, Integer related_requirement_reqmtId);

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Changerequest saveChangerequestDefects(Integer changeId_7, Defect related_defects);

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public void deleteChangerequest(Changerequest changerequest_1);

	/**
	 * Return all Changerequest entity
	 * 
	 */
	public List<Changerequest> findAllChangerequests(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Changerequest deleteChangerequestTestcases(Integer changerequest_changeId_8, Integer related_testcases_testId);

	/**
	 * Return a count of all Changerequest entity
	 * 
	 */
	public Integer countChangerequests();

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Changerequest saveChangerequestTestcases(Integer changeId_8, Testcase related_testcases);

	/**
	 */
	public Changerequest findChangerequestByPrimaryKey(Integer changeId_9);
}