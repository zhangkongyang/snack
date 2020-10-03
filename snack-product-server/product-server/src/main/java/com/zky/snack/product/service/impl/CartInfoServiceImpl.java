package com.zky.snack.product.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zky.snack.product.bean.CartInfo;
import com.zky.snack.product.mapper.ICartInfoMapper;
import com.zky.snack.product.service.ICartInfoService;
import com.zky.snack.product.util.StringUtil;

@Service
public class CartInfoServiceImpl implements ICartInfoService {

	@Autowired
	private ICartInfoMapper cartInfoMapper;

	
	public List<CartInfo> finds(String mno) {
		if (StringUtil.checkNull(mno)) {
			return Collections.emptyList();
		}
		return cartInfoMapper.finds(mno);
	}

	
	public List<Map<String, String>> info(String mno) {
		if (StringUtil.checkNull(mno)) {
			return Collections.emptyList();
		}
		return cartInfoMapper.info(mno);
	}

	
	public int add(CartInfo cf) {
		if (StringUtil.checkNull(cf.getCno())) {
			return -1;
		}
		return cartInfoMapper.add(cf);
	}

	
	public int delete(String[] cnos) {
		if (StringUtil.checkNull(cnos)) {
			return -1;
		}
		return cartInfoMapper.delete(cnos);
	}

	
	public int updateNum(Map<String, Object> map) {

		if (StringUtil.checkNull(map.get("cno"))) {
			return -1;
		}
		return cartInfoMapper.updateNum(map);
	}

	
	public List<CartInfo> findByCno(String cnos) {
		if (StringUtil.checkNull(cnos)){
			return Collections.emptyList();
		}

		return cartInfoMapper.findByCno(cnos);
	}

}
