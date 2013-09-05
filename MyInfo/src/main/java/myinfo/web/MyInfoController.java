package myinfo.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myinfo.dao.MyInfoDAO;

import myinfo.domain.MyInfo;

import myinfo.service.MyInfoService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.WebDataBinder;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

/**
 * Spring MVC controller that handles CRUD requests for MyInfo entities
 * 
 */

@Controller("MyInfoController")
public class MyInfoController {

	/**
	 * DAO injected by Spring that manages MyInfo entities
	 * 
	 */
	@Autowired
	private MyInfoDAO myInfoDAO;

	/**
	 * Service injected by Spring that provides CRUD operations for MyInfo entities
	 * 
	 */
	@Autowired
	private MyInfoService myInfoService;

	/**
	 * Entry point to show all MyInfo entities
	 * 
	 */
	public String indexMyInfo() {
		return "redirect:/indexMyInfo";
	}

	/**
	 * Select the MyInfo entity for display allowing the user to confirm that they would like to delete the entity
	 * 
	 */
	@RequestMapping("/confirmDeleteMyInfo")
	public ModelAndView confirmDeleteMyInfo(@RequestParam Integer myInfoIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("myinfo", myInfoDAO.findMyInfoByPrimaryKey(myInfoIdKey));
		mav.setViewName("myinfo/deleteMyInfo.jsp");

		return mav;
	}

	/**
	 * Show all MyInfo entities
	 * 
	 */
	@RequestMapping("/indexMyInfo")
	public ModelAndView listMyInfos() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("myinfos", myInfoService.loadMyInfos());

		mav.setViewName("myinfo/listMyInfos.jsp");

		return mav;
	}

	/**
	 * Edit an existing MyInfo entity
	 * 
	 */
	@RequestMapping("/editMyInfo")
	public ModelAndView editMyInfo(@RequestParam Integer myInfoIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("myinfo", myInfoDAO.findMyInfoByPrimaryKey(myInfoIdKey));
		mav.setViewName("myinfo/editMyInfo.jsp");

		return mav;
	}

	/**
	 * Save an existing MyInfo entity
	 * 
	 */
	@RequestMapping("/saveMyInfo")
	public String saveMyInfo(@ModelAttribute MyInfo myinfo) {
		myInfoService.saveMyInfo(myinfo);
		return "forward:/indexMyInfo";
	}

	/**
	 */
	@RequestMapping("/myinfoController/binary.action")
	public ModelAndView streamBinary(@ModelAttribute HttpServletRequest request, @ModelAttribute HttpServletResponse response) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("streamedBinaryContentView");
		return mav;

	}

	/**
	 * Create a new MyInfo entity
	 * 
	 */
	@RequestMapping("/newMyInfo")
	public ModelAndView newMyInfo() {
		ModelAndView mav = new ModelAndView();

		mav.addObject("myinfo", new MyInfo());
		mav.addObject("newFlag", true);
		mav.setViewName("myinfo/editMyInfo.jsp");

		return mav;
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
	 * Select an existing MyInfo entity
	 * 
	 */
	@RequestMapping("/selectMyInfo")
	public ModelAndView selectMyInfo(@RequestParam Integer myInfoIdKey) {
		ModelAndView mav = new ModelAndView();

		mav.addObject("myinfo", myInfoDAO.findMyInfoByPrimaryKey(myInfoIdKey));
		mav.setViewName("myinfo/viewMyInfo.jsp");

		return mav;
	}

	/**
	 * Delete an existing MyInfo entity
	 * 
	 */
	@RequestMapping("/deleteMyInfo")
	public String deleteMyInfo(@RequestParam Integer myInfoIdKey) {
		MyInfo myinfo = myInfoDAO.findMyInfoByPrimaryKey(myInfoIdKey);
		myInfoService.deleteMyInfo(myinfo);
		return "forward:/indexMyInfo";
	}
}