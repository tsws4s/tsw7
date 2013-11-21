package wsdm.rest;

import java.util.ArrayList;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import wsdm.domain.Price;
/*
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
@NamedQueries({
	@NamedQuery(name = "findAllPrices", query = "select myPrice from Price myPrice"),
	@NamedQuery(name = "findPriceByPrimaryKey", query = "select myPrice from Price myPrice where myPrice.priceId = ?1") })
*/
@Produces("application/json")
@Path("price")
public class PriceRest extends AbstractRest {
	
	@GET
	@Produces("application/json")
	public Price getPrice(@QueryParam("priceid") Integer priceId) {
		
		String sqlString = "select myPrice from Price myPrice where myPrice.priceId = "+priceId;
		Price price = (Price) executeUniqueResultQuery(sqlString);
		return price;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Price> listPrices() {
		
		ArrayList<Price> price = (ArrayList<Price>) executeResultListQuery("select myPrice from Price myPrice");
		return price;
	}
}