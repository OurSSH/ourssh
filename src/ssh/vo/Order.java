package ssh.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * 订单实体
 */
public class Order {
	private String oid;
	private Double total;        //订单总额
	private String ordertime;
	private String orderPayTime;
	private Integer state;     // 1:未付款   2:订单已经付款   3:已经发货   4:订单结束
	private String alipaycode; //支付宝交易订单号
	private String name;
	private String phone;
	private String addr;
	private Double realpaytotal;   //实付总额
	private String expressnumber; 
	private String expresstype;
	
	// 用户的外键:对象
	private User user;
	// 配置订单项的集合
	private Set<OrderItem> orderItems = new HashSet<OrderItem>();
	
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}

	
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public Order() {
		super();
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getOrderPayTime() {
		return orderPayTime;
	}
	public void setOrderPayTime(String orderPayTime) {
		this.orderPayTime = orderPayTime;
	}
	
	public String getAlipaycode() {
		return alipaycode;
	}
	public void setAlipaycode(String alipaycode) {
		this.alipaycode = alipaycode;
	}
	
	public Double getRealpaytotal() {
		return realpaytotal;
	}
	public void setRealpaytotal(Double realpaytotal) {
		this.realpaytotal = realpaytotal;
	}
	
	
	public String getExpressnumber() {
		return expressnumber;
	}
	public void setExpressnumber(String expressnumber) {
		this.expressnumber = expressnumber;
	}
	public String getExpresstype() {
		return expresstype;
	}
	public void setExpresstype(String expresstype) {
		this.expresstype = expresstype;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", orderPayTime=" + orderPayTime
				+ ", state=" + state + ", alipaycode=" + alipaycode + ", name=" + name + ", phone=" + phone + ", addr="
				+ addr + ", realpaytotal=" + realpaytotal + "]";
	}
	
	
}
