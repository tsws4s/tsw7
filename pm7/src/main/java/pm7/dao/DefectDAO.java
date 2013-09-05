package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Defect;

/**
 * DAO to manage Defect entities.
 * 
 */
public interface DefectDAO extends JpaDao<Defect> {

	/**
	 * JPQL Query - findDefectByDefectDescriptinContaining
	 *
	 */
	public Set<Defect> findDefectByDefectDescriptinContaining(String defectDescriptin) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectDescriptinContaining
	 *
	 */
	public Set<Defect> findDefectByDefectDescriptinContaining(String defectDescriptin, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectName
	 *
	 */
	public Set<Defect> findDefectByDefectName(String defectName) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectName
	 *
	 */
	public Set<Defect> findDefectByDefectName(String defectName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectId
	 *
	 */
	public Defect findDefectByDefectId(Integer defectId) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectId
	 *
	 */
	public Defect findDefectByDefectId(Integer defectId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllDefects
	 *
	 */
	public Set<Defect> findAllDefects() throws DataAccessException;

	/**
	 * JPQL Query - findAllDefects
	 *
	 */
	public Set<Defect> findAllDefects(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectNameContaining
	 *
	 */
	public Set<Defect> findDefectByDefectNameContaining(String defectName_1) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectNameContaining
	 *
	 */
	public Set<Defect> findDefectByDefectNameContaining(String defectName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectPriority
	 *
	 */
	public Set<Defect> findDefectByDefectPriority(String defectPriority) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectPriority
	 *
	 */
	public Set<Defect> findDefectByDefectPriority(String defectPriority, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByStatusContaining
	 *
	 */
	public Set<Defect> findDefectByStatusContaining(String status) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByStatusContaining
	 *
	 */
	public Set<Defect> findDefectByStatusContaining(String status, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectPriorityContaining
	 *
	 */
	public Set<Defect> findDefectByDefectPriorityContaining(String defectPriority_1) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectPriorityContaining
	 *
	 */
	public Set<Defect> findDefectByDefectPriorityContaining(String defectPriority_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectDescriptin
	 *
	 */
	public Set<Defect> findDefectByDefectDescriptin(String defectDescriptin_1) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByDefectDescriptin
	 *
	 */
	public Set<Defect> findDefectByDefectDescriptin(String defectDescriptin_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByPrimaryKey
	 *
	 */
	public Defect findDefectByPrimaryKey(Integer defectId_1) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByPrimaryKey
	 *
	 */
	public Defect findDefectByPrimaryKey(Integer defectId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByStatus
	 *
	 */
	public Set<Defect> findDefectByStatus(String status_1) throws DataAccessException;

	/**
	 * JPQL Query - findDefectByStatus
	 *
	 */
	public Set<Defect> findDefectByStatus(String status_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxDefectId();
}