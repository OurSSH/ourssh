package ssh.vo;

public class Product {
	private int pid;
	private String pname;
	private String pdesc;
	private Double pprice;
	private int pstock;
	private String pimg;
	//外键
	private Version version;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getPdesc() {
		return pdesc;
	}
	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}
	public Double getPprice() {
		return pprice;
	}
	public void setPprice(Double pprice) {
		this.pprice = pprice;
	}
	public int getPstock() {
		return pstock;
	}
	public void setPstock(int pstock) {
		this.pstock = pstock;
	}
	public String getPimg() {
		return pimg;
	}
	public void setPimg(String pimg) {
		this.pimg = pimg;
	}
	public Version getVersion() {
		return version;
	}
	public void setVersion(Version version) {
		this.version = version;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", pdesc=" + pdesc + ", pprice=" + pprice + ", pstock="
				+ pstock + ", pimg=" + pimg + "]";
	}
	
	
	
	
	
	
}
