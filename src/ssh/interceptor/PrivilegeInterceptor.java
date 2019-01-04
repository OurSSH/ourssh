package ssh.interceptor;

import org.apache.struts2.ServletActionContext;



import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

import ssh.vo.Is_ad_AdminUser;

/**
 * 权限拦截器:
 *
 */
public class PrivilegeInterceptor extends MethodFilterInterceptor{

	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
		// 判断是否登录,如果登录,放行,没有登录,跳转到登录页面.
		Is_ad_AdminUser adminUser = (Is_ad_AdminUser) ServletActionContext.getRequest()
				.getSession().getAttribute("existAdmin");
		if(adminUser != null){
			// 已经登录过
			return actionInvocation.invoke();
		}else{
			// 跳转到登录页面:
			ActionSupport support = (ActionSupport) actionInvocation.getAction();
			support.addActionError("您还没有登录!没有权限访问!");
			return "adminLogin";
		}
	}

}