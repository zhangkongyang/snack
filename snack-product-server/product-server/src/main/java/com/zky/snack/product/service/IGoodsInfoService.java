package com.zky.snack.product.service;

import java.util.List;
import java.util.Map;

import com.zky.snack.product.bean.GoodsInfo;

public interface IGoodsInfoService {
	public int add(GoodsInfo gf);
	
	public int update(GoodsInfo gf);
	
	/**
	 * 查看商品详细
	 * @param gid
	 * @return
	 */
	public GoodsInfo findByGid(String gno);
	
	/**
	 * 
	 * @param gname
	 * @param tno
	 * @param start 库存的开始值
	 * @param end 库存的结束值
	 * @param page
	 * @param row
	 * @return
	 */
	public Map<String, Object> findByPage(Map<String, Object> map);
	
	public Map<String, Object> findByFirst(Map<String, Object> map);
	
	public List<GoodsInfo> finds(Map<String, Object> map);
}
