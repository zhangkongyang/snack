package com.zky.snack.product.dto;

/**
 * 商品类型传输对象
 * 
 * @author 张孔洋
 * @data Oct 3, 2020
 */
public class ProductTypeInfoDTO {
	private String tno;
	private String tname;
	public String getTno() {
		return tno;
	}
	public void setTno(String tno) {
		this.tno = tno;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	@Override
	public String toString() {
		return "ProductTypeInfoDTO [tno=" + tno + ", tname=" + tname + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((tname == null) ? 0 : tname.hashCode());
		result = prime * result + ((tno == null) ? 0 : tno.hashCode());
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
		ProductTypeInfoDTO other = (ProductTypeInfoDTO) obj;
		if (tname == null) {
			if (other.tname != null)
				return false;
		} else if (!tname.equals(other.tname))
			return false;
		if (tno == null) {
			if (other.tno != null)
				return false;
		} else if (!tno.equals(other.tno))
			return false;
		return true;
	}
	public ProductTypeInfoDTO(String tno, String tname) {
		super();
		this.tno = tno;
		this.tname = tname;
	}
	public ProductTypeInfoDTO() {
		super();
	}
	
	

}
