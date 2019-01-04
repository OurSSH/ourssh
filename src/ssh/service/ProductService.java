package ssh.service;

import org.springframework.transaction.annotation.Transactional;

import ssh.utils.PageBean;
import ssh.vo.Product;

/** 产品 业务层 */
@Transactional
public interface ProductService {
	/** 根据产品pid查询该产品信息 返回产品对象 */
	public Product findByPid(int pid);

	// 带分页的查询方式
	public PageBean<Product> findByPage(Integer page);

	// 保存商品信息
	public void save(Product product);

	// 修改商品
	public void update(Product product);

	// 删除商品信息
	public void delete(int pid);
}
