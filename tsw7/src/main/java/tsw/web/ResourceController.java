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

import org.joda.time.DateTime;
import tsw.domain.Resource;
import tsw.domain.Tswacct;

import tsw.service.PriceService;
import tsw.service.ResourceService;
import tsw.service.SportService;

/**
 * Spring MVC controller that handles CRUD requests for Resource entities
 * 
 */

@Controller("ResourceController")
public class ResourceController {

	static int defaultMaxRows = 100;
   
	SessionConfigCache sessionCache = UsersController.getSessionCache();
	
	/**
	 * Service injected by Spring that provides CRUD operations for Resource entities
	 * 
	 */
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private PriceService priceService;
	@Autowired
	SportService sportService;

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
	@RequestMapping("/resourceController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	// List Search
	/**  *************************************  List Search  *************************************************
	 * 	 * Show all Resource entities
	 * 
	 */
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexResource")
	public ModelAndView listResources(HttpServletRequest request) {
		return listResourceFrom(request, 0);
	}
	
	/**
	 * Entry point to show all Resource entities
	 * 
	 */
	public String indexResource(HttpServletRequest request) {
		return "redirect:/indexResource";
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexResourceFrom")
	public ModelAndView listResourceFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Set<Resource> resources4Session = sessionCache.getResources4Session(request);
		mav.addObject("resources", resources4Session);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("resource/listResources.jsp");
		return mav;
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchResources")
	public ModelAndView searchResources(HttpServletRequest request) {
		return searchResourcesFrom(request, 0);
	}
	
	//TODO: [Veera] (Search-Med) For Searches, change window.open() to use Lightbox instead

	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchResourcesFrom")
	public ModelAndView searchResourcesFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		Set<Resource> resources4Session = sessionCache.getResources4Session(request);
		mav.addObject("resources", resources4Session);
		mav.addObject("searchFlag", true);
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("resource/searchResources.jsp");
		return mav;
	}
	/**
	 * Show all Schedule entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/scheduling")
	public ModelAndView scheduling(HttpServletRequest request, @RequestParam Integer resource_resourceId, @RequestParam java.util.Calendar afterDate, @RequestParam java.util.Calendar beforeDate) {
		ModelAndView mav = new ModelAndView();
		if(resource_resourceId==null){
			resource_resourceId = sessionCache.getTswacct(request).getDefaultResourceId();
		}
		if(afterDate==null){
			DateTime dt = new DateTime();
			dt = dt.minusDays(1);
			afterDate=dt.toGregorianCalendar();
		}
		if(beforeDate==null){
			DateTime dt = new DateTime(afterDate);
			dt = dt.plusDays(2);
			beforeDate = dt.toGregorianCalendar();
		}
		Resource res = resourceService.findResourceByPrimaryKey(resource_resourceId);
		mav.addObject("res", res);
		sessionCache.setEvents4Resource(request, res);
		mav.addObject("resourceId", resource_resourceId);
		mav.addObject("afterDate", afterDate);
		mav.addObject("beforeDate", beforeDate);
		Set<Resource> resources4Session = sessionCache.getResources4Session(request);
		mav.addObject("resources", resources4Session);
		mav.setViewName("resource/schedule.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * Create a new Resource entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newResource")
	public ModelAndView newResource(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		Resource res = new Resource();
		res.setActiveYn(1);
		mav.addObject("resource", res);
		mav.addObject("newFlag", true);
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("resource/editResource.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Resource entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editResource")
	public ModelAndView editResource(HttpServletRequest request, @RequestParam Integer resourceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("resource", resourceService.findResourceByPrimaryKey(resourceIdKey));
		Integer startResult= -1;
		Tswacct tswacct = sessionCache.getTswacct(request);
		mav.addObject("sports", sportService.findAllSports(startResult, defaultMaxRows));
		mav.addObject("prices", priceService.findAllPrices4tsw(tswacct, startResult , defaultMaxRows));
		mav.setViewName("resource/editResource.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Select the Resource entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeleteResource")
	public ModelAndView confirmDeleteResource(HttpServletRequest request, @RequestParam Integer resourceIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("resource", resourceService.findResourceByPrimaryKey(resourceIdKey));
		mav.setViewName("resource/deleteResource.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Delete an existing Resource entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deleteResource")
	public String deleteResource(HttpServletRequest request, @RequestParam Integer resourceIdKey) {
		Resource resource = resourceService.findResourceByPrimaryKey(resourceIdKey);
		resourceService.deleteResource(resource);
		return "forward:/indexResource";
	}
	
	/**
	 * Save an existing Resource entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/saveResource")
	public String saveResource(HttpServletRequest request, @ModelAttribute Resource resource, @RequestParam Integer selected_id11) {
		resourceService.saveResource(request, resource, selected_id11);
		sessionCache.resestSessionConfig(request);
		return "forward:/indexResource";
	}
	
}