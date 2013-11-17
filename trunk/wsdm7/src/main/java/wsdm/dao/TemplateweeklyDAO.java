package wsdm.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import wsdm.domain.Templateweekly;

/**
 * DAO to manage Templateweekly entities.
 * 
 */
public interface TemplateweeklyDAO extends JpaDao<Templateweekly> {

	/**
	 * JPQL Query - findTemplateweeklyBySatDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyBySatDailyFk(Integer satDailyFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyBySatDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyBySatDailyFk(Integer satDailyFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByDescriptionContaining
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByDescriptionContaining(String description) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByDescriptionContaining
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByDescriptionContaining(String description, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByTemplateNameContaining
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByTemplateNameContaining(String templateName) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByTemplateNameContaining
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByTemplateNameContaining(String templateName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplateweeklys
	 *
	 */
	public Set<Templateweekly> findAllTemplateweeklys() throws DataAccessException;

	/**
	 * JPQL Query - findAllTemplateweeklys
	 *
	 */
	public Set<Templateweekly> findAllTemplateweeklys(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByTemplateName
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByTemplateName(String templateName_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByTemplateName
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByTemplateName(String templateName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyBySunDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyBySunDailyFk(Integer sunDailyFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyBySunDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyBySunDailyFk(Integer sunDailyFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByDescription
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByDescription(String description_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByDescription
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByDescription(String description_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByFriDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByFriDailyFk(Integer friDailyFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByFriDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByFriDailyFk(Integer friDailyFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByWedDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByWedDailyFk(Integer wedDailyFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByWedDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByWedDailyFk(Integer wedDailyFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByThuDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByThuDailyFk(Integer thuDailyFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByThuDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByThuDailyFk(Integer thuDailyFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByMonDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByMonDailyFk(Integer monDailyFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByMonDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByMonDailyFk(Integer monDailyFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByTueDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByTueDailyFk(Integer tueDailyFk) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByTueDailyFk
	 *
	 */
	public Set<Templateweekly> findTemplateweeklyByTueDailyFk(Integer tueDailyFk, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByWeeklyTemplateId
	 *
	 */
	public Templateweekly findTemplateweeklyByWeeklyTemplateId(Integer weeklyTemplateId) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByWeeklyTemplateId
	 *
	 */
	public Templateweekly findTemplateweeklyByWeeklyTemplateId(Integer weeklyTemplateId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByPrimaryKey
	 *
	 */
	public Templateweekly findTemplateweeklyByPrimaryKey(Integer weeklyTemplateId_1) throws DataAccessException;

	/**
	 * JPQL Query - findTemplateweeklyByPrimaryKey
	 *
	 */
	public Templateweekly findTemplateweeklyByPrimaryKey(Integer weeklyTemplateId_1, int startResult, int maxRows) throws DataAccessException;

}