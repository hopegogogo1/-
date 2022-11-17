package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


/**
 *
 * @author zhangsheng
 * 2021-10-29 17:54:20
 * <dl>
 * 		<dt>DomainDaoInterface</dt>
 *		<dd></dd>
 * </dl>
 */
public interface DomainDaoInterface {



	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>插入对象信息</dd>
	 * </dl>
	 * @param obj 要插入的对象
	 * @return 操作成功返回1，否则返回0。
	 */
	public int insert(Object obj);



	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>删除对象信息.</dd>
	 * </dl>
	 * @param obj 要删除的对象
	 * @return 操作成功返回1，否则返回0。
	 */
	public int delete(Object obj);



	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>更新对象信息。</dd>
	 * </dl>
	 * @param obj 要更新的对象
	 * @return 操作成功返回1，否则返回0。
	 */
	public int update(Object obj);

	/**
	 * 通过对象ID查找对象信息.
	 *
	 * @param cls
	 *            对象所属的类
	 * @param objId
	 *            对象ID
	 *
	 * @return the student
	 */


	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>通过ID查找对象。</dd>
	 * </dl>
	 * @param objId 对象ID
	 * @return 查到的对象。若找不到则返回null。
	 */
	public Object findById(long objId);






	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>查找所有对象。</dd>
	 * </dl>
	 * @return 对象列表
	 */
	public List<? extends Object> findAll();


	/**
	 *
	 * <dl>
	 * 		<dt>作用：</dt>
	 *		<dd>将结果集转换为对象列表</dd>
	 * </dl>
	 * @param rs 要转换的结果集
	 * @return 转换得到的对象列表
	 */
	public List<? extends Object> toModel(ResultSet rs);

}
