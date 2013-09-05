package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.Users;

/**
 * Spring service that handles CRUD requests for Users entities
 * 
 */
public interface UsersService {

	/**
	 * Load an existing Users entity
	 * 
	 */
	public Set<Users> loadUserss();

	/**
	 * Save an existing Users entity
	 * 
	 */
	public void saveUsers(Users users);

	/**
	 * Return a count of all Users entity
	 * 
	 */
	public Integer countUserss();

	/**
	 * Delete an existing Users entity
	 * 
	 */
	public void deleteUsers(Users users_1);

	/**
	 */
	public Users findUsersByPrimaryKey(Integer id);

	/**
	 * Return all Users entity
	 * 
	 */
	public List<Users> findAllUserss(Integer startResult, Integer maxRows);
}