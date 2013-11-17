package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Templatedaily;

/**
 * DAO to manage Templatedaily entities.
 * 
 */
public interface TemplatedailyDAO extends JpaDao<Templatedaily> {

	/**
	 * JPQL Query - findTemplatedailyByDescriptionContaining
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByDescriptionContaining
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByTemplateNameContaining
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByTemplateNameContaining(String templateName) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByTemplateNameContaining
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByTemplateNameContaining(String templateName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplatedailys
	 *
	 */
	public Set<Templatedaily> findAllTemplatedailys() throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplatedailys
	 *
	 */
	public Set<Templatedaily> findAllTemplatedailys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByTemplateName
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByTemplateName(String templateName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByTemplateName
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByTemplateName(String templateName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByDailyTemplateId
	 *
	 */
	public Templatedaily findTemplatedailyByDailyTemplateId(Integer dailyTemplateId) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByDailyTemplateId
	 *
	 */
	public Templatedaily findTemplatedailyByDailyTemplateId(Integer dailyTemplateId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByPrimaryKey
	 *
	 */
	public Templatedaily findTemplatedailyByPrimaryKey(Integer dailyTemplateId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByPrimaryKey
	 *
	 */
	public Templatedaily findTemplatedailyByPrimaryKey(Integer dailyTemplateId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByNumTimeSlots
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByNumTimeSlots(Integer numTimeSlots) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByNumTimeSlots
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByNumTimeSlots(Integer numTimeSlots, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByDescription
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplatedailyByDescription
	 *
	 */
	public Set<Templatedaily> findTemplatedailyByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

}