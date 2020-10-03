package com.zky.snack.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zky.snack.user.bean.MemberInfo;
import com.zky.snack.user.mapper.IMemberInfoMapper;
import com.zky.snack.user.service.IMemberInfoService;
import com.zky.snack.user.util.StringUtil;

@Service
public class MemberInfoServiceImpl implements IMemberInfoService {
	@Autowired
	private IMemberInfoMapper MemberInfoMapper;
    
	
	public MemberInfo login(MemberInfo mf) {
		if (StringUtil.checkNull(mf.getNickName(), mf.getPwd())) {
			return null;
		}
		return MemberInfoMapper.login(mf);
	}

	public int reg(MemberInfo mf) {
		if (StringUtil.checkNull(mf.getNickName(), mf.getEmail())) {
			return -1;
		}
		return MemberInfoMapper.reg(mf);
	}

}
