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

import wsdm.domain.Templatetimeslot;

/**
 * DAO to manage Templatetimeslot entities.
 * 
 */
@Repository("TemplatetimeslotDAO")
@Transactional
public class TemplatetimeslotDAOImpl extends AbstractJpaDao<Templatetimeslot>
		implements TemplatetimeslotDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Templatetimeslot.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TemplatetimeslotDAOImpl
	 *
	 */
	public TemplatetimeslotDAOImpl() {
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
	 * JPQL Query - findTemplatetimeslotByPriceFk
	 *
	 */
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByPriceFk(Integer priceFk) throws DataAccessException {

		return findTemplatetimeslotByPriceFk(priceFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatetimeslotByPriceFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByPriceFk(Integer priceFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatetimeslotByPriceFk", startResult, maxRows, priceFk);
		return new LinkedHashSet<Templatetimeslot>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatetimeslotByStartTime
	 *
	 */
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByStartTime(java.util.Calendar startTime) throws DataAccessException {

		return findTemplatetimeslotByStartTime(startTime, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatetimeslotByStartTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByStartTime(java.util.Calendar startTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatetimeslotByStartTime", startResult, maxRows, startTime);
		return new LinkedHashSet<Templatetimeslot>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTemplatetimeslots
	 *
	 */
	@Transactional
	public Set<Templatetimeslot> findAllTemplatetimeslots() throws DataAccessException {

		return findAllTemplatetimeslots(-1, -1);
	}

	/**
	 * JPQL Query - findAllTemplatetimeslots
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatetimeslot> findAllTemplatetimeslots(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTemplatetimeslots", startResult, maxRows);
		return new LinkedHashSet<Templatetimeslot>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatetimeslotBySlotNum
	 *
	 */
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotBySlotNum(Integer slotNum) throws DataAccessException {

		return findTemplatetimeslotBySlotNum(slotNum, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatetimeslotBySlotNum
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotBySlotNum(Integer slotNum, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatetimeslotBySlotNum", startResult, maxRows, slotNum);
		return new LinkedHashSet<Templatetimeslot>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatetimeslotByDailyTemplateFk
	 *
	 */
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByDailyTemplateFk(Integer dailyTemplateFk) throws DataAccessException {

		return findTemplatetimeslotByDailyTemplateFk(dailyTemplateFk, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatetimeslotByDailyTemplateFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByDailyTemplateFk(Integer dailyTemplateFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatetimeslotByDailyTemplateFk", startResult, maxRows, dailyTemplateFk);
		return new LinkedHashSet<Templatetimeslot>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatetimeslotByTimeSlotId
	 *
	 */
	@Transactional
	public Templatetimeslot findTemplatetimeslotByTimeSlotId(Integer timeSlotId) throws DataAccessException {

		return findTemplatetimeslotByTimeSlotId(timeSlotId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatetimeslotByTimeSlotId
	 *
	 */

	@Transactional
	public Templatetimeslot findTemplatetimeslotByTimeSlotId(Integer timeSlotId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatetimeslotByTimeSlotId", startResult, maxRows, timeSlotId);
			return (wsdm.domain.Templatetimeslot) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTemplatetimeslotByEndTime
	 *
	 */
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByEndTime(java.util.Calendar endTime) throws DataAccessException {

		return findTemplatetimeslotByEndTime(endTime, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatetimeslotByEndTime
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Templatetimeslot> findTemplatetimeslotByEndTime(java.util.Calendar endTime, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTemplatetimeslotByEndTime", startResult, maxRows, endTime);
		return new LinkedHashSet<Templatetimeslot>(query.getResultList());
	}

	/**
	 * JPQL Query - findTemplatetimeslotByPrimaryKey
	 *
	 */
	@Transactional
	public Templatetimeslot findTemplatetimeslotByPrimaryKey(Integer timeSlotId) throws DataAccessException {

		return findTemplatetimeslotByPrimaryKey(timeSlotId, -1, -1);
	}

	/**
	 * JPQL Query - findTemplatetimeslotByPrimaryKey
	 *
	 */

	@Transactional
	public Templatetimeslot findTemplatetimeslotByPrimaryKey(Integer timeSlotId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTemplatetimeslotByPrimaryKey", startResult, maxRows, timeSlotId);
			return (wsdm.domain.Templatetimeslot) query.getSingleResult();
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
	public boolean canBeMerged(Templatetimeslot entity) {
		return true;
	}
}
