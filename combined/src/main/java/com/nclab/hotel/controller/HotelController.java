package com.nclab.hotel.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nclab.hotel.service.HotelServiceImpl;
import com.nclab.hotel.vo.HotelVO;

@RestController
@RequestMapping("/vue/hotel")
public class HotelController {

	private Logger log = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	public HotelServiceImpl hotelService;
	
	@GetMapping(value="/test")
	public List<HotelVO> getTest() {
		List<HotelVO> hotelList = hotelService.getTest();
		
		for(HotelVO t : hotelList) {
			System.out.println(t.name);
		}
		
		return hotelList;
	}
	
	@PostMapping(value="/hotelList")
	public List<HotelVO> getHotelList(@RequestBody String keyword) {
		List<HotelVO> hotelList = hotelService.findHotelByAddressOrName(keyword.replaceAll("\"", ""));
		
		for(HotelVO t : hotelList) {
			System.out.println("호텔리스트 : " + t.name);
		}
		return hotelList;
	}
}
