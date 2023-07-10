package com.nclab.account.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.nclab.account.vo.AccountVO;

public interface AccountService {

	public AccountVO findAccount(String userId);
	public List<AccountVO> listAccount();
	public void insertAccount(AccountVO account);
}
