package ssh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ssh.service.ProductService;
import ssh.vo.Cart;
import ssh.vo.CartItem;
import ssh.vo.Product;

/**
 * 购物车Action
 */
public class CartAction extends ActionSupport {
	// 注入productService
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 接收pid
	// private Integer pid;
	// 接收商品购买数量count
	// private Integer count;
	// public void setPid(Integer pid) {
	// this.pid = pid;
	// }
	// public void setCount(Integer count) {
	// this.count = count;
	// }

	// 将购物项添加到购物车
	public String addCart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 勾选了的产品 的pid数组
		String[] pids = request.getParameterValues("pid");
		if (pids != null) {
			Cart cart = getCart();
			for (int i = 0; i < pids.length; i++) {
				// 获取该pid产品对应的购买数量
				int countByPid = Integer.valueOf(request.getParameter(pids[i]));
				CartItem cartItem = new CartItem();
				cartItem.setCount(countByPid);
				int pid = Integer.parseInt(pids[i]);
				// 根据商品pid查询商品对象
				Product product = productService.findByPid(pid);
				cartItem.setProduct(product);
				System.out.print(product);
				System.out.println(pid + "的购买数量是：" + countByPid);

				// 将购物项加入购物车
				cart.addCart(cartItem);
			}
		}
		return "addCart";
	}

	// 将购物项添加到购物车
	public Cart getCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		// 第一次获取是没有该对象的
		if (cart == null) {
			cart = new Cart();
			ServletActionContext.getRequest().getSession().setAttribute("cart", cart);
		}
		return cart;
	}

	// 清空购物车
	public String clearCart() {
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		cart.clearCart();
		return "clearCart";
	}

	// 移除购物车项
	public String removeCart() {
		HttpServletRequest request = ServletActionContext.getRequest();
		// 准备移除的购物车项的产品id
		int pid = Integer.parseInt(request.getParameter("pid"));
		Cart cart = (Cart) ServletActionContext.getRequest().getSession().getAttribute("cart");
		cart.removeCart(pid);
		return "removeCart";
	}

	public String myCart() {
		return "myCart";
	}
}
