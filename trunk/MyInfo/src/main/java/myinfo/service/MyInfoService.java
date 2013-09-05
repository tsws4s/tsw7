package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.domain.MyInfo;

/**
 * Spring service that handles CRUD requests for MyInfo entities
 * 
 */
public interface MyInfoService {

	/**
	 * Save an existing MyInfo entity
	 * 
	 */
	public void saveMyInfo(MyInfo myinfo);

	/**
	 * Load an existing MyInfo entity
	 * 
	 */
	public Set<MyInfo> loadMyInfos();

	/**
	 */
	public MyInfo findMyInfoByPrimaryKey(Integer myInfoId);

	/**
	 * Return all MyInfo entity
	 * 
	 */
	public List<MyInfo> findAllMyInfos(Integer startResult, Integer maxRows);

	/**
	 * Return a count of all MyInfo entity
	 * 
	 */
	public Integer countMyInfos();

	/**
	 * Delete an existing MyInfo entity
	 * 
	 */
	public void deleteMyInfo(MyInfo myinfo_1);
}