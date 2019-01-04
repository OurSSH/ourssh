package ssh.dao;

import java.util.List;

import ssh.vo.User;

/**
 * 用户模块 持久层
 */
public interface UserDao {
	/** 按名称查询是否有该用户 */
	public User findByUsername(String username);

	/** 数据库保存注册用户 */
	public void save(User user);

	public User login(User user);

	// 查询所有用户信息
	public List<User> findall();

	// 查询顾客表中顾客个数
	public int findCount();

	// 分页查询
	public List<User> findBypage(int begin, int limit);

	// 删除方法
	public void delete(int uid);

	// 根据顾客id查找用户信息
	public User findbyId(int uid);

	// 修改用户信息
	public void update(User user);

	// 条件查询记录数（关键字）
	public int findKeyCount(String key, String value);

	// 分页关键字查询
	public List<User> KfindBypage(int begin, int limit, String key, String value);
}
