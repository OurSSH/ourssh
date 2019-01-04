package ssh.dao;

import java.util.List;

import ssh.vo.Version;

/**
 * 型号 持久层
 */
public interface VersionDao {

	public List<Version> findHot();

	/** 根据型号id查询该型号的信息 */
	public Version findByVid(int vid);

	/** 根据品牌id查询该品牌所有型号对象 */
	public List<Version> findByBid(int bid);

	/** 根据品牌id查询该品牌所有型号个数 */
	public int findVersionCountByBid(Integer bid);

	/** 根据品牌id 有条件地查询该品牌的型号 */
	public List<Version> findByPageBid(Integer bid, int begin, int limit);

	// 分页查询
	// public List<Version> findByPage(int begin, int limit);
	// 查询型号个数
	public int findCount();

	// 分页查询
	public List<Version> findByPage(int begin, int limit);

	// 修改型号信息
	public void update(Version version);

	// 保存型号信息
	public void save(Version version);

	// 查询所有型号的手机
	public List<Version> findAll();

}
