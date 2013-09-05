//**********************************************************
// UsersServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 03/04/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.dao.UsersDAO;

import myinfo.domain.Users;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for Users entities
 * 
 */

@Service("UsersService")
@Transactional
public class UsersServiceImpl implements UsersService {

	/**
	 * DAO injected by Spring that manages Users entities
	 * 
	 */
	@Autowired
	private UsersDAO usersDAO;

	/**
	 * Instantiates a new UsersServiceImpl.
	 *
	 */
	public UsersServiceImpl() {
	}

	/**
	 * Load an existing Users entity
	 * 
	 */
	@Transactional
	public Set<Users> loadUserss() {
		return usersDAO.findAllUserss();
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@Transactional
	public void saveUsers(Users users) {
		Users existingUsers = usersDAO.findUsersByPrimaryKey(users.getId());

		if (existingUsers != null) {
			if (existingUsers != users) {
				existingUsers.setId(users.getId());
				existingUsers.setEmail(users.getEmail());
				existingUsers.setPassword(users.getPassword());
				existingUsers.setIp(users.getIp());
				existingUsers.setActive(users.getActive());
			}
			users = usersDAO.store(existingUsers);
		} else {
			users = usersDAO.store(users);
		}
		usersDAO.flush();
	}

	/**
	 * Return a count of all Users entity
	 * 
	 */
	@Transactional
	public Integer countUserss() {
		return ((Long) usersDAO.createQuerySingleResult("select count(o) from Users o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Users entity
	 * 
	 */
	@Transactional
	public void deleteUsers(Users users) {
		usersDAO.remove(users);
		usersDAO.flush();
	}

	/**
	 */
	@Transactional
	public Users findUsersByPrimaryKey(Integer id) {
		return usersDAO.findUsersByPrimaryKey(id);
	}

	/**
	 * Return all Users entity
	 * 
	 */
	@Transactional
	public List<Users> findAllUserss(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Users>(usersDAO.findAllUserss(startResult, maxRows));
	}
}
