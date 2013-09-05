//**********************************************************
// AccountServiceImpl
// 
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package pm7.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import pm7.dao.AccountDAO;
import pm7.dao.PersonDAO;

import pm7.domain.Account;
import pm7.domain.Person;


/**
 * Spring service that handles CRUD requests for Account entities
 * 
 */

@Service("AccountService")
@Transactional
public class AccountServiceImpl implements AccountService {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;
	/**
	 * DAO injected by Spring that manages Person entities
	 * 
	 */
	@Autowired
	private PersonDAO personDAO;

	/**
	 * Instantiates a new AccountServiceImpl.
	 *
	 */
	public AccountServiceImpl() {
	}

	/**
	 * Return all Account entity
	 * 
	 */
	@Transactional
	public List<Account> findAllAccounts(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Account>(accountDAO.findAllAccounts(startResult, maxRows));
	}

	/**
	 * Load an existing Account entity
	 * 
	 */
	@Transactional
	public Set<Account> loadAccounts() {
		return accountDAO.findAllAccounts();
	}
	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Account saveAccount(Account account, Integer personId) {
		Account existingAccount = accountDAO.findAccountByPrimaryKey(account.getAccountId());

		if (existingAccount != null) {
			if (existingAccount != account) {
				existingAccount.setAccountId(account.getAccountId());
				existingAccount.setAccountName(account.getAccountName());
				existingAccount.setExpireDate(account.getExpireDate());
			}
			account = existingAccount;
	} else {
		int accountId = accountDAO.getMaxAccountId();
		account.setAccountId(accountId+1);
	}
		if(personId!=null && personId>0){
			account.setPerson(personDAO.findPersonByPersonId(personId));
		}
		account = accountDAO.store(account);
		accountDAO.flush();
	
	return account;
		
	}

	/**
	 * Return a count of all Account entity
	 * 
	 */
	@Transactional
	public Integer countAccounts() {
		return ((Long) accountDAO.createQuerySingleResult("select count(o) from Account o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public void deleteAccount(Account account) {
		accountDAO.remove(account);
		accountDAO.flush();
	}
	/*
	 * Save an existing Person entity
	 * 
	 */
	@Transactional
	public Account saveAccountPerson(Integer accountId, Person related_person) {
		Account account = accountDAO.findAccountByPrimaryKey(accountId, -1, -1);
		Person existingperson = personDAO.findPersonByPrimaryKey(related_person.getPersonId());

		// copy into the existing record to preserve existing relationships
		if (existingperson != null) {
			existingperson.setPersonId(related_person.getPersonId());
			existingperson.setFirstname(related_person.getFirstname());
			existingperson.setLastname(related_person.getLastname());
			existingperson.setPhone(related_person.getPhone());
			existingperson.setEmail(related_person.getEmail());
			existingperson.setDefaultProjectRole(related_person.getDefaultProjectRole());
			existingperson.setAddress(related_person.getAddress());
			existingperson.setCity(related_person.getCity());
			existingperson.setState(related_person.getState());
			existingperson.setZip(related_person.getZip());
			existingperson.setActiveYn(related_person.getActiveYn());
			related_person = existingperson;
		}

		account.setPerson(related_person);
		related_person.getAccounts().add(account);
		account = accountDAO.store(account);
		accountDAO.flush();

		related_person = personDAO.store(related_person);
		personDAO.flush();

		return account;
	}

	/**
	 */
	@Transactional
	public Account findAccountByPrimaryKey(Integer accountId) {
		return accountDAO.findAccountByPrimaryKey(accountId);
	}

	@Override
	public Account saveAccountPersons(Integer accountId_7, Person related_persons) {
		// TODO Auto-generated method stub
		return null;
	}


}
