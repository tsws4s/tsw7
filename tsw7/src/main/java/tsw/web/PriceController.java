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

import tsw.domain.Price;

import tsw.service.PriceService;

/**
 * Spring MVC controller that handles CRUD requests for Price entities
 * 
 */

@Controller("PriceController")
public class PriceController {
    
	SessionConfigCache sessionCache = UsersController.getSessionCache();

	/**
	 * Service injected by Spring that provides CRUD operations for Price entities
	 * 
	 */
	@Autowired
	private PriceService priceService;

	/**
	 * Entry point to show all Price entities
	 * 
	 */
	public String indexPrice() {
		return "redirect:/indexPrice";
	}

	// Init
	/**  ***************************************  Init  *******************************************************
	 * 	 * Register custom, context-specific property editors
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
	@RequestMapping("/priceController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}
	
	// List Search
	/**  *************************************  List Search  *************************************************
	 * 	 * Show all Price entities
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexPrice")
	public ModelAndView listPrices(HttpServletRequest request) {
		return listPricesFrom(request, 0);
	}
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/indexPriceFrom")
	public ModelAndView listPricesFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prices", priceService.loadPrices4tsw(sessionCache.getTswacct(request)));
		mav.addObject("indexFrom", indexFrom);
		mav.addObject("indexCount", priceService.getPriceCount4tsw(sessionCache.getTswacct(request)));
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("price/listPrices.jsp");
		return mav;
	}
	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchPriceFrom")
	public ModelAndView searchPriceFrom(HttpServletRequest request, @RequestParam int indexFrom) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("prices", priceService.loadPrices4tsw(sessionCache.getTswacct(request)));
		mav.addObject("searchFlag", true);
		mav.addObject("indexFrom", indexFrom);
		mav.addObject("indexCount", priceService.getPriceCount4tsw(sessionCache.getTswacct(request)));
		mav.addObject("resultsPerPage", sessionCache.getResultsPerPage(request));
		mav.addObject("user",sessionCache.getUser4Session(request));
		mav.setViewName("price/searchPrices.jsp");
		return mav;
	}	
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/searchPrice")
	public ModelAndView searchPrice(HttpServletRequest request) {
		return searchPriceFrom(request, 0);
	}
	
	// Add Edit Delete Confirm Save
	/**  **************************************  Add Edit Delete Confirm Save *********************************************
	 * 	 * Create a new Price entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/newPrice")
	public ModelAndView newPrice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("price", new Price());
		mav.addObject("newFlag", true);
		mav.setViewName("price/editPrice.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Edit an existing Price entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/editPrice")
	public ModelAndView editPrice(HttpServletRequest request, @RequestParam Integer priceIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("price", priceService.findPriceByPrimaryKey(priceIdKey));
		mav.setViewName("price/editPrice.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}

	/**
	 * Delete an existing Price entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/deletePrice")
	public String deletePrice(HttpServletRequest request, @RequestParam Integer priceIdKey) {
		Price price = priceService.findPriceByPrimaryKey(priceIdKey);
		priceService.deletePrice(price);
		return "forward:/indexPrice";
	}
	
	/**
	 * Select the Price entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/confirmDeletePrice")
	public ModelAndView confirmDeletePrice(HttpServletRequest request, @RequestParam Integer priceIdKey) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("price", priceService.findPriceByPrimaryKey(priceIdKey));
		mav.setViewName("price/deletePrice.jsp");
		mav.addObject("user",sessionCache.getUser4Session(request));
		return mav;
	}
	
	/**
	 * Save an existing Price entity
	 * 
	 */
	@Secured({ "ROLE_IS_AUTHENTICATED_REMEMBERED" })
	@RequestMapping("/savePrice")
	public String savePrice(HttpServletRequest request, @ModelAttribute Price price) {
		priceService.savePrice(sessionCache.getTswacct(request), price);
		return "forward:/indexPrice";
	}
}