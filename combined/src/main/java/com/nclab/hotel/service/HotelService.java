package com.nclab.hotel.service;

import java.util.List;

import com.nclab.hotel.vo.HotelVO;
import com.nclab.hotel.vo.SearchDto;

public interface HotelService {

	public List<HotelVO> findHotelByAddressOrName(String keyword);
	
	public List<HotelVO> searchHotelList(SearchDto search);
}
