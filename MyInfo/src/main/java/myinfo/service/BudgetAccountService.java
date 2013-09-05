package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.BudgetAccount;

/**
 * Spring service that handles CRUD requests for BudgetAccount entities
 * 
 */
public interface BudgetAccountService {

	/**
	 * Return all BudgetAccount entity
	 * 
	 */
	public List<BudgetAccount> findAllBudgetAccounts(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all BudgetAccount entity
	 * 
	 */
	public Integer countBudgetAccounts();

	/**
	 * Save an existing BudgetAccount entity
	 * 
	 */
	public void saveBudgetAccount(BudgetAccount budgetaccount);

	/**
	 * Load an existing BudgetAccount entity
	 * 
	 */
	public Set<BudgetAccount> loadBudgetAccounts();

	/**
	 * Delete an existing BudgetAccount entity
	 * 
	 */
	public void deleteBudgetAccount(BudgetAccount budgetaccount_1);

	/**
	 */
	public BudgetAccount findBudgetAccountByPrimaryKey(Integer budId);
}