package ssh.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
/**
 * 后台顾客管理action
 */
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.UserService;
import ssh.utils.PageBean;
import ssh.vo.User;

public class Is_ad_AdminCustomerAction extends ActionSupport implements ModelDriven<User> {
	private static final long serialVersionUID = 1L;
	// 页数
	private Integer page;
	// 关键字查询的key和value
	private String key;
	private String value;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	// 模型驱动使用对象
	private User user = new User();

	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return user;
	}

	// 注入用户服务层
	private UserService userService;

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	// 查找所有用户信息
	public String findall() {
		// System.out.println(page);
		PageBean<User> pageBean = userService.findByPage(page);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "list";
	}

	// 删除顾客信息
	public String delete() {
		// System.out.println(user.getUid());
		userService.delete(user.getUid());
		if(key!=null&&value!=null)
		{
			return "KSuccess";
		}
		return "Success";
	}

	// 根据id查询用户信息，并且跳转到编辑页面
	public String findbyId() {
		user = userService.findbyId(user.getUid());
		// 将user放入值栈
		ActionContext.getContext().getValueStack().set("user", user);
		if(key!=null&&value!=null)
		{
			ActionContext.getContext().getValueStack().set("key", key);
			ActionContext.getContext().getValueStack().set("value", value);
		}
		ActionContext.getContext().getValueStack().set("page", page);
		return "edit";
	}

	// 修改用户信息
	public String update() {
		userService.update(user);
		//HttpServletRequest request=ServletActionContext.getRequest();
		//System.out.println(request.getParameter("key")+request.getParameter("value"));
		//System.out.println("哈哈哈哈哈哈哈哈哈"+key+"哈哈哈哈哈哈哈哈哈"+value);
		if(key.equals("")&&value.equals(""))
		{
			//System.out.println("你好啊");
			return "Success";
		}
		// System.out.println("我在修改信息里面"+page);
		//System.out.println(key+value);
		return "KSuccess"; 
	}
	//关键字查询（分页）
	public String KeySearch() {
		//System.out.println(key+value);
		PageBean<User> pageBean=userService.KfindByPage(page, key, value);
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//将key与value放入值栈方便前台获取，执行上、下页
		ActionContext.getContext().getValueStack().set("key", key);
		ActionContext.getContext().getValueStack().set("value", value);
		return "keylist";
	}
}
