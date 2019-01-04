package ssh.service;

import java.util.List;

import ssh.dao.VersionDao;
import ssh.utils.PageBean;
import ssh.vo.Version;

/**
 * 型号 业务层
 * */
public class VersionServiceImpl implements VersionService {
	//注入VersionDao
	private VersionDao versionDao;
	public void setVersionDao(VersionDao versionDao) {
		this.versionDao = versionDao;
	}
	
	@Override
	public List<Version> findHot() {
		return versionDao.findHot();
	}

	@Override
	/**根据型号id查询该型号的信息*/
	public Version findByVid(int vid) {
		return versionDao.findByVid(vid);
	}

	@Override
	/** 根据品牌id查询该品牌所有型号对象 */
	public List<Version> findByBid(int bid) {
		return versionDao.findByBid(bid);
	}

	@Override
	/** 根据品牌id分页查询型号 */
	public PageBean<Version> findByPageBid(Integer bid, int page) {
		//PageBean [page=1, totalCount=8, totalPage=0, limit=5]
		
		PageBean<Version> pageBean = new PageBean<>();
		pageBean.setPage(page);  //设置当前页
		int limit = 10;
		pageBean.setLimit(limit);  //设置每页记录数
		//设置记录总数
		int totalCount = 0;
		totalCount =  versionDao.findVersionCountByBid(bid);
		pageBean.setTotalCount(totalCount);
		//设置总页数
		int totalPage = 0;
		if(totalCount % limit == 0){
			totalPage = totalCount / limit;
		}else{
			totalPage =( totalCount / limit )+ 1;
		}
		//totalPage = (int) Math.ceil(totalCount/limit);  //向上取整
		pageBean.setTotalPage(totalPage);
		//每页显示的数据集合
		int begin = (page-1)*limit;
		List<Version> list = versionDao.findByPageBid(bid,begin,limit);
		pageBean.setList(list);
		return pageBean;
	}
	// 带分页的查询功能

		@Override
		public PageBean<Version> findByPage(Integer page) {
			// TODO Auto-generated method stub
			PageBean<Version> pageBean = new PageBean<Version>();
			System.out.println(page);
			// 设置参数:
			pageBean.setPage(page);
			// 设置每页显示记录数:
			int limit = 8;
			pageBean.setLimit(limit);
			// 设置总记录数:
			int totalCount = versionDao.findCount();
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
			List<Version> list = versionDao.findByPage(begin, limit);
			pageBean.setList(list);
			return pageBean;
		}

		// 修改信号信息业务层
		@Override
		public void update(Version version) {
			// TODO Auto-generated method stub
			versionDao.update(version);
		}

		// 保存型号信息业务层
		@Override
		public void save(Version version) {
			// TODO Auto-generated method stub
			versionDao.save(version);
		}

		// 查询所有型号的业务层
		@Override
		public List<Version> findAll() {
			// TODO Auto-generated method stub
			return versionDao.findAll();
		}
}
