package com.zky.snack.product.dto;

/**
 * 商品信息传输对象
 * 
 * @author 张孔洋
 * @data Oct 3, 2020
 */
public class ProductInfoDTO {

	private Integer tno;
	private String gno; // 商品编号
	private Integer num; // 购买数量
	private double price; // 购买单价
	private String gname; // 商品名称
	private String pic; // 商品图片
	private String weight; // 净重
	private String unit; // 单位
	private String intro; // 简介
	private Integer status;
	private Integer balance;
	private String qperied;

	@Override
	public String toString() {
		return "ProductInfoDTO [tno=" + tno + ", gno=" + gno + ", num=" + num + ", price=" + price + ", gname=" + gname
				+ ", pic=" + pic + ", weight=" + weight + ", unit=" + unit + ", intro=" + intro + ", status=" + status
				+ ", balance=" + balance + ", qperied=" + qperied + "]";
	}

	public Integer getTno() {
		return tno;
	}

	public void setTno(Integer tno) {
		this.tno = tno;
	}

	public String getGno() {
		return gno;
	}

	public void setGno(String gno) {
		this.gno = gno;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	public String getQperied() {
		return qperied;
	}

	public void setQperied(String qperied) {
		this.qperied = qperied;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((gname == null) ? 0 : gname.hashCode());
		result = prime * result + ((gno == null) ? 0 : gno.hashCode());
		result = prime * result + ((intro == null) ? 0 : intro.hashCode());
		result = prime * result + ((num == null) ? 0 : num.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		long temp;
		temp = Double.doubleToLongBits(price);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((qperied == null) ? 0 : qperied.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((tno == null) ? 0 : tno.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
		result = prime * result + ((weight == null) ? 0 : weight.hashCode());
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
		ProductInfoDTO other = (ProductInfoDTO) obj;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (gname == null) {
			if (other.gname != null)
				return false;
		} else if (!gname.equals(other.gname))
			return false;
		if (gno == null) {
			if (other.gno != null)
				return false;
		} else if (!gno.equals(other.gno))
			return false;
		if (intro == null) {
			if (other.intro != null)
				return false;
		} else if (!intro.equals(other.intro))
			return false;
		if (num == null) {
			if (other.num != null)
				return false;
		} else if (!num.equals(other.num))
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
			return false;
		if (qperied == null) {
			if (other.qperied != null)
				return false;
		} else if (!qperied.equals(other.qperied))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (tno == null) {
			if (other.tno != null)
				return false;
		} else if (!tno.equals(other.tno))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		if (weight == null) {
			if (other.weight != null)
				return false;
		} else if (!weight.equals(other.weight))
			return false;
		return true;
	}

	public ProductInfoDTO(Integer tno, String gno, Integer num, double price, String gname, String pic, String weight,
			String unit, String intro, Integer status, Integer balance, String qperied) {
		super();
		this.tno = tno;
		this.gno = gno;
		this.num = num;
		this.price = price;
		this.gname = gname;
		this.pic = pic;
		this.weight = weight;
		this.unit = unit;
		this.intro = intro;
		this.status = status;
		this.balance = balance;
		this.qperied = qperied;
	}

	public ProductInfoDTO() {
		super();
	}

}
