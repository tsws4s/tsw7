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
	@NamedQuery(name = "findAllResources", query = "select myResource from Resource myResource"),
	@NamedQuery(name = "findResourceByActiveYn", query = "select myResource from Resource myResource where myResource.activeYn = ?1"),
	@NamedQuery(name = "findResourceByCity", query = "select myResource from Resource myResource where myResource.city = ?1"),
	@NamedQuery(name = "findResourceByPrimaryKey", query = "select myResource from Resource myResource where myResource.resourceId = ?1"),
	@NamedQuery(name = "findResourceByResourceId", query = "select myResource from Resource myResource where myResource.resourceId = ?1"),
	@NamedQuery(name = "findResourceByResourceName", query = "select myResource from Resource myResource where myResource.resourceName = ?1"),
	@NamedQuery(name = "findResourceByResourceType", query = "select myResource from Resource myResource where myResource.resourceType = ?1"),
	@NamedQuery(name = "findResourceByState", query = "select myResource from Resource myResource where myResource.state = ?1"),
	@NamedQuery(name = "findResourceByZipcode", query = "select myResource from Resource myResource where myResource.zipcode = ?1") })
*/
@Produces("application/json")
@Path("resource")
public class ResourceRest extends AbstractRest {
	
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