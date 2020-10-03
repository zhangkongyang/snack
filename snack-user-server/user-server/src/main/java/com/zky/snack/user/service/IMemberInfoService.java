package com.zky.snack.user.service;

import com.zky.snack.user.bean.MemberInfo;

public interface IMemberInfoService {
	public MemberInfo login(MemberInfo mf);
	
	public int reg(MemberInfo mf);
}
