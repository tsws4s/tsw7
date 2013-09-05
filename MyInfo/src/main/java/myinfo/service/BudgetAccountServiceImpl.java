//**********************************************************
// BudgetAccountServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 03/04/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.dao.BudgetAccountDAO;

import myinfo.domain.BudgetAccount;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for BudgetAccount entities
 * 
 */

@Service("BudgetAccountService")
@Transactional
public class BudgetAccountServiceImpl implements BudgetAccountService {

	/**
	 * DAO injected by Spring that manages BudgetAccount entities
	 * 
	 */
	@Autowired
	private BudgetAccountDAO budgetAccountDAO;

	/**
	 * Instantiates a new BudgetAccountServiceImpl.
	 *
	 */
	public BudgetAccountServiceImpl() {
	}

	/**
	 * Return all BudgetAccount entity
	 * 
	 */
	@Transactional
	public List<BudgetAccount> findAllBudgetAccounts(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<BudgetAccount>(budgetAccountDAO.findAllBudgetAccounts(startResult, maxRows));
	}

	/**
	 * Return a count of all BudgetAccount entity
	 * 
	 */
	@Transactional
	public Integer countBudgetAccounts() {
		return ((Long) budgetAccountDAO.createQuerySingleResult("select count(o) from BudgetAccount o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing BudgetAccount entity
	 * 
	 */
	@Transactional
	public void saveBudgetAccount(BudgetAccount budgetaccount) {
		BudgetAccount existingBudgetAccount = budgetAccountDAO.findBudgetAccountByPrimaryKey(budgetaccount.getBudId());

		if (existingBudgetAccount != null) {
			if (existingBudgetAccount != budgetaccount) {
				existingBudgetAccount.setBudId(budgetaccount.getBudId());
				existingBudgetAccount.setAccount(budgetaccount.getAccount());
				existingBudgetAccount.setIncExp(budgetaccount.getIncExp());
				existingBudgetAccount.setBudgetFk(budgetaccount.getBudgetFk());
				existingBudgetAccount.setJan(budgetaccount.getJan());
				existingBudgetAccount.setFeb(budgetaccount.getFeb());
				existingBudgetAccount.setMar(budgetaccount.getMar());
				existingBudgetAccount.setApr(budgetaccount.getApr());
				existingBudgetAccount.setMay(budgetaccount.getMay());
				existingBudgetAccount.setJun(budgetaccount.getJun());
				existingBudgetAccount.setJul(budgetaccount.getJul());
				existingBudgetAccount.setAug(budgetaccount.getAug());
				existingBudgetAccount.setSep(budgetaccount.getSep());
				existingBudgetAccount.setOct(budgetaccount.getOct());
				existingBudgetAccount.setNov(budgetaccount.getNov());
				existingBudgetAccount.setDec(budgetaccount.getDec());
				existingBudgetAccount.setTotal(budgetaccount.getTotal());
				existingBudgetAccount.setActiveYn(budgetaccount.getActiveYn());
				existingBudgetAccount.setUserFk(budgetaccount.getUserFk());
			}
			budgetaccount = budgetAccountDAO.store(existingBudgetAccount);
		} else {
			budgetaccount = budgetAccountDAO.store(budgetaccount);
		}
		budgetAccountDAO.flush();
	}

	/**
	 * Load an existing BudgetAccount entity
	 * 
	 */
	@Transactional
	public Set<BudgetAccount> loadBudgetAccounts() {
		return budgetAccountDAO.findAllBudgetAccounts();
	}

	/**
	 * Delete an existing BudgetAccount entity
	 * 
	 */
	@Transactional
	public void deleteBudgetAccount(BudgetAccount budgetaccount) {
		budgetAccountDAO.remove(budgetaccount);
		budgetAccountDAO.flush();
	}

	/**
	 */
	@Transactional
	public BudgetAccount findBudgetAccountByPrimaryKey(Integer budId) {
		return budgetAccountDAO.findBudgetAccountByPrimaryKey(budId);
	}
}
