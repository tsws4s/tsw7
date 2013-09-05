package myinfo.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllMyInfos", query = "select myMyInfo from MyInfo myMyInfo"),
		@NamedQuery(name = "findMyInfoByAccount", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.account = ?1"),
		@NamedQuery(name = "findMyInfoByAccountContaining", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.account like ?1"),
		@NamedQuery(name = "findMyInfoByActive", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.active = ?1"),
		@NamedQuery(name = "findMyInfoByCategoryFk", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.categoryFk = ?1"),
		@NamedQuery(name = "findMyInfoByFilename", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.filename = ?1"),
		@NamedQuery(name = "findMyInfoByFilenameContaining", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.filename like ?1"),
		@NamedQuery(name = "findMyInfoByMyInfoId", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.myInfoId = ?1"),
		@NamedQuery(name = "findMyInfoByPassword", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.password = ?1"),
		@NamedQuery(name = "findMyInfoByPasswordContaining", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.password like ?1"),
		@NamedQuery(name = "findMyInfoByPrimaryKey", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.myInfoId = ?1"),
		@NamedQuery(name = "findMyInfoByTitle", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.title = ?1"),
		@NamedQuery(name = "findMyInfoByTitleContaining", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.title like ?1"),
		@NamedQuery(name = "findMyInfoByUrl", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.url = ?1"),
		@NamedQuery(name = "findMyInfoByUrlContaining", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.url like ?1"),
		@NamedQuery(name = "findMyInfoByUserFk", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.userFk = ?1"),
		@NamedQuery(name = "findMyInfoByUsername", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.username = ?1"),
		@NamedQuery(name = "findMyInfoByUsernameContaining", query = "select myMyInfo from MyInfo myMyInfo where myMyInfo.username like ?1") })
@Table(catalog = "C324877_mystuff", name = "my_info")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "MyInfo/myinfo/domain", name = "MyInfo")
public class MyInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "my_info_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer myInfoId;
	/**
	 */

	@Column(name = "title", length = 145, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String title;
	/**
	 */

	@Column(name = "URL", length = 195)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String url;
	/**
	 */

	@Column(name = "category_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer categoryFk;
	/**
	 */

	@Column(name = "username", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String username;
	/**
	 */

	@Column(name = "password", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "filename", length = 195)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String filename;
	/**
	 */

	@Column(name = "account", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String account;
	/**
	 */

	@Column(name = "user_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer userFk;
	/**
	 */

	@Column(name = "active")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer active;

	/**
	 */
	public void setMyInfoId(Integer myInfoId) {
		this.myInfoId = myInfoId;
	}

	/**
	 */
	public Integer getMyInfoId() {
		return this.myInfoId;
	}

	/**
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 */
	public String getUrl() {
		return this.url;
	}

	/**
	 */
	public void setCategoryFk(Integer categoryFk) {
		this.categoryFk = categoryFk;
	}

	/**
	 */
	public Integer getCategoryFk() {
		return this.categoryFk;
	}

	/**
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 */
	public String getUsername() {
		return this.username;
	}

	/**
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}

	/**
	 */
	public String getFilename() {
		return this.filename;
	}

	/**
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 */
	public String getAccount() {
		return this.account;
	}

	/**
	 */
	public void setUserFk(Integer userFk) {
		this.userFk = userFk;
	}

	/**
	 */
	public Integer getUserFk() {
		return this.userFk;
	}

	/**
	 */
	public void setActive(Integer active) {
		this.active = active;
	}

	/**
	 */
	public Integer getActive() {
		return this.active;
	}

	/**
	 */
	public MyInfo() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(MyInfo that) {
		setMyInfoId(that.getMyInfoId());
		setTitle(that.getTitle());
		setUrl(that.getUrl());
		setCategoryFk(that.getCategoryFk());
		setUsername(that.getUsername());
		setPassword(that.getPassword());
		setFilename(that.getFilename());
		setAccount(that.getAccount());
		setUserFk(that.getUserFk());
		setActive(that.getActive());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("myInfoId=[").append(myInfoId).append("] ");
		buffer.append("title=[").append(title).append("] ");
		buffer.append("url=[").append(url).append("] ");
		buffer.append("categoryFk=[").append(categoryFk).append("] ");
		buffer.append("username=[").append(username).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("filename=[").append(filename).append("] ");
		buffer.append("account=[").append(account).append("] ");
		buffer.append("userFk=[").append(userFk).append("] ");
		buffer.append("active=[").append(active).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((myInfoId == null) ? 0 : myInfoId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof MyInfo))
			return false;
		MyInfo equalCheck = (MyInfo) obj;
		if ((myInfoId == null && equalCheck.myInfoId != null) || (myInfoId != null && equalCheck.myInfoId == null))
			return false;
		if (myInfoId != null && !myInfoId.equals(equalCheck.myInfoId))
			return false;
		return true;
	}
}
