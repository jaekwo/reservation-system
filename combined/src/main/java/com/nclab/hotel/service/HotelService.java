package com.nclab.hotel.service;

import java.util.List;

import com.nclab.hotel.vo.HotelVO;

public interface HotelService {

	public List<HotelVO> findHotelByAddressOrName(String keyword);
}