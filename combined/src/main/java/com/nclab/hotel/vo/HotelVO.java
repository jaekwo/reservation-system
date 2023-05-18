package com.nclab.hotel.vo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class HotelVO {
	
	public String hotelCode;
	public int areaCode;
	public String address;
	public String name;
	public int grade;
}
