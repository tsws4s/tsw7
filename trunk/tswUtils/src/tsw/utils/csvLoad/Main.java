package tsw.utils.csvLoad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Tim
 * 
 * To clean-up balance-lines:  DELETE FROM tsws4s_7.qbTxn WHERE Name='BALANCE-LINE';
 * 
 * qbTxnId,Account,SubAcct1,SubAcct2,SubAcct3,Type,Date,Num,Name,Memo,Split,Debit,Credit,Balance
 * ,Eagle Valley Bank - Checking,,,,,,,,,,,,"1,574.20"
 * ,,,,,Deposit,01/01/2011,,,Deposit,Coaching,10.00,,"1,584.20"
 * ,,,,,Deposit,01/03/2011,,,Deposit,Undeposited Funds,"2,138.50",,"3,722.70"
 * ,,,,,Check,01/04/2011,eft,Authorize.net,,Bank Service Charges,,30.77,"3,691.93"
 * 
 * ,The Pond,,,,,,,,,,,,"1,097,468.60"
 * ,,Equipment,,,,,,,,,,,"477,673.38"
 * ,,,Cost,,,,,,,,,,"477,673.38"
 * ,,,Total Cost,,,,,,,,,,"477,673.38"
 * ,,,Equipment - Other,,,,,,,,,,0.00
 * ,,,Total Equipment - Other,,,,,,,,,,0.00
 * ,,Total Equipment,,,,,,,,,,,"477,673.38"
 * ,,Furniture,,,,,,,,,,,0.00
 * 
 * ,,,Total Furniture - Other,,,,,,,,,,0.00
 * ,,Total Furniture,,,,,,,,,,,0.00
 * ,,Leasehold Improvements,,,,,,,,,,,"619,795.22"
 * ,,,Cost,,,,,,,,,,"619,795.22"
 * ,,,,Construction Buildout,,,,,,,,,0.00
 * 
 */
public class Main {

	private static String JDBC_CONNECTION_URL = "jdbc:mysql://tsws4s.com/tsws4s_7";
	private static String JDBC_CONNECTION_USER = "tsws4s_testUser";
	private static String JDBC_CONNECTION_PWD = "Ind1a123";

	public static void main(String[] args) {
		try {

			// CSVLoader loader = new CSVLoader(getCon());
			CSVLoaderQB1 loader = new CSVLoaderQB1(getCon());
			loader.loadCSV("C:\\data\\merGL.csv", "qbTxn", false);
			System.out.println("*Finished*");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static Connection getCon() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(JDBC_CONNECTION_URL, JDBC_CONNECTION_USER, JDBC_CONNECTION_PWD);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
	}
}
