package timeslot.dao;

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

import timeslot.domain.Timeslotstst;

/**
 * DAO to manage Timeslotstst entities.
 * 
 */
@Repository("TimeslotststDAO")
@Transactional
public class TimeslotststDAOImpl extends AbstractJpaDao<Timeslotstst> implements
		TimeslotststDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Timeslotstst.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySQL_C324877
	 *
	 */
	@PersistenceContext(unitName = "mySQL_C324877")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TimeslotststDAOImpl
	 *
	 */
	public TimeslotststDAOImpl() {
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
	 * JPQL Query - findTimeslotststByTimeslotId
	 *
	 */
	@Transactional
	public Timeslotstst findTimeslotststByTimeslotId(Integer timeslotId) throws DataAccessException {

		return findTimeslotststByTimeslotId(timeslotId, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByTimeslotId
	 *
	 */

	@Transactional
	public Timeslotstst findTimeslotststByTimeslotId(Integer timeslotId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTimeslotststByTimeslotId", startResult, maxRows, timeslotId);
			return (timeslot.domain.Timeslotstst) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTimeslotststByStart
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByStart(java.util.Calendar start) throws DataAccessException {

		return findTimeslotststByStart(start, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByStart
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByStart(java.util.Calendar start, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByStart", startResult, maxRows, start);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByT3sFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByT3sFk(Integer t3sFk) throws DataAccessException {

		return findTimeslotststByT3sFk(t3sFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByT3sFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByT3sFk(Integer t3sFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByT3sFk", startResult, maxRows, t3sFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByPriceLevelContaining
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByPriceLevelContaining(String priceLevel) throws DataAccessException {

		return findTimeslotststByPriceLevelContaining(priceLevel, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByPriceLevelContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByPriceLevelContaining(String priceLevel, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByPriceLevelContaining", startResult, maxRows, priceLevel);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByModifiedLast
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByModifiedLast(java.util.Calendar modifiedLast) throws DataAccessException {

		return findTimeslotststByModifiedLast(modifiedLast, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByModifiedLast
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByModifiedLast(java.util.Calendar modifiedLast, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByModifiedLast", startResult, maxRows, modifiedLast);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByTimeslot
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByTimeslot(Integer timeslot) throws DataAccessException {

		return findTimeslotststByTimeslot(timeslot, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByTimeslot
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByTimeslot(Integer timeslot, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByTimeslot", startResult, maxRows, timeslot);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByConcessionWkrCustFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByConcessionWkrCustFk(Integer concessionWkrCustFk) throws DataAccessException {

		return findTimeslotststByConcessionWkrCustFk(concessionWkrCustFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByConcessionWkrCustFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByConcessionWkrCustFk(Integer concessionWkrCustFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByConcessionWkrCustFk", startResult, maxRows, concessionWkrCustFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByOfficeWkrCustFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByOfficeWkrCustFk(Integer officeWkrCustFk) throws DataAccessException {

		return findTimeslotststByOfficeWkrCustFk(officeWkrCustFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByOfficeWkrCustFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByOfficeWkrCustFk(Integer officeWkrCustFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByOfficeWkrCustFk", startResult, maxRows, officeWkrCustFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByDateAfter
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByDateAfter(java.util.Calendar date) throws DataAccessException {

		return findTimeslotststByDateAfter(date, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByDateAfter(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByDateAfter", startResult, maxRows, date);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByActiveYn
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByActiveYn(Integer activeYn) throws DataAccessException {

		return findTimeslotststByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByCustFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByCustFk(Integer custFk) throws DataAccessException {

		return findTimeslotststByCustFk(custFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByCustFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByCustFk(Integer custFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByCustFk", startResult, maxRows, custFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByEnd
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByEnd(java.util.Calendar end) throws DataAccessException {

		return findTimeslotststByEnd(end, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByEnd
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByEnd(java.util.Calendar end, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByEnd", startResult, maxRows, end);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByCustDisplay
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByCustDisplay(String custDisplay) throws DataAccessException {

		return findTimeslotststByCustDisplay(custDisplay, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByCustDisplay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByCustDisplay(String custDisplay, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByCustDisplay", startResult, maxRows, custDisplay);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTimeslotststs
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findAllTimeslotststs() throws DataAccessException {

		return findAllTimeslotststs(-1, -1);
	}

	/**
	 * JPQL Query - findAllTimeslotststs
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findAllTimeslotststs(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTimeslotststs", startResult, maxRows);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByBelongsToResId
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByBelongsToResId(Integer belongsToResId) throws DataAccessException {

		return findTimeslotststByBelongsToResId(belongsToResId, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByBelongsToResId
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByBelongsToResId(Integer belongsToResId, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByBelongsToResId", startResult, maxRows, belongsToResId);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByProgramFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByProgramFk(Integer programFk) throws DataAccessException {

		return findTimeslotststByProgramFk(programFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByProgramFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByProgramFk(Integer programFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByProgramFk", startResult, maxRows, programFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByPrimaryKey
	 *
	 */
	@Transactional
	public Timeslotstst findTimeslotststByPrimaryKey(Integer timeslotId) throws DataAccessException {

		return findTimeslotststByPrimaryKey(timeslotId, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByPrimaryKey
	 *
	 */

	@Transactional
	public Timeslotstst findTimeslotststByPrimaryKey(Integer timeslotId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTimeslotststByPrimaryKey", startResult, maxRows, timeslotId);
			return (timeslot.domain.Timeslotstst) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTimeslotststByCustDisplayContaining
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByCustDisplayContaining(String custDisplay) throws DataAccessException {

		return findTimeslotststByCustDisplayContaining(custDisplay, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByCustDisplayContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByCustDisplayContaining(String custDisplay, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByCustDisplayContaining", startResult, maxRows, custDisplay);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByPriceLevel
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByPriceLevel(String priceLevel) throws DataAccessException {

		return findTimeslotststByPriceLevel(priceLevel, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByPriceLevel
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByPriceLevel(String priceLevel, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByPriceLevel", startResult, maxRows, priceLevel);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByDateBefore
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByDateBefore(java.util.Calendar date) throws DataAccessException {

		return findTimeslotststByDateBefore(date, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByDateBefore(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByDateBefore", startResult, maxRows, date);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByGameFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByGameFk(Integer gameFk) throws DataAccessException {

		return findTimeslotststByGameFk(gameFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByGameFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByGameFk(Integer gameFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByGameFk", startResult, maxRows, gameFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByModifiedByUserFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByModifiedByUserFk(Integer modifiedByUserFk) throws DataAccessException {

		return findTimeslotststByModifiedByUserFk(modifiedByUserFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByModifiedByUserFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByModifiedByUserFk(Integer modifiedByUserFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByModifiedByUserFk", startResult, maxRows, modifiedByUserFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByZamOperatorCustFk
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByZamOperatorCustFk(Integer zamOperatorCustFk) throws DataAccessException {

		return findTimeslotststByZamOperatorCustFk(zamOperatorCustFk, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByZamOperatorCustFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByZamOperatorCustFk(Integer zamOperatorCustFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByZamOperatorCustFk", startResult, maxRows, zamOperatorCustFk);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * JPQL Query - findTimeslotststByDate
	 *
	 */
	@Transactional
	public Set<Timeslotstst> findTimeslotststByDate(java.util.Calendar date) throws DataAccessException {

		return findTimeslotststByDate(date, -1, -1);
	}

	/**
	 * JPQL Query - findTimeslotststByDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Timeslotstst> findTimeslotststByDate(java.util.Calendar date, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTimeslotststByDate", startResult, maxRows, date);
		return new LinkedHashSet<Timeslotstst>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Timeslotstst entity) {
		return true;
	}
}
