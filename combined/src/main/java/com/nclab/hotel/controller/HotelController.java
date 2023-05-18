package com.nclab.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nclab.hotel.service.HotelServiceImpl;
import com.nclab.hotel.vo.HotelVO;

@RestController
@RequestMapping("/vue/hotel")
public class HotelController {

	private Logger log = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	public HotelServiceImpl hotelService;
	
	@PostMapping(value="/hotelList")
	public List<String> getHotelList(@RequestBody String keyword) {
		List<HotelVO> hotelList = hotelService.findHotelByAddressOrName(keyword);
		List<String> hotelNames = hotelList.stream().map(a -> a.name).toList();
		
		for(String t : hotelNames) {
			System.out.println("호텔리스트 : " + t + " / " + t);
		}
		return hotelNames;
	}
}
