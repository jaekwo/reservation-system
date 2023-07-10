package com.nclab.hotel.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nclab.hotel.vo.HotelVO;
import com.nclab.hotel.vo.SearchDto;

@Mapper
public interface HotelDAO {

	public List<HotelVO> findHotelByAddressOrName(String keyword);
	
	public List<HotelVO> searchHotelList(SearchDto search);
}
