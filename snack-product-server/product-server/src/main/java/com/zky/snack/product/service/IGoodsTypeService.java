package com.zky.snack.product.service;

import java.util.List;

import com.zky.snack.product.bean.GoodsType;

public interface IGoodsTypeService {
	public int add(GoodsType type);
	
	public int update(GoodsType type);
	
	public List<GoodsType> findAll();
	
	public List<GoodsType> finds();
}
