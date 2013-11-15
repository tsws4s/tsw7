package tsw.utils;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import au.com.bytecode.opencsv.CSVWriter;

public class TestCSV {

	private static String JDBC_CONNECTION_URL = "jdbc:mysql://tsws4s.com/tsws4s_4";
			private static String USERNAME = "tsws4s_testUser";
			private static String PWD = "Ind1a123";
			
	public static void main(String[] args) {

		CSVtoSQL();
		
		// sqlTableToCSV();
		
	}

	private static Connection getCon() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL, USERNAME, PWD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
	
	public static void CSVtoSQL(){
		try {
			CSVLoader loader = new CSVLoader(getCon());
			//loader.loadCSV("C:\\4devPC\\employee.csv", "Employee", true);
			loader.loadCSV("C:\\4devPC\\cutomerNew.csv", "Customer", false);
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public static void sqlTableToCSV(){
		boolean includeHeaders = true;
		String csv = "C:\\4devPC\\cutomer.csv";
		String sql = "select * from Customer;";
		
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(csv));
			ResultSet myResultSet = getCon().createStatement()
					.executeQuery(sql);
			writer.writeAll(myResultSet, includeHeaders);
			writer.close();
		} catch (Exception e) {
			// DO: handle exception
		}
		
	}
	
/*	
	public void readSample(){
		String csvFilename = "C:\\sample.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		// CSVReader reader = new CSVReader(new FileReader(file), ';')
		String[] row = null;
		while((row = csvReader.readNext()) != null) {
		    System.out.println(row[0]
		              + " # " + row[1]
		              + " #  " + row[2]);
		}
		//...
		csvReader.close();		
	}

	public void writeSample(){
	String csv = "C:\\output.csv";
	CSVWriter writer = new CSVWriter(new FileWriter(csv));
	 
	String [] country = "India#China#United States".split("#");
	 
	writer.writeNext(country);
	 
	writer.close();
	}
	
	public void mappingSample(){
		ColumnPositionMappingStrategy strat = new ColumnPositionMappingStrategy();
		strat.setType(Country.class);
		String[] columns = new String[] {"countryName", "capital"}; // the fields to bind do in your JavaBean
		strat.setColumnMapping(columns);
		 
		CsvToBean csv = new CsvToBean();
		 
		String csvFilename = "C:\\sample.csv";
		CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
		 
		List list = csv.parse(strat, csvReader);
		for (Object object : list) {
		    Country country = (Country) object;
		    System.out.println(country.getCapital());
		}
	}
	

*/
	
}