package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Changerequest;
import pm7.domain.Defect;
import pm7.domain.Feature;
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;
import pm7.domain.Statusupdate;

/**
 * Spring service that handles CRUD requests for Releaseplan entities
 * 
 */
public interface ReleaseplanService {

	/**
	 * Save an existing Defect entity
	 * 
	 */
	public Releaseplan saveReleaseplanDefects(Integer releaseId, Defect related_defects);

	/**
	 * Load an existing Releaseplan entity
	 * 
	 */
	public Set<Releaseplan> loadReleaseplans();

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	public void deleteReleaseplan(Releaseplan releaseplan);

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	public Releaseplan deleteReleaseplanStatusupdates(Integer releaseplan_releaseId, Integer related_statusupdates_statusId);

	/**
	 * Save an existing Feature entity
	 * 
	 */
	public Releaseplan saveReleaseplanFeatures(Integer releaseId_1, Feature related_features);

	/**
	 * Return all Releaseplan entity
	 * 
	 */
	public List<Releaseplan> findAllReleaseplans(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	public Releaseplan saveReleaseplanStatusupdates(Integer releaseId_2, Statusupdate related_statusupdates);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Releaseplan saveReleaseplanAccount(Integer releaseId_3, Account related_account);

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	public Releaseplan deleteReleaseplanFeatures(Integer releaseplan_releaseId_1, Integer related_features_featureId);

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	public Releaseplan saveReleaseplan(Releaseplan releaseplan_1);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Releaseplan saveReleaseplanRequirements(Integer releaseId_4, Requirement related_requirements);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Releaseplan saveReleaseplanChangerequests(Integer releaseId_5, Changerequest related_changerequests);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Releaseplan deleteReleaseplanAccount(Integer releaseplan_releaseId_2, Integer related_account_accountId);

	/**
	 */
	public Releaseplan findReleaseplanByPrimaryKey(Integer releaseId_6);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Releaseplan deleteReleaseplanProject(Integer releaseplan_releaseId_3, Integer related_project_projectId);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Releaseplan saveReleaseplanProject(Integer releaseId_7, Project related_project);

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Releaseplan deleteReleaseplanRequirements(Integer releaseplan_releaseId_4, Integer related_requirements_reqmtId);

	/**
	 * Return a count of all Releaseplan entity
	 * 
	 */
	public Integer countReleaseplans();

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Releaseplan deleteReleaseplanChangerequests(Integer releaseplan_releaseId_5, Integer related_changerequests_changeId);

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	public Releaseplan deleteReleaseplanDefects(Integer releaseplan_releaseId_6, Integer related_defects_defectId);
}