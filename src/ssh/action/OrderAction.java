package ssh.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.OrderService;
import ssh.utils.PageBean;
import ssh.utils.RandomIdUtils;
import ssh.utils.UUIDUtils;
import ssh.vo.Cart;
import ssh.vo.CartItem;
import ssh.vo.Order;
import ssh.vo.OrderItem;
import ssh.vo.User;

/**
 * 订单Action类
 */
public class OrderAction extends ActionSupport implements ModelDriven<Order> {
	// 模型驱动使用的对象
	private Order order = new Order();
	public Order getModel() {
		return order;
	}
	
	//分页查询的页数
	private Integer page;
	public void setPage(Integer page) {
		this.page = page;
	}
	
	// 注入OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	
	
	/**生成订单
	 * 
	 * */
	public String save() {
		// 设置订单关联的客户 从session中获取登录的用户对象:
		User existUser = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		if (existUser == null) {
			this.addActionError("亲!您还没有登录!");
			return "login";
		}
		order.setUser(existUser);
		// 订单数据补全
		//String uuidStr = UUIDUtils.getUUID();
		String timeIdStr = RandomIdUtils.getRandomId();
		order.setOid(timeIdStr);
		//设置订单创建时间为当前系统时间
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		order.setOrdertime(df.format(new Date()));
		
		//order.setOrderPayTime("2018-05-03");
		order.setState(1); // 1:未付款 2:订单已经付款 3:已经发货 4:订单结束
		// 设置订单的总金额:订单的总金额应该是购物车中总金额: 从session总获得购物车信息.
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		if (cart == null) {
			this.addActionMessage("亲!您还没有购物!");
			return "msg";
		}
		order.setTotal(cart.getTotal());
		// 设置订单项集合:
		for (CartItem cartItem : cart.getCartItems()) {
			// 订单项的信息从购物项获得的.
			OrderItem orderItem = new OrderItem();
			//uuidStr = UUIDUtils.getUUID();
			timeIdStr = RandomIdUtils.getRandomId();
			orderItem.setOiid(timeIdStr);
			orderItem.setCount(cartItem.getCount()); // 数量
			orderItem.setSubtotal(cartItem.getSubtotal()); // 消极
			orderItem.setProduct(cartItem.getProduct()); // 产品信息 对象
			orderItem.setOrder(order);
			order.getOrderItems().add(orderItem);
		}
		orderService.save(order);
		System.out.println("保存订单信息成功");
		// 清空购物车:
		cart.clearCart();

		// 页面需要回显订单信息:
		// 使用模型驱动了 所有可以不使用值栈保存了
		// ActionContext.getContext().getValueStack().set("order", order);
		return "saveSuccess";
	}
	
	/**根据订单id查询订单对象 返回订单收货地址填写页面*/
	public String findOrderByOid(){
		 //Order preOrder = orderService.findOrderByOid(order.getOid());
		// preOrder.setState(order.getState());
		order = orderService.findOrderByOid(order.getOid());
		return "findOrderByOidSuccess";
	}
	
	//根据用户uid查找订单
	public String findOrderByUid() {
		//获得登录的user对象
		User user = (User) ServletActionContext.getRequest().getSession().getAttribute("existUser");
		PageBean<Order> pageBean= orderService.findOrderByUid(user.getUid(),page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "findOrderByUid";
	}
	
	public String payOrder() {
		//修改订单中数据
		Order preOrder  = orderService.findOrderByOid(order.getOid());
		preOrder.setAddr(order.getAddr());
		preOrder.setName(order.getName());
		preOrder.setPhone(order.getPhone());
		orderService.update(preOrder);
		System.out.println("填入收货人、收货地址、收货联系人成功");
		//System.out.println(order);
		
		//跳转到支付宝支付
		return "payOrder";
	}
	
	/**更新订单状态*/
	public String updateState() {
		
		Order preOrder  = orderService.findOrderByOid(order.getOid());
		preOrder.setState(order.getState());
		//调用徐胜的Dao层更新方法
		orderService.update(preOrder);
		//返回我的订单页面
		return "updateState";
	}
	
	public String payFinished() {
		System.out.println("payFinished()方法执行");
		//实际开发中  不能以这里的返回结果作为是否付款成功的标准
		return "payFinished";
	}
	
	public String deleteOrder() {
		System.out.println("deleteOrder()方法执行");
		Order deleteOrder  = orderService.findOrderByOid(order.getOid());
		orderService.deleteOrder(deleteOrder);
		return "deleteOrder";
	}
	
	public String orderDetail() {
		System.out.println("orderDetail()方法执行");
		order  = orderService.findOrderByOid(order.getOid());
		System.out.println(order);
		//orderService.orderDetail(deleteOrder);
		return "orderDetail";
	}
	
//	public String alipay() {
//		return "alipayPayCode";
//	}
}
