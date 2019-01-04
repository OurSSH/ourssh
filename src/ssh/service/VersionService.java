package ssh.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import ssh.utils.PageBean;
import ssh.vo.Version;
@Transactional
public interface VersionService {
	/** 查询热门型号 */
	public List<Version> findHot();

	/** 根据型号id查询该型号的信息 */
	public Version findByVid(int vid);

	/** 根据品牌id查询该品牌所有型号对象 */
	public List<Version> findByBid(int bid);

	/** 根据品牌id分页查询型号 */
	public PageBean<Version> findByPageBid(Integer bid, int page);

	// 带分页的查询方式
	public PageBean<Version> findByPage(Integer page);

	// 修改型号信息
	public void update(Version version);

	// 保存型号信息
	public void save(Version version);

	// 查询所有手机型号
	public List<Version> findAll();
}
