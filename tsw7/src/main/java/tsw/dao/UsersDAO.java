package tsw.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Users;

/**
 * DAO to manage Users entities.
 * 
 */
public interface UsersDAO extends JpaDao<Users> {

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */
	public Set<Users> findUsersByPassword(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */
	public Set<Users> findUsersByPassword(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(Integer userId) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(Integer userId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */
	public Set<Users> findUsersByPasswordContaining(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */
	public Set<Users> findUsersByPasswordContaining(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUserss
	 *
	 */
	public Set<Users> findAllUserss4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllUserss
	 *
	 */
	public Set<Users> findAllUserss4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */
	public Set<Users> findUsersByUsernameContaining(String username) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */
	public Set<Users> findUsersByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */
	public Set<Users> findUsersByUsername(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */
	public Set<Users> findUsersByUsername(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByActiveYn
	 *
	 */
	public Set<Users> findUsersByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByActiveYn
	 *
	 */
	public Set<Users> findUsersByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUserId
	 *
	 */
	public Users findUsersByUserId(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUserId
	 *
	 */
	public Users findUsersByUserId(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxUsersID();

}