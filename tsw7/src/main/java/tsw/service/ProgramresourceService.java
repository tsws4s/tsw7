package tsw.service;

import java.util.List;
import java.util.Set;
import tsw.domain.Programresource;

/**
 * Spring service that handles CRUD requests for Programresource entities
 * 
 */
public interface ProgramresourceService {

	/**
	 * Save an existing Programresource entity
	 * @return 
	 * 
	 */
	public Programresource saveProgramresource(Programresource programresource, Integer programId, Integer resourceId, Integer priceId);

	/**
	 */
	public Programresource findProgramresourceByPrimaryKey(Integer programResourceId);

	/**
	 * Load an existing Programresource entity
	 * 
	 */
	public Set<Programresource> loadProgramresources();

	/**
	 * Delete an existing Programresource entity
	 * 
	 */
	public void deleteProgramresource(Programresource programresource_1);

	/**
	 * Return all Programresource entity
	 * 
	 */
	public List<Programresource> findAllProgramresources(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all Programresource entity
	 * 
	 */
	public Integer countProgramresources();
}