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

import pm7.domain.Requirement;

/**
 * DAO to manage Requirement entities.
 * 
 */
@Repository("RequirementDAO")
@Transactional
public class RequirementDAOImpl extends AbstractJpaDao<Requirement> implements
		RequirementDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Requirement.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new RequirementDAOImpl
	 *
	 */
	public RequirementDAOImpl() {
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
	 * JPQL Query - findRequirementByReqmtPriorityContaining
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtPriorityContaining(String reqmtPriority) throws DataAccessException {

		return findRequirementByReqmtPriorityContaining(reqmtPriority, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtPriorityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtPriorityContaining(String reqmtPriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtPriorityContaining", startResult, maxRows, reqmtPriority);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByPrimaryKey
	 *
	 */
	@Transactional
	public Requirement findRequirementByPrimaryKey(Integer reqmtId) throws DataAccessException {

		return findRequirementByPrimaryKey(reqmtId, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByPrimaryKey
	 *
	 */

	@Transactional
	public Requirement findRequirementByPrimaryKey(Integer reqmtId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRequirementByPrimaryKey", startResult, maxRows, reqmtId);
			return (pm7.domain.Requirement) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRequirementByStatusContaining
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByStatusContaining(String status) throws DataAccessException {

		return findRequirementByStatusContaining(status, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByStatusContaining", startResult, maxRows, status);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtId
	 *
	 */
	@Transactional
	public Requirement findRequirementByReqmtId(Integer reqmtId) throws DataAccessException {

		return findRequirementByReqmtId(reqmtId, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtId
	 *
	 */

	@Transactional
	public Requirement findRequirementByReqmtId(Integer reqmtId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findRequirementByReqmtId", startResult, maxRows, reqmtId);
			return (pm7.domain.Requirement) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findRequirementByStatus
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByStatus(String status) throws DataAccessException {

		return findRequirementByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByStatus(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtCodeContaining
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtCodeContaining(String reqmtCode) throws DataAccessException {

		return findRequirementByReqmtCodeContaining(reqmtCode, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtCodeContaining(String reqmtCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtCodeContaining", startResult, maxRows, reqmtCode);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtNameContaining
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtNameContaining(String reqmtName) throws DataAccessException {

		return findRequirementByReqmtNameContaining(reqmtName, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtNameContaining(String reqmtName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtNameContaining", startResult, maxRows, reqmtName);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescription
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtStoryDescription(String reqmtStoryDescription) throws DataAccessException {

		return findRequirementByReqmtStoryDescription(reqmtStoryDescription, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtStoryDescription(String reqmtStoryDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtStoryDescription", startResult, maxRows, reqmtStoryDescription);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtStoryDescriptionContaining(String reqmtStoryDescription) throws DataAccessException {

		return findRequirementByReqmtStoryDescriptionContaining(reqmtStoryDescription, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtStoryDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtStoryDescriptionContaining(String reqmtStoryDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtStoryDescriptionContaining", startResult, maxRows, reqmtStoryDescription);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtCode
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtCode(String reqmtCode) throws DataAccessException {

		return findRequirementByReqmtCode(reqmtCode, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtCode(String reqmtCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtCode", startResult, maxRows, reqmtCode);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtName
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtName(String reqmtName) throws DataAccessException {

		return findRequirementByReqmtName(reqmtName, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtName(String reqmtName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtName", startResult, maxRows, reqmtName);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findRequirementByReqmtPriority
	 *
	 */
	@Transactional
	public Set<Requirement> findRequirementByReqmtPriority(String reqmtPriority) throws DataAccessException {

		return findRequirementByReqmtPriority(reqmtPriority, -1, -1);
	}

	/**
	 * JPQL Query - findRequirementByReqmtPriority
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findRequirementByReqmtPriority(String reqmtPriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findRequirementByReqmtPriority", startResult, maxRows, reqmtPriority);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllRequirements
	 *
	 */
	@Transactional
	public Set<Requirement> findAllRequirements() throws DataAccessException {

		return findAllRequirements(-1, -1);
	}

	/**
	 * JPQL Query - findAllRequirements
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Requirement> findAllRequirements(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllRequirements", startResult, maxRows);
		return new LinkedHashSet<Requirement>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Requirement entity) {
		return true;
	}
	
	public Integer getMaxRequirementId() {
		Object obj = executeQuerySingleResult("select max(reqmtId) from Requirement");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
