package wsdm.dao;

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

import wsdm.domain.Templatecalendardate;

/**
 * DAO to manage Templatecalendardate entities.
 * 
 */
@Repository("TemplatecalendardateDAO")
@Transactional
public class TemplatecalendardateDAOImpl extends AbstractJpaDao<Templatecalendardate>
		implements TemplatecalendardateDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Templatecalendardate.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TemplatecalendardateDAOImpl
	 *
	 */
	public TemplatecalendardateDAOImpl() {
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
	 * JPQL Query - findTemplatecalendardateByPrimaryKey
	 *
	 */
	@Transactional
	public Templatecalendardate findTemplatecalendardateByPrimaryKey(Integer calDateId) throws DataAccessException {

		return findTemplatecalendardateByPrimaryKey(calDateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatecalendardateByPrimaryKey
	 *
	 */

	@Transactional
	public Templatecalendardate findTemplatecalendardateByPrimaryKey(Integer calDateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatecalendardateByPrimaryKey", startResult, maxRows, calDateId);
			return (wsdm.domain.Templatecalendardate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDailyTemplateFk
	 *
	 */
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDailyTemplateFk(Integer dailyTemplateFk) throws DataAccessException {

		return findTemplatecalendardateByDailyTemplateFk(dailyTemplateFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDailyTemplateFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDailyTemplateFk(Integer dailyTemplateFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatecalendardateByDailyTemplateFk", startResult, maxRows, dailyTemplateFk);
		return new LinkedHashSet<Templatecalendardate>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatecalendardateByCalDateId
	 *
	 */
	@Transactional
	public Templatecalendardate findTemplatecalendardateByCalDateId(Integer calDateId) throws DataAccessException {

		return findTemplatecalendardateByCalDateId(calDateId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatecalendardateByCalDateId
	 *
	 */

	@Transactional
	public Templatecalendardate findTemplatecalendardateByCalDateId(Integer calDateId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatecalendardateByCalDateId", startResult, maxRows, calDateId);
			return (wsdm.domain.Templatecalendardate) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllTemplatecalendardates
	 *
	 */
	@Transactional
	public Set<Templatecalendardate> findAllTemplatecalendardates() throws DataAccessException {

		return findAllTemplatecalendardates(-1, -1);
	}

	/**
	 * JPQL Query - findAllTemplatecalendardates
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatecalendardate> findAllTemplatecalendardates(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTemplatecalendardates", startResult, maxRows);
		return new LinkedHashSet<Templatecalendardate>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDate
	 *
	 */
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDate(java.util.Calendar date) throws DataAccessException {

		return findTemplatecalendardateByDate(date, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDate(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatecalendardateByDate", startResult, maxRows, date);
		return new LinkedHashSet<Templatecalendardate>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDateAfter
	 *
	 */
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDateAfter(java.util.Calendar date) throws DataAccessException {

		return findTemplatecalendardateByDateAfter(date, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDateAfter(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatecalendardateByDateAfter", startResult, maxRows, date);
		return new LinkedHashSet<Templatecalendardate>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatecalendardateByResourceFk
	 *
	 */
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByResourceFk(Integer resourceFk) throws DataAccessException {

		return findTemplatecalendardateByResourceFk(resourceFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatecalendardateByResourceFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByResourceFk(Integer resourceFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatecalendardateByResourceFk", startResult, maxRows, resourceFk);
		return new LinkedHashSet<Templatecalendardate>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDateBefore
	 *
	 */
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDateBefore(java.util.Calendar date) throws DataAccessException {

		return findTemplatecalendardateByDateBefore(date, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatecalendardateByDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatecalendardate> findTemplatecalendardateByDateBefore(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatecalendardateByDateBefore", startResult, maxRows, date);
		return new LinkedHashSet<Templatecalendardate>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Templatecalendardate entity) {
		return true;
	}
}
