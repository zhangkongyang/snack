package com.zky.snack.user.dto;

import java.io.Serializable;

/**
 * 用户登陆信息传输对象
 * @author 张孔洋
 * @data Oct 3, 2020
 */
public class MemberLoginInfoDATO implements Serializable {
	private static final long serialVersionUID = 6365471785346344743L;
	private Integer mno;
	private String nickName;
	private String tel; 
	private String photo;
	public Integer getMno() {
		return mno;
	}
	public void setMno(Integer mno) {
		this.mno = mno;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	@Override
	public String toString() {
		return "MemberLoginInfoDATO [mno=" + mno + ", nickName=" + nickName + ", tel=" + tel + ", photo=" + photo + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((mno == null) ? 0 : mno.hashCode());
		result = prime * result + ((nickName == null) ? 0 : nickName.hashCode());
		result = prime * result + ((photo == null) ? 0 : photo.hashCode());
		result = prime * result + ((tel == null) ? 0 : tel.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberLoginInfoDATO other = (MemberLoginInfoDATO) obj;
		if (mno == null) {
			if (other.mno != null)
				return false;
		} else if (!mno.equals(other.mno))
			return false;
		if (nickName == null) {
			if (other.nickName != null)
				return false;
		} else if (!nickName.equals(other.nickName))
			return false;
		if (photo == null) {
			if (other.photo != null)
				return false;
		} else if (!photo.equals(other.photo))
			return false;
		if (tel == null) {
			if (other.tel != null)
				return false;
		} else if (!tel.equals(other.tel))
			return false;
		return true;
	}
	public MemberLoginInfoDATO(Integer mno, String nickName, String tel, String photo) {
		super();
		this.mno = mno;
		this.nickName = nickName;
		this.tel = tel;
		this.photo = photo;
	}
	public MemberLoginInfoDATO() {
		super();
	}
	
	
 
}
