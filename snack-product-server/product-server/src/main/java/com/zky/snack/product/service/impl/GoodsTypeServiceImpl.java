package com.zky.snack.product.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zky.snack.product.bean.GoodsType;
import com.zky.snack.product.mapper.IGoodsTypeMapper;
import com.zky.snack.product.service.IGoodsTypeService;
import com.zky.snack.product.util.StringUtil;


@Service
public class GoodsTypeServiceImpl implements IGoodsTypeService{
	
	@Autowired
	private IGoodsTypeMapper goodsTypeMapper;

	
	public int add(GoodsType type) {
		if (StringUtil.checkNull(type.getTname())) {
			return -1;
		}
		
		return  goodsTypeMapper.add(type);
	}

	
	public int update(GoodsType type) {
		if (StringUtil.checkNull(type.getTname())) {
			return -1;
		}
		
		return goodsTypeMapper.update(type);
	}

	
	public List<GoodsType> findAll() {
		return goodsTypeMapper.findAll();
	}

	
	public List<GoodsType> finds() {
		return goodsTypeMapper.finds();
	}
}
