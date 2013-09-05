package myinfo.dao;

import java.util.Set;

import myinfo.domain.Budget;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Budget entities.
 * 
 */
public interface BudgetDAO extends JpaDao<Budget> {

	/**
	 * JPQL Query - findBudgetByYear
	 *
	 */
	public Set<Budget> findBudgetByYear(Integer year) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByYear
	 *
	 */
	public Set<Budget> findBudgetByYear(Integer year, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByBudgetId
	 *
	 */
	public Budget findBudgetByBudgetId(Integer budgetId) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByBudgetId
	 *
	 */
	public Budget findBudgetByBudgetId(Integer budgetId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByUserFk
	 *
	 */
	public Set<Budget> findBudgetByUserFk(Integer userFk) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByUserFk
	 *
	 */
	public Set<Budget> findBudgetByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByName
	 *
	 */
	public Set<Budget> findBudgetByName(String name) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByName
	 *
	 */
	public Set<Budget> findBudgetByName(String name, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByActiveYn
	 *
	 */
	public Set<Budget> findBudgetByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByActiveYn
	 *
	 */
	public Set<Budget> findBudgetByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllBudgets
	 *
	 */
	public Set<Budget> findAllBudgets() throws DataAccessException;

	/**
	 * JPQL Query - findAllBudgets
	 *
	 */
	public Set<Budget> findAllBudgets(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByNameContaining
	 *
	 */
	public Set<Budget> findBudgetByNameContaining(String name_1) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByNameContaining
	 *
	 */
	public Set<Budget> findBudgetByNameContaining(String name_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByPrimaryKey
	 *
	 */
	public Budget findBudgetByPrimaryKey(Integer budgetId_1) throws DataAccessException;

	/**
	 * JPQL Query - findBudgetByPrimaryKey
	 *
	 */
	public Budget findBudgetByPrimaryKey(Integer budgetId_1, int startResult, int maxRows) throws DataAccessException;

}