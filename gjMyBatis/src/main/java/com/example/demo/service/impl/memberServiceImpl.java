package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.memberMapper;
import com.example.demo.service.memberService;
import com.example.demo.vo.member;

/*用@Service宣告成一個Bean*/
@Service 
public class memberServiceImpl implements memberService {
	@Autowired
	memberMapper mp;
		
	@Override
	public void addMember(member m) {
		mp.add(m);		
	}

	@Override
	public member login(String username, String password) {
		member m=mp.queryUser(username, password);
		return m;
	}

	@Override
	public boolean usernameRepeat(String username) {
		member m=mp.queryUsername(username);
		
		boolean x=false;
		if(m!=null) x=true;
		
		return x;
	}

}
