package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.impl.memberServiceImpl;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;

import jakarta.servlet.http.HttpSession;

@RestController
public class memberController {
	@Autowired
	memberServiceImpl msi;
	
	@Autowired
	HttpSession session;
	
	@PostMapping("/Login")
	public ModelAndView gotoLogin(String username,String password)
	{
		member m=msi.login(username, password);
		
		ModelAndView mav=null;
		if(m!=null)
		{
			session.setAttribute("M", m);
			
			List<porder> a=new ArrayList();			
			session.setAttribute("L", a);
			
			mav=new ModelAndView("/loginSuccess");
		}
		else
		{
			mav=new ModelAndView("/loginError");
		}
		
		return mav;
	}
	
	@GetMapping("/addMember")
	public ModelAndView gotoAddMember()
	{
		return new ModelAndView("/addMember");
	}
	
	@PostMapping("/add")
	public ModelAndView addMember(String name, String username, String password)
	{
		/*
		 * 檢查帳號是否重複
		 * 1. 重複-->addMemberError
		 * 2. 沒有-->新增
		 * */
		boolean x=msi.usernameRepeat(username);
		
		ModelAndView mav=null;
		if(x)
		{
			mav=new ModelAndView("/addMemberError");
		}
		else
		{
			member m=new member(name,username,password);
			msi.addMember(m);
			
			mav=new ModelAndView("/addMemberSuccess");
		}
		
		return mav;
	}
}
