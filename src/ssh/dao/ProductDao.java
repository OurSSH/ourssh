package ssh.dao;

import java.util.List;

import ssh.vo.Product;

public interface ProductDao {

	/** 根据产品pid查询该产品信息 返回产品对象 */
	public Product findByPid(int pid);

	// 查询商品的个数
	public int findCount();

	// 分页查询
	public List<Product> findBypage(int begin, int limit);

	// 保存商品信息
	public void save(Product product);

	// 修改商品信息
	public void update(Product product);

	// 删除商品信息
	public void delete(int pid);
}
