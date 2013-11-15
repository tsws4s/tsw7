package wsdm.domain;

public class Customer {

	private Integer custid;
	private String firstname;
	private String lastname;
	private String dob;
	private String sex;
	private Integer active;

	public Customer(Integer custid, String firstname, String lastname, String dob, String sex) {
		
		super();
		setCustid(custid);
		setFirstname(firstname);
		setLastname(lastname);
		setDob(dob);
		setSex(sex);
		setActive(new Integer(1));
	}
	
	public Integer getCustid() {
		return custid;
	}

	public void setCustid(Integer custid) {
		this.custid = custid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	

}
