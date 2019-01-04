package ssh.dao;

import java.util.List;

import ssh.vo.Order;
import ssh.vo.OrderItem;

public interface OrderDao {

	public void save(Order order);
	/**Dao层 我的订单个数查询*/
	public Integer findCountByUid(Integer uid);
	/**Dao层 我的订单分页查询*/
	public List<Order> findOrderListByPageUid(Integer uid, Integer begin, Integer limit);
	/**Dao层 根据订单id查到订单*/
	public Order findOrderByOid(String oid);
	
	public void update(Order preOrder);
	/**Dao层 删除订单信息*/
	public void deleteOrder(Order deleteOrder);

	// 查询订单总数
	public int findCount();

	// 订单分页查询所有
	public List<Order> findByPage(int begin, int limit);

	// 根据id查询订单信息
	public Order findByOid(String oid);
	
	//根据oid查询订单项信息
	public List<OrderItem> findOrderItem(String oid);

	// 条件查询记录数（关键字）
	public int findKeyCount(String key, String value);

	 //分页关键字查询
	public List<Order> KeySearch(int begin, int limit, String key, String value);
	

}
