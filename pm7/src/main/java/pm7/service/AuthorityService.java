package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Authority;

/**
 * Spring service that handles CRUD requests for Authority entities
 * 
 */
public interface AuthorityService {

	/**
	 * Return a count of all Authority entity
	 * 
	 */
	public Integer countAuthoritys();

	/**
	 * Delete an existing Authority entity
	 * 
	 */
	public void deleteAuthority(Authority authority);

	/**
	 * Return all Authority entity
	 * 
	 */
	public List<Authority> findAllAuthoritys(Integer startResult, Integer maxRows);

	/**
	 * Save an existing Authority entity
	 * 
	 */
	public Authority saveAuthority(Authority authority_1);

	/**
	 */
	public Authority findAuthorityByPrimaryKey(Integer authorityId);

	/**
	 * Load an existing Authority entity
	 * 
	 */
	public Set<Authority> loadAuthoritys();
}