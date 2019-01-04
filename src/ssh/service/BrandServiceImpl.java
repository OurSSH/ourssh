package ssh.service;

import java.util.List;

import ssh.dao.BrandDao;
import ssh.vo.Brand;

public class BrandServiceImpl implements BrandService {
	//注入BrandDao
	private BrandDao brandDao;
	public void setBrandDao(BrandDao brandDao) {
		this.brandDao = brandDao;
	}
	@Override
	public List<Brand> findAll() {
		return brandDao.findAll();
	}
	//按id查找
		@Override
		public Brand findbyId(Integer bid) {
			// TODO Auto-generated method stub
			return brandDao.findbyId(bid);
		}
		//修改
		@Override
		public List<Brand> updata(Brand brand) {
			// TODO Auto-generated method stub
			return brandDao.updata(brand);
		}
		//增加
		@Override
		public List<Brand> save(Brand brand) {
			// TODO Auto-generated method stub	
			return brandDao.save(brand);
		}
		//删除
		@Override
		public List<Brand> delete(Integer bid) {
			// TODO Auto-generated method stub
			return brandDao.delete(bid);
		}
		//限制查找
		public List<Brand> LfindAll(){
			return brandDao.LfindAll();
		}
	
}
