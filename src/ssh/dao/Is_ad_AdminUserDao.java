package ssh.dao;

import ssh.vo.Is_ad_AdminUser;

public interface Is_ad_AdminUserDao {
	//后台管理人员登录验证
	public Is_ad_AdminUser adminUserlogin(Is_ad_AdminUser is_ad_AdminUser);
}
