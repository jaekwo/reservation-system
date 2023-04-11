package com.nclab.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nclab.account.vo.AccountVO;

public interface AccountService {

	public List<AccountVO> listAccount();
}
