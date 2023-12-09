package com.example.demo.service;

import java.util.List;

import com.example.demo.vo.porder;

public interface porderService {
	void addPorder(porder p);
	List<porder> findAll();
}
