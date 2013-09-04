package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.AuthoritiesDAO;
import tsw.dao.CustomerDAO;
import tsw.dao.TswacctDAO;
import tsw.dao.UsersDAO;

import tsw.domain.Authorities;
import tsw.domain.Tswacct;
import tsw.domain.Users;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Users entities
 * 
 */

	// TODO: [Tim] (Security-Med) Create "Register for Team or Program" widget for external web sites

	// TODO: [Tim] (Security-Med) Create Online payment (PayPal, Authorize.NET)

@Service("UsersService")
@Transactional
public class UsersServiceImpl implements UsersService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();
	
	/**
	 * DAO injected by Spring that manages Authorities entities
	 * 
	 */
	@Autowired
	private AuthoritiesDAO authoritiesDAO;

	/**
	 * DAO injected by Spring that manages Customer entities
	 * 
	 */
	@Autowired
	private CustomerDAO customerDAO;

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;

	/**
	 * DAO injected by Spring that manages Users entities
	 * 
	 */
	@Autowired
	private UsersDAO usersDAO;
	
	  @Autowired
	  private PasswordEncoder passwordEncoder;
	  
	/**
	 * Instantiates a new UsersServiceImpl.
	 *
	 */
	public UsersServiceImpl() {
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Users saveUsersTswacct(Integer userId, Tswacct related_tswacct) {
		Users users = usersDAO.findUsersByPrimaryKey(userId, -1, defaultMaxRows);
		Tswacct existingtswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswacct != null) {
			existingtswacct.setTswAcctId(related_tswacct.getTswAcctId());
			existingtswacct.setAcctName(related_tswacct.getAcctName());
			existingtswacct.setSubscrType(related_tswacct.getSubscrType());
			existingtswacct.setAmtPaid(related_tswacct.getAmtPaid());
			existingtswacct.setEstablishDate(related_tswacct.getEstablishDate());
			existingtswacct.setExpireDate(related_tswacct.getExpireDate());
			existingtswacct.setActiveYn(related_tswacct.getActiveYn());
			related_tswacct = existingtswacct;
		} else {
			related_tswacct = tswacctDAO.store(related_tswacct);
			tswacctDAO.flush();
		}

		users.setTswacct(related_tswacct);
		related_tswacct.getUserses().add(users);
		users = usersDAO.store(users);
		usersDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return users;
	}

	/**
	 * Return all Users entity
	 * 
	 */
	@Transactional
	public List<Users> findAllUserss4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Users>(usersDAO.findAllUserss4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 * Return a count of all Users entity
	 * 
	 */
	@Transactional
	public Integer countUserss() {
		return ((Long) usersDAO.createQuerySingleResult("select count(o) from Users o").getSingleResult()).intValue();
	}

	/**
	 * Save an existing Users entity
	 * 
	 */
	@Transactional
	public void saveUsers(Tswacct tswacct, Users users, Integer custId) {
		Users existingUsers = usersDAO.findUsersByPrimaryKey(users.getUserId());

		if (existingUsers != null) {
			if (existingUsers != users) {
				existingUsers.setUserId(users.getUserId());
				existingUsers.setUsername(users.getUsername());
				if(existingUsers.getPassword().equals(users.getPassword())){
					existingUsers.setPassword(users.getPassword());	
				} else {
					// TODO: [assignedTo] (Security-Med) Finish implementing to save encrypted password.  
					// Also need to update corresponding login logic to use encryption when checking passwords.
					String encodedPassword = passwordEncoder.encodePassword(users.getPassword(), null);
					existingUsers.setPassword(encodedPassword);					
				}
				existingUsers.setPassword(users.getPassword());
				existingUsers.setActiveYn(users.getActiveYn());
				existingUsers.setResultsPerPage(users.getResultsPerPage());
				existingUsers.setSelectTheme(users.getSelectTheme());
				existingUsers.setCustomer(users.getCustomer());
			}
			users = existingUsers;
		} else {
			int userId = usersDAO.getMaxUsersID();
			users.setUserId(userId+1);
			// AlsoDO: (Security-Med) Finish implementing to save encrypted password.  
			String encodedPassword = passwordEncoder.encodePassword(users.getPassword(), null);
			users.setPassword(encodedPassword);
			users.setTswacct(tswacct);
			users.setActiveYn(new Integer(1));
		}
		if(custId!=null && custId>0){
			users.setCustomer(customerDAO.findCustomerByPrimaryKey(custId));
		}
		users = usersDAO.store(users);
		usersDAO.flush();
	}

	@Transactional
	public void saveRegisteredUser(Tswacct tswacct, Users users) {
		
		// TODO: [assignedTo] (Security-Med) Need to finish save Registered User
		saveUsers(tswacct, users, users.getCustomer().getCustomerId());
		
	}

	/**
	 * Load an existing Users entity
	 * 
	 */
	@Transactional
	public Set<Users> loadUserss4tsw(Tswacct tswacct) {
		return usersDAO.findAllUserss4tsw(tswacct.getTswAcctId());
	}

	/**
	 * Delete an existing Users entity
	 * 
	 */
	@Transactional
	public void deleteUsers(Users users) {
		usersDAO.remove(users);
		usersDAO.flush();
	}

	/**
	 * Save an existing Authorities entity
	 * 
	 */
	@Transactional
	public Users saveUsersAuthoritieses(Integer userId, Authorities related_authoritieses) {
		Users users = usersDAO.findUsersByPrimaryKey(userId, -1, defaultMaxRows);
		Authorities existingauthoritieses = authoritiesDAO.findAuthoritiesByPrimaryKey(related_authoritieses.getAuthorityId());

		// copy into the existing record to preserve existing relationships
		if (existingauthoritieses != null) {
			existingauthoritieses.setAuthorityId(related_authoritieses.getAuthorityId());
			existingauthoritieses.setAuthorityName(related_authoritieses.getAuthorityName());
			related_authoritieses = existingauthoritieses;
		} else {
			related_authoritieses = authoritiesDAO.store(related_authoritieses);
			authoritiesDAO.flush();
		}

		users.getAuthoritieses().add(related_authoritieses);
		related_authoritieses.getUserses().add(users);
		users = usersDAO.store(users);
		usersDAO.flush();

		related_authoritieses = authoritiesDAO.store(related_authoritieses);
		authoritiesDAO.flush();

		return users;
	}

	/**
	 * Delete an existing Authorities entity
	 * 
	 */
	@Transactional
	public Users deleteUsersAuthoritieses(Integer users_userId, Integer related_authoritieses_authorityId) {
		Users users = usersDAO.findUsersByPrimaryKey(users_userId, -1, defaultMaxRows);
		Authorities related_authoritieses = authoritiesDAO.findAuthoritiesByPrimaryKey(related_authoritieses_authorityId, -1, defaultMaxRows);

		users.getAuthoritieses().remove(related_authoritieses);
		related_authoritieses.getUserses().remove(users);
		users = usersDAO.store(users);
		usersDAO.flush();

		related_authoritieses = authoritiesDAO.store(related_authoritieses);
		authoritiesDAO.flush();

		authoritiesDAO.remove(related_authoritieses);
		authoritiesDAO.flush();

		return users;
	}

	/**
	 */
	@Transactional
	public Users findUsersByPrimaryKey(Integer userId) {
		return usersDAO.findUsersByPrimaryKey(userId);
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Users deleteUsersTswacct(Integer users_userId, Integer related_tswacct_tswAcctId) {
		Users users = usersDAO.findUsersByPrimaryKey(users_userId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		users.setTswacct(null);
		related_tswacct.getUserses().remove(users);
		users = usersDAO.store(users);
		usersDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return users;
	}

	@Override
	public Object getUsersCount4tsw(Tswacct tswacct) { 
		int tswId = tswacct.getTswAcctId();
		return ((Long) usersDAO.createQuerySingleResult("select count(userId) from Users o where tswAcctFk='"+tswId+"'").getSingleResult()).intValue();
	}

	@Override
	public Set<Users> findUsersByUsername(String userName) {
		return usersDAO.findUsersByUsername(userName);
	}

}
