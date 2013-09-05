package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;

import pm7.domain.Person;


/**
 * Spring service that handles CRUD requests for Account entities
 * 
 */
public interface AccountService {
	/**
	 * Return all Account entity
	 * 
	 */
	public List<Account> findAllAccounts(Integer startResult, Integer maxRows);

	/**
	 * Load an existing Account entity
	 * 
	 */
	public Set<Account> loadAccounts();


	/**
	 * Save an existing Account entity
	 * 
	 */
	public Account saveAccount(Account account, Integer personId);
	/**
	 * Save an existing Person entity
	 * 
	 */
	public Account saveAccountPersons(Integer accountId_7, Person related_persons);
	/**
	 * Return a count of all Account entity
	 * 
	 */
	public Integer countAccounts();

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public void deleteAccount(Account account_1);

	/**
	 * Save an existing Person entity
	 * 
	 */
	public Account saveAccountPerson(Integer accountId_16, Person related_person);

	/**
	 */
	public Account findAccountByPrimaryKey(Integer accountId_17);

}