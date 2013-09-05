//**********************************************************
// FeatureServiceImpl
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
import pm7.dao.FeatureDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;

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

@Service("FeatureService")
@Transactional
public class FeatureServiceImpl implements FeatureService {

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
	 * DAO injected by Spring that manages Feature entities
	 * 
	 */
	@Autowired
	private FeatureDAO featureDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Releaseplan entities
	 * 
	 */
	@Autowired
	private ReleaseplanDAO releaseplanDAO;

	/**
	 * DAO injected by Spring that manages Requirement entities
	 * 
	 */
	@Autowired
	private RequirementDAO requirementDAO;

	/**
	 * Instantiates a new FeatureServiceImpl.
	 *
	 */
	public FeatureServiceImpl() {
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@Transactional
	public Feature saveFeature(Feature feature) {
		Feature existingFeature = featureDAO.findFeatureByPrimaryKey(feature.getFeatureId());

		if (existingFeature != null) {
			if (existingFeature != feature) {
				existingFeature.setFeatureId(feature.getFeatureId());
				existingFeature.setFeatureCode(feature.getFeatureCode());
				existingFeature.setFeatureName(feature.getFeatureName());
				existingFeature.setFeaturePriority(feature.getFeaturePriority());
			}
			feature = featureDAO.store(existingFeature);
		} else {
			int featureId = featureDAO.getMaxFeatureId();
			feature.setFeatureId(featureId+1);
			feature.setFeatureCode("Feature-"+(featureId+1));
//			feature.setAccount(acct);
			feature = featureDAO.store(feature);
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
		featureDAO.flush();
		return feature;
		}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Feature deleteFeatureAccount(Integer feature_featureId, Integer related_account_accountId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		feature.setAccount(null);
		feature = featureDAO.store(feature);
		featureDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return feature;
	}

	/**
	 * Return all Feature entity
	 * 
	 */
	@Transactional
	public List<Feature> findAllFeatures(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Feature>(featureDAO.findAllFeatures(startResult, maxRows));
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Feature saveFeatureReleaseplan(Integer featureId, Releaseplan related_releaseplan) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(featureId, -1, -1);
		Releaseplan existingreleaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan.getReleaseId());

		// copy into the existing record to preserve existing relationships
		if (existingreleaseplan != null) {
			existingreleaseplan.setReleaseId(related_releaseplan.getReleaseId());
			existingreleaseplan.setReleaseCode(related_releaseplan.getReleaseCode());
			existingreleaseplan.setReleaseName(related_releaseplan.getReleaseName());
			existingreleaseplan.setReleaseDescription(related_releaseplan.getReleaseDescription());
			existingreleaseplan.setReleaseDate(related_releaseplan.getReleaseDate());
			related_releaseplan = existingreleaseplan;
		} else {
			related_releaseplan = releaseplanDAO.store(related_releaseplan);
			releaseplanDAO.flush();
		}

		feature.setReleaseplan(related_releaseplan);
		related_releaseplan.getFeatures().add(feature);
		feature = featureDAO.store(feature);
		featureDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		return feature;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Feature saveFeatureChangerequests(Integer featureId, Changerequest related_changerequests) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(featureId, -1, -1);
		Changerequest existingchangerequests = changerequestDAO.findChangerequestByPrimaryKey(related_changerequests.getChangeId());

		// copy into the existing record to preserve existing relationships
		if (existingchangerequests != null) {
			existingchangerequests.setChangeId(related_changerequests.getChangeId());
			existingchangerequests.setStatus(related_changerequests.getStatus());
			existingchangerequests.setChangePriority(related_changerequests.getChangePriority());
			existingchangerequests.setChangeCode(related_changerequests.getChangeCode());
			existingchangerequests.setChangeName(related_changerequests.getChangeName());
			existingchangerequests.setChangeDescription(related_changerequests.getChangeDescription());
			related_changerequests = existingchangerequests;
		} else {
			int changeReqId = changerequestDAO.getMaxChangeId();
			related_changerequests.setChangeId(changeReqId+1);
			related_changerequests.setChangeCode("ChgReq-"+(changeReqId+1));
			related_changerequests = changerequestDAO.store(related_changerequests);
			changerequestDAO.flush();
		}

		related_changerequests.setFeature(feature);
		feature.getChangerequests().add(related_changerequests);
		related_changerequests = changerequestDAO.store(related_changerequests);
		changerequestDAO.flush();
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

		feature = featureDAO.store(feature);
		featureDAO.flush();

		return feature;
	}

	/**
	 */
	@Transactional
	public Feature findFeatureByPrimaryKey(Integer featureId) {
		return featureDAO.findFeatureByPrimaryKey(featureId);
	}

	/**
	 * Load an existing Feature entity
	 * 
	 */
	@Transactional
	public Set<Feature> loadFeatures() {
		return featureDAO.findAllFeatures();
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Feature deleteFeatureReleaseplan(Integer feature_featureId, Integer related_releaseplan_releaseId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);
		Releaseplan related_releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(related_releaseplan_releaseId, -1, -1);

		feature.setReleaseplan(null);
		related_releaseplan.getFeatures().remove(feature);
		feature = featureDAO.store(feature);
		featureDAO.flush();

		related_releaseplan = releaseplanDAO.store(related_releaseplan);
		releaseplanDAO.flush();

		releaseplanDAO.remove(related_releaseplan);
		releaseplanDAO.flush();

		return feature;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Feature saveFeatureProject(Integer featureId, Project related_project) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(featureId, -1, -1);
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

		feature.setProject(related_project);
		related_project.getFeatures().add(feature);
		feature = featureDAO.store(feature);
		featureDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return feature;
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Feature deleteFeatureChangerequests(Integer feature_featureId, Integer related_changerequests_changeId) {
		Changerequest related_changerequests = changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId, -1, -1);

		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);

		related_changerequests.setFeature(null);
		feature.getChangerequests().remove(related_changerequests);

		changerequestDAO.remove(related_changerequests);
		changerequestDAO.flush();

		return feature;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Feature deleteFeatureProject(Integer feature_featureId, Integer related_project_projectId) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		feature.setProject(null);
		related_project.getFeatures().remove(feature);
		feature = featureDAO.store(feature);
		featureDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return feature;
	}

	/**
	 * Return a count of all Feature entity
	 * 
	 */
	@Transactional
	public Integer countFeatures() {
		return ((Long) featureDAO.createQuerySingleResult("select count(o) from Feature o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Feature deleteFeatureRequirements(Integer feature_featureId, Integer related_requirements_reqmtId) {
		Requirement related_requirements = requirementDAO.findRequirementByPrimaryKey(related_requirements_reqmtId, -1, -1);

		Feature feature = featureDAO.findFeatureByPrimaryKey(feature_featureId, -1, -1);

		related_requirements.setFeature(null);
		feature.getRequirements().remove(related_requirements);

		requirementDAO.remove(related_requirements);
		requirementDAO.flush();

		return feature;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Feature saveFeatureAccount(Integer featureId, Account related_account) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(featureId, -1, -1);
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

		feature.setAccount(related_account);
		feature = featureDAO.store(feature);
		featureDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return feature;
	}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Feature saveFeatureRequirements(Integer featureId, Requirement related_requirements) {
		Feature feature = featureDAO.findFeatureByPrimaryKey(featureId, -1, -1);
		Requirement existingrequirements = requirementDAO.findRequirementByPrimaryKey(related_requirements.getReqmtId());

		// copy into the existing record to preserve existing relationships
		if (existingrequirements != null) {
			existingrequirements.setReqmtId(related_requirements.getReqmtId());
			existingrequirements.setStatus(related_requirements.getStatus());
			existingrequirements.setReqmtPriority(related_requirements.getReqmtPriority());
			existingrequirements.setReqmtCode(related_requirements.getReqmtCode());
			existingrequirements.setReqmtName(related_requirements.getReqmtName());
			existingrequirements.setReqmtStoryDescription(related_requirements.getReqmtStoryDescription());
			related_requirements = existingrequirements;
		} else {
			int reqmtId = requirementDAO.getMaxRequirementId();
			related_requirements.setReqmtId(reqmtId+1);
			related_requirements.setReqmtCode("ReqCd-"+(reqmtId+1));
			related_requirements = requirementDAO.store(related_requirements);
			requirementDAO.flush();
		}

		related_requirements.setFeature(feature);
		feature.getRequirements().add(related_requirements);
		related_requirements = requirementDAO.store(related_requirements);
		requirementDAO.flush();
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

		feature = featureDAO.store(feature);
		featureDAO.flush();

		return feature;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@Transactional
	public void deleteFeature(Feature feature) {
		featureDAO.remove(feature);
		featureDAO.flush();
	}
}
