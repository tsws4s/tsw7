package tsw.utils;

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
	 
//	import java.util.Properties;
//	import org.apache.log4j.Logger;
//	import org.apache.log4j.PropertyConfigurator;
	 
import net.sf.jasperreports.engine.JRExporterParameter;
	import net.sf.jasperreports.engine.JasperCompileManager;
	import net.sf.jasperreports.engine.JasperExportManager;
	import net.sf.jasperreports.engine.JasperFillManager;
	import net.sf.jasperreports.engine.JasperPrint;
	
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
	 
	/**
	 * The Class Test.
	 */
	public class JasperRptTest {
	 
	    /** The Constant LOG. */
	  //  private static final Logger LOG = Logger.getLogger(JasperRptTest.class);
	     
	    /** The Constant BUFFER. */
	    final static int BUFFER = 10240;
	     
	    /** The connection. */
	    static Connection connection = null;
	    
		private static String JDBC_CONNECTION_URL = "jdbc:mysql://tsws4s.com/tsws4s_4";
		private static String USERNAME = "tsws4s_testUser";
		private static String PWD = "Ind1a123";
		
		private static String SUB_DIR = "C://4devPC/test/";
		
	    /**
	     * Connect database.
	     */
	    static void ConnectDatabase() {
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
	 
	    /**
	     * File zip.
	     */
	    static void fileZip() {
	         
	        BufferedInputStream origin = null;
	        try
	        {
	            FileOutputStream dest = new FileOutputStream(SUB_DIR+"Leaf_Gray_Table_Based.zip");
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
	      
	    /**
	     * The main method.
	     *
	     * @param args the arguments
	     */
	    public static void main(String[] args) {
	        JasperReport jasperReport;
	        JasperPrint jasperPrint;
	         
	        // long start = System.currentTimeMillis();
	         
	        try {
	        	/*
	            // Log log4j configuration
	            final Properties log4jProperties = new Properties();
	            log4jProperties.load(new FileInputStream(SUB_DIR+"log4j.properties"));
	            PropertyConfigurator.configure(log4jProperties);
	             
	            LOG.info("Start");
	            LOG.info("--------");
	                         
	            LOG.info("Compile Jasper XML Report");
	            */
	            jasperReport = JasperCompileManager.compileReport(SUB_DIR+"Leaf_Gray_Table_Based.jrxml");
	            /*
	            LOG.info("time : " + (System.currentTimeMillis() - start)+ " ms.");
	             
	            LOG.info("Create Database connection");
	            */
	            ConnectDatabase();
	            /*
	            LOG.info("time : " + (System.currentTimeMillis() - start)+ " ms.");
	             
	            LOG.info("Create parameters");
	            */
	            Map <String, Object> parameters = new HashMap<String, Object>();
	            parameters.put("ReportTitle", "League & Program Report");
	            parameters.put("DataFile", SUB_DIR+"Leaf_Gray_Table_Based.jrxml");
	            parameters.put("IdRange", 10); 
	             
	            // LOG.info("Generated report");
	            
	            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, connection);
	            /*
	            LOG.info("time : " + (System.currentTimeMillis() - start)+ " ms.");
	             
	            LOG.info("Generated PDF");
	             */
	            
	            
	            /**
	             * 1- export to PDF
	             */
	            JasperExportManager.exportReportToPdfFile(jasperPrint, "Leaf_Gray_Table_Based.pdf");
	            /**
	             * 2- export to HTML
	             */
	            JasperExportManager.exportReportToHtmlFile(jasperPrint, "Leaf_Gray_Table_Based.html");

	            /**
	             * 3- export to CSV
	             */
	            JRCsvExporter exporter2 = new JRCsvExporter();
	            exporter2.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	            exporter2.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "Leaf_Gray_Table_Based.csv");
	            exporter2.exportReport();      

	            /**
	             * 4- export to Excel sheet
	             */
	            JRXlsExporter exporter = new JRXlsExporter();
	            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
	            exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, "Leaf_Gray_Table_Based.xls");
	            exporter.exportReport();      

	            
	            /*
	            LOG.info("time : " + (System.currentTimeMillis() - start)+ " ms.");
	             
	            LOG.info("Create Zip File");
	            */
	            fileZip();
	            /*
	            LOG.info("time : " + (System.currentTimeMillis() - start)+ " ms.");
	            */
	             
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        /*
	        LOG.info("--------");
	        LOG.info("Done");
	        */
	    }
	}
