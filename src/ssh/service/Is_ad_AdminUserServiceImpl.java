package ssh.service;

import org.springframework.transaction.annotation.Transactional;

import ssh.dao.Is_ad_AdminUserDao;
import ssh.vo.Is_ad_AdminUser;
/**
 * 后台模块 管理人员层
 */

@Transactional
public class Is_ad_AdminUserServiceImpl implements Is_ad_AdminUserService{	
	//注入is_ad_AdminUserDao
	private Is_ad_AdminUserDao is_ad_AdminUserDao;
	
	public void setIs_ad_AdminUserDao(Is_ad_AdminUserDao is_ad_AdminUserDao) {
		this.is_ad_AdminUserDao = is_ad_AdminUserDao;
	}
	//后台管理员登录验证
	@Override
	public Is_ad_AdminUser adminUserlogin(Is_ad_AdminUser is_ad_AdminUser) {
		// TODO Auto-generated method stub
		return is_ad_AdminUserDao.adminUserlogin(is_ad_AdminUser);
	}
	
}
