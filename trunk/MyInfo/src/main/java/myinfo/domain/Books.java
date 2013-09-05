package myinfo.domain;

import java.io.Serializable;

import java.lang.StringBuilder;

import java.math.BigDecimal;

import java.util.Calendar;

import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.*;

import javax.persistence.*;

/**
 */

@Entity
@NamedQueries({
		@NamedQuery(name = "findAllBookss", query = "select myBooks from Books myBooks"),
		@NamedQuery(name = "findBooksByAsinIsbn", query = "select myBooks from Books myBooks where myBooks.asinIsbn = ?1"),
		@NamedQuery(name = "findBooksByAsinIsbnContaining", query = "select myBooks from Books myBooks where myBooks.asinIsbn like ?1"),
		@NamedQuery(name = "findBooksByAuthor", query = "select myBooks from Books myBooks where myBooks.author = ?1"),
		@NamedQuery(name = "findBooksByAuthorContaining", query = "select myBooks from Books myBooks where myBooks.author like ?1"),
		@NamedQuery(name = "findBooksByBookId", query = "select myBooks from Books myBooks where myBooks.bookId = ?1"),
		@NamedQuery(name = "findBooksByFormat", query = "select myBooks from Books myBooks where myBooks.format = ?1"),
		@NamedQuery(name = "findBooksByFormatContaining", query = "select myBooks from Books myBooks where myBooks.format like ?1"),
		@NamedQuery(name = "findBooksByOrderDate", query = "select myBooks from Books myBooks where myBooks.orderDate = ?1"),
		@NamedQuery(name = "findBooksByOrderDateAfter", query = "select myBooks from Books myBooks where myBooks.orderDate > ?1"),
		@NamedQuery(name = "findBooksByOrderDateBefore", query = "select myBooks from Books myBooks where myBooks.orderDate < ?1"),
		@NamedQuery(name = "findBooksByPrice", query = "select myBooks from Books myBooks where myBooks.price = ?1"),
		@NamedQuery(name = "findBooksByPrimaryKey", query = "select myBooks from Books myBooks where myBooks.bookId = ?1"),
		@NamedQuery(name = "findBooksByReleaseDate", query = "select myBooks from Books myBooks where myBooks.releaseDate = ?1"),
		@NamedQuery(name = "findBooksByReleaseDateAfter", query = "select myBooks from Books myBooks where myBooks.releaseDate > ?1"),
		@NamedQuery(name = "findBooksByReleaseDateBefore", query = "select myBooks from Books myBooks where myBooks.releaseDate < ?1"),
		@NamedQuery(name = "findBooksByTitle", query = "select myBooks from Books myBooks where myBooks.title = ?1"),
		@NamedQuery(name = "findBooksByTitleContaining", query = "select myBooks from Books myBooks where myBooks.title like ?1"),
		@NamedQuery(name = "findBooksByUserFk", query = "select myBooks from Books myBooks where myBooks.userFk = ?1") })
@Table(catalog = "C324877_mystuff", name = "books")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "MyInfo/myinfo/domain", name = "Books")
public class Books implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "book_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer bookId;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar orderDate;
	/**
	 */

	@Column(name = "title", length = 245)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String title;
	/**
	 */

	@Column(name = "format", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String format;
	/**
	 */

	@Column(name = "`ASIN-ISBN`", length = 45)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String asinIsbn;
	/**
	 */

	@Column(name = "author", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String author;
	/**
	 */
	@Temporal(TemporalType.DATE)
	@Column(name = "release_date")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar releaseDate;
	/**
	 */

	@Column(name = "price", precision = 22)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal price;
	/**
	 */

	@Column(name = "user_fk")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer userFk;

	/**
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	/**
	 */
	public Integer getBookId() {
		return this.bookId;
	}

	/**
	 */
	public void setOrderDate(Calendar orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 */
	public Calendar getOrderDate() {
		return this.orderDate;
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
	public void setFormat(String format) {
		this.format = format;
	}

	/**
	 */
	public String getFormat() {
		return this.format;
	}

	/**
	 */
	public void setAsinIsbn(String asinIsbn) {
		this.asinIsbn = asinIsbn;
	}

	/**
	 */
	public String getAsinIsbn() {
		return this.asinIsbn;
	}

	/**
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 */
	public String getAuthor() {
		return this.author;
	}

	/**
	 */
	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	/**
	 */
	public Calendar getReleaseDate() {
		return this.releaseDate;
	}

	/**
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 */
	public BigDecimal getPrice() {
		return this.price;
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
	public Books() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Books that) {
		setBookId(that.getBookId());
		setOrderDate(that.getOrderDate());
		setTitle(that.getTitle());
		setFormat(that.getFormat());
		setAsinIsbn(that.getAsinIsbn());
		setAuthor(that.getAuthor());
		setReleaseDate(that.getReleaseDate());
		setPrice(that.getPrice());
		setUserFk(that.getUserFk());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("bookId=[").append(bookId).append("] ");
		buffer.append("orderDate=[").append(orderDate).append("] ");
		buffer.append("title=[").append(title).append("] ");
		buffer.append("format=[").append(format).append("] ");
		buffer.append("asinIsbn=[").append(asinIsbn).append("] ");
		buffer.append("author=[").append(author).append("] ");
		buffer.append("releaseDate=[").append(releaseDate).append("] ");
		buffer.append("price=[").append(price).append("] ");
		buffer.append("userFk=[").append(userFk).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((bookId == null) ? 0 : bookId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Books))
			return false;
		Books equalCheck = (Books) obj;
		if ((bookId == null && equalCheck.bookId != null) || (bookId != null && equalCheck.bookId == null))
			return false;
		if (bookId != null && !bookId.equals(equalCheck.bookId))
			return false;
		return true;
	}
}
