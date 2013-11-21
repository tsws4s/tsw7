package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Users;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllUserss", query = "select myUsers from Users myUsers"),
	@NamedQuery(name = "findUsersByActiveYn", query = "select myUsers from Users myUsers where myUsers.activeYn = ?1"),
	@NamedQuery(name = "findUsersByAdminYn", query = "select myUsers from Users myUsers where myUsers.adminYn = ?1"),
	@NamedQuery(name = "findUsersByCustomerFk", query = "select myUsers from Users myUsers where myUsers.customerFk = ?1"),
	@NamedQuery(name = "findUsersByPrimaryKey", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
	@NamedQuery(name = "findUsersByTswAcctFk", query = "select myUsers from Users myUsers where myUsers.tswAcctFk = ?1"),
	@NamedQuery(name = "findUsersByUserId", query = "select myUsers from Users myUsers where myUsers.userId = ?1"),
	@NamedQuery(name = "findUsersByUsername", query = "select myUsers from Users myUsers where myUsers.username = ?1") })

*/
@Produces("application/json")
@Path("users")
public class UsersRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Users getUser(@QueryParam("userid") Integer userId) {
		
		String sqlString = "select myUsers from Users myUsers where myUsers.userId = "+userId;
		Users user = (Users) executeUniqueResultQuery(sqlString);
		return user;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Users> listUsers() {
		
		ArrayList<Users> user = (ArrayList<Users>) executeResultListQuery("select myUsers from Users myUsers");
		return user;
	}
}