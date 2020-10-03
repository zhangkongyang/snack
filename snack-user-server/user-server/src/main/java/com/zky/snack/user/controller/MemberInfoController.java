package com.zky.snack.user.controller;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zky.snack.user.bean.MemberInfo;
import com.zky.snack.user.dto.SessionFeysConstant;
import com.zky.snack.user.enums.ResultEnum;
import com.zky.snack.user.service.IMemberInfoService;
import com.zky.snack.user.util.SendMailUtil;
import com.zky.snack.user.vo.ResultVO;

@RestController
@RequestMapping("/member")
public class MemberInfoController {
	
	@Autowired
	private IMemberInfoService memberInfoService;
	
	@Autowired
	private SendMailUtil sendMailUtil;
	
	
	@PostMapping("login")
	public ResultVO login(MemberInfo mf, HttpSession session) {
		String vcode = String.valueOf(session.getAttribute("vcode"));
		if(!vcode.equalsIgnoreCase(mf.getRealName())) {
			return new ResultVO(ResultEnum.CODE_ERROR);
		}
		
		MemberInfo memberInfo = memberInfoService.login(mf);
		if(memberInfo==null) {
			return new ResultVO(ResultEnum.LOGIN_ERROR);
		}
		
		session.setAttribute(SessionFeysConstant.CURRENTMEMBERACCOUNT, memberInfo);
		return new ResultVO(ResultEnum.LOGIN_SUCCESS);
	}
	
	@PostMapping("reg")
	public ResultVO reg(MemberInfo mf) {
		int result = memberInfoService.reg(mf);
		if(result>0) {
			return new ResultVO(ResultEnum.REG_SUCCESS);
		}
		return new ResultVO(ResultEnum.REG_ERROR);

	}
	
	@GetMapping("/info")
	public ResultVO check(HttpSession session) {
		Object obj = session.getAttribute(SessionFeysConstant.CURRENTMEMBERACCOUNT);
		if(obj==null) {
			return new ResultVO(ResultEnum.ERROR);
		}
		return new ResultVO(ResultEnum.SUCCESS,obj);
	}
	
	@PostMapping("/code")
	public ResultVO sendCode(String receive,String nickName,final HttpSession session) {
		String code="";
		Random rd = new Random();
		while(code.length() <6) {
			code+=rd.nextInt(10);
		}
		
		if(sendMailUtil.sendHtmlMail(receive, nickName, code)) { //说明发送成功
			session.setAttribute("code", code);
			
			TimerTask task = new TimerTask() { //创建一个定时器任务
				
				@Override
				public void run() {
					session.removeAttribute("code");
				}
			};
			
			Timer timer = new Timer(); //创建一个定时任务
			timer.schedule(task, 180000); //三分之执行这个任务一次
			return new ResultVO(ResultEnum.SUCCESS);
		}
		return new ResultVO(ResultEnum.ERROR);

		
	}
	
	

}
