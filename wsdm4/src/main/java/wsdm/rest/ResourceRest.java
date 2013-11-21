package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Resource;
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
	public Resource getResource(@QueryParam("resourceid") Integer resourceId) {
		
		String sqlString = "select myResource from Resource myResource where myResource.resourceId = "+resourceId;
		Resource resource = (Resource) executeUniqueResultQuery(sqlString);
		return resource;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Resource> listResources() {
		
		ArrayList<Resource> resource = (ArrayList<Resource>) executeResultListQuery("select myResource from Resource myResource");
		return resource;
	}
}