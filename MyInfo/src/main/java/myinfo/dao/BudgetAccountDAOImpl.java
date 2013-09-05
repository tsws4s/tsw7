package myinfo.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import myinfo.domain.BudgetAccount;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage BudgetAccount entities.
 * 
 */
@Repository("BudgetAccountDAO")
@Transactional
public class BudgetAccountDAOImpl extends AbstractJpaDao<BudgetAccount>
		implements BudgetAccountDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { BudgetAccount.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySQL_myInfo
	 *
	 */
	@PersistenceContext(unitName = "mySQL_myInfo")
	private EntityManager entityManager;

	/**
	 * Instantiates a new BudgetAccountDAOImpl
	 *
	 */
	public BudgetAccountDAOImpl() {
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
	 * JPQL Query - findBudgetAccountByNov
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByNov(Integer nov) throws DataAccessException {

		return findBudgetAccountByNov(nov, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByNov
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByNov(Integer nov, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByNov", startResult, maxRows, nov);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByActiveYn
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByActiveYn(Integer activeYn) throws DataAccessException {

		return findBudgetAccountByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByDec
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByDec(Integer dec) throws DataAccessException {

		return findBudgetAccountByDec(dec, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByDec
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByDec(Integer dec, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByDec", startResult, maxRows, dec);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByOct
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByOct(Integer oct) throws DataAccessException {

		return findBudgetAccountByOct(oct, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByOct
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByOct(Integer oct, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByOct", startResult, maxRows, oct);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByPrimaryKey
	 *
	 */
	@Transactional
	public BudgetAccount findBudgetAccountByPrimaryKey(Integer budId) throws DataAccessException {

		return findBudgetAccountByPrimaryKey(budId, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByPrimaryKey
	 *
	 */

	@Transactional
	public BudgetAccount findBudgetAccountByPrimaryKey(Integer budId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findBudgetAccountByPrimaryKey", startResult, maxRows, budId);
			return (myinfo.domain.BudgetAccount) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findBudgetAccountByJan
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByJan(Integer jan) throws DataAccessException {

		return findBudgetAccountByJan(jan, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByJan
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByJan(Integer jan, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByJan", startResult, maxRows, jan);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByApr
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByApr(Integer apr) throws DataAccessException {

		return findBudgetAccountByApr(apr, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByApr
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByApr(Integer apr, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByApr", startResult, maxRows, apr);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByUserFk
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByUserFk(Integer userFk) throws DataAccessException {

		return findBudgetAccountByUserFk(userFk, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByUserFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByUserFk", startResult, maxRows, userFk);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByAccount
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByAccount(String account) throws DataAccessException {

		return findBudgetAccountByAccount(account, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByAccount
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByAccount(String account, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByAccount", startResult, maxRows, account);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByBudId
	 *
	 */
	@Transactional
	public BudgetAccount findBudgetAccountByBudId(Integer budId) throws DataAccessException {

		return findBudgetAccountByBudId(budId, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByBudId
	 *
	 */

	@Transactional
	public BudgetAccount findBudgetAccountByBudId(Integer budId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findBudgetAccountByBudId", startResult, maxRows, budId);
			return (myinfo.domain.BudgetAccount) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findBudgetAccountByJun
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByJun(Integer jun) throws DataAccessException {

		return findBudgetAccountByJun(jun, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByJun
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByJun(Integer jun, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByJun", startResult, maxRows, jun);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByBudgetFk
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByBudgetFk(Integer budgetFk) throws DataAccessException {

		return findBudgetAccountByBudgetFk(budgetFk, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByBudgetFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByBudgetFk(Integer budgetFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByBudgetFk", startResult, maxRows, budgetFk);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByTotal
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByTotal(Integer total) throws DataAccessException {

		return findBudgetAccountByTotal(total, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByTotal
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByTotal(Integer total, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByTotal", startResult, maxRows, total);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByMar
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByMar(Integer mar) throws DataAccessException {

		return findBudgetAccountByMar(mar, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByMar
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByMar(Integer mar, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByMar", startResult, maxRows, mar);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByIncExpContaining
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByIncExpContaining(String incExp) throws DataAccessException {

		return findBudgetAccountByIncExpContaining(incExp, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByIncExpContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByIncExpContaining(String incExp, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByIncExpContaining", startResult, maxRows, incExp);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByAug
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByAug(Integer aug) throws DataAccessException {

		return findBudgetAccountByAug(aug, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByAug
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByAug(Integer aug, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByAug", startResult, maxRows, aug);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllBudgetAccounts
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findAllBudgetAccounts() throws DataAccessException {

		return findAllBudgetAccounts(-1, -1);
	}

	/**
	 * JPQL Query - findAllBudgetAccounts
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findAllBudgetAccounts(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllBudgetAccounts", startResult, maxRows);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByJul
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByJul(Integer jul) throws DataAccessException {

		return findBudgetAccountByJul(jul, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByJul
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByJul(Integer jul, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByJul", startResult, maxRows, jul);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByFeb
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByFeb(Integer feb) throws DataAccessException {

		return findBudgetAccountByFeb(feb, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByFeb
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByFeb(Integer feb, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByFeb", startResult, maxRows, feb);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByAccountContaining
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByAccountContaining(String account) throws DataAccessException {

		return findBudgetAccountByAccountContaining(account, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByAccountContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByAccountContaining(String account, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByAccountContaining", startResult, maxRows, account);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountBySep
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountBySep(Integer sep) throws DataAccessException {

		return findBudgetAccountBySep(sep, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountBySep
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountBySep(Integer sep, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountBySep", startResult, maxRows, sep);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByMay
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByMay(Integer may) throws DataAccessException {

		return findBudgetAccountByMay(may, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByMay
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByMay(Integer may, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByMay", startResult, maxRows, may);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * JPQL Query - findBudgetAccountByIncExp
	 *
	 */
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByIncExp(String incExp) throws DataAccessException {

		return findBudgetAccountByIncExp(incExp, -1, -1);
	}

	/**
	 * JPQL Query - findBudgetAccountByIncExp
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<BudgetAccount> findBudgetAccountByIncExp(String incExp, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findBudgetAccountByIncExp", startResult, maxRows, incExp);
		return new LinkedHashSet<BudgetAccount>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(BudgetAccount entity) {
		return true;
	}
}
