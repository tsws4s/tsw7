//**********************************************************
// UserServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 06/22/2013
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
import pm7.dao.UserDAO;

import pm7.domain.Account;
import pm7.domain.User;

/**
 * Spring service that handles CRUD requests for User entities
 * 
 */

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages User entities
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * Instantiates a new UserServiceImpl.
	 *
	 */
	public UserServiceImpl() {
	}

	/**
	 * Return all User entity
	 * 
	 */
	@Transactional
	public List<User> findAllUsers(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<User>(userDAO.findAllUsers(startResult, maxRows));
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public User deleteUserAccount(Integer user_userId, Integer related_account_accountId) {
		User user = userDAO.findUserByPrimaryKey(user_userId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		user.setAccount(null);
		user = userDAO.store(user);
		userDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return user;
	}

	/**
	 * Delete an existing User entity
	 * 
	 */
	@Transactional
	public void deleteUser(User user) {
		userDAO.remove(user);
		userDAO.flush();
	}

	/**
	 * Save an existing User entity
	 * 
	 */
	@Transactional
	public User saveUser(User user) {
		User existingUser = userDAO.findUserByPrimaryKey(user.getUserId());

		if (existingUser != null) {
			if (existingUser != user) {
				existingUser.setUserId(user.getUserId());
				existingUser.setUsername(user.getUsername());
				existingUser.setPassword(user.getPassword());
				existingUser.setActiveYn(user.getActiveYn());
			}
			user = userDAO.store(existingUser);
		} else {
			int userId = userDAO.getMaxUserId();
			user.setUserId(userId+1);
//			person.setAccount(acct);
			user = userDAO.store(user);
		}
//		if(attachmentId!=null && attachmentId>0){
//			attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//		}		
		userDAO.flush();
		return user;
		}

	/**
	 */
	@Transactional
	public User findUserByPrimaryKey(Integer userId) {
		return userDAO.findUserByPrimaryKey(userId);
	}

	/**
	 * Load an existing User entity
	 * 
	 */
	@Transactional
	public Set<User> loadUsers() {
		return userDAO.findAllUsers();
	}

	/**
	 * Return a count of all User entity
	 * 
	 */
	@Transactional
	public Integer countUsers() {
		return ((Long) userDAO.createQuerySingleResult("select count(o) from User o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public User saveUserAccount(Integer userId, Account related_account) {
		User user = userDAO.findUserByPrimaryKey(userId, -1, -1);
		Account existingaccount = accountDAO.findAccountByPrimaryKey(related_account.getAccountId());

		// copy into the existing record to preserve existing relationships
		if (existingaccount != null) {
			existingaccount.setAccountId(related_account.getAccountId());
			existingaccount.setAccountName(related_account.getAccountName());
			existingaccount.setExpireDate(related_account.getExpireDate());
			related_account = existingaccount;
		} else {
			related_account = accountDAO.store(related_account);
			accountDAO.flush();
		}

		user.setAccount(related_account);
		user = userDAO.store(user);
		userDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return user;
	}
}
