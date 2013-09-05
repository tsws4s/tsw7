package myinfo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myinfo.dao.MyCategoryDAO;

import myinfo.domain.MyCategory;

import myinfo.service.MyCategoryService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for MyCategory entities
 * 
 */

@Controller("MyCategoryController")
public class MyCategoryController {

	/**
	 * DAO injected by Spring that manages MyCategory entities
	 * 
	 */
	@Autowired
	private MyCategoryDAO myCategoryDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for MyCategory entities
	 * 
	 */
	@Autowired
	private MyCategoryService myCategoryService;

	/**
	 * Delete an existing MyCategory entity
	 * 
	 */
	@RequestMapping("/deleteMyCategory")
	public String deleteMyCategory(@RequestParam Integer categoryIdKey) {
		MyCategory mycategory = myCategoryDAO.findMyCategoryByPrimaryKey(categoryIdKey);
		myCategoryService.deleteMyCategory(mycategory);
		return "forward:/indexMyCategory";
	}

	/**
	 * Entry point to show all MyCategory entities
	 * 
	 */
	public String indexMyCategory() {
		return "redirect:/indexMyCategory";
	}

	/**
	 * Create a new MyCategory entity
	 * 
	 */
	@RequestMapping("/newMyCategory")
	public ModelAndView newMyCategory() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("mycategory", new MyCategory());
		mav.addObject("newFlag", true);
		mav.setViewName("mycategory/editMyCategory.jsp");

		return mav;
	}

	/**
	 * Save an existing MyCategory entity
	 * 
	 */
	@RequestMapping("/saveMyCategory")
	public String saveMyCategory(@ModelAttribute MyCategory mycategory) {
		myCategoryService.saveMyCategory(mycategory);
		return "forward:/indexMyCategory";
	}

	/**
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
	 * Edit an existing MyCategory entity
	 * 
	 */
	@RequestMapping("/editMyCategory")
	public ModelAndView editMyCategory(@RequestParam Integer categoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("mycategory", myCategoryDAO.findMyCategoryByPrimaryKey(categoryIdKey));
		mav.setViewName("mycategory/editMyCategory.jsp");

		return mav;
	}

	/**
	 * Show all MyCategory entities
	 * 
	 */
	@RequestMapping("/indexMyCategory")
	public ModelAndView listMyCategorys() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("mycategorys", myCategoryService.loadMyCategorys());

		mav.setViewName("mycategory/listMyCategorys.jsp");

		return mav;
	}

	/**
	 * Select the MyCategory entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteMyCategory")
	public ModelAndView confirmDeleteMyCategory(@RequestParam Integer categoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("mycategory", myCategoryDAO.findMyCategoryByPrimaryKey(categoryIdKey));
		mav.setViewName("mycategory/deleteMyCategory.jsp");

		return mav;
	}

	/**
	 */
	@RequestMapping("/mycategoryController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Select an existing MyCategory entity
	 * 
	 */
	@RequestMapping("/selectMyCategory")
	public ModelAndView selectMyCategory(@RequestParam Integer categoryIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("mycategory", myCategoryDAO.findMyCategoryByPrimaryKey(categoryIdKey));
		mav.setViewName("mycategory/viewMyCategory.jsp");

		return mav;
	}
}