package tsw.utils;

import java.util.ArrayList;
import java.util.List;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class TestSalesDAO {


/**
* Our dummy datasource. Retrieves a collection of data that is wrapped by a JRBeanCollectionDataSource.
* 
* @return a JRBeanCollectionDataSource collection
*/
public  JRDataSource getDataSource() {
// Create an array list of Sales
List<TestSales> items = new ArrayList<TestSales>();
 
// We'll add three Sales items
// You can populate data from a custom JDBC or DAO layer
// For this demo, we'll create an in-memory list of items
 
// Create first item
TestSales item1 = new TestSales();
item1.setId(1001L);
item1.setName("Pencil");
item1.setDescription("This is used for sketching drawings");
item1.setPrice(10.50);
 
// Create second item
TestSales item2 = new TestSales();
item2.setId(1002L);
item2.setName("Pen");
item2.setDescription("This is used for signing autographs");
item2.setPrice(15.00);
 
// Create third item
TestSales item3 = new TestSales();
item3.setId(1003L);
item3.setName("Bag");
item3.setDescription("This is used for storing other items");
item3.setPrice(50.00);
 
// Add to list
items.add(item1);
items.add(item2);
items.add(item3);
 
// Wrap the collection in a JRBeanCollectionDataSource
// This is one of the collections that Jasper understands
JRDataSource ds = new JRBeanCollectionDataSource(items);
 
// Return the wrapped collection
return ds;
}
}
