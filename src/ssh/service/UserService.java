package ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh.utils.PageBean;
import ssh.vo.User;

@Transactional
public interface UserService {
	/** 按用户名查询用户的方法 */
	public User findByUsername(String username);

	public void save(User user);

	/** 根据用户名、密码、状态 查询用户是否是存在并且已经激活 返回用户对象 */
	public User login(User user);

	// 查询所有顾客信息
	public List<User> findall();

	// 分页查询
	public PageBean<User> findByPage(Integer page);

	// 删除顾客信息
	public void delete(int uid);

	// 根据顾客id查找顾客信息
	public User findbyId(int uid);

	// 修改用户信息
	public void update(User user);

	// 关键字分页查询
	public PageBean<User> KfindByPage(Integer page, String key, String value);
}
