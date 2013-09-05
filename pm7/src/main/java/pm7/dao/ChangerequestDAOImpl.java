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

import pm7.domain.Changerequest;

/**
 * DAO to manage Changerequest entities.
 * 
 */
@Repository("ChangerequestDAO")
@Transactional
public class ChangerequestDAOImpl extends AbstractJpaDao<Changerequest>
		implements ChangerequestDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Changerequest.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new ChangerequestDAOImpl
	 *
	 */
	public ChangerequestDAOImpl() {
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
	 * JPQL Query - findChangerequestByChangePriorityContaining
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangePriorityContaining(String changePriority) throws DataAccessException {

		return findChangerequestByChangePriorityContaining(changePriority, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangePriorityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangePriorityContaining(String changePriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangePriorityContaining", startResult, maxRows, changePriority);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByStatusContaining
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByStatusContaining(String status) throws DataAccessException {

		return findChangerequestByStatusContaining(status, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByStatusContaining", startResult, maxRows, status);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByChangeDescription
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangeDescription(String changeDescription) throws DataAccessException {

		return findChangerequestByChangeDescription(changeDescription, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangeDescription
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangeDescription(String changeDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangeDescription", startResult, maxRows, changeDescription);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByChangeDescriptionContaining
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangeDescriptionContaining(String changeDescription) throws DataAccessException {

		return findChangerequestByChangeDescriptionContaining(changeDescription, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangeDescriptionContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangeDescriptionContaining(String changeDescription, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangeDescriptionContaining", startResult, maxRows, changeDescription);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByStatus
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByStatus(String status) throws DataAccessException {

		return findChangerequestByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByStatus(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllChangerequests
	 *
	 */
	@Transactional
	public Set<Changerequest> findAllChangerequests() throws DataAccessException {

		return findAllChangerequests(-1, -1);
	}

	/**
	 * JPQL Query - findAllChangerequests
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findAllChangerequests(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllChangerequests", startResult, maxRows);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByChangeCode
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangeCode(String changeCode) throws DataAccessException {

		return findChangerequestByChangeCode(changeCode, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangeCode
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangeCode(String changeCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangeCode", startResult, maxRows, changeCode);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByChangeName
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangeName(String changeName) throws DataAccessException {

		return findChangerequestByChangeName(changeName, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangeName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangeName(String changeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangeName", startResult, maxRows, changeName);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByChangeCodeContaining
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangeCodeContaining(String changeCode) throws DataAccessException {

		return findChangerequestByChangeCodeContaining(changeCode, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangeCodeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangeCodeContaining(String changeCode, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangeCodeContaining", startResult, maxRows, changeCode);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByChangeId
	 *
	 */
	@Transactional
	public Changerequest findChangerequestByChangeId(Integer changeId) throws DataAccessException {

		return findChangerequestByChangeId(changeId, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangeId
	 *
	 */

	@Transactional
	public Changerequest findChangerequestByChangeId(Integer changeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findChangerequestByChangeId", startResult, maxRows, changeId);
			return (pm7.domain.Changerequest) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findChangerequestByChangeNameContaining
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangeNameContaining(String changeName) throws DataAccessException {

		return findChangerequestByChangeNameContaining(changeName, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangeNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangeNameContaining(String changeName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangeNameContaining", startResult, maxRows, changeName);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByChangePriority
	 *
	 */
	@Transactional
	public Set<Changerequest> findChangerequestByChangePriority(String changePriority) throws DataAccessException {

		return findChangerequestByChangePriority(changePriority, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByChangePriority
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Changerequest> findChangerequestByChangePriority(String changePriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findChangerequestByChangePriority", startResult, maxRows, changePriority);
		return new LinkedHashSet<Changerequest>(query.getResultList());
	}

	/**
	 * JPQL Query - findChangerequestByPrimaryKey
	 *
	 */
	@Transactional
	public Changerequest findChangerequestByPrimaryKey(Integer changeId) throws DataAccessException {

		return findChangerequestByPrimaryKey(changeId, -1, -1);
	}

	/**
	 * JPQL Query - findChangerequestByPrimaryKey
	 *
	 */

	@Transactional
	public Changerequest findChangerequestByPrimaryKey(Integer changeId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findChangerequestByPrimaryKey", startResult, maxRows, changeId);
			return (pm7.domain.Changerequest) query.getSingleResult();
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
	public boolean canBeMerged(Changerequest entity) {
		return true;
	}
	
	public Integer getMaxChangeId() {
		Object obj = executeQuerySingleResult("select max(changeId) from Changerequest");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
