package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.User;

/**
 * DAO to manage User entities.
 * 
 */
public interface UserDAO extends JpaDao<User> {

	/**
	 * JPQL Query - findUserByUserId
	 *
	 */
	public User findUserByUserId(Integer userId) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUserId
	 *
	 */
	public User findUserByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	public Set<User> findUserByPassword(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPassword
	 *
	 */
	public Set<User> findUserByPassword(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 */
	public Set<User> findUserByUsernameContaining(String username) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsernameContaining
	 *
	 */
	public Set<User> findUserByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	public User findUserByPrimaryKey(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPrimaryKey
	 *
	 */
	public User findUserByPrimaryKey(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByActiveYn
	 *
	 */
	public Set<User> findUserByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findUserByActiveYn
	 *
	 */
	public Set<User> findUserByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	public Set<User> findAllUsers() throws DataAccessException;

	/**
	 * JPQL Query - findAllUsers
	 *
	 */
	public Set<User> findAllUsers(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 */
	public Set<User> findUserByUsername(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByUsername
	 *
	 */
	public Set<User> findUserByUsername(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	public Set<User> findUserByPasswordContaining(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUserByPasswordContaining
	 *
	 */
	public Set<User> findUserByPasswordContaining(String password_1, int startResult, int maxRows) throws DataAccessException;
	
	public Integer getMaxUserId();
}