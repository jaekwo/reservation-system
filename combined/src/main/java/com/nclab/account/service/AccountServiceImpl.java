package com.nclab.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nclab.account.dao.AccountDAO;
import com.nclab.account.vo.AccountVO;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountDAO accountRepository;
	
	@Override
	public List<AccountVO> listAccount() {
		return accountRepository.listAccount();
	}
	
}
