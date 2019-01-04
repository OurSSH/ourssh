package ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh.vo.Brand;

/**
 * 品牌分类 业务层
 * */
@Transactional
public interface BrandService {
	/**业务层 查询所有品牌*/
	public List<Brand> findAll();
	/**根据id查品牌*/
	public Brand findbyId(Integer bid);
	//修改品牌信息
	public List<Brand> updata(Brand brand);
	//保存品牌信息
	public List<Brand> save(Brand brand);
	//删除品牌信息
	public List<Brand> delete(Integer bid);
	//限制查找
	public List<Brand> LfindAll();
}
