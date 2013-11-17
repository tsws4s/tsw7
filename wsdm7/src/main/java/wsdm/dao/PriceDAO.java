package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Price;

/**
 * DAO to manage Price entities.
 * 
 */
public interface PriceDAO extends JpaDao<Price> {

	/**
	 * JPQL Query - findPriceByPrimaryKey
	 *
	 */
	public Price findPriceByPrimaryKey(Integer priceId) throws DataAccessException;

	/**
	 * JPQL Query - findPriceByPrimaryKey
	 *
	 */
	public Price findPriceByPrimaryKey(Integer priceId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllPrices
	 *
	 */
	public Set<Price> findAllPrices() throws DataAccessException;

	/**
	 * JPQL Query - findAllPrices
	 *
	 */
	public Set<Price> findAllPrices(int startResult, int maxRows) throws DataAccessException;

}