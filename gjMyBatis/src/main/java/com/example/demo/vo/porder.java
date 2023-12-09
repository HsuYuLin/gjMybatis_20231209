package com.example.demo.vo;

import lombok.Data;

@Data
public class porder {
	private Integer id;
	private String name;
	private Integer a;
	private Integer b;
	private Integer c;
	public porder(String name, Integer a, Integer b, Integer c) {
		super();
		this.name = name;
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public porder() {
		super();
		// TODO Auto-generated constructor stub
	}
}
