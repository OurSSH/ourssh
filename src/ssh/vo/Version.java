package ssh.vo;

import java.util.HashSet;
import java.util.Set;

public class Version {
	private int vid;
	private String vname;
	private String vdesc;
	private Double vprice;
	private Integer vstate;
	//引入外键
	private Brand brand;    //型号所属品牌
	//引入集合外键
	//品牌所有型号的对象集合
	private Set<Product> products = new HashSet<Product>(); 
	
	
	private String vimg;
	private int is_hot;
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public String getVdesc() {
		return vdesc;
	}
	public void setVdesc(String vdesc) {
		this.vdesc = vdesc;
	}
	public Double getVprice() {
		return vprice;
	}
	public void setVprice(Double vprice) {
		this.vprice = vprice;
	}
	public String getVimg() {
		return vimg;
	}
	public void setVimg(String vimg) {
		this.vimg = vimg;
	}
	public int getIs_hot() {
		return is_hot;
	}
	public void setIs_hot(int is_hot) {
		this.is_hot = is_hot;
	}
	public Brand getBrand() {
		return brand;
	}
	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	
	
	public Integer getVstate() {
		return vstate;
	}
	public void setVstate(Integer vstate) {
		this.vstate = vstate;
	}
	public Set<Product> getProducts() {
		return products;
	}
	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	public Version() {
		super();
	}
	@Override
	public String toString() {
		return "Version [vid=" + vid + ", vname=" + vname + ", vdesc=" + vdesc + ", vprice=" + vprice + ", vstate="
				+ vstate + ", vimg=" + vimg + ", is_hot=" + is_hot + "]";
	}
	
	
}
