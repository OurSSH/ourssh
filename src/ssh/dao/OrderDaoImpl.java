package ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ssh.utils.PageHibernateCallback;
import ssh.vo.Order;
import ssh.vo.OrderItem;

public class OrderDaoImpl extends HibernateDaoSupport implements OrderDao {

	@Override
	// Dao层的保存订单额操作
	public void save(Order order) {
		this.getHibernateTemplate().save(order);
	}

	@Override
	public Integer findCountByUid(Integer uid) {
		String hql = "select count(*) from Order o where o.user.uid = ?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql, uid);
		if (list != null && list.size() > 0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Order> findOrderListByPageUid(Integer uid, Integer begin, Integer limit) {
		//String hql = "from Order o where o.user.uid = ?0";
		String hql = "from Order o where o.user.uid = ?0 order by o.ordertime desc";
		List<Order> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<Order>(hql, new Object[] { uid }, begin, limit));
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	/** DAO层根据订单id查询订单 */
	public Order findOrderByOid(String oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	@Override
	/** DAO层修改订单的方法: */
	public void update(Order preOrder) {
		this.getHibernateTemplate().update(preOrder);
	}

	@Override
	public void deleteOrder(Order deleteOrder) {
		this.getHibernateTemplate().delete(deleteOrder);
	}

	// 查询订单总数的方法实现
	@Override
	// DAO中统计订单个数的方法
	public int findCount() {
		String hql = "select count(*) from Order";
		int total = ((Number) this.getHibernateTemplate().find(hql).listIterator().next()).intValue();
		if (total > 0) {
			// System.out.println("订单个数"+total);
			return total;
		}
		System.out.println("目前没有订单信息！");
		return 0;
	}

	// DAO中分页查询订单的方法
	public List<Order> findByPage(int begin, int limit) {
		String hql = "from Order order by ordertime asc";
		List<Order> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		return list;
	}

	// DAO层根据订单id查询订单
	public Order findByOid(String oid) {
		return this.getHibernateTemplate().get(Order.class, oid);
	}

	// DAO层修改订单的方法:
//	public void update(Order order) {
//		this.getHibernateTemplate().update(order);
//	}

	// Dao层根据订单编号查询订单项
	@Override
	public List<OrderItem> findOrderItem(String oid) {
		// TODO Auto-generated method stub
		String hql = "from OrderItem oi where oi.order.oid = '" + oid + "'";
		List<OrderItem> list = (List<OrderItem>) this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// 关键字查询记录数的实现
	// @Override
	public int findKeyCount(String key, String value) {
		// TODO Auto-generated method stub
		// 如果查询的是用户id 或是订单状态，将String 类型转化为int 类型
		int total;
		String hql = "select count(*) from Order where " + key + " like '%" + value + "%'";
		// 查询用户个数
		total = ((Number) this.getHibernateTemplate().find(hql).listIterator().next()).intValue();
		if (total > 0) {
			System.out.println("关键字查询顾客数量：" + total);
			return total;
		}
		System.out.println("关键字查询没能查询到信息！");
		return 0;
	}

	// 关键字查询订单信息
	@Override
	public List<Order> KeySearch(int begin, int limit, String key, String value) {
		// TODO Auto-generated method stub
		String hql = "from Order where " + key + " like '%" + value + "%' order by uid desc";
		List<Order> list = this.getHibernateTemplate()
				.execute(new PageHibernateCallback<Order>(hql, null, begin, limit));
		// System.out.println(list.get(0).getEmail());
		return list;
	}

}
