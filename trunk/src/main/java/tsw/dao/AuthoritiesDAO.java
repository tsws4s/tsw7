package tsw.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Authorities;

/**
 * DAO to manage Authorities entities.
 * 
 */
public interface AuthoritiesDAO extends JpaDao<Authorities> {

	/**
	 * JPQL Query - findAuthoritiesByAuthorityNameContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityNameContaining(String authorityName) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityNameContaining
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityNameContaining(String authorityName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityId
	 *
	 */
	public Authorities findAuthoritiesByAuthorityId(Integer authorityId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByPrimaryKey
	 *
	 */
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityName
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityName(String authorityName_1) throws DataAccessException;

	/**
	 * JPQL Query - findAuthoritiesByAuthorityName
	 *
	 */
	public Set<Authorities> findAuthoritiesByAuthorityName(String authorityName_1, int startResult, int maxRows) throws DataAccessException;

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
	
	
	public Integer getMaxAuthorityID();
	
}