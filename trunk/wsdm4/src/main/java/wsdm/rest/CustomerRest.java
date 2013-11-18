package wsdm.rest;

import java.util.ArrayList;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import wsdm.dao.HibernateSessionFactory;
import wsdm.domain.Customer;

/**   mappedBy reference an unknown target entity property: wsdm.domain.Customer.tswacct in wsdm.domain.Tswacct.customers
 * org.hibernate.TypeMismatchException: Provided id of the wrong type for class wsdm.domain.Customer. Expected: class java.lang.Integer, got class java.lang.String
disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS

org.codehaus.jackson.map.JsonMappingException: No serializer found for class org.hibernate.proxy.pojo.javassist.JavassistLazyInitializer and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS) ) (through reference chain: wsdm.domain.Customer_$$_javassist_6["handler"])
	org.codehaus.jackson.map.ser.StdSerializerProvider$1.serialize(StdSerializerProvider.java:62)

 */

@Produces("application/json")
@Path("customer")
public class CustomerRest {
	
	@GET
	@Produces("application/json")
	public Customer getCustomer(@QueryParam("custid") Integer custId) {
		Customer customer = null;
		Session session = HibernateSessionFactory.getSessionFactory().openSession();  
		Transaction tx = null;
		try {  
		    tx = session.beginTransaction();  
		    Query query = session.createQuery("select myCustomer from Customer myCustomer where customerId = "+custId); 
		    customer= (Customer) query.uniqueResult();
		    //customer = (Customer) session.load(Customer.class, custId); 
		    //session.persist(...);  		  
		    tx.commit(); // Flush happens automatically  
		}  
		catch (RuntimeException e) {  
		    tx.rollback();  
		    throw e; // or display error message  
		}  
		finally {  
		    session.close();  
		}
		
		return customer;
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("list")
	@Produces("application/json")
	public ArrayList<Customer> listCustomers() {
		
		ArrayList<Customer> customers = new ArrayList<Customer>();
		Session session = HibernateSessionFactory.getSessionFactory().openSession();  
		Transaction tx = null;
		try {  
		    tx = session.beginTransaction();   
		    Query query = session.createQuery("select myCustomer from Customer myCustomer"); 
		    customers = (ArrayList<Customer>) query.list();
		    //session.persist(...);  
		    tx.commit(); // Flush happens automatically  
		}   
		catch (RuntimeException e) {  
		    tx.rollback();  
		    throw e; // or display error message  
		}  
		finally {  
		    session.close();  
		}
		
		return customers;
	}
}