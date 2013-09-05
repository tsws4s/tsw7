//**********************************************************
// TestcasestepServiceImpl
// 
// Author: TODO: update developer's name in comment header
// Creation date: 06/22/2013
//
// Copyright (C) 2013  Team Sportsware
//*********************************************************

package pm7.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import pm7.dao.AccountDAO;
import pm7.dao.ProjectDAO;
import pm7.dao.TestcaseDAO;
import pm7.dao.TestcasestepDAO;

import pm7.domain.Account;
import pm7.domain.Project;
import pm7.domain.Testcase;
import pm7.domain.Testcasestep;

/**
 * Spring service that handles CRUD requests for Testcasestep entities
 * 
 */

@Service("TestcasestepService")
@Transactional
public class TestcasestepServiceImpl implements TestcasestepService {

	/**
	 * DAO injected by Spring that manages Account entities
	 * 
	 */
	@Autowired
	private AccountDAO accountDAO;

	/**
	 * DAO injected by Spring that manages Project entities
	 * 
	 */
	@Autowired
	private ProjectDAO projectDAO;

	/**
	 * DAO injected by Spring that manages Testcase entities
	 * 
	 */
	@Autowired
	private TestcaseDAO testcaseDAO;

	/**
	 * DAO injected by Spring that manages Testcasestep entities
	 * 
	 */
	@Autowired
	private TestcasestepDAO testcasestepDAO;

	/**
	 * Instantiates a new TestcasestepServiceImpl.
	 *
	 */
	public TestcasestepServiceImpl() {
	}

	/**
	 * Save an existing Account entity
	 * 
	 */
	@Transactional
	public Testcasestep saveTestcasestepAccount(Integer testStepId, Account related_account) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testStepId, -1, -1);
		Account existingaccount = accountDAO.findAccountByPrimaryKey(related_account.getAccountId());

		// copy into the existing record to preserve existing relationships
		if (existingaccount != null) {
			existingaccount.setAccountId(related_account.getAccountId());
			existingaccount.setAccountName(related_account.getAccountName());
			existingaccount.setExpireDate(related_account.getExpireDate());
			related_account = existingaccount;
		} else {
			related_account = accountDAO.store(related_account);
			accountDAO.flush();
		}

		testcasestep.setAccount(related_account);
		testcasestep = testcasestepDAO.store(testcasestep);
		testcasestepDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		return testcasestep;
	}

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	@Transactional
	public Testcasestep deleteTestcasestepTestcase(Integer testcasestep_testStepId, Integer related_testcase_testId) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testcasestep_testStepId, -1, -1);
		Testcase related_testcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase_testId, -1, -1);

		testcasestep.setTestcase(null);
		related_testcase.getTestcasesteps().remove(testcasestep);
		testcasestep = testcasestepDAO.store(testcasestep);
		testcasestepDAO.flush();

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		testcaseDAO.remove(related_testcase);
		testcaseDAO.flush();

		return testcasestep;
	}

	/**
	 * Return all Testcasestep entity
	 * 
	 */
	@Transactional
	public List<Testcasestep> findAllTestcasesteps(Integer startResult, Integer maxRows) {
		return new java.util.ArrayList<Testcasestep>(testcasestepDAO.findAllTestcasesteps(startResult, maxRows));
	}

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	@Transactional
	public void deleteTestcasestep(Testcasestep testcasestep) {
		testcasestepDAO.remove(testcasestep);
		testcasestepDAO.flush();
	}

	/**
	 * Delete an existing Account entity
	 * 
	 */
	@Transactional
	public Testcasestep deleteTestcasestepAccount(Integer testcasestep_testStepId, Integer related_account_accountId) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testcasestep_testStepId, -1, -1);
		Account related_account = accountDAO.findAccountByPrimaryKey(related_account_accountId, -1, -1);

		testcasestep.setAccount(null);
		testcasestep = testcasestepDAO.store(testcasestep);
		testcasestepDAO.flush();

		related_account = accountDAO.store(related_account);
		accountDAO.flush();

		accountDAO.remove(related_account);
		accountDAO.flush();

		return testcasestep;
	}

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	@Transactional
	public Testcasestep saveTestcasestepTestcase(Integer testStepId, Testcase related_testcase) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testStepId, -1, -1);
		Testcase existingtestcase = testcaseDAO.findTestcaseByPrimaryKey(related_testcase.getTestId());

		// copy into the existing record to preserve existing relationships
		if (existingtestcase != null) {
			existingtestcase.setTestId(related_testcase.getTestId());
			existingtestcase.setPassFail(related_testcase.getPassFail());
			existingtestcase.setTestCaseCode(related_testcase.getTestCaseCode());
			existingtestcase.setTestName(related_testcase.getTestName());
			existingtestcase.setTestDescription(related_testcase.getTestDescription());
			existingtestcase.setTestSetup(related_testcase.getTestSetup());
			related_testcase = existingtestcase;
		} else {
			related_testcase = testcaseDAO.store(related_testcase);
			testcaseDAO.flush();
		}

		testcasestep.setTestcase(related_testcase);
		related_testcase.getTestcasesteps().add(testcasestep);
		testcasestep = testcasestepDAO.store(testcasestep);
		testcasestepDAO.flush();
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/

		related_testcase = testcaseDAO.store(related_testcase);
		testcaseDAO.flush();

		return testcasestep;
	}

	/**
	 * Delete an existing Project entity
	 * 
	 */
	@Transactional
	public Testcasestep deleteTestcasestepProject(Integer testcasestep_testStepId, Integer related_project_projectId) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testcasestep_testStepId, -1, -1);
		Project related_project = projectDAO.findProjectByPrimaryKey(related_project_projectId, -1, -1);

		testcasestep.setProject(null);
		related_project.getTestcasesteps().remove(testcasestep);
		testcasestep = testcasestepDAO.store(testcasestep);
		testcasestepDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		projectDAO.remove(related_project);
		projectDAO.flush();

		return testcasestep;
	}

	/**
	 * Return a count of all Testcasestep entity
	 * 
	 */
	@Transactional
	public Integer countTestcasesteps() {
		return ((Long) testcasestepDAO.createQuerySingleResult("select count(o) from Testcasestep o").getSingleResult()).intValue();
	}

	/**
	 * Load an existing Testcasestep entity
	 * 
	 */
	@Transactional
	public Set<Testcasestep> loadTestcasesteps() {
		return testcasestepDAO.findAllTestcasesteps();
	}

	/**
	 */
	@Transactional
	public Testcasestep findTestcasestepByPrimaryKey(Integer testStepId) {
		return testcasestepDAO.findTestcasestepByPrimaryKey(testStepId);
	}

	/**
	 * Save an existing Project entity
	 * 
	 */
	@Transactional
	public Testcasestep saveTestcasestepProject(Integer testStepId, Project related_project) {
		Testcasestep testcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testStepId, -1, -1);
		Project existingproject = projectDAO.findProjectByPrimaryKey(related_project.getProjectId());

		// copy into the existing record to preserve existing relationships
		if (existingproject != null) {
			existingproject.setProjectId(related_project.getProjectId());
			existingproject.setProjectName(related_project.getProjectName());
			existingproject.setProjectDesc(related_project.getProjectDesc());
			existingproject.setProjectType(related_project.getProjectType());
			existingproject.setStartDate(related_project.getStartDate());
			existingproject.setDueDate(related_project.getDueDate());
			existingproject.setCompleteDate(related_project.getCompleteDate());
			existingproject.setEstimateHrs(related_project.getEstimateHrs());
			existingproject.setActualHrs(related_project.getActualHrs());
			existingproject.setHrRate(related_project.getHrRate());
			existingproject.setActiveYn(related_project.getActiveYn());
			related_project = existingproject;
		} else {
			related_project = projectDAO.store(related_project);
			projectDAO.flush();
		}

		testcasestep.setProject(related_project);
		related_project.getTestcasesteps().add(testcasestep);
		testcasestep = testcasestepDAO.store(testcasestep);
		testcasestepDAO.flush();

		related_project = projectDAO.store(related_project);
		projectDAO.flush();

		return testcasestep;
	}

	/**
	 * Save an existing Testcasestep entity
	 * 
	 */
	@Transactional
	public Testcasestep saveTestcasestep(Testcasestep testcasestep) {
		Testcasestep existingTestcasestep = testcasestepDAO.findTestcasestepByPrimaryKey(testcasestep.getTestStepId());

		if (existingTestcasestep != null) {
			if (existingTestcasestep != testcasestep) {
				existingTestcasestep.setTestStepId(testcasestep.getTestStepId());
				existingTestcasestep.setPassFail(testcasestep.getPassFail());
				existingTestcasestep.setTestCaseStepField(testcasestep.getTestCaseStepField());
				existingTestcasestep.setStepDescription(testcasestep.getStepDescription());
				existingTestcasestep.setExpectedResult(testcasestep.getExpectedResult());
				existingTestcasestep.setActualResult(testcasestep.getActualResult());
			}
			testcasestep = testcasestepDAO.store(existingTestcasestep);
		} else {
			int testcasestepId = testcasestepDAO.getMaxTestcasestepId();
			testcasestep.setTestStepId(testcasestepId+1);
//			person.setAccount(acct);
			testcasestep = testcasestepDAO.store(testcasestep);
		}
//		if(attachmentId!=null && attachmentId>0){
//			attachment = attachmentDAO.findAccountByPrimaryKey(attachmentId);
//		}		
		/**
		if(resourceId!=null && resourceId>0){
			program.setResource(resourceDAO.findResourceByResourceId(resourceId));
		}
		if(levelId!=null && levelId>0){
			program.setLevel(levelDAO.findLevelByLevelId(levelId));
		}
		if(coordId!=null && coordId>0){
			program.setCustomer(customerDAO.findCustomerByPrimaryKey(coordId));
		}
		if(priceId!=null && priceId>0){
			program.setPrice(priceDAO.findPriceByPrimaryKey(priceId));
		}
		if(sportId!=null && sportId>0){
			program.setSport(sportDAO.findSportByPrimaryKey(sportId));
		}
		 **/
		testcasestepDAO.flush();
		return testcasestep;
		}
}
