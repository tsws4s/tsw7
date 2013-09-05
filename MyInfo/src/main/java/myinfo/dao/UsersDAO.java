package myinfo.dao;

import java.util.Set;

import myinfo.domain.Users;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage Users entities.
 * 
 */
public interface UsersDAO extends JpaDao<Users> {

	/**
	 * JPQL Query - findUsersByActive
	 *
	 */
	public Set<Users> findUsersByActive(Integer active) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByActive
	 *
	 */
	public Set<Users> findUsersByActive(Integer active, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(Integer id) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(Integer id, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findUsersById
	 *
	 */
	public Users findUsersById(Integer id_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersById
	 *
	 */
	public Users findUsersById(Integer id_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByIpContaining
	 *
	 */
	public Set<Users> findUsersByIpContaining(String ip) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByIpContaining
	 *
	 */
	public Set<Users> findUsersByIpContaining(String ip, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByIp
	 *
	 */
	public Set<Users> findUsersByIp(String ip_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByIp
	 *
	 */
	public Set<Users> findUsersByIp(String ip_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByEmail
	 *
	 */
	public Set<Users> findUsersByEmail(String email) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByEmail
	 *
	 */
	public Set<Users> findUsersByEmail(String email, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllUserss
	 *
	 */
	public Set<Users> findAllUserss() throws DataAccessException;

	/**
	 * JPQL Query - findAllUserss
	 *
	 */
	public Set<Users> findAllUserss(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByEmailContaining
	 *
	 */
	public Set<Users> findUsersByEmailContaining(String email_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByEmailContaining
	 *
	 */
	public Set<Users> findUsersByEmailContaining(String email_1, int startResult, int maxRows) throws DataAccessException;

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

}