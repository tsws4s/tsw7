package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Customer;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllTswaccts", query = "select myTswacct from Tswacct myTswacct"),
	@NamedQuery(name = "findTswacctByActiveYn", query = "select myTswacct from Tswacct myTswacct where myTswacct.activeYn = ?1"),
	@NamedQuery(name = "findTswacctByExpireDate", query = "select myTswacct from Tswacct myTswacct where myTswacct.expireDate = ?1"),
	@NamedQuery(name = "findTswacctByPrimaryKey", query = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = ?1"),
	@NamedQuery(name = "findTswacctBySubscrType", query = "select myTswacct from Tswacct myTswacct where myTswacct.subscrType = ?1"),
	@NamedQuery(name = "findTswacctByTswAcctId", query = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = ?1") })
*/

@Produces("application/json")
@Path("tswacct")
public class TswacctRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Customer getCustomer(@QueryParam("custid") Integer custId) {
		
		String sqlString = "select myCustomer from Customer myCustomer where customerId = "+custId;
		Customer customer = (Customer) executeUniqueResultQuery(sqlString);
		return customer;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Customer> listCustomers() {
		
		ArrayList<Customer> customers = (ArrayList<Customer>) executeResultListQuery("select myCustomer from Customer myCustomer");
		return customers;
	}
}