package pm7.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import pm7.domain.Feature;

/**
 * DAO to manage Feature entities.
 * 
 */
@Repository("FeatureDAO")
@Transactional
public class FeatureDAOImpl extends AbstractJpaDao<Feature> implements
		FeatureDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Feature.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new FeatureDAOImpl
	 *
	 */
	public FeatureDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findFeatureByPrimaryKey
	 *
	 */
	@Transactional
	public Feature findFeatureByPrimaryKey(Integer featureId) throws DataAccessException {

		return findFeatureByPrimaryKey(featureId, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByPrimaryKey
	 *
	 */

	@Transactional
	public Feature findFeatureByPrimaryKey(Integer featureId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findFeatureByPrimaryKey", startResult, maxRows, featureId);
			return (pm7.domain.Feature) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findFeatureByFeatureCode
	 *
	 */
	@Transactional
	public Set<Feature> findFeatureByFeatureCode(String featureCode) throws DataAccessException {

		return findFeatureByFeatureCode(featureCode, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByFeatureCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Feature> findFeatureByFeatureCode(String featureCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findFeatureByFeatureCode", startResult, maxRows, featureCode);
		return new LinkedHashSet<Feature>(query.getResultList());
	}

	/**
	 * JPQL Query - findFeatureByFeatureName
	 *
	 */
	@Transactional
	public Set<Feature> findFeatureByFeatureName(String featureName) throws DataAccessException {

		return findFeatureByFeatureName(featureName, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByFeatureName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Feature> findFeatureByFeatureName(String featureName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findFeatureByFeatureName", startResult, maxRows, featureName);
		return new LinkedHashSet<Feature>(query.getResultList());
	}

	/**
	 * JPQL Query - findFeatureByFeaturePriorityContaining
	 *
	 */
	@Transactional
	public Set<Feature> findFeatureByFeaturePriorityContaining(String featurePriority) throws DataAccessException {

		return findFeatureByFeaturePriorityContaining(featurePriority, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByFeaturePriorityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Feature> findFeatureByFeaturePriorityContaining(String featurePriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findFeatureByFeaturePriorityContaining", startResult, maxRows, featurePriority);
		return new LinkedHashSet<Feature>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllFeatures
	 *
	 */
	@Transactional
	public Set<Feature> findAllFeatures() throws DataAccessException {

		return findAllFeatures(-1, -1);
	}

	/**
	 * JPQL Query - findAllFeatures
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Feature> findAllFeatures(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllFeatures", startResult, maxRows);
		return new LinkedHashSet<Feature>(query.getResultList());
	}

	/**
	 * JPQL Query - findFeatureByFeatureNameContaining
	 *
	 */
	@Transactional
	public Set<Feature> findFeatureByFeatureNameContaining(String featureName) throws DataAccessException {

		return findFeatureByFeatureNameContaining(featureName, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByFeatureNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Feature> findFeatureByFeatureNameContaining(String featureName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findFeatureByFeatureNameContaining", startResult, maxRows, featureName);
		return new LinkedHashSet<Feature>(query.getResultList());
	}

	/**
	 * JPQL Query - findFeatureByFeatureCodeContaining
	 *
	 */
	@Transactional
	public Set<Feature> findFeatureByFeatureCodeContaining(String featureCode) throws DataAccessException {

		return findFeatureByFeatureCodeContaining(featureCode, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByFeatureCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Feature> findFeatureByFeatureCodeContaining(String featureCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findFeatureByFeatureCodeContaining", startResult, maxRows, featureCode);
		return new LinkedHashSet<Feature>(query.getResultList());
	}

	/**
	 * JPQL Query - findFeatureByFeaturePriority
	 *
	 */
	@Transactional
	public Set<Feature> findFeatureByFeaturePriority(String featurePriority) throws DataAccessException {

		return findFeatureByFeaturePriority(featurePriority, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByFeaturePriority
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Feature> findFeatureByFeaturePriority(String featurePriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findFeatureByFeaturePriority", startResult, maxRows, featurePriority);
		return new LinkedHashSet<Feature>(query.getResultList());
	}

	/**
	 * JPQL Query - findFeatureByFeatureId
	 *
	 */
	@Transactional
	public Feature findFeatureByFeatureId(Integer featureId) throws DataAccessException {

		return findFeatureByFeatureId(featureId, -1, -1);
	}

	/**
	 * JPQL Query - findFeatureByFeatureId
	 *
	 */

	@Transactional
	public Feature findFeatureByFeatureId(Integer featureId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findFeatureByFeatureId", startResult, maxRows, featureId);
			return (pm7.domain.Feature) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Feature entity) {
		return true;
	}
	
	public Integer getMaxFeatureId() {
		Object obj = executeQuerySingleResult("select max(featureId) from Feature");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
