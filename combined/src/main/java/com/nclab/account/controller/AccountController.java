package com.nclab.account.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nclab.account.service.AccountServiceImpl;
import com.nclab.account.vo.AccountVO;

@Controller
public class AccountController {
	
	private Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	public AccountServiceImpl accountService;
	
	@RequestMapping("/news")
	public @ResponseBody Map<String, Object> accountList() throws Exception {
		Map<String, Object> rtnObj = new HashMap<String, Object>();
		
		List<AccountVO> accountList = accountService.listAccount();
		logger.info("account ->" + accountList.toString());
		
		rtnObj.put("account_list", accountList);
		return rtnObj;
	}

}
