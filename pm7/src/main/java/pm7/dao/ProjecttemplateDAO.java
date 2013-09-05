package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Projecttemplate;

/**
 * DAO to manage Projecttemplate entities.
 * 
 */
public interface ProjecttemplateDAO extends JpaDao<Projecttemplate> {

	/**
	 * JPQL Query - findProjecttemplateByTemplateName
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateName(String templateName) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateName
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateName(String templateName, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByPrimaryKey
	 *
	 */
	public Projecttemplate findProjecttemplateByPrimaryKey(Integer templateId) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByPrimaryKey
	 *
	 */
	public Projecttemplate findProjecttemplateByPrimaryKey(Integer templateId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateNameContaining
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateNameContaining(String templateName_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateNameContaining
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateNameContaining(String templateName_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateId
	 *
	 */
	public Projecttemplate findProjecttemplateByTemplateId(Integer templateId_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateId
	 *
	 */
	public Projecttemplate findProjecttemplateByTemplateId(Integer templateId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateDesc
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateDesc(String templateDesc) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateDesc
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateDesc(String templateDesc, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateDescContaining
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateDescContaining(String templateDesc_1) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByTemplateDescContaining
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByTemplateDescContaining(String templateDesc_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByActiveYn
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByActiveYn(Integer activeYn) throws DataAccessException;

	/**
	 * JPQL Query - findProjecttemplateByActiveYn
	 *
	 */
	public Set<Projecttemplate> findProjecttemplateByActiveYn(Integer activeYn, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAllProjecttemplates
	 *
	 */
	public Set<Projecttemplate> findAllProjecttemplates() throws DataAccessException;

	/**
	 * JPQL Query - findAllProjecttemplates
	 *
	 */
	public Set<Projecttemplate> findAllProjecttemplates(int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxProjecttemplateId();
}