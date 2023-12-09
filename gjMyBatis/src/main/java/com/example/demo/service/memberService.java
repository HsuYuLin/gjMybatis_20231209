package com.example.demo.service;

import com.example.demo.vo.member;

public interface memberService {
	//新增會員
	void addMember(member m);
	
	//登入
	member login(String username,String password);
	
	//檢查帳號是否重複
	boolean usernameRepeat(String username);
}
