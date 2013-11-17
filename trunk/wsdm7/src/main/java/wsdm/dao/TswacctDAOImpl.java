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

import wsdm.domain.Tswacct;

/**
 * DAO to manage Tswacct entities.
 * 
 */
@Repository("TswacctDAO")
@Transactional
public class TswacctDAOImpl extends AbstractJpaDao<Tswacct> implements
		TswacctDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Tswacct.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new TswacctDAOImpl
	 *
	 */
	public TswacctDAOImpl() {
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
	 * JPQL Query - findTswacctByAmtPaid
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByAmtPaid(java.math.BigDecimal amtPaid) throws DataAccessException {

		return findTswacctByAmtPaid(amtPaid, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByAmtPaid
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByAmtPaid(java.math.BigDecimal amtPaid, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByAmtPaid", startResult, maxRows, amtPaid);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByExpireDateBefore
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByExpireDateBefore(java.util.Calendar expireDate) throws DataAccessException {

		return findTswacctByExpireDateBefore(expireDate, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByExpireDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByExpireDateBefore(java.util.Calendar expireDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByExpireDateBefore", startResult, maxRows, expireDate);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByAcctName
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByAcctName(String acctName) throws DataAccessException {

		return findTswacctByAcctName(acctName, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByAcctName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByAcctName(String acctName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByAcctName", startResult, maxRows, acctName);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByEstablishDateBefore
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByEstablishDateBefore(java.util.Calendar establishDate) throws DataAccessException {

		return findTswacctByEstablishDateBefore(establishDate, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByEstablishDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByEstablishDateBefore(java.util.Calendar establishDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByEstablishDateBefore", startResult, maxRows, establishDate);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByEstablishDate
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByEstablishDate(java.util.Calendar establishDate) throws DataAccessException {

		return findTswacctByEstablishDate(establishDate, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByEstablishDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByEstablishDate(java.util.Calendar establishDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByEstablishDate", startResult, maxRows, establishDate);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByActiveYn
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByActiveYn(Integer activeYn) throws DataAccessException {

		return findTswacctByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByAcctNameContaining
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByAcctNameContaining(String acctName) throws DataAccessException {

		return findTswacctByAcctNameContaining(acctName, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByAcctNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByAcctNameContaining(String acctName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByAcctNameContaining", startResult, maxRows, acctName);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByExpireDateAfter
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByExpireDateAfter(java.util.Calendar expireDate) throws DataAccessException {

		return findTswacctByExpireDateAfter(expireDate, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByExpireDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByExpireDateAfter(java.util.Calendar expireDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByExpireDateAfter", startResult, maxRows, expireDate);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByEstablishDateAfter
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByEstablishDateAfter(java.util.Calendar establishDate) throws DataAccessException {

		return findTswacctByEstablishDateAfter(establishDate, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByEstablishDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByEstablishDateAfter(java.util.Calendar establishDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByEstablishDateAfter", startResult, maxRows, establishDate);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctByTswAcctId
	 *
	 */
	@Transactional
	public Tswacct findTswacctByTswAcctId(Integer tswAcctId) throws DataAccessException {

		return findTswacctByTswAcctId(tswAcctId, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByTswAcctId
	 *
	 */

	@Transactional
	public Tswacct findTswacctByTswAcctId(Integer tswAcctId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTswacctByTswAcctId", startResult, maxRows, tswAcctId);
			return (wsdm.domain.Tswacct) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */
	@Transactional
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId) throws DataAccessException {

		return findTswacctByPrimaryKey(tswAcctId, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByPrimaryKey
	 *
	 */

	@Transactional
	public Tswacct findTswacctByPrimaryKey(Integer tswAcctId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findTswacctByPrimaryKey", startResult, maxRows, tswAcctId);
			return (wsdm.domain.Tswacct) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findTswacctByExpireDate
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctByExpireDate(java.util.Calendar expireDate) throws DataAccessException {

		return findTswacctByExpireDate(expireDate, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctByExpireDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctByExpireDate(java.util.Calendar expireDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctByExpireDate", startResult, maxRows, expireDate);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctBySubscrTypeContaining
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctBySubscrTypeContaining(String subscrType) throws DataAccessException {

		return findTswacctBySubscrTypeContaining(subscrType, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctBySubscrTypeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctBySubscrTypeContaining(String subscrType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctBySubscrTypeContaining", startResult, maxRows, subscrType);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findTswacctBySubscrType
	 *
	 */
	@Transactional
	public Set<Tswacct> findTswacctBySubscrType(String subscrType) throws DataAccessException {

		return findTswacctBySubscrType(subscrType, -1, -1);
	}

	/**
	 * JPQL Query - findTswacctBySubscrType
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findTswacctBySubscrType(String subscrType, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findTswacctBySubscrType", startResult, maxRows, subscrType);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllTswaccts
	 *
	 */
	@Transactional
	public Set<Tswacct> findAllTswaccts() throws DataAccessException {

		return findAllTswaccts(-1, -1);
	}

	/**
	 * JPQL Query - findAllTswaccts
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Tswacct> findAllTswaccts(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllTswaccts", startResult, maxRows);
		return new LinkedHashSet<Tswacct>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Tswacct entity) {
		return true;
	}
}
