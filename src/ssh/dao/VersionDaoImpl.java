package ssh.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import ssh.utils.PageHibernateCallback;
import ssh.vo.Version;

/**
 * 型号  持久层实现类
 * */
public class VersionDaoImpl extends HibernateDaoSupport implements VersionDao {

	private static final String Object = null;

	@Override
	public List<Version> findHot() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Version.class);
		//查询热门的商品，is_hot = 1
		
//		criteria.add(Restrictions.eq("is_hot", 1));
		criteria.add(Restrictions.eq("is_hot", 1));
		//倒序查询最新添加的热门型号
		//criteria.addOrder(Order.desc("pdate"));
		//执行分页查询
		List<Version> list = (List<Version>)this.getHibernateTemplate().findByCriteria(criteria, 0, 10);
		return list;
	}

	@Override
	/**根据型号id查询该型号的信息*/
	public Version findByVid(int vid) {
		return this.getHibernateTemplate().get(Version.class, vid);
	}

	@Override
	/**根据品牌id bid 查询该品牌的所有型号对象*/
	public List<Version> findByBid(int bid) {
		String hql = "from Version where bid = ?0";
		List<Version> list = (List<Version>) this.getHibernateTemplate().find(hql, bid);
		if(list!=null && list.size()>0) {
			System.out.print("**********查找到数据库中的该品牌所有型号   数量为");
			System.out.println(list.size());
			return list;
		}
		System.out.println("**********查找不到数据库中的该用户名的用户*******");
		return null;
	}

	@Override
	/** 根据品牌id查询该品牌所有型号个数 */
	public int findVersionCountByBid(Integer bid) {
		String hql = "select count(*) from Version where bid = ?0";
		List<Long> list = (List<Long>) this.getHibernateTemplate().find(hql,bid);
		if(list!=null && list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	/** 根据品牌id  有条件地查询该品牌的型号 */
	public List<Version> findByPageBid(Integer bid, int begin, int limit) {
		String hql = "from Version where bid = ?0";
	    Object[] objects = {bid};
	    List<Version> list = this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, objects, begin, limit));
	    if(list!=null && list.size()>0) {
			return list;
		}
		return null;
	}
	
	/** 根据品牌id查询该品牌所有产品个数 */
	//String hql = "select from Product p where p.version.brand = ?0";
	
	/** 根据品牌id 分页查询该品牌所有产品 */
	//hql复杂语句查询三表关联  select p from brand b, version v,product p where bid=v.brand.bid and v.id=p.version.vid and bid=?0;
	//hql简单语句 select p from Product p join p.version v join v.brand b where b.bid=?0;
//	public List<Product> findProductByBid(Integer bid, int begin, int limit){
//	    String hql = "select p from Product p join p.version v join v.brand b where b.bid=?0";
//	    List<Product> list = this.getHibernateTemplate().execute(new PageHibernateCallback<>(hql, Object[] {cid}, begin, limit));
//	    if(list!=null && list.size()>0) {
//			return list;
//		}
//		return null;
//	}
	//Dao中的统计二级分类个数的方法
		public int findCount() {
			String hql="select count(*) from Version";
			int total=((Number)this.getHibernateTemplate().find(hql).listIterator().next()).intValue();
			if (total > 0) {
				return total;
			}
			System.out.println("目前没有手机型号！");
				return 0;
		}

		@Override
		//分页查询实现
		public List<Version> findByPage(int begin, int limit) {
			// TODO Auto-generated method stub
			String hql = "from Version order by vid desc";
			List<Version> list = this.getHibernateTemplate().execute(
					new PageHibernateCallback<Version>(hql, null, begin,
							limit));
			return list;
		}
		//修改型号信息方法的实现
		@Override
		public void update(Version version) {
			// TODO Auto-generated method stub
			this.getHibernateTemplate().update(version);
		}
		//保存手机型号方法的实现
		@Override
		public void save(Version version) {
			// TODO Auto-generated method stub
			this.getHibernateTemplate().save(version);
		}

		@Override
		public List<Version> findAll() {
			// TODO Auto-generated method stub
			String hql="from Version order by vid desc";
			List<Version> list=(List<Version>)this.getHibernateTemplate().find(hql);
			if (list != null && list.size() > 0) {
				return list;
			}
			System.out.println("**********Version表中没有数据*******");
			return null;
		}
		
}
