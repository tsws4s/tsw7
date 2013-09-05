package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.AuthoritiesDAO;
import tsw.dao.UsersDAO;

import tsw.domain.Authorities;
import tsw.domain.Users;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Authorities entities
 * 
 */

@Service("AuthoritiesService")
@Transactional
public class AuthoritiesServiceImpl implements AuthoritiesService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();
	
	/**
	 * DAO injected by Spring that manages Authorities entities
	 * 
	 */
	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	/**
	 * DAO injected by Spring that manages Users entities
	 * 
	 */
	@Autowired
	private UsersDAO usersDAO;

	/**
	 * Instantiates a new AuthoritiesServiceImpl.
	 *
	 */
	public AuthoritiesServiceImpl() {
	}

	/**
	 * Delete an existing Authorities entity
	 * 
	 */
	@Transactional
	public void deleteAuthorities(Authorities authorities) {
		authoritiesDAO.remove(authorities);
		authoritiesDAO.flush();
	}

	/**
	 * Load an existing Authorities entity
	 * 
	 */
	@Transactional
	public Set<Authorities> loadAuthoritiess() {
		return authoritiesDAO.findAllAuthoritiess();
	}

	/**
	 * Return a count of all Authorities entity
	 * 
	 */
	@Transactional
	public Integer countAuthoritiess() {
		return ((Long) authoritiesDAO.createQuerySingleResult("select count(o) from Authorities o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Users entity
	 * 
	 */
	@Transactional
	public Authorities deleteAuthoritiesUserses(Integer authorities_authorityId, Integer related_userses_userId) {
		Users related_userses = usersDAO.findUsersByPrimaryKey(related_userses_userId, -1, defaultMaxRows);

		Authorities authorities = authoritiesDAO.findAuthoritiesByPrimaryKey(authorities_authorityId, -1, defaultMaxRows);

		related_userses.getAuthoritieses().remove(authorities);
		authorities.getUserses().remove(related_userses);

		usersDAO.remove(related_userses);
		usersDAO.flush();

		return authorities;
	}

	/**
	 * Save an existing Authorities entity
	 * 
	 */
	@Transactional
	public void saveAuthorities(Authorities authorities) {
		Authorities existingAuthorities = authoritiesDAO.findAuthoritiesByPrimaryKey(authorities.getAuthorityId());

		if (existingAuthorities != null) {
			if (existingAuthorities != authorities) {
				existingAuthorities.setAuthorityId(authorities.getAuthorityId());
				existingAuthorities.setAuthorityName(authorities.getAuthorityName());
			}
			authorities = authoritiesDAO.store(existingAuthorities);
		} else {
			int authorityId = authoritiesDAO.getMaxAuthorityID();
			authorities.setAuthorityId(authorityId+1);
			authorities = authoritiesDAO.store(authorities);
		}
		authoritiesDAO.flush();
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@Transactional
	public Authorities saveAuthoritiesUserses(Integer authorityId, Users related_userses) {
		Authorities authorities = authoritiesDAO.findAuthoritiesByPrimaryKey(authorityId, -1, defaultMaxRows);
		Users existinguserses = usersDAO.findUsersByPrimaryKey(related_userses.getUserId());

		// copy into the existing record to preserve existing relationships
		if (existinguserses != null) {
			existinguserses.setUserId(related_userses.getUserId());
			existinguserses.setUsername(related_userses.getUsername());
			existinguserses.setPassword(related_userses.getPassword());
			existinguserses.setActiveYn(related_userses.getActiveYn());
			related_userses = existinguserses;
		} else {
			related_userses = usersDAO.store(related_userses);
			usersDAO.flush();
		}

		related_userses.getAuthoritieses().add(authorities);
		authorities.getUserses().add(related_userses);
		related_userses = usersDAO.store(related_userses);
		usersDAO.flush();

		authorities = authoritiesDAO.store(authorities);
		authoritiesDAO.flush();

		return authorities;
	}

	/**
	 */
	@Transactional
	public Authorities findAuthoritiesByPrimaryKey(Integer authorityId) {
		return authoritiesDAO.findAuthoritiesByPrimaryKey(authorityId);
	}

	/**
	 * Return all Authorities entity
	 * 
	 */
	@Transactional
	public List<Authorities> findAllAuthoritiess(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Authorities>(authoritiesDAO.findAllAuthoritiess(startResult, maxRows));
	}
}
