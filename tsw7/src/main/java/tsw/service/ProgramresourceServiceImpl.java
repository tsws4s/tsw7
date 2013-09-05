package tsw.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tsw.dao.PriceDAO;
import tsw.dao.ProgramDAO;
import tsw.dao.ProgramresourceDAO;
import tsw.dao.ResourceDAO;
import tsw.domain.Programresource;
import tsw.web.UsersController;

/**
 * Spring service that handles CRUD requests for Programresource entities
 * 
 */

@Service("ProgramresourceService")
@Transactional
public class ProgramresourceServiceImpl implements ProgramresourceService {
	
	int defaultMaxRows = UsersController.getDefaultMaxRows();

	/**
	 * DAO injected by Spring that manages Program entities
	 * 
	 */
	@Autowired
	private ProgramDAO programDAO;
		
	@Autowired
	private ResourceDAO resourceDAO;
	
	@Autowired
	private PriceDAO priceDAO;

	@Autowired
	private ProgramresourceDAO programresourceDAO;

	/**
	 * Instantiates a new ProgramresourceServiceImpl.
	 *
	 */
	public ProgramresourceServiceImpl() {
	}

	/**
	 * Save an existing Programresource entity
	 * 
	 */
	@Transactional
	public Programresource saveProgramresource(Programresource programresource, Integer programId, Integer resourceId, Integer priceId) {
		Programresource existingProgramresource = programresourceDAO.findProgramresourceByPrimaryKey(programresource.getProgramResourceId());

		if (existingProgramresource != null) {
			if (existingProgramresource != programresource) {
				existingProgramresource.setProgramResourceId(programresource.getProgramResourceId());
				existingProgramresource.setResource(programresource.getResource());
				existingProgramresource.setResourcePrice(programresource.getResourcePrice());
			}
			programresource = existingProgramresource;
		} else {
			int programResourceId = programresourceDAO.getMaxProgramResourceId();
			programresource.setProgramResourceId(programResourceId+1);
		}
		if(resourceId!=null && resourceId>0){
			programresource.setResource(resourceDAO.findResourceByPrimaryKey(resourceId));
		}
		if(programId!=null && programId>0){
			programresource.setProgram(programDAO.findProgramByPrimaryKey(programId));
		}
		if(priceId!=null && priceId>0){
			programresource.setResourcePrice(priceDAO.findPriceByPrimaryKey(priceId));
		}

		programresource = programresourceDAO.store(programresource);
		programresourceDAO.flush();
		return programresource;
	}

	/**
	 */
	@Transactional
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId) {
		return programresourceDAO.findProgramresourceByPrimaryKey(programResourceId);
	}

	/**
	 * Load an existing Programresource entity
	 * 
	 */
	@Transactional
	public Set<Programresource> loadProgramresources() {
		return programresourceDAO.findAllProgramresources();
	}

	/**
	 * Delete an existing Programresource entity
	 * 
	 */
	@Transactional
	public void deleteProgramresource(Programresource programresource) {
		programresourceDAO.remove(programresource);
		programresourceDAO.flush();
	}

	/**
	 * Return all Programresource entity
	 * 
	 */
	@Transactional
	public List<Programresource> findAllProgramresources(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Programresource>(programresourceDAO.findAllProgramresources(startResult, maxRows));
	}

	/**
	 * Return a count of all Programresource entity
	 * 
	 */
	@Transactional
	public Integer countProgramresources() {
		return ((Long) programresourceDAO.createQuerySingleResult("select count(o) from Programresource o").getSingleResult()).intValue();
	}
}
