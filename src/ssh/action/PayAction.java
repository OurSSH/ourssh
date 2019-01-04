package ssh.action;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.config.AlipayConfig;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.OrderService;
import ssh.service.ProductService;
import ssh.vo.Order;
import ssh.vo.OrderItem;
import ssh.vo.Product;

/*
 * 支付 Action
 * **/
public class PayAction extends ActionSupport implements ModelDriven<Order> {
	// 模型驱动使用的对象
	private Order order = new Order();

	public Order getModel() {
		return order;
	}

	// 注入OrderService
	private OrderService orderService;

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	// 注入OrderService
	private ProductService productService;
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public String paySuccessReturn() throws AlipayApiException, UnsupportedEncodingException {
		System.out.println("执行paySuccessReturn()  获取支付宝返回信息");
		HttpServletRequest request = ServletActionContext.getRequest();
		// 获取支付宝GET过来反馈信息
		Map<String, String> params = new HashMap<String, String>();
		Map<String, String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i] : valueStr + values[i] + ",";
			}
			// 乱码解决，这段代码在出现乱码时使用
			// valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}

		boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset,
				AlipayConfig.sign_type); // 调用SDK验证签名
		if (signVerified) {
			// 商户订单号
			String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"), "UTF-8");
			// 支付宝交易号
			String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"), "UTF-8");
			// 付款金额
			String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"), "UTF-8");
			System.out.println("商户订单号:" + out_trade_no);
			System.out.println("支付宝交易号:" + trade_no);
			System.out.println("付款金额:" + total_amount);
			
			//改变订单状态
			Order preOrder = orderService.findOrderByOid(out_trade_no);
			preOrder.setState(2);
			preOrder.setAlipaycode(trade_no);
			preOrder.setRealpaytotal(Double.parseDouble(total_amount));
			//设置订单付款时间为当前系统时间
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			preOrder.setOrderPayTime(df.format(new Date()));
			for(OrderItem oi:preOrder.getOrderItems()) {
				Product product = oi.getProduct();
				product.setPstock(oi.getProduct().getPstock()-oi.getCount());
				productService.update(product);
			 }
			orderService.update(preOrder);

		} else {
			System.out.println("验签失败");
			// out.println("验签失败");
		}
		return "paySuccessReturn";
	}
}
