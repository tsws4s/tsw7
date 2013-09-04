package tsw.web;

import java.util.Set;

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

import tsw.domain.Authorities;
import tsw.domain.Customer;
import tsw.domain.Tswacct;
import tsw.domain.Users;

import tsw.service.AuthoritiesService;
import tsw.service.CustomerService;
import tsw.service.MailService;
import tsw.service.ProgramService;
import tsw.service.TaskScheduling;
import tsw.service.TswacctService;
import tsw.service.UsersService;

/**
 * Spring MVC controller that handles CRUD requests for Customer entities
 * 
 */

	// TODO: [assignedTo] (Customer-Med) Implement the "Family Quick Entry" wizard "SAVE" capability 

	// TODO: [assignedTo] (Customer-Med) Implement the email campaign capability 

@Controller("CustomerController")
public class CustomerController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * Service injected by Spring that provides CRUD operations for Customer entities
	 * 
	 */
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProgramService programService;
	@Autowired
	private TswacctService tswacctService;
	@Autowired
	private AuthoritiesService authoritiesService;
	@Autowired
	private UsersService usersService;
	@Autowired
	private MailService mailService;
	
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
	@RequestMapping("/customerController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	// List Search
	/**  *************************************  List Search  *************************************************
	 * Show all Customer entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexCustomer")
	public ModelAndView listCustomers(HttpServletRequest request) {
		return listCustomersFrom(request, -1);
	}
	
	/**
	 * Entry point to show all Customer entities
	 * 
	 */
	public String indexCustomer(HttpServletRequest request) {
		return "redirect:/indexCustomer";
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexCustomerFrom")
	public ModelAndView listCustomersFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Set<Customer> cust = customerService.loadCustomers4tsw(sessionCache.getTswacct(request), indexFrom,sessionCache.getResultsPerPage(request));
		mav.addObject("customers", cust);
		mav.addObject("indexFrom", indexFrom+0);
		mav.addObject("indexCount", customerService.getCustomerCount4tsw(sessionCache.getTswacct(request)));
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("customer/listCustomers.jsp");
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchCustomers")
	public ModelAndView searchCustomers(HttpServletRequest request) {
		return searchCustomersFrom(request, -1);
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchCustomersFrom")
		public ModelAndView searchCustomersFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		return searchCustomers2From(request, indexFrom, 4);
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchCustomers2")
	public ModelAndView searchCustomers2(HttpServletRequest request, @RequestParam Integer custNum) {
		return searchCustomers2From(request, -1, custNum);
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchCustomers2From")
	public ModelAndView searchCustomers2From(HttpServletRequest request, @RequestParam int indexFrom, @RequestParam Integer custNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customers", customerService.loadCustomers4tsw(sessionCache.getTswacct(request), indexFrom,sessionCache.getResultsPerPage(request)));
		mav.addObject("custNum", custNum);
		mav.addObject("searchFlag", true);
		mav.addObject("indexFrom", indexFrom);
		mav.addObject("indexCount", customerService.getCustomerCount4tsw(sessionCache.getTswacct(request)));
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("customer/searchCustomers.jsp");
		return mav;
	}
	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Customer entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newCustomer")
	public ModelAndView newCustomer(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Customer cust = new Customer();
		mav.addObject("customer", cust);
		mav.addObject("newFlag", true);
		mav.addObject("showFamily",false);
		mav.setViewName("customer/editCustomer.jsp");
		mav.addObject("user", sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Customer entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editCustomer")
	public ModelAndView editCustomer(HttpServletRequest request, @RequestParam Integer customerIdKey) {
		ModelAndView mav = new ModelAndView();
		Customer cust = customerService.findCustomerByPrimaryKey(customerIdKey);
		mav.addObject("customer", cust);
		if(cust.getCustomers().size()>0){
			mav.addObject("showFamily",true);
		}
		mav.setViewName("customer/editCustomer.jsp");
		mav.addObject("user", sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteCustomer")
	public String deleteCustomer(HttpServletRequest request, @RequestParam Integer customerIdKey) {
		Customer customer = customerService.findCustomerByPrimaryKey(customerIdKey);
		customerService.deleteCustomer(customer);
		return "forward:/indexCustomer";
	}
	
	/**
	 * Select the Customer entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteCustomer")
	public ModelAndView confirmDeleteCustomer(HttpServletRequest request, @RequestParam Integer customerIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customer", customerService.findCustomerByPrimaryKey(customerIdKey));
		mav.setViewName("customer/deleteCustomer.jsp");
		mav.addObject("user", sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Save an existing Customer entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveCustomer")
	public String saveCustomer(HttpServletRequest request, @ModelAttribute Customer customer, @RequestParam Integer selected_id4) {
		customerService.saveCustomer(customer, selected_id4, sessionCache.getTswacct(request));
		return "forward:/indexCustomer";
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveChangedPassword")
	public String saveChangedPassword(HttpServletRequest request, @ModelAttribute Customer customer) {
		//
		customerService.saveCustomer(customer, -1, sessionCache.getTswacct(request));
		return "forward:/login";
	}	
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveRegisteredUser")
	public ModelAndView saveRegisteredUser(HttpServletRequest request, @ModelAttribute Customer customer, @RequestParam Integer tswacct_id) {
		Tswacct tswacct = tswacctService.findTswacctByPrimaryKey(tswacct_id);
		customer.setActiveYn(1);
		customer.setAdminYn(0);
		customer.setSelectTheme("Blue");
		Customer cust = customerService.saveCustomer(customer, null, tswacct);
		Authorities authorities = new Authorities();
		authorities.setAuthorityName("IS_AUTHENTICATED_REMEMBERED");
		authorities.setAuthority("IS_AUTHENTICATED_REMEMBERED");
		authorities.setId(cust.getCustomerId().toString());
		authorities.setUsername(cust.getEmail());
		authoritiesService.saveAuthorities(authorities);
		return resetPasswordRequest(request, customer.getEmail());
	}
	// Login and Others
	/**  ************************************** Login and Others *********************************************
	 * 
	 */
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/dashboard")
	public ModelAndView dashboard(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("../sitemesh-common/dashboard.jsp");
		mav.addObject("programs", programService.loadAnyPrograms4tsw(sessionCache.getTswacct(request),-1));
		mav.addObject("user",sessionCache.getUser4Session(request));
		TaskScheduling.start(tswacctService);
		if(!sessionCache.isSessionAuthenitcated(request)){
			mav = login(request);
			mav.addObject("notAuthenticated", true);		
		}
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		// clear session 
		sessionCache.removeSessionConfig(request);
		mav.setViewName("../sitemesh-common/login.jsp");
		mav.addObject("user",null);
		return mav;
	}
	@RequestMapping("/loginError")
	public ModelAndView loginError(HttpServletRequest request, @RequestParam Boolean login_error) {
		ModelAndView mav = new ModelAndView();
		sessionCache.removeSessionConfig(request);
		mav.setViewName("../sitemesh-common/login.jsp?login_error=true");
		mav.addObject("user",null);
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/loginSuccess")
	public ModelAndView loginSuccess(HttpServletRequest request) {
		// setup new session	
		sessionCache.setupSessionConfig(request, this);
		Users loginUser = sessionCache.getUser4Session(request);
		
		boolean notifyLogin = true;
		String emailAddr = "service@simplyt3s.com";
		if(notifyLogin){
			try {
				StringBuffer msg = new StringBuffer();	
				msg.append("<html><head></head><body>");
				msg.append("<p>Team Sportsware - Login</p>");
				msg.append("<p> </p>");
				msg.append("<p>You have requested to be notified upon login of users.</p>");
				msg.append("<p> </p>");
				msg.append("<p>User: "+loginUser.getUsername()+"</p>");
				msg.append("<p>("+request.getServerName()+"/"+request.getContextPath()+")</p>");
				msg.append("<p> </p>");
				msg.append("<p>Sincerely,</p>");
				msg.append("<p> </p>");
				msg.append("<p>Your friends at Team Sportsware</p>");
				msg.append("</body></html>");
				mailService.sendMail(emailAddr, emailAddr, "Login notification", msg.toString());
			} catch (Exception e) {
				// ignore
			}			
		}
		return dashboard(request);
	}
	
	@RequestMapping("/resetPasswordRequest")
	public ModelAndView resetPasswordRequest(HttpServletRequest request, @RequestParam String emailAddr) {
		// setup new session	
		// check for User by emailAddr... generate "resetKey" , save in Users record, send in Reset request email.
		if(emailAddr==null || emailAddr.length()<1){
				emailAddr = "service@simplyt3s.com";
		}
		String key="al1sk3fj5";
		String path=request.getPathTranslated();
    	try {
			StringBuffer msg = new StringBuffer();	
			msg.append("<html><head></head><body>");
			msg.append("<p>Team Sportsware - Reset Password</p>");
			msg.append("<p> </p>");
			msg.append("<p>You have requested to change your password.</p>");
			msg.append("<p> </p>");
			msg.append("<p><a href='"+path+"/changePassword?emailAddr="+emailAddr+"&key="+key+"'>Click here</a> to reset the password.</p>");
			msg.append("<p> </p>");
			msg.append("<p>Sincerely,</p>");
			msg.append("<p> </p>");
			msg.append("<p>Your friends at Team Sportsware</p>");
			msg.append("</body></html>");
			mailService.sendMail("service@simplyt3s.com", emailAddr, "Reset Password email", msg.toString());
		} catch (Exception e) {
			// no-op
		}
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("../sitemesh-common/resetPasswordRequest.jsp");
		return mav;
	}

	@RequestMapping("/changePassword")
	public ModelAndView changePassword(HttpServletRequest request, @RequestParam String emailAddr, @RequestParam String key) {
		ModelAndView mav = new ModelAndView();
		if(key.equals("al1sk3fj5")){
			Customer cust = customerService.findCustomerByEmailAddr(emailAddr);
			mav.addObject("customer", cust);
			mav.setViewName("customer/changePassword.jsp");
			return mav;			
		}
		mav.setViewName("../sitemesh-common/login.jsp");
		return mav;	
	}	
	
	@RequestMapping("/registerUser")
	public ModelAndView registerUser(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Customer cust = new Customer();
		cust.setActiveYn(1);
		mav.addObject("customer", cust);
		mav.addObject("newFlag", true);
		mav.setViewName("../sitemesh-common/registerUser.jsp");
		return mav;
	}	

	// callback above comes back here... 
	public Users getUser4Username(String userName) throws Exception {
		Set<Users> usersFound = usersService.findUsersByUsername(userName);		
		if(usersFound.isEmpty()){
			throw new Exception("cannot find Username = '"+userName+"'");
		}
		return usersFound.iterator().next();
	}
	
	@RequestMapping("/faq")
	public ModelAndView faq(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(!sessionCache.isSessionAuthenitcated(request)){
			mav.addObject("notAuthenticated", true);
		} else {
			mav.addObject("notAuthenticated", false);			
		}		
		mav.setViewName("../sitemesh-common/faq.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}	
	@RequestMapping("/contactUs")
	public ModelAndView contactUs(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(!sessionCache.isSessionAuthenitcated(request)){
			mav.addObject("notAuthenticated", true);
		} else {
			mav.addObject("notAuthenticated", false);			
		}		
		mav.setViewName("../sitemesh-common/contactUs.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}	
	@RequestMapping("/helpDesk")
	public ModelAndView helpDesk(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		if(!sessionCache.isSessionAuthenitcated(request)){
			mav.addObject("notAuthenticated", true);
		} else {
			mav.addObject("notAuthenticated", false);			
		}
		mav.setViewName("../sitemesh-common/helpDesk.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}		

	/**
	 * Select the child Customer entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteCustomerCustomers")
	public ModelAndView confirmDeleteCustomerCustomers(HttpServletRequest request, @RequestParam Integer customer_customerId, @RequestParam Integer related_customers_customerId) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("customer", customerService.findCustomerByPrimaryKey(related_customers_customerId));
		mav.addObject("customer_customerId", customer_customerId);
		mav.setViewName("customer/customers/deleteCustomers.jsp");

		return mav;
	}

	/**
	 * Delete an existing Customer entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteCustomerCustomers")
	public ModelAndView deleteCustomerCustomers(HttpServletRequest request, @RequestParam Integer customer_customerId, @RequestParam Integer related_customers_customerId) {
		Customer customer = customerService.deleteCustomerCustomers(customer_customerId, related_customers_customerId);
		return editCustomer(request, customer.getCustomerId());
	}
	
	/**  *******************************************************************************************************
	 * 
	 */

	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/emailCustomers")
	public ModelAndView emailCustomers(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("customers", customerService.loadCustomers4tsw(sessionCache.getTswacct(request)));
		// mav.addObject("searchFlag", true);
		mav.setViewName("customer/emailCustomers.jsp");
		mav.addObject("user", sessionCache.getUser4Session(request));
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/adminCustomer")
	public ModelAndView adminCustomers(HttpServletRequest request) {	
		ModelAndView mav = listCustomers(request);
		mav.addObject("adminFlag", true);
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/custCustomer")
	public ModelAndView custCustomers(HttpServletRequest request) {	
		ModelAndView mav = new ModelAndView();
		mav.addObject("customers", customerService.loadCustomers4tsw(sessionCache.getTswacct(request)));
		mav.addObject("adminFlag", false);
		mav.setViewName("customer/listCustomers.jsp");
		mav.addObject("user", sessionCache.getUser4Session(request));
		return mav;
	}	
	
}