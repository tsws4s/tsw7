package tsw.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import tsw.domain.Resource;
import tsw.domain.Tswacct;

/**
 * Spring service that handles CRUD requests for Resource entities
 * 
 */
public interface ResourceService {

	public Integer getResourceCount4tsw(Tswacct tswacct);
	
	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	public Resource deleteResourceTswacct(Integer resource_resourceId_1, Integer related_tswacct_tswAcctId);

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	public Resource saveResourceTswacct(Integer resourceId, Tswacct related_tswacct);

	/**
	 * Delete an existing Resource entity
	 * 
	 */
	public void deleteResource(Resource resource);

	/**
	 * Load an existing Resource entity
	 * 
	 */
	public Set<Resource> loadResources4tsw(Tswacct tswacct);
	public Set<Resource> loadResources4tsw(Tswacct tswacct, int from);

	/**
	 * Save an existing Resource entity
	 * 
	 */
	public void saveResource(HttpServletRequest request, Resource resource_1, Integer priceId);

	/**
	 * Return all Resource entity
	 * 
	 */
	public List<Resource> findAllResources4tsw(Tswacct tswacct, Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Resource entity
	 * 
	 */
	public Integer countResources();

	/**
	 */
	public Resource findResourceByPrimaryKey(Integer resourceId_1);
	
	public Resource findResourceByResourceName(Tswacct tswacct, String resourceName);
}