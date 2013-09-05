package pm7.service;

import java.util.List;
import java.util.Set;

import pm7.domain.Account;
import pm7.domain.Project;
import pm7.domain.Testcase;
import pm7.domain.Testcasestep;

/**
 * Spring service that handles CRUD requests for Testcasestep entities
 * 
 */
public interface TestcasestepService {

	/**
	 * Save an existing Account entity
	 * 
	 */
	public Testcasestep saveTestcasestepAccount(Integer testStepId, Account related_account);

	/**
	 * Delete an existing Testcase entity
	 * 
	 */
	public Testcasestep deleteTestcasestepTestcase(Integer testcasestep_testStepId, Integer related_testcase_testId);

	/**
	 * Return all Testcasestep entity
	 * 
	 */
	public List<Testcasestep> findAllTestcasesteps(Integer startResult, Integer maxRows);

	/**
	 * Delete an existing Testcasestep entity
	 * 
	 */
	public void deleteTestcasestep(Testcasestep testcasestep);

	/**
	 * Delete an existing Account entity
	 * 
	 */
	public Testcasestep deleteTestcasestepAccount(Integer testcasestep_testStepId_1, Integer related_account_accountId);

	/**
	 * Save an existing Testcase entity
	 * 
	 */
	public Testcasestep saveTestcasestepTestcase(Integer testStepId_1, Testcase related_testcase);

	/**
	 * Delete an existing Project entity
	 * 
	 */
	public Testcasestep deleteTestcasestepProject(Integer testcasestep_testStepId_2, Integer related_project_projectId);

	/**
	 * Return a count of all Testcasestep entity
	 * 
	 */
	public Integer countTestcasesteps();

	/**
	 * Load an existing Testcasestep entity
	 * 
	 */
	public Set<Testcasestep> loadTestcasesteps();

	/**
	 */
	public Testcasestep findTestcasestepByPrimaryKey(Integer testStepId_2);

	/**
	 * Save an existing Project entity
	 * 
	 */
	public Testcasestep saveTestcasestepProject(Integer testStepId_3, Project related_project);

	/**
	 * Save an existing Testcasestep entity
	 * 
	 */
	public Testcasestep saveTestcasestep(Testcasestep testcasestep_1);
}