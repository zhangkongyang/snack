package com.zky.snack.product.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.zky.snack.product.bean.GoodsInfo;
import com.zky.snack.product.enums.ResultEnum;
import com.zky.snack.product.service.IGoodsInfoService;
import com.zky.snack.product.util.StringUtil;
import com.zky.snack.product.vo.ResultVO;

@RestController
@RequestMapping("/goods")
public class GoodsInfoController {

	@Autowired
	private IGoodsInfoService goodsInfoService;

	@PostMapping("/findByFirst")
	public ResultVO findByFirst(@RequestParam Map<String, Object> map) {
		Map<String, Object> findByFirst = goodsInfoService.findByFirst(map);
		return new ResultVO(ResultEnum.SUCCESS, findByFirst);
	}

	@PostMapping("/finds")
	public ResultVO finds(@RequestParam Map<String, Object> map) {

		List<GoodsInfo> finds = goodsInfoService.finds(map);
		return new ResultVO(ResultEnum.SUCCESS, finds);
	}

	@PostMapping("/findByPage")
	public Map<String, Object> findByPage(@RequestParam Map<String, Object> map) {
		return goodsInfoService.findByPage(map);
	}

	@PostMapping("/upload")
	public Map<String, Object> uploadPic(HttpServletRequest request, @RequestParam("upload") MultipartFile pic) {
		Map<String, Object> map = new HashMap<String, Object>();

		try {

			System.out.println(pic);
			if (pic.isEmpty()) {
				return map;
			}

			String savePath = "pics";

			String path = request.getServletContext().getRealPath(""); // 取当前项目在服务器中的绝对路径
			String temp = request.getServletContext().getInitParameter("uploadPath");
			System.out.println(temp);
			if (!StringUtil.checkNull(temp)) {
				savePath = temp;
			}

			savePath += "/" + new Date().getTime() + "_" + pic.getOriginalFilename(); // 获取文件名并在前面加上一个时间戳
			File dest = new File(new File(path).getParentFile(), savePath);

			// 将图片从本地保持到服务器
			pic.transferTo(dest);

			map.put("fileName", pic.getOriginalFilename());
			map.put("uploaded", 1);
			map.put("url", "../../../" + savePath);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return map;
	}

	@PostMapping("/add")
	public ResultVO addGoods(@RequestParam("picinfo") MultipartFile[] pics, GoodsInfo gf, HttpServletRequest request) {
		if (pics != null && pics.length > 0 && !pics[0].isEmpty()) {

			try {
				String savePath = "pics";
				String basepath = request.getServletContext().getRealPath(""); // 取当前项目在服务器中的绝对路径
				String temp = request.getServletContext().getInitParameter("uploadPath");
				if (!StringUtil.checkNull(temp)) {
					savePath = temp;
				}
				System.out.println("basepath="+basepath);
				System.out.println("savePath="+savePath);

				String picStr = "";
				File dest = null;
				String path="";
            
				for (MultipartFile fl : pics) {

					path +=savePath+ "/" + new Date().getTime() + "_" + fl.getOriginalFilename(); // 获取文件名并在前面加上一个时间戳
					dest = new File(new File(basepath).getParentFile(), path);

					// 将图片从本地保持到服务器
					fl.transferTo(dest);
					System.out.println("path="+path);
					picStr += "../" + path + ",";
				}
				
				if(!"".equals(picStr)) {
					picStr = picStr.substring(0, picStr.lastIndexOf(","));
				}
				gf.setPics(picStr);
				
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		int result = goodsInfoService.add(gf);
		if(result >0) {
			return new ResultVO(ResultEnum.SUCCESS);
		}
		return new ResultVO(ResultEnum.ERROR);
		
	}

}
