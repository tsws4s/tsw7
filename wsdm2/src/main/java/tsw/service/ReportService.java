package tsw.service;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

/*import tsw.domain.Users;
import tsw.web.SessionConfigCache;
import tsw.web.UsersController;*/

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;

@Service("ReportService")
public class ReportService {

//	private static SessionConfigCache sessionCache = UsersController.getSessionCache();

	/** The Constant BUFFER. */
    final static int BUFFER = 10240;
     
    /** The connection. */
    static Connection connection = null;
    
	private static String JDBC_CONNECTION_URL = "jdbc:mysql://tsws4s.com/tsws4s_4";
	private static String USERNAME = "tsws4s_testUser";
	private static String PWD = "Ind1a123";
	
	private static String SUB_DIR = null;
	
	    /**
	     * Connect database.
	     */
	    void ConnectDatabase() {
	    	if(connection == null){
		        try {          
		            // Load the JDBC driver
					Class.forName("com.mysql.jdbc.Driver");;
					connection = DriverManager.getConnection(JDBC_CONNECTION_URL, USERNAME, PWD);	
		        } catch (ClassNotFoundException e) {
		            System.err.println("Could not find the database driver");
		        } catch (Exception e) {
		            System.err.println("Could not connect to the database");
		        }
	    	}
	    }
	    
		public void runReport(HttpServletRequest request, String jrmxlFilename){		
			runReport(request, jrmxlFilename, null);
		}
		
		public void runReport(HttpServletRequest request, String jrmxlFilename, Map <String, Object> parameters){

		JasperReport jasperReport = null;
        JasperPrint jasperPrint = null;
		ServletContext srvltCntxt = request.getSession().getServletContext();
        SUB_DIR = srvltCntxt.getRealPath("/ReportsDir/"+ jrmxlFilename);
/*		Users user = sessionCache.getUser4Session(request);
		Integer tswAcct = user.getTswacct().getTswAcctId();
*/
        Integer tswAcct=null;
        if(parameters==null){
        	parameters = new HashMap<String, Object>();
        }
        parameters.put("ReportTitle", "Team Sportsware Report");
        parameters.put("DataFile", SUB_DIR+"/"+jrmxlFilename+".jrxml");	
        parameters.put("tswAcctId", tswAcct);		

        try {
            ConnectDatabase();

            jasperReport = JasperCompileManager.compileReport(SUB_DIR+"/"+jrmxlFilename+".jrxml");
 
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
          
            /**
             * 1- export to PDF
             */
            JasperExportManager.exportReportToPdfFile(jasperPrint, SUB_DIR+"/"+tswAcct+"_"+jrmxlFilename+".pdf");
            /**
             * 2- export to HTML
             */
            JasperExportManager.exportReportToHtmlFile(jasperPrint, SUB_DIR+"/"+tswAcct+"_"+jrmxlFilename+".html"); 
            /**
             * 3- export to CSV
             */
            JRCsvExporter exporter2 = new JRCsvExporter();
            exporter2.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter2.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, SUB_DIR+"/"+tswAcct+"_"+jrmxlFilename+".csv");
            exporter2.exportReport();      
            /**
             * 4- export to Excel sheet
             */
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, SUB_DIR+"/"+tswAcct+"_"+jrmxlFilename+".xls");
            exporter.exportReport();	
 
            // fileZip();          
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
    /**
     * File zip.
     */
    void fileZip() {
         
        BufferedInputStream origin = null;
        try
        {
            FileOutputStream dest = new FileOutputStream(SUB_DIR+"Simple_Blue1.zip");
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(dest));
            byte data[] = new byte[BUFFER];
             
            // get a list of files from current directory
            File f = new File(SUB_DIR);
            String files[] = f.list();
 
            for (int i=0; i<files.length; i++) {
             
                System.out.println("Adding: "+files[i]);
                FileInputStream fi = new FileInputStream(SUB_DIR+files[i]);
                origin = new BufferedInputStream(fi, BUFFER);
                ZipEntry entry = new ZipEntry(files[i]);
                out.putNextEntry(entry);
                int count;
                while((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
