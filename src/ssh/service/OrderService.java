package ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh.utils.PageBean;
import ssh.vo.Order;
import ssh.vo.OrderItem;

@Transactional
public interface OrderService {

	public void save(Order order);

	public PageBean<Order> findOrderByUid(Integer uid, Integer page);

	public Order findOrderByOid(String oid);

	public void update(Order preOrder);

	public void deleteOrder(Order deleteOrder);

	// 分页查询所有订单信息
	public PageBean<Order> findAll(Integer page);

	// 修改订单信息
	// public void update(Order order);
	// 根据oid查询订单信息
	public Order findbyId(String oid);

	// 关键字查询订单数量
	public int findKeyCount(String key, String value);

	// 根据订单编号查询订单项
	public List<OrderItem> findOrderItem(String oid);

	// 关键字分页查询订单信息
	public PageBean<Order> KeySearck(Integer page, String key, String value);

}
