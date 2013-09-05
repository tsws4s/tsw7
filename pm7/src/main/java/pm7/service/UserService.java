package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.User;

/**
 * Spring service that handles CRUD requests for User entities
 * 
 */
public interface UserService {

	/**
	 * Return all User entity
	 * 
	 */
	public List<User> findAllUsers(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public User deleteUserAccount(Integer user_userId, Integer related_account_accountId);

	/**
	 * Delete an existing User entity
	 * 
	 */
	public void deleteUser(User user);

	/**
	 * Save an existing User entity
	 * 
	 */
	public User saveUser(User user_1);

	/**
	 */
	public User findUserByPrimaryKey(Integer userId);

	/**
	 * Load an existing User entity
	 * 
	 */
	public Set<User> loadUsers();

	/**
	 * Return a count of all User entity
	 * 
	 */
	public Integer countUsers();

	/**
	 * Save an existing Account entity
	 * 
	 */
	public User saveUserAccount(Integer userId_1, Account related_account);
}