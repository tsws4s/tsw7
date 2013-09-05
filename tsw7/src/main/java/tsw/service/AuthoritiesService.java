package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Authorities;
import tsw.domain.Users;

/**
 * Spring service that handles CRUD requests for Authorities entities
 * 
 */
public interface AuthoritiesService {

	/**
	 * Delete an existing Authorities entity
	 * 
	 */
	public void deleteAuthorities(Authorities authorities);

	/**
	 * Load an existing Authorities entity
	 * 
	 */
	public Set<Authorities> loadAuthoritiess();

	/**
	 * Return a count of all Authorities entity
	 * 
	 */
	public Integer countAuthoritiess();

	/**
	 * Delete an existing Users entity
	 * 
	 */
	public Authorities deleteAuthoritiesUserses(Integer authorities_authorityId, Integer related_userses_userId);

	/**
	 * Save an existing Authorities entity
	 * 
	 */
	public void saveAuthorities(Authorities authorities_1);

	/**
	 * Save an existing Users entity
	 * 
	 */
	public Authorities saveAuthoritiesUserses(Integer authorityId, Users related_userses);

	/**
	 */
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId_1);

	/**
	 * Return all Authorities entity
	 * 
	 */
	public List<Authorities> findAllAuthoritiess(Integer startResult, Integer maxRows);
}