package wsdm.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

import wsdm.domain.Users;

/**
 * DAO to manage Users entities.
 * 
 */
@Repository("UsersDAO")
@Transactional
public class UsersDAOImpl extends AbstractJpaDao<Users> implements UsersDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { Users.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mysql_tsw
	 *
	 */
	@PersistenceContext(unitName = "mysql_tsw")
	private EntityManager entityManager;

	/**
	 * Instantiates a new UsersDAOImpl
	 *
	 */
	public UsersDAOImpl() {
		super();
	}

	/**
	 * Get the entity manager that manages persistence unit 
	 *
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * Returns the set of entity classes managed by this DAO.
	 *
	 */
	public Set<Class<?>> getTypes() {
		return dataTypes;
	}

	/**
	 * JPQL Query - findUsersByActiveYn
	 *
	 */
	@Transactional
	public Set<Users> findUsersByActiveYn(Integer activeYn) throws DataAccessException {

		return findUsersByActiveYn(activeYn, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByActiveYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByActiveYn", startResult, maxRows, activeYn);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByUserId
	 *
	 */
	@Transactional
	public Users findUsersByUserId(Integer userId) throws DataAccessException {

		return findUsersByUserId(userId, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByUserId
	 *
	 */

	@Transactional
	public Users findUsersByUserId(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUsersByUserId", startResult, maxRows, userId);
			return (wsdm.domain.Users) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findUsersBySelectTheme
	 *
	 */
	@Transactional
	public Set<Users> findUsersBySelectTheme(String selectTheme) throws DataAccessException {

		return findUsersBySelectTheme(selectTheme, -1, -1);
	}

	/**
	 * JPQL Query - findUsersBySelectTheme
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersBySelectTheme(String selectTheme, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersBySelectTheme", startResult, maxRows, selectTheme);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByAdminYn
	 *
	 */
	@Transactional
	public Set<Users> findUsersByAdminYn(Integer adminYn) throws DataAccessException {

		return findUsersByAdminYn(adminYn, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByAdminYn
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByAdminYn(Integer adminYn, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByAdminYn", startResult, maxRows, adminYn);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersBySelectThemeContaining
	 *
	 */
	@Transactional
	public Set<Users> findUsersBySelectThemeContaining(String selectTheme) throws DataAccessException {

		return findUsersBySelectThemeContaining(selectTheme, -1, -1);
	}

	/**
	 * JPQL Query - findUsersBySelectThemeContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersBySelectThemeContaining(String selectTheme, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersBySelectThemeContaining", startResult, maxRows, selectTheme);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllUserss
	 *
	 */
	@Transactional
	public Set<Users> findAllUserss() throws DataAccessException {

		return findAllUserss(-1, -1);
	}

	/**
	 * JPQL Query - findAllUserss
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findAllUserss(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllUserss", startResult, maxRows);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByCustomerFk
	 *
	 */
	@Transactional
	public Set<Users> findUsersByCustomerFk(Integer customerFk) throws DataAccessException {

		return findUsersByCustomerFk(customerFk, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByCustomerFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByCustomerFk(Integer customerFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByCustomerFk", startResult, maxRows, customerFk);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */
	@Transactional
	public Set<Users> findUsersByUsername(String username) throws DataAccessException {

		return findUsersByUsername(username, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByUsername
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByUsername(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByUsername", startResult, maxRows, username);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */
	@Transactional
	public Set<Users> findUsersByPasswordContaining(String password) throws DataAccessException {

		return findUsersByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByResultsPerPage
	 *
	 */
	@Transactional
	public Set<Users> findUsersByResultsPerPage(Integer resultsPerPage) throws DataAccessException {

		return findUsersByResultsPerPage(resultsPerPage, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByResultsPerPage
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByResultsPerPage(Integer resultsPerPage, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByResultsPerPage", startResult, maxRows, resultsPerPage);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */
	@Transactional
	public Set<Users> findUsersByUsernameContaining(String username) throws DataAccessException {

		return findUsersByUsernameContaining(username, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByUsernameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByUsernameContaining", startResult, maxRows, username);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */
	@Transactional
	public Set<Users> findUsersByPassword(String password) throws DataAccessException {

		return findUsersByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByPassword", startResult, maxRows, password);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByTswAcctFk
	 *
	 */
	@Transactional
	public Set<Users> findUsersByTswAcctFk(Integer tswAcctFk) throws DataAccessException {

		return findUsersByTswAcctFk(tswAcctFk, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByTswAcctFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<Users> findUsersByTswAcctFk(Integer tswAcctFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findUsersByTswAcctFk", startResult, maxRows, tswAcctFk);
		return new LinkedHashSet<Users>(query.getResultList());
	}

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */
	@Transactional
	public Users findUsersByPrimaryKey(Integer userId) throws DataAccessException {

		return findUsersByPrimaryKey(userId, -1, -1);
	}

	/**
	 * JPQL Query - findUsersByPrimaryKey
	 *
	 */

	@Transactional
	public Users findUsersByPrimaryKey(Integer userId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findUsersByPrimaryKey", startResult, maxRows, userId);
			return (wsdm.domain.Users) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(Users entity) {
		return true;
	}
}
