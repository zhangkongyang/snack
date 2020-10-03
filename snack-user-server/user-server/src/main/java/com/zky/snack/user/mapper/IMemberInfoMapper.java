package com.zky.snack.user.mapper;

import com.zky.snack.user.bean.MemberInfo;

public interface IMemberInfoMapper {
	public MemberInfo login(MemberInfo mf);
	
	public int reg(MemberInfo mf);
}
