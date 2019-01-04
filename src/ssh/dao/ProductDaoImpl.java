package ssh.dao;

import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ssh.utils.PageHibernateCallback;
import ssh.vo.Product;

public class ProductDaoImpl  extends HibernateDaoSupport implements ProductDao {

	@Override
	/**根据产品pid查询该产品的信息 返回product对象*/
	public Product findByPid(int pid) {
		return this.getHibernateTemplate().get(Product.class, pid);
	}
	@Override
	//查询商品个数
	public int findCount() {
		// TODO Auto-generated method stub
		String hql="select count(*) from Product";
		
		int total=((Number)this.getHibernateTemplate().find(hql).listIterator().next()).intValue();
		if (total > 0) {
			//System.out.println("商品个数"+total);
			return total;
		}
		System.out.println("目前没有商品信息！");
			return 0;
	}
	//分页查询方法的实现
	@Override
	public List<Product> findBypage(int begin, int limit) {
		// TODO Auto-generated method stub
		String hql="from Product order by pid desc";
		List<Product> list = this.getHibernateTemplate().execute(
				new PageHibernateCallback<Product>(hql, null, begin,
						limit));
		//System.out.println(list.get(0).getPdesc());
		return list;
	}
	
	//保存商品信息
	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(product);
	}
	//修改商品信息的实现
	@Override
	public void update(Product product) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(product);
	}
	//删除商品信息的实现
	@Override
	public void delete(int pid) {
		// TODO Auto-generated method stub
		//根据id获取对象
		Product product=(Product) this.getHibernateTemplate().get(Product.class, pid);
		//删除对象
		this.getHibernateTemplate().delete(product);
	}
	
}
