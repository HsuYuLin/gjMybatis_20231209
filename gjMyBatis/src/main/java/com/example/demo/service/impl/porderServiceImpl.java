package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.porderMapper;
import com.example.demo.service.porderService;
import com.example.demo.vo.porder;

@Service
public class porderServiceImpl implements porderService{
	@Autowired
	porderMapper pm;
	
	@Override
	public void addPorder(porder p) {
		pm.add(p);		
	}

	@Override
	public List<porder> findAll() {		
		return pm.queryAll();
	}

}
