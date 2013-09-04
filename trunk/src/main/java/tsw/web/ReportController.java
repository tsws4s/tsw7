package tsw.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import tsw.domain.Users;
import tsw.service.CustomerService;
import tsw.service.LevelService;
import tsw.service.MailService;
import tsw.service.PriceService;
import tsw.service.ReportService;
import tsw.service.ResourceService;

@Controller("ReportController")
public class ReportController {

	SessionConfigCache sessionCache = UsersController.getSessionCache();

	int defaultMaxRows = UsersController.getDefaultMaxRows();

	// future - change to Spring bean, vs. static
	//@Autowired
	// private ReportService reportService;
	
	@Autowired
	private PriceService priceService;
	@Autowired
	private LevelService levelService;
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	ReportService reportService;
	
	@Autowired
	MailService mailService;
	
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
	@RequestMapping("/reportController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;
	}
	
	// TODO: [Tim] (Charts-Hi) Fix charts that broke after resolving javascript loading for DatePicker
	//   See dashboard.jsp and javascript loaded in main.jsp

	
	// TODO: [Tim] (Reports-Hi) Update & Complete Report templates in Jasper, deploy jrmxl in /ReportsDir/
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/generateReport")
	public String generateReport(HttpServletRequest request, @RequestParam String rptName) {
		reportService.runReport(request, rptName);
		Users user = sessionCache.getUser4Session(request);
		Integer tswAcct = user.getTswacct().getTswAcctId();
		return "redirect:/ReportsDir/"+rptName+"/"+tswAcct+"_"+rptName+".pdf";
	}

	@RequestMapping("/viewReport")
	public String viewReport(HttpServletRequest request, @RequestParam String rptName) {
		Users user = sessionCache.getUser4Session(request);
		Integer tswAcct = user.getTswacct().getTswAcctId();
		return "redirect:/ReportsDir/"+rptName+"/"+tswAcct+"_"+rptName+".pdf";
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/downloadReport")
	public ModelAndView downloadReport(HttpServletRequest request, @RequestParam String rptName) {
		ModelAndView mav = new ModelAndView();
		Users user = sessionCache.getUser4Session(request);
		Integer tswAcct = user.getTswacct().getTswAcctId();
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.addObject("reportLink","/ReportsDir/"+rptName+"/"+tswAcct+"_"+rptName);
		mav.setViewName("report/downloadReport.jsp");
		return mav;
	}	

	
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/emailReport")
	public ModelAndView emailReport(HttpServletRequest request, @RequestParam String rptName, @RequestParam String emailTo, @RequestParam String pdfXls) {

		ModelAndView mav = new ModelAndView();
		Users user = sessionCache.getUser4Session(request);
		Integer tswAcct = user.getTswacct().getTswAcctId();
		String reportAttachment = "ReportsDir/"+rptName+"/"+tswAcct+"_"+rptName+"."+pdfXls;	
		String body = "See attached Report./n/n/n or click here to download:  http://"+request.getServletPath()+"/"+reportAttachment;

		mailService.sendMail("service@simplyt3s.com", null, emailTo, null, "Report - "+tswAcct+"_"+rptName+"."+pdfXls, body, reportAttachment);
		
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.addObject("emailTo",emailTo);
		mav.addObject("reportName",tswAcct+"_"+rptName+"."+pdfXls);
		mav.setViewName("report/emailedReport.jsp");
		return mav;

	}
	
	
	/**
	 * Print Reports
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/printReport")
	public ModelAndView printReport(HttpServletRequest request, @RequestParam String rpt) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/"+rpt);
		mav.addObject("reportFlag", true);
		Users sessUser = sessionCache.getUser4Session(request);
		mav.addObject("user",sessUser);
		
		if(rpt.startsWith("printAccount")){
			mav.addObject("tswacct",sessUser.getTswacct());					
			mav.addObject("levels",levelService.findAllLevels4tsw(sessUser.getTswacct(), -1, defaultMaxRows));					
			mav.addObject("resources",resourceService.findAllResources4tsw(sessUser.getTswacct(), -1, defaultMaxRows));					
			mav.addObject("prices",priceService.findAllPrices4tsw(sessUser.getTswacct(), -1, defaultMaxRows));					
		}
		if(rpt.startsWith("printLevels")){
			mav.addObject("levels",levelService.findAllLevels4tsw(sessUser.getTswacct(), -1, defaultMaxRows));					
		}
		if(rpt.startsWith("printResources")){
			mav.addObject("resources",resourceService.findAllResources4tsw(sessUser.getTswacct(), -1, defaultMaxRows));					
		}
		if(rpt.startsWith("printPrices")){
			mav.addObject("prices",priceService.findAllPrices4tsw(sessUser.getTswacct(), -1, defaultMaxRows));					
		}
		if(rpt.startsWith("printCustomers")){
			mav.addObject("customers",customerService.findAllCustomers4tsw(sessUser.getTswacct(), -1, defaultMaxRows));					
		}
		
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/accountReport")
	public ModelAndView accountReport(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/accountReport.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}		
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/leagueReport")
	public ModelAndView leagueReport(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/leagueReport.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/programReport")
	public ModelAndView programReport(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/programReport.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/schedulingReport")
	public ModelAndView schedulingReport(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/schedulingReport.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/customerReport")
	public ModelAndView customerReport(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("report/customerReport.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
}
