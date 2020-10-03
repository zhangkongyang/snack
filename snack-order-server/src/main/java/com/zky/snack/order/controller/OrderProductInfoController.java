package com.zky.snack.order.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zky.snack.order.enums.ResultEnum;
import com.zky.snack.order.vo.ResultVO;
import com.zky.snack.product.dto.ProductInfoDTO;

@RestController
@RequestMapping("product")
public class OrderProductInfoController {
	@PostMapping("listForGno")
	public ResultVO listForGno(@RequestParam List<String> gno) {
		ProductInfoDTO dto=null;
		return new ResultVO(ResultEnum.DATA_NULL);
	}

}
