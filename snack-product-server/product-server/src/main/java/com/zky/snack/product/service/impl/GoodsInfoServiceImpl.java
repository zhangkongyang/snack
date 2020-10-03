package com.zky.snack.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zky.snack.product.bean.GoodsInfo;
import com.zky.snack.product.mapper.IGoodsInfoMapper;
import com.zky.snack.product.service.IGoodsInfoService;
import com.zky.snack.product.util.RequestParamUtil;
import com.zky.snack.product.util.StringUtil;


@Service
public class GoodsInfoServiceImpl implements IGoodsInfoService{
   
	@Autowired
	private IGoodsInfoMapper goodsInfoMapper;

	
	public int add(GoodsInfo gf) {
		if (StringUtil.checkNull(gf.getGname(), gf.getPrice(), gf.getPics())) {
			return -1;
		}
		
		return goodsInfoMapper.add(gf);
	}

	
	public int update(GoodsInfo gf) {
		if (StringUtil.checkNull(gf.getGname(), gf.getPrice(), gf.getPics())) {
			return -1;
		}

		return goodsInfoMapper.update(gf);
	}

	
	public GoodsInfo findByGid(String gno) {
		if (StringUtil.checkNull(gno)) {
			return null;
		}
		
		return goodsInfoMapper.findByGid(gno);
	}

	
	public Map<String, Object> findByPage(Map<String, Object> map) {
		map=RequestParamUtil.updateFindByPage(map);
		map.put("total",goodsInfoMapper.total(map));
		map.put("rows", goodsInfoMapper.findByPage(map));
		return map;
	}

	
	public Map<String, Object> findByFirst(Map<String, Object> map) {
		
		map=RequestParamUtil.updateFindByPage(map);

		map.put("total", goodsInfoMapper.totals(map));
		map.put("rows", goodsInfoMapper.finds(map));
		return map;
	}

	
	public List<GoodsInfo> finds(Map<String, Object> map) {
		map=RequestParamUtil.updateFindByPage(map);	
		return goodsInfoMapper.finds(map);
	}
}
