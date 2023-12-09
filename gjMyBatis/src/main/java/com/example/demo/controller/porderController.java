package com.example.demo.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.impl.porderServiceImpl;
import com.example.demo.vo.member;
import com.example.demo.vo.porder;

import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/porder")
public class porderController {
	@Autowired
	porderServiceImpl psi;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	HttpServletResponse response;
	
	@GetMapping("/porder")
	public ModelAndView goToPorder()
	{
		return new ModelAndView("/porder/porder");
	}
	
	/*@GetMapping("/confirm")
	public ModelAndView goToConfirm()
	{
		return new ModelAndView("/porder/confirm");
	}*/
	
	/*@GetMapping("/finish")
	public ModelAndView goToFinish()
	{
		return new ModelAndView("/porder/finish");
	}*/
	
	@PostMapping("/add")
	public ModelAndView addPorder(int A,int B,int C)
	{
		/*
		 * 1.擷取session-->member
		 * 2.new porder-->轉session
		 * 3.切換-->confirm頁
		 * */
		member m=(member)session.getAttribute("M");
		porder p=new porder(m.getName(),A,B,C);
		
		session.setAttribute("P", p);
		
		return new ModelAndView("/porder/confirm");
	}
	
	@RequestMapping("/finish")
	public ModelAndView goToFinish()
	{
		/*
		 * 1.擷取session-->P
		 * 2.psi.addPorder
		 * 3.切換-->finish頁
		 * */
		porder p=(porder)session.getAttribute("P");
		psi.addPorder(p);
		
		return new ModelAndView("/porder/finish");
	}
	
	@GetMapping("/logout")
	public void logOut()
	{
		session.removeAttribute("M");
		session.removeAttribute("P");
		
		try {
			response.sendRedirect("/index.html");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
