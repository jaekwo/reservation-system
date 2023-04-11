package com.nclab.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nclab.dao.nclabmapper;
import com.nclab.service.combinedservice;
import com.nclab.vo.combinedvo;

@Service("mainservice")
public class combinedImpl implements combinedservice {

	@Autowired
	nclabmapper nclabRepository;
	
	
	public combinedvo getEmpno() {
		
		return nclabRepository.getEmpno();
	}

}
