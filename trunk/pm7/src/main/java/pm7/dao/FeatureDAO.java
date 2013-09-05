package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Feature;

/**
 * DAO to manage Feature entities.
 * 
 */
public interface FeatureDAO extends JpaDao<Feature> {

	/**
	 * JPQL Query - findFeatureByPrimaryKey
	 *
	 */
	public Feature findFeatureByPrimaryKey(Integer featureId) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByPrimaryKey
	 *
	 */
	public Feature findFeatureByPrimaryKey(Integer featureId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureCode
	 *
	 */
	public Set<Feature> findFeatureByFeatureCode(String featureCode) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureCode
	 *
	 */
	public Set<Feature> findFeatureByFeatureCode(String featureCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureName
	 *
	 */
	public Set<Feature> findFeatureByFeatureName(String featureName) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureName
	 *
	 */
	public Set<Feature> findFeatureByFeatureName(String featureName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeaturePriorityContaining
	 *
	 */
	public Set<Feature> findFeatureByFeaturePriorityContaining(String featurePriority) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeaturePriorityContaining
	 *
	 */
	public Set<Feature> findFeatureByFeaturePriorityContaining(String featurePriority, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllFeatures
	 *
	 */
	public Set<Feature> findAllFeatures() throws DataAccessException;

	/**
	 * JPQL Query - findAllFeatures
	 *
	 */
	public Set<Feature> findAllFeatures(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureNameContaining
	 *
	 */
	public Set<Feature> findFeatureByFeatureNameContaining(String featureName_1) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureNameContaining
	 *
	 */
	public Set<Feature> findFeatureByFeatureNameContaining(String featureName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureCodeContaining
	 *
	 */
	public Set<Feature> findFeatureByFeatureCodeContaining(String featureCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureCodeContaining
	 *
	 */
	public Set<Feature> findFeatureByFeatureCodeContaining(String featureCode_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeaturePriority
	 *
	 */
	public Set<Feature> findFeatureByFeaturePriority(String featurePriority_1) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeaturePriority
	 *
	 */
	public Set<Feature> findFeatureByFeaturePriority(String featurePriority_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureId
	 *
	 */
	public Feature findFeatureByFeatureId(Integer featureId_1) throws DataAccessException;

	/**
	 * JPQL Query - findFeatureByFeatureId
	 *
	 */
	public Feature findFeatureByFeatureId(Integer featureId_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxFeatureId();
}