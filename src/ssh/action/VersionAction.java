package ssh.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.VersionService;
import ssh.vo.Version;

/**
 * 型号Version   Action对象
 * */
public class VersionAction extends ActionSupport  implements ModelDriven<Version> {
	//模型驱动使用的对象(用于接收数据的模型驱动  从index页面传来了vid)
	private Version version = new Version();
	@Override
	public Version getModel() {
		return version;
	}
	
	//注入型号的Service
	private VersionService versionService;
	public void setVersionService(VersionService versionService) {
		this.versionService = versionService;
	}

        
	/**根据型号id 查询方法*/
	public String findByVid() {
		System.out.println("根据型号id查询信息  执行");
		//调用VersionService的方法进行查询
		version= versionService.findByVid(version.getVid());
		//跳转到型号详细页
		return "findByVid";
	}
	
	
//	public String execute() {
//		System.out.println("根据型号id查询信息  执行");
//		//调用VersionService的方法进行查询
//		version= versionService.findByVid(version.getVid());
//		//跳转到型号详细页
//		return SUCCESS;
//	}
	
	
}
