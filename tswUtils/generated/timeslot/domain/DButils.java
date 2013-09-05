package timeslot.domain;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DButils {
	
	String url="jdbc:mysql://mysql906.ixwebhosting.com/";
	String dbName="C324877_t3sportsTST";
//	String dbName="C324877_t3sports";
	String tbl="timeslotsTST";
//	String tbl="timeslots_wr";
//	String tbl="timeslots";
	String userName="C324877_imsuser";
	String password="imsaDm1n";
	String driver = "com.mysql.jdbc.Driver";
    Connection conn = null;
    Statement stmt = null;
    
public DButils() {

	}

public DButils(String db_server, String db_name, String db_un, String db_pw, String tbl) {
	this.url = db_server;
	this.dbName = db_name;
	this.userName = db_un;
	this.password = db_pw;
	this.tbl = tbl;
}

public Connection getConnection() {
	if(conn==null){
		try {
			Class.forName(driver).newInstance();
			conn = DriverManager.getConnection(url + dbName, userName, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
return conn;
}
public Statement getStatement(){
	if(stmt==null){
		try {
			stmt = getConnection().createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	return stmt;
}
public int getNextId(){
	int nextId = 0;
	try {		
		String sql = "select max(timeslot_id) from "+dbName+"."+tbl+";";
		ResultSet rs = getStatement().executeQuery(sql);
		rs.next();
		nextId = rs.getInt("max(timeslot_id)");
		// System.out.println("-rs.getInt(max(timeslot_id))-("+nextId+") ");
	} catch (Exception e) {
		e.printStackTrace();
	}
	return nextId;
}

public void close() {	
	if(conn!=null){
		try {				
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

	public String getDb_name() {
		return dbName;
	}
	public void setDb_name(String db_name) {
		this.dbName = db_name;
	}
	public String getTbl() {
		return tbl;
	}
	public void setTbl(String tbl) {
		this.tbl = tbl;
	}
	
	
}
