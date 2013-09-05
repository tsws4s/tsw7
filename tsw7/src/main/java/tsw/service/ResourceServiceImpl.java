package tsw.service;

import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import tsw.dao.PriceDAO;
import tsw.dao.ResourceDAO;
import tsw.dao.TswacctDAO;

import tsw.domain.Resource;
import tsw.domain.Tswacct;
import tsw.web.SessionConfigCache;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Resource entities
 * 
 */

@Service("ResourceService")
@Transactional
public class ResourceServiceImpl implements ResourceService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();  
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * DAO injected by Spring that manages Resource entities
	 * 
	 */
	@Autowired
	private ResourceDAO resourceDAO;

	/**
	 * DAO injected by Spring that manages Tswacct entities
	 * 
	 */
	@Autowired
	private TswacctDAO tswacctDAO;
	
	@Autowired
	private PriceDAO priceDAO;
	/**
	 * Instantiates a new ResourceServiceImpl.
	 *
	 */
	public ResourceServiceImpl() {
	}

	/**
	 * Delete an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Resource deleteResourceTswacct(Integer resource_resourceId, Integer related_tswacct_tswAcctId) {
		Resource resource = resourceDAO.findResourceByPrimaryKey(resource_resourceId, -1, defaultMaxRows);
		Tswacct related_tswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct_tswAcctId, -1, defaultMaxRows);

		resource.setTswacct(null);
		related_tswacct.getResources().remove(resource);
		resource = resourceDAO.store(resource);
		resourceDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		tswacctDAO.remove(related_tswacct);
		tswacctDAO.flush();

		return resource;
	}

	/**
	 * Save an existing Tswacct entity
	 * 
	 */
	@Transactional
	public Resource saveResourceTswacct(Integer resourceId, Tswacct related_tswacct) {
		Resource resource = resourceDAO.findResourceByPrimaryKey(resourceId, -1, defaultMaxRows);
		Tswacct existingtswacct = tswacctDAO.findTswacctByPrimaryKey(related_tswacct.getTswAcctId());

		// copy into the existing record to preserve existing relationships
		if (existingtswacct != null) {
			existingtswacct.setTswAcctId(related_tswacct.getTswAcctId());
			existingtswacct.setAcctName(related_tswacct.getAcctName());
			existingtswacct.setSubscrType(related_tswacct.getSubscrType());
			existingtswacct.setAmtPaid(related_tswacct.getAmtPaid());
			existingtswacct.setEstablishDate(related_tswacct.getEstablishDate());
			existingtswacct.setExpireDate(related_tswacct.getExpireDate());
			existingtswacct.setActiveYn(related_tswacct.getActiveYn());
			related_tswacct = existingtswacct;
		} else {
			related_tswacct = tswacctDAO.store(related_tswacct);
			tswacctDAO.flush();
		}

		resource.setTswacct(related_tswacct);
		related_tswacct.getResources().add(resource);
		resource = resourceDAO.store(resource);
		resourceDAO.flush();

		related_tswacct = tswacctDAO.store(related_tswacct);
		tswacctDAO.flush();

		return resource;
	}

	/**
	 * Delete an existing Resource entity
	 * 
	 */
	@Transactional
	public void deleteResource(Resource resource) {
		resourceDAO.remove(resource);
		resourceDAO.flush();
	}

	/**
	 * Load an existing Resource entity
	 * 
	 */
	@Transactional
	public Set<Resource> loadResources4tsw(Tswacct tswacct) {
		return resourceDAO.findAllResources4tsw(tswacct.getTswAcctId());
	}
	@Transactional
	public Set<Resource> loadResources4tsw(Tswacct tswacct, int from) {
		return resourceDAO.findAllResources4tsw(tswacct.getTswAcctId(), from,-1);
	}
	
	/**
	 * Save an existing Resource entity
	 * 
	 */
	@Transactional
	public void saveResource(HttpServletRequest request, Resource resource, Integer priceId) {
		Resource existingResource = resourceDAO.findResourceByPrimaryKey(resource.getResourceId());

		if (existingResource != null) {
			if (existingResource != resource) {
				existingResource.setResourceId(resource.getResourceId());
				existingResource.setResourceName(resource.getResourceName());
				existingResource.setActiveYn(resource.getActiveYn());
				existingResource.setNotes(resource.getNotes());
				existingResource.setResourceType(resource.getResourceType());
				existingResource.setEmail(resource.getEmail());
				existingResource.setPhone(resource.getPhone());
				existingResource.setAddress(resource.getAddress());
				existingResource.setCity(resource.getCity());
				existingResource.setState(resource.getState());
				existingResource.setZipcode(resource.getZipcode());
			}
			resource = existingResource;
		} else {
			int resId = resourceDAO.getMaxResourceID();
			resource.setResourceId(resId+1);
			resource.setTswacct(sessionCache.getTswacct(request));			
		}
		if(priceId!=null && priceId>0){
			resource.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		resource = resourceDAO.store(resource);
		resourceDAO.flush();
	}

	/**
	 * Return all Resource entity
	 * 
	 */
	@Transactional
	public List<Resource> findAllResources4tsw(Tswacct tswacct, Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Resource>(resourceDAO.findAllResources4tsw(tswacct.getTswAcctId(), startResult, maxRows));
	}

	/**
	 * Return a count of all Resource entity
	 * 
	 */
	@Transactional
	public Integer countResources() {
		return ((Long) resourceDAO.createQuerySingleResult("select count(o) from Resource o").getSingleResult()).intValue();
	}

	/**
	 */
	@Transactional
	public Resource findResourceByPrimaryKey(Integer resourceId) {
		return resourceDAO.findResourceByPrimaryKey(resourceId);
	}
	
	@Transactional
	public Resource findResourceByResourceName(Tswacct tswacct, String resourceName) {
		return resourceDAO.findResourceByResourceName(tswacct, resourceName);
	}
	
	@Override
	public Integer getResourceCount4tsw(Tswacct tswacct) {
		int tswId = tswacct.getTswAcctId();
		return ((Long) resourceDAO.createQuerySingleResult("select count(resourceId) from Resource o where tswAcctFk = '"+tswId+"'").getSingleResult()).intValue();
	}
}
