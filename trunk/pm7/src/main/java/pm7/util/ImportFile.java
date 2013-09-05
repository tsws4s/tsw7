package pm7.util;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ImportFile implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 725156758496089134L;
	
	private String fileName;
	private String originalFilename;
	private String uploadPath;
	private String fileDataType;
	private char separator;

	private String[] headerRow;	
	private List<String[]> importRecords;
	private List<Boolean> recordLoaded;
	
	public ImportFile(String fileDataType, String fileName, String uploadPath) {
		super();
		this.fileDataType = fileDataType;
		this.fileName = fileName;
		this.uploadPath = uploadPath;
		this.separator = ',';
	}

	public char getSeparator() {
		return separator;
	}

	public void setSeparator(char separator) {
		this.separator = separator;
	}
	
	public String getUploadPath() {
		return uploadPath;
	}

	public void setUploadPath(String uploadPath) {
		this.uploadPath = uploadPath;
	}	
	public String getFileDataType() {
		return fileDataType;
	}

	public String getFileName() {
		return fileName;
	}

	public String getOriginalFilename() {
		return originalFilename;
	}
	
	public String[] getHeaderRow() {
		if(headerRow==null){
			headerRow = new String[]{ };
		}
		return headerRow;
	}
	public void setHeaderRow(String[] headerRow) {
		this.headerRow = headerRow;
	}
	
	public List<String[]> getImportRecords() {
		if(importRecords==null){
			importRecords = new ArrayList<String[]>();
		}	
		return importRecords;
	}
	public void setImportRecords(List<String[]> importRecords) {
		this.importRecords = importRecords;
		initializeRecordLoaded();
	}

	public List<Boolean> getRecordLoaded() {
		if(recordLoaded==null){
			recordLoaded = new ArrayList<Boolean>();
		}	
		return recordLoaded;
	}
	public void setRecordLoaded(List<Boolean> recordLoaded) {
		this.recordLoaded = recordLoaded;
	}	

	public void initializeRecordLoaded() {
		this.recordLoaded = new ArrayList<Boolean>();
		int numRecords = getImportRecords().size();
		for(int i=0;i>numRecords;i++){
			this.recordLoaded.add(new Boolean(false));
		}
	}	
}
