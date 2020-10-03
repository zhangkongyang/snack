	package com.zky.snack.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zky.snack.product.bean.GoodsType;
import com.zky.snack.product.enums.ResultEnum;
import com.zky.snack.product.service.IGoodsTypeService;
import com.zky.snack.product.vo.ResultVO;

@RestController
@RequestMapping("/types")
public class GoodsTypeController{
	
	@Autowired
	private IGoodsTypeService  goodsTypeService;
	
	@GetMapping("/finds")
	public ResultVO finds() {
		System.out.println(goodsTypeService);
		List<GoodsType> list = goodsTypeService.finds();
		if(list==null ||list.isEmpty()) {
			return new ResultVO(ResultEnum.DATA_NULL);
		}
		return new ResultVO(ResultEnum.SUCCESS,list);
	}
	
	@PostMapping("/findAll")
	public List<GoodsType> findAll(){
		return goodsTypeService.findAll();
	}
	
	@PostMapping("/find")
	public List<GoodsType> find(){
		return goodsTypeService.finds();
	}
	
}
