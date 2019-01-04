package ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ssh.vo.Is_ad_AdminUser;
import ssh.vo.User;


public class Is_ad_AdminUserDaoImpl extends HibernateDaoSupport implements Is_ad_AdminUserDao{

	@Override
	public Is_ad_AdminUser adminUserlogin(Is_ad_AdminUser is_ad_AdminUser) {
		String hql = "from Is_ad_AdminUser where username= ?0 and password=?1 ";
		List<Is_ad_AdminUser> list = (List<Is_ad_AdminUser>)this.getHibernateTemplate().find(hql,is_ad_AdminUser.getUsername(),is_ad_AdminUser.getPassword());
		if(list!=null && list.size()>0) {
			Is_ad_AdminUser ia=new Is_ad_AdminUser();
			ia=list.get(0);
			System.out.println("**********查找到数据库中的该用户名的用户*******");
			System.out.println(ia);
			return list.get(0);
		}
		System.out.println("**********查找不到数据库中的该用户名的用户*******");
		return null;
	}

}
