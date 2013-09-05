package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.PriceDAO;

import tsw.domain.Price;
import tsw.domain.Tswacct;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Price entities
 * 
 */

@Service("PriceService")
@Transactional
public class PriceServiceImpl implements PriceService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages Price entities
	 * 
	 */
	@Autowired
	private PriceDAO priceDAO;

	/**
	 * Instantiates a new PriceServiceImpl.
	 *
	 */
	public PriceServiceImpl() {
	}

	/**
	 * Delete an existing Price entity
	 * 
	 */
	@Transactional
	public void deletePrice(Price price) {
		priceDAO.remove(price);
		priceDAO.flush();
	}

	/**
	 * Return a count of all Price entity
	 * 
	 */
	@Transactional
	public Integer countPrices() {
		return ((Long) priceDAO.createQuerySingleResult("select count(o) from Price o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public Price findPriceByPrimaryKey(Integer priceId) {
		return priceDAO.findPriceByPrimaryKey(priceId);
	}

	/**
	 * Return all Price entity
	 * 
	 */
	@Transactional
	public List<Price> findAllPrices4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Price>(priceDAO.findAllPrices4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 * Load an existing Price entity
	 * 
	 */
	@Transactional
	public Set<Price> loadPrices4tsw(Tswacct tswacct) {
		return priceDAO.findAllPrices4tsw(tswacct.getTswAcctId());
	}

	/**
	 * Save an existing Price entity
	 * 
	 */
	@Transactional
	public void savePrice(Tswacct tswacct, Price price) {
		Price existingPrice = priceDAO.findPriceByPrimaryKey(price.getPriceId());

		if (existingPrice != null) {
			if (existingPrice != price) {
				existingPrice.setPriceId(price.getPriceId());
				existingPrice.setPriceField(price.getPriceField());
				existingPrice.setPriceCategory(price.getPriceCategory());
				existingPrice.setDescription(price.getDescription());
				existingPrice.setPriceColor(price.getPriceColor());
			}
			price = priceDAO.store(existingPrice);
		} else {
			int priceId = priceDAO.getMaxPriceID();
			price.setPriceId(priceId+1);
			price.setTswacct(tswacct);
			price = priceDAO.store(price);
		}
		priceDAO.flush();
	}

	@Override
	public Integer getPriceCount4tsw(Tswacct tswacct) {
		int tswId = tswacct.getTswAcctId();
		return ((Long) priceDAO.createQuerySingleResult("select count(priceId) from Price o where tswAcctFk = '"+tswId+"'").getSingleResult()).intValue();	
		}
}