package pm7.dao;

import java.util.Set;

import org.skyway.spring.util.dao.JpaDao;

import org.springframework.dao.DataAccessException;

import pm7.domain.Attachment;

/**
 * DAO to manage Attachment entities.
 * 
 */
public interface AttachmentDAO extends JpaDao<Attachment> {

	/**
	 * JPQL Query - findAllAttachments
	 *
	 */
	public Set<Attachment> findAllAttachments() throws DataAccessException;

	/**
	 * JPQL Query - findAllAttachments
	 *
	 */
	public Set<Attachment> findAllAttachments(int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentType
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentType(String attachmentType) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentType
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentType(String attachmentType, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentTypeContaining
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentTypeContaining(String attachmentType_1) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentTypeContaining
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentTypeContaining(String attachmentType_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachId
	 *
	 */
	public Attachment findAttachmentByAttachId(Integer attachId) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachId
	 *
	 */
	public Attachment findAttachmentByAttachId(Integer attachId, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentUrl
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentUrl(String attachmentUrl) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentUrl
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentUrl(String attachmentUrl, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByPrimaryKey
	 *
	 */
	public Attachment findAttachmentByPrimaryKey(Integer attachId_1) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByPrimaryKey
	 *
	 */
	public Attachment findAttachmentByPrimaryKey(Integer attachId_1, int startResult, int maxRows) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentUrlContaining
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentUrlContaining(String attachmentUrl_1) throws DataAccessException;

	/**
	 * JPQL Query - findAttachmentByAttachmentUrlContaining
	 *
	 */
	public Set<Attachment> findAttachmentByAttachmentUrlContaining(String attachmentUrl_1, int startResult, int maxRows) throws DataAccessException;

	public Integer getMaxAttachmentId();
}