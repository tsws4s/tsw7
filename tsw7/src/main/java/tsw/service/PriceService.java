package tsw.service;

import java.util.List;
import java.util.Set;

import tsw.domain.Price;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Price entities
 * 
 */
public interface PriceService {

	/**
	 * Delete an existing Price entity
	 * 
	 */
	public void deletePrice(Price price);

	/**
	 * Return a count of all Price entity
	 * 
	 */
	public Integer countPrices();

	/**
	 */
	public Price findPriceByPrimaryKey(Integer priceId);

	/**
	 * Return all Price entity
	 * 
	 */
	public List<Price> findAllPrices4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Load an existing Price entity
	 * 
	 */
	public Set<Price> loadPrices4tsw(Tswacct tswacct);

	/**
	 * Save an existing Price entity
	 * 
	 */
	public void savePrice(Tswacct tswacct, Price price_1);

	public Integer getPriceCount4tsw(Tswacct tswacct);
}