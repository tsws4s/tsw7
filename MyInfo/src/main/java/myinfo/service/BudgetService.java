package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.Budget;

/**
 * Spring service that handles CRUD requests for Budget entities
 * 
 */
public interface BudgetService {

	/**
	 * Return all Budget entity
	 * 
	 */
	public List<Budget> findAllBudgets(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Budget entity
	 * 
	 */
	public void saveBudget(Budget budget);

	/**
	 * Return a count of all Budget entity
	 * 
	 */
	public Integer countBudgets();

	/**
	 * Delete an existing Budget entity
	 * 
	 */
	public void deleteBudget(Budget budget_1);

	/**
	 */
	public Budget findBudgetByPrimaryKey(Integer budgetId);

	/**
	 * Load an existing Budget entity
	 * 
	 */
	public Set<Budget> loadBudgets();
}