package myinfo.dao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import myinfo.domain.MyInfo;

import org.skyway.spring.util.dao.AbstractJpaDao;

import org.springframework.dao.DataAccessException;

import org.springframework.stereotype.Repository;

import org.springframework.transaction.annotation.Transactional;

/**
 * DAO to manage MyInfo entities.
 * 
 */
@Repository("MyInfoDAO")
@Transactional
public class MyInfoDAOImpl extends AbstractJpaDao<MyInfo> implements MyInfoDAO {

	/**
	 * Set of entity classes managed by this DAO.  Typically a DAO manages a single entity.
	 *
	 */
	private final static Set<Class<?>> dataTypes = new HashSet<Class<?>>(Arrays.asList(new Class<?>[] { MyInfo.class }));

	/**
	 * EntityManager injected by Spring for persistence unit mySQL_myInfo
	 *
	 */
	@PersistenceContext(unitName = "mySQL_myInfo")
	private EntityManager entityManager;

	/**
	 * Instantiates a new MyInfoDAOImpl
	 *
	 */
	public MyInfoDAOImpl() {
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
	 * JPQL Query - findMyInfoByUrlContaining
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByUrlContaining(String url) throws DataAccessException {

		return findMyInfoByUrlContaining(url, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByUrlContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByUrlContaining(String url, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByUrlContaining", startResult, maxRows, url);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByUrl
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByUrl(String url) throws DataAccessException {

		return findMyInfoByUrl(url, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByUrl
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByUrl(String url, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByUrl", startResult, maxRows, url);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByAccountContaining
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByAccountContaining(String account) throws DataAccessException {

		return findMyInfoByAccountContaining(account, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByAccountContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByAccountContaining(String account, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByAccountContaining", startResult, maxRows, account);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByTitle
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByTitle(String title) throws DataAccessException {

		return findMyInfoByTitle(title, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByTitle
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByTitle(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByTitle", startResult, maxRows, title);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByPasswordContaining
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByPasswordContaining(String password) throws DataAccessException {

		return findMyInfoByPasswordContaining(password, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByPasswordContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByPasswordContaining", startResult, maxRows, password);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByPassword
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByPassword(String password) throws DataAccessException {

		return findMyInfoByPassword(password, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByPassword
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByPassword(String password, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByPassword", startResult, maxRows, password);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByTitleContaining
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByTitleContaining(String title) throws DataAccessException {

		return findMyInfoByTitleContaining(title, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByTitleContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByTitleContaining(String title, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByTitleContaining", startResult, maxRows, title);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByPrimaryKey
	 *
	 */
	@Transactional
	public MyInfo findMyInfoByPrimaryKey(Integer myInfoId) throws DataAccessException {

		return findMyInfoByPrimaryKey(myInfoId, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByPrimaryKey
	 *
	 */

	@Transactional
	public MyInfo findMyInfoByPrimaryKey(Integer myInfoId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findMyInfoByPrimaryKey", startResult, maxRows, myInfoId);
			return (myinfo.domain.MyInfo) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findMyInfoByUserFk
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByUserFk(Integer userFk) throws DataAccessException {

		return findMyInfoByUserFk(userFk, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByUserFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByUserFk", startResult, maxRows, userFk);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByCategoryFk
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByCategoryFk(Integer categoryFk) throws DataAccessException {

		return findMyInfoByCategoryFk(categoryFk, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByCategoryFk
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByCategoryFk(Integer categoryFk, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByCategoryFk", startResult, maxRows, categoryFk);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByMyInfoId
	 *
	 */
	@Transactional
	public MyInfo findMyInfoByMyInfoId(Integer myInfoId) throws DataAccessException {

		return findMyInfoByMyInfoId(myInfoId, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByMyInfoId
	 *
	 */

	@Transactional
	public MyInfo findMyInfoByMyInfoId(Integer myInfoId, int startResult, int maxRows) throws DataAccessException {
		try {
			Query query = createNamedQuery("findMyInfoByMyInfoId", startResult, maxRows, myInfoId);
			return (myinfo.domain.MyInfo) query.getSingleResult();
		} catch (NoResultException nre) {
			return null;
		}
	}

	/**
	 * JPQL Query - findMyInfoByUsernameContaining
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByUsernameContaining(String username) throws DataAccessException {

		return findMyInfoByUsernameContaining(username, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByUsernameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByUsernameContaining", startResult, maxRows, username);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByAccount
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByAccount(String account) throws DataAccessException {

		return findMyInfoByAccount(account, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByAccount
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByAccount(String account, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByAccount", startResult, maxRows, account);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByUsername
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByUsername(String username) throws DataAccessException {

		return findMyInfoByUsername(username, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByUsername
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByUsername(String username, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByUsername", startResult, maxRows, username);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByFilename
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByFilename(String filename) throws DataAccessException {

		return findMyInfoByFilename(filename, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByFilename
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByFilename(String filename, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByFilename", startResult, maxRows, filename);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByActive
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByActive(Integer active) throws DataAccessException {

		return findMyInfoByActive(active, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByActive
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByActive(Integer active, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByActive", startResult, maxRows, active);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findAllMyInfos
	 *
	 */
	@Transactional
	public Set<MyInfo> findAllMyInfos() throws DataAccessException {

		return findAllMyInfos(-1, -1);
	}

	/**
	 * JPQL Query - findAllMyInfos
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findAllMyInfos(int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findAllMyInfos", startResult, maxRows);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * JPQL Query - findMyInfoByFilenameContaining
	 *
	 */
	@Transactional
	public Set<MyInfo> findMyInfoByFilenameContaining(String filename) throws DataAccessException {

		return findMyInfoByFilenameContaining(filename, -1, -1);
	}

	/**
	 * JPQL Query - findMyInfoByFilenameContaining
	 *
	 */

	@SuppressWarnings("unchecked")
	@Transactional
	public Set<MyInfo> findMyInfoByFilenameContaining(String filename, int startResult, int maxRows) throws DataAccessException {
		Query query = createNamedQuery("findMyInfoByFilenameContaining", startResult, maxRows, filename);
		return new LinkedHashSet<MyInfo>(query.getResultList());
	}

	/**
	 * Used to determine whether or not to merge the entity or persist the entity when calling Store
	 * @see store
	 * 
	 *
	 */
	public boolean canBeMerged(MyInfo entity) {
		return true;
	}
}
