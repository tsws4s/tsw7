//**********************************************************
// AuthorityServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 06/22/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package pm7.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import pm7.dao.AuthorityDAO;

import pm7.domain.Authority;

/**
 * Spring service that handles CRUD requests for Authority entities
 * 
 */

@Service("AuthorityService")
@Transactional
public class AuthorityServiceImpl implements AuthorityService {

	/**
	 * DAO injected by Spring that manages Authority entities
	 * 
	 */
	@Autowired
	private AuthorityDAO authorityDAO;

	/**
	 * Instantiates a new AuthorityServiceImpl.
	 *
	 */
	public AuthorityServiceImpl() {
	}

	/**
	 * Return a count of all Authority entity
	 * 
	 */
	@Transactional
	public Integer countAuthoritys() {
		return ((Long) authorityDAO.createQuerySingleResult("select count(o) from Authority o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing Authority entity
	 * 
	 */
	@Transactional
	public void deleteAuthority(Authority authority) {
		authorityDAO.remove(authority);
		authorityDAO.flush();
	}

	/**
	 * Return all Authority entity
	 * 
	 */
	@Transactional
	public List<Authority> findAllAuthoritys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Authority>(authorityDAO.findAllAuthoritys(startResult, maxRows));
	}

	/**
	 * Save an existing Authority entity
	 * 
	 */
	@Transactional
	public Authority saveAuthority(Authority authority) {
		Authority existingAuthority = authorityDAO.findAuthorityByPrimaryKey(authority.getAuthorityId());

		if (existingAuthority != null) {
			if (existingAuthority != authority) {
				existingAuthority.setAuthorityId(authority.getAuthorityId());
				existingAuthority.setAuthorityName(authority.getAuthorityName());
			}
			authority = authorityDAO.store(existingAuthority);
		} else {
			int authorityId = authorityDAO.getMaxAuthorityId();
			authority.setAuthorityId(authorityId+1);
//			authority.setAccount(acct);
			authority = authorityDAO.store(authority);
		}
//		if(attachmentId!=null && attachmentId>0){
//			attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//		}		
		authorityDAO.flush();
		return authority;
		}
	/**
	 */
	@Transactional
	public Authority findAuthorityByPrimaryKey(Integer authorityId) {
		return authorityDAO.findAuthorityByPrimaryKey(authorityId);
	}

	/**
	 * Load an existing Authority entity
	 * 
	 */
	@Transactional
	public Set<Authority> loadAuthoritys() {
		return authorityDAO.findAllAuthoritys();
	}
}
