package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Authorities;

/**
 * DAO to manage Authorities entities.
 * 
 */
public interface AuthoritiesDAO extends JpaDao<Authorities> {

	/**
	 * JPQL Query - findAuthoritiesByAuthorityContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityContaining(String authority) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityContaining(String authority, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByUsernameContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByUsernameContaining(String username) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByUsernameContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritiess
	 *
	 */
	public Set<Authorities> findAllAuthoritiess() throws DataAccessException;

	/**
	 * JPQL Query - findAllAuthoritiess
	 *
	 */
	public Set<Authorities> findAllAuthoritiess(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByUsername
	 *
	 */
	public Set<Authorities> findAuthoritiesByUsername(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByUsername
	 *
	 */
	public Set<Authorities> findAuthoritiesByUsername(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityName
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityName(String authorityName) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityName
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityName(String authorityName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesById
	 *
	 */
	public Set<Authorities> findAuthoritiesById(String id) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesById
	 *
	 */
	public Set<Authorities> findAuthoritiesById(String id, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthority
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthority(String authority_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthority
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthority(String authority_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityNameContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityNameContaining(String authorityName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityNameContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityNameContaining(String authorityName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByIdContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByIdContaining(String id_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByIdContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByIdContaining(String id_1, int startResult, int maxRows) throws DataAccessException;

}