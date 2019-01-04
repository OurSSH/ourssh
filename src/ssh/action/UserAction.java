package ssh.action;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.UserService;
import ssh.vo.User;
/**
 * action：用户模块
 * */
public class UserAction extends ActionSupport  implements ModelDriven<User>{
	//模型驱动使用的对象
	private User user = new User();
	@Override
	public User getModel() {
		return user;
	}
	//属性驱动  注册表单中的验证码
	private String checkcode;
	public void setCheckcode(String checkcode) {
		this.checkcode = checkcode;
	}
	//注入UserService
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**跳转到注册页面的执行方法*/
	public String registPage() {
		System.out.println("跳转到注册页面的执行方法");
		return "registPage";
	}
	
	/**ajax进行异步检验用户名的执行方法
	 * 因为用ajax 无需用页面跳转
	 * @throws IOException 
	 * */
	public void findByName() throws IOException {
		System.out.println("ajax进行异步检验用户名的执行方法");
		//调用UserService查询
		User existUser = userService.findByUsername(user.getUsername());
		//获得response对象，向页面输出
		HttpServletResponse response = ServletActionContext.getResponse();
		response.setContentType("text/html;charset=UTF-8");  //因为要输出中文
		if(existUser!=null) {
			//查询到该用户  用户名已经存在
			response.getWriter().println("<font color='red'>用户名已经存在</font>");
		}else {
			//查询不到该用户  用户名可以使用
			response.getWriter().println("<font color='green'>用户名可以使用</font>");
		}
		
	}
	
	/**用户注册方法*/
	public String regist() {
		//判断验证码是否输入正确
		String checkcode1 = (String) ServletActionContext.getRequest().getSession().getAttribute("checkcode");
		if(!checkcode1.equalsIgnoreCase(checkcode)) {
			this.addActionError("验证码输入错误");
			return "checkcodeFail";
		}
		userService.save(user);
		//调用UserService查询
		User existUser = userService.findByUsername(user.getUsername());
		if(existUser!=null) {
			this.addActionMessage("注册成功，5秒后自动跳转到登录界面");
			return "registToLogin";
		}else {
			this.addActionMessage("注册失败，5秒后自动跳转到注册界面");
			return "registToRegist";
		}
		
	}
	
	/**跳转到用户登录页面*/
	public String loginPage() {
		return "loginPage";
	}
	
	/**用户登录  执行方法*/
	public String login() {
		//根据用户名、密码、状态 查询
		User existUser = userService.login(user);
		if(existUser!=null) {
			//存入session
			ServletActionContext.getRequest().getSession().setAttribute("existUser", existUser);
			return "loginSuccess";
		}else {
			this.addActionError("登录失败：用户名或密码错误");
			return LOGIN;
		}
	}
	
	/**退出当前用户*/
	public String logout() {
		//销毁session
		ServletActionContext.getRequest().getSession().invalidate();
		return "logout";
	}
	
	/**前台： 跳转到用户个人信息页面*/
	public String info() {
		return "info";
	}

	
}
