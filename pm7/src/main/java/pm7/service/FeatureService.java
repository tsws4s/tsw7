package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Changerequest;
import pm7.domain.Feature;
import pm7.domain.Project;
import pm7.domain.Releaseplan;
import pm7.domain.Requirement;

/**
 * Spring service that handles CRUD requests for Feature entities
 * 
 */
public interface FeatureService {

	/**
	 * Save an existing Feature entity
	 * 
	 */
	public Feature saveFeature(Feature feature);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Feature deleteFeatureAccount(Integer feature_featureId, Integer related_account_accountId);

	/**
	 * Return all Feature entity
	 * 
	 */
	public List<Feature> findAllFeatures(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	public Feature saveFeatureReleaseplan(Integer featureId, Releaseplan related_releaseplan);

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	public Feature saveFeatureChangerequests(Integer featureId_1, Changerequest related_changerequests);

	/**
	 */
	public Feature findFeatureByPrimaryKey(Integer featureId_2);

	/**
	 * Load an existing Feature entity
	 * 
	 */
	public Set<Feature> loadFeatures();

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	public Feature deleteFeatureReleaseplan(Integer feature_featureId_1, Integer related_releaseplan_releaseId);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Feature saveFeatureProject(Integer featureId_3, Project related_project);

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	public Feature deleteFeatureChangerequests(Integer feature_featureId_2, Integer related_changerequests_changeId);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Feature deleteFeatureProject(Integer feature_featureId_3, Integer related_project_projectId);

	/**
	 * Return a count of all Feature entity
	 * 
	 */
	public Integer countFeatures();

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	public Feature deleteFeatureRequirements(Integer feature_featureId_4, Integer related_requirements_reqmtId);

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Feature saveFeatureAccount(Integer featureId_4, Account related_account);

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	public Feature saveFeatureRequirements(Integer featureId_5, Requirement related_requirements);

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	public void deleteFeature(Feature feature_1);
}