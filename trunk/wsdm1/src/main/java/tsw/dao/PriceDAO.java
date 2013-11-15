package tsw.dao;

import java.math.BigDecimal;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import tsw.domain.Price;

/**
 * DAO to manage Price entities.
 * 
 */
public interface PriceDAO extends JpaDao<Price> {

	/**
	 * JPQL Query - findPriceByPriceColor
	 *
	 */
	public Set<Price> findPriceByPriceColor(String priceColor) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceColor
	 *
	 */
	public Set<Price> findPriceByPriceColor(String priceColor, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceId
	 *
	 */
	public Price findPriceByPriceId(Integer priceId) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceId
	 *
	 */
	public Price findPriceByPriceId(Integer priceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceCategory
	 *
	 */
	public Set<Price> findPriceByPriceCategory(String priceCategory) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceCategory
	 *
	 */
	public Set<Price> findPriceByPriceCategory(String priceCategory, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByDescription
	 *
	 */
	public Set<Price> findPriceByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByDescription
	 *
	 */
	public Set<Price> findPriceByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceColorContaining
	 *
	 */
	public Set<Price> findPriceByPriceColorContaining(String priceColor_1) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceColorContaining
	 *
	 */
	public Set<Price> findPriceByPriceColorContaining(String priceColor_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceCategoryContaining
	 *
	 */
	public Set<Price> findPriceByPriceCategoryContaining(String priceCategory_1) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceCategoryContaining
	 *
	 */
	public Set<Price> findPriceByPriceCategoryContaining(String priceCategory_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceField
	 *
	 */
	public Set<Price> findPriceByPriceField(java.math.BigDecimal priceField) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPriceField
	 *
	 */
	public Set<Price> findPriceByPriceField(BigDecimal priceField, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByDescriptionContaining
	 *
	 */
	public Set<Price> findPriceByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByDescriptionContaining
	 *
	 */
	public Set<Price> findPriceByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPrices
	 *
	 */
	public Set<Price> findAllPrices4tsw(Integer tswId) throws DataAccessException;

	/**
	 * JPQL Query - findAllPrices
	 *
	 */
	public Set<Price> findAllPrices4tsw(Integer tswId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPrimaryKey
	 *
	 */
	public Price findPriceByPrimaryKey(Integer priceId_1) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPrimaryKey
	 *
	 */
	public Price findPriceByPrimaryKey(Integer priceId_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxPriceID();

}