package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Templatemonthly;

/**
 * DAO to manage Templatemonthly entities.
 * 
 */
public interface TemplatemonthlyDAO extends JpaDao<Templatemonthly> {

	/**
	 * JPQL Query - findAllTemplatemonthlys
	 *
	 */
	public Set<Templatemonthly> findAllTemplatemonthlys() throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplatemonthlys
	 *
	 */
	public Set<Templatemonthly> findAllTemplatemonthlys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateNameContaining
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByTemplateNameContaining(String templateName) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateNameContaining
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByTemplateNameContaining(String templateName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek2fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek2fk(Integer week2fk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek2fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek2fk(Integer week2fk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByDescription
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByDescription(String description) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByDescription
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByDescription(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateName
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByTemplateName(String templateName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByTemplateName
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByTemplateName(String templateName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek3fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek3fk(Integer week3fk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek3fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek3fk(Integer week3fk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByDescriptionContaining
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByDescriptionContaining(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByDescriptionContaining
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByDescriptionContaining(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByPrimaryKey
	 *
	 */
	public Templatemonthly findTemplatemonthlyByPrimaryKey(Integer monthlyTemplateId) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByPrimaryKey
	 *
	 */
	public Templatemonthly findTemplatemonthlyByPrimaryKey(Integer monthlyTemplateId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek4fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek4fk(Integer week4fk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek4fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek4fk(Integer week4fk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek1fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek1fk(Integer week1fk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek1fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek1fk(Integer week1fk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByMonthlyTemplateId
	 *
	 */
	public Templatemonthly findTemplatemonthlyByMonthlyTemplateId(Integer monthlyTemplateId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByMonthlyTemplateId
	 *
	 */
	public Templatemonthly findTemplatemonthlyByMonthlyTemplateId(Integer monthlyTemplateId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek5fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek5fk(Integer week5fk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatemonthlyByWeek5fk
	 *
	 */
	public Set<Templatemonthly> findTemplatemonthlyByWeek5fk(Integer week5fk, int startResult, int maxRows) throws DataAccessException;

}