package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Tswacct;
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
	public Tswacct getTswacct(@QueryParam("tswacctid") Integer tswacctId) {
		
		String sqlString = "select myTswacct from Tswacct myTswacct where myTswacct.tswAcctId = "+tswacctId;
		Tswacct tswacct = (Tswacct) executeUniqueResultQuery(sqlString);
		return tswacct;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Tswacct> listTswaccts() {
		
		ArrayList<Tswacct> tswacct = (ArrayList<Tswacct>) executeResultListQuery("select myTswacct from Tswacct myTswacct");
		return tswacct;
	}
}