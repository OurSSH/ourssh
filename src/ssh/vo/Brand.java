package ssh.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * 品牌 实体对象
 * */
public class Brand {
	private Integer bid;
	private String bname;
	private Integer bstate;
	//品牌所有型号的对象集合
	private Set<Version> versions = new HashSet<Version>(); 
	
	
	public Integer getBstate() {
		return bstate;
	}
	public void setBstate(Integer bstate) {
		this.bstate = bstate;
	}
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Set<Version> getVersions() {
		return versions;
	}
	public void setVersions(Set<Version> versions) {
		this.versions = versions;
	}
	public Brand() {
		super();
	}
	@Override
	public String toString() {
		return "Brand [bid=" + bid + ", bname=" + bname + ", bstate=" + bstate + "]";
	}
	
	
	
}
