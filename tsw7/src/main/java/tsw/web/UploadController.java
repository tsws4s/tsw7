package tsw.web;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import tsw.domain.ImportFile;
import tsw.domain.UploadItem;
import tsw.service.CSVFileService;

@Controller("UploadController")
public class UploadController
{
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();
	
	@Autowired
	CSVFileService csvFileService;
	
	// Init
	/**  ***************************************  Init  *******************************************************
	 * Register custom, context-specific property editors
	 * 
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder, HttpServletRequest request) { // Register static property editors.
		binder.registerCustomEditor(java.util.Calendar.class, new org.skyway.spring.util.databinding.CustomCalendarEditor());
		binder.registerCustomEditor(byte[].class, new org.springframework.web.multipart.support.ByteArrayMultipartFileEditor());
		binder.registerCustomEditor(boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(false));
		binder.registerCustomEditor(Boolean.class, new org.skyway.spring.util.databinding.EnhancedBooleanEditor(true));
		binder.registerCustomEditor(java.math.BigDecimal.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(java.math.BigDecimal.class, true));
		binder.registerCustomEditor(Integer.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Integer.class, true));
		binder.registerCustomEditor(java.util.Date.class, new org.skyway.spring.util.databinding.CustomDateEditor());
		binder.registerCustomEditor(String.class, new org.skyway.spring.util.databinding.StringEditor());
		binder.registerCustomEditor(Long.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Long.class, true));
		binder.registerCustomEditor(Double.class, new org.skyway.spring.util.databinding.NaNHandlingNumberEditor(Double.class, true));
	}

	/**
	 */
	@RequestMapping("/uploadController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
	
  @Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/importExport")
	public ModelAndView importExport(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("tswacct",sessionCache.getUser4Session(request).getTswacct());
		mav.addObject("uploadItem", new UploadItem());
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("csvfile/importExport.jsp");
		return mav;
	}

  
	//TODO: [assignedTo] (ImportExport-Med) Implement ImportExport files
	//  Import:  Customers, Teams & Players, Participants, Events & Games
 
  @RequestMapping(value = "/saveImportFile")
  public ModelAndView saveImportFile(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		ImportFile importFile = sessionCache.getImportFile4Session(request);
		if(importFile!=null){
			try {
				importFile = csvFileService.createAndSaveObjects(request, importFile);
			} catch (Exception e) {
				e.printStackTrace();
				request.setAttribute("message", "There was an error: " + e.getMessage());
			}
		} else {
			importFile = new ImportFile("unknown", "unknown", "unknown");
			request.setAttribute("message", "There was an error:  No ImportFile was found");
		}
		mav.addObject("importFile",importFile);	
		mav.addObject("saveResults",true);		
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("csvfile/loadResult.jsp");
		return mav;
  }

  @RequestMapping(value = "/uploadResult")
  public ModelAndView uploadResult(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mav = new ModelAndView(); 
		
		ImportFile importFile = (ImportFile)request.getAttribute("importFile");
		sessionCache.setImportFile4Session(request, importFile);
		
		if(importFile!=null){
			try {
				// Do we need to pass request?
				importFile = CSVFileService.loadRecords(request, importFile);
			} catch (IOException e) {
				e.printStackTrace();
				request.setAttribute("message", "There was an error: " + e.getMessage());
			} 
		} else {
			importFile = new ImportFile("unknown", "unknown", "unknown");
			request.setAttribute("message", "There was an error:  No ImportFile was found");
		}
		mav.addObject("importFile",importFile);
		mav.addObject("saveResults",false);		
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("csvfile/uploadResult.jsp");
		return mav;
  }
}
