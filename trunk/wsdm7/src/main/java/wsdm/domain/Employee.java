package wsdm.domain;

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
		@NamedQuery(name = "findAllEmployees", query = "select myEmployee from Employee myEmployee"),
		@NamedQuery(name = "findEmployeeByBirthdate", query = "select myEmployee from Employee myEmployee where myEmployee.birthdate = ?1"),
		@NamedQuery(name = "findEmployeeByBirthdateAfter", query = "select myEmployee from Employee myEmployee where myEmployee.birthdate > ?1"),
		@NamedQuery(name = "findEmployeeByBirthdateBefore", query = "select myEmployee from Employee myEmployee where myEmployee.birthdate < ?1"),
		@NamedQuery(name = "findEmployeeByEmployeeId", query = "select myEmployee from Employee myEmployee where myEmployee.employeeId = ?1"),
		@NamedQuery(name = "findEmployeeByFirstname", query = "select myEmployee from Employee myEmployee where myEmployee.firstname = ?1"),
		@NamedQuery(name = "findEmployeeByFirstnameContaining", query = "select myEmployee from Employee myEmployee where myEmployee.firstname like ?1"),
		@NamedQuery(name = "findEmployeeByLastname", query = "select myEmployee from Employee myEmployee where myEmployee.lastname = ?1"),
		@NamedQuery(name = "findEmployeeByLastnameContaining", query = "select myEmployee from Employee myEmployee where myEmployee.lastname like ?1"),
		@NamedQuery(name = "findEmployeeByPrimaryKey", query = "select myEmployee from Employee myEmployee where myEmployee.employeeId = ?1"),
		@NamedQuery(name = "findEmployeeBySalary", query = "select myEmployee from Employee myEmployee where myEmployee.salary = ?1") })
@Table(catalog = "C324877_tsws4s", name = "Employee")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(namespace = "wsdm7/wsdm/domain", name = "Employee")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 */

	@Column(name = "employee_id", nullable = false)
	@Basic(fetch = FetchType.EAGER)
	@Id
	@XmlElement
	Integer employeeId;
	/**
	 */

	@Column(name = "firstname", length = 85)
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
	@Temporal(TemporalType.DATE)
	@Column(name = "birthdate")
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	Calendar birthdate;
	/**
	 */

	@Column(name = "salary", scale = 2, precision = 20)
	@Basic(fetch = FetchType.EAGER)
	@XmlElement
	BigDecimal salary;

	/**
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 */
	public Integer getEmployeeId() {
		return this.employeeId;
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
	public void setBirthdate(Calendar birthdate) {
		this.birthdate = birthdate;
	}

	/**
	 */
	public Calendar getBirthdate() {
		return this.birthdate;
	}

	/**
	 */
	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	/**
	 */
	public BigDecimal getSalary() {
		return this.salary;
	}

	/**
	 */
	public Employee() {
	}

	/**
	 * Copies the contents of the specified bean into this bean.
	 *
	 */
	public void copy(Employee that) {
		setEmployeeId(that.getEmployeeId());
		setFirstname(that.getFirstname());
		setLastname(that.getLastname());
		setBirthdate(that.getBirthdate());
		setSalary(that.getSalary());
	}

	/**
	 * Returns a textual representation of a bean.
	 *
	 */
	public String toString() {

		StringBuilder buffer = new StringBuilder();

		buffer.append("employeeId=[").append(employeeId).append("] ");
		buffer.append("firstname=[").append(firstname).append("] ");
		buffer.append("lastname=[").append(lastname).append("] ");
		buffer.append("birthdate=[").append(birthdate).append("] ");
		buffer.append("salary=[").append(salary).append("] ");

		return buffer.toString();
	}

	/**
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (int) (prime * result + ((employeeId == null) ? 0 : employeeId.hashCode()));
		return result;
	}

	/**
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Employee))
			return false;
		Employee equalCheck = (Employee) obj;
		if ((employeeId == null && equalCheck.employeeId != null) || (employeeId != null && equalCheck.employeeId == null))
			return false;
		if (employeeId != null && !employeeId.equals(equalCheck.employeeId))
			return false;
		return true;
	}
}
