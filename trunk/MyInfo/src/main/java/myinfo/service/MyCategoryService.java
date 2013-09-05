package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.MyCategory;

/**
 * Spring service that handles CRUD requests for MyCategory entities
 * 
 */
public interface MyCategoryService {

	/**
	 * Return all MyCategory entity
	 * 
	 */
	public List<MyCategory> findAllMyCategorys(Integer startResult, Integer maxRows);

	/**
	 */
	public MyCategory findMyCategoryByPrimaryKey(Integer categoryId);

	/**
	 * Return a count of all MyCategory entity
	 * 
	 */
	public Integer countMyCategorys();

	/**
	 * Delete an existing MyCategory entity
	 * 
	 */
	public void deleteMyCategory(MyCategory mycategory);

	/**
	 * Load an existing MyCategory entity
	 * 
	 */
	public Set<MyCategory> loadMyCategorys();

	/**
	 * Save an existing MyCategory entity
	 * 
	 */
	public void saveMyCategory(MyCategory mycategory_1);
}