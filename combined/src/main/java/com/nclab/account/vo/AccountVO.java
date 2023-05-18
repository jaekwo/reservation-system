package com.nclab.account.vo;

import java.time.LocalDateTime;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Getter
@NoArgsConstructor
public class AccountVO {

	public String id;
	public String pw;
	public String name;
	public String mobile;
	public String birthDay;
	public String email;
	public LocalDateTime creDtt;
	public LocalDateTime updDtt;
	public int grade;
	
	public AccountVO(JoinDto joinDto) {
		this.id = joinDto.id;
		this.pw = joinDto.pw;
		this.name = joinDto.name;
		this.mobile = joinDto.mobile;
		this.birthDay = joinDto.birthDay;
		this.email = joinDto.email;
		this.creDtt = LocalDateTime.now();
		this.updDtt = LocalDateTime.now();
		this.grade = 1;
	}
}
