package tsw.service;

import java.util.List;
import java.util.Set;
import tsw.domain.Commission;

/**
 * Spring service that handles CRUD requests for Authorities entities
 * 
 */
public interface CommissionService {

	/**
	 * Delete an existing Commission entity
	 * 
	 */
	public void deleteCommission(Commission commission);

	/**
	 * Load an existing Commission entity
	 * 
	 */
	public Set<Commission> loadCommission();

	/**
	 * Save an existing Authorities entity
	 * 
	 */
	public void saveCommission(Commission commission1);

	/**
	 */
	public Commission findCommissionByPrimaryKey(Integer commissionId);

	/**
	 */
	public  List<Commission> findCommissionsBySalesRepId(Integer salesRepId);

	/**
	 * Return all Authorities entity
	 * 
	 */
	public List<Commission> findAllCommission(Integer startResult, Integer maxRows);
}