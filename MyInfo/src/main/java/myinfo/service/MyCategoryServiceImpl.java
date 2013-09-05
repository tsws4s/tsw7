//**********************************************************
// MyCategoryServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 03/04/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.dao.MyCategoryDAO;

import myinfo.domain.MyCategory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for MyCategory entities
 * 
 */

@Service("MyCategoryService")
@Transactional
public class MyCategoryServiceImpl implements MyCategoryService {

	/**
	 * DAO injected by Spring that manages MyCategory entities
	 * 
	 */
	@Autowired
	private MyCategoryDAO myCategoryDAO;

	/**
	 * Instantiates a new MyCategoryServiceImpl.
	 *
	 */
	public MyCategoryServiceImpl() {
	}

	/**
	 * Return all MyCategory entity
	 * 
	 */
	@Transactional
	public List<MyCategory> findAllMyCategorys(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<MyCategory>(myCategoryDAO.findAllMyCategorys(startResult, maxRows));
	}

	/**
	 */
	@Transactional
	public MyCategory findMyCategoryByPrimaryKey(Integer categoryId) {
		return myCategoryDAO.findMyCategoryByPrimaryKey(categoryId);
	}

	/**
	 * Return a count of all MyCategory entity
	 * 
	 */
	@Transactional
	public Integer countMyCategorys() {
		return ((Long) myCategoryDAO.createQuerySingleResult("select count(o) from MyCategory o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing MyCategory entity
	 * 
	 */
	@Transactional
	public void deleteMyCategory(MyCategory mycategory) {
		myCategoryDAO.remove(mycategory);
		myCategoryDAO.flush();
	}

	/**
	 * Load an existing MyCategory entity
	 * 
	 */
	@Transactional
	public Set<MyCategory> loadMyCategorys() {
		return myCategoryDAO.findAllMyCategorys();
	}

	/**
	 * Save an existing MyCategory entity
	 * 
	 */
	@Transactional
	public void saveMyCategory(MyCategory mycategory) {
		MyCategory existingMyCategory = myCategoryDAO.findMyCategoryByPrimaryKey(mycategory.getCategoryId());

		if (existingMyCategory != null) {
			if (existingMyCategory != mycategory) {
				existingMyCategory.setCategoryId(mycategory.getCategoryId());
				existingMyCategory.setCategoryName(mycategory.getCategoryName());
				existingMyCategory.setActive(mycategory.getActive());
			}
			mycategory = myCategoryDAO.store(existingMyCategory);
		} else {
			mycategory = myCategoryDAO.store(mycategory);
		}
		myCategoryDAO.flush();
	}
}
