package com.nclab.account.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nclab.account.dao.AccountDAO;
import com.nclab.account.vo.AccountVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountRepository;
	
	@Override
	public AccountVO findAccount(String userId) {
		return accountRepository.findAccount(userId);
	}
	
	@Override
	public List<AccountVO> listAccount() {
		return accountRepository.listAccount();
	}
	
	@Override
	public void insertAccount(AccountVO account) {
		accountRepository.insertAccount(account);
	}
}
