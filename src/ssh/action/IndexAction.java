package ssh.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import ssh.service.BrandService;
import ssh.service.VersionService;
import ssh.vo.Brand;
import ssh.vo.Version;

/**
 * Action：首页访问
 * */
public class IndexAction extends ActionSupport{
	//注入品牌分类的Service
	private BrandService brandService;
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}
	
	//注入型号相关的Service  首页访问时要展示热门型号
	private VersionService versionService;
	public void setVersionService(VersionService versionService) {
		this.versionService = versionService;
	}

	/**
	 * 执行首页访问的方法
	 * */
	public String execute() {
		//查询所有品牌传到导航栏
		//List<Brand> brandList = brandService.findAll();
		List<Brand> brandList = brandService.LfindAll();
		//因为所有页面都有品牌列表分类  存入session  不用ServletContext
		ActionContext.getContext().getSession().put("brandList", brandList);	
		//查询热门型号
		List<Version> hotVersionList = new ArrayList<>();
		List<Version> List  = versionService.findHot();
		for(int i=0;i<List.size();i++) {
			if(List.get(i).getBrand().getBstate()!=0) {
				hotVersionList.add(List.get(i));
			}
		}
		//保存到值栈
		ActionContext.getContext().getValueStack().set("hotVersionList", hotVersionList);
		return "index";
	}
}
