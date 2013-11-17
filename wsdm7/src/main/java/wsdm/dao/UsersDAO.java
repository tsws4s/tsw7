package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Users;

/**
 * DAO to manage Users entities.
 * 
 */
public interface UsersDAO extends JpaDao<Users> {

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
	public Users findUsersByUserId(Integer userId) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUserId
	 *
	 */
	public Users findUsersByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersBySelectTheme
	 *
	 */
	public Set<Users> findUsersBySelectTheme(String selectTheme) throws DataAccessException;

	/**
	 * JPQL Query - findUsersBySelectTheme
	 *
	 */
	public Set<Users> findUsersBySelectTheme(String selectTheme, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByAdminYn
	 *
	 */
	public Set<Users> findUsersByAdminYn(Integer adminYn) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByAdminYn
	 *
	 */
	public Set<Users> findUsersByAdminYn(Integer adminYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersBySelectThemeContaining
	 *
	 */
	public Set<Users> findUsersBySelectThemeContaining(String selectTheme_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersBySelectThemeContaining
	 *
	 */
	public Set<Users> findUsersBySelectThemeContaining(String selectTheme_1, int startResult, int maxRows) throws DataAccessException;

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
	 * JPQL Query - findUsersByCustomerFk
	 *
	 */
	public Set<Users> findUsersByCustomerFk(Integer customerFk) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByCustomerFk
	 *
	 */
	public Set<Users> findUsersByCustomerFk(Integer customerFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */
	public Set<Users> findUsersByUsername(String username) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */
	public Set<Users> findUsersByUsername(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */
	public Set<Users> findUsersByPasswordContaining(String password) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */
	public Set<Users> findUsersByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByResultsPerPage
	 *
	 */
	public Set<Users> findUsersByResultsPerPage(Integer resultsPerPage) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByResultsPerPage
	 *
	 */
	public Set<Users> findUsersByResultsPerPage(Integer resultsPerPage, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */
	public Set<Users> findUsersByUsernameContaining(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */
	public Set<Users> findUsersByUsernameContaining(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */
	public Set<Users> findUsersByPassword(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */
	public Set<Users> findUsersByPassword(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByTswAcctFk
	 *
	 */
	public Set<Users> findUsersByTswAcctFk(Integer tswAcctFk) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByTswAcctFk
	 *
	 */
	public Set<Users> findUsersByTswAcctFk(Integer tswAcctFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(Integer userId_1) throws DataAccessException;

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	public Users findUsersByPrimaryKey(Integer userId_1, int startResult, int maxRows) throws DataAccessException;

}