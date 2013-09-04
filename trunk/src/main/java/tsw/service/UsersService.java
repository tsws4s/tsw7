package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Authorities;
import tsw.domain.Tswacct;
import tsw.domain.Users;

/**
 * Spring service that handles CRUD requests for Users entities
 * 
 */
public interface UsersService {

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Users saveUsersTswacct(Integer userId, Tswacct related_tswacct);

	/**
	 * Return all Users entity
	 * 
	 */
	public List<Users> findAllUserss4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Users entity
	 * 
	 */
	public Integer countUserss();

	/**
	 * Save an existing Users entity
	 * 
	 */
	public void saveUsers(Tswacct tswacct, Users users, Integer selected_id4);

	/**
	 * Load an existing Users entity
	 * 
	 */
	public Set<Users> loadUserss4tsw(Tswacct tswacct);

	/**
	 * Delete an existing Users entity
	 * 
	 */
	public void deleteUsers(Users users_1);

	/**
	 * Save an existing Authorities entity
	 * 
	 */
	public Users saveUsersAuthoritieses(Integer userId_2, Authorities related_authoritieses);

	/**
	 * Delete an existing Authorities entity
	 * 
	 */
	public Users deleteUsersAuthoritieses(Integer users_userId_1, Integer related_authoritieses_authorityId);

	/**
	 */
	public Users findUsersByPrimaryKey(Integer userId_3);

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Users deleteUsersTswacct(Integer users_userId_2, Integer related_tswacct_tswAcctId);

	public Object getUsersCount4tsw(Tswacct tswacct);

	public Set<Users> findUsersByUsername(String userName);

	public void saveRegisteredUser(Tswacct tswacct, Users users);
}