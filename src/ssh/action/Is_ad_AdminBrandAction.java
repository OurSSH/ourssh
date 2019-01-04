package ssh.action;

import java.util.Iterator;
import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.BrandService;
import ssh.service.VersionService;
import ssh.vo.Brand;
import ssh.vo.Version;

public class Is_ad_AdminBrandAction extends ActionSupport implements ModelDriven<Brand> {
	private static final long serialVersionUID = 1L;
	// 模型驱动使用的对象
	private Brand brand = new Brand();

	@Override
	public Brand getModel() {
		// TODO Auto-generated method stub
		return brand;
	}

	// 注入品牌service
	private BrandService brandService;

	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	// 注入型号service
	private VersionService versionService;

	public void setVersionService(VersionService versionService) {
		this.versionService = versionService;
	}

	// 查找所有的手机品牌
	public String findallBrand() {
		// 查询所有的手机品牌用于后台的一级分类显示
		List<Brand> aList = brandService.findAll();
		// 保存到值栈
		ActionContext.getContext().getValueStack().set("aList", aList);
		return "list";
	}

	// 根据id查询手机品牌
	public String findbyId() {
		// 根据传过来的bid查询品牌信息
		Brand fbrand = brandService.findbyId(brand.getBid());
		ActionContext.getContext().getValueStack().set("fbrand", fbrand);
		return "edit";
	}

	// 修改手机品牌
	public String update() {
//		List<Brand> aList=brandService.updata(brand.getBid(), brand.getBname(),brand.getBstate());
		//versionService.findByBid(brand.getBid());
		
//		Brand prebrand = brandService.findbyId(brand.getBid());
//	
//		if(brand.getBstate()==0) {
////			for(Version v:prebrand.getVersions()) {
////				v.setVstate(0);
////			}
////			
//			Iterator<Version> it = prebrand.getVersions().iterator();  
//			while (it.hasNext()) {  
//			  it.next().setVstate(0);;   
//			}  
//		}
//		prebrand.setBstate(brand.getBstate());
//		
//		List<Brand> aList=brandService.updata(prebrand);
		List<Brand> aList=brandService.updata(brand);
		ActionContext.getContext().getValueStack().set("aList", aList);
		//System.out.println(brand.getBname()+brand.getBid());
		return "list";
	}

	// 保存手机品牌
	public String save() {
		List<Brand> aList = brandService.save(brand);
		ActionContext.getContext().getValueStack().set("aList", aList);
		return "list";
	}

	// 删除手机品牌
	public String delete() {
		List<Brand> aList = brandService.delete(brand.getBid());
		ActionContext.getContext().getValueStack().set("aList", aList);
		return "list";
	}
}
