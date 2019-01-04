package ssh.service;

import java.util.List;

import ssh.dao.ProductDao;
import ssh.utils.PageBean;
import ssh.vo.Product;

/** 产品 业务层实现类 */
public class ProductServiceImpl implements ProductService {
	// 注入ProductDao
	private ProductDao productDao;

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	/** 根据产品pid查询该产品信息 返回产品对象 */
	public Product findByPid(int pid) {
		return productDao.findByPid(pid);
	}

	// 分页查询
	@Override
	public PageBean<Product> findByPage(Integer page) {
		// TODO Auto-generated method stub
		PageBean<Product> pageBean = new PageBean<Product>();
		// 设置参数:
		pageBean.setPage(page);
		// 设置每页显示记录数:
		int limit = 8;
		pageBean.setLimit(limit);
		// 设置总记录数:
		int totalCount = productDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 设置总页数:
		int totalPage = 0;
		if (totalCount % limit == 0) {
			totalPage = totalCount / limit;
		} else {
			totalPage = totalCount / limit + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 设置页面显示数据的集合:
		int begin = (page - 1) * limit;
		List<Product> list = productDao.findBypage(begin, limit);
		pageBean.setList(list);
		return pageBean;
	}

	// 保存商品信息
	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		productDao.save(product);
	}

	// 修改商品信息
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		productDao.update(product);
	}

	// 根据商品id删除商品
	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub
		productDao.delete(pid);
	}
}
