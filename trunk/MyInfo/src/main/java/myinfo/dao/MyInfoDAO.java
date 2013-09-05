package myinfo.dao;

import java.util.Set;

import myinfo.domain.MyInfo;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage MyInfo entities.
 * 
 */
public interface MyInfoDAO extends JpaDao<MyInfo> {

	/**
	 * JPQL Query - findMyInfoByUrlContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByUrlContaining(String url) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUrlContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByUrlContaining(String url, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUrl
	 *
	 */
	public Set<MyInfo> findMyInfoByUrl(String url_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUrl
	 *
	 */
	public Set<MyInfo> findMyInfoByUrl(String url_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByAccountContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByAccountContaining(String account) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByAccountContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByAccountContaining(String account, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByTitle
	 *
	 */
	public Set<MyInfo> findMyInfoByTitle(String title) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByTitle
	 *
	 */
	public Set<MyInfo> findMyInfoByTitle(String title, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByPasswordContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByPasswordContaining(String password) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByPasswordContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByPasswordContaining(String password, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByPassword
	 *
	 */
	public Set<MyInfo> findMyInfoByPassword(String password_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByPassword
	 *
	 */
	public Set<MyInfo> findMyInfoByPassword(String password_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByTitleContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByTitleContaining(String title_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByTitleContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByTitleContaining(String title_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByPrimaryKey
	 *
	 */
	public MyInfo findMyInfoByPrimaryKey(Integer myInfoId) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByPrimaryKey
	 *
	 */
	public MyInfo findMyInfoByPrimaryKey(Integer myInfoId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUserFk
	 *
	 */
	public Set<MyInfo> findMyInfoByUserFk(Integer userFk) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUserFk
	 *
	 */
	public Set<MyInfo> findMyInfoByUserFk(Integer userFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByCategoryFk
	 *
	 */
	public Set<MyInfo> findMyInfoByCategoryFk(Integer categoryFk) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByCategoryFk
	 *
	 */
	public Set<MyInfo> findMyInfoByCategoryFk(Integer categoryFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByMyInfoId
	 *
	 */
	public MyInfo findMyInfoByMyInfoId(Integer myInfoId_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByMyInfoId
	 *
	 */
	public MyInfo findMyInfoByMyInfoId(Integer myInfoId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUsernameContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByUsernameContaining(String username) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUsernameContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByUsernameContaining(String username, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByAccount
	 *
	 */
	public Set<MyInfo> findMyInfoByAccount(String account_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByAccount
	 *
	 */
	public Set<MyInfo> findMyInfoByAccount(String account_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUsername
	 *
	 */
	public Set<MyInfo> findMyInfoByUsername(String username_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByUsername
	 *
	 */
	public Set<MyInfo> findMyInfoByUsername(String username_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByFilename
	 *
	 */
	public Set<MyInfo> findMyInfoByFilename(String filename) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByFilename
	 *
	 */
	public Set<MyInfo> findMyInfoByFilename(String filename, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByActive
	 *
	 */
	public Set<MyInfo> findMyInfoByActive(Integer active) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByActive
	 *
	 */
	public Set<MyInfo> findMyInfoByActive(Integer active, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllMyInfos
	 *
	 */
	public Set<MyInfo> findAllMyInfos() throws DataAccessException;

	/**
	 * JPQL Query - findAllMyInfos
	 *
	 */
	public Set<MyInfo> findAllMyInfos(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByFilenameContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByFilenameContaining(String filename_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyInfoByFilenameContaining
	 *
	 */
	public Set<MyInfo> findMyInfoByFilenameContaining(String filename_1, int startResult, int maxRows) throws DataAccessException;

}