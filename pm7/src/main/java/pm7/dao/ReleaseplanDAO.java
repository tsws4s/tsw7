package pm7.dao;

import java.util.Calendar;
import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Releaseplan;

/**
 * DAO to manage Releaseplan entities.
 * 
 */
public interface ReleaseplanDAO extends JpaDao<Releaseplan> {

	/**
	 * JPQL Query - findReleaseplanByReleaseCode
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseCode(String releaseCode) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseCode
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseCode(String releaseCode, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDateBefore
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDateBefore(java.util.Calendar releaseDate) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDateBefore
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDateBefore(Calendar releaseDate, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDateAfter
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDateAfter(java.util.Calendar releaseDate_1) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDateAfter
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDateAfter(Calendar releaseDate_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDescriptionContaining
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDescriptionContaining(String releaseDescription) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDescriptionContaining
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDescriptionContaining(String releaseDescription, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDescription
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDescription(String releaseDescription_1) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDescription
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDescription(String releaseDescription_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseId
	 *
	 */
	public Releaseplan findReleaseplanByReleaseId(Integer releaseId) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseId
	 *
	 */
	public Releaseplan findReleaseplanByReleaseId(Integer releaseId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByPrimaryKey
	 *
	 */
	public Releaseplan findReleaseplanByPrimaryKey(Integer releaseId_1) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByPrimaryKey
	 *
	 */
	public Releaseplan findReleaseplanByPrimaryKey(Integer releaseId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDate
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDate(java.util.Calendar releaseDate_2) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseDate
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseDate(Calendar releaseDate_2, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseName
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseName(String releaseName) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseName
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseName(String releaseName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllReleaseplans
	 *
	 */
	public Set<Releaseplan> findAllReleaseplans() throws DataAccessException;

	/**
	 * JPQL Query - findAllReleaseplans
	 *
	 */
	public Set<Releaseplan> findAllReleaseplans(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseNameContaining
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseNameContaining(String releaseName_1) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseNameContaining
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseNameContaining(String releaseName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseCodeContaining
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseCodeContaining(String releaseCode_1) throws DataAccessException;

	/**
	 * JPQL Query - findReleaseplanByReleaseCodeContaining
	 *
	 */
	public Set<Releaseplan> findReleaseplanByReleaseCodeContaining(String releaseCode_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxReleaseplanId();
}