package com.nclab.account.controller;

import javax.servlet.http.HttpSession;

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
	public String loginAction(@RequestBody LoginDto loginUser) {
		String msg = "sucess";
		AccountVO account = accountService.findAccount(loginUser.userId);
		if(account == null) {
			msg = "checkAccount";
			log.info("계정을 확인해주세요");
		} else if (!loginUser.userPw.equals(account.pw)) {
			msg = "checkPw";
			log.info("비밀번호를 확인해주세요");
		} else {
			msg = "sucess";
			// 로그인 처리
			log.info("로그인 : " + account.id);
		}
		return msg;
	}
	
	@PostMapping(value="/joinAction")
	public AccountVO joinAction(@RequestBody JoinDto joinDto) {
		AccountVO account = new AccountVO(joinDto);
		accountService.insertAccount(account);
		return account;
	}
	
	
	

}
