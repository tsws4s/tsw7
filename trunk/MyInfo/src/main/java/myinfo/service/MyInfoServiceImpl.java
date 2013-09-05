//**********************************************************
// MyInfoServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 03/04/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package myinfo.service;

import java.util.List;
import java.util.Set;

import myinfo.dao.MyInfoDAO;

import myinfo.domain.MyInfo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 * Spring service that handles CRUD requests for MyInfo entities
 * 
 */

@Service("MyInfoService")
@Transactional
public class MyInfoServiceImpl implements MyInfoService {

	/**
	 * DAO injected by Spring that manages MyInfo entities
	 * 
	 */
	@Autowired
	private MyInfoDAO myInfoDAO;

	/**
	 * Instantiates a new MyInfoServiceImpl.
	 *
	 */
	public MyInfoServiceImpl() {
	}

	/**
	 * Save an existing MyInfo entity
	 * 
	 */
	@Transactional
	public void saveMyInfo(MyInfo myinfo) {
		MyInfo existingMyInfo = myInfoDAO.findMyInfoByPrimaryKey(myinfo.getMyInfoId());

		if (existingMyInfo != null) {
			if (existingMyInfo != myinfo) {
				existingMyInfo.setMyInfoId(myinfo.getMyInfoId());
				existingMyInfo.setTitle(myinfo.getTitle());
				existingMyInfo.setUrl(myinfo.getUrl());
				existingMyInfo.setCategoryFk(myinfo.getCategoryFk());
				existingMyInfo.setUsername(myinfo.getUsername());
				existingMyInfo.setPassword(myinfo.getPassword());
				existingMyInfo.setFilename(myinfo.getFilename());
				existingMyInfo.setAccount(myinfo.getAccount());
				existingMyInfo.setUserFk(myinfo.getUserFk());
				existingMyInfo.setActive(myinfo.getActive());
			}
			myinfo = myInfoDAO.store(existingMyInfo);
		} else {
			myinfo = myInfoDAO.store(myinfo);
		}
		myInfoDAO.flush();
	}

	/**
	 * Load an existing MyInfo entity
	 * 
	 */
	@Transactional
	public Set<MyInfo> loadMyInfos() {
		return myInfoDAO.findAllMyInfos();
	}

	/**
	 */
	@Transactional
	public MyInfo findMyInfoByPrimaryKey(Integer myInfoId) {
		return myInfoDAO.findMyInfoByPrimaryKey(myInfoId);
	}

	/**
	 * Return all MyInfo entity
	 * 
	 */
	@Transactional
	public List<MyInfo> findAllMyInfos(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<MyInfo>(myInfoDAO.findAllMyInfos(startResult, maxRows));
	}

	/**
	 * Return a count of all MyInfo entity
	 * 
	 */
	@Transactional
	public Integer countMyInfos() {
		return ((Long) myInfoDAO.createQuerySingleResult("select count(o) from MyInfo o").getSingleResult()).intValue();
	}

	/**
	 * Delete an existing MyInfo entity
	 * 
	 */
	@Transactional
	public void deleteMyInfo(MyInfo myinfo) {
		myInfoDAO.remove(myinfo);
		myInfoDAO.flush();
	}
}
