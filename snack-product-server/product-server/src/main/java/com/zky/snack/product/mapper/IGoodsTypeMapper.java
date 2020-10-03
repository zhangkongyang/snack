package com.zky.snack.product.mapper;

import java.util.List;

import com.zky.snack.product.bean.GoodsType;

public interface IGoodsTypeMapper {
	
public int add(GoodsType type);
	
	public int update(GoodsType type);
	
	public List<GoodsType> findAll();
	
	public List<GoodsType> finds();

}
