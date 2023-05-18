package com.nclab.account.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nclab.account.service.AccountServiceImpl;
import com.nclab.account.vo.AccountVO;
import com.nclab.account.vo.JoinDto;
import com.nclab.account.vo.LoginDto;

@RestController
@RequestMapping("/vue/account")
public class AccountController {
	
	private Logger log = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	public AccountServiceImpl accountService;

	@PostMapping(value="/loginAction")
	public AccountVO loginAction(@RequestBody LoginDto loginUser) {
		AccountVO accountVO = accountService.findAccount(loginUser.userId);
		if(accountVO == null) throw new NullPointerException("계정을 확인해주세요.");
		return accountVO;
	}
	
	@PostMapping(value="/joinAction")
	public AccountVO joinAction(@RequestBody JoinDto joinDto) {
		AccountVO account = new AccountVO(joinDto);
		accountService.insertAccount(account);
		return account;
	}
	
	
	

}
