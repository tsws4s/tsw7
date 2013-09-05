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

import pm7.domain.Account;

/**
 * DAO to manage Account entities.
 * 
 */
@Repository("AccountDAO")
@Transactional
public class AccountDAOImpl extends AbstractJpaDao<Account> implements
		AccountDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Account.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySql_pm7
	 *
	 */
	@PersistenceContext(unitName = "mySql_pm7")
	private EntityManager entityManager;

	/**
	 * Instantiates a new AccountDAOImpl
	 *
	 */
	public AccountDAOImpl() {
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
	 * JPQL Query - findAccountByExpireDate
	 *
	 */
	@Transactional
	public Set<Account> findAccountByExpireDate(java.util.Calendar expireDate) throws DataAccessException {

		return findAccountByExpireDate(expireDate, -1, -1);
	}

	/**
	 * JPQL Query - findAccountByExpireDate
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Account> findAccountByExpireDate(java.util.Calendar expireDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAccountByExpireDate", startResult, maxRows, expireDate);
		return new LinkedHashSet<Account>(query.getResultList());
	}

	/**
	 * JPQL Query - findAccountByExpireDateBefore
	 *
	 */
	@Transactional
	public Set<Account> findAccountByExpireDateBefore(java.util.Calendar expireDate) throws DataAccessException {

		return findAccountByExpireDateBefore(expireDate, -1, -1);
	}

	/**
	 * JPQL Query - findAccountByExpireDateBefore
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Account> findAccountByExpireDateBefore(java.util.Calendar expireDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAccountByExpireDateBefore", startResult, maxRows, expireDate);
		return new LinkedHashSet<Account>(query.getResultList());
	}

	/**
	 * JPQL Query - findAccountByExpireDateAfter
	 *
	 */
	@Transactional
	public Set<Account> findAccountByExpireDateAfter(java.util.Calendar expireDate) throws DataAccessException {

		return findAccountByExpireDateAfter(expireDate, -1, -1);
	}

	/**
	 * JPQL Query - findAccountByExpireDateAfter
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Account> findAccountByExpireDateAfter(java.util.Calendar expireDate, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAccountByExpireDateAfter", startResult, maxRows, expireDate);
		return new LinkedHashSet<Account>(query.getResultList());
	}

	/**
	 * JPQL Query - findAccountByAccountId
	 *
	 */
	@Transactional
	public Account findAccountByAccountId(Integer accountId) throws DataAccessException {

		return findAccountByAccountId(accountId, -1, -1);
	}

	/**
	 * JPQL Query - findAccountByAccountId
	 *
	 */

	@Transactional
	public Account findAccountByAccountId(Integer accountId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAccountByAccountId", startResult, maxRows, accountId);
			return (pm7.domain.Account) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAccountByPrimaryKey
	 *
	 */
	@Transactional
	public Account findAccountByPrimaryKey(Integer accountId) throws DataAccessException {

		return findAccountByPrimaryKey(accountId, -1, -1);
	}

	/**
	 * JPQL Query - findAccountByPrimaryKey
	 *
	 */

	@Transactional
	public Account findAccountByPrimaryKey(Integer accountId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findAccountByPrimaryKey", startResult, maxRows, accountId);
			return (pm7.domain.Account) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findAllAccounts
	 *
	 */
	@Transactional
	public Set<Account> findAllAccounts() throws DataAccessException {

		return findAllAccounts(-1, -1);
	}

	/**
	 * JPQL Query - findAllAccounts
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Account> findAllAccounts(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllAccounts", startResult, maxRows);
		return new LinkedHashSet<Account>(query.getResultList());
	}

	/**
	 * JPQL Query - findAccountByAccountNameContaining
	 *
	 */
	@Transactional
	public Set<Account> findAccountByAccountNameContaining(String accountName) throws DataAccessException {

		return findAccountByAccountNameContaining(accountName, -1, -1);
	}

	/**
	 * JPQL Query - findAccountByAccountNameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Account> findAccountByAccountNameContaining(String accountName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAccountByAccountNameContaining", startResult, maxRows, accountName);
		return new LinkedHashSet<Account>(query.getResultList());
	}

	/**
	 * JPQL Query - findAccountByAccountName
	 *
	 */
	@Transactional
	public Set<Account> findAccountByAccountName(String accountName) throws DataAccessException {

		return findAccountByAccountName(accountName, -1, -1);
	}

	/**
	 * JPQL Query - findAccountByAccountName
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Account> findAccountByAccountName(String accountName, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAccountByAccountName", startResult, maxRows, accountName);
		return new LinkedHashSet<Account>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Account entity) {
		return true;
	}
	
	public Integer getMaxAccountId() {
		Object obj = executeQuerySingleResult("select max(accountId) from Account");
		if(obj!=null){
			return (Integer)obj;
		}
		return 0;
	}
}
