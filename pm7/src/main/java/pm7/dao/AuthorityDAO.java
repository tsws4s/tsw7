package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Authority;

/**
 * DAO to manage Authority entities.
 * 
 */
public interface AuthorityDAO extends JpaDao<Authority> {

	/**
	 * JPQL Query - findAuthorityByAuthorityName
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityName(String authorityName) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityName
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityName(String authorityName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityId
	 *
	 */
	public Authority findAuthorityByAuthorityId(Integer authorityId) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityId
	 *
	 */
	public Authority findAuthorityByAuthorityId(Integer authorityId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	public Authority findAuthorityByPrimaryKey(Integer authorityId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByPrimaryKey
	 *
	 */
	public Authority findAuthorityByPrimaryKey(Integer authorityId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	public Set<Authority> findAllAuthoritys() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritys
	 *
	 */
	public Set<Authority> findAllAuthoritys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityNameContaining
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityNameContaining(String authorityName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthorityByAuthorityNameContaining
	 *
	 */
	public Set<Authority> findAuthorityByAuthorityNameContaining(String authorityName_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxAuthorityId();
}