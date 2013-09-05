package myinfo.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import myinfo.domain.MyCategory;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage MyCategory entities.
 * 
 */
@Repository("MyCategoryDAO")
@Transactional
public class MyCategoryDAOImpl extends AbstractJpaDao<MyCategory> implements
		MyCategoryDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { MyCategory.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySQL_myInfo
	 *
	 */
	@PersistenceContext(unitName = "mySQL_myInfo")
	private EntityManager entityManager;

	/**
	 * Instantiates a new MyCategoryDAOImpl
	 *
	 */
	public MyCategoryDAOImpl() {
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
	 * JPQL Query - findMyCategoryByCategoryNameContaining
	 *
	 */
	@Transactional
	public Set<MyCategory> findMyCategoryByCategoryNameContaining(String categoryName) throws DataAccessException {

		return findMyCategoryByCategoryNameContaining(categoryName, -1, -1);
	}

	/**
	 * JPQL Query - findMyCategoryByCategoryNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyCategory> findMyCategoryByCategoryNameContaining(String categoryName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyCategoryByCategoryNameContaining", startResult, maxRows, categoryName);
		return new LinkedHashSet<MyCategory>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyCategoryByCategoryName
	 *
	 */
	@Transactional
	public Set<MyCategory> findMyCategoryByCategoryName(String categoryName) throws DataAccessException {

		return findMyCategoryByCategoryName(categoryName, -1, -1);
	}

	/**
	 * JPQL Query - findMyCategoryByCategoryName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyCategory> findMyCategoryByCategoryName(String categoryName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyCategoryByCategoryName", startResult, maxRows, categoryName);
		return new LinkedHashSet<MyCategory>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyCategoryByCategoryId
	 *
	 */
	@Transactional
	public MyCategory findMyCategoryByCategoryId(Integer categoryId) throws DataAccessException {

		return findMyCategoryByCategoryId(categoryId, -1, -1);
	}

	/**
	 * JPQL Query - findMyCategoryByCategoryId
	 *
	 */

	@Transactional
	public MyCategory findMyCategoryByCategoryId(Integer categoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findMyCategoryByCategoryId", startResult, maxRows, categoryId);
			return (myinfo.domain.MyCategory) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findMyCategoryByActive
	 *
	 */
	@Transactional
	public Set<MyCategory> findMyCategoryByActive(Integer active) throws DataAccessException {

		return findMyCategoryByActive(active, -1, -1);
	}

	/**
	 * JPQL Query - findMyCategoryByActive
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyCategory> findMyCategoryByActive(Integer active, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyCategoryByActive", startResult, maxRows, active);
		return new LinkedHashSet<MyCategory>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllMyCategorys
	 *
	 */
	@Transactional
	public Set<MyCategory> findAllMyCategorys() throws DataAccessException {

		return findAllMyCategorys(-1, -1);
	}

	/**
	 * JPQL Query - findAllMyCategorys
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyCategory> findAllMyCategorys(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllMyCategorys", startResult, maxRows);
		return new LinkedHashSet<MyCategory>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyCategoryByPrimaryKey
	 *
	 */
	@Transactional
	public MyCategory findMyCategoryByPrimaryKey(Integer categoryId) throws DataAccessException {

		return findMyCategoryByPrimaryKey(categoryId, -1, -1);
	}

	/**
	 * JPQL Query - findMyCategoryByPrimaryKey
	 *
	 */

	@Transactional
	public MyCategory findMyCategoryByPrimaryKey(Integer categoryId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findMyCategoryByPrimaryKey", startResult, maxRows, categoryId);
			return (myinfo.domain.MyCategory) query.getSingleResult();
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
	public boolean canBeMerged(MyCategory entity) {
		return true;
	}
}
