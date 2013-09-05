package myinfo.dao;

import java.util.Set;

import myinfo.domain.BudgetAccount;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage BudgetAccount entities.
 * 
 */
public interface BudgetAccountDAO extends JpaDao<BudgetAccount> {

	/**
	 * JPQL Query - findBudgetAccountByNov
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByNov(Integer nov) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByNov
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByNov(Integer nov, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByActiveYn
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByActiveYn
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByDec
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByDec(Integer dec) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByDec
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByDec(Integer dec, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByOct
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByOct(Integer oct) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByOct
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByOct(Integer oct, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByPrimaryKey
	 *
	 */
	public BudgetAccount findBudgetAccountByPrimaryKey(Integer budId) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByPrimaryKey
	 *
	 */
	public BudgetAccount findBudgetAccountByPrimaryKey(Integer budId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByJan
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByJan(Integer jan) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByJan
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByJan(Integer jan, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByApr
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByApr(Integer apr) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByApr
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByApr(Integer apr, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByUserFk
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByUserFk(Integer userFk) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByUserFk
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByAccount
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByAccount(String account) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByAccount
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByAccount(String account, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByBudId
	 *
	 */
	public BudgetAccount findBudgetAccountByBudId(Integer budId_1) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByBudId
	 *
	 */
	public BudgetAccount findBudgetAccountByBudId(Integer budId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByJun
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByJun(Integer jun) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByJun
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByJun(Integer jun, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByBudgetFk
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByBudgetFk(Integer budgetFk) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByBudgetFk
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByBudgetFk(Integer budgetFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByTotal
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByTotal(Integer total) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByTotal
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByTotal(Integer total, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByMar
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByMar(Integer mar) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByMar
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByMar(Integer mar, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByIncExpContaining
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByIncExpContaining(String incExp) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByIncExpContaining
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByIncExpContaining(String incExp, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByAug
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByAug(Integer aug) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByAug
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByAug(Integer aug, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllBudgetAccounts
	 *
	 */
	public Set<BudgetAccount> findAllBudgetAccounts() throws DataAccessException;

	/**
	 * JPQL Query - findAllBudgetAccounts
	 *
	 */
	public Set<BudgetAccount> findAllBudgetAccounts(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByJul
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByJul(Integer jul) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByJul
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByJul(Integer jul, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByFeb
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByFeb(Integer feb) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByFeb
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByFeb(Integer feb, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByAccountContaining
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByAccountContaining(String account_1) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByAccountContaining
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByAccountContaining(String account_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountBySep
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountBySep(Integer sep) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountBySep
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountBySep(Integer sep, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByMay
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByMay(Integer may) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByMay
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByMay(Integer may, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByIncExp
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByIncExp(String incExp_1) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetAccountByIncExp
	 *
	 */
	public Set<BudgetAccount> findBudgetAccountByIncExp(String incExp_1, int startResult, int maxRows) throws DataAccessException;

}