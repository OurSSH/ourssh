package ssh.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import ssh.service.ProductService;
import ssh.service.VersionService;
import ssh.utils.PageBean;
import ssh.vo.Product;
import ssh.vo.Version;

public class Is_ad_AdminProductAction extends ActionSupport implements ModelDriven<Product> {
	private static final long serialVersionUID = 1L;
	// 商品模型驱动使用对象
	private Product product = new Product();
	private Integer page;
	private Version version = new Version();

	public Version getVersion() {
		return version;
	}

	@Override
	public Product getModel() {
		// TODO Auto-generated method stub
		return product;
	}

	// 注入商品service
	private ProductService productService;

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	// 注入型号service
	private VersionService versionService;

	public void setVersionService(VersionService versionService) {
		this.versionService = versionService;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	// 查找所有商品信息（分页）
	public String findallProduct() {
		// 分页查询
		PageBean<Product> pageBean = productService.findByPage(page);
		// 存入值栈
		ActionContext.getContext().getValueStack().set("pageBean", pageBean);
		return "list";
	}

	// 跳转到添加页面
	public String addPage() {
		// 查询所有手机型号的信息
		List<Version> list = versionService.findAll();
		// 存入值栈
		// System.out.println(page);
		ActionContext.getContext().getValueStack().set("page", page);
		ActionContext.getContext().getValueStack().set("list", list);
		// System.out.println(list.get(0).getVid()+list.get(0).getVname());
		return "add";
	}

	// 保存商品信息
	public String save() {
		
		// System.out.println("Save页面中的"+page);
//		product.setPname(product.getVersion().getBrand().getBname()+product.getVersion().getVname()+product.getPdesc());
		productService.save(product);
		return "Success";
	}

	// 跳转到编辑页面
	public String edit() {
		// 查询所有手机型号的信息
		List<Version> list = versionService.findAll();
		// 根据商品id查询商品信息
		//System.out.println("我在测试ID中" + product.getPid());
		product = productService.findByPid(product.getPid());
		// System.out.println("哈哈哈哈哈哈哈哈"+page);
		// 存入值栈
		ActionContext.getContext().getValueStack().set("list", list);
		ActionContext.getContext().getValueStack().set("page", page);
		ActionContext.getContext().getValueStack().set("product", product);
		return "edit";
	}
	//修改商品信息
	public String update() {
		//System.out.println(product.getPid()+product.getPdesc()+product.getPprice()+product.getPstock()+product.getVersion().getVid()+product.getVersion().getVname()+page);
		productService.update(product);
		return "Success";
	}
	//删除商品信息
	public String delete() {
		productService.delete(product.getPid());
		return "Success";
	}

}
