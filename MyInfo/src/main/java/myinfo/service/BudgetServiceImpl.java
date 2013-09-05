//**********************************************************
// BudgetServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 03/04/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.dao.BudgetDAO;

import myinfo.domain.Budget;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Budget entities
 * 
 */

@Service("BudgetService")
@Transactional
public class BudgetServiceImpl implements BudgetService {

	/**
	 * DAO injected by Spring that manages Budget entities
	 * 
	 */
	@Autowired
	private BudgetDAO budgetDAO;

	/**
	 * Instantiates a new BudgetServiceImpl.
	 *
	 */
	public BudgetServiceImpl() {
	}

	/**
	 * Return all Budget entity
	 * 
	 */
	@Transactional
	public List<Budget> findAllBudgets(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Budget>(budgetDAO.findAllBudgets(startResult, maxRows));
	}

	/**
	 * Save an existing Budget entity
	 * 
	 */
	@Transactional
	public void saveBudget(Budget budget) {
		Budget existingBudget = budgetDAO.findBudgetByPrimaryKey(budget.getBudgetId());

		if (existingBudget != null) {
			if (existingBudget != budget) {
				existingBudget.setBudgetId(budget.getBudgetId());
				existingBudget.setName(budget.getName());
				existingBudget.setYear(budget.getYear());
				existingBudget.setActiveYn(budget.getActiveYn());
				existingBudget.setUserFk(budget.getUserFk());
			}
			budget = budgetDAO.store(existingBudget);
		} else {
			budget = budgetDAO.store(budget);
		}
		budgetDAO.flush();
	}

	/**
	 * Return a count of all Budget entity
	 * 
	 */
	@Transactional
	public Integer countBudgets() {
		return ((Long) budgetDAO.createQuerySingleResult("select count(o) from Budget o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Budget entity
	 * 
	 */
	@Transactional
	public void deleteBudget(Budget budget) {
		budgetDAO.remove(budget);
		budgetDAO.flush();
	}

	/**
	 */
	@Transactional
	public Budget findBudgetByPrimaryKey(Integer budgetId) {
		return budgetDAO.findBudgetByPrimaryKey(budgetId);
	}

	/**
	 * Load an existing Budget entity
	 * 
	 */
	@Transactional
	public Set<Budget> loadBudgets() {
		return budgetDAO.findAllBudgets();
	}
}
