package ssh.dao;

import java.util.List;

import ssh.vo.Brand;

/**
 * 品牌分类 持久层
 */
public interface BrandDao {

	List<Brand> findAll();

	// 根据id查询指定品牌信息
	public Brand findbyId(Integer bid);

	// 修改指定id的品牌信息
	public List<Brand> updata(Brand brand);

	// 增加手机品牌
	public List<Brand> save(Brand brand);

	// 删除手机品牌
	public List<Brand> delete(Integer bid);

	// 前台限制查询
	public List<Brand> LfindAll();

}
