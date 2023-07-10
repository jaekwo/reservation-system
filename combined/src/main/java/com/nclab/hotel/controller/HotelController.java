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
import com.nclab.hotel.vo.SearchDto;

@RestController
@RequestMapping("/vue/hotel")
public class HotelController {

	private Logger log = LoggerFactory.getLogger(HotelController.class);
	
	@Autowired
	public HotelServiceImpl hotelService;
	
	@PostMapping(value="/searchHotel")
	public List<HotelVO> searchHotelList(@RequestBody SearchDto search) {
		List<HotelVO> hotelList = hotelService.searchHotelList(search);
		return hotelList;
	}
	
	@PostMapping(value="/hotelList")
	public List<HotelVO> getHotelList(@RequestBody String keyword) {
		keyword = keyword.replaceAll("\"", "");
		if(keyword.equals("")) {
			keyword = "-";
		}
		List<HotelVO> hotelList = hotelService.findHotelByAddressOrName(keyword);
		return hotelList;
	}
}
