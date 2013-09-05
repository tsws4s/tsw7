//**********************************************************
// ReleaseplanServiceImpl
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
import pm7.dao.DefectDAO;
import pm7.dao.FeatureDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.ReleaseplanDAO;
import pm7.dao.RequirementDAO;
import pm7.dao.StatusupdateDAO;

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

@Service("ReleaseplanService")
@Transactional
public class ReleaseplanServiceImpl implements ReleaseplanService {

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
	 * DAO injected by Spring that manages Defect entities
	 * 
	 */
	@Autowired
	private DefectDAO defectDAO;

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
	 * DAO injected by Spring that manages Statusupdate entities
	 * 
	 */
	@Autowired
	private StatusupdateDAO statusupdateDAO;

	/**
	 * Instantiates a new ReleaseplanServiceImpl.
	 *
	 */
	public ReleaseplanServiceImpl() {
	}

	/**
	 * Save an existing Defect entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplanDefects(Integer releaseId, Defect related_defects) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseId, -1, -1);
		Defect existingdefects = defectDAO.findDefectByPrimaryKey(related_defects.getDefectId());

		// copy into the existing record to preserve existing relationships
		if (existingdefects != null) {
			existingdefects.setDefectId(related_defects.getDefectId());
			existingdefects.setStatus(related_defects.getStatus());
			existingdefects.setDefectPriority(related_defects.getDefectPriority());
			existingdefects.setDefectName(related_defects.getDefectName());
			existingdefects.setDefectDescriptin(related_defects.getDefectDescriptin());
			related_defects = existingdefects;
		} else {
			related_defects = defectDAO.store(related_defects);
			defectDAO.flush();
		}

		related_defects.setReleaseplan(releaseplan);
		releaseplan.getDefects().add(related_defects);
		related_defects = defectDAO.store(related_defects);
		defectDAO.flush();
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

		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		return releaseplan;
	}

	/**
	 * Load an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Set<Releaseplan> loadReleaseplans() {
		return releaseplanDAO.findAllReleaseplans();
	}

	/**
	 * Delete an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public void deleteReleaseplan(Releaseplan releaseplan) {
		releaseplanDAO.remove(releaseplan);
		releaseplanDAO.flush();
	}

	/**
	 * Delete an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Releaseplan deleteReleaseplanStatusupdates(Integer releaseplan_releaseId, Integer related_statusupdates_statusId) {
		Statusupdate related_statusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates_statusId, -1, -1);

		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		related_statusupdates.setReleaseplan(null);
		releaseplan.getStatusupdates().remove(related_statusupdates);

		statusupdateDAO.remove(related_statusupdates);
		statusupdateDAO.flush();

		return releaseplan;
	}

	/**
	 * Save an existing Feature entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplanFeatures(Integer releaseId, Feature related_features) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseId, -1, -1);
		Feature existingfeatures = featureDAO.findFeatureByPrimaryKey(related_features.getFeatureId());

		// copy into the existing record to preserve existing relationships
		if (existingfeatures != null) {
			existingfeatures.setFeatureId(related_features.getFeatureId());
			existingfeatures.setFeatureCode(related_features.getFeatureCode());
			existingfeatures.setFeatureName(related_features.getFeatureName());
			existingfeatures.setFeaturePriority(related_features.getFeaturePriority());
			related_features = existingfeatures;
		} else {
			related_features = featureDAO.store(related_features);
			featureDAO.flush();
		}

		related_features.setReleaseplan(releaseplan);
		releaseplan.getFeatures().add(related_features);
		related_features = featureDAO.store(related_features);
		featureDAO.flush();
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

		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		return releaseplan;
	}

	/**
	 * Return all Releaseplan entity
	 * 
	 */
	@Transactional
	public List<Releaseplan> findAllReleaseplans(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Releaseplan>(releaseplanDAO.findAllReleaseplans(startResult, maxRows));
	}

	/**
	 * Save an existing Statusupdate entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplanStatusupdates(Integer releaseId, Statusupdate related_statusupdates) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseId, -1, -1);
		Statusupdate existingstatusupdates = statusupdateDAO.findStatusupdateByPrimaryKey(related_statusupdates.getStatusId());

		// copy into the existing record to preserve existing relationships
		if (existingstatusupdates != null) {
			existingstatusupdates.setStatusId(related_statusupdates.getStatusId());
			existingstatusupdates.setStatusDate(related_statusupdates.getStatusDate());
			existingstatusupdates.setStatusUpdateDesc(related_statusupdates.getStatusUpdateDesc());
			existingstatusupdates.setEstHrsLeft(related_statusupdates.getEstHrsLeft());
			existingstatusupdates.setRiskGyr(related_statusupdates.getRiskGyr());
			related_statusupdates = existingstatusupdates;
		} else {
			int statusupdateId = statusupdateDAO.getMaxStatusupdateId();
			related_statusupdates.setStatusId(statusupdateId+1);
			related_statusupdates = statusupdateDAO.store(related_statusupdates);
			statusupdateDAO.flush();
		}

		related_statusupdates.setReleaseplan(releaseplan);
		releaseplan.getStatusupdates().add(related_statusupdates);
		related_statusupdates = statusupdateDAO.store(related_statusupdates);
		statusupdateDAO.flush();
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

		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		return releaseplan;
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplanAccount(Integer releaseId, Account related_account) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseId, -1, -1);
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

		releaseplan.setAccount(related_account);
		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return releaseplan;
	}

	/**
	 * Delete an existing Feature entity
	 * 
	 */
	@Transactional
	public Releaseplan deleteReleaseplanFeatures(Integer releaseplan_releaseId, Integer related_features_featureId) {
		Feature related_features = featureDAO.findFeatureByPrimaryKey(related_features_featureId, -1, -1);

		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		related_features.setReleaseplan(null);
		releaseplan.getFeatures().remove(related_features);

		featureDAO.remove(related_features);
		featureDAO.flush();

		return releaseplan;
	}

	/**
	 * Save an existing Releaseplan entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplan(Releaseplan releaseplan) {
		Releaseplan existingReleaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan.getReleaseId());

		if (existingReleaseplan != null) {
			if (existingReleaseplan != releaseplan) {
				existingReleaseplan.setReleaseId(releaseplan.getReleaseId());
				existingReleaseplan.setReleaseCode(releaseplan.getReleaseCode());
				existingReleaseplan.setReleaseName(releaseplan.getReleaseName());
				existingReleaseplan.setReleaseDescription(releaseplan.getReleaseDescription());
				existingReleaseplan.setReleaseDate(releaseplan.getReleaseDate());
			}
			releaseplan = releaseplanDAO.store(existingReleaseplan);
		} else {
			int releaseplanId = releaseplanDAO.getMaxReleaseplanId();
			releaseplan.setReleaseId(releaseplanId+1);
//			person.setAccount(acct);
			releaseplan = releaseplanDAO.store(releaseplan);
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
		releaseplanDAO.flush();
		return releaseplan;
		}

	/**
	 * Save an existing Requirement entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplanRequirements(Integer releaseId, Requirement related_requirements) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseId, -1, -1);
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
			related_requirements = requirementDAO.store(related_requirements);
			requirementDAO.flush();
		}

		related_requirements.setReleaseplan(releaseplan);
		releaseplan.getRequirements().add(related_requirements);
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

		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		return releaseplan;
	}

	/**
	 * Save an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplanChangerequests(Integer releaseId, Changerequest related_changerequests) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseId, -1, -1);
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
			related_changerequests = changerequestDAO.store(related_changerequests);
			changerequestDAO.flush();
		}

		related_changerequests.setReleaseplan(releaseplan);
		releaseplan.getChangerequests().add(related_changerequests);
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

		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		return releaseplan;
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Releaseplan deleteReleaseplanAccount(Integer releaseplan_releaseId, Integer related_account_accountId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		releaseplan.setAccount(null);
		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return releaseplan;
	}

	/**
	 */
	@Transactional
	public Releaseplan findReleaseplanByPrimaryKey(Integer releaseId) {
		return releaseplanDAO.findReleaseplanByPrimaryKey(releaseId);
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Releaseplan deleteReleaseplanProject(Integer releaseplan_releaseId, Integer related_project_projectId) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		releaseplan.setProject(null);
		related_project.getReleaseplans().remove(releaseplan);
		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return releaseplan;
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Releaseplan saveReleaseplanProject(Integer releaseId, Project related_project) {
		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseId, -1, -1);
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

		releaseplan.setProject(related_project);
		related_project.getReleaseplans().add(releaseplan);
		releaseplan = releaseplanDAO.store(releaseplan);
		releaseplanDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return releaseplan;
	}

	/**
	 * Delete an existing Requirement entity
	 * 
	 */
	@Transactional
	public Releaseplan deleteReleaseplanRequirements(Integer releaseplan_releaseId, Integer related_requirements_reqmtId) {
		Requirement related_requirements = requirementDAO.findRequirementByPrimaryKey(related_requirements_reqmtId, -1, -1);

		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		related_requirements.setReleaseplan(null);
		releaseplan.getRequirements().remove(related_requirements);

		requirementDAO.remove(related_requirements);
		requirementDAO.flush();

		return releaseplan;
	}

	/**
	 * Return a count of all Releaseplan entity
	 * 
	 */
	@Transactional
	public Integer countReleaseplans() {
		return ((Long) releaseplanDAO.createQuerySingleResult("select count(o) from Releaseplan o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Changerequest entity
	 * 
	 */
	@Transactional
	public Releaseplan deleteReleaseplanChangerequests(Integer releaseplan_releaseId, Integer related_changerequests_changeId) {
		Changerequest related_changerequests = changerequestDAO.findChangerequestByPrimaryKey(related_changerequests_changeId, -1, -1);

		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		related_changerequests.setReleaseplan(null);
		releaseplan.getChangerequests().remove(related_changerequests);

		changerequestDAO.remove(related_changerequests);
		changerequestDAO.flush();

		return releaseplan;
	}

	/**
	 * Delete an existing Defect entity
	 * 
	 */
	@Transactional
	public Releaseplan deleteReleaseplanDefects(Integer releaseplan_releaseId, Integer related_defects_defectId) {
		Defect related_defects = defectDAO.findDefectByPrimaryKey(related_defects_defectId, -1, -1);

		Releaseplan releaseplan = releaseplanDAO.findReleaseplanByPrimaryKey(releaseplan_releaseId, -1, -1);

		related_defects.setReleaseplan(null);
		releaseplan.getDefects().remove(related_defects);

		defectDAO.remove(related_defects);
		defectDAO.flush();

		return releaseplan;
	}
}
