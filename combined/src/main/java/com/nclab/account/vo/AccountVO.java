package com.nclab.account.vo;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
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
	
	public AccountVO(String id, String pw, String name, String mobile, String birthDay, String email,
			LocalDateTime creDtt, LocalDateTime updDtt, int grade) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.mobile = mobile;
		this.birthDay = birthDay;
		this.email = email;
		this.creDtt = creDtt;
		this.updDtt = updDtt;
		this.grade = grade;
	}

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
