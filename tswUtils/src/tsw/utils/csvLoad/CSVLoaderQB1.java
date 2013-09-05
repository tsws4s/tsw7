package tsw.utils.csvLoad;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;

import au.com.bytecode.opencsv.CSVReader;

/**
 *
 * @author viralpatel.net
 *
 */
public class CSVLoaderQB1 {

	private static final String SQL_INSERT = "INSERT INTO ${table}(${keys}) VALUES(${values})";
	private static final String TABLE_REGEX = "\\$\\{table\\}";
	private static final String KEYS_REGEX = "\\$\\{keys\\}";
	private static final String VALUES_REGEX = "\\$\\{values\\}";

	private Connection connection;
	private char seprator;

	/**
	 * Public constructor to build CSVLoader object with
	 * Connection details. The connection is closed on success
	 * or failure.
	 * @param connection
	 */
	public CSVLoaderQB1(Connection connection) {
		this.connection = connection;
		//Set default separator
		this.seprator = ',';
	}

	/**
	 * Parse CSV file using OpenCSV library and load in
	 * given database table.
	 * @param csvFile Input CSV file
	 * @param tableName Database table name to import data
	 * @param truncateBeforeLoad Truncate the table before inserting
	 * 			new records.
	 * @throws Exception
	 */
	public void loadCSV(String csvFile, String tableName,
			boolean truncateBeforeLoad) throws Exception {

		CSVReader csvReader = null;
		if(null == this.connection) {
			throw new Exception("Not a valid connection.");
		}
		try {

			csvReader = new CSVReader(new FileReader(csvFile), this.seprator);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Error occured while executing file. "+ e.getMessage());
		}

		String[] headerRow = csvReader.readNext();

		if (null == headerRow) {
			throw new FileNotFoundException(
					"No columns defined in given CSV file."+"Please check the CSV file format.");
		}

		String questionmarks = StringUtils.repeat("?,", headerRow.length);
		questionmarks = (String) questionmarks.subSequence(0, questionmarks.length() - 1);

		String query = SQL_INSERT.replaceFirst(TABLE_REGEX, tableName);
		query = query.replaceFirst(KEYS_REGEX, StringUtils.join(headerRow, ","));
		query = query.replaceFirst(VALUES_REGEX, questionmarks);

		System.out.println("Query: " + query);

		String[] nextLine;
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = this.connection;
			con.setAutoCommit(false);
			ps = con.prepareStatement(query);

			if(truncateBeforeLoad) {
				//delete data from table before loading csv
				con.createStatement().execute("DELETE FROM " + tableName);
			}
			DecimalFormat format = (DecimalFormat) NumberFormat.getInstance(Locale.US);
			format.setParseBigDecimal(true);
			String Account = "";
			String SubAcct1 = "";
			String SubAcct2 = "";
			String SubAcct3 = "";
			boolean noDate = false;
			final int batchSize = 200;
			int count = 0;			
			try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery("select max("+tableName+"Id) from "+tableName+";");
				rs.first();
				count=(int)rs.getLong(1);
			}catch(Exception e){
				//
			}

			Date date = null;
			while ((nextLine = csvReader.readNext()) != null) {

				if (null != nextLine) {
					int index = 1;
					for (String string : nextLine) {
						if(index==1){
							string=String.valueOf(count+1);
							noDate = false;
						}
						if(index==2){
							if(!string.isEmpty()){
								Account=string;
								SubAcct1 = "";
								SubAcct2 = "";
								SubAcct3 = "";
							} else {
								string=Account;
							}
						}
						if(index==3){
							if(!string.isEmpty()){
								SubAcct1 = string;
								SubAcct2 = "";
								SubAcct3 = "";
							} else {
								string=SubAcct1;
							}
						}
						if(index==4){
							if(!string.isEmpty()){
								SubAcct2 = string;
								SubAcct3 = "";
							} else {
								string=SubAcct2;
							}
						}
						if(index==5){
							if(!string.isEmpty()){
								SubAcct3 = string;
							} else {
								string=SubAcct3;
							}
						}
						if(index==7 && string.isEmpty()){
							System.out.println("NO-DATE - BALANCE-LINE");
							string = "1/1/2000";
							noDate = true;
						}
						if(index==9 && noDate){
							string="BALANCE-LINE";
						}
						if((index==12 || index==13 || index==14)){
							if(string.isEmpty()){
								string="0.00";								
							}
						}						
									
						date = DateUtil.convertToDate(string);
						if (null != date) {
							ps.setDate(index++, new java.sql.Date(date.getTime()));
						} else {
							if((index==12 || index==13 || index==14)){
								BigDecimal number = (BigDecimal) format.parse(string);
								ps.setBigDecimal(index++, number);
							} else {
								ps.setString(index++, string);
							}	
						}
						if (count % 100 == 0) {
							System.out.print(string+",");
						}
					}
					ps.addBatch();
					if (count % 100 == 0) {
						System.out.println("**");
					}					
				}
				if (++count % batchSize == 0) {
					ps.executeBatch();
					System.out.println("Inserted Batch: "+batchSize);
				}
			}
			ps.executeBatch(); // insert remaining records
			con.commit();
			System.out.println("Final Insert");
		} catch (Exception e) {
			con.rollback();
			e.printStackTrace();
			throw new Exception(
					"Error occured while loading data from file to database."
							+ e.getMessage());
		} finally {
			if (null != ps)
				ps.close();
			if (null != con)
				con.close();

			csvReader.close();
		}
	}

	public char getSeprator() {
		return seprator;
	}

	public void setSeprator(char seprator) {
		this.seprator = seprator;
	}

}
