package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.vo.porder;

@Mapper //用來產生Bean
public interface porderMapper {
	@Insert("insert into porder(name,a,b,c) values(#{name},#{a},#{b},#{c})")
	void add(porder p);
	
	@Select("select * from porder")
	List<porder> queryAll();
}
