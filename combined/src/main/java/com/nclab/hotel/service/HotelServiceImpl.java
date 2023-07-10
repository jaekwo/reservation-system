package com.nclab.hotel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nclab.hotel.dao.HotelDAO;
import com.nclab.hotel.vo.HotelVO;
import com.nclab.hotel.vo.SearchDto;

@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	HotelDAO hotelRepository;
	
	@Override
	public List<HotelVO> findHotelByAddressOrName(String keyword) {
		return hotelRepository.findHotelByAddressOrName(keyword);
	}
	
	@Override
	public List<HotelVO> searchHotelList(SearchDto search) {
		return hotelRepository.searchHotelList(search);
	}
}
