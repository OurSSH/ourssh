package ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ssh.utils.PageHibernateCallback;
import ssh.vo.User;

/**
 * 用户模块 持久层 需要在spring配置文件中 给该bean配置 sessionFactory 才能使用Hibernate模版
 */
public class UserDaoImpl extends HibernateDaoSupport implements UserDao {
	/** 按名称查询是否有该用户 */
	public User findByUsername(String username) {
		String hql = "from User where username= ?0";
		// String hql="from User where username = ?0";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, username);
		if (list != null && list.size() > 0) {
			User u = new User();
			u = list.get(0);
			System.out.println(u);
			return list.get(0);
		}
		return null;
	}

	@Override
	public void save(User user) {
		this.getHibernateTemplate().save(user);
	}

	@Override
	public User login(User user) {
		String hql = "from User where username= ?0 and password=?1 and state=?2";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql, user.getUsername(), user.getPassword(), 1);
		if (list != null && list.size() > 0) {
			User u = new User();
			u = list.get(0);
			return list.get(0);
		}
		return null;
	}

	// 查询所有用户信息的实现
	@Override
	public List<User> findall() {
		// TODO Auto-generated method stub
		String hql = "from User";
		List<User> list = (List<User>) this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	// 查询顾客表中的顾客数量方法的实现
	@Override
	public int findCount() {
		String hql = "select count(*) from User";
		// 查询用户个数
		int total = ((Number) this.getHibernateTemplate().find(hql).listIterator().next()).intValue();
		if (total > 0) {
			return total;
		}
		return 0;
	}

	// 分页查询方法的实现
	@Override
	public List<User> findBypage(int begin, int limit) {
		String hql = "from User order by uid desc";
		List<User> list = this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}

	// 查询方法的实现
	@Override
	public void delete(int uid) {
		// 根据id获取对象
		User user = (User) this.getHibernateTemplate().get(User.class, uid);
		// 删除对象
		this.getHibernateTemplate().delete(user);
	}

	// 根据id查询方法的实现
	@Override
	public User findbyId(int uid) {
		User user = (User) this.getHibernateTemplate().get(User.class, uid);
		return user;
	}

	// 修改用户信息的实现方法
	@Override
	public void update(User user) {
		this.getHibernateTemplate().update(user);
	}

	// 关键字查询记录数的实现
	@Override
	public int findKeyCount(String key, String value) {
		String hql = "select count(*) from User where " + key + " like '%" + value + "%'";
		// 查询用户个数
		int total = ((Number) this.getHibernateTemplate().find(hql).listIterator().next()).intValue();
		if (total > 0) {
			return total;
		}
		return 0;
	}

	// 分页关键字查询方法的实现
	@Override
	public List<User> KfindBypage(int begin, int limit, String key, String value) {
		String hql = "from User where " + key + " like '%" + value + "%' order by uid desc";
		List<User> list = this.getHibernateTemplate().execute(new PageHibernateCallback<User>(hql, null, begin, limit));
		return list;
	}
}
