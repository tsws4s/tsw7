package wsdm.domain;

import java.io.Serializable;

import java.lang.StringBuilder;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.*;

import javax.persistence.*;


@Entity
@NamedQueries({
		@NamedQuery(name = "findAllCustomers", query = "select myCustomer from Customer myCustomer"),
		@NamedQuery(name = "findCustomerByActiveYn", query = "select myCustomer from Customer myCustomer where myCustomer.activeYn = ?1"),
		@NamedQuery(name = "findCustomerByAdminYn", query = "select myCustomer from Customer myCustomer where myCustomer.adminYn = ?1"),
		@NamedQuery(name = "findCustomerByCustomerId", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1"),
		@NamedQuery(name = "findCustomerByFirstname", query = "select myCustomer from Customer myCustomer where myCustomer.firstname = ?1"),
		@NamedQuery(name = "findCustomerByFirstnameContaining", query = "select myCustomer from Customer myCustomer where myCustomer.firstname like ?1"),
		@NamedQuery(name = "findCustomerByLastname", query = "select myCustomer from Customer myCustomer where myCustomer.lastname = ?1"),
		@NamedQuery(name = "findCustomerByLastnameContaining", query = "select myCustomer from Customer myCustomer where myCustomer.lastname like ?1"),
		@NamedQuery(name = "findCustomerByPassword", query = "select myCustomer from Customer myCustomer where myCustomer.password = ?1"),
		@NamedQuery(name = "findCustomerByPrimaryKey", query = "select myCustomer from Customer myCustomer where myCustomer.customerId = ?1") })

@Table(catalog = "C324877_tsws4s", name = "Customer")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm4/wsdm/domain", name = "Customer")
@XmlRootElement(namespace = "wsdm4/wsdm/domain")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;



	@Column(name = "customerID", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer customerId;
	/**
	 */

	@Column(name = "email", length = 155)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String email;
	/**
	 */

	@Column(name = "firstname", length = 55)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String firstname;
	/**
	 */

	@Column(name = "lastname", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String lastname;
	/**
	 */

	@Column(name = "phone", length = 25)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String phone;
	/**
	 */

	@Column(name = "yearBorn")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer yearBorn;
	/**
	 */

	@Column(name = "address", length = 145)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String address;
	/**
	 */

	@Column(name = "city", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String city;
	/**
	 */

	@Column(name = "state", length = 65)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String state;
	/**
	 */

	@Column(name = "zipcode", length = 15)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String zipcode;
	/**
	 */

	@Column(name = "addrSameAsFamily")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer addrSameAsFamily;
	/**
	 */

	@Column(name = "activeYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer activeYn;
	/**
	 */

	@Column(name = "password", length = 75)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String password;
	/**
	 */

	@Column(name = "selectTheme", length = 85)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	String selectTheme;
	/**
	 */

	@Column(name = "adminYN")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Integer adminYn;

	/**
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	/**
	 */
	public Integer getCustomerId() {
		return this.customerId;
	}

	/**
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 */
	public String getEmail() {
		return this.email;
	}

	/**
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 */
	public String getFirstname() {
		return this.firstname;
	}

	/**
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 */
	public String getLastname() {
		return this.lastname;
	}

	/**
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 */
	public String getPhone() {
		return this.phone;
	}

	/**
	 */
	public void setYearBorn(Integer yearBorn) {
		this.yearBorn = yearBorn;
	}

	/**
	 */
	public Integer getYearBorn() {
		return this.yearBorn;
	}

	/**
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 */
	public String getAddress() {
		return this.address;
	}

	/**
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 */
	public String getCity() {
		return this.city;
	}

	/**
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 */
	public String getState() {
		return this.state;
	}

	/**
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	/**
	 */
	public String getZipcode() {
		return this.zipcode;
	}

	/**
	 */
	public void setAddrSameAsFamily(Integer addrSameAsFamily) {
		this.addrSameAsFamily = addrSameAsFamily;
	}

	/**
	 */
	public Integer getAddrSameAsFamily() {
		return this.addrSameAsFamily;
	}

	/**
	 */
	public void setActiveYn(Integer activeYn) {
		this.activeYn = activeYn;
	}

	/**
	 */
	public Integer getActiveYn() {
		return this.activeYn;
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
	public void setSelectTheme(String selectTheme) {
		this.selectTheme = selectTheme;
	}

	/**
	 */
	public String getSelectTheme() {
		return this.selectTheme;
	}

	/**
	 */
	public void setAdminYn(Integer adminYn) {
		this.adminYn = adminYn;
	}

	/**
	 */
	public Integer getAdminYn() {
		return this.adminYn;
	}


	/**
	 */
	public Customer() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Customer that) {
		setCustomerId(that.getCustomerId());
		setEmail(that.getEmail());
		setFirstname(that.getFirstname());
		setLastname(that.getLastname());
		setPhone(that.getPhone());
		setYearBorn(that.getYearBorn());
		setAddress(that.getAddress());
		setCity(that.getCity());
		setState(that.getState());
		setZipcode(that.getZipcode());
		setAddrSameAsFamily(that.getAddrSameAsFamily());
		setActiveYn(that.getActiveYn());
		setPassword(that.getPassword());
		setSelectTheme(that.getSelectTheme());
		setAdminYn(that.getAdminYn());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("customerId=[").append(customerId).append("] ");
		buffer.append("email=[").append(email).append("] ");
		buffer.append("firstname=[").append(firstname).append("] ");
		buffer.append("lastname=[").append(lastname).append("] ");
		buffer.append("phone=[").append(phone).append("] ");
		buffer.append("yearBorn=[").append(yearBorn).append("] ");
		buffer.append("address=[").append(address).append("] ");
		buffer.append("city=[").append(city).append("] ");
		buffer.append("state=[").append(state).append("] ");
		buffer.append("zipcode=[").append(zipcode).append("] ");
		buffer.append("addrSameAsFamily=[").append(addrSameAsFamily).append("] ");
		buffer.append("activeYn=[").append(activeYn).append("] ");
		buffer.append("password=[").append(password).append("] ");
		buffer.append("selectTheme=[").append(selectTheme).append("] ");
		buffer.append("adminYn=[").append(adminYn).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((customerId == null) ? 0 : customerId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Customer))
			return false;
		Customer equalCheck = (Customer) obj;
		if ((customerId == null && equalCheck.customerId != null) || (customerId != null && equalCheck.customerId == null))
			return false;
		if (customerId != null && !customerId.equals(equalCheck.customerId))
			return false;
		return true;
	}
}
