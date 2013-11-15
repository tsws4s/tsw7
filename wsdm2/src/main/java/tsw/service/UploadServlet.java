package tsw.service;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import tsw.domain.ImportFile;


/**
 * A Java servlet that handles file upload from client.
 * @author www.codejava.net
 */
public class UploadServlet extends HttpServlet {
	
//	static SessionConfigCache sessionCache = new SessionConfigCache();
	
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIRECTORY = "UploadDir";
	private static final int THRESHOLD_SIZE 	= 1024 * 1024 * 3; 	// 3MB
	private static final int MAX_FILE_SIZE 		= 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE 	= 1024 * 1024 * 50; // 50MB

	
	/**
	 * handles file upload via HTTP POST method
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// checks if the request actually contains upload file
		if (!ServletFileUpload.isMultipartContent(request)) {
			PrintWriter writer = response.getWriter();
			writer.println("Request does not contain upload data");
			writer.flush();
			return;
		}
		
		// configures upload settings
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(THRESHOLD_SIZE);
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setFileSizeMax(MAX_FILE_SIZE);
		upload.setSizeMax(MAX_REQUEST_SIZE);

		// not sure why form element not sent in request??
		//String dataType = request.getParameter("dataType");
		String dataType = "Game";
		
		// not sure why form element not sent in request??
		//Integer tswacctId = Integer.parseInt(request.getParameter("tswacctId"));
		Integer tswacctId = 103;
		
		// constructs the directory path to store upload file
		String uploadPath = getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY+File.separator+dataType;
		String theFileName = "filename";

		// creates the directory if it does not exist
		File uploadDir = new File(uploadPath);
		if (!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			// parses the request's content to extract file data
			@SuppressWarnings("rawtypes")
			List formItems = upload.parseRequest(request);
			@SuppressWarnings("rawtypes")
			Iterator iter = formItems.iterator();
			
			// iterates over form's fields
			while (iter.hasNext()) {
				FileItem item = (FileItem) iter.next();
				// processes only fields that are not form fields
				if (!item.isFormField()) {
					String fileName = tswacctId + "_" + new File(item.getName()).getName();
					String filePath = uploadPath + File.separator + fileName;
					theFileName = fileName;
					File storeFile = new File(filePath);				
					// saves the file on disk
					item.write(storeFile);
				}
			}
			request.setAttribute("message", "Upload has been done successfully!");
		} catch (Exception ex) {
			request.setAttribute("message", "There was an error: " + ex.getMessage());
		}
		if(theFileName!=null){
			
		}
		ImportFile importFile = new ImportFile(dataType, theFileName, uploadPath);
		request.setAttribute("importFile",importFile);

		getServletContext().getRequestDispatcher("/uploadResult").forward(request, response);

	}
}
