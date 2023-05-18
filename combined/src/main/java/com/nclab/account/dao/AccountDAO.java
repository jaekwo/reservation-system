package com.nclab.account.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nclab.account.vo.AccountVO;

@Mapper
public interface AccountDAO {

	public AccountVO findAccount(String userId);
	public List<AccountVO> listAccount();
	public void insertAccount(AccountVO account);
}
