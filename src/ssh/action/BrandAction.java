package ssh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.VersionService;
import ssh.utils.PageBean;
import ssh.vo.Brand;
import ssh.vo.Version;

public class BrandAction extends ActionSupport implements ModelDriven<Brand> {
	// 模型驱动使用的对象(用于接收数据的模型驱动 从top页面传来了bid)
	private Brand brand = new Brand();
	@Override
	public Brand getModel() {
		return brand;
	}
	
	
	
	private int page;
	public void setPage(int page) {
		this.page = page;
	}

	// 注入型号的Service
	private VersionService versionService;
	public void setVersionService(VersionService versionService) {
		this.versionService = versionService;
	}

	/** 根据品牌id查询该品牌所有型号对象 */
	public String findByBid() {
		//该品牌所有型号对象传到型号页
		List<Version> brandVersionList = versionService.findByBid(brand.getBid());
		//保存到值栈
		ActionContext.getContext().getValueStack().set("brandVersionList", brandVersionList);
		return "findByBid";
	}
	
	/** 根据品牌id 分页查询   该品牌所有型号对象 */
	public String findByPageBid() {
		PageBean<Version> pageBean = versionService.findByPageBid(brand.getBid(),page);  //此次page为1
		//将pagebean存如值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		//System.out.println(pageBean);
		return "findByPageBid";
	}
}
