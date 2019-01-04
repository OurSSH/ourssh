package ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ssh.vo.Brand;
import ssh.vo.Version;

/**
 * 品牌分类 持久层实现类 需要在spring配置文件中 给该bean配置 sessionFactory 才能使用Hibernate模版
 */
public class BrandDaoImpl extends HibernateDaoSupport implements BrandDao {

	@Override
	public List<Brand> findAll() {
		String hql = "from Brand";
		List<Brand> list = (List<Brand>) this.getHibernateTemplate().find(hql);
		if (list != null && list.size() > 0) {
			return list;
		}
		System.out.println("**********brand表中没有数据*******");
		return null;
	}

	// 根据id查
	@Override
	public Brand findbyId(Integer bid) {
		// TODO Auto-generated method stub
		// String hql="from Brand where bid='"+bid+"'";
		Brand brand = (Brand) this.getHibernateTemplate().get(Brand.class, bid);
		if (brand.getBname() != null) {
			// System.out.println(brand.getBname());
			return brand;
		}
		System.out.println("你所查的id没有数据！");
		return null;
	}

	// 修改品牌信息
	@Override
	public List<Brand> updata(Brand brand) {
		// TODO Auto-generated method stub
		// this.getHibernateTemplate().update
		// System.out.println(brand.getBname()+"哈哈哈");
		this.getHibernateTemplate().update(brand);
		List<Brand> list = findAll();
		return list;
	}

	// 保存手机品牌
	@Override
	public List<Brand> save(Brand brand) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(brand);
		List<Brand> list = findAll();
		return list;
	}

	// 删除手机品牌
	@Override
	public List<Brand> delete(Integer bid) {
		// TODO Auto-generated method stub
		// 根据id获取对象
		Brand brand = (Brand) this.getHibernateTemplate().get(Brand.class, bid);
		// 删除
		this.getHibernateTemplate().delete(brand);
		List<Brand> list = findAll();
		return list;
	}

	// 限制查询
	@Override
	public List<Brand> LfindAll() {
		// TODO Auto-generated method stub
		String hql = "from Brand";
		// 下架商品无法显示出来
		DetachedCriteria criteria = DetachedCriteria.forClass(Brand.class);
		criteria.add(Restrictions.eq("bstate", 1));
		List<Brand> list = (List<Brand>) this.getHibernateTemplate().findByCriteria(criteria);
		if (list != null && list.size() > 0) {
			return list;
		}
		System.out.println("**********brand表中没有数据*******");
		return null;
	}

}
