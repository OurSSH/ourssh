package ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh.dao.OrderDao;
import ssh.utils.PageBean;
import ssh.vo.Order;
import ssh.vo.OrderItem;

@Transactional
public class OrderServiceImpl implements OrderService {
	// 注入OrderDao
	private OrderDao orderDao;

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public void save(Order order) {
		orderDao.save(order);
	}
	//
	// // 业务层根据用户id查询订单,带分页查询.
	// public PageBean<Order> findByUid(Integer uid,Integer page) {
	// PageBean<Order> pageBean = new PageBean<Order>();
	// // 设置当前页数:
	// pageBean.setPage(page);
	// // 设置每页显示记录数:
	// // 显示5个
	// int limit = 5;
	// pageBean.setLimit(limit);
	// // 设置总记录数:
	// int totalCount = 0;
	// totalCount = orderDao.findCountByUid(uid);
	// pageBean.setTotalCount(totalCount);
	// // 设置总页数
	// int totalPage = 0;
	// if(totalCount % limit == 0){
	// totalPage = totalCount / limit;
	// }else{
	// totalPage = totalCount / limit + 1;
	// }
	// pageBean.setTotalPage(totalPage);
	// // 设置每页显示数据集合:
	// int begin = (page - 1)*limit;
	// List<Order> list = orderDao.findPageByUid(uid,begin,limit);
	// pageBean.setList(list);
	// return pageBean;
	// }
	//
	// // 根据订单id查询订单
	// public Order findByOid(Integer oid) {
	// return orderDao.findByOid(oid);
	// }
	//
	// // 业务层修改订单的方法:
	// public void update(Order currOrder) {
	// orderDao.update(currOrder);
	// }
	//
	// // 业务层查询所有订单方法
	// public PageBean<Order> findAll(Integer page) {
	// PageBean<Order> pageBean = new PageBean<Order>();
	// // 设置参数
	// pageBean.setPage(page);
	// // 设置每页显示的记录数:
	// int limit = 10;
	// pageBean.setLimit(limit);
	// // 设置总记录数
	// int totalCount = orderDao.findCount();
	// pageBean.setTotalCount(totalCount);
	// // 设置总页数
	// int totalPage = 0;
	// if(totalCount % limit == 0){
	// totalPage = totalCount / limit;
	// }else{
	// totalPage = totalCount / limit + 1;
	// }
	// pageBean.setTotalPage(totalPage);
	// // 设置每页显示数据集合
	// int begin = (page - 1) * limit;
	// List<Order> list = orderDao.findByPage(begin,limit);
	// pageBean.setList(list);
	// return pageBean;
	// }
	//
	// // 业务层查询订单项的方法
	// public List<OrderItem> findOrderItem(Integer oid) {
	// return orderDao.findOrderItem(oid);
	// }

	@Override
	/** 业务层 通过用户id分页查找订单列表 */
	public PageBean<Order> findOrderByUid(Integer uid, Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		pageBean.setPage(page);
		Integer limit = 5;
		pageBean.setLimit(limit);
		Integer totalCount = null;
		totalCount = orderDao.findCountByUid(uid);
		pageBean.setTotalCount(totalCount);
		Integer totalPage = null;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = (totalCount / limit) + 1;
		}
		// totalPage = (int) Math.ceil(totalCount/limit); //向上取整
		pageBean.setTotalPage(totalPage);
		Integer begin = (page - 1) * limit;
		List<Order> list = orderDao.findOrderListByPageUid(uid, begin, limit);

		if (list == null) {
			return null;
		}

		pageBean.setList(list);
		return pageBean;
	}

	@Override
	/** 业务层 通过订单id查找订单 */
	public Order findOrderByOid(String oid) {
		return orderDao.findOrderByOid(oid);
	}

	@Override
	/** 业务层 修改订单信息 */
	public void update(Order preOrder) {
		orderDao.update(preOrder);
	}

	@Override
	/** 业务层 删除订单信息 */
	public void deleteOrder(Order deleteOrder) {
		orderDao.deleteOrder(deleteOrder);
	}

	@Override
	// 业务层查询所有订单方法
	public PageBean<Order> findAll(Integer page) {
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置参数
		pageBean.setPage(page);
		// 设置每页显示的记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数
		int totalCount = orderDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置每页显示数据集合
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.findByPage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 业务层根据oid查询订单信息
	@Override
	public Order findbyId(String oid) {
		// TODO Auto-generated method stub
		return orderDao.findByOid(oid);
	}

	// //业务层修改订单信息
	// @Override
	// public void update(Order order) {
	// // TODO Auto-generated method stub
	// orderDao.update(order);
	// }
	// 业务层关键字查询订单数量
	@Override
	public int findKeyCount(String key, String value) {
		// TODO Auto-generated method stub
		return orderDao.findKeyCount(key, value);
	}

	// 业务层查询订单项的方法
	public List<OrderItem> findOrderItem(String oid) {
		return orderDao.findOrderItem(oid);
	}

	// 关键字分页查询订单信息
	@Override
	public PageBean<Order> KeySearck(Integer page, String key, String value) {
		// TODO Auto-generated method stub
		PageBean<Order> pageBean = new PageBean<Order>();
		// 设置参数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 10;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = orderDao.findKeyCount(key, value);
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置页面显示数据的集合:
		int begin = (page - 1) * limit;
		List<Order> list = orderDao.KeySearch(begin, limit, key, value);
		pageBean.setList(list);
		return pageBean;
	}

}
