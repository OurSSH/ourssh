package ssh.action;
/**
 * 后台管理人员action
 */
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.Is_ad_AdminUserService;
import ssh.vo.Is_ad_AdminUser;
import ssh.vo.User;

public class Is_ad_AdminUserAction  extends ActionSupport  implements ModelDriven<Is_ad_AdminUser>{

	private static final long serialVersionUID = 1L;
	//模型驱动使用的对象
	private Is_ad_AdminUser is_ad_AdminUser=new Is_ad_AdminUser();
	@Override
	public Is_ad_AdminUser getModel() {
		// TODO Auto-generated method stub
		return is_ad_AdminUser;
	}
	
	//注入Is_ad_AdminUserService
	private Is_ad_AdminUserService is_ad_AdminUserService;
	public void setIs_ad_AdminUserService(Is_ad_AdminUserService is_ad_AdminUserService) {
		this.is_ad_AdminUserService = is_ad_AdminUserService;
	}
	//登录校验
	public String login_AdminUser() {
		//根据用户名、密码 查询
		Is_ad_AdminUser existAdmin=is_ad_AdminUserService.adminUserlogin(is_ad_AdminUser);
		if(existAdmin!=null) {
			//存入session
			ServletActionContext.getRequest().getSession().setAttribute("existAdmin",existAdmin);
			return "home";
		}else {
			this.addActionError("登录失败：用户名或密码错误");
			return "index";
		}
	}
	//退出登录
	public String logout_AdminUser() {
//		Map session = ActionContext.getContext().getSession();
//		ServletActionContext.getRequest().getSession().remove("logged-in");
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "index";

	}

}
