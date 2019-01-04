package ssh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.OrderService;
import ssh.utils.PageBean;
import ssh.vo.Order;
import ssh.vo.OrderItem;

public class Is_ad_AdminOrderAction extends ActionSupport implements ModelDriven<Order> {

	private static final long serialVersionUID = 1L;
	private Integer page;
	//关键字查询使用的key和value
	private String key;
	private String value;
	// 模型驱动使用对象
	private Order order=new Order();

	@Override
	public Order getModel() {
		// TODO Auto-generated method stub
		return order;
	}

	// 注入订单Service
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	//分页总订单查询
	public String findallOrder()
	{
//		System.out.println("hahahhahahahahhaahhahahahahaaaaaaaaaaaaaaa"+page);
		PageBean<Order> pageBean=orderService.findAll(page);
		ActionContext.getContext().getValueStack().set("pageBean",pageBean);
		return "list";
	}
	//修改订单状态
	public String updateState() {
		//System.out.println("我的订单编号是"+order.getOid());
		order=orderService.findbyId(order.getOid());
		//System.out.println("订单信息"+order.getAddr()+order.getState()+order.getName());
		int a=3;
		order.setState(a);
	//	System.out.println("修改后的订单状态"+order.getState());
		orderService.update(order);
		if(key!=null&&value!=null)
		{
			//System.out.println("你好啊");
			//System.out.println("jdshdsfahjadfshfdhasjkhjkdfsajkhfdsa");
			return "KSuccess";
		}
		//System.out.println("关键字插叙发士大夫撒旦发生发生法撒旦发");
		return "Success";
	}
	//跳转到快递单号填写
	public String addExpressnumber()
	{
		order=orderService.findbyId(order.getOid());
		//将当前页数保存入值栈
		ActionContext.getContext().getValueStack().set("page", page);
		ActionContext.getContext().getValueStack().set("order", order);
		ActionContext.getContext().getValueStack().set("key", key);
		ActionContext.getContext().getValueStack().set("value", value);
		return "add";
	}
	//修改（填写）快递单号
	public String updateExpressnumber()
	{
		//用number存储快递单号
		String number=order.getExpressnumber();
		//根据id查询订单信息
		order=orderService.findbyId(order.getOid());
		//将快递单号设入订单信息
		order.setExpressnumber(number);
		//修改订单信息
		orderService.update(order);
		if(key.equals("")&&value.equals(""))
		{
			
			//System.out.println("你好啊");
			return "Success";
		}
		
		return "KSuccess";
	}
	//关键字查询
	public String KeySearch()
	{
		PageBean<Order> pageBean=orderService.KeySearck(page, key, value);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//System.out.println("哈哈哈哈哈哈哈哈哈哈"+a);
		return "keylist";
	}
	//根据订单编号查询订单项信息
	public String findOrderItem() {
		List<OrderItem> list=orderService.findOrderItem(order.getOid());
		ActionContext.getContext().getValueStack().set("list", list);
		return "orderItem";
	}
	//根据订单id删除订单信息
	public String delete() {
		Order preorder=orderService.findbyId(order.getOid());
		orderService.deleteOrder(preorder);
		if(key!=null&&value!=null)
		{
			//System.out.println("你好啊");
			//System.out.println("jdshdsfahjadfshfdhasjkhjkdfsajkhfdsa");
			return "KSuccess";
		}
		//System.out.println("关键字插叙发士大夫撒旦发生发生法撒旦发");
		return "Success";
	}

}
