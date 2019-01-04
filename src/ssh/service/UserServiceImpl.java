package ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh.dao.UserDao;
import ssh.utils.PageBean;
import ssh.utils.UUIDUtils;
import ssh.vo.User;

/**
 * 用户模块 业务层
 * */
@Transactional
public class UserServiceImpl implements UserService{
	//注入UserDao
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	/**按用户名查询用户的方法*/
	public User findByUsername(String username) {
		System.out.println("UserServiceImpl findByUsername");
		return userDao.findByUsername(username);
	}

	@Override
	public void save(User user) {
		//将数据存入到数据库
		user.setState(1);  
		String code = UUIDUtils.getUUID();
		user.setCode(code);
		userDao.save(user);
		
	}

	@Override
	/**根据用户名、密码、状态 查询用户是否存在  返回用户对象*/
	public User login(User user) {
		return userDao.login(user);
	}
	
	//查询所有用户信息
		@Override
		public List<User> findall() {
			// TODO Auto-generated method stub
			return userDao.findall();
		}
		//分页查询

		@Override
		public PageBean<User> findByPage(Integer page) {
			// TODO Auto-generated method stub
			PageBean<User> pageBean=new PageBean<User>();
			// 设置参数:
					pageBean.setPage(page);
					// 设置每页显示记录数:
					int limit = 10;
					pageBean.setLimit(limit);
					// 设置总记录数:
					int totalCount = userDao.findCount();
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
					List<User> list = userDao.findBypage(begin, limit);
					pageBean.setList(list);
					return pageBean;
		}

		@Override
		public void delete(int uid) {
			// TODO Auto-generated method stub
			userDao.delete(uid);
		}

		@Override
		public User findbyId(int uid) {
			// TODO Auto-generated method stub
			return userDao.findbyId(uid);
		}
		//修改用户信息业务层的实现
		@Override
		public void update(User user) {
			// TODO Auto-generated method stub
			 userDao.update(user);
		}
		//关键字查询分页
		@Override
		public PageBean<User> KfindByPage(Integer page, String key, String value) {
			// TODO Auto-generated method stub
			PageBean<User> pageBean=new PageBean<User>();
			// 设置参数:
					pageBean.setPage(page);
					// 设置每页显示记录数:
					int limit = 10;
					pageBean.setLimit(limit);
					// 设置总记录数:
					int totalCount = userDao.findKeyCount(key, value);
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
					List<User> list = userDao.KfindBypage(begin, limit, key, value);
					pageBean.setList(list);
					return pageBean;
		}
}
