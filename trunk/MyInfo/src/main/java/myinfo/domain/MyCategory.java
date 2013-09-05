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
		@NamedQuery(name = "findAllMyCategorys", query = "select myMyCategory from MyCategory myMyCategory"),
		@NamedQuery(name = "findMyCategoryByActive", query = "select myMyCategory from MyCategory myMyCategory where myMyCategory.active = ?1"),
		@NamedQuery(name = "findMyCategoryByCategoryId", query = "select myMyCategory from MyCategory myMyCategory where myMyCategory.categoryId = ?1"),
		@NamedQuery(name = "findMyCategoryByCategoryName", query = "select myMyCategory from MyCategory myMyCategory where myMyCategory.categoryName = ?1"),
		@NamedQuery(name = "findMyCategoryByCategoryNameContaining", query = "select myMyCategory from MyCategory myMyCategory where myMyCategory.categoryName like ?1"),
		@NamedQuery(name = "findMyCategoryByPrimaryKey", query = "select myMyCategory from MyCategory myMyCategory where myMyCategory.categoryId = ?1") })
@Table(catalog = "C324877_mystuff", name = "my_category")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "MyInfo/myinfo/domain", name = "MyCategory")
public class MyCategory implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "category_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer categoryId;
	/**
	 */

	@Column(name = "category_name", length = 95, nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String categoryName;
	/**
	 */

	@Column(name = "active", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer active;

	/**
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 */
	public Integer getCategoryId() {
		return this.categoryId;
	}

	/**
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 */
	public String getCategoryName() {
		return this.categoryName;
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
	public MyCategory() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(MyCategory that) {
		setCategoryId(that.getCategoryId());
		setCategoryName(that.getCategoryName());
		setActive(that.getActive());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("categoryId=[").append(categoryId).append("] ");
		buffer.append("categoryName=[").append(categoryName).append("] ");
		buffer.append("active=[").append(active).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((categoryId == null) ? 0 : categoryId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof MyCategory))
			return false;
		MyCategory equalCheck = (MyCategory) obj;
		if ((categoryId == null && equalCheck.categoryId != null) || (categoryId != null && equalCheck.categoryId == null))
			return false;
		if (categoryId != null && !categoryId.equals(equalCheck.categoryId))
			return false;
		return true;
	}
}
