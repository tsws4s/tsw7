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

import pm7.domain.Defect;

/**
 * DAO to manage Defect entities.
 * 
 */
@Repository("DefectDAO")
@Transactional
public class DefectDAOImpl extends AbstractJpaDao<Defect> implements DefectDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Defect.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new DefectDAOImpl
	 *
	 */
	public DefectDAOImpl() {
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
	 * JPQL Query - findDefectByDefectDescriptinContaining
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByDefectDescriptinContaining(String defectDescriptin) throws DataAccessException {

		return findDefectByDefectDescriptinContaining(defectDescriptin, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByDefectDescriptinContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByDefectDescriptinContaining(String defectDescriptin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByDefectDescriptinContaining", startResult, maxRows, defectDescriptin);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByDefectName
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByDefectName(String defectName) throws DataAccessException {

		return findDefectByDefectName(defectName, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByDefectName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByDefectName(String defectName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByDefectName", startResult, maxRows, defectName);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByDefectId
	 *
	 */
	@Transactional
	public Defect findDefectByDefectId(Integer defectId) throws DataAccessException {

		return findDefectByDefectId(defectId, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByDefectId
	 *
	 */

	@Transactional
	public Defect findDefectByDefectId(Integer defectId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDefectByDefectId", startResult, maxRows, defectId);
			return (pm7.domain.Defect) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllDefects
	 *
	 */
	@Transactional
	public Set<Defect> findAllDefects() throws DataAccessException {

		return findAllDefects(-1, -1);
	}

	/**
	 * JPQL Query - findAllDefects
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findAllDefects(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllDefects", startResult, maxRows);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByDefectNameContaining
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByDefectNameContaining(String defectName) throws DataAccessException {

		return findDefectByDefectNameContaining(defectName, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByDefectNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByDefectNameContaining(String defectName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByDefectNameContaining", startResult, maxRows, defectName);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByDefectPriority
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByDefectPriority(String defectPriority) throws DataAccessException {

		return findDefectByDefectPriority(defectPriority, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByDefectPriority
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByDefectPriority(String defectPriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByDefectPriority", startResult, maxRows, defectPriority);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByStatusContaining
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByStatusContaining(String status) throws DataAccessException {

		return findDefectByStatusContaining(status, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByStatusContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByStatusContaining", startResult, maxRows, status);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByDefectPriorityContaining
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByDefectPriorityContaining(String defectPriority) throws DataAccessException {

		return findDefectByDefectPriorityContaining(defectPriority, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByDefectPriorityContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByDefectPriorityContaining(String defectPriority, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByDefectPriorityContaining", startResult, maxRows, defectPriority);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByDefectDescriptin
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByDefectDescriptin(String defectDescriptin) throws DataAccessException {

		return findDefectByDefectDescriptin(defectDescriptin, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByDefectDescriptin
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByDefectDescriptin(String defectDescriptin, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByDefectDescriptin", startResult, maxRows, defectDescriptin);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * JPQL Query - findDefectByPrimaryKey
	 *
	 */
	@Transactional
	public Defect findDefectByPrimaryKey(Integer defectId) throws DataAccessException {

		return findDefectByPrimaryKey(defectId, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByPrimaryKey
	 *
	 */

	@Transactional
	public Defect findDefectByPrimaryKey(Integer defectId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findDefectByPrimaryKey", startResult, maxRows, defectId);
			return (pm7.domain.Defect) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findDefectByStatus
	 *
	 */
	@Transactional
	public Set<Defect> findDefectByStatus(String status) throws DataAccessException {

		return findDefectByStatus(status, -1, -1);
	}

	/**
	 * JPQL Query - findDefectByStatus
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Defect> findDefectByStatus(String status, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findDefectByStatus", startResult, maxRows, status);
		return new LinkedHashSet<Defect>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Defect entity) {
		return true;
	}
	
	public Integer getMaxDefectId() {
		Object obj = executeQuerySingleResult("select max(defectId) from Defect");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
