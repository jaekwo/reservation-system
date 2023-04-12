package com.nclab.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.nclab.account.service.AccountServiceImpl;
import com.nclab.account.vo.AccountVO;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	public AccountServiceImpl accountService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Home...");
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping(value="/data", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> data(@RequestParam(name="msg", defaultValue="test") String msg) {
		logger.debug("Message : {}", msg);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("message", "Server message with " + msg);
		return map;
	}
	
	@RequestMapping(value="/data2", method=RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> data2() throws Exception {
		Map<String, Object> rtnObj = new HashMap<String, Object>();
		List<AccountVO> accountList = accountService.listAccount();
		rtnObj.put("account_list", accountList);
		return rtnObj;
	}
}
