package com.nclab.controller;

import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nclab.service.combinedservice;
import com.nclab.vo.combinedvo;

@Controller
public class nclabController {

	@Resource(name="mainservice")
	combinedservice comservice;
	
	@RequestMapping(value="/main", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		
		combinedvo comvo = comservice.getEmpno();
		System.out.println("Å×½ºÆ®"+comvo.getEname());
		model.addAttribute("empno", comvo);
		return "d";
	}
}
