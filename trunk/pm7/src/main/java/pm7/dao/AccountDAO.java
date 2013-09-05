package pm7.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Account;

/**
 * DAO to manage Account entities.
 * 
 */
public interface AccountDAO extends JpaDao<Account> {

	/**
	 * JPQL Query - findAccountByExpireDate
	 *
	 */
	public Set<Account> findAccountByExpireDate(java.util.Calendar expireDate) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByExpireDate
	 *
	 */
	public Set<Account> findAccountByExpireDate(Calendar expireDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByExpireDateBefore
	 *
	 */
	public Set<Account> findAccountByExpireDateBefore(java.util.Calendar expireDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByExpireDateBefore
	 *
	 */
	public Set<Account> findAccountByExpireDateBefore(Calendar expireDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByExpireDateAfter
	 *
	 */
	public Set<Account> findAccountByExpireDateAfter(java.util.Calendar expireDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByExpireDateAfter
	 *
	 */
	public Set<Account> findAccountByExpireDateAfter(Calendar expireDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByAccountId
	 *
	 */
	public Account findAccountByAccountId(Integer accountId) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByAccountId
	 *
	 */
	public Account findAccountByAccountId(Integer accountId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByPrimaryKey
	 *
	 */
	public Account findAccountByPrimaryKey(Integer accountId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByPrimaryKey
	 *
	 */
	public Account findAccountByPrimaryKey(Integer accountId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAccounts
	 *
	 */
	public Set<Account> findAllAccounts() throws DataAccessException;

	/**
	 * JPQL Query - findAllAccounts
	 *
	 */
	public Set<Account> findAllAccounts(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByAccountNameContaining
	 *
	 */
	public Set<Account> findAccountByAccountNameContaining(String accountName) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByAccountNameContaining
	 *
	 */
	public Set<Account> findAccountByAccountNameContaining(String accountName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByAccountName
	 *
	 */
	public Set<Account> findAccountByAccountName(String accountName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAccountByAccountName
	 *
	 */
	public Set<Account> findAccountByAccountName(String accountName_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxAccountId();
}