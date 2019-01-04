package ssh.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

//import java.util.ArrayList;
//import java.util.List;
//
//import javax.servlet.http.HttpServletRequest;
//
//import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.BrandService;
import ssh.service.VersionService;
import ssh.utils.PageBean;
import ssh.vo.Brand;
import ssh.vo.Version;

public class Is_ad_AdminVersionAction extends ActionSupport implements ModelDriven<Version> {
	private static final long serialVersionUID = 1L;
	private Integer page;
	// 文件上传需要的三个属性:
	private File upload;
	private String uploadFileName;
	private String uploadContentType;

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	// 模型驱动使用的对象(Version)
	private Version version = new Version();

	@Override
	public Version getModel() {
		// TODO Auto-generated method stub
		return version;
	}

	// 注入型号service(业务层处理)
	private VersionService versionService;

	// 设置service
	public void setVersionService(VersionService versionService) {
		this.versionService = versionService;
	}

	// 模型层(Brand)
	private Brand brand = new Brand();

	public Brand getBrand() {
		return brand;
	}

	// 注入手机品牌service(业务层处理)
	private BrandService brandService;

	// 设置service
	public void setBrandService(BrandService brandService) {
		this.brandService = brandService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	// 查找所有商品信息（分页）
	public String findallVersion() {
		// 调用Service进行查询.
		PageBean<Version> pageBean = versionService.findByPage(page);
		// List<Brand> list=new ArrayList<Brand>();
		// for(int i=0;i<pageBean.getList().size();i++) {
		// Brand brand=new Brand();
		// brand=pageBean.getList().get(i).getBrand();
		// System.out.println(brand.getBname());
		// list.add(brand);
		// }
		// HttpServletRequest request=ServletActionContext.getRequest();
		// request.getSession().setAttribute("list",list);
		// 存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "list";
	}

	// 编辑前先查找
	public String edit() {
		// 根据id查询二级分类:
		version = versionService.findByVid(version.getVid());
		// System.out.println(version.getVname() + version.getVstate());
		// 查询所有一级分类:
		List<Brand> bList = brandService.findAll();
		// System.out.println(bList.get(0).getBname());
		// 将集合存入到值栈中.
		// System.out.println("我是页数"+page);
		ActionContext.getContext().getValueStack().set("page", page);
		ActionContext.getContext().getValueStack().set("bList", bList);
		ActionContext.getContext().getValueStack().set("version", version);
		return "edit";
	}

	// 更改信息
	public String update() throws IOException {
		// System.out.println("修改方法中"+version.getVid()+version.getVname()+version.getVdesc()+version.getVimg()+version.getIs_hot()+version.getVstate()+version.getVprice()+version.getBrand().getBname()+version.getBrand().getBid()+version.getBrand().getBstate());
		// 上传:
		if(version.getVstate()==0)
		{
			version.setIs_hot(0);
		}
		if (upload != null) {
			String delPath = ServletActionContext.getServletContext().getRealPath("/" + version.getVimg());
			File file = new File(delPath);
			file.delete();
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/version");
			// 创建文件类型对象:
			StringBuffer sb=new StringBuffer();
			String[] strs=path.split("\\\\");
			for(int i=0;i<strs.length;i++) {
				System.out.println(strs[i]);
				if(strs[i].equals(".metadata")) {
					for(int j=0;j<i;j++) {
						sb.append(strs[j]+"\\");
					}
				}
			}
			sb.append("Tom\\WebContent\\upload");
			File diskFile = new File(sb.toString() + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);

			version.setVimg("version/" + uploadFileName);
		}
		//System.out.println("我在测试啊"+version.getVimg());
		versionService.update(version);
		// System.out.println(page);
		// PageBean<Version> pageBean = versionService.findByPage(page);
		// ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "updateSuccess";
	}

	// 跳转到增加页面
	public String addPage() {
		// 查询所有一级分类:
		List<Brand> bList = brandService.findAll();
		ActionContext.getContext().getValueStack().set("bList", bList);
		// 将第几页传入值栈
		ActionContext.getContext().getValueStack().set("page", page);
		return "addPage";
	}

	// 保存方法
	public String save() throws IOException {
		// System.out.println("我在保存方法"+page);

		// 将图片上传
		// product.setImage(image);
		if (upload != null) {
			// 将商品图片上传到服务器上.
			// 获得上传图片的服务器端路径.
			String path = ServletActionContext.getServletContext().getRealPath("/version");
			// 创建文件类型对象:
			StringBuffer sb=new StringBuffer();
			String[] strs=path.split("\\\\");
			for(int i=0;i<strs.length;i++) {
				System.out.println(strs[i]);
				if(strs[i].equals(".metadata")) {
					for(int j=0;j<i;j++) {
						sb.append(strs[j]+"\\");
					}
				}
			}
			sb.append("SSH\\WebContent\\version");
			System.out.println(sb.toString());
			File diskFile = new File(sb.toString() + "//" + uploadFileName);
			// 文件上传:
			FileUtils.copyFile(upload, diskFile);

			version.setVimg("version/" + uploadFileName);
		}
		versionService.save(version);
		return "saveSuccess";
	}

}
