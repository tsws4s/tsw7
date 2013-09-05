package myinfo.dao;

import java.util.Set;

import myinfo.domain.MyCategory;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

/**
 * DAO to manage MyCategory entities.
 * 
 */
public interface MyCategoryDAO extends JpaDao<MyCategory> {

	/**
	 * JPQL Query - findMyCategoryByCategoryNameContaining
	 *
	 */
	public Set<MyCategory> findMyCategoryByCategoryNameContaining(String categoryName) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByCategoryNameContaining
	 *
	 */
	public Set<MyCategory> findMyCategoryByCategoryNameContaining(String categoryName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByCategoryName
	 *
	 */
	public Set<MyCategory> findMyCategoryByCategoryName(String categoryName_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByCategoryName
	 *
	 */
	public Set<MyCategory> findMyCategoryByCategoryName(String categoryName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByCategoryId
	 *
	 */
	public MyCategory findMyCategoryByCategoryId(Integer categoryId) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByCategoryId
	 *
	 */
	public MyCategory findMyCategoryByCategoryId(Integer categoryId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByActive
	 *
	 */
	public Set<MyCategory> findMyCategoryByActive(Integer active) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByActive
	 *
	 */
	public Set<MyCategory> findMyCategoryByActive(Integer active, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllMyCategorys
	 *
	 */
	public Set<MyCategory> findAllMyCategorys() throws DataAccessException;

	/**
	 * JPQL Query - findAllMyCategorys
	 *
	 */
	public Set<MyCategory> findAllMyCategorys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByPrimaryKey
	 *
	 */
	public MyCategory findMyCategoryByPrimaryKey(Integer categoryId_1) throws DataAccessException;

	/**
	 * JPQL Query - findMyCategoryByPrimaryKey
	 *
	 */
	public MyCategory findMyCategoryByPrimaryKey(Integer categoryId_1, int startResult, int maxRows) throws DataAccessException;

}